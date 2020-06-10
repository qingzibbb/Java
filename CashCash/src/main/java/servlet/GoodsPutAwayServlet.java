package servlet;

import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/inbound")
public class GoodsPutAwayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=uft-8");

        //输入类型全是String
        String name = req.getParameter("name");
        String stock = req.getParameter("stock");
        String introduce = req.getParameter("introduce");
        String unit = req.getParameter("unit");
        String price = req.getParameter("price");//String89.9

        //把String类输入转化成正确类型存入数据库
        double doublePrice = Double.valueOf(price);//Double89.9

        int realPrice = new Double(100*doublePrice).intValue();//int8990

        String discount = req.getParameter("discount");

        Connection connection = null;
        PreparedStatement ps = null;

        Writer writer = resp.getWriter();

        try {
            String sql = "insert into goods(name,introduce,stock,unit,price,discount) values (?,?,?,?,?,?)";
            connection = DBUtil.getConnection(true);
            ps = connection.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,introduce);//产品
            ps.setInt(3,Integer.valueOf(stock));//库存
            ps.setString(4,unit);
            ps.setInt(5,realPrice);//真实价格
            ps.setInt(6,Integer.valueOf(discount));//折扣

            int ret = ps.executeUpdate();
            if(ret == 0){
                writer.write("<h2> 商品上架失败</h2>");
            }else{
                writer.write("<h2> 商品上架成功</h2>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }
}
