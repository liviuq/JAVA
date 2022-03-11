package com.L3;

import com.L3.node.Computer;
import com.L3.node.NameSortComparator;

import java.util.Collections;

public class Main {

    public static void main(String[] args)
    {
	    Network myNetwork = new Network();
        myNetwork.addNode(new Computer("1", "AA:AA:AA:AA", "IS","192.168.0.1", 100));
        myNetwork.addNode(new Computer("5", "AA:AA:AA:AA", "IS","192.168.0.2", 100));
        myNetwork.addNode(new Computer("3", "AA:AA:AA:AA", "IS","192.168.0.3", 100));
        myNetwork.addNode(new Computer("10", "AA:AA:AA:AA", "IS","192.168.0.4", 100));
        myNetwork.addNode(new Computer("0", "AA:AA:AA:AA", "IS","192.168.0.5", 100));

        Collections.sort(myNetwork.getNodes(), new NameSortComparator());
        myNetwork.printNetwork();
    }
}
