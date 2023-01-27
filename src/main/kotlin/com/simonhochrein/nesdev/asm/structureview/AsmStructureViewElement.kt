package com.simonhochrein.nesdev.asm.structureview

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.simonhochrein.nesdev.asm.AsmFile
import com.simonhochrein.nesdev.asm.psi.AsmConstant
import com.simonhochrein.nesdev.asm.psi.AsmLabel
import com.simonhochrein.nesdev.asm.psi.impl.AsmConstantImpl
import com.simonhochrein.nesdev.asm.psi.impl.AsmLabelImpl

class AsmStructureViewElement(private val myElement: NavigatablePsiElement) :
    StructureViewTreeElement, SortableTreeElement {

    override fun getPresentation(): ItemPresentation = myElement.presentation ?: PresentationData()

    override fun getChildren(): Array<TreeElement> {
        if(myElement is AsmFile){
            val constants = PsiTreeUtil.findChildrenOfType(myElement, AsmConstant::class.java).map {
                AsmStructureViewElement(it as AsmConstantImpl)
            }
            val labels = PsiTreeUtil.findChildrenOfType(myElement, AsmLabel::class.java).map {
                AsmStructureViewElement(it as AsmLabelImpl)
            }
            val treeElements = constants + labels

            return treeElements.toTypedArray()
        }
        return emptyArray()
    }

    override fun navigate(requestFocus: Boolean) = myElement.navigate(requestFocus)

    override fun canNavigate() = myElement.canNavigate()

    override fun canNavigateToSource() = myElement.canNavigateToSource()

    override fun getValue() = myElement

    override fun getAlphaSortKey() = myElement.name.orEmpty()

}