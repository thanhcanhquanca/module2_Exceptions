package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // lỗi liên quan đến đầu vào và đầu ra như đọc , ghi tệp
        try {
            FileReader file = new FileReader("nonexstent.txxt");
            BufferedReader reader = new BufferedReader(file);
            System.out.println(reader.readLine());
        }catch (IOException e){
            System.out.println("lỗi I/O xảy ra" + e.getMessage());
        }

        //
    }
}
