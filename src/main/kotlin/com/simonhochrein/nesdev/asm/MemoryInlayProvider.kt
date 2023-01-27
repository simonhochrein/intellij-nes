package com.simonhochrein.nesdev.asm

import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import com.intellij.refactoring.suggested.endOffset
import com.simonhochrein.nesdev.asm.psi.AsmNumber
import com.simonhochrein.nesdev.asm.psi.AsmTypes
import javax.swing.JComponent
import javax.swing.JPanel

@Suppress("UnstableApiUsage")
class MemoryInlayProvider : InlayHintsProvider<MemoryInlayProvider.Settings> {
    data class Settings(var showForMemoryAddresses: Boolean = true)

    override val key: SettingsKey<Settings>
        get() = KEY

    override val name: String
        get() = "Memory inlay hints"
    override val previewText: String
        get() = """
            test:
                lda #$00
                sta $2006
                sta $2006
        """.trimIndent()

    override fun createSettings() = Settings()

    override fun getCollectorFor(
        file: PsiFile,
        editor: Editor,
        settings: Settings,
        sink: InlayHintsSink
    ) = object : FactoryInlayHintsCollector(editor) {
        override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
            if(settings.showForMemoryAddresses) {
                presentMemory(element)
            }

            return true
        }

        private fun presentMemory(element: PsiElement) {
            when(element) {
                is AsmNumber -> {
                    if(element.firstChild.elementType == AsmTypes.HEX_NUMBER) {
                        AsmLanguageSpec.INSTANCE.findMemory(element.text)?.let {
                            val presentation = factory.roundWithBackground(factory.smallText(it.name))
                            sink.addInlineElement(element.endOffset, true, presentation, false)
                        }
                    }
                }
            }
        }


    }

    override fun createConfigurable(settings: Settings) = object : ImmediateConfigurable {
        override val mainCheckboxText: String
            get() = "Enable memory inlay hints"
        override val cases: List<ImmediateConfigurable.Case>
            get() = listOf(ImmediateConfigurable.Case("Memory Address Inlays", "memory", settings::showForMemoryAddresses))

        override fun createComponent(listener: ChangeListener) = JPanel()
    }


    companion object {
        val KEY = SettingsKey<Settings>("nesdev.memory.hints")
    }
}