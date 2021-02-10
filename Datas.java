package sample;

import javafx.beans.property.SimpleStringProperty;

public class Datas {
    private SimpleStringProperty n1;
    private SimpleStringProperty n2;

    public Datas(String n1, String n2) {
        this.n1 = new SimpleStringProperty(n1);
        this.n2 = new SimpleStringProperty(n2);
    }

    public Datas() {
        this.n1 = new SimpleStringProperty("0");
        this.n2 = new SimpleStringProperty("0");
    }

    public String getN1() {
        return n1.get();
    }

    public void setN1(String n1) {
        this.n1.set(n1);
    }

    public String getN2() {
        return n2.get();
    }

    public void setN2(String n2) {
        this.n2.set(n2);
    }
}
