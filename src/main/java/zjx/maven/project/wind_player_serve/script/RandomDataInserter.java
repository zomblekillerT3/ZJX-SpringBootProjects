package zjx.maven.project.wind_player_serve.script;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomDataInserter {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/wind_player_serve";
    private static final String USER = "root";
    private static final String PASSWORD = "qyf123456";

    private static final String INSERT_SQL = "INSERT INTO total_theme (t_themeName, t_upDownBack, t_mainBack, creator) VALUES (?, ?, ?, ?)";

    private static final String[] creators = {"145", "435", "765", "432", "908"};

    public static void main(String[] args) {
        Set<String> uniqueThemeNames = new HashSet<>();
        Random random = new Random();
        int numRecords = 100; // 需要插入的记录数

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {

            for (int i = 0; i < numRecords; i++) {
                String themeName;
                // 生成唯一的主题名
                do {
                    themeName = "Theme_" + random.nextInt(10000);
                } while (uniqueThemeNames.contains(themeName));
                uniqueThemeNames.add(themeName);

                String upDownBack = generateRandomColor();
                String mainBack = generateRandomColor();
                String creator = creators[random.nextInt(creators.length)];

                preparedStatement.setString(1, themeName);
                preparedStatement.setString(2, upDownBack);
                preparedStatement.setString(3, mainBack);
                preparedStatement.setString(4, creator);

                preparedStatement.addBatch(); // 添加到批处理
            }

            preparedStatement.executeBatch(); // 执行批处理
            System.out.println("数据插入成功!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomColor() {
        Random random = new Random();
        return String.format("#%06X", random.nextInt(0xFFFFFF + 1));
    }
}

