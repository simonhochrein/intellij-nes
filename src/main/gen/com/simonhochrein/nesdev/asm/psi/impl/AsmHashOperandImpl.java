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

public class AsmHashOperandImpl extends ASTWrapperPsiElement implements AsmHashOperand {

  public AsmHashOperandImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsmVisitor visitor) {
    visitor.visitHashOperand(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsmVisitor) accept((AsmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsmNumber getNumber() {
    return findChildByClass(AsmNumber.class);
  }

  @Override
  @Nullable
  public AsmRef getRef() {
    return findChildByClass(AsmRef.class);
  }

}
