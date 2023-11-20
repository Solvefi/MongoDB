package mongodb.demo.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "restaurant")
public class Restaurant {
    @Id
    private String id;

    @Field(name="name")
    private String name;

    @Field(name="cuisine")
    private String cuisine;

    @Field(name="address")
    private String address;

    @Field(name="check")
    private int check;

//    @DBRef
//    List<Clothes> clothes;
//
//    public Restaurant(String name, String cuisine, String address, int check, List<Clothes> clothes) {
//        this.name = name;
//        this.cuisine = cuisine;
//        this.address = address;
//        this.check = check;
//        this.clothes = clothes;
//    }

    public Restaurant(String name, String cuisine, String address, int check) {
        this.name = name;
        this.cuisine = cuisine;
        this.address = address;
        this.check = check;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

//    public List<Clothes> getClothes() {
//        return clothes;
//    }
//
//    public void setClothes(List<Clothes> clothes) {
//        this.clothes = clothes;
//    }

    @Override
    public String toString() {
        return "Restaurant {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", address='" + address + '\''+
                ", check=" + check + '\''+
                //", clothes=" + clothes +
                '}';
    }
}
