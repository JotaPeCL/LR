import ASI.Analisis;
import java.io.*;
import static ASI.Tokens.*;


%%
%class Lexer
%type Tokens
%line
%column
L=[a-zA-Z_]+
D=-?[0-9]+|-?(([0-9]+[.]?[0-9]*)|([.][0-9]+))(e[+-]?[0-9]+)?
CA=\"(\\.|[^\"])*\"
CAR='([^'\\]|\\\\[btnfr"'\\"\\\\])'
espacio=[ ]+
espa=[\t]+
esp=[\r]+
salto=[\n]
%{
    public String lexeme;
Analisis c=new Analisis();
int estado = 0;
int nu=0;
%}
%%


"//" .* { /* Ignore */ }
"/*" [^*] ~"*/" | "/*" "*"+ "/" { /* Ignore */ }
{espacio} {/*Ignore*/}
{espa} {/*Ignore*/}
{esp} {/*Ignore*/}
{salto} {/*Ignore*/}
<YYINITIAL> "int" {c.linea=yyline; lexeme=yytext();return ent;}
<YYINITIAL> "float" {c.linea=yyline; lexeme=yytext();return flot;}
<YYINITIAL> "char" {c.linea=yyline; lexeme=yytext();return car;}
<YYINITIAL> "cad" {c.linea=yyline; lexeme=yytext();return cad;}
<YYINITIAL> ";" {c.linea=yyline; lexeme=yytext();return  punto_coma;}
<YYINITIAL> "." {c.linea=yyline; lexeme=yytext();return punto;}
<YYINITIAL> "," {c.linea=yyline; lexeme=yytext();return coma;}
<YYINITIAL> "(" {c.linea=yyline; lexeme=yytext();return parentesis_abre;}
<YYINITIAL> ")" {c.linea=yyline; lexeme=yytext();return parentesis_cierra;}
<YYINITIAL> "=" {c.linea=yyline; lexeme=yytext();return igual;}
<YYINITIAL> "+" {c.linea=yyline; lexeme=yytext();return mas;}
<YYINITIAL> "-" {c.linea=yyline; lexeme=yytext();return menos;}
<YYINITIAL> "/" {c.linea=yyline; lexeme=yytext();return division;}
<YYINITIAL> "*" {c.linea=yyline; lexeme=yytext();return multiplicacion;}
<YYINITIAL> {D} {c.linea=yyline; lexeme=yytext();return Numero;}
<YYINITIAL> {CA}+ {c.linea=yyline; lexeme=yytext();return cadena;}
<YYINITIAL> {CAR}+ {c.linea=yyline; lexeme=yytext();return caracter;}
<YYINITIAL> {L}({L}{D})* {c.linea = yyline;lexeme = yytext();return ID;}
. {c.linea=yyline; lexeme=yytext();return Error;}

