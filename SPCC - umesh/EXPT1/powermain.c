#include<stdio.h>
#include<powershare.h>
int main(){
	int b,e,ans;
	printf("Enter the base\n");
	scanf("%d",&b);
	printf("Enter the exponent\n");
	scanf("%d",&e);
	ans=power(b,e);
	printf("Result is %d",ans);
	return 1;
}
