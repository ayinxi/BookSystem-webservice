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
        response.setHeader("Access-Control-Allow-Origin", "*");

        System.out.println("接收访问: "+request.getRequestURI());
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
                        String[] str=url.split("/");
                        if (identity==0){
                            if(str[1].equals("shop")||str[1].equals("admin")){
                                map.put("msg",ResultEnum.AUTHORITY_FAIL.getMsg());
                                map.put("code",ResultEnum.AUTHORITY_FAIL.getCode());
                                authority=false;
                            }

                        }else if(identity==1){
                            if(str[1].equals("admin")){
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
                            System.out.println("访问token正确，且有权限继续访问");
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
            System.out.println("该访问出错");
        }

        //执行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
