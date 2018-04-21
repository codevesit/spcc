#include<stdio.h>
#include"factshare.h"
int main()
{
	int n, res;
	printf("Enter the number: ");
	scanf("%d",&n);
	res = factorial(n);
	printf("The factorial of %d is %d\n",n,res);
}
