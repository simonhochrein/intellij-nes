package com.simonhochrein.nesdev.build

import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.roots.ProjectModelBuildableElement
import com.intellij.openapi.roots.ProjectModelExternalSource

@Suppress("UnstableApiUsage")
open class NesBuildConfiguration(val configuration: RunConfiguration, val environment: ExecutionEnvironment) : ProjectModelBuildableElement {
    override fun getExternalSource(): ProjectModelExternalSource? = null
}