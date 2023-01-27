package com.simonhochrein.nesdev.asm.psi

import com.intellij.psi.tree.TokenSet

object AsmTokenSets {
    val IDENTIFIERS = TokenSet.create(AsmTypes.IDENTIFIER)
    val NUMBERS = TokenSet.create(AsmTypes.HEX_NUMBER, AsmTypes.DEC_NUMBER, AsmTypes.BIN_NUMBER)
}