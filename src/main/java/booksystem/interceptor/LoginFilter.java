package booksystem.interceptor;


import booksystem.utils.TokenUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("TestFilter,"+request.getRequestURI());
        response.setHeader("Access-Control-Allow-Origin", "*");

        Map<String,String> map = new HashMap<>();
        String url =  ((HttpServletRequest)servletRequest).getRequestURI();
        if(url != null){
            //登录请求直接放行
            if("/login".equals(url)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else{
                //其他请求验证token
                String token = ((HttpServletRequest)servletRequest).getHeader("token");
                if(true){
                    //token验证结果
                    int verify  = 1;
                    if(verify != 1){
                        //验证失败
                        if(verify == 2){
                            map.put("errorMsg","token已过期");
                        }else if(verify == 0){
                            map.put("errorMsg","用户信息验证失败");
                        }
                    }else if(verify  == 1){
                        //token验证结果
                    int identity=Integer.parseInt(TokenUtils.parseToken(token).get("identity").toString());
                    System.out.println("该身份权限为："+identity);
                        //验证成功，放行
                        filterChain.doFilter(servletRequest,servletResponse);
                        return;
                    }
                }else{
                    //token为空的返回
                    map.put("errorMsg","未携带token信息");
                }
            }
            JSONObject jsonObject = new JSONObject(map);
            servletResponse.setContentType("application/json");
            //设置响应的编码
            servletResponse.setCharacterEncoding("utf-8");
            //响应
            PrintWriter pw=servletResponse.getWriter();
            pw.write(jsonObject.toString());
            pw.flush();
            pw.close();
        }

        //执行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
