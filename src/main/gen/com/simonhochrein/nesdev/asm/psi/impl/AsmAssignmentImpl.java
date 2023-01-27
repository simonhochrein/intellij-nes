// This is a generated file. Not intended for manual editing.
package com.simonhochrein.nesdev.asm.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.simonhochrein.nesdev.asm.psi.AsmTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.simonhochrein.nesdev.asm.psi.*;

public class AsmAssignmentImpl extends ASTWrapperPsiElement implements AsmAssignment {

  public AsmAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsmVisitor visitor) {
    visitor.visitAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsmVisitor) accept((AsmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AsmConstant getConstant() {
    return findNotNullChildByClass(AsmConstant.class);
  }

  @Override
  @NotNull
  public AsmExpr getExpr() {
    return findNotNullChildByClass(AsmExpr.class);
  }

}
