package com.L3;

import com.L3.node.*;

import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args)
    {
	    Network myNetwork = new Network();
        Node n1 = new Computer("1", "AA:AA:AA:AA", "IS","192.168.0.255", 13);
        myNetwork.addNode(n1);

        Node n2 = new Computer("2", "AA:AA:AA:AA", "IS","192.168.0.21", 100);
        myNetwork.addNode(n2);

        //tested "var", it should not be used here as typing Node does not get any easier than this.
        var n3 = new Computer("3", "AA:AA:AA:AA", "IS","192.168.0.423", 100);
        myNetwork.addNode(n3);

        Node n4 = new Computer("4", "AA:AA:AA:AA", "IS","192.168.1.4", 100);
        myNetwork.addNode(n4);

        Node n5 = new Computer("5", "AA:AA:AA:AA", "IS","192.168.33.5", 100);
        myNetwork.addNode(n5);

        Node n6 = new Switch("6", "SW:IT:CH:01", "Iasi, IS");
        myNetwork.addNode(n6);

        Node n7 = new Router("7", "RO:UT:ER:RR", "Iasi, IS", "192.168.0.6");
        myNetwork.addNode(n7);

        //sorting the list with a lambda
        Collections.sort(myNetwork.getNodes(), (Node o1, Node o2) ->
        {
            return(o1.getName().compareTo(o2.getName()));
        });

        n1.addNeighbor(n2, 10);
        n1.addNeighbor(n3, 50);
        n2.addNeighbor(n4, 20);
        n2.addNeighbor(n5, 20);
        n2.addNeighbor(n3, 20);
        n3.addNeighbor(n4, 10);
        n4.addNeighbor(n5, 30);
        n4.addNeighbor(n6, 10);
        n5.addNeighbor(n6, 20);

        myNetwork.printNetwork();

        Computer c1 = (Computer) n1;
        System.out.println(c1.getStorageCapacity(Size.MB));

        myNetwork.printIdentifiable();
    }
}
