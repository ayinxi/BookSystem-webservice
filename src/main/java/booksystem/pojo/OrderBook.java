package booksystem.pojo;

public class OrderBook {
    private String id;
    private String book_id;
    private String order_id;
    private int number;//图书数量
    private String creat_time;
    private String update_time;

    public OrderBook(){}

    public OrderBook(String id, String book_id,String order_id, int number, String creat_time, String update_time) {
        this.id = id;
        this.book_id=book_id;
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

    public int getNumber() {
        return number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setNumber(int number) {
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

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
}
