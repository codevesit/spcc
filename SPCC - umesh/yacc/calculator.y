%{
	#include <stdio.h>
	#include <stdlib.h>
%}
%start lines
%token NUMBER
%token PLUS MINUS TIMES DIVIDE POWER
%token LEFT_PARENTHESIS RIGHT_PARENTHESIS
%token END
%left PLUS MINUS
%left TIMES DIVIDE
%right POWER
%%
lines: /* empty */
| lines line /* do nothing */
line: exp END { printf("found exp END\n"); printf("The output is %d quick maths",$1); }
;
exp : term { printf("found term\n");$$=$1; }
| exp PLUS term { printf("found exp PLUS term\n");$$=$1+$3; }
| exp MINUS term { printf("found exp MINUS term\n");$$=$1-$3; }
;
term : factor { printf("found factor\n");$$=$1; }
| term TIMES factor { printf("found term TIMES factor\n");$$=$1*$3; }
| term DIVIDE factor { printf("found term DIVIDE factor\n");$$=$1/$3; }
;
factor : NUMBER { printf("found NUMBER %d\n", yylval);$$=yylval; }
| LEFT_PARENTHESIS exp RIGHT_PARENTHESIS
{ printf("found PARENS exp\n"); }
;
%%
int main (void) {
	return yyparse ( );
}
int yyerror (char *s) {
	fprintf (stderr, "%s\n", s);
}
