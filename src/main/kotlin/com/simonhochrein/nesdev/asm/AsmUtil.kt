package com.simonhochrein.nesdev.asm

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.simonhochrein.nesdev.asm.psi.AsmConstant
import com.simonhochrein.nesdev.asm.psi.AsmLabel

object AsmUtil {
    fun findLabels(project: Project): ArrayList<AsmLabel> {
        val result = arrayListOf<AsmLabel>()
        val virtualFiles = FileTypeIndex.getFiles(AsmFileType.INSTANCE, GlobalSearchScope.allScope(project))

        for (file in virtualFiles) {
            val asmFile = PsiManager.getInstance(project).findFile(file)

            if (asmFile != null) {
                val labels = PsiTreeUtil.findChildrenOfType(asmFile, AsmLabel::class.java)
                result.addAll(labels)
            }
        }

        return result
    }

    fun findConstants(project: Project): ArrayList<AsmConstant> {
        val result = arrayListOf<AsmConstant>()
        val virtualFiles = FileTypeIndex.getFiles(AsmFileType.INSTANCE, GlobalSearchScope.allScope(project))

        for (file in virtualFiles) {
            val asmFile = PsiManager.getInstance(project).findFile(file)

            asmFile?.let {
                val assignments = PsiTreeUtil.findChildrenOfType(asmFile, AsmConstant::class.java)
                result.addAll(assignments)
            }
        }

        return result
    }

    fun findLabels(project: Project, ident: String): ArrayList<AsmLabel> {
        val result = arrayListOf<AsmLabel>()
        val virtualFiles = FileTypeIndex.getFiles(AsmFileType.INSTANCE, GlobalSearchScope.allScope(project))

        for (file in virtualFiles) {
            val asmFile = PsiManager.getInstance(project).findFile(file)

            if (asmFile != null) {
                val labels = PsiTreeUtil.findChildrenOfType(asmFile, AsmLabel::class.java)
                for (label in labels) {
                    if (ident == label.label) {
                        result.add(label)
                    }
                }
            }
        }

        return result
    }

    fun findConstants(project: Project, ident: String): ArrayList<AsmConstant> {
        val result = arrayListOf<AsmConstant>()
        val virtualFiles = FileTypeIndex.getFiles(AsmFileType.INSTANCE, GlobalSearchScope.allScope(project))

        for (file in virtualFiles) {
            val asmFile = PsiManager.getInstance(project).findFile(file)

            asmFile?.let {
                val constants = PsiTreeUtil.findChildrenOfType(asmFile, AsmConstant::class.java)
                result.addAll(constants.filter {
                    ident == it.identifier
                })
            }
        }

        return result
    }
}