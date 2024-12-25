package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        // lỗi liên quan đến đầu vào và đầu ra như đọc , ghi tệp
        try {
            FileReader file = new FileReader("nonexstent.txxt");
            BufferedReader reader = new BufferedReader(file);
            System.out.println(reader.readLine());
        }catch (IOException e){
            System.out.println("lỗi I/O xảy ra" + e.getMessage());
        }

        // lỗi xảy ra khi làm việc với cơ sở dữ liệu  sql

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user", "pass");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nonexistent_table");

        }catch (SQLException e){
            System.out.println("loi co so du lieu " + e.getMessage());
        }

        //

    }
}
