package com.simonhochrein.nesdev.asm

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.simonhochrein.nesdev.asm.psi.AsmConstant
import com.simonhochrein.nesdev.asm.psi.AsmLabel
import com.simonhochrein.nesdev.asm.psi.AsmTokenSets
import com.simonhochrein.nesdev.asm.psi.AsmTypes
import com.simonhochrein.nesdev.asm.psi.impl.AsmPsiImplUtil.getLabel
import org.jetbrains.annotations.Nls
import org.jetbrains.annotations.NonNls

class AsmFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
            AsmLexerAdapter(), AsmTokenSets.IDENTIFIERS, TokenSet.create(AsmTypes.COMMENT), AsmTokenSets.NUMBERS
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is AsmLabel || psiElement is AsmConstant
    }

    override fun getHelpId(psiElement: PsiElement): @NonNls String? {
        return null
    }

    override fun getType(element: PsiElement): @Nls String {
        return if (element is AsmLabel) "label" else "identifier"
    }

    override fun getDescriptiveName(element: PsiElement): @Nls String {
        return if (element is AsmLabel) getLabel(element)!! else element.text
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): @Nls String {
        return "Nothing"
    }
}