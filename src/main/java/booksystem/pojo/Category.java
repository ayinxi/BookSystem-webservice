package booksystem.pojo;

public class Category {
    private String id;
    private String main_category;
    private String second_category;

    public Category(){}

    public Category(String id, String main_category, String second_category) {
        this.id = id;
        this.main_category = main_category;
        this.second_category = second_category;
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
}
