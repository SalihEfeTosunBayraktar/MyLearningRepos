package Hamam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadValueInFiles {

        public static double readValue(int index) {
            String currentValueStr = "";
            try {
                // 1. Dosyayı satır satır oku
                List<String> lines = Files.readAllLines(Paths.get(Main.appveribelgesiKlasorYolu+".txt"));

                // 2. Satırları kontrol et ve değiştir
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);

                    if (line.contains("(" + index + ")=")) {
                        int eqIndex = line.indexOf("=");

                        // Mevcut değeri al
                        currentValueStr = line.substring(eqIndex + 1).trim();


                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Double.parseDouble(currentValueStr);
        }



}
