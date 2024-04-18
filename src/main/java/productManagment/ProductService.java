package productManagment;

import Exceptions.AlreadyFoundException;
import Exceptions.ProductNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private Map<String,Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product){
        if(products.containsKey(product.getProductId())){
            throw new AlreadyFoundException("Product already found with id : "+ product.getProductId());
        }
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product.getProductId());
    }

    public String displayProductById(String id){
        if(products.containsKey(id)){
            Product product = products.get(id);
            return product.displayProductDetails();
        }else{
            throw new ProductNotFoundException("product not found with id : "+id);
        }
    }

    public List<Product> displayAllProducts(){
        return products.values().stream().toList();
    }

    public boolean isProductExists(String id) {
        return products.containsKey(id);
    }


}
