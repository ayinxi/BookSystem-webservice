package booksystem.pojo;

public class Order {
    private String id;
    private double total;//总金额
    private int status;//订单状态:1.未付款 2.已付款 3.未发货、4.已发货(未收货) 5.已收货、6.退货.未评价 7.已评价
    private int return_status;//退款状态：-1.无效 1.申请退款 2.同意 3.拒绝
    private String return_reason;//退货理由
    private String check_opinion;//审核意见
    private String address_id;
    private String shop_id;
    private String user_id;
    private String remark;//评价
    private double rate;//评分
    private String create_time;
    private String update_time;

    public Order(){}

    public Order(String id, double total, int status, int return_status, String return_reason, String check_opinion, String address_id, String shop_id, String user_id, String remark, double rate, String create_time, String update_time) {
        this.id = id;
        this.total = total;
        this.status = status;
        this.return_status = return_status;
        this.return_reason = return_reason;
        this.check_opinion = check_opinion;
        this.address_id = address_id;
        this.shop_id = shop_id;
        this.user_id = user_id;
        this.remark = remark;
        this.rate = rate;
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

    public int getReturn_status() {
        return return_status;
    }

    public String getReturn_reason() {
        return return_reason;
    }

    public String getCheck_opinion() {
        return check_opinion;
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

    public String getRemark() {
        return remark;
    }

    public double getRate() {
        return rate;
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

    public void setReturn_status(int return_status) {
        this.return_status = return_status;
    }

    public void setReturn_reason(String return_reason) {
        this.return_reason = return_reason;
    }

    public void setCheck_opinion(String check_opinion) {
        this.check_opinion = check_opinion;
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

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
