// This is a generated file. Not intended for manual editing.
package com.simonhochrein.nesdev.asm.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.simonhochrein.nesdev.asm.psi.impl.AsmNamedElement;

public class AsmVisitor extends PsiElementVisitor {

  public void visitAssignment(@NotNull AsmAssignment o) {
    visitPsiElement(o);
  }

  public void visitConstant(@NotNull AsmConstant o) {
    visitNamedElement(o);
  }

  public void visitDirective(@NotNull AsmDirective o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull AsmExpr o) {
    visitPsiElement(o);
  }

  public void visitHashOperand(@NotNull AsmHashOperand o) {
    visitPsiElement(o);
  }

  public void visitLabel(@NotNull AsmLabel o) {
    visitNamedElement(o);
  }

  public void visitNumber(@NotNull AsmNumber o) {
    visitPsiElement(o);
  }

  public void visitOnlyLabelLine(@NotNull AsmOnlyLabelLine o) {
    visitPsiElement(o);
  }

  public void visitOpcode(@NotNull AsmOpcode o) {
    visitNamedElement(o);
  }

  public void visitOperand(@NotNull AsmOperand o) {
    visitPsiElement(o);
  }

  public void visitRef(@NotNull AsmRef o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull AsmNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
