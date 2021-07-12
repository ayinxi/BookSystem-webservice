package booksystem.pojo;

public class Cartitem {
    private String id;
    private int sum;//数量
    private String book_id;
    private String user_id;

    public Cartitem(){}

    public Cartitem(String id, int sum, String book_id, String user_id) {
        this.id = id;
        this.sum = sum;
        this.book_id = book_id;
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
