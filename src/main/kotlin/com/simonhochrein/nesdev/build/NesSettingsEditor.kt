package com.simonhochrein.nesdev.build

import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.fields.ExpandableTextField
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import javax.swing.JComponent

class NesSettingsEditor : SettingsEditor<NesRunConfiguration>() {
    private var myScriptName: TextFieldWithBrowseButton? = null
    private var myCompilerFlags: ExpandableTextField? = null

    override fun resetEditorFrom(configuration: NesRunConfiguration) {
        myScriptName?.text = configuration.getScriptName().orEmpty()
        myCompilerFlags?.text = configuration.getCompilerFlags().orEmpty()
    }

    override fun applyEditorTo(configuration: NesRunConfiguration) {
        configuration.setScriptName(myScriptName!!.text)
        configuration.setCompilerFlags(myCompilerFlags!!.text)
    }

    override fun createEditor(): JComponent {
        return panel {
            row {
                label("Mesen path")
                cell()
                myScriptName = textFieldWithBrowseButton(fileChosen = {
                    it.path
                }).horizontalAlign(HorizontalAlign.FILL).component
            }
            row {
                label("Compiler flags")
                myCompilerFlags = expandableTextField().horizontalAlign(HorizontalAlign.FILL).component
            }
        }
    }

}
