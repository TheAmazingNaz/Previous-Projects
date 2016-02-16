/*****************************************
 ** File: proj4.c
 ** Author: Yakubu Nazif Wanka
 ** Date: 11/23/08
 ** Section: 101
 ** E-mail: yakubu1@umbc.edu
 **
 **       This file contains the main driver
 ** program for project 4. This file asks the
 ** user for a series of choices using whhich
 ** The user may encrypt or decrypt both files
 ** and or strings or just Print a character
 ** key table
 **
 ** Other files required are:
 **      1. datasecurity.h
 **      2. datasecurity.h
 *****************************************/

#include<stdio.h>
#include<stdlib.h>

#include "datasecurity.h"

int main()
{
  char *choice;
  choice = (char *) malloc(CHOICESIZE * sizeof(char)) ;
  PrintMenu();
  while(fscanf(stdin, "%s", choice) != '\n')
  {
    switch(choice[0])
      {
      case 'P':
	PrintKeyTable();
	break;
      case 'p':
	PrintKeyTable();
	break;
      case'F':
	FileInterface();
	break;
      case 'f':
	FileInterface();
	break;
      case 'S':
	StringInterface();
	break;
      case 's':
	StringInterface();
      case 'Q':
	return 0;
	break;
      case 'q':
	return 0;
	break;
      default:
	break;
      }
    PrintMenu();
    }
  return 0;
}
