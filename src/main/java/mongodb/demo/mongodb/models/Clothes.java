package mongodb.demo.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "clothes")
public class Clothes {
    @Id
    private String id;

    @Field(name="size")
    private String size;

    @Field(name="color")
    private String color;

    @Field(name="gender")
    private String gender;

    @Field(name="type")
    private String type;

    public Clothes(String size, String color, String gender, String type) {
        this.size = size;
        this.color = color;
        this.gender = gender;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Clothes {" +
                "id='" + id + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", gender=" + gender + '\''+
                ", type=" + type + '\''+
                '}';
    }
}

