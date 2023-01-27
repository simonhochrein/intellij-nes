package com.simonhochrein.nesdev.asm.psi

import com.intellij.psi.tree.IElementType
import com.simonhochrein.nesdev.asm.AsmLanguage

class AsmElementType(debugName: String): IElementType(debugName, AsmLanguage.INSTANCE)