package com.simonhochrein.nesdev.asm.structureview

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import com.simonhochrein.nesdev.asm.psi.AsmConstant
import com.simonhochrein.nesdev.asm.psi.AsmLabel

class AsmStructureViewModel(editor: Editor?, psiFile: PsiFile) : StructureViewModelBase(psiFile, editor,
    AsmStructureViewElement(psiFile)
), StructureViewModel.ElementInfoProvider {

    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return element.value is AsmLabel || element.value is AsmConstant
    }

    override fun getSuitableClasses(): Array<Class<*>> {
        return arrayOf(AsmLabel::class.java, AsmConstant::class.java)
    }

}