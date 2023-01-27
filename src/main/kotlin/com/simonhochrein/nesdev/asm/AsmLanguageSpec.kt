package com.simonhochrein.nesdev.asm

import com.intellij.openapi.util.JDOMUtil
import com.intellij.util.xmlb.XmlSerializerUtil
import org.codehaus.stax2.XMLStreamReader2

data class Opcode(
    val mnemonic: String,
    val name: String,
    val description: String
)

class AsmLanguageSpec {
    fun findOpcode(mnemonic: String): Opcode? =
        opcodes.find {
            it.mnemonic == mnemonic
        }

    val opcodes: List<Opcode>

    init {
        val data = JDOMUtil.load(this.javaClass.getResourceAsStream("/data.xml"))

        val opcodes = mutableListOf<Opcode>()

        for (child in data.getChild("opcodes").children) {
            opcodes.add(Opcode(child.getAttributeValue("mnemonic"), child.getAttributeValue("name"), child.getChildTextTrim("description")))
        }

        this.opcodes = opcodes
    }

    companion object {
        val INSTANCE = AsmLanguageSpec()
    }
}