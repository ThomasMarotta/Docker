package com.example.demo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${DB_PASSWORD_FILE:/run/secrets/db_password}")
    private String dbPasswordFile;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(readPasswordFromFile());
        return dataSource;
    }

    private String readPasswordFromFile() {
        try {
            return new String(Files.readAllBytes(Paths.get(dbPasswordFile))).trim();
        } catch (IOException e) {
            throw new RuntimeException("Unable to read password from file", e);
        }
    }
}
