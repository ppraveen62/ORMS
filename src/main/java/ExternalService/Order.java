package ExternalService;

public class Order {
    private int orderId;
    private String productId;
    private int orderedQty;
    private String address;

    public Order(int orderId, String productId, int orderedQty, String address) {
        this.orderId = orderId;
        this.productId = productId;
        this.orderedQty = orderedQty;
        this.address = address;
        
    }

    public String getProductId() {
        return productId;
    }

    public int getOrderedQty() {
        return orderedQty;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }
}
