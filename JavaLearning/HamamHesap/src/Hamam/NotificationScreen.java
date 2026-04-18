package Hamam;

import javax.swing.*;
import java.awt.*;

    public class NotificationScreen {

        public static void showNotification(JPanel parentPanel, String mesaj, int sureSn, Color arkaPlanRenk) {
            Window parentWindow = SwingUtilities.getWindowAncestor(parentPanel);


            JWindow window = getJWindow(mesaj, arkaPlanRenk, parentWindow);

            window.setVisible(true);
            window.setOpacity(1f);



            // Başlangıçta tamamen görünür
           //


            // Önce bekle, sonra fade out başlat
            new Timer(sureSn * 1000, e -> {
                Timer fadeTimerOut = new Timer(20, ev -> {
                    float opacity = window.getOpacity();
                    opacity -= 0.05f; // her adımda %5 azalt
                    if (opacity <= 0f) {
                        window.setOpacity(0f);
                        ((Timer) ev.getSource()).stop();
                        window.dispose();
                    } else {
                        window.setOpacity(opacity);
                    }
                });
                fadeTimerOut.start();
            }).start();
        }

        private static JWindow getJWindow(String mesaj, Color arkaPlanRenk, Window parentWindow) {
            JWindow window = new JWindow(parentWindow);

            JPanel panel = new JPanel();
            panel.setBackground(arkaPlanRenk);
            JLabel label = new JLabel(mesaj);
            label.setForeground(Color.black);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            panel.add(label);

            window.add(panel);
            window.pack();

            if (parentWindow != null) {
                int parentX = parentWindow.getX();
                int parentY = parentWindow.getY();
                int parentWidth = parentWindow.getWidth();
                int parentHeight = parentWindow.getHeight();

                int windowWidth = window.getWidth();
                int windowHeight = window.getHeight();

                int x = parentX + (parentWidth - windowWidth) / 2;
                int y = parentY + (parentHeight - windowHeight) / 2;

                window.setLocation(x, y);
            }
            return window;
        }
    }



