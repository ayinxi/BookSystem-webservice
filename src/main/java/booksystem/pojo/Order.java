package booksystem.pojo;

public class Order {
    private String id;
    private double total;//总金额
    private int status;//订单状态:1.未付款 2.已付款 3.未发货、4.已发货(未收货) 5.已收货、6.退货.未评价 7.已评价
    private String address_id;
    private String shop_id;
    private String user_id;
    private String create_time;
    private String update_time;

    public Order(){}


    public Order(String id, double total, int status, String address_id, String shop_id, String user_id, String create_time, String update_time) {
        this.id = id;
        this.total = total;
        this.status = status;
        this.address_id = address_id;
        this.shop_id = shop_id;
        this.user_id = user_id;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public String getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public int getStatus() {
        return status;
    }

    public String getAddress_id() {
        return address_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
