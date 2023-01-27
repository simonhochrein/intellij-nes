package com.simonhochrein.nesdev.asm

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.simonhochrein.nesdev.asm.psi.AsmTokenSets
import com.simonhochrein.nesdev.asm.psi.AsmTypes

class AsmSyntaxHighlighter: SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return AsmLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            AsmTypes.MNEMONIC -> KEYWORD_KEYS
            AsmTypes.COMMENT -> COMMENT_KEYS
            AsmTypes.STRING -> STRING_KEYS
            in AsmTokenSets.NUMBERS -> NUMBER_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        private val MNEMONIC_KEY = createTextAttributesKey("ASM_MNEMONIC", DefaultLanguageHighlighterColors.KEYWORD)
        private val LINE_COMMENT_KEY = createTextAttributesKey("ASM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        private val NUMBER_KEY = createTextAttributesKey("ASM_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        private val STRING_KEY = createTextAttributesKey("ASM_STRING", DefaultLanguageHighlighterColors.STRING)

        val KEYWORD_KEYS = arrayOf(MNEMONIC_KEY)
        val COMMENT_KEYS = arrayOf(LINE_COMMENT_KEY)
        val NUMBER_KEYS = arrayOf(NUMBER_KEY)
        val STRING_KEYS = arrayOf(STRING_KEY)
        val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}