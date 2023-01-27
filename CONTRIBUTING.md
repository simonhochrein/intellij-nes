# Getting Started

## Environment

Make sure [JetBrains Runtime](https://github.com/JetBrains/JetBrainsRuntime/releases) is installed and that JAVA_HOME and PATH are set correctly

## Clone

```shell
git clone https://github.com/simonhochrein/intellij-nes
cd intellij-nes
```

## Building & Running

Common Gradle tasks:
* `./gradlew :buildPlugin` -- build plugin and create archive at `build/distributions` which can be installed via `Install plugin from disk` in IDE Plugin settings
* `./gradlew :runIde` -- build and run development IDE build

## Development

This project is developed through [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/). When you open the project a `Run Plugin` task should be available to build the plugin and debug it through a development IDE.