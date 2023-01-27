package com.simonhochrein.nesdev.build

import com.intellij.execution.BeforeRunTask
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key

class NesConfigurationFactory(nesRunConfigurationType: NesRunConfigurationType) : ConfigurationFactory(nesRunConfigurationType) {
    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return NesRunConfiguration(project, this, "NES")
    }

    override fun getOptionsClass(): Class<NesRunConfigurationOptions> {
        return NesRunConfigurationOptions::class.java
    }

    override fun getId(): String {
        return "NES"
    }

}
