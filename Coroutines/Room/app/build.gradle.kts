plugins {
  id(BuildPlugins.androidApplication)
  kotlin(BuildPlugins.kotlinAndroid)
  kotlin(BuildPlugins.kotlinAndroidExtensions)
  kotlin(BuildPlugins.kotlinKapt)
}

android {
  compileSdkVersion(AndroidSdk.compile)

  defaultConfig {
    applicationId = "com.subhipandey.android.rwandroidtutorial"
    minSdkVersion(AndroidSdk.min)
    targetSdkVersion(AndroidSdk.target)
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

  // Kotlin
  implementation(Libraries.kotlinStdLib)

  // Support Libraries
  implementation(Libraries.appCompat)
  implementation(Libraries.recyclerView)
  implementation(Libraries.constraintLayout)
  implementation(Libraries.picasso)
  implementation(Libraries.gson)

  // TUTORIAL DEPENDENCIES
  implementation(Libraries.roomRuntime)
  kapt(Libraries.roomCompiler)
  implementation(Libraries.roomKtx)

  implementation(Libraries.lifecycleViewModelKtx)
  implementation(Libraries.lifecycleExtensions)
}
