#include <stdio.h>

// Function to calculate LRC
unsigned char calculateLRC(unsigned char *data, int length)
{
    unsigned char lrc = 0;
    for (int i = 0; i < length; i++)
    {
        lrc += data[i];
    }
    // Take the one's complement of the sum
    lrc = (~lrc) + 1;
    return lrc;
}

// Function to print a byte in binary format
void printBinary(unsigned char byte)
{
    for (int i = 7; i >= 0; i--)
    {
        printf("%d", (byte >> i) & 1);
    }
}

int main()
{
    // Example data to be sent (replace this with your actual data)
    unsigned char dataToSend[] = {0x41, 0x42, 0x43, 0x44}; // "ABCD" in ASCII
    int dataLength = sizeof(dataToSend) / sizeof(dataToSend[0]);

    // Calculate LRC for the data
    unsigned char lrc = calculateLRC(dataToSend, dataLength);

    // Append LRC to the data
    dataToSend[dataLength] = lrc;

    // Display the data with appended LRC in binary format
    printf("Data with appended LRC (in binary):\n");
    for (int i = 0; i < dataLength + 1; i++)
    {
        printBinary(dataToSend[i]);
        printf(" ");
    }
    printf("\n");

    return 0;
}