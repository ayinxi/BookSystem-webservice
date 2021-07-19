package booksystem.pojo;

public class Book {
    private String id;
    private String book_name;
    private String author;
    private double price;
    private int volume;//销量
    private int repertory;//库存
    private String press;//出版社
    private int edition;//版本
    private String print_time;
    private String image_b;
    private String image_s;
    private String category_id;//目录id
    private String shop_id;//店铺id
    private String create_time;
    private String update_time;

    public Book(){}
    public Book(String id, String book_name, String author, double price, int volume, int repertory, String press, int edition, String print_time, String image_b, String image_s, String category_id, String shop_id,String create_time,String update_time) {
        this.id = id;
        this.book_name = book_name;
        this.author = author;
        this.price = price;
        this.volume = volume;//销量
        this.repertory = repertory;//库存
        this.press = press;//出版社
        this.edition = edition;
        this.print_time = print_time;
        this.image_b = image_b;
        this.image_s = image_s;
        this.category_id = category_id;
        this.shop_id = shop_id;
        this.create_time = create_time;
        this.update_time=update_time;
    }

    public String getId() {
        return id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public int getRepertory() {
        return repertory;
    }

    public String getPress() {
        return press;
    }

    public int getEdition() {
        return edition;
    }

    public String getPrint_time() {
        return print_time;
    }

    public String getImage_b() {
        return image_b;
    }

    public String getImage_s() {
        return image_s;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setPrint_time(String print_time) {
        this.print_time = print_time;
    }

    public void setImage_b(String image_b) {
        this.image_b = image_b;
    }

    public void setImage_s(String image_s) {
        this.image_s = image_s;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setCreat_time(String create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
