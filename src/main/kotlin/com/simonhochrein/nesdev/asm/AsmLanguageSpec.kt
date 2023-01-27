package com.simonhochrein.nesdev.asm

import com.intellij.openapi.util.JDOMUtil
import com.intellij.openapi.util.NlsSafe
import com.intellij.util.xmlb.XmlSerializerUtil
import org.codehaus.stax2.XMLStreamReader2

data class Opcode(
    val mnemonic: String,
    val name: String,
    val description: String
)

data class Memory(val name: String, val address: String)

class AsmLanguageSpec {
    fun findOpcode(mnemonic: String) =
        opcodes.find {
            it.mnemonic == mnemonic
        }

    fun findMemory(address: String) =
        memory.find {
            it.address == address
        }

    val opcodes: ArrayList<Opcode> = arrayListOf()
    val memory: ArrayList<Memory> = arrayListOf()

    init {
        val data = JDOMUtil.load(this.javaClass.getResourceAsStream("/data.xml"))

        for (child in data.getChild("opcodes").children) {
            opcodes.add(
                Opcode(
                    child.getAttributeValue("mnemonic"),
                    child.getAttributeValue("name"),
                    child.getChildTextTrim("description")
                )
            )
        }

        for (child in data.getChild("memory").children) {
            memory.add(Memory(child.getAttributeValue("name"), child.getAttributeValue("address")))
        }
    }

    companion object {
        val INSTANCE = AsmLanguageSpec()
    }
}