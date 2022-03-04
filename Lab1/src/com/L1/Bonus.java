package com.L1;

import java.util.ArrayList;

public class Bonus
{
    private int numberOfNodes;

    //this list holds lists of positions for every node
    private ArrayList<ArrayList<Integer>> wordNeighboursInt;

    //list to hold the positions of words in cycle
    ArrayList<Integer> wordsInCycle;

    //constructor
    public Bonus(int numberOfNodes)
    {
        this.numberOfNodes = numberOfNodes;
        //initialising wordNeighboursInt

        wordNeighboursInt = new ArrayList<ArrayList<Integer>>(numberOfNodes);
        //adding n lists of integers to our list
        for(int i = 0; i < numberOfNodes; i++)
        {
            wordNeighboursInt.add(new ArrayList<Integer>());
        }

        //initialising wordsInCycle
        wordsInCycle = new ArrayList<Integer>();
    }

    //populates generateWordIntegerNeighbours with the adjacencyMatrix created in Homework
    public void generateWordIntegerNeighbours(boolean[][] adjacencyMatrix)
    {
        //iterating through the matrix to find all neighbours of node i
        for(int i = 0; i < numberOfNodes; i++)
        {
            for(int j = 0; j < numberOfNodes; j++)
            {
                if(adjacencyMatrix[i][j])
                {
                    //we get the list at position i and push back position j
                    wordNeighboursInt.get(i).add(j);
                }
            }
        }
    }

    //dfs function to check for cycle in the connected component that the node start
    //belongs to
    public int dfs(boolean[] isVisited, int start, int parent)
    {
        //clearing the cycle
        wordsInCycle.clear();

        //visit the start node
        isVisited[start] = true;
        //exploring start's neighbours to see if we call dfs recursively
        for(Integer wordNeighbourInt : wordNeighboursInt.get(start))
        {
            //check if wordNeighbourInt is not visited
            if(!isVisited[wordNeighbourInt])
            {
                //call dfs from this node
                int dfsReturnValue = dfs(isVisited, wordNeighbourInt, start);
                if(dfsReturnValue == 1)
                {
                    //if dfsReturnValue is 1, then we found a cycle, so we add start to
                    //the cycle
                    wordsInCycle.add(start);

                    //return 1 so we notify dfs that we found a cycle
                    return 1;
                }
                else
                {
                    if(wordNeighbourInt != parent)
                    {
                        wordsInCycle.add(start);
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public void printCycle()
    {
        for(Integer word : wordsInCycle)
        {
            System.out.printf("%d ", word);
        }
    }
}
