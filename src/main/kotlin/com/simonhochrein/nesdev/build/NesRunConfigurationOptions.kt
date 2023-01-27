package com.simonhochrein.nesdev.build

import com.intellij.execution.configurations.RunConfigurationOptions

class NesRunConfigurationOptions: RunConfigurationOptions() {
    val myScriptName = string("").provideDelegate(this, "scriptName")
    val myCompilerFlags = string("-t nes").provideDelegate(this, "compilerFlags")

    fun getScriptName() = myScriptName.getValue(this)
    fun setScriptName(name: String) = myScriptName.setValue(this, name)
    fun getCompilerFlags() = myCompilerFlags.getValue(this)
    fun setCompilerFlags(flags: String) = myCompilerFlags.setValue(this, flags)
}