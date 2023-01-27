package com.simonhochrein.nesdev.asm

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class AsmFile(viewProvider: FileViewProvider): PsiFileBase(viewProvider, AsmLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return AsmFileType.INSTANCE;
    }

    override fun toString(): String = "Assembly File"
}