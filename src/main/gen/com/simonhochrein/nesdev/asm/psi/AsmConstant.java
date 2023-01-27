// This is a generated file. Not intended for manual editing.
package com.simonhochrein.nesdev.asm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.simonhochrein.nesdev.asm.psi.impl.AsmNamedElement;
import com.intellij.navigation.ItemPresentation;

public interface AsmConstant extends AsmNamedElement {

  @Nullable
  String getIdentifier();

  @Nullable
  String getName();

  @NotNull
  PsiElement setName(@NotNull String newName);

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  ItemPresentation getPresentation();

}
