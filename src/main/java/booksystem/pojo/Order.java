package booksystem.pojo;

public class Order {
    private String id;
    private String order_time;
    private double total;//总金额
    private int status;//订单状态:1.未付款 2.已付款 3.未发货、4.已发货(未收货) 5.已收货、6.退货.未评价 7.已评价
    private String address_id;
    private String user_id;
    private String remark;//评价
    private double rate;//评分
    private String creat_time;
    private String update_time;

    public Order(){}

    public Order(String id, String order_time, double total, int status, String address_id, String user_id,String remark,double rate,String creat_time,String update_time) {
        this.id = id;
        this.order_time = order_time;
        this.total = total;
        this.status = status;
        this.address_id = address_id;
        this.user_id = user_id;
        this.remark=remark;
        this.rate=rate;
        this.creat_time = creat_time;
        this.update_time=update_time;
    }

    public String getId() {
        return id;
    }

    public String getOrder_time() {
        return order_time;
    }

    public double getTotal() {
        return total;
    }

    public int getStatus() {
        return status;
    }

    public String getRemark() {
        return remark;
    }

    public double getRate() {
        return rate;
    }

    public String getAddress_id() {
        return address_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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
