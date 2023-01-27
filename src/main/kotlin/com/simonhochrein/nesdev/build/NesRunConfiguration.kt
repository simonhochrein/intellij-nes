package com.simonhochrein.nesdev.build

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class NesRunConfiguration(project: Project, factory: NesConfigurationFactory, name: String) :
    RunConfigurationBase<NesRunConfigurationOptions>(project, factory, name),
    RunConfigurationWithSuppressedDefaultDebugAction {

    override fun getOptions(): NesRunConfigurationOptions {
        return super.getOptions() as NesRunConfigurationOptions
    }

    fun getScriptName() = options.getScriptName()
    fun setScriptName(name: String) = options.setScriptName(name)
    fun getCompilerFlags() = options.getCompilerFlags()
    fun setCompilerFlags(flags: String) = options.setCompilerFlags(flags)


    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return NesSettingsEditor()
    }

    override fun checkConfiguration() {
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState {
        return object : CommandLineState(environment) {
            override fun startProcess(): ProcessHandler {
                val commandLine = GeneralCommandLine(options.getScriptName(), "")
                val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
                ProcessTerminatedListener.attach(processHandler)
                return processHandler
            }
        }
    }

}
