package com.L3;

public interface Storage
{
    int getStorageCapacity();
    void setStorageCapacity(int storageCapacity);
    default int getStorageCapacity(Size size)
    {
        if (size == Size.KB)
            return getStorageCapacity() * 1048576;
        else if (size == Size.MB)
            return getStorageCapacity() * 1000;
        else if (size == Size.BYTE)
            return getStorageCapacity() * 1_000_000_000;
        return getStorageCapacity();
    }
}
