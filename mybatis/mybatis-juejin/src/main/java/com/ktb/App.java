package com.ktb;

import com.ktb.dao.DepartmentDao;
import com.ktb.dao.EmployeeDao;
import com.ktb.dao.UserDao;
import com.ktb.entity.Department;
import com.ktb.entity.Employee;
import com.ktb.entity.User;
import com.ktb.service.DepartmentDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Department> departmentList = sqlSession.selectList("com.ktb.dao.DepartmentDao.findAll");
        departmentList.forEach(System.out::println);
    }

    /**
     * 测试不用动态代理的查找
     *
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl(sqlSessionFactory);
        List<Department> all = departmentDao.findAll();
        all.forEach(System.out::println);
        Department byId = departmentDao.findById("18ec781fbefd727923b0d35740b177ab");
        System.out.printf("666:" + byId);
    }


    /**
     * 用动态代理的增删改查
     *
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //此处需要设置 自动提交
        DepartmentDao departmentMapper = sqlSession.getMapper(DepartmentDao.class);
        Department department = departmentMapper.findById("18ec781fbefd727923b0d35740b177ab");
        System.out.println(department);

        department.setName("小虎哥good");
        departmentMapper.update(department);
        department = departmentMapper.findById("18ec781fbefd727923b0d35740b177ab");
        System.out.println(department);
    }


    /**
     * 多对1关联测试
     *
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //此处需要设置 自动提交
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println("user:" + user);
        }
    }

    /**
     * 多对1 延迟加载
     */
    @Test
    public void test04() throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //此处需要设置 自动提交
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> all = userDao.findAllByLazy();
        for (User user : all) {
            System.out.println("user:" + user);
        }
    }

    /**
     * 1对多
     */
    @Test
    public void test05() throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //此处需要设置 自动提交
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        List<Department> all = departmentDao.findAll();
        for (Department department : all) {
            System.out.println("department:" + department);
            for (User user : department.getUsers()) {
                System.out.println("user:" + user);
            }
        }
    }


    /**
     * 1对多 延迟加载
     */
    @Test
    public void test06() throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //此处需要设置 自动提交
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        List<Department> all = departmentDao.findAllLazy();
        for (Department department : all) {
            System.out.println("department:" + department);
//            for (User user : department.getUsers()) {
//                System.out.println("user:" + user);
//            }
        }
    }

    /**
     * todo 这种方式要求 SQL 映射文件名必须和接口名相同并且在同一目录下
     *
     * @throws IOException
     */

    @Test
    public void test07() throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //此处需要设置 自动提交
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee department = employeeDao.findOne(1);
        System.out.println("department = " + department);
    }


    @Test
    public void test08() throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //此处需要设置 自动提交
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee entity = new Employee(null, "123", "男");
        Integer integer = employeeDao.insertEmployee(entity);
        System.out.println("entity = " + entity.getId());
    }


}
