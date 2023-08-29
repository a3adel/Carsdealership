plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    testApi(TestDependencies.Junit4)
    testApi(TestDependencies.mockk)
    testApi(TestDependencies.coroutines_test)
}