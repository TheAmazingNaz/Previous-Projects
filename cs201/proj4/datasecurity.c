/*****************************************
 ** File: datasecurity.c
 ** Author: Yakubu Nazif Wanka
 ** Section: 101
 ** E-mail: yakubu1@umbc.edu
 **
 **       This file contains the functions
 ** used by the the file proj4.c
 **
 ** Other files required are:
 **      1. datasecurity.h
 *****************************************/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include "datasecurity.h" 

/******************************************************************
 * Function: StringInterface
 *
 * This function gives the user the option of either Encrypting or
 * decrypting whichever string they enter.
 *
 *Inputs: None
 *Output: None
 ******************************************************************/
void StringInterface()
{
  /*The string choice which is going to contain the user choice*/
  /*and The newline character*/
  char *choice;
  choice = (char *) malloc(CHOICESIZE * sizeof(char)) ;
  if(choice == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for choice\n");
      exit (-1);
    }

  PrintSMenu();
  /*Reads the choice from the user*/
  fscanf(stdin, "%s", choice);
    {
      /*For both lowercase and uppercase choices, launch Encryption*/
      /*or decryption modes*/
      switch(choice[0])
	{
	case 'E':
	  TranslateString();
	  break;
	case 'e':
	  TranslateString();
	  break;
	case'D':
	  DecryptString();
	  break;
	case 'd':
	  DecryptString();
	  break;
	default:
	  return;
	  break;
	}
    } 
  free(choice); 
  return;
}
 
/******************************************************************
 * Function: FileInterface
 *
 * This function gives the user the option of either Encrypting or
 * decrypting whichever file they enter.
 *
 *Inputs: None
 *Output: None
 ******************************************************************/
void FileInterface()
{
  char *choice;
  choice = (char *) malloc(CHOICESIZE * sizeof(char)) ;
  if(choice == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for choice\n");
      exit (-2);
    }
  PrintSMenu();
  fscanf(stdin, "%s", choice);
  switch(choice[0])
      {
      case 'E':
	TranslateFile();
	break;
      case 'e':
	TranslateFile();
	break;
      case'D':
	DecryptFile();
	break;
      case 'd':
	DecryptFile();
	break;
      default:
	return;
	break;
      }
  free(choice);
  return;
}
 
/*****************************************************************
 * Function: PrinptKeyTable
 * 
 * This function prints the encryption key table for the user
 *
 * Usage: PrintKeyTable();
 *
 * Inputs: None
 * Output: Printed Table
 *****************************************************************/
void PrintKeyTable()
{
  int num, result, uppernum;
  KEYS character;

  fprintf(stdout, "\n\t\t        KEY TABLE\n");
  fprintf(stdout, "========================================================");
  fprintf(stdout, "======\n");
  fprintf(stdout, "Decoded: ");

  /*Fill The inputs of the Character Table*/
  for(uppernum = 65; uppernum < 91; uppernum++)
    {
      character.input = uppernum;
      fprintf(stdout, "%2c", character.input);
    }

  fprintf(stdout, "\nEncoded: ");
  
  /*Fill THe outputs of the Character table*/
  for(num = 65; num < 91; num++)
    {
      result = Hailstones(num, ELEMENT);
      character.output = result;
      fprintf(stdout, "%2c", character.output);
    }

    return;
}

/**************************************************************************
 * Function: PrintMenu
 *
 * This function prints the menu showing the user the list of options that
 * can be done by the program.
 *
 * Usage: PrintMenu();
 *
 * Inputs: None
 * Outputs:Printed Menu
 ***************************************************************************/
void PrintMenu()
{
  fprintf(stdout, "\n\n_______________Main Menu______________");
  fprintf(stdout, "\n               P - Print Key Table");
  fprintf(stdout, "\n               F - Translate File");
  fprintf(stdout, "\n               S - Translate User String");
  fprintf(stdout, "\n               Q - Quit");
  fprintf(stdout, "\n\nPlease make a Selection : ");

  return;
}

/***************************************************************************
 * Function: PrintSMenu
 *
 * This function prints the second Menu for the S and F choices asking the
 * user whether they want to encrypt or decrypt a file or string
 *
 * Usage: PrintSMenu();
 *
 * Inputs: None
 * Output: Printed Menu
 ***************************************************************************/
void PrintSMenu()
{
  fprintf(stdout, "\nSelect the Translation Mode:");
  fprintf(stdout, "\n                   E - Encryption Mode");
  fprintf(stdout, "\n                   D - Decryption Mode\n");
  fprintf(stdout, "Please enter your Selection : ");
}

/**************************************************************************
 * Function: TranslateFile
 * 
 * This function encrypts any file after asking the user for the filename 
 * and places the output in any given output file.
 *
 * Inputs: None
 * Outputs:Encrypted file.
 **************************************************************************/
void TranslateString()
{
  char *input, *output, *straynewline;
  KEYS *character;
  int i, j = 64, k, n;
  /*Dynamically allocate memory for input*/

  input = (char *) malloc(NUMLETTERS * sizeof(char)) ;
   if (input == NULL)
   {
     fprintf(stderr, "Out of memory - getting space for input\n");
     exit (-3);
   }

   /*Dynamically allocate memory for straynewline*/
   straynewline = (char *) malloc(2 * sizeof(char)) ;
   if (straynewline == NULL)
   {
     fprintf(stderr, "Out of memory - getting space for the stray new line\n");
     exit (-4);
   }
   
   /*Dynamicaly allocate memory for output*/
   output = (char *) malloc(NUMLETTERS * sizeof(char));   
   if (output == NULL)
   {
     fprintf(stderr, "Out of memory - getting space for output\n");
     exit (-5);
   }
   /*Dynamically allocate memory for character table*/
   character = (KEYS *) malloc(ALPHABET * sizeof(KEYS));
   if (character == NULL)
   {
     fprintf(stderr, "Out of memory - getting space for the character table\n");
     exit (-6);
   }
   
   fprintf(stdout, "\nPlease enter your message: ");
   /*Fill character table*/
   for(i = 0; i < ALPHABET; i++)
     {
       j++;
       character[i].input = j;
       character[i].output = Hailstones(character[i].input, ELEMENT);
     }
   
   /*Scan the newline character from earlier user input*/
   fgets(straynewline, 2, stdin);

   /*Scan User Input*/
   fgets(input, 80, stdin);
   /*For Every letter in the string*/
   for(k = 0; k < NUMLETTERS; k++)
     {
       /*Compare it against every letter in the alphabet*/
       /*If it matches with an alphabetic character match it with its output*/
       for(n = 0; n < ALPHABET; n++)
	 {
	   /*If it is a lowercase letter, convert it to*/
	   /*uppercase, then match it*/
	   if(input[k] > 96 && input[k] < 123)
	     {
	       input[k] -= 32;
	       if(input[k] == character[n].input)
		 {
		   output[k] = character[n].output;
		 }
	     }   
	   /*If not, just match it*/
	   else if(input[k] == character[n].input)
	     {
	       output[k] = character[n].output;
	     }
	   /*If it is a non-alphabetic character take it directly*/
	   /*to the output string*/
	   else if(input[k] > 122)
	     {
	       output[k] = input[k]; 
	     }
	   else if(input[k] > 90 && input[k] < 97)
	     {
	       output[k] = input[k]; 
		 }
	   else if(input[k] < 65)
	     {
	       output[k] = input[k]; 
	     }
	 }
     }
   /*Print output string*/
   printf("\nThe Encrypted Message is: %s\n", output);
   
   free(input);
   free(straynewline);
   free(character);
   free(output);

   return;
}

/**************************************************************************
 * Function: DecryptString
 *
 * This is a function that asks the user for any string then decrypts it.
 *
 * Inputs:None
 * Outputs: Decrypted String.
 **************************************************************************/
void DecryptString()
{
  char *input, *output, *straynewline;
  KEYS *character;
  int i, j = 64, k, n;
  /*Dynamically allocate memory for input*/

  input = (char *) malloc(NUMLETTERS * sizeof(char)) ;
   if (input == NULL)
   {
     fprintf(stderr, "Out of memory - getting space for input\n");
     exit (-7);
   }

   /*Dynamically allocate memory for straynewline*/
   straynewline = (char *) malloc(2 * sizeof(char)) ;
   if (straynewline == NULL)
   {
     fprintf(stderr, "Out of memory - getting space for the stray new line\n");
     exit (-8);
   }
   
   /*Dynamicaly allocate memory for output*/
   output = (char *) malloc(NUMLETTERS * sizeof(char));   
   if (output == NULL)
   {
     fprintf(stderr, "Out of memory - getting space for output\n");
     exit (-9);
   }

   character = (KEYS *) malloc(ALPHABET * sizeof(KEYS));
   if (character == NULL)
   {
     fprintf(stderr, "Out of memory - getting space for the character table\n");
     exit (-10);
   }

   fprintf(stdout, "\nPlease enter your message: ");

   for(i = 0; i < ALPHABET; i++)
     {
       j++;
       character[i].input = j;
       character[i].output = Hailstones(character[i].input, ELEMENT);
     }
   fgets(straynewline, 2, stdin);
   fgets(input, 80, stdin);
   
   /*For every letter in the alphabet*/
   for(k = 0; k < NUMLETTERS; k++)
     {
       /*If the given inputted charcter matches with an output character*/
       /*In the character table then match its output with its matching input*/
       for(n = 0; n < ALPHABET; n++)
	 {
	   if(input[k] > 122)
	     {
	       output[k] = input[k]; 
	     }
	   else if(input[k] < 65)
	     {
	       output[k] = input[k]; 
	     }
	   else if(input[k] == character[n].output)
	     {
	       output[k] = character[n].input;
	     }	
	 }
     }
   printf("\nThe Encrypted Message is: %s\n", output);
   
   free(input);
   free(straynewline);
   free(character);
   free(output);

   return;
}

/**************************************************************************
 * Function: TranslateFile
 * 
 * This function encrypts any file after asking the user for the filename 
 * and places the output in any given output file.
 *
 * Inputs: None
 * Outputs:Encrypted file.
 **************************************************************************/
void TranslateFile()
{
  char *input, *output, *filename, *outfilename;
  KEYS *character;
  FILE *ifp, *ofp;
  int i, j = 64, k, n;
  
  character = (KEYS *) malloc(ALPHABET * sizeof(KEYS));
  if (character == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for character table\n");
      exit (-11);
    }
  
  input = (char *) malloc(NUMLETTERS * sizeof(char)) ;
  if (input == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for input\n");
      exit (-12);
    }

  output = (char *) malloc(NUMLETTERS * sizeof(char)) ;
  if (output == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for output\n");
      exit (-13);
    }

  filename = (char *) malloc(FILENAMESIZE * sizeof(char)) ;
  if (filename == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for filename\n");
      exit (-14);
    }

  outfilename = (char *) malloc(FILENAMESIZE * sizeof(char)) ;
  if (outfilename == NULL)
    {
      printf("Out of memory - getting space for outputfilename\n");
      exit(-15);
    }
  /*Get Filenames of input and output files*/
  fprintf(stdout, "\nPLease Enter your input file: ");
  fscanf(stdin, "%s", filename);
  fprintf(stdout, "\nPlease enter your output file: ");
  fscanf(stdin, "%s", outfilename);

  ifp = fopen(filename, "r");
  if (ifp == NULL) {
    fprintf(stderr, "Can't open %s for reading.\n", filename); 
    exit(-1);
  }

  ofp = fopen(outfilename, "w");
  if (ifp == NULL) {
    fprintf(stderr, "Can't open %s for writing.\n", outfilename); 
    exit(-1);
  }

  for(i = 0; i < ALPHABET; i++)
    {
      j++;
      character[i].input = j;
      character[i].output = Hailstones(character[i].input, ELEMENT);
    }
  /*Scans each line from the input file until the end*/
  while(fgets(input, 80, ifp) != NULL)
    {
      /*Encrypts the inputfile line-by-line*/
      for(k = 0; k < NUMLETTERS; k++)
	{
	  for(n = 0; n < ALPHABET; n++)
	    {
	      if(input[k] > 96 && input[k] < 123)
		{
		  input[k] -= 32;
		  if(input[k] == character[n].input)
		    {
		      output[k] = character[n].output;
		    }
		}
	      else if(input[k] == character[n].input)
		{
		  output[k] = character[n].output;
		}
	      else if(input[k] > 122)
		{
		  output[k] = input[k]; 
		}
	      else if(input[k] > 90 && input[k] < 97)
		{
		  output[k] = input[k]; 
		}
	      else if(input[k] < 65)
		{
		  output[k] = input[k]; 
		}
	
	    }
	}
      /*Stores each encrypted line in the output file*/
      fputs(output, ofp);
    }
   fclose(ifp);
   fclose(ofp);
   free(input);
   free(filename);
   free(outfilename);
   free(character);
   free(output);
   return;
}

/**************************************************************************
 * Function: DecryptFile
 * 
 * This function decrypts any file after asking the user for the filename 
 * and places the output in any given output file.
 *
 * Inputs: None
 * Outputs:Decrypted file.
 **************************************************************************/
void DecryptFile()
{
  char *input, *output, *filename, *outfilename;
  KEYS *character;
  FILE *ifp, *ofp;
  int i, j = 64, k, n;
  
  character = (KEYS *) malloc(ALPHABET * sizeof(KEYS));
  if (character == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for character table\n");
      exit (-16);
    }
  
  input = (char *) malloc(NUMLETTERS * sizeof(char)) ;
  if (input == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for input\n");
      exit (-17);
    }

  output = (char *) malloc(NUMLETTERS * sizeof(char)) ;
  if (output == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for output\n");
      exit (-18);
    }

  filename = (char *) malloc(FILENAMESIZE * sizeof(char)) ;
  if (filename == NULL)
    {
      fprintf(stderr, "Out of memory - getting space for filename\n");
      exit (-19);
    }

  outfilename = (char *) malloc(FILENAMESIZE * sizeof(char)) ;
  if (outfilename == NULL)
    {
      printf("Out of memory - getting space for outputfilename\n");
      exit(-20);
    }

  fprintf(stdout, "\nPLease Enter your input file: ");
  fscanf(stdin, "%s", filename);
  fprintf(stdout, "\nPlease enter your output file: ");
  fscanf(stdin, "%s", outfilename);

  ifp = fopen(filename, "r");
  if (ifp == NULL)
    {
    fprintf(stderr, "Can't open %s for reading.\n", filename); 
    exit(-1);
    }
  
  ofp = fopen(outfilename, "w");
  if (ifp == NULL) 
    {
      fprintf(stderr, "Can't open %s for writing.\n", outfilename); 
      exit(-1);
    }

  for(i = 0; i < ALPHABET; i++)
    {
      j++;
      character[i].input = j;
      character[i].output = Hailstones(character[i].input, ELEMENT);
    }

  /*Compare each character from input to outputs in charactertable*/
  /*If input character matches any encrypted character output*/
  /*match it with its corresponding decrypted value*/
  while(fgets(input, 80, ifp) != NULL)
    {
      for(k = 0; k < NUMLETTERS; k++)
	{
	  for(n = 0; n < ALPHABET; n++)
	    {
	      if(input[k] > 122)
		{
		  output[k] = input[k]; 
		}
	      else if(input[k] < 65)
		{
		  output[k] = input[k]; 
		}
	      else if(input[k] == character[n].output)
		{
		  output[k] = character[n].input;
		}	
	    }
	}
      fputs(output, ofp);
    }
   fclose(ifp);
   fclose(ofp);
   free(input);
   free(character);
   free(output);
}

/*************************************************************************
 * Function: Hailstones
 * 
 * This is a recursive function that returns any element of the Hailstone
 * of any given number
 *
 * Inputs : Number, element. 
 * Outputs: Hailstone sequence result.
 **************************************************************************/
int Hailstones(int num, int times)
{
  /*If the number is 1 end the Hailstone Sequence*/
  if(num == 1)
    {
      return num;
    }
  /*If the number of executions is 1 then stop*/
  else if(times == 1)
    {
      return num;
    }
  /*If even, divide by 2*/
  else if(num%2 == 0)
    {
      num /= 2;
    }
  /*If odd, multiply by 3 then add 1*/
  else if(num%2 != 0)
    {
      num *= 3;
      num++;
    }

  /*Do it again and again until it has found whichever element the user was*/
  /*Looking for*/
  num = Hailstones(num, times - 1);

  /*Exceptions that must be made for D,H,L,P,R,T,V,X,Z and any value*/
  /*greater than 122*/
  if(num == 17)
    {
      num = 111;
    }
  else if(num == 18)
    {
      num = 114;
    }
  else if(num == 19)
    {
      num = 115;
    }
  else if(num == 20)
    {
      num = 117;
    }
  else if(num == 124)
    {
      num = 120;
    }
  else if(num == 21)
    {
      num = 121;
    }
  else if(num == 130)
    {
      num = 97;
    }
  else if(num == 22)
    {
      num = 103;
    }
  else if(num == 136)
    {
      num = 109;
    }
  else if(num > 122)
    {
      num -= ALPHABET;
    }

  return num;
}
  
