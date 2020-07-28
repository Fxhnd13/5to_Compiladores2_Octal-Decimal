package Analizadores;

import java_cup.runtime.Symbol;

%%

%class Lexer
%public
%cup
%line
%column

/* special chars */
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]+

/* integer literals */
OctalLiteral = [0-7]

%{
    private boolean error = false;

    private Symbol symbol(int type) {
        String lexeme = yytext();
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1, type));
    }

    private Symbol symbol(int type, String lexeme) {
        tokens.add(new Token(lexeme, yyline+1, yycolumn+1, type));
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1, type));
    }

    private void error(String lexeme) {
        error = true;
        System.out.Println("No se ingreso un número octal");
    }
    
    public boolean getError(){
        return error;
    }
%}

%%

/* reglas lexicas */
<YYINITIAL> {

    {OctalLiteral}                  {   return symbol(OCTAL);}

}

/* error fallback */
[^]                              {   error(yytext());    }
