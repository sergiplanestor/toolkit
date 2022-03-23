plugins {
    libPlugins().forEach(::id)
}

apply<com.splanes.plugins.JitpackPublishPlugin>()
configure<com.splanes.plugins.JitpackPublishPluginExtension> {
    artifactVersion.set(project.property("lib.compose.ui.components.version") as String)
}

android {

    namespace = "com.splanes.toolkit.compose.ui.components"

    applyLibModuleDefaultConfig()

    applyLibFlavors()

    applyCompileOptions()

    kotlinOptions { applyKotlinOptions() }

    withFeatures(Feature.Compose)

    composeOptions { kotlinCompilerExtensionVersion = DependencyVersion.compose }
}

dependencies {

    androidCore(isApi = true)
    androidRuntime(isApi = true)

    timber(isApi = true)

    composeBase(isApi = true)
    composeSystemUi(isApi = true)
    composeNavigation(isApi = true)
    api(Dependency.toolkitComposeUiTheme)

    test()
}