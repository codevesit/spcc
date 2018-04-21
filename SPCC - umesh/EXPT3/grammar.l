%{
#include<stdio.h>
#include<stdlib.h>
int adv = 0, adj = 0, verb = 0;
%}
%%
(easily) adv++;
(lazy) adj++;
(runs) verb++;
%%
int main()
{
printf("Enter a string\n");
yylex();
printf("adjective count = %d\nadverb count = %d\nverb count = %d",adj,adv,verb);
} 
