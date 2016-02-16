/*******************************************************
 *Filename:     util.h                                 *
 *Author:       Yakubu Nazif Wanka                     *
 *Date Written: 10/14/08                               *
 *Email:        yakubu1@umbc.edu                       *
 *                                                     *
 *This program contains prototypes of general functions*
 *that can be used in any program                      *
 \*******************************************************/

/* size defined for multi dimensional array */

#define SIZE 15
/********************************************************************************************
** ChangeValue
**    This function takes the original array created using inputs from the .dat file
** and, depending on the wind direction, calls the functions necessary to modify
** the array and make the oil spread in the right direction. It then prints everything
**      Inputs : original array, wind direction, interval, and time
**      Outputs : Simulation
***********************************************************************************************/
void ChangeValue(int gallons[SIZE][SIZE], int direction, int interval, int time);


/**********************************************
 ** WestWind(int gallons[][])
 **    This function changes the array so that
 ** the oil is seen to move as though the wind
 ** were blowing from the west.
 **      Inputs: Original Array
 **      Outputs: Modified Array
 **********************************************/
void WestWind(int gallons[SIZE][SIZE]);


/**********************************************
 ** NorthWind(int gallons[][])
 **    This function changes the array so that
 ** the oil is seen to move as though the wind
 ** were blowing from the north.
 **      Inputs: Original Array
 **      Outputs: Modified Array
 **********************************************/
void NorthWind(int gallons[SIZE][SIZE]);


/**********************************************
 ** EastWind(int gallons[][])
 **    This function changes the array so that
 ** the oil is seen to move as though the win
 ** were blowing from the east.
 **      Inputs: Original Array
 **      Outputs: Modified Array
 **********************************************/
void EastWind(int gallons[SIZE][SIZE]);

/**********************************************
 ** SouthWind(int gallons[][])
 **    This function changes the array so that
 ** the oil is seen to move as though the wind
 ** were blowing from the south.
 **      Inputs: Original Array
 **      Outputs: Modified Array
 **********************************************/
void SouthWind(int gallons[SIZE][SIZE]);


/****************************************
 ** PrintGreeting
 **     This function prints a greeting
 **  to the user.
 **     Inputs: None
 **     Outputs:Greeting
 ****************************************/
void PrintGreeting(void);

