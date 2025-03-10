#include <stdio.h>
#include <string.h>

int main()
{
    char s[1000], c;
    int i, count = 0;

    printf("Enter the string: ");
    // Use fgets instead of gets
    fgets(s, sizeof(s), stdin);

    // Remove the newline character if present
    if ((strlen(s) > 0) && (s[strlen(s) - 1] == '\n'))
    {
        s[strlen(s) - 1] = '\0';
    }

    printf("Enter character to be searched: ");
    // Using getchar to read the character to search
    c = getchar();

    // Count the occurrences of the character
    for (i = 0; s[i]; i++)
    {
        if (s[i] == c)
        {
            count++;
        }
    }

    printf("Character '%c' occurs %d times\n", c, count);

    return 0;
}
