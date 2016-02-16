/*******************************************************
 *Filename:     util.h                                 *
 *Author:       Yakubu Nazif Wanka                     *
 *Date Written: 09/23/08                               *
 *Date Modified:11/09/08                               *
 *Email:        yakubu1@umbc.edu                       *
 *                                                     *
 *This program contains prototypes of general functions*
 *that can be used in any program                      *
 \*******************************************************/

/*********************************************
 ** Function: GetValidInt()
 ** GetValidInt() gets an integer from the user between
 ** specified minimum and maximum values, and will
 ** reprompt the user until it gets one that is valid.
 **                                                  
 ** Inputs: min and max, the minimum and maximum      
 **          (inclusive) values for the entered integer 
 ** Output: returns an integer between min and max,  
 **          inclusively                              
 *********************************************/    
int  GetValidInt (int min, int max);

/*********************************************
 ** Function: SetRandomSeed
 ** Usage:    SetRandomSeed();
 **
 ** The pseudo-random number generator is seeded
 ** with a call to time() assuring a different
 ** seed everytime the program runs.
 **
 ** Inputs: None
 ** Output: No value is returned
 *********************************************/
void SetRandomSeed (void);

/*********************************************
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
 *********************************************/
int  GetRandomNumber (int low, int high);

/******************************************************
 *Function: ForeignToDollars
 *
 *Purpose: This function converts the amount of
 *currency inputed by the user to dollars.
 ******************************************************/
float ForeignToDollars (float units, float conversion);

/*********************************************
 *Function: CelsiusToFahrenheit
 *
 *Purpose: This function converts the celsius
 *temperature to fahrenheit
 *********************************************/
double CelsiusToFahrenheit (double celsius);

/***************************************************
 *Function: ForeignTimeToEastern
 *
 *Purpose: This function converts the foreign time
 *to Eastern Time.
 ***************************************************/
int ForeignTimeToEastern (int hour, int adjustment);

/***************************************************
 *Function: PrintAMPMForm
 *
 *Purpose: This function converts the time from 24
 *hour to 12-hour form then prints it.
 ***************************************************/
void PrintAMPMForm(int hour, int minutes);
