package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnexion {

    private String url;
    private String user;
    private String password;

    public PostgresConnexion(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connexion error : " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        PostgresConnexion pc = new PostgresConnexion(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "1234"
        );

        Connection conn = pc.getConnection();
        if (conn != null) {
            System.out.println("Connexion done !");
        }
    }
}
