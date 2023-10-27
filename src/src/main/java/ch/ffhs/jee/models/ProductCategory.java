package ch.ffhs.jee.models;

public class ProductCategory {
    private final int id;
    private final String name;

    public ProductCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
