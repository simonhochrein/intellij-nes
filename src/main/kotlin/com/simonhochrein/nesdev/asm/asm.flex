package com.simonhochrein.nesdev.asm;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.simonhochrein.nesdev.asm.psi.AsmTypes;
import com.intellij.psi.TokenType;

%%

%class AsmLexer
%implements FlexLexer
%unicode
%caseless
%function advance
%type IElementType
%eof{  return;
%eof}

EOL=\R
MNEMONIC=(
    "adc" | "and" | "asl" | "bcc" | "bcs" | "beq" | "bit" | "bmi" | "bne" | "bpl" | "brk" | "bvc" | "bvs" | "clc" |
    "cld" | "cli" | "clv" | "cmp" | "cpx" | "cpy" | "dec" | "dex" | "dey" | "eor" | "inc" | "inx" | "iny" | "jmp" |
    "jsr" | "lda" | "ldx" | "ldy" | "lsr" | "nop" | "ora" | "pha" | "php" | "pla" | "plp" | "rol" | "ror" | "rti" |
    "rts" | "sbc" | "sec" | "sed" | "sei" | "sta" | "stx" | "sty" | "tax" | "tay" | "tsx" | "txa" | "txs" | "tya"
)
IDENTIFIER=[a-zA-Z_][a-zA-Z_0-9]*
WHITE_SPACE=[\ \t\f]

STRING=("\""[^\"]*"\"")+

HEX_NUMBER=\$[a-fA-F0-9]+
DEC_NUMBER=[0-9]+
BIN_NUMBER=%[01]+

%%

{EOL}            { return AsmTypes.EOL; }
":"              { return AsmTypes.COLON; }
"@"              { return AsmTypes.AT; }
"#"              { return AsmTypes.HASH; }
"."              { return AsmTypes.DOT; }
","              { return AsmTypes.COMMA; }
"="              { return AsmTypes.EQUAL; }
(":-"|":+")      { return AsmTypes.UNNAMED_LABEL; }
{STRING}         { return AsmTypes.STRING; }

{HEX_NUMBER}     { return AsmTypes.HEX_NUMBER; }
{DEC_NUMBER}     { return AsmTypes.DEC_NUMBER; }
{BIN_NUMBER}     { return AsmTypes.BIN_NUMBER; }

{MNEMONIC}       { return AsmTypes.MNEMONIC; }
{IDENTIFIER}     { return AsmTypes.IDENTIFIER; }

{WHITE_SPACE}+   { return TokenType.WHITE_SPACE; }

";"[^\r\n]*      { return AsmTypes.COMMENT; }

[^]              { return TokenType.BAD_CHARACTER; }