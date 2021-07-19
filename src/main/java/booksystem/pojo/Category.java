package booksystem.pojo;

public class Category {
    private String id;
    private String main_category;
    private String second_category;
    private boolean status;
    private String create_time;
    private String update_time;

    public Category(){}

    public Category(String id, String main_category, String second_category, boolean status, String create_time, String update_time) {
        this.id = id;
        this.main_category = main_category;
        this.second_category = second_category;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public String getId() {
        return id;
    }

    public String getMain_category() {
        return main_category;
    }

    public String getSecond_category() {
        return second_category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMain_category(String main_category) {
        this.main_category = main_category;
    }

    public void setSecond_category(String second_category) {
        this.second_category = second_category;
    }

    public boolean isStatus() {
        return status;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
