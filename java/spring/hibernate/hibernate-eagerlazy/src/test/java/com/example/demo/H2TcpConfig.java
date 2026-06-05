package com.example.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.sql.SQLException;

@TestConfiguration
@Import(H2TcpConfig.class)
public class H2TcpConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public org.h2.tools.Server h2TcpServer() throws SQLException {
        return org.h2.tools.Server.createTcpServer(
                "-tcp",
                "-tcpAllowOthers",
                "-tcpPort", "9092"
        );
    }
}
