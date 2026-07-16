package com.example.demo;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

//QYQP
@Configuration
public class H2Config {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp",
                "-tcpAllowOthers",
                //The default is 9092, but you can use a different one as long as it is the same
                // as in jdbc:h2:tcp://localhost:9093/mem:testdb
                "-tcpPort", "9093"
        );
    }
}
