package com.simonhochrein.nesdev.asm

import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project

class AsmGotoSymbolContributor : ChooseByNameContributor {
    override fun getNames(project: Project, includeNonProjectItems: Boolean): Array<String> {
        val labels = AsmUtil.findLabels(project)
        val constants = AsmUtil.findConstants(project);
        val names = mutableListOf<String>()

        for(label in labels) {
            if(label.label?.isNotEmpty() == true) {
                names.add(label.label!!)
            }
        }

        for(constant in constants) {
            if(constant.name?.isNotEmpty() == true) {
                names.add(constant.name!!)
            }
        }

        return names.toTypedArray()
    }

    override fun getItemsByName(
        name: String,
        pattern: String?,
        project: Project,
        includeNonProjectItems: Boolean
    ): Array<NavigationItem> {
        val labels = AsmUtil.findLabels(project, name).map {
            it as NavigationItem
        }
        val constants = AsmUtil.findConstants(project, name).map {
            it as NavigationItem
        }

        return (labels + constants).toTypedArray()
    }
}