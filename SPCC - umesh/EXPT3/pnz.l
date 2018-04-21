%{
#include<stdio.h>
#include<stdlib.h>
%}
digit [0-9]
%%
[0] {printf("You have entered zero");}
\+?{digit}+ {printf("You have entered a positive number");}
-{digit}+ {printf("You have entered a negative number");}
%%
int main()
{
printf("Enter a number\n");
yylex();
}
