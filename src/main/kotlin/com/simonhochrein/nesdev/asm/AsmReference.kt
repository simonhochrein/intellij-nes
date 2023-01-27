package com.simonhochrein.nesdev.asm

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class AsmReference(element: PsiElement, textRange: TextRange): PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {
    private val key: String
    init {
        key = element.text.substring(textRange.startOffset, textRange.endOffset)
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement.project

        val labels = AsmUtil.findLabels(project, key).map {
            PsiElementResolveResult(it)
        }
        val constants = AsmUtil.findConstants(project, key).map {
            PsiElementResolveResult(it)
        }

        return (constants + labels).toTypedArray()
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun getVariants(): Array<Any> {
        val project = myElement.project
        val labels = AsmUtil.findLabels(project).filter {
            it.label?.isNotEmpty() == true
        }.map {
            LookupElementBuilder.create(it).withIcon(AllIcons.Nodes.Field).withTypeText(it.containingFile.name)
        }

        val constants = AsmUtil.findConstants(project).filter {
            it.identifier?.isNotEmpty() == true
        }.map {
            LookupElementBuilder.create(it).withIcon(AllIcons.Nodes.Constant).withTypeText(it.containingFile.name)
        }

        return (constants + labels).toTypedArray()
    }
}