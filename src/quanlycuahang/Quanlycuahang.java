package quanlycuahang;

import javax.swing.*;
import view.giaodienbanhang;
import controller.banhang_controller;

public class Quanlycuahang {
    public static void main(String[] args) {
        // Đảm bảo chạy trên luồng giao diện Swing
        SwingUtilities.invokeLater(() -> {
            // Tạo JFrame
            JFrame frame = new JFrame("Quản Lý Cửa Hàng - Bán Hàng");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Tạo View
            giaodienbanhang view = new giaodienbanhang();

            // Gắn Controller
            new banhang_controller(view);

            // Đưa View vào Frame
            frame.setContentPane(view);

            // Hiển thị
            frame.setVisible(true);
        });
    }
}
