/*******************************************************************
 ** File:    proj2.c
 ** Author:  Yakubu Nazif Wanka
 ** Date:    4/22/06
 ** Section: 0101
 ** E-mail:  yakubu1@umbc.edu
 **
 **    This file contains the main druver program for project 4. It
 ** reads the given .dat file for the amount of oil per square mile
 ** and uses that to simulate the spreading of oil over 225 square
 ** miles over a given time period at certain intervals.
 **
 **Other files required are
 **    1. oilspill.h
 **    2. util.h
 **    3. oilspill.c
 **    4. util.c
 **    5. graphicshelper.h
 **    6. graphicshelper.o
 *******************************************************************/ 

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "oilspill.h"
#include "util.h"

#define SIZE 15
#define LOW 1
#define HIGH 5

int main()
{
  /*Greets THe USer*/
  PrintGreeting();
  int time, interval, gallons[SIZE][SIZE], direction, i, j;

  /*Gets and prints the interval and the time*/
  scanf("%d", &interval);
  scanf("%d", &time);
  printf("Time interval : %d\n\n", interval);
  printf("Total Time : %d\n\n", time);
  
  /*Randomly picks a wind direction*/
  SetRandomSeed();
  direction = GetRandomNumber(LOW, HIGH);
  switch(direction)
    {
    case 1:
      printf("Wind direction: From the South\n");
      break;
    case 2:
      printf("Wind direction: From the East\n");
      break;
    case 3:
      printf("Wind direction: From the North\n");
      break;
    default:
      printf("Wind direction: From the West\n");
      break;
    }
  /*Fills the array with values from the .dat file*/       
  for(i = 0; i < SIZE; i++)
    {
      for(j = 0; j < SIZE; j++)
	{
	  scanf("%d", &gallons[i][j]);
	}
    }
  /*modifies and prints the result*/
  ChangeValue(gallons, direction, interval, time);
  return 0;
}
