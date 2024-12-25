package view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // IOException lỗi liên quan đến đầu vào và đầu ra như đọc , ghi tệp
        try {
            FileReader file = new FileReader("nonexstent.txxt");
            BufferedReader reader = new BufferedReader(file);
            System.out.println(reader.readLine());
        }catch (IOException e){
            System.out.println("lỗi I/O xảy ra" + e.getMessage());
        }

        // SQLException lỗi xảy ra khi làm việc với cơ sở dữ liệu  sql

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user", "pass");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nonexistent_table");

        }catch (SQLException e){
            System.out.println("loi co so du lieu " + e.getMessage());
        }

        // ClassNotFoundException xảy ra khi chương tình không tìm thấy một lớp được yêu cầu

        try {
            Class.forName("com.unknow.ClassName");
        }
            catch (ClassNotFoundException e){
                System.out.println("không tim thay lớp" + e.getMessage());
            }

        // xảy ra lỗi khi cố gắng mở tệp không tồn tai

        try {
            FileReader file = new FileReader("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Tệp không tồn tại: " + e.getMessage());
        }


        // xảy ra khi một luồng (thread) bị gián đoạn
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Luồng bị gián đoạn!");
            }
        });
        t.start();
        t.interrupt(); // Gián đoạn luồng
    }

    //





    }


