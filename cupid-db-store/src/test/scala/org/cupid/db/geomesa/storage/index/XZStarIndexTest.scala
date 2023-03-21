/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cupid.db.geomesa.storage.index

import com.typesafe.scalalogging.LazyLogging
import org.cupid.db.geomesa.storage.TestGeoMesaDataStore
import org.geotools.data.{Query, Transaction}
import org.geotools.filter.text.ecql.ECQL
import org.locationtech.geomesa.features.ScalaSimpleFeature
import org.locationtech.geomesa.utils.collection.SelfClosingIterator
import org.locationtech.geomesa.utils.geotools.{FeatureUtils, SimpleFeatureTypes}
import org.locationtech.geomesa.utils.io.WithClose
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class XZStarIndexTest extends Specification with LazyLogging {

  "XZStarIndex" should {
    "index and query correctly" in {
      foreach(Seq("xzstar:geom")) { indices =>
        val spec =
          "name:String,track:String,dtg:Date,*geom:MultiPoint:srid=4326;" +
            s"geomesa.indices.enabled=$indices"

        val sft = SimpleFeatureTypes.createType("test", spec)

        val ds = new TestGeoMesaDataStore(false) // requires strict bbox...

        val features =
          (0 until 9).map { i =>
            ScalaSimpleFeature.create(
              sft,
              s"$i",
              s"name$i",
              "track1",
              null,
              s"MULTIPOINT(${i}0 60, 4$i 61, 4${i + 1} 62, ${i + 1}5 63)"
            )
          } ++ (10 until 18).map { i =>
            ScalaSimpleFeature.create(
              sft,
              s"$i",
              s"name$i",
              "track2",
              null,
              s"MULTIPOINT(4${i - 10} 60, 4${i - 10} 61, 4${i - 9} 62, 4${i - 8} 63)"
            )
          } ++ (20 until 29).map { i =>
            ScalaSimpleFeature.create(
              sft,
              s"$i",
              s"name$i",
              "track3",
              null,
              s"MULTIPOINT(6${i - 20} 60, 6${i - 20} 61, 6${i - 19} 62)"
            )
          } ++ (30 until 32).map { i =>
            ScalaSimpleFeature.create(
              sft,
              s"$i",
              s"name$i",
              "track4",
              null,
              s"MULTIPOINT(${i - 20} 60, ${i - 20} 61)"
            )
          }

        ds.createSchema(sft)
        WithClose(ds.getFeatureWriterAppend(sft.getTypeName, Transaction.AUTO_COMMIT)) { writer =>
          features.foreach(FeatureUtils.write(writer, _, useProvidedFid = true))
        }

        val filter = ECQL.toFilter("bbox(geom,0,55,70,65)")

        val filterReault = SelfClosingIterator(
          ds.getFeatureReader(new Query("test", filter), Transaction.AUTO_COMMIT)
        ).toList
        filterReault must containTheSameElementsAs(features)

      }
    }
  }

}
