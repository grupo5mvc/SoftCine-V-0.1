package com.grupo5.softCine.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/softcine?serverTimezone=UTC", "root", "");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FabricaDeConexao.getConnection();
    }
}
