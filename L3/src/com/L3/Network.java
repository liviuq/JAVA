package com.L3;

import com.L3.node.Node;

import java.util.ArrayList;
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
}
