package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entiy.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);

        User loginUser = new User();//登录对象
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        UserService userService = new UserService();
        User user = userService.login(loginUser);

        Map<String,Object> returnMap = new HashMap<>();
        if(user!= null){
            System.out.println("登陆成功"+username);
            //1、把当前登录成功的用户写到session中
            req.getSession().setAttribute("user",user);
            returnMap.put("msg",true);
        }else {
            System.out.println("登陆失败"+username);
            returnMap.put("msg",false);
        }

        //把登陆成功的map返回给前端 json :便于前端进行处理
        ObjectMapper objectMapper = new ObjectMapper();
        //将returnMap转换为json字符串
        objectMapper.writeValue(resp.getWriter(),returnMap);
    }
}
