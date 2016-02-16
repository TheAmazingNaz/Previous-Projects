/*************************************************************
 ** IsPresent --
 **   This function takes an array of websites and
 ** an individual website, checks for a duplicate,
 ** and returns either the index to the duplicate
 ** or, if there is none, the value of the index
 ** of the first available open location in the
 ** array.
 **   Inputs: The array of websites, any individual website.
 **   Output: An index of the duplicate or the first available
 **           location.
 **************************************************************/ 

int IsPresent(WEBSITE array[], WEBSITE newSite);


/*************************************************************
 ** ArrayLength --
 **   This function takes an array of websites and returns the
 ** number of websites that are in the array.
 **   Inputs: Website array.
 **   Output: Number of websites.
 **************************************************************/

int ArrayLength(WEBSITE array[]);


/*************************************************************
 ** ComputeTotals --
 **   This function takes an array of websites and
 ** an individual website, checks for a duplicate,
 ** and returns either the index to the duplicate
 ** or, if there is none, the value of the index
 ** of the first available open location in the
 ** array.
 **   Inputs: The array of websites, and pointers to 
 **           totalUniqueSites and totalLoggedTime, and pointers
 **           to the total number of each type of site in the
 **           array
 **   Output: None
 **************************************************************/

void ComputeTotals(WEBSITE array[], int *pTotalUniqueSites,
		   int *pTotalNonUniqueSites, int *pTotalTimeLogged,
		   int *pTotalFunSites, int *pTotalSearchSites,
		   int *pTotalEducationSites, int *pTotalNewsSites); 
