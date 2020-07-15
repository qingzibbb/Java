public static List<User> findByPage(int start, int rows,Map<String, String[]> map) {
        List<User> userList = new ArrayList<>();
        String sql = "select * from usermessage where 1=1 ";//and name like ?
        StringBuffer sb = new StringBuffer(sql);
        List<Object> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key)[0];
            if(value != null && !"".equals(value)) {
                sb.append(" and ").append(key).append(" like ? ");
                list.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        list.add(start);
        list.add(rows);
        System.out.println("sql : "+ sb);
        System.out.println("list: "+ list);

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sb.toString());
            //给sql语句赋值
            //String sql = "update usermessage set gender=?,age=?,address=?,qq=?,email=? where id=?";

            setValues(ps,list.toArray());

            rs = ps.executeQuery();

            while (rs.next()) {
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
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return userList;
    }