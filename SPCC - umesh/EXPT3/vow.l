%{
#include<stdio.h>
#include<stdlib.h>
int vowel = 0, con = 0;
%}
%%
[aeiouAEIOU] vowel++;
[a-zA-Z] con++;
%%
int main()
{
printf("Enter a string\n");
yylex();
printf("No of vowels is %d and consonants is %d\n",vowel,con);
}
