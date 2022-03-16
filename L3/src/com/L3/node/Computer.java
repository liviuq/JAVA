package com.L3.node;

import com.L3.Identifiable;
import com.L3.Storage;

public class Computer extends Node implements Identifiable, Storage
{
    private String ipAddress;
    private int storageCapacity;

    public Computer(String name, String macAddress, String location, String ipAddress, int storageCapacity)
    {
        super(name, macAddress, location);
        this.ipAddress = ipAddress;
        this.storageCapacity = storageCapacity;
    }

    public int getStorageCapacity()
    {
        return storageCapacity;
    }

    @Override
    public void setStorageCapacity(int storageCapacity)
    {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String getIpAddress()
    {
        return ipAddress;
    }

    @Override
    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString()
    {
        return "Computer{" +
                "ipAddress='" + ipAddress + '\'' +
                ", storageCapacity=" + storageCapacity +
                ", name='" + getName() + '\'' +
                ", macAddress='" + getMacAddress() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
