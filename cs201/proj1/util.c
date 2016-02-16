#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include"util.h"

/*******************************************************************
 ** File:          Util.c                                          
 ** Author         Yakubu Nazif Wanka                             
 ** Date Created:  09/21/2008                                      
 ** Last Modified: 11/9/2008                                         
 ** Section:       101
 ** E-mail:        yakubu1@umbc.edu
 **
 ** This file contains the function definitions of functions deemed
 ** to be of general usefulness to the user.
 *******************************************************************/


/**********************************************************
 ** Function: GetValidInt()
 ** GetValidInt() gets an integer from the user between
 ** specified minimum and maximum values, and will
 ** reprompt the user until it gets one that is valid.
 **                                                  
 ** Inputs: min and max, the minimum. and maximum      
 **          (inclusive) values for the entered integer 
 ** Output: returns an integer between min and max,  
 **          inclusively                              
 **********************************************************/    
int GetValidInt (int min, int max)
{
   /* is set greater than max so the loop will be entered*/
   int input = max + 1;

   /* Loop assures valid input */
   while( input < min || input > max )
   {
      printf("Please enter an integer between");
      printf(" %d and %d : ", min, max);
      scanf("%d", &input);
   }

   return input;
}

/*********************************************************
 ** Function: GetRandomNumber
 ** Usage:    x = GetRandomNumber();
 **
 ** GetRandomNumber() returns a pseudo-random integer
 ** between the values passed into the function: low and 
 ** high, inclusive.
 **
 ** Inputs: low - an int which is the lowest value 
 **         in the range of acceptable random numbers
 **         high - an int which is the highest value
 **         in the range of acceptable random numbers
 ** Output: returns a random integer between low and 
 **         high, inclusive
 *********************************************************/
int GetRandomNumber (int low, int high) 
{
   int num ;

   /* Call rand() to get a large random number. */
   num = rand() ;

   /* Scale the random number within range. */
   num = num % (high - low + 1) + low ;

   return num ;
}

/********************************************************
 ** Function: SetRandomSeed
 ** Usage:    SetRandomSeed();
 **
 ** The pseudo-random number generator is seeded
 ** with a call to time() assuring a different
 ** seed everytime the program runs.
 **
 ** Inputs: None
 ** Output: No value is returned
 *********************************************************/
void SetRandomSeed (void) 
{
   int timeSeed ;

   /* Use the time function to set the seed. */
   timeSeed = (int) time(0) ;
   srand(timeSeed) ;
}

/***********************************************************
 ** Function: CesiusToFahrenheit
 ** Usage:    x = CelsiusToFahrenheit(double celsius);
 **
 ** This function converts any tempereature in celsius into
 ** fahrenheit.
 **
 ** Input: Temperature in celsius
 ** Output: Temperature in Fahrenheit
 ***********************************************************/
double CelsiusToFahrenheit(double celsius)
{
   double fahrenheit1;

   fahrenheit1 = 9.0/5 * celsius + 32;

   return fahrenheit1;
}

/*****************************************************************
 ** Function: ForeignTimeToEastern
 ** Usage:    x = ForeignTimeToEastern(int hour, int adjustment);
 **
 ** This function converts any foreign time(24 hour format)
 ** to local time(24 hour format).
 **
 ** Inputs: Foreign Time, and Time difference
 ** Output: Local Time
 ****************************************************************/
int ForeignTimeToEastern(int hour, int adjustment)
{
   int converttime;

   converttime = hour+adjustment;
   /*If adjustment produces a negative number, then add 24 hours to it*/
   if(converttime<0)
   {
      converttime=+24;
   }
   return converttime;
}

/******************************************************************
 ** Function: ForeignToDollars
 ** Usage:    x = ForeignToDollars(float units, float conv);
 **
 ** This function converts foreign currency to dollars.
 **
 ** Inputs: The amount of foreign currency and the exchange rate
 ** Output: The amount in dollars
 *******************************************************************/
float ForeignToDollars (float units, float conv)
{
   float dollar;
   dollar = units * conv;
   return dollar;
}

/*******************************************************************************************************
 ** Function: PrintAMPMForm
 ** Usage: x = PrintAMPMForm(int hour, int minutes);
 ** 
 ** This funtion converts time in 24 hour format to 12 hour format.
 **
 ** Inputs: Time in 24 hours and minutes
 ** Output: 12 hour time hours and minutes
 *******************************************************************************************************/ 
void PrintAMPMForm(int hour, int minutes)
{
   int amhour;
   /*If the time is greater than 12 then, 12 should be subtracted to make it PM. If not then it is AM*/
   if(hour>12)
   {
      amhour = hour - 12;
      printf("%d:%d PM Eastern Time\n", amhour, minutes);
   }
   else
   {
      amhour = hour;
      printf("%d:%d AM Eastern Time\n", amhour, minutes);
   }

   return;
}
