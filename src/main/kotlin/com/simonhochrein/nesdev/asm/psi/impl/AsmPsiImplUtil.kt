package com.simonhochrein.nesdev.asm.psi.impl

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.simonhochrein.nesdev.asm.psi.AsmAssignment
import com.simonhochrein.nesdev.asm.psi.AsmConstant
import com.simonhochrein.nesdev.asm.psi.AsmElementFactory
import com.simonhochrein.nesdev.asm.psi.AsmLabel
import com.simonhochrein.nesdev.asm.psi.AsmOpcode
import com.simonhochrein.nesdev.asm.psi.AsmRef
import com.simonhochrein.nesdev.asm.psi.AsmTypes
import javax.swing.Icon

object AsmPsiImplUtil {
    @JvmStatic
    fun getLabel(element: AsmLabel): String? {
        return element.node.findChildByType(AsmTypes.IDENTIFIER)?.text
    }

    @JvmStatic
    fun getIdentifier(element: AsmNamedElement): String? {
        return element.node.findChildByType(AsmTypes.IDENTIFIER)?.text
    }

    @JvmStatic
    fun getName(element: AsmLabel): String? {
        return getLabel(element)
    }

    @JvmStatic
    fun setName(element: AsmLabel, newName: String): PsiElement {
        val labelNode = element.node.findChildByType(AsmTypes.LABEL);

        if(labelNode != null) {
            val label = AsmElementFactory.createLabel(element.project, newName)
            val newLabelNode = label.firstChild.node
            element.node.replaceChild(labelNode, newLabelNode)
        }

        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: AsmLabel): PsiElement? {
        return element.node.findChildByType(AsmTypes.LABEL)?.psi
    }

    @JvmStatic
    fun getName(element: AsmRef): String? {
        return getIdentifier(element)
    }

    @JvmStatic
    fun setName(element: AsmRef, newName: String): PsiElement {
        val refNode = element.node.findChildByType(AsmTypes.REF);

        if(refNode != null) {
            val ref = AsmElementFactory.createLabel(element.project, newName)
            val newRefNode = ref.firstChild.node
            element.node.replaceChild(refNode, newRefNode)
        }

        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: AsmRef): PsiElement? {
        return element.node.findChildByType(AsmTypes.REF)?.psi
    }

    @JvmStatic
    fun getPresentation(element: AsmLabel): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return element.label
            }

            override fun getLocationString(): String? {
                return element.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return AllIcons.Nodes.Field
            }

        }
    }


    @JvmStatic
    fun getNameIdentifier(element: AsmOpcode): PsiElement {
        return element
    }

    @JvmStatic
    fun getName(element: AsmOpcode): String? {
        return element.text
    }

    @JvmStatic
    fun setName(element: AsmOpcode, newName: String): PsiElement {
//        val refNode = element.node.findChildByType(AsmTypes.REF);
//
//        if(refNode != null) {
//            val ref = AsmElementFactory.createLabel(element.project, newName)
//            val newRefNode = ref.firstChild.node
//            element.node.replaceChild(refNode, newRefNode)
//        }

        return element
    }

    @JvmStatic
    fun getName(element: AsmConstant): String? {
        return getIdentifier(element)
    }

    @JvmStatic
    fun setName(element: AsmConstant, newName: String): PsiElement {
        val refNode = element.node.findChildByType(AsmTypes.CONSTANT);

        if(refNode != null) {
            val ref = AsmElementFactory.createConstant(element.project, newName)
            val newRefNode = ref.firstChild.node
            element.node.replaceChild(refNode, newRefNode)
        }

        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: AsmConstant): PsiElement? {
        return element.node.findChildByType(AsmTypes.CONSTANT)?.psi
    }

    @JvmStatic
    fun getPresentation(element: AsmConstant): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return element.identifier
            }

            override fun getLocationString(): String? {
                return element.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return AllIcons.Nodes.Constant
            }

        }
    }
}