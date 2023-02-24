/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.cupid.db.geomesa.storage.curve

import org.locationtech.sfcurve.zorder.{ZN, ZRange}

class Z2T(val z: Long) extends AnyVal {
  import Z2T._

  def <(other: Z2T) = z < other.z
  def >(other: Z2T) = z > other.z

  def <=(other: Z2T) = z <= other.z
  def >=(other: Z2T) = z >= other.z

  def +(offset: Long) = new Z2T(z + offset)
  def -(offset: Long) = new Z2T(z - offset)

  def ==(other: Z2T) = other.z == z

  def decode: (Int, Int) = (combine(z), combine(z >> 1))

  def dim(i: Int) = Z2T.combine(z >> i)

  def d0 = dim(0)
  def d1 = dim(1)

  def mid(p: Z2T): Z2T = {
    val (x, y) = decode
    val (px, py) = p.decode
    Z2T((x + px) >>> 1, (y + py) >>> 1) // overflow safe mean
  }

  def bitsToString =
    f"(${z.toBinaryString}%16s)(${dim(0).toBinaryString}%8s,${dim(1).toBinaryString}%8s)"
  override def toString = f"$z $decode"
}

object Z2T extends ZN {

  override val Dimensions = 2
  override val BitsPerDimension = 31
  override val TotalBits = 62
  override val MaxMask = 0x7FFFFFFFL // ignore the sign bit, using it breaks < relationship

  def apply(zvalue: Long) = new Z2T(zvalue)

  // Bits of x and y will be encoded as ....y1x1y0x0
  def apply(x: Int, y: Int): Z2T = new Z2T(split(x) | split(y) << 1)

  def unapply(z: Z2T): Option[(Int, Int)] = Some(z.decode)

  /** insert 0 between every bit in value. Only first 31 bits can be considered. */
  override def split(value: Long): Long = {
    var x: Long = value & MaxMask
    x = (x ^ (x << 32)) & 0x00000000FFFFFFFFL
    x = (x ^ (x << 16)) & 0x0000FFFF0000FFFFL
    x = (x ^ (x << 8)) & 0x00FF00FF00FF00FFL // 11111111000000001111111100000000..
    x = (x ^ (x << 4)) & 0x0F0F0F0F0F0F0F0FL // 1111000011110000
    x = (x ^ (x << 2)) & 0x3333333333333333L // 11001100..
    x = (x ^ (x << 1)) & 0x5555555555555555L // 1010...
    x
  }

  /** combine every other bit to form a value. Maximum value is 31 bits. */
  override def combine(z: Long): Int = {
    var x = z & 0x5555555555555555L
    x = (x ^ (x >> 1)) & 0x3333333333333333L
    x = (x ^ (x >> 2)) & 0x0F0F0F0F0F0F0F0FL
    x = (x ^ (x >> 4)) & 0x00FF00FF00FF00FFL
    x = (x ^ (x >> 8)) & 0x0000FFFF0000FFFFL
    x = (x ^ (x >> 16)) & 0x00000000FFFFFFFFL
    x.toInt
  }

  override def contains(range: ZRange, value: Long): Boolean = {
    val (x, y) = Z2T(value).decode
    x >= Z2T(range.min).d0 && x <= Z2T(range.max).d0 && y >= Z2T(range.min).d1 && y <= Z2T(
      range.max
    ).d1
  }

  override def overlaps(range: ZRange, value: ZRange): Boolean = {
    def overlaps(a1: Int, a2: Int, b1: Int, b2: Int) = math.max(a1, b1) <= math.min(a2, b2)
    overlaps(Z2T(range.min).d0, Z2T(range.max).d0, Z2T(value.min).d0, Z2T(value.max).d0) &&
    overlaps(Z2T(range.min).d1, Z2T(range.max).d1, Z2T(value.min).d1, Z2T(value.max).d1)
  }

}
