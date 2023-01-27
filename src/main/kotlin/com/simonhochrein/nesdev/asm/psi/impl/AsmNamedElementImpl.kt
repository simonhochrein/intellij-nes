package com.simonhochrein.nesdev.asm.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.simonhochrein.nesdev.asm.AsmReference
import com.simonhochrein.nesdev.asm.AsmUtil

abstract class AsmNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), AsmNamedElement {
    override fun getReference(): PsiReference? {
        return AsmReference(node.psi, TextRange(0, node.textLength))
    }
}