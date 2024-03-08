object Config {
    const val ROOT_PROJECT_NAME = "search-service"
    const val DEFAULT_PROJECTS_EXTENSION_NAME = "nowhereLibs"
    const val TEST_LIBS_CATALOG_NAME = "testLibs"
    const val TEST_LIBS_CATALOG_FILE = "gradle/test-libs.versions.toml"
}

rootProject.name = Config.ROOT_PROJECT_NAME

dependencyResolutionManagement {
    defaultProjectsExtensionName = Config.DEFAULT_PROJECTS_EXTENSION_NAME
    versionCatalogs {
        create(Config.TEST_LIBS_CATALOG_NAME) {
            from(files(Config.TEST_LIBS_CATALOG_FILE))
        }
    }
}