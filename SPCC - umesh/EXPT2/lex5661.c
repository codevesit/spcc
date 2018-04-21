#include<stdio.h>
#include<string.h>
#include<fcntl.h>
int charcmp (char c)
{
    int i,limit=7;
    char a[100]={'+','-','*','/','%','=',','};
    for(i=0;i<limit;i++)
    {
        if(c == a[i])
            return 1;
    }
    return 0;
}
int main()
{
    FILE *fp, *r;
    int check = 0;
    int count = 0,locastr=0,ctr=0, i, j,op=0,de=0;
    char c,string[100][100], operatorarr[20], compare[3][10] = {"void","int","main"}, delimiter[10];
    fp = fopen("program.txt", "r");
    if (fp == NULL)
    {
        printf("Could not open file");
        return 0;
    }
    for (c = getc(fp); c != EOF; c = getc(fp))
    {
        if( c == '\n' || c == ' ' || c == ';' || c == '}' || c == '{' || c == '(' || c == ')')
        {
            //string[locastr][ctr]=c;
            if(ctr > 0)
            {
                locastr++;
                ctr=0;
            }
            if(c == ';' || c == '}' || c == '{' || c == '(' || c == ')')
            {
                delimiter[de++]=c;
            }


        }
        else if( charcmp(c) != 0)
        {
            operatorarr[op++]=c;
            //string[locastr][ctr]='\0';
            locastr++;
            ctr=0;
        }
        else if( c == '\0'){

        }
        else
        {
            string[locastr][ctr]=c;
            //printf("%c",string[locastr][ctr]);
            ctr++;
        }

    }
    for(i=0;i<locastr;i++)
    {
        check = 0;
        for(j=0;j<3;j++)
        {
            if(strcmp(string[i],compare[j]) == 0)
                check = 1;
        }
        //printf("key or identifier %s\n",string[i]);
        if( check == 1 )
        {
            printf("key %s\n",string[i]);
        }
        else
        {
            printf("identifier %s\n",string[i]);
        }
    }
    for(i=0;i<op;i++)
    {
        printf("operator %c\n",operatorarr[i]);
    }

    for(i=0;i<de;i++)
    {
        printf("delimiter %c\n",delimiter[i]);
    }

    // Close the file
    fclose(fp);
    printf("The file has %d lines\n ", count);

    return 0;

}
