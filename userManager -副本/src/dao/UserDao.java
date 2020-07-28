package dao;

import entiy.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDao {
    public  User login(User longinUser){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from usermessage where username=? and password=?";

        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,longinUser.getUsername());
            ps.setString(2,longinUser.getPassword());
            rs = ps.executeQuery();

            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setQq(rs.getString("qq"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return user;
    }

    //添加用户
    public int add(User user){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into usermessage(name, username, password, gender, age, address, qq, email) value (?,?,?,?,?,?,?,?)";
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getGender());
            ps.setInt(5,user.getAge());
            ps.setString(6,user.getAddress());
            ps.setString(7,user.getQq());
            ps.setString(8,user.getEmail());

            int ret = ps.executeUpdate();
            return ret; //ret=1 添加成功；ret=0 添加失败
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return 0;//添加失败
    }

    //删除用户信息
    public int delete(int id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "delete from usermessage where id=?";
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int ret = ps.executeUpdate();
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return 0;//删除失败
    }

    //根据用户ID查找对应用户
    public User find(int id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            String sql = "select * from usermessage where id=?";
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setQq(rs.getString("qq"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return user;
    }

    //更新：只需要给一个用户对象
    public int updateUser(User upUser){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            String sql = "update usermessage set gender=?,age=?,address=?,qq=?,email=? where id=?";
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,upUser.getGender());
            ps.setInt(2,upUser.getAge());
            ps.setString(3,upUser.getAddress());
            ps.setString(4,upUser.getQq());
            ps.setString(5,upUser.getEmail());
            ps.setInt(6,upUser.getId());
            int ret = ps.executeUpdate();
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(connection,ps,null);
        }
        return 0;
    }

    //Object... arrays数组
    public void setValues(PreparedStatement ps,Object... arrays) throws SQLException {
        for (int i = 0; i < arrays.length; i++) {
            ps.setObject(i+1,arrays[i]);
            //                           1       0
        }
    }

    /*查询当前条件下的所有用户信息 条件可给可不给 且可以模糊查询
       start:开始查询的起始位置
       rows：每次查询多少条记录
       map：包含0name，address，email
     */

    public List<User> findByPage(int start, int rows, Map<String,String[]> map){
        List<User> userList = new ArrayList<>();

        //String sql = "select * from usermessage where name=? and address=? and email=? limit ?,?";
        String sql = "select * from usermessage where 1=1";// and name like ?
        StringBuffer sb = new StringBuffer(sql);
        List<Object> list  = new ArrayList<>();
        Set<String> keySet = map.keySet();//存储key值
        for (String key:keySet) {
            String value = map.get(key)[0];
            if(value!=null && !"".equals(value)){
                sb.append(" and ").append(key).append(" like ? ");
                list.add("%"+value+"%");//值以某个字开头或结尾
            }
        }
        sb.append(" limit ?,? ");
        list.add(start);
        list.add(rows);

        System.out.println("sql:"+sb);
        System.out.println("list:"+list);

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sb.toString());

            //给SQL语句赋值
            setValues(ps,list.toArray());

            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setQq(rs.getString("qq"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return userList;
    }

    //查询总共有多少记录
    public int findAllRecord(Map<String,String[]> map){
        int count = 0;
        String sql = "select count(*) from usermessage where 1=1";// and name like ?
        StringBuffer sb = new StringBuffer(sql);
        List<Object> list  = new ArrayList<>();
        Set<String> keySet = map.keySet();//存储key值
        for (String key:keySet) {
            String value = map.get(key)[0];
            if(value!=null && !"".equals(value)){
                sb.append(" and ").append(key).append(" like ? ");
                list.add("%"+value+"%");//值以某个字开头或结尾
            }
        }
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sb.toString());

            //给SQL语句赋值
            setValues(ps,list.toArray());

            rs = ps.executeQuery();
            if (rs.next()){
                count = rs.getInt(1);
                //count = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return count;
    }
    /*public static void main(String[] args) {
        /*User user = new User();
        user.setName("小赵");
        user.setUsername("emei");
        user.setPassword("123456");
        user.setGender("女");
        user.setAddress("陕西");
        user.setQq("456223982");
        user.setEmail("98754612");
        user.setAge(10);

        int ret = add(user);
        if(ret == 0){
            System.out.println("插入失败");
        }else {
            System.out.println("添加成功");
        }*/

        /*int ret = delete(8);
        if(ret == 0){
            System.out.println("删除失败");
        }else {
            System.out.println("删除成功");
        }*/

        /*User user = find(25);
        System.out.println(user);*/

        /*User user = new User();
        user.setId(1);
        user.setGender("男");
        user.setAge(10);
        user.setAddress("陕西");
        user.setQq("456223982");
        user.setEmail("98754612");
        int ret = updateUser(user);
        if(ret == 0){
            System.out.println("更新失败");
        }else {
            System.out.println("更新成功");
        }

        Map<String,String[]> map = new HashMap<>();
        String[] names = {""};
        map.put("name",names);
        String[] addresses = {"陕西"};
        map.put("address",addresses);
        String[] emails = {""};
        map.put("email",emails);


        System.out.println(findAllRecord(map));
        List<User> userList = findByPage(0,5,map);
        for (User user:userList) {
            System.out.println(user);
        }
    }*/
}
