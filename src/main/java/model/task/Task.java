package model.task;
import model.Default;
import model.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Task extends Default {
    private String name;
    private String place;
    private Float importance;
    private String memo;
    private Date dueAt;
    private Integer completion;
    private Integer userId;
    private Integer categoryId;
    public Task(
            Integer id,
            String name,
            String place,
            Float importance,
            String memo,
            Date dueAt,
            Timestamp createdAt,
            Timestamp updatedAt,
            Integer completion,
            Integer userId,
            Integer categoryId
    ){
        //親クラス(Default)のコンストラクタを呼び出す
        super(id, createdAt, updatedAt);
        this.name=  name;
        this.place = place;
        this.importance = importance;
        this.memo = memo;
        this.dueAt = dueAt;
        this.completion = completion;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Float getImportance() {
        return importance;
    }

    public void setImportance(Float importance) {
        this.importance = importance;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getDueAt() {
        return dueAt;
    }

    public void setDueAt(Timestamp dueAt) {
        this.dueAt = dueAt;
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Task search(){
        Task task = Repository.search(this);
        return task;
    }

    public static ArrayList<Task> indexTasks(User user) {
        return Repository.indexTasks(user);
    }

    public void update(){Repository.update(this);}
}