package Model;

import java.util.ArrayList;
import java.util.List;

public class Characters {
    private int id;
    private String name;
    private String region;
    private List<Products> products;

    public Characters(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.products = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Characters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", products=" + products +
                '}';
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public void kaufeProdukt(Products products) {
        this.products.add(products);
    }
}
