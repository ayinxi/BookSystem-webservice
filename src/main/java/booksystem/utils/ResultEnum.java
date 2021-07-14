package booksystem.utils;


public enum ResultEnum {
    //可自行定义，与前端交互
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    User_NOT_EXIST(1,"用户不存在"),
    User_IS_EXISTS(2,"已存在"),
    DATA_IS_NULL(3,"数据为空"),
    DELETE_FAIL(5,"删除失败"),
    UPDATE_FAIL(6,"更新失败"),
    VERIFY_FAIL(7,"验证失败"),
    AUTHORITY_FAIL(8,"无权限访问"),
    TOKEN_FAIL(9,"token错误或已过期"),
    TOKEN_IS_NULL(10,"token为空"),
    LOGIN_FAIL(11,"登录失败"),

    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}