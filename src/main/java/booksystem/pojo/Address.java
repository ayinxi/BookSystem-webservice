package booksystem.pojo;

public class Address {
    private String id;
    private String address;
    private String name;//收货人
    private String phone;
    private String user_id;
    private int status;//是否为默认地址
    private String creat_time;
    private String update_time;

    public Address(){}

    public Address(String id, String address, String name, String phone, String user_id, int status,String creat_time,String update_time) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.user_id = user_id;
        this.status = status;
        this.creat_time = creat_time;
        this.update_time=update_time;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", user_id='" + user_id + '\'' +
                ", status=" + status +
                ", creat_time='" + creat_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
