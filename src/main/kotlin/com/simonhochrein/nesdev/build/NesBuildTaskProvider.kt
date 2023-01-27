package com.simonhochrein.nesdev.build

import com.intellij.execution.BeforeRunTask
import com.intellij.execution.BeforeRunTaskProvider
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.util.Key
import com.intellij.task.ProjectTaskManager
import java.util.concurrent.CompletableFuture

class NesBuildTaskProvider: BeforeRunTaskProvider<NesBuildTaskProvider.NesBuildTask>() {

    class NesBuildTask(providerId: Key<NesBuildTask>): BeforeRunTask<NesBuildTask>(providerId) {
        init {
            isEnabled = true
        }
    }

    override fun getId(): Key<NesBuildTask> = ID

    override fun getName(): String {
        return "Build"
    }

    override fun createTask(runConfiguration: RunConfiguration): NesBuildTask? = if (runConfiguration is NesRunConfiguration) NesBuildTask(ID) else null

    override fun executeTask(
        context: DataContext,
        configuration: RunConfiguration,
        environment: ExecutionEnvironment,
        task: NesBuildTask
    ): Boolean {
        val buildConfiguration = NesBuildConfiguration(configuration, environment)

        val result = CompletableFuture<Boolean>()
        ProjectTaskManager.getInstance(environment.project).build(buildConfiguration).onProcessed {
            result.complete(!it.hasErrors() && !it.isAborted)
        }

        return result.get()
    }

    override fun isSingleton(): Boolean = true

    companion object {
        val ID: Key<NesBuildTask> = Key.create("NES.BUILD_TASK_PROVIDER")
    }
}