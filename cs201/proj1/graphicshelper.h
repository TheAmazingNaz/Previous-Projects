/***************************************** 
** File: graphicshelper.h 
** Author: Ryan Bergeron
** Date: 10/1/2008
** 
** E-mail: rberge1@umbc.edu 
** 
** This file contains graphic helper functions for creating a picture,
** and creating an animated picture.
** 
** 
** Other files required are 
** 1. graphicshelper.o - contains the binary code of the functions 
** ***********************************************/ 

#ifndef _GRAPHICS_HELPER_H_
#define _GRAPHICS_HELPER_H_


/************************************************ 
** CreatePPM -- 
** This function creates a PPM picture file from an Array. 
**  
** Inputs: Array of integers, time of creation
** Output: NONE 
**************************************************/ 

void CreatePPM(int array [][15], int time);

/************************************************ 
** ShowOilSpill -- 
** This function creates an animated gif from PPM files in your
** directory. 
**  
** Inputs: Number of images, increment of filenames
** Output: NONE 
**************************************************/ 

void ShowOilSpill(int numFrames, int step);

#endif
