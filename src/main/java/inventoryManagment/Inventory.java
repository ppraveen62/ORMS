package inventoryManagment;

import Exceptions.FailedOrderFullfilmentException;
import Exceptions.ProductNotFoundException;
import productManagment.ProductService;

import java.util.HashMap;
import java.util.Map;

public class Inventory  {

    private Map<String,Integer> stock;

    private ProductService productService;

    public Inventory(ProductService productService) {
        this.stock = new HashMap<>();
        this.productService = productService;
    }

    public void addStockOnProductsAdded(String productId, int newQty){
        if(!productService.isProductExists(productId)){
            throw new ProductNotFoundException("Product not found with id : "+productId);
        }
        if(stock.containsKey(productId)){
            int oldQty = stock.get(productId);
            stock.put(productId,newQty+oldQty);
            System.out.println("stock added for productId " + productId);
        }else {
            stock.put(productId, newQty);
            System.out.println("stock added for productId " + productId);
        }
    }

    public void updateStockOnOrderFullfilment(String productId, int qtyConsumed) {
        if(!productService.isProductExists(productId)){
            throw new ProductNotFoundException("Product not found with id : "+productId);
        }
        if(stock.containsKey(productId)){
            int oldQty = stock.get(productId);
            if(oldQty>0  && qtyConsumed<=oldQty){
                stock.put(productId,oldQty-qtyConsumed);
                System.out.println("stock updated for productId " + productId);
            }else {
                throw new FailedOrderFullfilmentException("insufficient stock for productId "
                        +productId + " needs stock "+(qtyConsumed-oldQty)+" to fullfill order") ;
            }

        }
    }
    public int getStockLevelById(String productId){
        if(!productService.isProductExists(productId)){
            throw new ProductNotFoundException("Product not found with id : "+productId);
        }
        return stock.get(productId);
    }


}
