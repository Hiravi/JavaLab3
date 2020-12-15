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
        return 0;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
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
