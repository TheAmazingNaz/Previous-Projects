/******************************************************
 ** File: proj3helper.c
 ** Author: Ryan Bergeron
 ** Date: 10-17-2008
 ** email: rberge1@umbc.edu
 **
 ** Purpose: Contains the function definitions used in
 **          project 3.
 ******************************************************/

#include "proj3helper.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**************************************************
 ** Function: Create Address() - breaks the website 
 **           into an ADDRESS based on . positions
 **           in the string.
 ** Inputs: webaddress - a website as a string
 ** Outputs:  an ADDRESS structure
 **************************************************/

ADDRESS CreateAddress(char webaddress[])
{
   ADDRESS site;
   int i = 0;
   int member = 0;
   int index = 0;

   /* traverse the entire string stopping at null terminator */
   while(webaddress[i] != '\0')
   {

     /* token we wish to break the string apart about */
      if(webaddress[i] == '.')
      {
	 /* null terminates each member of address */
	 /* this makes a char array a string */
	 switch(member)
	 {
	    case 0:
	       site.accessCode[index] ='\0';
	       break;
	    case 1:
	       site.domainName[index] ='\0';
	       break;
	 }
	 member++;
	 i++;
	 index = 0;
      }
      else
      {
	/* assembles the char arrays in our address */
	/* based on where we are between the websites . position */
	 switch(member)
	 {
            /* accessCode  */
	    case 0:
	       site.accessCode[index] = webaddress[i];
	       break;
	    /* domainName */
	    case 1:
	       site.domainName[index] = webaddress[i];
	       break;
	    case 2:
	       site.domainEnding[index] = webaddress[i];
	       break;
	 }
	 i++;
	 index++;
      }
   }
   /* finish the domain ending string */
   site.domainEnding[index] ='\0';

    return site;
}
