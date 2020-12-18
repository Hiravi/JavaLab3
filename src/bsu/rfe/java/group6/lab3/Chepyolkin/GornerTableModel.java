package bsu.rfe.java.group6.lab3.Chepyolkin;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
        return 3;
    }
    public int getRowCount() {
        // Вычислить количество точек между началом и концом отрезка
        // исходя из шага табулирования
        return new Double(Math.ceil((to-from)/step)).intValue() + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        Double result;
        Double x = from + rowIndex * step;
        if (columnIndex == 0) {
            return x;
        }
        else if (columnIndex == 1) {
            result = coefficients[0];
            for (int i = 0; i < coefficients.length - 1; i++) {
                result = result * x + coefficients[i + 1];
            }
            return result;
        }
        else {
            result = coefficients[0];
            Boolean resultBoolean;
            for (int i = 0; i < coefficients.length - 1; i++) {
                result = result * x + coefficients[i + 1];
            }
            String temp = Double.toString(result);
            char[] arr = temp.toCharArray();

            if (arr[0] == '0' ||( arr[0] == '-' && arr[1] == '0')) {
                resultBoolean = true;
            } else {
                resultBoolean = false;
            }
            return resultBoolean;
        }
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
                return "Дробная часть является квадратом?";
        }
    }
    public Class<?> getColumnClass(int col) {
        // И в 1-ом и во 2-ом столбце находятся значения типа Double
        if(col == 2)
            return Boolean.class;
        else
            return Double.class;
    }
}
