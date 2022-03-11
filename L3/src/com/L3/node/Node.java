package com.L3.node;

import java.util.Objects;

public class Node
{
    protected String name;
    protected String macAddress;
    protected String location;

    public Node(String name, String macAddress, String location)
    {
        this.name = name;
        this.macAddress = macAddress;
        this.location = location;
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
