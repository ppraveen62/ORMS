import ExternalService.Order;
import ExternalService.ShippingService;
import inventoryManagment.Inventory;
import org.junit.Test;
import productManagment.Clothings;
import productManagment.Electronics;
import productManagment.ProductService;

import static org.junit.Assert.assertEquals;

public class ExternalServiceTest {

    @Test
    public void testShipOrder(){
        ProductService productService= new ProductService();
        Electronics laptop = new Electronics("E2", "ipad screen", 999.99, "15 inch * 13 inch");
        Clothings shirt = new Clothings("C2", "Shirt", 19.99, "M", "Blue");
        productService.addProduct(laptop);
        productService.addProduct(shirt);

        Inventory inventory = new Inventory(productService);
        inventory.addStockOnProductsAdded("E2",5);
        inventory.addStockOnProductsAdded("C2",10);

        ShippingService shippingService = new ShippingService(productService,inventory);

        Order order = new Order(214,"E2",3,
                "konark street,shantinagar,Hyderabad, 522032,9033494334");
        shippingService.shipOrder(order);

        assertEquals(2,inventory.getStockLevelById("E2"));

    }

}
