package service;

//操作dao层
import dao.UserDao;
import entiy.PageBean;
import entiy.User;

import java.util.List;
import java.util.Map;

public class UserService {

    public User login(User loginUser){
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        return user;
    }

    public int add(User user){
        UserDao userDao = new UserDao();
        int ret = userDao.add(user);
        return ret;
    }

    public int delete(int id){
        UserDao userDao = new UserDao();
        int ret = userDao.delete(id);
        return ret;
    }

    public User find(int id){
        UserDao userDao = new UserDao();
        User user = userDao.find(id);
        return user;
    }

    public int updateUser(User upUser){
        UserDao userDao = new UserDao();
        int user = userDao.updateUser(upUser);
        return user;
    }

    /*currentPage：当前页， rows 每页行数，map包含name address email
    确定
    private int totalCount; //总记录数  12 finAllRecord
    private int totalPage;  //总页码    3  计算
    private List<T> list;  //每页中的数据  --》findByPage
    private int currentPage;  //当前页码   currentPage
    private int rows;  //每页的记录数   rows
     */
    public PageBean<User>  findAllByPage(int currentPage, int rows, Map<String,String[]> map){
        PageBean<User> pageBean = new PageBean<>();
        UserDao userDao = new UserDao();
        int totalCount = userDao.findAllRecord(map);
        int totalPage = 0;
        if(totalCount % rows != 0){
            totalPage = totalCount / rows + 1;
        }else {
            totalPage = totalCount / rows;
        }
        pageBean.setTotalPage(totalPage);
        pageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*rows;
        List<User> userList = userDao.findByPage(start,rows,map);
        pageBean.setList(userList);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        return pageBean;
    }
}
