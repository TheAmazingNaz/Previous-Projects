/******************************************************
 ** File: proj3helper.h
 ** Author: Ryan Bergeron
 ** Date: 10-17-2008
 ** email: rberge1@umbc.edu
 **
 ** Purpose: Contains the function protoypes used in
 **          project 3.
 ******************************************************/
#ifndef _PROJ3_HELPER_H_
#define _PROJ3_HELPER_H_

#define MAX_ACCESS_CODE_SIZE 15
#define MAX_DOMAIN_SIZE 30
#define MAX_DOMAIN_ENDING_SIZE 4
#define MAX_SITE_TYPE_SIZE 10
#define MAX_NUMBER_WEBSITES 100

typedef struct address
{
   char accessCode[MAX_ACCESS_CODE_SIZE];
   char domainName[MAX_DOMAIN_SIZE];
   char domainEnding[MAX_DOMAIN_ENDING_SIZE];
}ADDRESS;

ADDRESS CreateAddress(char webaddress[]);

#endif
