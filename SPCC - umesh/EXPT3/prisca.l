%{
#include<stdio.h>
#include<stdlib.h>
int p = 0, s = 0;
%}
%%
(printf) p++;
(scanf) s++;
%%
int main()
{
printf("Enter a string\n");
yylex();
printf("printf count = %d\nscanf count = %d",p,s);
}
