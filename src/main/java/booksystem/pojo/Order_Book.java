package booksystem.pojo;

public class Order_Book {
    private String id;
    private String order_id;
    private String number;//图书数量

    public Order_Book(){}

    public Order_Book(String id, String order_id, String number) {
        this.id = id;
        this.order_id = order_id;
        this.number = number;
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
}
