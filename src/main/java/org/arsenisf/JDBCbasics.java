package org.arsenisf;

import java.sql.*;

public class JDBCbasics {
    static final String url = "jdbc:postgresql://localhost:5432/postgres";
    static final String password = "33037";
    static final String username = "postgres";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        /*addSeveralProducts(connection);*/
        selectAllProduct(connection);
    }

    public static void addProduct(Connection connection, String product, int price) {
        String statement = "INSERT INTO \"JDBCschema\".purchase (product, price) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {

            preparedStatement.setString(1, "PS5");
            preparedStatement.setInt(2, 3500);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Sql exception" + e.getStackTrace());
        }
    }

    public static void selectAllProduct(Connection connection) {
        String statement = "SELECT * FROM \"JDBCschema\".purchase";

        try (PreparedStatement preparedStatement = connection.prepareStatement(statement) ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Purchase purchase = new Purchase();
                purchase.setId(resultSet.getInt("id"));
                purchase.setProduct(resultSet.getString("product"));
                purchase.setPrice(resultSet.getInt("price"));
                System.out.println(purchase);
            }
            System.out.println(resultSet);
        } catch (SQLException e) {
            System.out.println("SQL exception " + e.getStackTrace());
        }
    }

    public static void addSeveralProducts(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.addBatch("INSERT INTO \"JDBCschema\".purchase (product, price) VALUES ('Cow', 730)");
            statement.addBatch("INSERT INTO \"JDBCschema\".purchase (product, price) VALUES ('Horse', 900)");
            statement.addBatch("INSERT INTO \"JDBCschema\".purchase (product, price) VALUES ('Dog', 250)");
            statement.executeBatch();

        } catch (SQLException e) {
            System.out.println("Sql exception" + e.getStackTrace());
        }
    }
}
