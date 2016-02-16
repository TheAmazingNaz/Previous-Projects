/************************************************************************
 ** File:    datamine.h
 ** Author:  Yakubu Nazif Wanka
 ** Date:    11/9/06
 ** Section: 0101
 ** E-mail:  yakubu1@umbc.edu
 **
 ** This program contains the function headers, and #defines used in
 ** project 4 with explanations.
 *************************************************************************/

#include<string.h>
#include<time.h>
#include <ctype.h>
#include "proj3helper.h"

#define MAX_ACCESS_CODE_SIZE 15
#define MAX_DOMAIN_SIZE 30
#define MAX_DOMAIN_ENDING_SIZE 4
#define MAX_SITE_TYPE_SIZE 10
#define SIZE 100

typedef struct website
{
      ADDRESS webAddress;
      char  siteType[MAX_SITE_TYPE_SIZE];
      int   hits;
      int   seconds;
}WEBSITE;

/*********************************************************************
 ** SameWebsite --
 **    This function compares every member of every element in a given
 ** array with any given website to see if the website is already
 ** inside it. If it is, it returns a value of 1. If not, it returns
 ** a value of 0.
 **
 ** Usage: SameWebsite(array, newSite);
 **
 **       Inputs : An Array of Websites, and a website
 **       Output : True(1) or False(0)
 *********************************************************************/
int SameWebsite(WEBSITE array[], WEBSITE newSite);

/*****************************************************************************
 ** CalcStats --
 **    This function calculates the percentages in the breakdown at the bottom
 ** of the output, and prints them in a nice little table plus total time in
 ** HH:MM:SS form.
 **
 ** Usage:   CalcStats(TotalUniqueSites, TotalFunSites, TotalSearchSites,
 **          TotalNewsSites, TotalEducationSites, TotalTimeLogged,
 **          TotalNonUniqueSites);
 **
 **        Inputs : The total number of unique sites, the total of each site
 **                 type, the total time logged and the total number of non
 **                 unique sites.
 **        Output : The printed results and the suggestion
 *****************************************************************************/
void CalcStats(float TotalUnique, float TotalFunSites, float TotalSearchSites,
	       float TotalNewsSites, float TotalEducationSites,
	       int TotalTimeLogged, int TotalNonUnique);

/*********************************************************************
 ** Sort Array --
 **    This function sorts the members of the given array using the
 ** bubble sort alogorithm by their number of hits. Each member is
 ** compared to the adjacent member and if it is less than the one in
 ** front, they are switched. This is done until every element in
 ** the array has been compared and it is fully sorted.
 **
 ** Usage: SortArray(array, size);
 **
 **        Inputs : An array and its size
 **        Output : The sorted array
 **********************************************************************/
void SortArray (WEBSITE array[] , int size);

/*****************************************************************************
 ** PrintSuggestion --
 **    This function prints the suggestion based on the percentage hits each
 ** site type got.
 **
 ** Usage: PrintSuggestion(InterestFun, InterstSearch, InterestNews,
 **                        InterestEducation);
 **
 **       Inputs : The percentage of each site type
 **       Output : The printed suggestion
 *****************************************************************************/
void PrintSuggestion(int InterestFun, int InterestSearch, int InterestNews,
		     int InterestEducation);

/***************************************************************
 ** PrintTable --
 **    This function prints the members of the four arrays in a
 ** table showing site type, website, number of hits, and total
 ** time spent on it
 **
 ** Usage: PrintTable(comSites, netSites, eduSites, govSites);
 **
 **        Inputs : The four arrays
 **        Output : The printed table
 ***************************************************************/
void PrintTable(WEBSITE comSites[], WEBSITE netSites[],
                WEBSITE eduSites[], WEBSITE govSites[]);


/***************************************************************
 * Function: ReadSites
 *
 * This function asks the user for the name of the data
 * file to be used, opens it, reads the website Addresses and
 * sorts them. The totals are then computed and the tables
 * printed using other functions within this one.
 *
 * Usage: ReadSites();
 * Inputs:  None
 * Outputs: Sites
 ***************************************************************/
void ReadSites();

/*************************************************************************
 * Function: ComputeTotals
 *
 * This function calculates the total number of websites visited
 * for each type of wesbites, calculates the total time and hits
 * etc.
 *
 * Usage:   void ComputeTotals(WEBSITE array[], int *pTotalUniqueSites,
            int *pTotalNonUniqueSites, int *pTotalTimeLogged,
            int *pTotalFunSites, int *pTotalSearchSites,
            int *pTotalEducationSites, int *pTotalNewsSites);
 *
 * Inputs:  pTotalUniqueSites, pTotalTimeLogged, pTotalNonUniqueSites,
 *          pTotalTimeLogged, pTotalFunSites, pTotalFunSites,
 *          pTotalSearchSites, pTotalEducationSites, TotalNewsSites.
 *
 * Outputs: Total Websites, Total Time Spent, Total  Hits
 ***********************************************************************/
void ComputeTotals(WEBSITE array[], int *pTotalUniqueSites,
                   int *pTotalNonUniqueSites, int *pTotalTimeLogged,
                   int *pTotalFunSites, int *pTotalSearchSites,
                   int *pTotalEDucationSites, int *pTotalNewsSites);


/***************************************************************
 * Function: ArrayLength
 *
 * Usage: TotalGov = ArrayLength(govSites)
 *
 * This function calculates the number of websites in an array
 * Inputs: Website[]
 * Outputs: Number of websites
 ***************************************************************/
int ArrayLength(WEBSITE array[]);

/********************************************************************
 * Function: IsPresent
 *
 * Usage: index = Ispresent(WEBSITE govsites[], WEBSITE newSite);
 *
 * This function checks a website against an array of websites to
 * see if there is a duplicate, if so, it returns the index location
 * of the duplicate, if not, then that of the first available open
 * location is returned.
 * Inputs : sites array, newSite
 * Output:  Index
 *********************************************************************/
int IsPresent(WEBSITE array[], WEBSITE newSite);

/*********************************************************
 * Function:PrintGreeting
 * This function prints the greeting to the user at the
 * beginning of the program explaining what it does
 *
 * Usage: PrintGreeting();
 *
 * Inputs: None
 * Outputs: Greeting to stdout
 **********************************************************/
void PrintGreeting();

/*********************************************************
 * Function: FillArray
 * This function fills whichever array is passed to it
 * with a dummy value to in order for the length of the
 * array to be easily determined
 *
 * Usage: FillArray(array);
 *
 * Inputs: Sites array
 * Outputs: Sites Array
 **********************************************************/
WEBSITE FillArray(WEBSITE array[]);
