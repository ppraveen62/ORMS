package ExternalService;

import Exceptions.ProductNotFoundException;
import inventoryManagment.Inventory;
import productManagment.ProductService;

public class ShippingService {
    private ProductService productService;
    private Inventory inventory;
    public ShippingService(ProductService productService,Inventory inventory){
        this.productService = productService;
        this.inventory = inventory;
    }

    public void shipOrder(Order order){
        if(!productService.isProductExists(order.getProductId())){
            throw new ProductNotFoundException("Product not found with id : "+order.getProductId());
        }
        System.out.println("shipping in progress for orderId : "+order.getOrderId());
        inventory.updateStockOnOrderFullfilment(order.getProductId(),order.getOrderedQty());
    }
}
