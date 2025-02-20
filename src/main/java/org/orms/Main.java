package org.orms;

import Exceptions.FailedOrderFullfilmentException;
import ExternalService.Order;
import ExternalService.ShippingService;
import inventoryManagment.Inventory;
import productManagment.Clothings;
import productManagment.Electronics;
import productManagment.ProductService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        Electronics laptop = new Electronics("E1", "Laptop screen", 999.99, "15 inch * 13 inch");
        Clothings shirt = new Clothings("C1", "Shirt", 19.99, "M", "Blue");

        ProductService productService = new ProductService();
        productService.addProduct(laptop);
        productService.addProduct(shirt);

        // display product by id sss
        System.out.println(productService.displayProductById("C1"));

        // adding stock to inventory

        Inventory inventory = new Inventory(productService);
        inventory.addStockOnProductsAdded("C1",5);
        inventory.addStockOnProductsAdded("E1",3);

       // displaying stock by id
        System.out.println("stock of product id C1 is "+inventory.getStockLevelById("C1"));

        //adding stock to existing and checking
        inventory.addStockOnProductsAdded("C1",10);
        System.out.println("stock of product id C1 is "+inventory.getStockLevelById("C1"));

        //updating stock to existing and checking
        inventory.updateStockOnOrderFullfilment("E1",2);
        System.out.println("stock of product id E1 is "+inventory.getStockLevelById("E1"));


        //displaying all producs
        System.out.println(productService.displayAllProducts().toString());

        //placing order and checking stock

        ShippingService shippingService=new ShippingService(productService,inventory);

        Order order1 = new Order(214,"E1",1,
                            "konark street,shantinagar,Hyderabad, 522032,9033494334");
        Order order2 = new Order(215,"C1",3,
                "konark street,shantinagar,Hyderabad, 522032,9033494334");


        shippingService.shipOrder(order1);
        shippingService.shipOrder(order2);

        //stock checking after order placement
        System.out.println("stock of product id C1 is "+inventory.getStockLevelById("C1"));
        System.out.println("stock of product id E1 is "+inventory.getStockLevelById("E1"));


        // task 2

        String apiUrl = "https://bportaluri.com/wp-content/MaximoJavaDocs76/";
        try{


            URL url =new URL(apiUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            System.out.println(httpURLConnection.getResponseCode());

            Scanner scanner = new Scanner(httpURLConnection.getInputStream());
            StringBuffer response = new StringBuffer();

            while (scanner.hasNextLine()){
                response.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println("Retrived assest from Maximo api");
            System.out.println(response.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }





    }
}