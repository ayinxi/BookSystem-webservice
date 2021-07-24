package booksystem.pojo;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AliPay {

    /*商户订单号，必填*/
    private String order_id;
    /*付款金额，必填*/
    private String total_amount;
    /*商品描述，可空*/
    private String body;
    /*超时时间参数*/
    private String timeout_express="10m";
    private String product_code="FAST_INSTANT_TRADE_PAY";

    public AliPay() {
    }

    public AliPay(String order_id, String total_amount, String body) {
        this.order_id = order_id;
        this.total_amount = total_amount;
        this.body = body;
        this.timeout_express = "10m";
        this.product_code = "FAST_INSTANT_TRADE_PAY";
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public String getBody() {
        return body;
    }

    public String getTimeout_express() {
        return timeout_express;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    @Override
    public String toString() {
        return "AliPay{" +
                "order_id='" + order_id + '\'' +
                ", total_amount=" + total_amount +
                ", body='" + body + '\'' +
                ", timeout_express='" + timeout_express + '\'' +
                ", product_code='" + product_code + '\'' +
                '}';
    }
}
