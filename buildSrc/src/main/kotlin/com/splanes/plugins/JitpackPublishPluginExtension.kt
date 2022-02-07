package com.splanes.plugins

import org.gradle.api.provider.Property

interface JitpackPublishPluginExtension {
    val artifactGroup: Property<String>
    val artifactId: Property<String>
    val artifactVersion: Property<String>
}