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

    val sourcesJar by tasks.creating(Jar::class) {
        group = JavaBasePlugin.DOCUMENTATION_GROUP
        description = "Assembles sources JAR"
        archiveClassifier.set("sources")
        from(project.android.sourceSets.getByName("main").java.srcDirs)
    }

    artifacts { archives(sourcesJar) }

    fun MavenPublication.applyConfig() {
        from(components["release"])
        artifact(sourcesJar)

        groupId = "com.github.sergiplanestor"
        artifactId = project.name
        version = BuildVersion.name
    }

    publishing {
        publications {
            create<MavenPublication>("release") { applyConfig() }
        }
    }
}

