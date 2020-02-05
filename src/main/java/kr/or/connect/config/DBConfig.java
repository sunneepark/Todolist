package kr.or.connect.config;

import javax.sql.DataSource;
import java.sql.Connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class DBConfig {
	private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/web_master?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";

    private String username = "root";
    private String password = "wlzheoqkr1!";

/*    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }*/
    
    @Bean
    public Connection Connection() {
    	BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        
        Connection conn = null;
        try {
			conn = dataSource.getConnection();
			if(conn == null)
				System.out.println("DB 연결 오류");
		}catch (Exception e) {
			e.printStackTrace();
		}
        
        return conn;
    }
}
