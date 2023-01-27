// This is a generated file. Not intended for manual editing.
package com.simonhochrein.nesdev.asm.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.simonhochrein.nesdev.asm.psi.impl.*;

public interface AsmTypes {

  IElementType ASSIGNMENT = new AsmElementType("ASSIGNMENT");
  IElementType CONSTANT = new AsmElementType("CONSTANT");
  IElementType DIRECTIVE = new AsmElementType("DIRECTIVE");
  IElementType EXPR = new AsmElementType("EXPR");
  IElementType LABEL = new AsmElementType("LABEL");
  IElementType NUMBER = new AsmElementType("NUMBER");
  IElementType ONLY_LABEL_LINE = new AsmElementType("ONLY_LABEL_LINE");
  IElementType OPCODE = new AsmElementType("OPCODE");
  IElementType OPERAND = new AsmElementType("OPERAND");
  IElementType REF = new AsmElementType("REF");

  IElementType AT = new AsmTokenType("AT");
  IElementType BIN_NUMBER = new AsmTokenType("BIN_NUMBER");
  IElementType COLON = new AsmTokenType("COLON");
  IElementType COMMA = new AsmTokenType("COMMA");
  IElementType COMMENT = new AsmTokenType("COMMENT");
  IElementType DEC_NUMBER = new AsmTokenType("DEC_NUMBER");
  IElementType DOT = new AsmTokenType("DOT");
  IElementType EOL = new AsmTokenType("EOL");
  IElementType EQUAL = new AsmTokenType("EQUAL");
  IElementType HASH = new AsmTokenType("HASH");
  IElementType HEX_NUMBER = new AsmTokenType("HEX_NUMBER");
  IElementType IDENTIFIER = new AsmTokenType("IDENTIFIER");
  IElementType MNEMONIC = new AsmTokenType("MNEMONIC");
  IElementType STRING = new AsmTokenType("STRING");
  IElementType UNNAMED_LABEL = new AsmTokenType("UNNAMED_LABEL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGNMENT) {
        return new AsmAssignmentImpl(node);
      }
      else if (type == CONSTANT) {
        return new AsmConstantImpl(node);
      }
      else if (type == DIRECTIVE) {
        return new AsmDirectiveImpl(node);
      }
      else if (type == EXPR) {
        return new AsmExprImpl(node);
      }
      else if (type == LABEL) {
        return new AsmLabelImpl(node);
      }
      else if (type == NUMBER) {
        return new AsmNumberImpl(node);
      }
      else if (type == ONLY_LABEL_LINE) {
        return new AsmOnlyLabelLineImpl(node);
      }
      else if (type == OPCODE) {
        return new AsmOpcodeImpl(node);
      }
      else if (type == OPERAND) {
        return new AsmOperandImpl(node);
      }
      else if (type == REF) {
        return new AsmRefImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
