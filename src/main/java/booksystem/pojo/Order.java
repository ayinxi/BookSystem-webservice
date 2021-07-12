package booksystem.pojo;

public class Order {
    private String id;
    private String order_time;
    private double total;//总金额
    private int status;//订单状态：1.未发货、2.未收货、3.未评价、4.已评价
    private String address_id;
    private String user_id;
    private String remark;//评价
    private double rate;//评分

    public Order(){}

    public Order(String id, String order_time, double total, int status, String address_id, String user_id,String remark,double rate) {
        this.id = id;
        this.order_time = order_time;
        this.total = total;
        this.status = status;
        this.address_id = address_id;
        this.user_id = user_id;
        this.remark=remark;
        this.rate=rate;
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
}
