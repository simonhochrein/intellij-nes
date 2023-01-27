package com.simonhochrein.nesdev.asm

import com.intellij.lang.Language

class AsmLanguage: Language("Assembly") {
    companion object {
        val INSTANCE = AsmLanguage()
    }
}