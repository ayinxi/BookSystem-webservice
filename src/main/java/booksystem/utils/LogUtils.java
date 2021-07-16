package booksystem.utils;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class LogUtils {
    public static String getNowTime(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z  ");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static JSONObject getParams(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Enumeration<String> params = request.getParameterNames();
        for (Enumeration<String> e = params; e.hasMoreElements();) {
            String key = e.nextElement().toString();
            try {
                jsonObject.put(key, request.getParameter(key));
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }

        }
        return jsonObject;
    }

    public static void main(String[] args) {
        System.out.println(getNowTime());
    }
}
