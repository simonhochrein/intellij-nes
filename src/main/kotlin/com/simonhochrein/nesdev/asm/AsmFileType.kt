package com.simonhochrein.nesdev.asm

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class AsmFileType: LanguageFileType(AsmLanguage.INSTANCE) {
    override fun getName(): String = "Assembly File"

    override fun getDescription(): String = "6502 assembly file"

    override fun getDefaultExtension(): String = "s"

    override fun getIcon(): Icon = AllIcons.FileTypes.Custom

    companion object {
        @JvmField
        val INSTANCE = AsmFileType()
    }
}