plugins {
    libPlugins(GradlePlugin.Other("maven-publish")).forEach(::id)
}

/*apply<com.splanes.plugins.JitpackPublishPlugin>()
configure<com.splanes.plugins.JitpackPublishPluginExtension> {
    artifactVersion.set(project.property("lib.core.version") as String)
}*/

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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.toolkitcompose"
                artifactId = "core"
                version = "1.0.1"
                from(components["release"])
            }
        }
    }
}