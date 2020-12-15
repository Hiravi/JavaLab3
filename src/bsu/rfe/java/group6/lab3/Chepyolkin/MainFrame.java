package bsu.rfe.java.group6.lab3.Chepyolkin;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame {

    public static final int WIDTH = 720;
    public static final int HEIGHT = 480;
    JLabel labelStartX = new JLabel("X изменяется на интервале от:");
    JLabel labelEndX = new JLabel("до:");
    JLabel labelStep = new JLabel("с шагом:");
    JTextField fieldStartX = new JTextField("0.0", 10);
    JTextField fieldEndX = new JTextField("0.0", 10);
    JTextField fieldStep = new JTextField("0.0", 10);


    MainFrame () {

        super("name");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setBounds((toolkit.getScreenSize().width - WIDTH) / 2, (toolkit.getScreenSize().height - HEIGHT) / 2, WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Выпадающее меню "Файл"
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");

        // Контейнер ввода данных
        fieldStartX.setMaximumSize(fieldStartX.getPreferredSize());
        fieldEndX.setMaximumSize(fieldEndX.getPreferredSize());
        fieldStep.setMaximumSize(fieldStep.getPreferredSize());
        Box hboxDataFilds = Box.createHorizontalBox();
        hboxDataFilds.add(Box.createHorizontalGlue());
        hboxDataFilds.add(labelStartX);
        hboxDataFilds.add(Box.createHorizontalStrut(10));
        hboxDataFilds.add(fieldStartX);
        hboxDataFilds.add(Box.createHorizontalStrut(20));
        hboxDataFilds.add(labelEndX);
        hboxDataFilds.add(Box.createHorizontalStrut(10));
        hboxDataFilds.add(fieldEndX);
        hboxDataFilds.add(Box.createHorizontalStrut(20));
        hboxDataFilds.add(labelStep);
        hboxDataFilds.add(Box.createHorizontalStrut(10));
        hboxDataFilds.add(fieldStep);
        hboxDataFilds.add(Box.createHorizontalGlue());











        // Кнопка "Вычислить"
       /* buttonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double x = Double.valueOf(fieldX.getText());
                    Double y = Double.valueOf(fieldY.getText());
                    Double z = Double.valueOf(fieldZ.getText());
                    if (formulaID == 1) {
                        result = calculate1(x, y, z);
                    }
                    else {
                        result = calculate2(x, y, z);
                    }
                    fieldResult.setText(result.toString());
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи " +
                            "числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Кнопка "Очистить поля"
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldX.setText("0");
                fieldY.setText("0");
                fieldZ.setText("0");
                fieldResult.setText("0");
            }
        });*/




    }
}
