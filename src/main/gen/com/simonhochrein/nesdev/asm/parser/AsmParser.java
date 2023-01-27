// This is a generated file. Not intended for manual editing.
package com.simonhochrein.nesdev.asm.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.simonhochrein.nesdev.asm.psi.AsmTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AsmParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return asmFile(b, l + 1);
  }

  /* ********************************************************** */
  // (line_ EOL)* line_?
  static boolean asmFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = asmFile_0(b, l + 1);
    r = r && asmFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (line_ EOL)*
  private static boolean asmFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!asmFile_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "asmFile_0", c)) break;
    }
    return true;
  }

  // line_ EOL
  private static boolean asmFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmFile_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = line_(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // line_?
  private static boolean asmFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmFile_1")) return false;
    line_(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // constant EQUAL expr
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constant(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && expr(b, l + 1);
    exit_section_(b, m, ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // assignment
  static boolean assignment_line(PsiBuilder b, int l) {
    return assignment(b, l + 1);
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // DOT IDENTIFIER
  public static boolean directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, DIRECTIVE, r);
    return r;
  }

  /* ********************************************************** */
  // label? directive expressions
  static boolean directive_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_line")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directive_line_0(b, l + 1);
    r = r && directive(b, l + 1);
    r = r && expressions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // label?
  private static boolean directive_line_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_line_0")) return false;
    label(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // number
  //     | ref
  //     | STRING
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = number(b, l + 1);
    if (!r) r = ref(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr (COMMA expr)*
  static boolean expressions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && expressions_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expr)*
  private static boolean expressions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expressions_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expressions_1", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean expressions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HASH (number | ref | STRING)
  public static boolean hash_operand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hash_operand")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASH);
    r = r && hash_operand_1(b, l + 1);
    exit_section_(b, m, HASH_OPERAND, r);
    return r;
  }

  // number | ref | STRING
  private static boolean hash_operand_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hash_operand_1")) return false;
    boolean r;
    r = number(b, l + 1);
    if (!r) r = ref(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  /* ********************************************************** */
  // label? opcode operand?
  static boolean instruction_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_line")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = instruction_line_0(b, l + 1);
    r = r && opcode(b, l + 1);
    r = r && instruction_line_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // label?
  private static boolean instruction_line_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_line_0")) return false;
    label(b, l + 1);
    return true;
  }

  // operand?
  private static boolean instruction_line_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_line_2")) return false;
    operand(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // AT? IDENTIFIER? COLON
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABEL, "<label>");
    r = label_0(b, l + 1);
    r = r && label_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AT?
  private static boolean label_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label_0")) return false;
    consumeToken(b, AT);
    return true;
  }

  // IDENTIFIER?
  private static boolean label_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label_1")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // (instruction_line | assignment_line | directive_line | only_label_line)? COMMENT?
  static boolean line_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = line__0(b, l + 1);
    p = r; // pin = 1
    r = r && line__1(b, l + 1);
    exit_section_(b, l, m, r, p, AsmParser::line_recover);
    return r || p;
  }

  // (instruction_line | assignment_line | directive_line | only_label_line)?
  private static boolean line__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line__0")) return false;
    line__0_0(b, l + 1);
    return true;
  }

  // instruction_line | assignment_line | directive_line | only_label_line
  private static boolean line__0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line__0_0")) return false;
    boolean r;
    r = instruction_line(b, l + 1);
    if (!r) r = assignment_line(b, l + 1);
    if (!r) r = directive_line(b, l + 1);
    if (!r) r = only_label_line(b, l + 1);
    return r;
  }

  // COMMENT?
  private static boolean line__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line__1")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // !EOL
  static boolean line_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, EOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // HEX_NUMBER | DEC_NUMBER | BIN_NUMBER
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, HEX_NUMBER);
    if (!r) r = consumeToken(b, DEC_NUMBER);
    if (!r) r = consumeToken(b, BIN_NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // label
  public static boolean only_label_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "only_label_line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ONLY_LABEL_LINE, "<only label line>");
    r = label(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MNEMONIC
  public static boolean opcode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "opcode")) return false;
    if (!nextTokenIs(b, MNEMONIC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MNEMONIC);
    exit_section_(b, m, OPCODE, r);
    return r;
  }

  /* ********************************************************** */
  // hash_operand
  //     | UNNAMED_LABEL
  //     | expr (COMMA IDENTIFIER)?
  public static boolean operand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operand")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERAND, "<operand>");
    r = hash_operand(b, l + 1);
    if (!r) r = consumeToken(b, UNNAMED_LABEL);
    if (!r) r = operand_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expr (COMMA IDENTIFIER)?
  private static boolean operand_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operand_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && operand_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA IDENTIFIER)?
  private static boolean operand_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operand_2_1")) return false;
    operand_2_1_0(b, l + 1);
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean operand_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operand_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ref")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, REF, r);
    return r;
  }

}
