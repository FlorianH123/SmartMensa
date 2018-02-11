package de.stl.saar.internetentw2.dao.entity;

import de.stl.saar.internetentw2.model.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DishEntity {
    private long dishId;
    private String name;
    private double price;
    private Category category;
    private String imageName;

    protected DishEntity() {
    }

    public DishEntity(String name, double price, Category category, String imageName) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.imageName = imageName;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
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
}
