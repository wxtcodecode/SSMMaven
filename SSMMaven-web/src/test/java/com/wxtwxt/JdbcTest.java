package com.wxtwxt;

import com.wxtwxt.mapper.EmpMapper;
import com.wxtwxt.pojo.Emp;
import com.wxtwxt.pojo.EmpExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * Spring和junit5的整合
 * @author Wxt
 * @create 2022-03-14 11:21
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = "classpath:Spring-persist.xml")
public class JdbcTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EmpMapper empMapper;
    @Test
    public void testEmpMapper() {
        Emp emp = empMapper.selectByPrimaryKey(1);
        System.out.println(emp);
    }
    @Test
    public void testDataBase() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println("conn = " + conn);
    }
}
