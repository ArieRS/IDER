package jti46.ider.engine;

/**
 * Created by yunhasnawa on 11/03/17.
 */

public class Commodity
{
    private int id;
    private String name;
    private double price;
    private double count;

    public Commodity()
    {

    }

    public Commodity(int id, String name, double price, double count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
