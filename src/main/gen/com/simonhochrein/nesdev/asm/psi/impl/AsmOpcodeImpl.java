// This is a generated file. Not intended for manual editing.
package com.simonhochrein.nesdev.asm.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.simonhochrein.nesdev.asm.psi.AsmTypes.*;
import com.simonhochrein.nesdev.asm.psi.*;

public class AsmOpcodeImpl extends AsmNamedElementImpl implements AsmOpcode {

  public AsmOpcodeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsmVisitor visitor) {
    visitor.visitOpcode(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsmVisitor) accept((AsmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public String getName() {
    return AsmPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String newName) {
    return AsmPsiImplUtil.setName(this, newName);
  }

  @Override
  @NotNull
  public PsiElement getNameIdentifier() {
    return AsmPsiImplUtil.getNameIdentifier(this);
  }

}
