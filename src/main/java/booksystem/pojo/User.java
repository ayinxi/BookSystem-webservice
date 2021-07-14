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
    private String create_time;//注册时间
    private String update_time;//注册时间
    private int identity;//身份:0.用户 1.商家
    private int apply_pass;//0.未申请 1.未通过 2.已通过
    private String apply_reason;
    private String shop_id;//商家店铺id
    private String access_time;

    public User(String id, String username, String password, String email, int status, String activationCode, String name, String avatar_b, String avatar_s, String create_time, String update_time, int identity, int apply_pass, String apply_reason, String shop_id, String access_time) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.activationCode = activationCode;
        this.name = name;
        this.avatar_b = avatar_b;
        this.avatar_s = avatar_s;
        this.create_time = create_time;
        this.update_time = update_time;
        this.identity = identity;
        this.apply_pass = apply_pass;
        this.apply_reason = apply_reason;
        this.shop_id = shop_id;
        this.access_time = access_time;
    }

    public User(){}


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

    public String getCreate_time() {
        return create_time;
    }

    public String getAccess_time() {
        return access_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setAccess_time(String access_time) {
        this.access_time = access_time;
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

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
