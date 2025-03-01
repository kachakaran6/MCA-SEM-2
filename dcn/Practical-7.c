#include <stdio.h>
int countSetBits(int n)
{
    int count = 0;
    while (n > 0)
    {
        if (n % 2 == 1)
        {
            count++;
        }
        n = n / 2;
    }
    return count;
}
int main()
{
    int num;
    printf("Enter an integer: ");
    scanf("%d", &num);

    int result = countSetBits(num);
    printf("Number of set bits in %d: %d\n", num, result);
    return 0;
}
