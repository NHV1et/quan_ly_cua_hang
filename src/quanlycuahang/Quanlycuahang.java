package quanlycuahang;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import view.giaodienbanhang;


public class Quanlycuahang {
    public static void main(String[] args) {
        // Chạy GUI trên EDT
        SwingUtilities.invokeLater(() -> {
            // Tạo frame
            JFrame frame = new JFrame("Bán hàng");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Tạo panel view (giaodienbanhang)
            giaodienbanhang panel = new giaodienbanhang();

            // Nếu bạn có hàm postInit() hoặc cần bind controller/model, gọi ở đây
            // panel.postInit(); // nếu bạn đã thêm method này

            frame.setContentPane(panel);
            frame.pack(); // hoặc frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null); // căn giữa
            frame.setVisible(true);
        });
    }
}
