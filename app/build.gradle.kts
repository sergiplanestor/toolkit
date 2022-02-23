plugins {
    appPlugins().forEach(::id)
}

android {

    namespace = "com.splanes.toolkit"

    applyAppDefaultConfig()

    applySigningConfig()

    applyAppFlavors()

    applyCompileOptions()

    kotlinOptions { applyKotlinOptions() }

    excludeCommonPackages()
}

dependencies {

    androidCore()
    androidRuntime()

    test()
}