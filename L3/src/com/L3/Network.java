package com.L3;

import com.L3.node.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Network
{
    private List<Node> nodes;

    public Network()
    {
        nodes = new ArrayList<>();
    }

    public List<Node> getNodes()
    {
        return nodes;
    }

    public void addNode(Node node)
    {
         for(Node temporaryNode : nodes)
         {
             if(temporaryNode.getName().equals(node.getName()))
             {
                 return;
             }
         }
         nodes.add(node);
    }

    public void deleteNode(Node node)
    {
        for(Node temporaryNode : nodes)
        {
            if(temporaryNode.getName().equals(node.getName()))
            {
                nodes.remove(node);
            }
        }
    }

    public void printIdentifiable()
    {
        List<Identifiable> list = new ArrayList<>();

        for(Object object : nodes)
        {
            if(object instanceof Identifiable)
            {
                list.add((Identifiable) object);
            }
        }

        list.sort((Identifiable i1, Identifiable i2) ->
        {
            return (i1.getIpAddress().compareTo(i2.getIpAddress()));
        });

        for(Identifiable identifiable : list)
        {
            System.out.printf("%s\n", identifiable);
        }
    }

    public void printNetwork()
    {
        for(Node node : nodes)
        {
            for(Map.Entry<Node, Integer> currentNode : node.getNeighborAndCost().entrySet())
            {
                System.out.printf("%s--%s %d\n", node.getName(), currentNode.getKey().getName(), currentNode.getValue());
            }
        }
    }

    //we will be using the Floyd Warshall algorithm
    public void solveAST()
    {
        //first we will define our weighted adjacency matrix
        int totalNodes = this.nodes.size();
        int [][] adjacencyMatrixWeighted = new int[totalNodes][totalNodes];

        for(int i = 0; i < totalNodes; i++)
        {
            for (int j = 0; j < totalNodes; j++)
            {
                if(i == j)
                {
                    adjacencyMatrixWeighted[i][j] = 0;
                }
                else
                {
                    adjacencyMatrixWeighted[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        //populating the adjacency matrix
        for(Node node : nodes)
        {
            for(Map.Entry<Node, Integer> tuple : node.getNeighborAndCost().entrySet())
            {
                //get the line from node
                int line = nodes.indexOf(node);

                //get the column
                int column = nodes.indexOf(tuple.getKey());

                //setting the weight
                adjacencyMatrixWeighted[line][column] = tuple.getValue();
            }
        }

        //applying the algorithm
        //iterate through all the nodes while "relaxing" the nodes.
        //we do this relaxation totalNodes times and
        //we will be sure that after totalNodes+1 there will be no relaxation happening
        for (int i = 0; i < totalNodes; i++)
        {
            for (int j = 0; j < totalNodes; j++)
            {
                for (int k = 0; k < totalNodes; k++)
                {
                    if(adjacencyMatrixWeighted[j][i] + adjacencyMatrixWeighted[i][k] < adjacencyMatrixWeighted[j][k])
                    {
                        adjacencyMatrixWeighted[j][k] = adjacencyMatrixWeighted[j][i] + adjacencyMatrixWeighted[i][k];
                    }
                }
            }
        }

        //printing the distance between identifiable nodes
        for(Node node1 : nodes)
        {
            for(Node node2 : nodes)
            {
                if((node1 instanceof Identifiable) &&
                        (node2 instanceof Identifiable) &&
                        (node1 != node2) &&
                        adjacencyMatrixWeighted[nodes.indexOf(node1)][nodes.indexOf(node2)] != Integer.MAX_VALUE)
                {
                    System.out.printf("%s -> %s : %d\n", node1.getName(), node2.getName(), adjacencyMatrixWeighted[nodes.indexOf(node1)][nodes.indexOf(node2)]);
                }
            }
        }

    }
}
