package application;

import application.command.AddCommand;
import application.command.InfoCommand;
import application.command.LoadCommand;
import application.command.SaveCommand;
import application.exception.InvalidCatalogException;
import application.exception.ItemNotFoundCatalogException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable
{
    private String name;
    private List<Item> items;

    public Catalog(){}

    public Catalog(String name)
    {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Item> getItems()
    {
        return items;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
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
