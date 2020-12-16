package bsu.rfe.java.group6.lab3.Chepyolkin;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MainFrame extends JFrame {

    public static final int WIDTH = 720;
    public static final int HEIGHT = 480;
    private Double[] coefficients;
    private JFileChooser fileChooser = null;
    private GornerTableCellRenderer renderer = new GornerTableCellRenderer();
    private JMenuItem saveToTextMenuItem;
    private JMenuItem saveToGraphicsMenuItem;
    private JMenuItem searchValueMenuItem;
    private Box hboxResult;
    private GornerTableModel data;

    MainFrame(Double[] coefficients) {

        super("name");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setBounds((toolkit.getScreenSize().width - WIDTH) / 2, (toolkit.getScreenSize().height - HEIGHT) / 2,
                WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.coefficients = coefficients;

        // Поля ввода данных с названиями
        JLabel labelStartX = new JLabel("X изменяется на интервале от:");
        JLabel labelEndX = new JLabel("до:");
        JLabel labelStep = new JLabel("с шагом:");
        JTextField fieldStartX = new JTextField("0.0", 10);
        JTextField fieldEndX = new JTextField("0.0", 10);
        JTextField fieldStep = new JTextField("0.0", 10);

        // Выпадающее меню "Файл"
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu tableMenu = new JMenu("Таблица");
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Обработка активации "Сохранить в текстовый файл"
        Action saveToFileAction = new AbstractAction("Сохранить в текстовом файле") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser == null) {
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("."));
                }
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    saveToTextFile(fileChooser.getSelectedFile());
                }
            }
        };

        // Добавить пункт "Сохранить в текстовый файл" в меню "Файл"
        saveToTextMenuItem = fileMenu.add(saveToFileAction);
        saveToGraphicsMenuItem.setEnabled(false);

        // Создать новое действие по поиску значений многочлена
        Action searchValueAction = new AbstractAction("Найти значение многочлена") {
            public void actionPerformed(ActionEvent event) {

                // Запросить пользователя ввести искомую строку
                String value = JOptionPane.showInputDialog(MainFrame.this, "Введите значение для поиска",
                                "Поиск значения", JOptionPane.QUESTION_MESSAGE);
                // Установить введенное значение в качестве иголки
                renderer.setNeedle(value);

                // Обновить таблицу
                getContentPane().repaint();//метод JFrame
            }
        };

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
       /* JButton buttonCalc = new JButton();
       buttonCalc.addActionListener(new ActionListener() {
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

    protected void saveToTextFile(File selectedFile) {

        try {

            PrintStream out = new PrintStream(selectedFile);
            out.println("Результаты табулированных вычислений по схеме Горнера");
            out.print ("Многочлен: ");
            for (int i=0; i<coefficients.length; i++) {
                out.print(coefficients[i] + "*X^" +
                        (coefficients.length-i-1));
                if (i!=coefficients.length-1)
                    out.print(" + ");
            }
            out.println("");
            out.println("Интервал от " + data.getFromX() + " до " +
                    data.getToX() + " с шагом " + data.getStep());
            out.println("====================================================");
            // Записать в поток вывода значения в точках
            for (int i = 0; i<data.getRowCount(); i++) {
                out.println("Значение в точке " + data.getValueAt(i,0)
                        + " равно " + data.getValueAt(i,1));
            }
            // Закрыть поток
            out.close();


        }
        catch (FileNotFoundException e) {

        }
    }
}