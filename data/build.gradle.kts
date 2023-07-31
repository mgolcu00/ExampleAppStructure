plugins {
    alias(libs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // injection dependency
    implementation(libs.javax.inject)

    // network client dependency
    implementation(libs.ktor.client.core)


    implementation(libs.kotlinx.coroutines.core)

    // domain module dependency
    implementation(project(":domain"))

}