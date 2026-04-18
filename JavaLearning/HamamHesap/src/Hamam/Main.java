package Hamam;

import javax.swing.*;
import java.io.*;
import Hamam.ReplaceValueInFile;



public class Main {
    public static final String appKlasorYolu = "HamamHesap";
    public static final String appVeriBelgesi = "geciciKullaniciVeri";
    public static final String appGunSonuBelgesi = "GunSonuHesapGirisi";
    public static final String appveribelgesiKlasorYolu = appKlasorYolu+"/"+appVeriBelgesi;
    public static final String appGunSonuBelgesiKlasorYolu = appKlasorYolu+"/"+appGunSonuBelgesi;
    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainScreen myScreen = new MainScreen();  // UI sınıfını oluştur
                myScreen.setVisible(true);   // UI'yi görünür yap
            }
        });

        // Önce klasör oluştur (program klasöründe "veriler" isimli)
        File folder = new File(appKlasorYolu);
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Klasör oluşturuldu: " + folder.getAbsolutePath());
            } else {
                System.out.println("Klasör oluşturulamadı!");
                return;
            }
        }

        // Dosyayı klasörün içine koy
        File file = new File(folder, appVeriBelgesi+".txt");

        try {
            if (file.exists()) {
                // Dosya zaten varsa sadece oku
                System.out.println("Dosya zaten mevcut. İçeriği okuyorum...");

                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                bufferedReader.close();
                reader.close();

            } else {
                FileWriter writer = new FileWriter(file);
                writer.write("<----Hunat Hamamı Hesap Uygulaması Geçici Veri Belgesi---->\n-------------By Legendnoobe------------\nToplam Tutar(0)=0\nToplam Yetiskin Giris(1)=0\nToplam Çocuk Giris(2)=0\nToplam Tüm Kese(3)=0\nToplam Sırt Kese(4)=0\nToplam Köpük Masaşı(5)=0\nToplam Yağ Masajı(6)=0\nToplam Kolonya Masajı(7)=0\nToplam Kumaş Kese(8)=0\nToplam Örgü Lif(9)=0\nToplam Yeşil Sabun(10)=0\nToplam Beyaz Sabun(11)=0\nToplam Topuk Taşı(12)=0\nToplam Şampuan(13)=0\nToplam Permatik(14)=0\nToplam Meyveli Soda(15)=0\nToplam Sade Soda(16)=0\nToplam Gazoz(17)=0\nToplam Teneke İçecek(18)=0\nToplam Kola(19)=0\nToplam Fanta(20)=0\nToplam Ayran(21)=0\nToplam Su(22)=0\nToplam Çay(23)=0\nToplam Kahve(24)=0");
                writer.close();

                System.out.println("Yeni dosya '" + file.getName() + "' klasör içine oluşturuldu.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
