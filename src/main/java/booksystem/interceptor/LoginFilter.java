package booksystem.interceptor;


import booksystem.utils.ResultEnum;
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
    final String[] allowUrl={
            "/login","/register"
    };
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("TestFilter,"+request.getRequestURI());
        response.setHeader("Access-Control-Allow-Origin", "*");

        Map<String,Object> map = new HashMap<>();
        String url =  ((HttpServletRequest)servletRequest).getRequestURI();
        if(url != null){
            //登录请求直接放行
            boolean isAllowUrl=false;
            for(int i=0;i<allowUrl.length;i++){
                if(allowUrl[i].equals(url))
                    isAllowUrl=true;
            }
            if(isAllowUrl){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else{
                //其他请求验证token
                String token = ((HttpServletRequest)servletRequest).getHeader("token");
                if(token!=null){
                    //token验证结果
                    boolean verify  = TokenUtils.verify(token);
                    if(!verify){
                        //验证失败
                        map.put("msg",ResultEnum.TOKEN_FAIL.getMsg());
                        map.put("code", ResultEnum.TOKEN_FAIL.getCode());
                    }else if(verify){
                        //token验证结果
                        int identity=Integer.parseInt(TokenUtils.parseToken(token).get("identity").toString());
                        boolean authority=true;
                        System.out.println("该身份权限为："+identity);
                        String[] str=url.split("/");
                        for(int i=0;i<str.length;i++){
                            System.out.println(str[i]);
                        }
                        if (identity==0){
                            if(str[0].equals("shop")||str[0].equals("admin")){
                                map.put("msg",ResultEnum.AUTHORITY_FAIL.getMsg());
                                map.put("code",ResultEnum.AUTHORITY_FAIL.getCode());
                                authority=false;
                            }

                        }else if(identity==1){
                            if(str[0].equals("admin")){
                                map.put("msg",ResultEnum.AUTHORITY_FAIL.getMsg());
                                map.put("code",ResultEnum.AUTHORITY_FAIL.getCode());
                                authority=false;
                            }
                        }else if(identity==2){

                        }else {
                            authority=false;
                        }
                        //验证成功，且有权限
                        if(authority){
                            token=TokenUtils.refresh(token);
                            response.setHeader("token",token);
                            filterChain.doFilter(servletRequest,servletResponse);
                            return;
                        }
                    }
                }else{
                    //token为空的返回
                    map.put("msg",ResultEnum.TOKEN_IS_NULL.getMsg());
                    map.put("code",ResultEnum.TOKEN_IS_NULL.getCode());
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
