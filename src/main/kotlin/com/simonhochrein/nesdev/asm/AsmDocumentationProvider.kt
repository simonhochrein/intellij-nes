package com.simonhochrein.nesdev.asm

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.psi.PsiElement
import com.simonhochrein.nesdev.asm.psi.AsmOpcode

class AsmDocumentationProvider : AbstractDocumentationProvider() {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        if(element is AsmOpcode) {
            val mnemonic = element.name
            return mnemonic?.let {
                AsmLanguageSpec.INSTANCE.findOpcode(it.lowercase())?.description
            }
        }
        return super.generateDoc(element, originalElement)
    }
}