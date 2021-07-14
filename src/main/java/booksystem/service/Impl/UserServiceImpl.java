package booksystem.service.Impl;

import booksystem.dao.UserDao;
import booksystem.pojo.User;
import booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    String from;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public User getUserByID(String user_id) {
        return userDao.getUserByID(user_id);
    }

    @Override
    public void addUser(String email, String password, String name, int status, String activationCode) {
        userDao.addUser(email,password,name,status,activationCode);
    }


    @Override
    public void deleteUser(String user_id) {
        userDao.deleteUser(user_id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updateStatus(String username, int status) {
        return userDao.updateStatus(username,status);
    }

    @Override
    public int updateCode(String username, String activationCode) {
        return userDao.updateCode(username,activationCode);
    }

    @Override
    public int sendMimeMail(String password, String email, String name) {
        try{
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setSubject("教我编程图书商城-验证码邮件");//主题
            //生成随机数
            String Code = randomCode();

            mailMessage.setText("您的注册验证码是："+Code);//内容

            mailMessage.setTo(email);//发给谁

            mailMessage.setFrom(from);//你自己的邮箱

            mailSender.send(mailMessage);//发送
            //更新验证码
            userDao.updateCode(email,Code);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    @Override
    public int register(String password, String email, String name, String activationCode) {
        User user=userDao.getUserByName(email);
        if(user!=null)
        {
            //用户已存在
            return -1;
        }else {
            try {
                userDao.addUser(email,password,name,0,null);
                user=userDao.getUserByName(email);
                String Code = user.getActivationCode();
                //如果email数据为空，或者不一致，注册失败
                if (email == null || email.isEmpty()) {
                    //return "error,邮箱错误请重新注册";
                    return 0;
                } else if (!Code.equals(activationCode)) {
                    //return "error,激活码错误请重新注册"
                    return 1;
                }
                //将数据写入数据库
                userDao.updateStatus(email,1);
                //跳转成功页面
                return 2;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return 3;
    }
}
