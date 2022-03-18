package com.L3.node;

public class Switch extends Node
{
    public Switch(String name, String macAddress, String location)
    {
        super(name, macAddress, location);
    }

    @Override
    public String toString()
    {
        return "Switch{" +
                "name='" + getName() + '\'' +
                ", macAddress='" + getMacAddress() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
