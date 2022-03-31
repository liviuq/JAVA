package application.command;

import application.Catalog;
import application.Item;
import application.exception.InvalidCatalogException;

public abstract class AddCommand
{
    public static void add(Catalog catalog, Item item) throws InvalidCatalogException
    {
        //check to see if the item is unique
        for(Item catalogItem : catalog.getItems())
        {
            if(catalogItem.equals(item))
                return;
        }

        catalog.getItems().add(item);
    }
}
