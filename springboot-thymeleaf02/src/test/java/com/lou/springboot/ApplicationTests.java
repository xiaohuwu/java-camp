package com.lou.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class ApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    public void dataSourceTest() throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println(connection != null);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
