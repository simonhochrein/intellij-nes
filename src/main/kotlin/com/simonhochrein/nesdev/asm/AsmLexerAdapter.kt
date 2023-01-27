package com.simonhochrein.nesdev.asm

import com.intellij.lexer.FlexAdapter

class AsmLexerAdapter: FlexAdapter(AsmLexer(null))