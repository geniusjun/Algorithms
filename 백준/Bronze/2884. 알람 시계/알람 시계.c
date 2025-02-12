#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
    int hours = 0;
    int minutes = 0;

    scanf("%d %d", &hours, &minutes);

    if (minutes >= 45 && hours != 0)
    {
        minutes -= 45;
    }
    else if (minutes < 45 && hours != 0)
    {
        hours -= 1;
        minutes = 60 + (minutes - 45);
    }
    else if (hours == 0 && minutes < 45)
    {
        hours = 23;
        minutes = 60 + (minutes - 45);
    }
    else if (hours == 0 && minutes >= 45)
    {
        minutes -= 45;
    }


    printf("%d %d", hours, minutes);

    return 0;
}