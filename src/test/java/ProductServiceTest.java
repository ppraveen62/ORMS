import org.junit.Test;
import productManagment.Clothings;
import productManagment.Electronics;
import productManagment.ProductService;

import static org.junit.Assert.assertTrue;

public class ProductServiceTest {
    @Test
    public void testAddElectronicProducts(){
        Electronics laptop = new Electronics("E2", "ipad screen", 999.99, "15 inch * 13 inch");
        ProductService productService = new ProductService();
        productService.addProduct(laptop);
        assertTrue(productService.isProductExists("E2"));
    }

    @Test
    public void testAddClothingProduct() {
        Clothings shirt = new Clothings("C2", "Shirt", 19.99, "M", "Blue");
        ProductService productService = new ProductService();
        productService.addProduct(shirt);
        assertTrue(productService.isProductExists("C2"));
    }

}
