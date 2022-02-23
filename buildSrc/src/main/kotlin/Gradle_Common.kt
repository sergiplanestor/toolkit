import com.android.build.api.dsl.*
import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

typealias Plugins = GradlePlugin
internal typealias BF = BuildFeatures
internal typealias BT = BuildType
internal typealias DC = DefaultConfig
internal typealias PF = ProductFlavor
internal typealias CExt<T, U, V, W> = CommonExtension<T, U, V, W>

fun KotlinJvmOptions.applyKotlinOptions(target: String = "11") {
    jvmTarget = target
    freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
}

fun <T : BF, U : BT, V : DC, W : PF> CExt<T, U, V, W>.applyCompileOptions() {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}