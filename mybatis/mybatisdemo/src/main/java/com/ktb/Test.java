package com.ktb;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.ktb.mapper.*;
import com.ktb.model.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.findAll();
        users.forEach(System.out::println);
        sqlSession.close();
    }

    private static SqlSession getSqlSession() throws   IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从 SqlSessionFactory 中获取 SqlSession
        return sqlSessionFactory.openSession(true); //此处设置事务手动提交 坑一
    }

    @org.junit.jupiter.api.Test
    public void test() throws IOException {

        // 2、获取sqlSession实例，能直接执行已经映射的sql语句
        // sql的唯一标识：statement Unique identifier matching the statement to use.
        // SqlSession：parameter A parameter object to pass to the statement.
        SqlSession sqlSessionFactory = getSqlSession();
        try {
            Employee employee = sqlSessionFactory.selectOne("abc.getEmpById", 1);
            System.out.println(employee);
        } finally {
            sqlSessionFactory.close();
        }
    }

    @org.junit.jupiter.api.Test
    public void test01() throws IOException {

        // 2、获取sqlSession实例，能直接执行已经映射的sql语句
        // sql的唯一标识：statement Unique identifier matching the statement to use.
        // SqlSession：parameter A parameter object to pass to the statement.
        SqlSession sqlSessionFactory = getSqlSession();
        try {
            EmployeeMapper mapper = sqlSessionFactory.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(new Gson().toJson(employee));
        } finally {
            sqlSessionFactory.close();
        }
    }

    @org.junit.jupiter.api.Test
    public void add() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer("xiaohu", "男", "18589717969");
        CustomerVo customerVo = new CustomerVo();
        customerVo.setCustomer(customer);
        Long save = mapper.save(customerVo);
        System.out.println("save:" + save);
        System.out.println(customer);
        sqlSession.close();
    }

    @org.junit.jupiter.api.Test
    public void update() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.get(6, null);
        customer.setName("小虎哥123");
        Long update = mapper.update(customer);
        System.out.println("update:" + update);
        sqlSession.close();
    }

    /**
     * 1对多查询
     *
     * @throws IOException
     */
    @org.junit.jupiter.api.Test
    public void get() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        Customer customer = mapper.get(new Customer(6));
        User user = mapper.findById(1);
        System.out.println(new Gson().toJson(user));
        sqlSession.close();
    }


    @org.junit.jupiter.api.Test
    public void getByCondition() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = dao.findbyCondition("小", 19);
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @org.junit.jupiter.api.Test
    public void findUser() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("UZI");
        User user1 = mapper.findUser(user);
        System.out.println(user1.toString());
        sqlSession.close();
    }


    @org.junit.jupiter.api.Test
    public void insertUser() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("小虎");
        user.setAge(29);
        mapper.insertUser(user);
        sqlSession.close();
    }

    @org.junit.jupiter.api.Test
    public void findByIds() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        ArrayList list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        List<Customer> customer = mapper.findByIds(array);
        System.out.println(customer.toString());
        sqlSession.close();
    }

    @org.junit.jupiter.api.Test
    public void getCount() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Long customer = mapper.queryTotalCount();
        System.out.println(customer.toString());

        sqlSession.close();
    }

    @org.junit.jupiter.api.Test
    public void queryCustomerResultMap() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        CustomerRM customer = mapper.queryCustomerResultMap(6);
        System.out.println(customer.toString());
        sqlSession.close();
    }


    @org.junit.jupiter.api.Test
    public void dynamicSql() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setName("小虎哥");
        customer.setTelephone("18589717969");
        List<Customer> list = mapper.queryByNameAndTelephone(customer);
        for (Customer customer1 : list) {
            System.out.println(customer1.toString());
        }
        System.out.println(customer.toString());
        sqlSession.close();
    }


    @org.junit.jupiter.api.Test
    public void dynamicSql2() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setName("小虎哥");
        customer.setTelephone("18589717969");
        List<Customer> list = mapper.queryByNameAndTelephone2(customer);
        for (Customer customer1 : list) {
            System.out.println(customer1.toString());
        }
        System.out.println(customer.toString());
        sqlSession.close();
    }

    /**
     * 1对1关联测试
     *
     * @throws IOException
     */
    @org.junit.jupiter.api.Test
    public void getAllOrder() throws IOException {
        SqlSession sqlSession = getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order> allOrders = orderDao.findAllOrders();
        System.out.println("orders:" + new Gson().toJson(allOrders));
        sqlSession.close();
    }


    /**
     * 1对1关联测试
     *
     * @throws IOException
     */
    @org.junit.jupiter.api.Test
    public void getAllUsers() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int pageNun = 1; // 页码
        int pageSize = 2;// 每页显示条数
        PageHelper.startPage(pageNun, pageSize);
        List<User> users = userDao.findAllUsers();
        System.out.println("users:" + new Gson().toJson(users));

        //5.把用户数据封装到PageInfo分页结果对象
        PageInfo<User> page = new PageInfo<>(users);

        //6.取出PageInfo的属性
        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        System.out.println("当前页码=" + page.getPageNum());
        System.out.println("每页显示条数=" + page.getPageSize());
        System.out.println("当前页起始行号=" + page.getStartRow());
        System.out.println("当前页结束行号=" + page.getEndRow());
        System.out.println("总记录数=" + page.getTotal());
        System.out.println("总页数=" + page.getPages());
        System.out.println("是否为第1页=" + page.isIsFirstPage());
        System.out.println("是否为最后1页=" + page.isIsLastPage());
        System.out.println("是否有上一页=" + page.isHasPreviousPage());
        System.out.println("是否有下一页=" + page.isHasNextPage());
        System.out.println("当前页数据=");
        for (User c : page.getList()) {
            System.out.println(c);
        }

        sqlSession.close();
    }


}
