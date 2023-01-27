package com.simonhochrein.nesdev.asm.psi

import com.intellij.psi.tree.IElementType
import com.simonhochrein.nesdev.asm.AsmLanguage

class AsmTokenType(debugName: String): IElementType(debugName, AsmLanguage.INSTANCE) {
    override fun toString(): String = "AsmTokenType." + super.toString()
}