package application.command;

import application.Catalog;

public abstract class ListCommand
{
    public static void list(Catalog catalog)
    {
        System.out.println(catalog);
    }
}
