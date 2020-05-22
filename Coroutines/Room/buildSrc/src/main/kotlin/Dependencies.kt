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

const val kotlinVersion = "1.3.70"

object BuildPlugins {

  object Versions {
    const val buildToolsVersion = "3.6.1"
  }

  const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
  const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  const val androidApplication = "com.android.application"
  const val kotlinAndroid = "android"
  const val kotlinAndroidExtensions = "android.extensions"
  const val kotlinKapt = "kapt"

}

object AndroidSdk {
  const val min = 19
  const val compile = 29
  const val target = compile
}

object Libraries {
  private object Versions {
    const val room = "2.2.5"
    const val lifecycle = "2.2.0"
    const val jetpack = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val gson = "2.8.6"
    const val picasso = "2.71828"
  }

  const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
  const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
  const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

  const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
  const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

  const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
  const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
  const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.jetpack}"
  const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
  const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
  const val gson = "com.google.code.gson:gson:${Versions.gson}"


}

