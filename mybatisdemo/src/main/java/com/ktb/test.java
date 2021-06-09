package com.ktb;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.ktb.mapper.CustomerMapper;
import com.ktb.mapper.OrderDao;
import com.ktb.mapper.StudentMapper;
import com.ktb.mapper.UserDao;
import com.ktb.model.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student tom = mapper.getStudentByNumber(0);
        System.out.println(tom);
        sqlSession.close();
    }

    private static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从 SqlSessionFactory 中获取 SqlSession
        return sqlSessionFactory.openSession(true); //此处设置事务手动提交 坑一
    }

    @Test
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

    @Test
    public void update() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.get(6,null);
        customer.setName("小虎哥123");
        Long update = mapper.update(customer);
        System.out.println("update:" + update);
        sqlSession.close();
    }

    @Test
    public void get() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
//        Customer customer = mapper.get(new Customer(6));
        Customer customer = mapper.get(6,null);
        System.out.println(customer.toString());
        sqlSession.close();
    }

    @Test
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

    @Test
    public void getCount() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Long customer = mapper.queryTotalCount();
        System.out.println(customer.toString());

        sqlSession.close();
    }

    @Test
    public void queryCustomerResultMap() throws IOException {
        SqlSession sqlSession = getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        CustomerRM customer = mapper.queryCustomerResultMap(6);
        System.out.println(customer.toString());
        sqlSession.close();
    }


    @Test
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


    @Test
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
     * @throws IOException
     */
    @Test
    public void getAllOrder() throws IOException {
        SqlSession sqlSession = getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order> allOrders = orderDao.findAllOrders();
        System.out.println("orders:" + new Gson().toJson(allOrders));
        sqlSession.close();
    }



    /**
     * 1对1关联测试
     * @throws IOException
     */
    @Test
    public void getAllUsers() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int pageNun = 1; // 页码
        int pageSize = 2;// 每页显示条数
        PageHelper.startPage(pageNun,pageSize);
        List<User> users = userDao.findAllUsers();
        System.out.println("users:" + new Gson().toJson(users));

        //5.把用户数据封装到PageInfo分页结果对象
        PageInfo<User> page = new PageInfo<>(users);

        //6.取出PageInfo的属性
        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        System.out.println("当前页码="+page.getPageNum());
        System.out.println("每页显示条数="+page.getPageSize());
        System.out.println("当前页起始行号="+page.getStartRow());
        System.out.println("当前页结束行号="+page.getEndRow());
        System.out.println("总记录数="+page.getTotal());
        System.out.println("总页数="+page.getPages());
        System.out.println("是否为第1页="+page.isIsFirstPage());
        System.out.println("是否为最后1页="+page.isIsLastPage());
        System.out.println("是否有上一页="+page.isHasPreviousPage());
        System.out.println("是否有下一页="+page.isHasNextPage());
        System.out.println("当前页数据=");
        for(User c:page.getList()){
            System.out.println(c);
        }

        sqlSession.close();
    }



}
