package com.example.demo.componenetScan;

import com.example.demo.scope.JdbcConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentDao {
    @Autowired
    private ComponentJdbcConnection jdbcConnection;

    public ComponentJdbcConnection getJdbcConnection() {
        return jdbcConnection;
    }

    public void setJdbcConnection(ComponentJdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }
}
