package booksystem.pojo;

public class OrderBook {
    private String id;
    private String book_id;
    private String order_id;
    private int number;//图书数量
    private String remark;
    private double rate;
    private int return_status;//退款状态：-1.无效 1.申请退款未审核 2.同意 3.拒绝
    private String return_reason;//退货理由
    private String check_opinion;//审核意见

    public OrderBook(){}

    public OrderBook(String id, String book_id, String order_id, int number, String remark, double rate, int return_status, String return_reason, String check_opinion) {
        this.id = id;
        this.book_id = book_id;
        this.order_id = order_id;
        this.number = number;
        this.remark = remark;
        this.rate = rate;
        this.return_status = return_status;
        this.return_reason = return_reason;
        this.check_opinion = check_opinion;
    }

    public double getRate() {
        return rate;
    }

    public int getReturn_status() {
        return return_status;
    }

    public String getReturn_reason() {
        return return_reason;
    }

    public void setRate(double rate) {
        this.rate = rate;
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

    public String getCheck_opinion() {
        return check_opinion;
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

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
