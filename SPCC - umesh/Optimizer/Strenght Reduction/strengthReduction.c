#include<stdio.h>
void printStmt(char c,char s,int loop)
{
    int i = 0;
    for(i=0;i<loop;i++)
        {
            if(i==(loop-1))
            {
                printf("%c",c);
            }
            else
            {
                printf("%c%c",c,s);
            }
        }
}
void main()
{
    int input2,i;
    char sign,input1;
    float convert;
    printf("Enter code in form of arg sign arg\n");
    scanf("%c",&input1);
    scanf("%c",&sign);
    scanf("%d",&input2);
    if(sign == '^')
    {
        printStmt(input1,'*',input2);
    }
    else if(sign == '*')
    {
        printStmt(input1,'+',input2);
    }
    else if(sign == '/')
    {
        convert = (float) (1/(float) input2);
        printf("%c*%f",input1,convert);
    }
}
