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
import com.intellij.navigation.ItemPresentation;

public class AsmConstantImpl extends AsmNamedElementImpl implements AsmConstant {

  public AsmConstantImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsmVisitor visitor) {
    visitor.visitConstant(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsmVisitor) accept((AsmVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public String getIdentifier() {
    return AsmPsiImplUtil.getIdentifier(this);
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
  @Nullable
  public PsiElement getNameIdentifier() {
    return AsmPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return AsmPsiImplUtil.getPresentation(this);
  }

}
