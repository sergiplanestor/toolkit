import org.gradle.api.artifacts.dsl.DependencyHandler

object DependencyVersion {
    const val androidxCore = "1.7.0"
    const val androidxRuntime = "2.4.0"
    const val androidxExtensions = "2.2.0"
    const val androidxViewModel = "2.4.0"
    const val kotlinCoroutines = "1.6.0"

    const val timberLogger = "5.0.1"

    const val compose = "1.1.0-rc03"
    const val composeMaterial = "1.2.0-alpha02"
    const val composeMaterial3 = "1.0.0-alpha04"
    const val composeMaterialIcons = "1.2.0-alpha05"
    const val composeActivity = "1.4.0"
    const val composeNavigation = "2.5.0-alpha02"
    const val composeAccompanistNavigationAnim = "0.24.2-alpha"
    const val composeSystemUi = "0.24.1-alpha"

    const val toolkitComposeUiTheme = "1.0.1-CT"
    const val toolkitComposeUiComponents = "1.0.1-CC"
}

object Dependency {

    const val androidxCore = "androidx.core:core-ktx:${DependencyVersion.androidxCore}"
    const val androidxRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${DependencyVersion.androidxRuntime}"
    const val androidxExtensions = "androidx.lifecycle:lifecycle-extensions:${DependencyVersion.androidxExtensions}"
    const val androidxViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependencyVersion.androidxViewModel}"

    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependencyVersion.kotlinCoroutines}"
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersion.kotlinCoroutines}"

    const val timberLogger = "com.jakewharton.timber:timber:${DependencyVersion.timberLogger}"

    const val androidxComposeUi = "androidx.compose.ui:ui:${DependencyVersion.compose}"
    const val androidxComposeMaterial = "androidx.compose.material:material:${DependencyVersion.composeMaterial}"
    const val androidxComposeMaterial3 = "androidx.compose.material3:material3:${DependencyVersion.composeMaterial3}"
    const val androidxComposeMaterialIcons = "androidx.compose.material:material-icons-extended:${DependencyVersion.composeMaterialIcons}"
    const val androidxComposeUiPreview = "androidx.compose.ui:ui-tooling-preview:${DependencyVersion.compose}"
    const val androidxComposeActivity = "androidx.activity:activity-compose:${DependencyVersion.composeActivity}"
    const val androidxComposeNavigation = "androidx.navigation:navigation-compose:${DependencyVersion.composeNavigation}"
    const val composeAccompanistNavigationAnim = "com.google.accompanist:accompanist-navigation-animation:${DependencyVersion.composeAccompanistNavigationAnim}"
    const val androidxComposeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${DependencyVersion.composeNavigation}"
    const val composeSystemUi = "com.google.accompanist:accompanist-systemuicontroller:${DependencyVersion.composeSystemUi}"

    const val toolkitComposeUiTheme = "com.github.sergiplanestor.toolkit:theme:${DependencyVersion.toolkitComposeUiTheme}"
    const val toolkitComposeUiComponents = "com.github.sergiplanestor.toolkit:components:${DependencyVersion.toolkitComposeUiComponents}"
}

fun DependencyHandler.androidCore(isApi: Boolean = false) {
    impl(Dependency.androidxCore, isApi = isApi)
}

fun DependencyHandler.androidRuntime(isApi: Boolean = false) {
    impl(Dependency.androidxRuntime, isApi = isApi)
}

fun DependencyHandler.androidExtensions(isApi: Boolean = false) {
    impl(Dependency.androidxExtensions, isApi = isApi)
}

fun DependencyHandler.androidViewModel(isApi: Boolean = false) {
    impl(Dependency.androidxViewModel, isApi = isApi)
}

fun DependencyHandler.ktxCoroutines(isApi: Boolean = false) {
    impl(Dependency.kotlinCoroutinesCore, isApi = isApi)
    impl(Dependency.kotlinCoroutinesAndroid, isApi = isApi)
}

fun DependencyHandler.timber(isApi: Boolean = false) {
    impl(Dependency.timberLogger, isApi = isApi)
}

fun DependencyHandler.toolkitComposeUiTheme(isApi: Boolean = false) {
    impl(Dependency.toolkitComposeUiTheme, isApi = isApi)
}

fun DependencyHandler.composeBase(
    isMaterial3: Boolean = true,
    includeIconExtension: Boolean = true,
    isApi: Boolean = false
) {
    impl(Dependency.androidxComposeUi, isApi = isApi)
    impl(Dependency.androidxComposeActivity, isApi = isApi)
    impl(Dependency.androidxComposeUiPreview, isApi = isApi)
    composeMaterial()
    if (isMaterial3) composeMaterial3(isApi)
    if (includeIconExtension) composeMaterialIcons(isApi)

    test(Test.androidxComposeJUnit, isUiTest = true)

    apply(Test.androidxComposeTooling, ImplType.DebugImpl)
}

fun DependencyHandler.composeMaterial(isApi: Boolean = false) {
    impl(Dependency.androidxComposeMaterial, isApi = isApi)
}

fun DependencyHandler.composeMaterial3(isApi: Boolean = false) {
    impl(Dependency.androidxComposeMaterial3, isApi = isApi)
}

fun DependencyHandler.composeMaterialIcons(isApi: Boolean = false) {
    impl(Dependency.androidxComposeMaterialIcons, isApi = isApi)
}

fun DependencyHandler.composeNavigation(isNavAnim: Boolean = true, isApi: Boolean = false) {
    impl(Dependency.androidxComposeNavigation, isApi = isApi)
    if (isNavAnim) composeNavigationAnim(isApi)
}

fun DependencyHandler.composeNavigationAnim(isApi: Boolean = false) {
    impl(Dependency.composeAccompanistNavigationAnim, isApi = isApi)
}

fun DependencyHandler.composeViewModel(isApi: Boolean = false) {
    impl(Dependency.androidxComposeViewModel, isApi = isApi)
}

fun DependencyHandler.composeSystemUi(isApi: Boolean = false) {
    impl(Dependency.composeSystemUi, isApi = isApi)
}

fun DependencyHandler.compose(isApi: Boolean = false) {
    composeBase(isApi)
    composeNavigation(isApi)
    composeViewModel(isApi)
    composeSystemUi(isApi)
}

fun DependencyHandler.test() {
    test(Test.junit)
    test(Test.androidxJUnit, isUiTest = true)
    test(Test.androidxEspressoCore, isUiTest = true)
}

object TestVersion {
    const val junit = "4.13.2"
    const val androidxJUnit = "1.1.3"
    const val androidxEspressoCore = "3.4.0"
    const val androidxComposeJUnit = DependencyVersion.compose
    const val androidxComposeTooling = DependencyVersion.compose
}

object Test {
    const val junit = "junit:junit:${TestVersion.junit}"
    const val androidxJUnit = "androidx.test.ext:junit:${TestVersion.androidxJUnit}"
    const val androidxEspressoCore = "androidx.test.espresso:espresso-core:${TestVersion.androidxEspressoCore}"
    const val androidxComposeJUnit = "androidx.compose.ui:ui-test-junit4:${TestVersion.androidxComposeJUnit}"
    const val androidxComposeTooling = "androidx.compose.ui:ui-tooling:${TestVersion.androidxComposeTooling}"
}