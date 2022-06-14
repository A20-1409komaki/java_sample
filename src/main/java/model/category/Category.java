package model.category;
import model.Default;
import model.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Category extends Default {
    private String name;
    private String color;
    private Integer userId;
    public Category(
            Integer id,
            String name,
            String color,
            Timestamp createdAt,
            Timestamp updatedAt,
            Integer userId
    ){
        //親クラス(Default)のコンストラクタを呼び出す
        super(id, createdAt, updatedAt);
        this.name=  name;
        this.color = color;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void insert() {
        Repository.insert(this);
    }

    public static ArrayList<Category> indexCategories(User user) {
        return Repository.indexCategories(user);
    }


}