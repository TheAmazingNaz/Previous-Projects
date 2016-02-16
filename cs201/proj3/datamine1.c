#include<stdio.h>
#include<stdlib.h>
#include<strings.h>
#include "datamine.h"
#include "proj3helper.h"

/****************************************************************************
 ** FillArray --
 **   This function fills the hits and seconds members of every element
 ** in whatever array is passed  to it with 0s so that the array length
 ** can easily be determined.
 **     Inputs: The Array to be filled
 **     Outputs: The filled array
 ****************************************************************************/
WEBSITE FillArray(WEBSITE array[])
{
   int i;

/*For Every element in the array, the number of hits*/
/*and seconds are made to be 0*/   
   for(i = 0; i < SIZE; i++)
   {
      array[i].seconds = 0;
      array[i].hits = 0;
   } 

 /*return filled array*/
   return array[SIZE];
}

/****************************************************************************
 ** ArrayLength --
 **    This function counts the members of whatever array is passed to it
 ** until it encounters a dummy value then it stops counting
 **       Inputs: The array to counted
 **       Outputs: The arrays length
 ****************************************************************************/
int ArrayLength(WEBSITE array[])
{
   int i;
   int k = 0;
   
   /*Count every element in the array till the dummy value*/
   /*is reached*/
   for(i = 0; i < SIZE; i++)
   {
      if(array[i].seconds != 0)
      {
	 k++;
      }
   }
   
   /*return length*/
   return k;
}

/***************************************************************************
 ** ReadSites --
 **    This function asks the user for the name of the data
 ** file to be used, opens it, reads the website Addresses and
 ** sorts them. The totals are then computed and the tables printed using
 ** other functions within this one.
 **      Inputs: None
 **      Outputs: 4 arrays fll of websites and printed results.
 ***************************************************************************/
void ReadSites()
{
   FILE *ifp;
   char filename[SIZE] = "cat";
   char temp[SIZE] = "dog";
   int j = 0;

   /*The  four arrays are declared*/
   WEBSITE t, comSites[SIZE], govSites[SIZE], eduSites[SIZE], netSites[SIZE];

   int TotalNonUniqueSites = 0, TotalUniqueSites = 0, TotalTimeLogged = 0;
   int TotalFunSites = 0, TotalSearchSites = 0, TotalEducationSites = 0;
   int  TotalNewsSites = 0, *pTotalNewsSites, *pTotalNonUniqueSites;
   int *pTotalUniqueSites, *pTotalTimeLogged, *pTotalFunSites; 
   int *pTotalSearchSites, *pTotalEducationSites;

   /*The pointers are set to point to the their corresponding values*/
   pTotalNonUniqueSites = &TotalNonUniqueSites;
   pTotalUniqueSites = &TotalUniqueSites;
   pTotalTimeLogged = &TotalTimeLogged;
   pTotalFunSites = &TotalFunSites;
   pTotalSearchSites = &TotalSearchSites;
   pTotalEducationSites = &TotalEducationSites;
   pTotalNewsSites = &TotalNewsSites;

   /*The are filled with dummy values*/
   FillArray(comSites);
   FillArray(netSites);
   FillArray(eduSites);
   FillArray(govSites);

   /*Asks the user for the file name*/
   fprintf(stdout, "\nPlease enter the file name: ");
   fscanf(stdin, "%s", filename);
   ifp = fopen(filename, "r");

   /*If the file cannot exit and give error message*/
   if(ifp == NULL)
   {
      fprintf(stderr, "The file could not be opened.");
      exit(-1);
   }

   /*Scans every thing in the file until it reaches the end*/
   while(fscanf(ifp, "%s %s %d", temp, t.siteType, &t.seconds) != EOF)
     {
	/*Breaks the string temp  into access code, domain name*/
	/* and domain ending and stores the in the temporary structure*/
	t.webAddress = CreateAddress(temp);
	
	/*Depending on the first letter of the domain ending, stores*/
	/*them into the appropriate array*/
	if(t.webAddress.domainEnding[0] == 'c')
	{
	   /*Finds the index of wherever the website is supposed to go*/
	   j = IsPresent(comSites, t);
	   
	   /*Stores the website in the proper location*/
	   comSites[j].webAddress = t.webAddress;
	   
	   /*Stores the siteType in the corresponding location*/
	   strcpy(comSites[j].siteType, t.siteType);
	   
	   /*Adds the number of hits and the seconds*/
	   comSites[j].hits += 1;
	   comSites[j].seconds += t.seconds;
	} 
	else if(t.webAddress.domainEnding[0] == 'g')
	{
	   j = IsPresent(govSites, t);
	   
	   govSites[j].webAddress = t.webAddress;
	   strcpy(govSites[j].siteType, t.siteType);
	   govSites[j].hits += 1;
	   govSites[j].seconds += t.seconds;
	}
	else if(t.webAddress.domainEnding[0] == 'n')
	{
	   j = IsPresent(netSites, t);
	   
	   netSites[j].webAddress = t.webAddress;
	   strcpy(netSites[j].siteType, t.siteType);
	   netSites[j].hits += 1;
	   netSites[j].seconds += t.seconds;
	 }
       else
	 {
	   j = IsPresent(eduSites, t);
	   
	   eduSites[j].webAddress = t.webAddress;
	   strcpy(eduSites[j].siteType, t.siteType);
	   eduSites[j].hits += 1;
	   eduSites[j].seconds += t.seconds;
	 } 
     }  
   
   /*Sorts the arrays*/
   SortArray(eduSites, ArrayLength(eduSites));
   SortArray(govSites, ArrayLength(govSites));
   SortArray(comSites, ArrayLength(comSites));
   SortArray(netSites, ArrayLength(netSites));
   
   /*Computes the totals using data from all the arrays*/
   ComputeTotals(comSites, pTotalUniqueSites, pTotalNonUniqueSites,
		 pTotalTimeLogged, pTotalFunSites, pTotalSearchSites,
		 pTotalEducationSites, pTotalNewsSites);

   ComputeTotals(eduSites, pTotalUniqueSites, pTotalNonUniqueSites, 
		 pTotalTimeLogged, pTotalFunSites, pTotalSearchSites,
		 pTotalEducationSites, pTotalNewsSites);

   ComputeTotals(netSites, pTotalUniqueSites, pTotalNonUniqueSites,
		 pTotalTimeLogged, pTotalFunSites, pTotalSearchSites,
		 pTotalEducationSites, pTotalNewsSites);

   ComputeTotals(govSites, pTotalUniqueSites, pTotalNonUniqueSites,
		 pTotalTimeLogged, pTotalFunSites, pTotalSearchSites,
		 pTotalEducationSites, pTotalNewsSites);

   /*Prints the results of the read*/
   PrintTable(comSites, netSites, eduSites, govSites);
   
   /*Caclulates the percentages and prints them*/
   CalcStats(TotalUniqueSites, TotalFunSites, TotalSearchSites,
	     TotalNewsSites, TotalEducationSites, TotalTimeLogged,
	     TotalNonUniqueSites);
   
   return;
}

/********************************************************************
 ** IsPresent --
 **    This function checks a website against an array of websites to
 ** see if there is a duplicate, if so, it returns the index location
 ** of the duplicate, if not, then that of the first available open
 ** location is returned.
 **        Inputs : sites array, newSite
 **        Output : Index
 *********************************************************************/
int IsPresent(WEBSITE array[], WEBSITE newSite)
{
   int i = 0;
   
   /*If the website is not inside the array, return the array length*/
   if(SameWebsite(array, newSite) != 1)
   {
     return ArrayLength(array);
   }
   /*If not then keep adding 1 to i, until the location of the*/
   /*location of the equal website is reached then the count is stopped*/
   /*and the element index returned.*/
   else
   {  
      for( i = 0; i < ArrayLength(array); i++)
      {
	 if(strcmp(array[i].webAddress.accessCode,
		   newSite.webAddress.accessCode) == 0)
	 { 
	    if(strcmp(array[i].webAddress.domainName,
		      newSite.webAddress.domainName) == 0)
	    {
	       if(strcmp(array[i].webAddress.domainEnding, 
			 newSite.webAddress.domainEnding) == 0)
	       {
		  break;
	       }
	    }
	 }
      }
   }
   /*the index of the equal websites location is returned*/
   return i;
}

/*********************************************************************
 ** SameWebsite --
 **    This function compares every member of every element in a given
 ** array with any given website to see if the website is already
 ** inside it. If it is, it returns a value of 1. If not, it returns
 ** a value of 0.
 **       Inputs : An Array of Websites, and a website
 **       Output : True(1) or False(0)
 *********************************************************************/
int SameWebsite(WEBSITE array[], WEBSITE newSite)
{
   int i, k = 0;

   /*Directly compare eeach component of each element of the array*/
   /*with each component of the new website. and returns 1 if any*/
   /*element website is equal to the new Website*/
   for(i = 0; i < SIZE; i++)
   {
      if(strcmp(array[i].webAddress.accessCode,
		newSite.webAddress.accessCode) == 0)
      { 
	 if(strcmp(array[i].webAddress.domainName,
		   newSite.webAddress.domainName) == 0)
	 {
	    if(strcmp(array[i].webAddress.domainEnding, 
		      newSite.webAddress.domainEnding) == 0)
	    {
	       k = 1;
	    }
	 }
      }
   }

   return k;
}

/*********************************************************************
 ** Sort Array -- 
 **    This function sorts the members of the given array using the
 ** bubble sort alogorithm by their number of hits. Each member is
 ** compared to the adjacent member and if it is less than the one in
 ** front, they are switched. This is done until every element in
 ** the array has been compared and it is fully sorted.
 **        Inputs : An array and its size
 **        Output : The sorted array
 **********************************************************************/
void SortArray (WEBSITE array[SIZE] , int size)
{
  int i, j;
  
  /*A temporary website is declared which stores the smaller element*/
  /*during the switch*/
  WEBSITE temp;

  /*Every member is compared to the one in front of it*/
  for (i = 0; i < size; i++)
    {
      for (j = 0; j < size - 1; j++)
	{
	   /*If it is smaller, it is switched with the one in front*/
	  if (array[j].hits < array[j+1].hits)
	    {
	      temp = array[j];
	      array[j] = array[j + 1];
	      array[j+1] = temp;
	    }
	}
    }
}

/*********************************************************
 ** PrintGreeting --
 **    This function prints the greeting to the user at the
 ** beginning of the program explaining what it does
 **       Inputs: None
 **       Outputs: Greeting to stdout
 **********************************************************/
void PrintGreeting()
{
  fprintf(stdout, "***********************************************************\n");
  fprintf(stdout, "************************DATA MINE**************************\n");
  fprintf(stdout, "***********************************************************\n");
  fprintf(stdout, "*********************This Program Mines********************\n");
  fprintf(stdout, "********************Any History File And*******************\n");
  fprintf(stdout, "*****************Gives A Detailed Breakdown****************\n");
  fprintf(stdout, "*******************of Website Statistics*******************\n");
  fprintf(stdout, "***********************************************************\n");

  return;
}

/***************************************************************
 ** PrintTable --
 **    This function prints the members of the four arrays in a
 ** table showing site type, website, number of hits, and total
 ** time spent on it
 **        Inputs : The four arrays
 **        Output : The printed table
 ***************************************************************/
void PrintTable(WEBSITE comSites[SIZE], WEBSITE netSites[SIZE],
		WEBSITE eduSites[SIZE], WEBSITE govSites[SIZE])
{
  int m;

  fprintf(stdout, "\n\n        TYPE    HITS    TIME     WEB ADDRESS");
  fprintf(stdout, "\n=========================================================\n");
  
  printf("EDU sites: (%d Sites)\n", ArrayLength(eduSites));
  for(m = 0; m < ArrayLength(eduSites); m++)
  {
     printf("     %s\t %d\t%d\t%s.%s.%s\n", eduSites[m].siteType, eduSites[m].hits,
	    eduSites[m].seconds, eduSites[m].webAddress.accessCode,
	    eduSites[m].webAddress.domainName,
	    eduSites[m].webAddress.domainEnding);
  }
  
  printf("\nCOM sites: (%d Sites)\n", ArrayLength(comSites));
  for(m = 0; m < ArrayLength(comSites); m++)
  {
     printf("     %s\t %d\t%d\t%s.%s.%s\n", comSites[m].siteType, comSites[m].hits,
	    comSites[m].seconds, comSites[m].webAddress.accessCode,
	    comSites[m].webAddress.domainName,
	    comSites[m].webAddress.domainEnding);
  }
  
  printf("\nNET sites: (%d Sites)\n", ArrayLength(netSites));
  for(m = 0; m < ArrayLength(netSites); m++)
  {
     printf("     %s\t %d\t%d\t%s.%s.%s\n", netSites[m].siteType, netSites[m].hits,
	    netSites[m].seconds, netSites[m].webAddress.accessCode,
	    netSites[m].webAddress.domainName,
	    netSites[m].webAddress.domainEnding);
  }

  printf("\nGOV sites: (%d Sites)\n", ArrayLength(govSites));
  for(m = 0; m < ArrayLength(govSites); m++)
  {
     printf("     %s\t %d\t%d\t%s.%s.%s\n", govSites[m].siteType, govSites[m].hits,
	    govSites[m].seconds, govSites[m].webAddress.accessCode,
	    govSites[m].webAddress.domainName,
	    govSites[m].webAddress.domainEnding);
  }
  
  return;
}


/*************************************************************************
 ** ComputeTotals --
 **    This function calculates the total number of websites visited
 ** for each type of wesbites, calculates the total time and hits
 ** etc.
 **       Inputs : Pointers to all the values that need to be totalled
 **	  Output : Total Websites, Total Time Spent, Total  Hits  
 *************************************************************************/
void ComputeTotals(WEBSITE array[SIZE], int *pTotalUniqueSites,
		   int *pTotalNonUniqueSites, int *pTotalTimeLogged,
		   int *pTotalFunSites, int *pTotalSearchSites,
		   int *pTotalEducationSites, int *pTotalNewsSites)
{
   int n;

  /*The Total number of unique sites is basically equal to the length of*/
  /*the final array*/
  *pTotalUniqueSites += ArrayLength(array);
  
  /*For every member of the array with more than one hit, add 1 to the total*/
  for(n = 0; n < ArrayLength(array); n++)
  {
      if(array[n].hits > 1)
	{
	  *pTotalNonUniqueSites += 1;
	}
    }

  /*For every member of the array, add the total number of seconds upon*/
  /*itself, and add 1 to the total for each type that shows up in the array*/
  for(n = 0; n < ArrayLength(array); n++)
    {
      *pTotalTimeLogged += array[n].seconds;
      
      if(array[n].siteType[0] == 'S')
	{
	  *pTotalSearchSites += 1;
	}
      if(array[n].siteType[0] == 'N')
	{ 
	  *pTotalNewsSites += 1;
	}
      if(array[n].siteType[0] == 'F')
	{
	  *pTotalFunSites += 1;
	}
      if(array[n].siteType[0] == 'E')
	{          
	  *pTotalEducationSites += 1;
	}
    }	
}

/*****************************************************************************
 ** CalcStats -- 
 **    This function calculates the percentages in the breakdown at the bottom
 ** of the output, and prints them in a nice little table plus total time in
 ** HH:MM:SS form.
 **        Inputs : The total number of unique sites, the total of each site
 **                 type, the total time logged and the total number of non
 **                 unique sites.
 **        Output : The printed results and the suggestion
 *****************************************************************************/
void CalcStats(float TotalUnique, float TotalFunSites, float TotalSearchSites,
	       float TotalNewsSites, float TotalEducationSites, 
	       int TotalTimeLogged, int TotalNonUnique)
{
   float InterestFun, InterestSearch, InterestNews, InterestEducation;
   int hours, minutes, seconds;
   
   /*The number of each site type is converted to a percentage based on*/
   /*the total number of unique sites*/
   InterestFun = (TotalFunSites/TotalUnique)*100;
   InterestSearch= (TotalSearchSites/TotalUnique)*100;
   InterestNews = (TotalNewsSites/TotalUnique)*100;
   InterestEducation = (TotalEducationSites/TotalUnique)*100;
   
   /*The total time is converted to hours, minutes and seconds*/
   hours = TotalTimeLogged/3600;
   minutes = (TotalTimeLogged%3600)/60;
   seconds = (TotalTimeLogged - (minutes*60) - (hours*3600));
   
   fprintf(stdout, "\n\n=============================================");
   fprintf(stdout, "\n               MINED RESULTS                   ");
   fprintf(stdout, "\n=============================================\n");
   fprintf(stdout, "\nTotal Unique Websites : %.0lf             \n", 
	   TotalUnique); 
   fprintf(stdout, "Total Time Logged: %d:%d:%d            \n", 
	   hours, minutes, seconds);
   fprintf(stdout, "Total Non Unique Websites: %.d          \n",
	   TotalNonUnique); 
   fprintf(stdout, "\n=============================================\n");
   fprintf(stdout, "           Website Content Breakdown           \n");
   fprintf(stdout, "=============================================\n");
   fprintf(stdout, "   Search Pages:\t%.0f\tInterest: %.0f%%\n",
	   TotalSearchSites, InterestSearch);
   fprintf(stdout, "   News Pages:\t\t%.0f\tInterest: %.0f%%\n",
	   TotalNewsSites, InterestNews);
   fprintf(stdout, "   Fun Pages:\t\t%.0f\tInterest: %.0f%%\n",
	   TotalFunSites, InterestFun);
   fprintf(stdout, "   Education Pages:\t%.0f\tInterest: %.0f%%\n",
	   TotalEducationSites, InterestEducation);
   fprintf(stdout, "=============================================\n");
   
   PrintSuggestion(InterestFun, InterestSearch, InterestNews,
		   InterestEducation);
   
   return;
}


/*****************************************************************************
 ** PrintSuggestion --
 **    This function prints the suggestion based on the percentage hits each
 ** site type got
 **       Inputs : The percentage of each site type
 **       Output : The printed suggestion
 *****************************************************************************/ 
void PrintSuggestion(int InterestFun, int InterestSearch, int InterestNews,
		     int InterestEducation)
{
   /*The percentages are stored in an array of ints*/
   int Interests[4], i, biggestInterest;
   Interests[0] = InterestFun;
   Interests[1] = InterestSearch;
   Interests[2] = InterestNews;
   Interests[3] = InterestEducation;
   
   /*Thr biggest is initialized as the first element of the array*/
   biggestInterest = Interests[0];
   
   /*Each element of the array is compared to the one next to it, if*/
   /* one is bigger, it is given the biggestInterest title until a biggest*/
   /*Interest is finally found after all the elements are scanned*/
   for(i = 0; i < 5; i++)
   {
      if(Interests[i] > biggestInterest)
      {
	 biggestInterest = Interests[i];
      }
   }
   
   /*based on whichever interest is determined to be the biggest*/
   /*a suggestion is made*/
  if(biggestInterest == InterestFun)
  {
     printf("\n\nRecommendation: Add Fun Content to our pages.\n");
  }
  else if(biggestInterest == InterestSearch)
  {
     printf("\n\nRecommendation: Add Search Content to our pages.\n");
  }
  else if(biggestInterest == InterestNews)
  {
     printf("\n\nRecommendation: Add News Content to our pages.\n");
  }
  else
  {
     printf("\n\nRecommendation: Add Education Content to our pages.\n");
  }
  
  return;
}
