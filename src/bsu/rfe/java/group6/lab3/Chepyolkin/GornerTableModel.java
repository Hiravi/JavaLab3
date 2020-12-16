package bsu.rfe.java.group6.lab3.Chepyolkin;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double fromX;
    private Double toX;
    private Double step;

    public GornerTableModel(Double[] coefficients, Double fromX, Double toX, Double step) {
        this.coefficients = coefficients;
        this.fromX = fromX;
        this.toX = toX;
        this.step = step;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return new Double(Math.ceil((toX-fromX)/step)).intValue() + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Double result;
        Double x = fromX + rowIndex * step;
        if (columnIndex == 0) {
            return x;
        }
        else {
            result = coefficients[0];
            for (int i = 0; i < coefficients.length - 1; i++) {
                result = result * x + coefficients[i + 1];
            }
            return result;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Double.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Значение Х:";
            default:
                return "Значение многочлена:";
        }
    }

    // Сеттеры и геттеры
    public Double getFromX() {
        return fromX;
    }

    public void setFromX(Double fromX) {
        this.fromX = fromX;
    }

    public Double getToX() {
        return toX;
    }

    public void setToX(Double toX) {
        this.toX = toX;
    }

    public Double getStep() {
        return step;
    }

    public void setStep(Double step) {
        this.step = step;
    }
}
