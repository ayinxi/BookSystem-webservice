package booksystem.pojo;

public class Shop {
    private String id;
    private String avatar_b;
    private String avatar_s;
    private String shop_name;
    private double rate;//评分
    private String creat_time;
    private String update_time;

    public Shop(){}

    public Shop(String id, String avatar_b, String avatar_s, String shop_name,double rate,String creat_time,String update_time) {
        this.id = id;
        this.avatar_b = avatar_b;
        this.avatar_s = avatar_s;
        this.shop_name = shop_name;
        this.creat_time = creat_time;
        this.update_time=update_time;
        this.rate=rate;
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
