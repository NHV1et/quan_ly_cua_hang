package quanlycuahang;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import view.giaodienbanhang;
import view.giaodien_qly_hdon;

public class Quanlycuahang {

    public static void main(String[] args) {
        Scanner v = new Scanner(System.in);
        // Chạy GUI trên EDT
        SwingUtilities.invokeLater(() -> {
            // Biến lựa chọn giao diện (có thể lấy từ args hoặc hardcode)
            System.out.println("1. Vào giao diện bán hàng" + '\n' + "2.Vào giao diện quản lý hóa đơn");
            int choice = v.nextInt();

            JFrame frame = null;

            switch (choice) {
                case 1:
                    frame = new JFrame("Bán hàng");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setContentPane(new giaodienbanhang());
                    break;

                case 2:
                    frame = new JFrame("Quản lý hóa đơn");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setContentPane(new giaodien_qly_hdon().getContentPane());
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }

            frame.pack(); // hoặc frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null); // căn giữa
            frame.setVisible(true);
        });
    }
}
