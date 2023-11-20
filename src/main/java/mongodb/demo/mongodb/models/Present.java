package mongodb.demo.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "present")
public class Present {
    @Id
    private String id;

    @Field(name="type")
    private String type;

    @Field(name="color")
    private String color;

    @Field(name="gender")
    private String gender;

    @Field(name="price")
    private int price;

    public Present(String type, String color, String gender, int price) {
        this.type = type;
        this.color = color;
        this.gender = gender;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Present {" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", gender='" + gender + '\''+
                ", price=" + price +
                '}';
    }
}
