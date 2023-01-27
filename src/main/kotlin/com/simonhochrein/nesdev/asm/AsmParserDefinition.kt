package com.simonhochrein.nesdev.asm

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.simonhochrein.nesdev.asm.parser.AsmParser
import com.simonhochrein.nesdev.asm.psi.AsmTypes

class AsmParserDefinition: ParserDefinition {

    override fun createLexer(project: Project?): Lexer {
        return AsmLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.create(AsmTypes.COMMENT)
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project?): PsiParser {
        return AsmParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return AsmFile(viewProvider)
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return AsmTypes.Factory.createElement(node)
    }

    companion object {
        val FILE = IFileElementType(AsmLanguage.INSTANCE)
    }
}