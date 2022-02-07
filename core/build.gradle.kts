plugins {
    libPlugins().forEach(::id)
}

apply<com.splanes.plugins.JitpackPublishPlugin>()

android {

    namespace = "com.splanes.core"

    applyLibModuleDefaultConfig()

    applyLibFlavors()

    applyCompileOptions()

    kotlinOptions { jvmTarget() }

    withFeatures(Feature.Compose)

    composeOptions { kotlinCompilerExtensionVersion = DependencyVersion.compose }

    excludeCommonPackages()
}

dependencies {

    androidCore()
    androidRuntime()
    androidExtensions()
    androidViewModel()

    ktxCoroutines()

    compose()

    test()
}