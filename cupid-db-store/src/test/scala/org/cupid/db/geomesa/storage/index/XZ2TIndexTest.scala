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
import org.junit.runner.RunWith
import org.locationtech.geomesa.features.ScalaSimpleFeature
import org.locationtech.geomesa.utils.collection.SelfClosingIterator
import org.locationtech.geomesa.utils.geotools.{FeatureUtils, SimpleFeatureTypes}
import org.locationtech.geomesa.utils.io.WithClose
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class XZ2TIndexTest extends Specification with LazyLogging {

  "XZ2TIndex" should {
    "index and query yearly epochs correctly" in {
      foreach(Seq("xz2t:geom:dtg")) { indices =>
        val spec =
          "name:String,track:String,dtg:Date,*geom:LineString:srid=4326;" +
            s"geomesa.z3.interval=month,geomesa.indices.enabled=$indices"

        val sft = SimpleFeatureTypes.createType("test", spec)

        val ds = new TestGeoMesaDataStore(false) // requires strict bbox...

        // note: 2020 was a leap year
        val features =
          (0 until 10).map { i =>
            ScalaSimpleFeature.create(
              sft,
              s"$i",
              s"name$i",
              "track1",
              s"2020-12-07T0$i:00:00.000Z",
              s"LINESTRING(4$i 60, 4$i 61)"
            )
          } ++ (10 until 20).map { i =>
            ScalaSimpleFeature.create(
              sft,
              s"$i",
              s"name$i",
              "track2",
              s"2020-12-${i}T$i:00:00.000Z",
              s"LINESTRING(4${i - 10} 60, 4${i - 10} 61)"
            )
          } ++ (20 until 30).map { i =>
            ScalaSimpleFeature.create(
              sft,
              s"$i",
              s"name$i",
              "track3",
              s"2020-12-${i}T${i - 10}:00:00.000Z",
              s"LINESTRING(6${i - 20} 60, 6${i - 20} 61)"
            )
          } ++ (30 until 32).map { i =>
            ScalaSimpleFeature.create(
              sft,
              s"$i",
              s"name$i",
              "track4",
              s"2020-12-${i}T${i - 10}:00:00.000Z",
              s"LINESTRING(${i - 20} 60, ${i - 20} 61)"
            )
          }

        ds.createSchema(sft)
        WithClose(ds.getFeatureWriterAppend(sft.getTypeName, Transaction.AUTO_COMMIT)) { writer =>
          features.foreach(FeatureUtils.write(writer, _, useProvidedFid = true))
        }

        val filter = ECQL.toFilter(
          "bbox(geom,0,55,70,65) AND dtg during 2020-12-01T00:00:00.000Z/2020-12-31T23:59:59.999Z"
        )

        val filterReault = SelfClosingIterator(
          ds.getFeatureReader(new Query("test", filter), Transaction.AUTO_COMMIT)
        ).toList
        filterReault must containTheSameElementsAs(features)

        val lastDayFilter = ECQL.toFilter(
          "bbox(geom,9,59,12,61) AND dtg during 2020-12-31T00:00:00.000Z/2020-12-31T23:59:59.999Z"
        )

        val lastDayResults =
          SelfClosingIterator(
            ds.getFeatureReader(new Query("test", lastDayFilter), Transaction.AUTO_COMMIT)
          ).toList

        lastDayResults mustEqual Seq(features.last)
      }
    }
  }

}
