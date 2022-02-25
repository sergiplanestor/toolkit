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

    androidCore()
    androidRuntime()

    timber()

    composeBase()
    composeSystemUi()
    composeNavigation()
    api(Dependency.toolkitComposeUiTheme)

    test()
}