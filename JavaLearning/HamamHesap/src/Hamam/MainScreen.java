package Hamam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MainScreen extends JFrame{
    public Double Tutar;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField14;
    private JTextField textField13;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField17;
    private JTextField textField18;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField22;
    private JTextField textField23;
    private JTextField textField24;
    private JButton tutarHesaplaButton;
    private JButton sıfırlaButton;
    private JButton odemeAlButton;
    private JTextArea TutarTextDisplay;
    private JLabel TutarDoubleDisplay;
    private JPanel MainPanel;
    private JTextField alinanUcretTextField;
    private JLabel paraUstuTextfield;
    private JButton kaydetButton;
    private JButton günSonuButton;
    private JButton l1ButtonUp;

    //Penceremizin Constructure Metodu
    public MainScreen() {

        SwingUtilities.invokeLater(() -> {
            MainPanel.getRootPane().requestFocusInWindow();
        });
        setResizable(true);
        setTitle("Hunat Hamamı Hesap Sistemi By Legendnoobe");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Ekranın ortasında açılması için
        add(MainPanel);
        //Kullanacağımız textfield ları array liste ekledik
        ArrayList<JTextField> fields = new ArrayList<JTextField>();
        Collections.addAll(fields,textField1, textField2, textField3, textField4, textField5,
                textField6, textField7, textField8, textField9, textField10,
                textField11, textField12, textField13, textField14, textField15,
                textField16, textField17, textField18, textField19, textField20,
                textField21, textField22, textField23, textField24, alinanUcretTextField);

        //cusytom focus listener oluşturduk
        FocusListener baseFocusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                source.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                String text = source.getText();
                try {
                    int value = Integer.parseInt(text);
                    System.out.println("Girilen Değer Geçerli Bir Sayı");
                } catch (NumberFormatException a) {
                    System.out.println("Girilen Değer Geçerli Bir Sayı Değil");

                        if (source == textField1)
                            source.setText("1");
                        else if (source == alinanUcretTextField)
                            source.setText("Alınan Ücret");
                        else
                            source.setText("0");
                }
            }
        };
        addBaseFocusListenerToTextfields(baseFocusListener,fields);
        tutarHesaplaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              calculatePrice();
            }
        });
        sıfırlaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll(fields);
            }
        });
        //Burada Klavye ile kod kontrolü sağlıyoruz
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ENTER) {
                            calculatePrice();
                        }
                        if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_DELETE) {
                            clearAll(fields);
                        }
                        return false; // false = diğer bileşenler de olayı işleyebilsin

                    }
                });
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //ReplaceValueInFile.replaceValue(0);
              ReplaceValueInFile.replaceValue(1,textToDoublePars(textField1));
              ReplaceValueInFile.replaceValue(2,textToDoublePars(textField2));
              ReplaceValueInFile.replaceValue(3,textToDoublePars(textField3));
              ReplaceValueInFile.replaceValue(4,textToDoublePars(textField4));
              ReplaceValueInFile.replaceValue(5,textToDoublePars(textField5));
              ReplaceValueInFile.replaceValue(6,textToDoublePars(textField6));
              ReplaceValueInFile.replaceValue(7,textToDoublePars(textField7));
              ReplaceValueInFile.replaceValue(8,textToDoublePars(textField8));
              ReplaceValueInFile.replaceValue(9,textToDoublePars(textField9));
              ReplaceValueInFile.replaceValue(10,textToDoublePars(textField19));
              ReplaceValueInFile.replaceValue(11,textToDoublePars(textField20));
              ReplaceValueInFile.replaceValue(12,textToDoublePars(textField21));
              ReplaceValueInFile.replaceValue(13,textToDoublePars(textField22));
              ReplaceValueInFile.replaceValue(14,textToDoublePars(textField23));
              ReplaceValueInFile.replaceValue(15,textToDoublePars(textField10));
              ReplaceValueInFile.replaceValue(16,textToDoublePars(textField11));
              ReplaceValueInFile.replaceValue(17,textToDoublePars(textField12));
              ReplaceValueInFile.replaceValue(18,textToDoublePars(textField13));
              ReplaceValueInFile.replaceValue(19,textToDoublePars(textField14));
              ReplaceValueInFile.replaceValue(20,textToDoublePars(textField15));
              ReplaceValueInFile.replaceValue(21,textToDoublePars(textField16));
              ReplaceValueInFile.replaceValue(22,textToDoublePars(textField17));
              ReplaceValueInFile.replaceValue(23,textToDoublePars(textField18));
              ReplaceValueInFile.replaceValue(24,textToDoublePars(textField19));
              ReplaceValueInFile.replaceValue(25,textToDoublePars(textField24));
              NotificationScreen.showNotification(MainPanel,"Başarıyla Kaydedildi",2,Color.green);
            }
        });
        günSonuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NotificationScreen.showNotification(MainPanel,"Gün Sonu Belgesi Veriler Dosyasına Yazdırıldı.",2,Color.orange);
                    DayFinalInFiles.dayFinalText();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


    //Burada Focus listeneri tüm textfieldlar için çalışır hale getiriyoruz
    public void addBaseFocusListenerToTextfields(FocusListener listener,ArrayList<JTextField> fields){
        for (JTextField field : fields){
            field.addFocusListener(listener);
        }
    }
    //Burada Tüm fieldları defult hale getiriyoruz
    public void clearAll(ArrayList<JTextField> fields){
        for (JTextField field : fields) {
            if (field==textField1)
                field.setText("1");
            else if (field==alinanUcretTextField)
                field.setText("Alınan Ücret");
            else
                field.setText("0");

        }
        paraUstuTextfield.setText("Para Üstü");
        TutarTextDisplay.setText("Tutar Tablosu");
        TutarDoubleDisplay.setText("Toplam Tutar");
    }
    //Burada Hesaplamaları yaptırıyoruz
    public void calculatePrice(){
        Double normalEnt = (textToDoublePars(textField1)*200);
        Double childEnt = (textToDoublePars(textField2)*100);
        Double tumKeseEnt = (textToDoublePars(textField3)*80);
        Double bolusunTumKeseEnt = (textToDoublePars(textField3)*40);
        Double sirtEnt = (textToDoublePars(textField4)*40);
        Double bolusulensirtEnt = (textToDoublePars(textField4)*20);
        Double kopukEnt = (textToDoublePars(textField5)*80);
        Double yagEnt = (textToDoublePars(textField6)*250);
        Double kolonyaEnt = (textToDoublePars(textField7)*60);
        Double kumasKeseEnt = (textToDoublePars(textField8)*80);
        Double orguLifEnt = (textToDoublePars(textField9)*80);
        Double yesilSabunEnt = (textToDoublePars(textField19)*40);
        Double beyazSabunEnt = (textToDoublePars(textField20)*25);
        Double topukTasiEnt = (textToDoublePars(textField21)*30);
        Double sampuanEnt = (textToDoublePars(textField22)*150);
        Double permatikEnt = (textToDoublePars(textField23)*15);
        //Hamam İçinde Tutan Toplam Ücret
        Double hamamiciTutarEnt = normalEnt+childEnt+tumKeseEnt+sirtEnt+kopukEnt+yagEnt+kolonyaEnt
                +kumasKeseEnt+orguLifEnt+yesilSabunEnt+beyazSabunEnt+topukTasiEnt+sampuanEnt+permatikEnt;

        Double meyveliSodaEnt = (textToDoublePars(textField10)*30);
        Double sadeSodaEnt = (textToDoublePars(textField11)*15);
        Double gazozEnt = (textToDoublePars(textField12)*20);
        Double tenekeEnt = (textToDoublePars(textField13)*40);
        Double kolaEnt = (textToDoublePars(textField14)*40);
        Double fantaEnt = (textToDoublePars(textField15)*40);
        Double ayranEnt = (textToDoublePars(textField16)*30);
        Double suEnt = (textToDoublePars(textField17)*10);
        Double cayEnt = (textToDoublePars(textField18)*10);
        Double kahveEnt = (textToDoublePars(textField24)*30);

        //Hamam Dışı Alınan İçecek Ücretleri
        Double hamamDisiTutarEnt = meyveliSodaEnt+sadeSodaEnt+gazozEnt+tenekeEnt+kolaEnt
                +fantaEnt+ayranEnt+suEnt+cayEnt+kahveEnt;

        Double hamamAlacakUcret = (hamamiciTutarEnt+hamamDisiTutarEnt)-(bolusulensirtEnt+bolusunTumKeseEnt+yagEnt+kopukEnt+kolonyaEnt);
        Double keseciAlacakUcret = bolusulensirtEnt+bolusunTumKeseEnt+yagEnt+kopukEnt+kolonyaEnt;

        TutarTextDisplay.setText("Hamamın Alacağı Tutar "+hamamAlacakUcret+" tl\n"+"Kesecinin Alacağı Tutar "+keseciAlacakUcret+" tl");
        TutarDoubleDisplay.setText("Toplam Tutar:"+Double.toString(hamamiciTutarEnt+ hamamDisiTutarEnt)+"tl");
        Tutar = (hamamiciTutarEnt+ hamamDisiTutarEnt);


        String text = alinanUcretTextField.getText();
        try {
            int value = Integer.parseInt(text);
            System.out.println("Geçerli sayı: " + value);

            Double flagControl = (Double.parseDouble((alinanUcretTextField.getText()))-Tutar);

            if (flagControl>0){
                paraUstuTextfield.setText("Verilecek Para Üstü "+((Double.toString(Math.abs(flagControl))))+" tl");
            }
            else if (flagControl<0){
                paraUstuTextfield.setText("Alınacak Para "+((Double.toString(Math.abs(flagControl))))+" tl");
            }
            else if (flagControl==0){
                paraUstuTextfield.setText("Verilecek Veya Alınacak Para Üstü Yok ");
            }
        } catch (NumberFormatException a) {
            System.out.println("Sayı değil!");
        }

    }
    //Burada Metinden Alınan Verileri Double Sayıya Çeviriyoruz
    public double textToDoublePars(JTextField textfield){
        return Double.parseDouble(textfield.getText().toString());

    }


}

