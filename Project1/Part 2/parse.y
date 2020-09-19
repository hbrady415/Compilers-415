%{
#include <stdio.h>
int yylex();
void yyerror(char* s);
%}

// Says that a possible data type to use is an int called "bool_val"
%union{
int bool_val;
}

// These are the tokens
%token T 
%token F

// Can now say that the type for the nonterminals is a "bool_val"
%type <bool_val> expr
%type <bool_val> expr1
%type <bool_val> expr2
%type <bool_val> expr3
%type <bool_val> expr4
%type <bool_val> const

%start program

// $$ allows us to save the result, to be used by the rules that call it
// $# allows us to access the number saved by that rule and use it
// This allows us to work our way up and print either T or F
// Note that in C booleans are just 1 or 0 and couldn't figure out how to use booleans in bison so here we are
%%
program : expr'.'	{ if($1)printf("T"); else printf("F"); }
;

expr : expr1 '|''|' expr { if($1 || $4) $$ = 1; else $$ = 0; }
    | expr1 { $$ = $1; } 
;
expr1 : expr2 '^' expr1 { if($1 ^ $3) $$ = 1; else $$ = 0; }
      | expr2 { $$ = $1; }
;

expr2 : expr3 '&''&' expr2 { if($1 && $4) $$ = 1; else $$ = 0; }
      | expr4 '&''&' expr2 { if($1 && $4) $$ = 1; else $$ = 0; } 
      | const '&''&' expr2 { if($1 && $4) $$ = 1; else $$ = 0; }
      | expr3 { $$ = $1; }
      | expr4 { $$ = $1; }
      | const { $$ = $1; }
;

expr3 : '~'const { if($2)$$ = 0; else $$ = 1; }
      | '~'expr4 { if($2)$$ = 0; else $$ = 1; }
;

expr4 : '('expr')' { $$ = $2; }
;

const : T { $$ = 1; }
      | F { $$ = 0; }
;
%%

void yyerror(char* s){
  fprintf(stderr, "%s\n",s);
}

int main(int argc, char* argv[]){
	yyparse();
	return 0;
}
