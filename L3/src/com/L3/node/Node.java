package com.L3.node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Node
{
    private String name;
    private String macAddress;
    private String location;
    private Map<Node, Integer> neighborAndCost;

    public Node(String name, String macAddress, String location)
    {
        this.name = name;
        this.macAddress = macAddress;
        this.location = location;
        this.neighborAndCost = new HashMap<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Map<Node, Integer> getNeighborAndCost()
    {
        return neighborAndCost;
    }

    /**
     * Copies the entire map given as parameter into the current node's map
     * @param neighborAndCost
     */
    public void setNeighborAndCost(Map<Node, Integer> neighborAndCost)
    {
        if(neighborAndCost == null) { return; }
        this.neighborAndCost.putAll(neighborAndCost);
    }

    /**
     * Adds a path of cost "cost" to "neighbor" from the current node.
     *
     *we might not want to check for duplicates because, in a "real" network,
     *there might be multiple direct routes from v1 to v2 that might
     *have different time costs.
     * @param neighbor
     * @param cost
     */
    public void addNeighbor(Node neighbor, Integer cost)
    {
        neighborAndCost.put(neighbor, cost);
    }

    public void deleteNeighbor(Node neighbor)
    {
        neighborAndCost.remove(neighbor);
    }

    /**
     * An object is equal to another object if and only if
     * the MAC addresses are identical
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(macAddress);
    }

    @Override
    public String toString()
    {
        return "Node{" +
                "name='" + name + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
