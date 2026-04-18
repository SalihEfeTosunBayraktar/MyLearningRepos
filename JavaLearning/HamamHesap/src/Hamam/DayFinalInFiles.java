package Hamam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DayFinalInFiles {

    // Ürünleri ve birim fiyatlarını tanımlıyoruz
    static class Product {
        String name;
        int priceMultiplier; // TL çarpanı
        Product(String name, int priceMultiplier) {
            this.name = name;
            this.priceMultiplier = priceMultiplier;
        }
    }

    public static void dayFinalText() throws IOException {
        Product[] products = {
                new Product("Yetiskin Giris", 200),
                new Product("Çocuk Giris", 100),
                new Product("Tüm Kese", 80),
                new Product("Sırt Kese", 40),
                new Product("Köpük Masajı", 80),
                new Product("Yağ Masajı", 250),
                new Product("Kolonya Masajı", 60),
                new Product("Kumaş Kese", 80),
                new Product("Örgü Lif", 80),
                new Product("Yeşil Sabun", 40),
                new Product("Beyaz Sabun", 25),
                new Product("Topuk Taşı", 30),
                new Product("Şampuan", 150),
                new Product("Permatik", 15),
                new Product("Meyveli Soda", 30),
                new Product("Sade Soda", 15),
                new Product("Gazoz", 20),
                new Product("Teneke İçecek", 40),
                new Product("Kola", 40),
                new Product("Fanta", 40),
                new Product("Ayran", 20),
                new Product("Su", 10),
                new Product("Çay", 10),
                new Product("Kahve", 30)
        };

        List<Integer> totals = new ArrayList<>();
        int dayFinalTLAmount = 0;

        // Tüm ürünlerin TL toplamlarını ve günlük toplamı hesapla
        for (int i = 0; i < products.length; i++) {
            int quantity = (int) ReadValueInFiles.readValue(i + 1);
            int total = quantity * products[i].priceMultiplier;
            totals.add(total);
            dayFinalTLAmount += total;
        }

        // Dosya oluşturma
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm");
        String formattedDateTime = now.format(formatter);
        File file = new File(Main.appGunSonuBelgesiKlasorYolu + formattedDateTime + ".txt");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.format("%-20s %-10s %-15s%n", "Ürün", "Adet", "Toplam TL"));
            writer.write("----------------------------------------------------\n");

            for (int i = 0; i < products.length; i++) {
                int quantity = (int) ReadValueInFiles.readValue(i + 1);
                writer.write(String.format("%-20s %-10d %-15d%n", products[i].name, quantity, totals.get(i)));
            }

            writer.write("----------------------------------------------------\n");
            writer.write(String.format("%-20s %-10s %-15d%n", "Toplam Tutar", "", dayFinalTLAmount));
        }


        System.out.println("Yeni dosya '" + file.getName() + "' klasör içine oluşturuldu.");
    }
}
