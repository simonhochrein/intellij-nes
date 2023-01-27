package com.simonhochrein.nesdev.asm.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.simonhochrein.nesdev.asm.AsmFile
import com.simonhochrein.nesdev.asm.AsmFileType

object AsmElementFactory {
    @JvmStatic
    fun createLabel(project: Project, name: String): AsmLabel {
        val file = createFile(project, name)
        return file.firstChild as AsmLabel
    }

    @JvmStatic
    fun createFile(project: Project, text: String): AsmFile {
        val name = "dummy.s"
        return PsiFileFactory.getInstance(project).createFileFromText(name, AsmFileType.INSTANCE, text) as AsmFile
    }

    fun createConstant(project: Project, name: String): AsmConstant {
        val file = createFile(project, name)
        return file.firstChild as AsmConstant
    }
}