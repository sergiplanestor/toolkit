plugins {
    libPlugins().forEach(::id)
}

android {

    namespace = "com.splanes.toolkit.base.logger"

    applyLibModuleDefaultConfig()

    applyLibFlavors()

    applyCompileOptions()

    kotlinOptions { applyKotlinOptions() }
}

dependencies {

    androidCore()
    androidRuntime()

    timber(isApi = true)

    test()
}