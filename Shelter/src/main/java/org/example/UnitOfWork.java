package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UnitOfWork implements AutoCloseable {
    private Connection connection;
    private boolean isCommitted;

    public UnitOfWork() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Shelter";
        String username = "postgres";
        String password = "admin";
        connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        isCommitted = false;
    }

    public Connection getConnection() {
        return connection;
    }

    //  Подтверждение изменений
    public void commit() throws SQLException {
        connection.commit();
        isCommitted = true;
    }

    //  Откат изменений
    public void rollback() throws SQLException {
        connection.rollback();
        isCommitted = true;
    }

    //  Прерывание соединения
    @Override
    public void close() throws SQLException {
        if (!isCommitted) {
            connection.rollback();
        }
        connection.close();
    }
}

