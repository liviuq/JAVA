/**
 * This is the Homework part of Lab1
 * @author  Petrache Andrei Liviu
 * @group 2A3
 * @version 1.0
 * @since   24 Feb 2022
 */

package com.L1;

import java.lang.StringBuffer;
import java.util.LinkedList;

public class Homework
{
    public static void main(String[] args)
    {
        /**
         * Let n, p be two integers and C1,...,Cm a set of letters (the alphabet),
         * all given as a command line arguments. Validate the arguments!
         */
        int n = 0, p = 0;

        //Checking to see if we have remaining letters for the alphabet
        if(args.length - 2 <= 0)
            System.exit(1);

        //Create the alphabet using StringBuffer
        StringBuffer alphabet = new StringBuffer(args.length - 2);
        if(args.length >= 3)
        {
            try
            {
                //Try extracting n,p from the argument list
                n = Integer.parseInt(args[0]);
                p = Integer.parseInt(args[1]);

                //Try extracting the alphabet
                for(int i = 2; i < args.length; i++)
                {
                    alphabet.append(args[i].charAt(0));
                }
            }
            catch (NumberFormatException e)
            {
                System.out.printf("First 2 args must be ints!\n");
                System.exit(2);
            }
        }

        System.out.printf("n = %d, p = %d\nAlphabet: %s\n", n, p, alphabet);
        
        /**
         * Create an array of n strings (called words), each word containing exactly p characters from the given alphabet.
         * Display on the screen the generated array.
         */

        //Initialised the array of words
        StringBuilder[] words = new StringBuilder[n];
        for (int i = 0; i < n; i++)
        {
            //initialising every word
            words[i] = new StringBuilder();
        }

        //generating random words
        for(int i = 0; i < n; i++) //for words
        {
            for(int j = 0; j < p; j++)
            {
                //random char from alphabet
                int position = (int) (Math.random() * 1000000) % alphabet.length();
                words[i].insert(j, alphabet.charAt(position));
            }
        }

        //printing the words
        for(StringBuilder word : words)
        {
            System.out.printf("%s\n", word);
        }

        /**
         * Create a boolean n x n matrix, representing the adjacency relation of the words.
         */
        boolean[][] adjacency = new boolean[n][n];

        //Defaulting it to 0
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                adjacency[i][j] = false;
            }
        }

        //Measuring the time taken
        long begin = System.nanoTime();

        //Discovering the neighbors
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                //primary diagonal
                if(i == j)
                    continue;

                //check for neighbourhoodness
                //iterating through words[i] characters
                //and check to see if they exist in words[j]
                for(int k = 0; k < words[i].length(); k++)
                {
                    if(words[j].indexOf(  words[i].substring(k,k+1)  ) != -1)
                    {
                        adjacency[i][j] = true;
                        adjacency[j][i] = true;
                        break;
                    }
                }
            }
        }

        //saving current time
        double end = System.nanoTime();
        //printing the delta between end and begin times, dividing it over 10^9 so the result is in seconds
        System.out.println("Time taken in seconds: " + (end - begin)/1000000000);

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.printf("%b ", adjacency[i][j]);
            }
            System.out.println("");
        }

        /**
         * Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen.
         */
        //Created a linked list of strings to hold the neighbours of each word
        LinkedList<String>[] wordNeighbours = new LinkedList[n];
        for(int i = 0; i < n; i++)
        {
            //initialised the linked lists
            wordNeighbours[i] = new LinkedList<String>();
        }

        //looping through every word
        //it can be more efficient to check the half above the primary diagonal
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                //if word[i] and word[j] are adjacent
                if(adjacency[i][j] == true)
                {
                    //add word[j] as neighbor of word[i] using the toString method for the StringBuilder
                    wordNeighbours[i].add(words[j].toString());
                }
            }
        }

        //printing the neighbours
        for(int i = 0; i < n; i++)
        {
            System.out.println("Neighbours of " + words[i] + ":");
            for(int j = 0; j < wordNeighbours[i].size(); j++)
            {
                System.out.printf("%s ", wordNeighbours[i].get(j));
            }
            System.out.println("");
        }
    }
}
