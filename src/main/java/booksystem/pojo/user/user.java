package booksystem.pojo.user;
import java.util.Date;
public class user {
    private String id;
    private String username;
    private String password;
    private String email;
    private int status;
    private char activationCode;
    private String name;
    private String avator_b;
    private String avator_s;
    private java.util.Date rgtime;
    private int identity;
    private int shop_id;

    public user(){}
    public user(String id, String username, String password, String email, int status, char activationCode, String name, String avator_b, String avator_s, Date rgtime, int identity, int shop_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.activationCode = activationCode;
        this.name = name;
        this.avator_b = avator_b;
        this.avator_s = avator_s;
        this.rgtime = rgtime;
        this.identity = identity;
        this.shop_id = shop_id;
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

    public char getActivationCode() {
        return activationCode;
    }

    public String getName() {
        return name;
    }

    public String getAvator_b() {
        return avator_b;
    }

    public String getAvator_s() {
        return avator_s;
    }

    public Date getRgtime() {
        return rgtime;
    }

    public int getIdentity() {
        return identity;
    }

    public int getShop_id() {
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

    public void setActivationCode(char activationCode) {
        this.activationCode = activationCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvator_b(String avator_b) {
        this.avator_b = avator_b;
    }

    public void setAvator_s(String avator_s) {
        this.avator_s = avator_s;
    }

    public void setRgtime(Date rgtime) {
        this.rgtime = rgtime;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", activationCode=" + activationCode +
                ", name='" + name + '\'' +
                ", avator_b='" + avator_b + '\'' +
                ", avator_s='" + avator_s + '\'' +
                ", rgtime=" + rgtime +
                ", identity=" + identity +
                ", shop_id=" + shop_id +
                '}';
    }
}
