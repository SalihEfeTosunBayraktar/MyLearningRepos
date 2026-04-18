package Hamam;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class ReplaceValueInFile {

    public static void replaceValue(int index, double newValue) {
        try {
            // 1. Dosyayı satır satır oku
            List<String> lines = Files.readAllLines(Paths.get(Main.appveribelgesiKlasorYolu+".txt"));

            // 2. Satırları kontrol et ve değiştir
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);

                if (line.contains("(" + index + ")=")) {
                    int eqIndex = line.indexOf("=");

                    // Mevcut değeri al
                    String currentValueStr = line.substring(eqIndex + 1).trim();
                    double currentValue = Double.parseDouble(currentValueStr);

                    // Yeni değeri ekle
                    double updatedValue = currentValue + newValue;

                    lines.set(i, line.substring(0, eqIndex + 1) + updatedValue);
                    break;
                }
            }

            // 3. Dosyaya tekrar yaz
            Files.write(Paths.get("veriler/kullaniciveri.txt"), lines);

            System.out.println("Dosya güncellendi.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
