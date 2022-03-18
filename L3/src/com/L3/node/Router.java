package com.L3.node;

import com.L3.Identifiable;

public class Router extends Node implements Identifiable
{
    private String ipAddress;

    public Router(String name, String macAddress, String location, String ipAddress)
    {
        super(name, macAddress, location);
        this.ipAddress = ipAddress;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString()
    {
        return "Router{" +
                "name='" + getName() + '\'' +
                ", macAddress='" + getMacAddress() + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
