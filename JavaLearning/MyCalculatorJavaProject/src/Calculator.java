import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private JPanel JavaCalculator;
    private JButton button6;
    private JButton button9;
    private JButton button3;
    private JButton PlusButton;
    private JButton DivideButton;
    private JButton MultiplyButton;
    private JButton MinusButton;
    private JButton ClearButton;
    private JButton EqualsButton;
    private JButton DotButton;
    private JTextField textField1;
    private JButton button2;
    private JButton button5;
    private JButton button8;
    private JButton button0;
    private JButton button1;
    private JButton button4;
    private JButton button7;
    private JButton CosButton;
    private JLabel textDisplay;
    private JTextField textField2;

    private double total1;
    private double total2;
    private double answerNumber;
    private String mode;
    public static boolean CalculatorWorking = false;
    public static boolean process =false;
    public List<JButton> ProcessButtons=new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("MyCalculatorJavaProject By Salihefe");
        frame.setContentPane(new Calculator().JavaCalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500); // Genişlik: 400, Yükseklik: 300 piksel
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        CalculatorWorking = true;




    }

    public Calculator() {
        ProcessButtons.add(PlusButton);
        ProcessButtons.add(MinusButton);
        ProcessButtons.add(MultiplyButton);
        ProcessButtons.add(DivideButton);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button1);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button2);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button3);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button4);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button5);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button6);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button7);
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button8);
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button9);
            }
        });
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonClicked(button0);
            }
        });
        PlusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total1 = Double.parseDouble(textField1.getText());
                textField1.setText("");
                textField2.setText(total1+" + ");
                mode = "Plus";



            }
        });
        MinusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total1 = Double.parseDouble(textField1.getText());
                textField1.setText("");
                textField2.setText(total1+" - ");
                mode = "Minus";


            }
        });
        MultiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total1 = Double.parseDouble(textField1.getText());
                textField1.setText("");
                textField2.setText(total1+" * ");
                mode = "Multiply";



            }
        });
        DivideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total1 = Double.parseDouble(textField1.getText());
                textField1.setText("");
                textField2.setText(total1+" / ");
                mode = "Divide";

            }
        });

        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total1 =0;
                total2 = 0;
                textField1.setText("");
                textField2.setText("");
                textDisplay.setText("");
                String mode = "";

            }
        });
        DotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")){
                    textField1.setText("0.");
                }
                else if (textField1.getText().contains(".")){
                    DotButton.setEnabled(false);
                }
                else
                {
                    String DotButtonText = textField1.getText()+DotButton.getText();
                    textField1.setText(DotButtonText);
                }
                DotButton.setEnabled(true);
            }
        });
        EqualsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mode.equals("Plus")) {
                    total2 = total1 + Double.parseDouble(textField1.getText());

                }
                else if (mode.equals("Multiply")){
                    total2 = total1 * Double.parseDouble(textField1.getText());

                }
                else if (mode.equals("Minus")){
                    total2 = total1 - Double.parseDouble(textField1.getText());

                }
                else if (mode.equals("Divide")){
                    total2 = total1 / Double.parseDouble(textField1.getText());

                }

                textField2.setText(textField2.getText()+Double.parseDouble(textField1.getText()));
                textField1.setText(Double.toString(total2));
                mode = "";

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        textField2.setText(textField2.getText()+" = "+textField1.getText());
                        textField1.setText("");
                    }
                });
                timer.setRepeats(false); // sadece bir kez çalışsın
                timer.start();


            }
        });



    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

 public void ButtonClicked(JButton Button){
        if (Button!=ProcessButtons) {
            String ButtonText = Button.getText();
            textField1.setText(textField1.getText() + ButtonText);
        }

 }
}
