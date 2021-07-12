package booksystem.pojo.admin;

public class Admin {
    String id;
    String username;
    String password;
    String avatar_b;
    String avatar_s;
    String name;

    public Admin() {
    }

    public Admin(String id, String username, String password, String avatar_b, String avatar_s, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar_b = avatar_b;
        this.avatar_s = avatar_s;
        this.name = name;
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

    public String getAvatar_b() {
        return avatar_b;
    }

    public String getAvatar_s() {
        return avatar_s;
    }

    public String getName() {
        return name;
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

    public void setAvatar_b(String avatar_b) {
        this.avatar_b = avatar_b;
    }

    public void setAvatar_s(String avatar_s) {
        this.avatar_s = avatar_s;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar_b='" + avatar_b + '\'' +
                ", avatar_s='" + avatar_s + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
