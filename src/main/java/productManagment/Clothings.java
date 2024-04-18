package productManagment;

public class Clothings extends Product{
    private String size;
    private String color;

    public Clothings(String productId, String productName, double price , String size , String color) {
        super(productId, productName, price);
        this.size = size;
        this.color= color;
    }

    @Override
    public String toString() {
        return "Clothings{"+
                "productId='" + super.getProductId() + '\'' +
                ", productName='" + super.getProductName() + '\'' +
                ", price=" + super.getPrice() + '\'' +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public String displayProductDetails() {
        return  toString();
    }
}
