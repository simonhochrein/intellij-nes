package com.simonhochrein.nesdev.asm

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.StandardPatterns.not
import com.intellij.patterns.StandardPatterns.string
import com.intellij.util.ProcessingContext
import com.simonhochrein.nesdev.asm.psi.AsmTypes

class AsmCompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, not(afterMnemonic).andNot(
            psiElement(AsmTypes.COMMENT)
        ), object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(
                parameters: CompletionParameters,
                context: ProcessingContext,
                result: CompletionResultSet
            ) {
                val opcodes = AsmLanguageSpec.INSTANCE.opcodes
                result.addAllElements(opcodes.map {
                    LookupElementBuilder.create(it.mnemonic).withTypeText(it.name).withInsertHandler(InlineInsertHandler())
                })
            }
        })

//        extend(CompletionType.BASIC, afterMnemonic.andNot(
//            psiElement(AsmTypes.COMMENT)
//        ), object : CompletionProvider<CompletionParameters>() {
//            override fun addCompletions(
//                parameters: CompletionParameters,
//                context: ProcessingContext,
//                result: CompletionResultSet
//            ) {
//                val labels = AsmUtil.findLabels(parameters.originalFile.project)
//
//                result.addAllElements(labels.filter { it.label != null }
//                    .map { LookupElementBuilder.create(it.label!!).withIcon(AllIcons.Nodes.Field) })
//            }
//        })
    }

    class InlineInsertHandler : InsertHandler<LookupElement> {
        override fun handleInsert(context: InsertionContext, item: LookupElement) {
            val editor = context.editor
            val offset = editor.caretModel.offset
            context.document.insertString(offset, " ");
            editor.caretModel.moveToOffset(offset + 1)
        }

    }

    companion object {
        val afterMnemonic = psiElement().afterLeafSkipping(
            not(psiElement(AsmTypes.EOL)).andNot(psiElement(AsmTypes.MNEMONIC)),
            psiElement(AsmTypes.MNEMONIC)
        )
    }
}