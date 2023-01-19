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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

public class ControllerDetaliiZbor {
    private Stage stage;
    private Scene scene;
    private Parent root;
    String ZborProb;
    @FXML
    Label aPlecare;
    @FXML
    Label aSosire;
    @FXML
    Label oraPlecare;
    @FXML
    Label pretZbor;
    @FXML
    ImageView imagDestinatie;
    public void displayZbor(String x){
       // String str = "Hello I'm your String";
        String[] splited = x.split("\\s+");
        aPlecare.setText(aPlecare.getText()+splited[0]);
        aSosire.setText(aSosire.getText()+splited[1]);
        oraPlecare.setText(oraPlecare.getText()+splited[2]);
        pretZbor.setText(pretZbor.getText()+splited[3]);
        ZborProb=x;

        //Image img= new Image();
        imagDestinatie=new ImageView();
       // imagDestinatie.setImage(img);



    }
    public void switchtoSceneProblema(ActionEvent event) throws IOException {
        /**
         * Aceasta metoda schimba scena pt a da posibilitatea userului si vb cu un admin pt support
         *
         */
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScenaProblema.fxml"));
        root = loader.load();
        ControllerZborProblema scene2Controller = loader.getController();
        scene2Controller.displayChat(ZborProb);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void serializareZboruriRezervate2(List<ZboruriRezervate> l, File f){
        try{
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            for(ZboruriRezervate i: l){
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<ZboruriRezervate> deserializareZboruriRezervate2(File f, int numar){
        List<ZboruriRezervate> l= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<numar;i++){
                l.add((ZboruriRezervate) ois.readObject());
            }
            ois.close();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }
}



