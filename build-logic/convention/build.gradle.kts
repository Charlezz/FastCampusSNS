plugins {
    `kotlin-dsl`
}

group = "kr.co.fastcampus.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin {
    plugins {
        register("fastCampusHiltPlugin"){
            id = "fastcampus.hilt.plugin"
            implementationClass = "FastCampusHiltPlugin"
        }
    }
}