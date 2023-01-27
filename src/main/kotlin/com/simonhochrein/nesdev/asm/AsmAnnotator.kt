package com.simonhochrein.nesdev.asm

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.options.colors.pages.DefaultLanguageColorsPage
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.simonhochrein.nesdev.asm.psi.AsmDirective
import com.simonhochrein.nesdev.asm.psi.AsmHashOperand
import com.simonhochrein.nesdev.asm.psi.AsmLabel
import com.simonhochrein.nesdev.asm.psi.AsmNumber
import com.simonhochrein.nesdev.asm.psi.AsmRef

class AsmAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if(element is AsmLabel) {
            val labelRange = element.textRange
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(labelRange).textAttributes(DefaultLanguageHighlighterColors.IDENTIFIER).create()
        }
        if(element is AsmDirective) {
            val labelRange = element.textRange
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(labelRange).textAttributes(DefaultLanguageHighlighterColors.METADATA).create()
        }

        if(element is AsmNumber) {
            if(element.text.startsWith("%") && element.text.length > 9) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Binary number longer than 8 bits").range(element.textRange).create()
            }
        }

        if(element is AsmRef && element.parent !is AsmHashOperand) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element.textRange).textAttributes(DefaultLanguageHighlighterColors.INSTANCE_FIELD).create()
        }

        if(element is AsmHashOperand) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element.textRange).textAttributes(DefaultLanguageHighlighterColors.STRING).create()
        }
    }
}