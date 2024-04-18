package productManagment;

public class Electronics extends Product {

    private String specifications;
    public Electronics(String productId, String productName, double price,String specifications) {
        super(productId, productName, price);
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return "Electronics{"+
                "productId='" + super.getProductId() + '\'' +
                ", productName='" + super.getProductName() + '\'' +
                ", price=" + super.getPrice() + '\'' +
                ", specifications='" + specifications + '\'' +
                '}';
    }

    @Override
    public String displayProductDetails() {
        return toString();
    }

}
