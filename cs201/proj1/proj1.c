/*********************************************************************************
 ** File:          Proj1.c
 ** Author:        Yakubu Nazif Wanka
 ** Created:       09/27/2008
 ** Last Modified: 10/01/2008
 **
 **   This file contains the main driver program for project 4.
 ** This program takes the Foreign currency, Foreign Time, or Foreign temperature,
 ** converts them to local values(Dollars, 12-hour-format, and Fahrenheit then
 ** displays the results in the format specified in the project description.
 **
 ** Other files required are
 **      1. travel.h -- prototypes for the functions useful to Project 1 only
 **      2. util.h -- prototypes for functions that can be reused after Project 1
 **
 *********************************************************************************/
#include<stdio.h>
#include "travel.h"
#include "util.h"
int main()
{
   int input;
   PrintGreeting();
   /*Unless 4 is selected, restart program Does this work?*/
   do
   {
      DisplayMainMenu();
      input =  GetValidInt(1, 4);
      /*Main Menu Options select*/
      switch (input)
      {
         case 1:
            ConvertTime();
            break;
         case 2:
            ConvertCurrency();
            break;
         case 3:
            ConvertTemp();
            break;
         default:
            break;
      }
   }while(input !=4);

   return 0;
}
