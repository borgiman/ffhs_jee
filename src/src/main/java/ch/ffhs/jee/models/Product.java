package ch.ffhs.jee.models;

public class Product {
    private final int id;
    private final int price;
    private final String vendorName;
    private final String productName;
    private final String shortDetail;
    private final int rating;
    private final int numberOfRatings;

    public Product(int id, int price, String vendorName, String productName, String shortDetail, int rating, int numberOfRatings) {
        this.id = id;
        this.price = price;
        this.vendorName = vendorName;
        this.productName = productName;
        this.shortDetail = shortDetail;
        this.rating = rating;
        this.numberOfRatings = numberOfRatings;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getShortDetail() {
        return this.shortDetail;
    }

    public int getRating() {
        return this.rating;
    }

    public int getNumberOfRatings() {
        return this.numberOfRatings;
    }
}
