package booksystem.pojo;

public class Order_Book {
    private String id;
    private String order_id;
    private String number;//图书数量
    private String creat_time;
    private String update_time;

    public Order_Book(){}

    public Order_Book(String id, String order_id, String number,String creat_time,String update_time) {
        this.id = id;
        this.order_id = order_id;
        this.number = number;
        this.creat_time = creat_time;
        this.update_time=update_time;
    }

    public String getId() {
        return id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getNumber() {
        return number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getCreat_time() {
        return creat_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setCreat_time(String creat_time) {
        this.creat_time = creat_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
