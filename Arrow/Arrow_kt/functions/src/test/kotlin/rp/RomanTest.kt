/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
 
package rp

import org.junit.Assert
import org.junit.Test

/**
 * Test for the Int to Roman conversion
 */
class RomanTest {

  @Test
  fun romanFromNullIsEmpty() {
    val emptyInt: Int? = null
    val roman = emptyInt.toRoman()
    Assert.assertEquals(roman, "")
  }


  @Test
  fun romanFrom1IsI() {
    Assert.assertEquals(1.toRoman(), "I")
  }

  @Test
  fun romanFrom2IsII() {
    Assert.assertEquals(2.toRoman(), "II")
  }

  @Test
  fun romanFrom4IsIV() {
    Assert.assertEquals(4.toRoman(), "IV")
  }

  @Test
  fun romanFrom6IsVI() {
    Assert.assertEquals(6.toRoman(), "VI")
  }

  @Test
  fun romanFrom10IsX() {
    Assert.assertEquals(10.toRoman(), "X")
  }

  @Test
  fun romanFrom1234IsMCCXXXIV() {
    Assert.assertEquals(1234.toRoman(), "MCCXXXIV")
  }

  @Test
  fun romanFrom1500IsMD() {
    Assert.assertEquals(1500.toRoman(), "MD")
  }
}