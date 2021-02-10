package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Random;

public class Controller {
    @FXML
    TableView<Datas> tableView;
    @FXML
    private javafx.scene.control.TableColumn<Datas, String> k;
    @FXML
    private TableColumn<Datas, String> y;
    @FXML
    private TextArea txt_1;
    @FXML
    private TextArea txt_2;
    @FXML
    private Button b4;
    private final int row= 10;
    ObservableList<Datas> el = FXCollections.observableArrayList();
    public void b1_ch(ActionEvent actionEvent) {
        cleanUp();
        add();
        tableView.refresh();
    }
    public void b2_ch(ActionEvent actionEvent) {
        ArrayList<Double> listNum = new ArrayList<>();
        double result = 0;
        double sum = 0;
        double a = 0;
        double b = 0;
            for (int i = 0; i < el.size(); i++) {
                listNum.add(Double.parseDouble(el.get(i).getN1()));
            }
            a = Double.parseDouble(txt_1.getText());
            b = Double.parseDouble(txt_2.getText());
            for (int j = 0; j < listNum.size(); j++) {
                sum += listNum.get(j);
                if (j == 0) {
                    el.get(0).setN2("-");
                } else {
                    result = Math.sqrt(Math.pow(Math.cos(listNum.get(j)), 2)/((Math.pow(a, 2) + Math.pow(b, 2)) - Math.sin(listNum.get(j))))*(sum-listNum.get(j));
                    el.get(j).setN2(String.valueOf(result));
                }
            }
        tableView.refresh();
    }
    public void b3_ch(ActionEvent actionEvent) {
        for (int i = 0; i < row; i++) {
            el.get(i).setN1("0");
            el.get(i).setN2("");
        }
        txt_1.setText("0");
        txt_2.setText("0");
        tableView.refresh();
    }
    public void b4_ch(ActionEvent actionEvent) {
        Stage stage = (Stage) b4.getScene().getWindow();
        stage.close();
    }
    public void initialize() {
        tableView.itemsProperty().setValue(el);
        tableView.setEditable(true);
        add();
        k.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN1()));
        k.setCellFactory(TextFieldTableCell.forTableColumn());
        k.setOnEditCommit(event -> ((Datas) event.getTableView().getItems().get(event.getTablePosition().getRow())).setN1(event.getNewValue()));
        y.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN2()));
    }
    public void add() {
        double sum = 0.0;
        Random rnd1 = new Random();
        Random rnd2 = new Random();
        int a = rnd1.nextInt(20)-10;
        int b = rnd2.nextInt(20)-10;
        txt_1.setText(String.valueOf(a));
        txt_2.setText(String.valueOf(b));
        for (int i = 0; i < row; i++) {
            double randomNum = Math.random()*100;
            sum += randomNum;
            el.add(new Datas(String.valueOf(randomNum), taskR(randomNum,sum, a, b)));
        }
        el.get(0).setN2("-");
    }
    public String taskR(double num, double sum, int a, int b) {
        String result = "";
        double aNum = a;
        double bNum = b;
        result = String.valueOf(Math.sqrt(Math.pow(Math.cos(num), 2)/((Math.pow(aNum, 2) + Math.pow(bNum, 2)) - Math.sin(num)))*(sum-num));
        return result;
    }
    public void cleanUp() {
        if (el.size() != 0) {
            for (int i = 0; i < row; i++) {
                el.remove(0);
            }
        }
    }

}
