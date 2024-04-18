import inventoryManagment.Inventory;
import org.junit.Test;
import productManagment.Clothings;
import productManagment.Electronics;
import productManagment.ProductService;

import static org.junit.Assert.assertEquals;

public class InventoryServiceTest {

    @Test
    public void testAddStockOnProduct(){

        ProductService productService= new ProductService();

        Electronics laptop = new Electronics("E2", "ipad screen", 999.99, "15 inch * 13 inch");
        Clothings shirt = new Clothings("C2", "Shirt", 19.99, "M", "Blue");

        productService.addProduct(laptop);
        productService.addProduct(shirt);

        Inventory inventory = new Inventory(productService);

        inventory.addStockOnProductsAdded("E2",5);
        inventory.addStockOnProductsAdded("C2",10);

        assertEquals(5,inventory.getStockLevelById("E2"));
        assertEquals(10, inventory.getStockLevelById("C2"));
    }


    @Test
    public void testUpdateStockOnOrderFullfillment(){
        ProductService productService= new ProductService();
        Electronics laptop = new Electronics("E2", "ipad screen", 999.99, "15 inch * 13 inch");
        Clothings shirt = new Clothings("C2", "Shirt", 19.99, "M", "Blue");
        productService.addProduct(laptop);
        productService.addProduct(shirt);

        Inventory inventory = new Inventory(productService);
        inventory.addStockOnProductsAdded("E2",5);
        inventory.addStockOnProductsAdded("C2",10);

        inventory.updateStockOnOrderFullfilment("C2",5);
        assertEquals(5,inventory.getStockLevelById("C2"));
    }
}
