/****************************************************\
 *Filename:      travel.c                            *
 *Created By:    Yakubu Nazif Wanka                  *
 *Email:         yakubu1@umbc.edu                    *
 *Date Created:  09/24/08                            *
 *Last Modified: 10/01/08                            *
 *Purpose: Contains the functions of defenitions to  *
 *be used in the program travel.c.                   *
\*****************************************************/

#include<stdio.h>
#include<stdlib.h>
#include"util.h"
#include"travel.h"

#define  POUND      1.85369
#define  SWEDISH    0.15280
#define  EURO       1.47343
#define  RUBLE      0.03997

#define LONDON     -5
#define STOCKHOLM  -6
#define TAMPERE    -7 
#define HELSINKI   -7
#define STALINGRAD -8

void ConvertCurrency (void)
{
   int choice1;
   float units, conv;
   double dollar;
   DisplayLocationsMenu();
   printf("\n\nYour Location ? \n");
   /*Gets the location from the user*/
   choice1 = GetValidInt(1, 5);
   switch (choice1)
   {
      case 1:
	 conv = POUND;
	 printf("\nHow many pounds ? ");
	 scanf("%f", &units);
	 break;
      case 2:
	 conv = SWEDISH;
	 printf("\nHow many kronors ? ");
	 scanf("%f", &units);
	 break;
      case 3:
	 conv = EURO;
	 printf("\nHow many Euros ? ");
	 scanf("%f", &units);
	 break;
      case 4:
	 conv = EURO;
	 printf("\nHow many Euros ? ");
	 scanf("%f", &units);
	 break;
     default:
	 conv = RUBLE;
	 printf("\nHow many rubles ? ");
	 scanf("%f", &units);
	 break;
   }
   /*Converts the units entered into dollars based on location*/
   dollar =  ForeignToDollars (units, conv);
   switch(choice1)
   {
      case 1:
	 printf("\n%.2f pounds is $%.2f\n", units, dollar);
	 break;
      case 2:
	 printf("\n%.2f kronors is $%.2f\n", units, dollar);
	 break;
      case 3:
	 printf("\n%.2f euros is $%.2f\n", units, dollar);
	 break;
      case 4:
	 printf("\n%.2f euros is $%.2f\n", units, dollar);
	 break;
      default:
	 printf("\n%.2f rubles is $%.2f\n", units, dollar);
	 break;
   }

   return;
}

void ConvertTime (void)
{
   int hours, minutes, converttime2, adjustment;
   DisplayLocationsMenu();
   printf("\n\nYour Location?\n");
   /*Gets the location of the User*/
   adjustment = GetValidInt(1, 5);
   /*Gets the time from the user*/
   printf("\n\nWhat time is it?\n");
   printf("hour ?\n");
   hours = GetValidInt(0, 23);
   printf("minutes ?\n");
   minutes = GetValidInt(0, 59);
   /*chooses adjustment based on location, and prints the time*/
   switch(adjustment)
   {
      case 1:
         adjustment = LONDON;
	 printf("\n%d:%d  London time is ", hours, minutes);
	 converttime2 = ForeignTimeToEastern(hours, adjustment);
	 PrintAMPMForm(converttime2, minutes);
         break;
      case 2:
         adjustment = STOCKHOLM;
	 printf("\n%d:%d Stockholm time is ", hours, minutes);
	 converttime2 = ForeignTimeToEastern(hours, adjustment);
         PrintAMPMForm(converttime2, minutes);
	 break;
      case 3:
         adjustment = TAMPERE;
	 printf("\n%d:%d Tampere time is ", hours, minutes);
	 converttime2 = ForeignTimeToEastern(hours, adjustment);
	 PrintAMPMForm(converttime2, minutes);
         break;
      case 4:
         adjustment =  HELSINKI;
	 printf("\n%d:%d Helsinki time is ", hours, minutes);
	 converttime2 = ForeignTimeToEastern(hours, adjustment);
         PrintAMPMForm(converttime2, minutes);
	 break;
      default:
         adjustment =  STALINGRAD;
	 printf("\n%d:%d St. Petersburg time is ", hours, minutes);
	 converttime2 = ForeignTimeToEastern(hours, adjustment);
         PrintAMPMForm(converttime2, minutes);
	 break;
   }
   
   return;
}

void DisplayLocationsMenu (void)
{
   printf("\nWhere are you?\n");
   printf("\n        1 - London\n");
   printf("\n        2 - Stockholm\n");
   printf("\n        3 - Tampere\n");
   printf("\n        4 - Helsinki\n");
   printf("\n        5 - St. Petersburg\n");
   
   return;
}
void DisplayMainMenu (void)
{
   printf("\n\n        1 - Convert Time\n");
   printf("\n        2 - Convert Currency\n");
   printf("\n        3 - Convert Temperature\n");
   printf("\n        4 - Quit\n\n");
   printf("\nYour Choice ?\n");
   
   return;
}

void PrintGreeting (void)
{
   printf("\n*    Hello and Welcome to World Traveler!    *\n");
   printf("\nThis program will help you convert     \n");
   printf("Currency, Time and Temperature into     \n");
   printf("US Dollars, 12 hour format and Fahrenheit.\n");

   return;
} 

void ConvertTemp (void)
{
   int fahrenheit;
   int celsius;
   /*Gets the temperature in celsius then converts to fahrenheit*/
   printf("Enter the temperature in celsius: ");
   scanf("%d", &celsius);
   fahrenheit = CelsiusToFahrenheit(celsius);
   printf("\nThe temperature in fahrenheit is %2d fahrenheit\n", fahrenheit);

   return;
}
