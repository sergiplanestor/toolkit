plugins {
    appPlugins().forEach(::id)
}

android {

    namespace = "com.splanes.toolkitcompose"

    applyAppDefaultConfig()

    applySigningConfig()

    applyAppFlavors()

    applyCompileOptions()

    kotlinOptions { jvmTarget() }

    excludeCommonPackages()
}

dependencies {

    androidCore()
    androidRuntime()

    compose()

    test()
}