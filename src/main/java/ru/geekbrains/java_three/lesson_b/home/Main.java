package ru.geekbrains.java_three.lesson_b.home;

import java.sql.*;

public class Main {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();

            createTable("Users", "id INTEGER PRIMARY KEY AUTOINCREMENT", "name text NOT NULL", "birthday_at text NOT NULL");

            addToTable("Users", "name, birthday_at", "('Петя', 1998-07-08)", "('Вася', 1971-02-10)", "('Лена', 2001-04-05)");

            System.out.println(getEntry("Users"));
            System.out.println(getEntry("Users", "id, name"));
            System.out.println(getEntry("Users", "id, name", "name = 'Петя'"));
            System.out.println(getEntry("Users", "*", "name = 'Петя'"));

            deleteFromTable("Users", "name", "Вася");

            deleteTable("Users");

            disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Функция для создания таблицы
    private static void createTable(String tableName, String... columnStatements) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE IF EXISTS ").append(tableName).append(";\n");
        sb.append("CREATE TABLE ").append(tableName).append(" (\n");
        for (String statement : columnStatements) {
            sb.append(statement).append(",\n");
        }
        sb.delete(sb.length() - 2, sb.length() - 1).append(");");
        statement.executeUpdate(sb.toString());
    }

    // Функция для добавления записи в таблицу
    private static void addToTable(String tableName, String columns, String... values) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(tableName).append("(").append(columns).append(") VALUES\n");
        for (String value : values) {
            sb.append(value).append(",\n");
        }
        sb.delete(sb.length() - 2, sb.length()).append(";");
        statement.executeUpdate(sb.toString());
    }

    // Функции для получения записей из таблицы
    // Функция для вывода всех записей
    private static String getEntry(String tableName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        return getEntriesFromResultSet(resultSet);
    }

    // Функция вывода определенных столбцов из всей таблицы
    private static String getEntry(String tableName, String columns) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT " + columns + " FROM " + tableName);
        return getEntriesFromResultSet(resultSet);
    }

    // Функция вывода определенных столбцов с определенным условием
    private static String getEntry(String tableName, String columns, String statements) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT "  + columns + " FROM " + tableName + " WHERE " + statements);
        return getEntriesFromResultSet(resultSet);
    }

    // Удаляет запись из таблицы
    private static void deleteFromTable(String tableName, String columnName, Object value) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ").append(tableName).append(" WHERE ").append(columnName).append(" = ");
        if (value instanceof String) {
            sb.append("'").append(value).append("';");
        } else {
            sb.append(value).append(";");
        }
        statement.executeUpdate(sb.toString());
    }

    // Удаляет таблицу
    private static void deleteTable(String tableName) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS " + tableName);
    }

    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        statement = connection.createStatement();
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }

    // Получение строки из ResultSet
    private static String getEntriesFromResultSet(ResultSet resultSet) throws SQLException {
        StringBuilder sb = new StringBuilder();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                sb.append(resultSet.getString(resultSetMetaData.getColumnName(i))).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
