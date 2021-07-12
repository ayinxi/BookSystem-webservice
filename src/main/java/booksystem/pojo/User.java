package booksystem.pojo;

public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private int status;//是否激活
    private String activationCode;//激活码
    private String name;//昵称
    private String avatar_b;
    private String avatar_s;
    private String rgtime;//注册时间
    private int identity;//身份:0.游客(未登录) 1.未激活用户 2.激活用户 3.商家
    private int apply_pass;//0.未申请 1.未通过 2.已通过
    private String apply_reason;
    private String shop_id;//商家店铺id

    public User(){}

    public User(String id, String username, String password, String email, int status, String activationCode, String name, String avatar_b, String avatar_s, String rgtime, int identity,int apply_pass,String apply_reason, String shop_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.activationCode = activationCode;
        this.name = name;
        this.avatar_b = avatar_b;
        this.avatar_s = avatar_s;
        this.rgtime = rgtime;
        this.identity = identity;
        this.shop_id = shop_id;
        this.apply_reason=apply_reason;
        this.apply_pass=apply_pass;
    }

    public String getApply_reason() {
        return apply_reason;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public String getName() {
        return name;
    }

    public String getAvatar_b() {
        return avatar_b;
    }

    public String getAvatar_s() {
        return avatar_s;
    }

    public String getRgtime() {
        return rgtime;
    }

    public int getIdentity() {
        return identity;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar_b(String avatar_b) {
        this.avatar_b = avatar_b;
    }

    public void setAvatar_s(String avatar_s) {
        this.avatar_s = avatar_s;
    }

    public void setRgtime(String rgtime) {
        this.rgtime = rgtime;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    public int getApply_pass() {
        return apply_pass;
    }

    public void setApply_pass(int apply_pass) {
        this.apply_pass = apply_pass;
    }
}
