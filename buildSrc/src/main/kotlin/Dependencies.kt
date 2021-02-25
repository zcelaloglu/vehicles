const val kotlinVersion = "1.4.0"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.4"
        const val safeArgsVersion = "1.0.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val safeArgsPlugin =
        "android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgsVersion}"

}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
    const val buildToolsVersion = "29.0.2"
}

object Libraries {

    private object Versions {

        const val appcompatVersion = "1.1.0"
        const val androidxCoreKtxVersion = "1.1.0"
        const val constraintLayoutVersion = "1.1.3"
        const val supportV4Version = "1.0.0"
        const val materialVersion = "1.2.0"
        const val fragmentKtxVersion = "1.1.0"
        const val koinVersion = "2.2.0-alpha-1"
        const val lifecycleExtensionsVersion = "2.1.0"
        const val recyclerviewAnimationVersion = "3.0.0"
        const val navigation = "2.2.2"
        const val glideVersion = "4.11.0"
        const val retrofitVersion = "2.7.0"
        const val moshiConverterVersion = "2.7.0"
        const val loggingInterceptorVersion = "4.2.1"
        const val coroutinesCoreVersion = "1.3.9"
    }

        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
        const val androidxKtx = "androidx.core:core-ktx:${Versions.androidxCoreKtxVersion}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val supportV4 = "androidx.legacy:legacy-support-v4:${Versions.supportV4Version}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
        const val koinAndroid = "org.koin:koin-android:${Versions.koinVersion}"
        const val koinLifeCycleScope = "org.koin:koin-android-scope:${Versions.koinVersion}"
        const val koinAndroidViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koinVersion}"
        const val lifecycleExtensions =
            "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensionsVersion}"
        const val recyclerviewAnimations =
            "jp.wasabeef:recyclerview-animators:${Versions.recyclerviewAnimationVersion}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
        const val glideAnnotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverterVersion}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCoreVersion}"
    }

object TestLibraries {
    private object Versions {
        const val junitVersion = "4.12"
        const val androidxJunitVersion = "1.1.1"
        const val truthVersion = "1.0"
        const val mockWebServerVersion = "4.2.1"
        const val androidxTestCoreVersion = "1.0.0"
        const val archComponentTestVersion = "2.1.0"
        const val coroutinesCoreVersion = "1.3.3"
    }

    const val junit = "junit:junit:${Versions.junitVersion}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunitVersion}"
    const val googleTruth = "com.google.truth:truth:${Versions.truthVersion}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServerVersion}"
    const val androidxCoreTest = "androidx.test:core:${Versions.androidxTestCoreVersion}"
    const val archComponentTest =
        "androidx.arch.core:core-testing:${Versions.archComponentTestVersion}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesCoreVersion}"

}