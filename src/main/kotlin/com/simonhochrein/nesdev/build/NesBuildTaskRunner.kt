package com.simonhochrein.nesdev.build

import com.intellij.openapi.project.Project
import com.intellij.task.ProjectModelBuildTask
import com.intellij.task.ProjectTask
import com.intellij.task.ProjectTaskContext
import com.intellij.task.ProjectTaskRunner
import com.intellij.task.TaskRunnerResults
import org.jetbrains.concurrency.AsyncPromise
import org.jetbrains.concurrency.Promise
import org.jetbrains.concurrency.resolvedPromise

class NesBuildTaskRunner: ProjectTaskRunner() {
    override fun canRun(projectTask: ProjectTask): Boolean {
        if(projectTask is ProjectModelBuildTask<*> && projectTask.buildableElement is NesBuildConfiguration) {
            return true
        }
        return false
    }

    override fun run(project: Project, context: ProjectTaskContext, vararg tasks: ProjectTask?): Promise<Result> {
        val task = tasks[0] as? ProjectModelBuildTask<*>
        val configuration = task?.buildableElement as? NesBuildConfiguration



        val resultPromise = AsyncPromise<Result>()

        return resolvedPromise(TaskRunnerResults.SUCCESS)
    }
}