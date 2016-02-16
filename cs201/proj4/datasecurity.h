/*****************************************
 ** File: datasecurity.h
 ** Author: Yakubu Nazif Wanka
 ** Date: 11/23/08
 ** Section: 101
 ** E-mail: yakubu1@umbc.edu
 **
 **       This file contains the function
 ** headers used by the the file proj4.c
 ** and datasecurity.c
 *****************************************/

#define ALPHABET 26

#define ELEMENT 3

#define NUMLETTERS 80

#define CHOICESIZE 3

#define FILENAMESIZE 30

typedef struct key
{
  char input;
  char output;
}KEYS;

/*************************************************************************
 * Function: Hailstones
 * 
 * This is a recursive function that returns any element of the Hailstone
 * of any given number
 *
 * Inputs : Number, element. 
 * Outputs: Hailstone sequence result.
 **************************************************************************/
int Hailstones(int num, int times);

/**************************************************************************
 * Function: TranslateString
 *
 * This is a function that asks the user for any string then encrypts it.
 *
 * Inputs:None
 * Outputs: Encrypted String.
 **************************************************************************/
void TranslateString();

/**************************************************************************
 * Function: TranslateFile
 * 
 * This function encrypts any file after asking the user for the filename 
 * and places the output in any given output file.
 *
 * Inputs: None
 * Outputs:Encrypted file.
 **************************************************************************/
void TranslateFile();

/**************************************************************************
 * Function: PrintMenu
 *
 * This function prints the menu showing the user the list of options that
 * can be done by the program.
 *
 * Inputs: None
 * Outputs:Printed Menu
 ***************************************************************************/
void PrintMenu();

/***************************************************************************
 * Function: PrintSMenu
 *
 * This function prints the second Menu for the S and F choices asking the
 * user whether they want to encrypt or decrypt a file or string
 *
 * Inputs: None
 * Output: Printed Menu
 ***************************************************************************/
void PrintSMenu();

/***************************************************************************
 * Function: PrinptKeyTable
 * 
 * This function prints the encryption key table for the user
 *
 * Inputs: None
 * Output: Printed Table
 ***************************************************************************/
void PrintKeyTable();

/**************************************************************************
 * Function: DecryptFile
 * 
 * This function decrypts any file after asking the user for the filename 
 * and places the output in any given output file.
 *
 * Inputs: None
 * Outputs:Decrypted file.
 **************************************************************************/
void DecryptFile();

/**************************************************************************
 * Function: DecryptString
 *
 * This is a function that asks the user for any string then decrypts it.
 *
 * Inputs:None
 * Outputs: Decrypted String.
 **************************************************************************/
void DecryptString();

/******************************************************************
 * Function: StringInterface
 *
 * This function gives the user the option of either Encrypting or
 * decrypting whichever string they enter.
 *
 *Inputs: None
 *Output: None
 ******************************************************************/
void StringInterface();

/******************************************************************
 * Function: FileInterface
 *
 * This function gives the user the option of either Encrypting or
 * decrypting whichever file they enter.
 *
 *Inputs: None
 *Output: None
 ******************************************************************/
void FileInterface();
