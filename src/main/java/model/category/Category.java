package model.category;
import model.Default;
import java.sql.Timestamp;
public class Category extends Default {
    private String name;
    private Integer color;
    public Category(
            Integer id,
            String name,
            Integer color,
            Timestamp createdAt,
            Timestamp updatedAt,
            Integer user_id
    ){
        //親クラス(Default)のコンストラクタを呼び出す
        super(id, createdAt, updatedAt);
        this.name=  name;
        this.color = color;
    }


}