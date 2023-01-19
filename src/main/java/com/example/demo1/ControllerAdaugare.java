package com.example.demo1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControllerAdaugare {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField aPlecare;
    @FXML
    TextField aSosire;
    @FXML
    TextField pretZbor;
    @FXML
    DatePicker dataZbor;
    public void adagare(ActionEvent e) throws IOException {
        /**
         * Aceasta metoda da posibilitatea adminului sa adauge zbourri noi
         *
         */
        String nrul="";
        File myObj7= new File("nrZboruriExistente.txt");
        Scanner myReader7= new Scanner(myObj7);
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        List<Zbor> l= new ArrayList<>();
        File file= new File("zboruri2.txt");
        l.addAll(deserializareZboruri2(file, Integer.parseInt(nrul)));
        String plec,sos,pret;
        LocalDate data;
        plec=aPlecare.getText();
        sos=aSosire.getText();
        pret=pretZbor.getText();
        data=dataZbor.getValue();
        Zbor z= new Zbor(plec,sos,data,"12:00",Integer.parseInt(pret));
        l.add(z);
        nrul=String.valueOf(Integer.parseInt(nrul)+1);
       // File f=new File("")
        serializareZboruri2(l,file);
        FileWriter myWriter= new FileWriter("nrZboruriExistente.txt");
        //nrul=String.valueOf(Integer.parseInt(nrul)+1);
        myWriter.write(nrul);
        myWriter.close();
        root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoAdmin1(ActionEvent event) throws IOException {
        /**
         * Aceasta metoda modifica scena, si da adminului posibilitatea sa se intoarca la pagina principala
         *
         */
        root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void serializareZboruri2(List<Zbor> l, File f){
        try{
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            for(Zbor i: l){
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Zbor> deserializareZboruri2(File f, int numar){
        List<Zbor> l= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<numar;i++){
                l.add((Zbor) ois.readObject());
            }
            ois.close();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }
}
