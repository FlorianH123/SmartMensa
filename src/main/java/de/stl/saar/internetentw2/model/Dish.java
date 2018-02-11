package de.stl.saar.internetentw2.model;

public class Dish {
    private Long id;
    private String name;
    private double price;
    private Category category;
    private String imageName;

    public Dish() {
    }

    public Dish(String name, double price, Category category, String imageName) {
        id = 0L;
        this.name = name;
        this.price = price;
        this.category = category;
        this.imageName = imageName;
    }

    public Dish(Long id, String name, double price, Category category, String imageName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.imageName = imageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
