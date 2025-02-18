package Model;

public class Products {
    private String name;
    private double price;
    private String universe;

    public Products(String name, double price, String universe) {
        this.name = name;
        this.price = price;
        this.universe = universe;
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

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", universe='" + universe + '\'' +
                '}';
    }
}
