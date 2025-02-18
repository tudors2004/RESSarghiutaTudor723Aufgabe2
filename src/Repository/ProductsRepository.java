package Repository;
import Model.Products;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {
    List<Products> products=new ArrayList<>();
    public void addProduct(Products product){
        products.add(product);
    }
    public void deleteProduct(String name){
        products.removeIf(product -> product.getName().equals(name));
    }
    public void updateProduct(Products newProduct, String name){
        deleteProduct(name);
        addProduct(newProduct);
    }
    public List<Products> getAllProducts(){
        return products;
    }
    public Products getProductByName(String name){
        for (Products product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
