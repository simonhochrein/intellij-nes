package com.simonhochrein.nesdev.asm

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.psi.util.prevLeaf
import com.simonhochrein.nesdev.asm.psi.AsmLabel
import com.simonhochrein.nesdev.asm.psi.AsmTypes

class AsmFoldingBuilder : FoldingBuilder {
    // TODO: Refactor this
    override fun buildFoldRegions(node: ASTNode, document: Document): Array<FoldingDescriptor> {
        val foldingRegions = mutableListOf<FoldingDescriptor>()
        var lastStartOffset = 0
        var lastLabel: AsmLabel? = null

        PsiTreeUtil.findChildrenOfType(node.psi, AsmLabel::class.java).forEach {

            if(lastStartOffset > 0) {
                val lastLeaf = it.prevLeaf { element ->
                    element.elementType != AsmTypes.EOL && element.elementType != TokenType.WHITE_SPACE
                }

                lastLeaf?.textRange?.endOffset?.let { endOffset ->
                    if(endOffset > lastStartOffset) {
                        foldingRegions.add(FoldingDescriptor(it, lastStartOffset, endOffset, null, "..."))
                    }
                }
            }

            lastStartOffset = it.textOffset + it.textLength
            lastLabel = it
        }

        if (lastStartOffset > 0 && node.startOffset + node.textLength > lastStartOffset) {
            foldingRegions.add(
                FoldingDescriptor(
                    lastLabel!!,
                    lastStartOffset,
                    node.startOffset + node.textLength,
                    null,
                    "..."
                )
            )
        }

        return foldingRegions.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode) = null

    override fun isCollapsedByDefault(node: ASTNode) = false
}