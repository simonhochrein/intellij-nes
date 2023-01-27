package com.simonhochrein.nesdev.build

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.icons.AllIcons

class NesRunConfigurationType : ConfigurationTypeBase("NES", "NES Run Configuration [EXPERIMENTAL]", "", AllIcons.RunConfigurations.Application) {
    override fun getConfigurationFactories(): Array<ConfigurationFactory> {
        return arrayOf(NesConfigurationFactory(this))
    }
}