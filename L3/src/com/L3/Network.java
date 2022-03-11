package com.L3;

import com.L3.node.Node;

import java.util.ArrayList;
import java.util.List;

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
            System.out.printf("%s\n", node);
        }
    }
}
