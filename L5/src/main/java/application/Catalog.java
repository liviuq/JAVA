package application;

import application.exception.InvalidCatalogException;
import application.exception.ItemNotFoundCatalogException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable
{
    private String name;
    private List<Item> items;

    public Catalog(String name)
    {
        this.name = name;
        items = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void add(Item item) throws InvalidCatalogException
    {
        //check to see if the item is unique
        for(Item catalogItem : items)
        {
            if(catalogItem.equals(item))
                return;
        }

        items.add(item);
    }

    public Item findById(String id) throws ItemNotFoundCatalogException
    {
        return items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
