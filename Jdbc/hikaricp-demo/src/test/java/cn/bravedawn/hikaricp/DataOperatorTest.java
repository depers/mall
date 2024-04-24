package cn.bravedawn.hikaricp;

import cn.bravedawn.hikarcp.DataOperator;
import cn.bravedawn.hikarcp.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author : fengx9
 * @Project : hikaricp-demo
 * @Date : Created in 2023-11-24 15:48
 */

@Slf4j
public class DataOperatorTest {


    @Test
    public void testFetchData() throws SQLException {
        List<Employee> employees = DataOperator.fetchData();
        log.info("{}", employees);
    }
}
