package booksystem.pojo;

public class Shop {
    private String id;
    private String user_id;//商家id
    private String avatar_b;
    private String avatar_s;
    private String shopper_name;//店主名
    private String shop_name;
    private double rate;//评分
    private int apply_pass;//1.已提交未审核 2.通过 3.拒绝
    private String apply_reason;
    private String check_opinion;//审核意见
    private String create_time;
    private String update_time;

    public Shop(){}

    public Shop(String id, String user_id, String avatar_b, String avatar_s, String shopper_name, String shop_name, double rate, int apply_pass, String apply_reason, String check_opinion, String create_time, String update_time) {
        this.id = id;
        this.user_id = user_id;
        this.avatar_b = avatar_b;
        this.avatar_s = avatar_s;
        this.shopper_name = shopper_name;
        this.shop_name = shop_name;
        this.rate = rate;
        this.apply_pass = apply_pass;//申请：1.已提交未审核 2.通过3.拒绝4.已注销
        this.apply_reason = apply_reason;
        this.check_opinion = check_opinion;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public String getShopper_name() {
        return shopper_name;
    }

    public String getCheck_opinion() {
        return check_opinion;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setShopper_name(String shopper_name) {
        this.shopper_name = shopper_name;
    }

    public void setCheck_opinion(String check_opinion) {
        this.check_opinion = check_opinion;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getApply_pass() {
        return apply_pass;
    }

    public String getApply_reason() {
        return apply_reason;
    }

    public void setApply_pass(int apply_pass) {
        this.apply_pass = apply_pass;
    }

    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAvatar_b(String avatar_b) {
        this.avatar_b = avatar_b;
    }

    public void setAvatar_s(String avatar_s) {
        this.avatar_s = avatar_s;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public String getAvatar_b() {
        return avatar_b;
    }

    public String getAvatar_s() {
        return avatar_s;
    }

    public String getShop_name() {
        return shop_name;
    }


    public String getUpdate_time() {
        return update_time;
    }


    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
