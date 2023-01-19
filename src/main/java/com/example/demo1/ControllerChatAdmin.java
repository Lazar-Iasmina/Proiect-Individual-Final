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

public class ControllerChatAdmin implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    String mesajSelectat;
    @FXML
    Label MesajSelectat;
    @FXML
    ListView<String> mesaje;
    List<Mesaj> l1=new ArrayList<>();
    public void initialize(URL arg0, ResourceBundle arg1){
        /**
         * Aceasta metoda afiseaza in gui toate chaturile unui admin
         */
        File file=new File("mesaje.txt");
        String nrul="";
        File myObj7= new File("nrMesaje.txt");
        Scanner myReader7= null;
        try {
            myReader7 = new Scanner(myObj7);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        l1.addAll(deserializareMesaje(file,Integer.parseInt(nrul)));
        File myObj= new File("userPass.txt");
        Scanner myReader= null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        File myObj2= new File("uPass.txt");
        Scanner myReader2= null;
        try {
            myReader2 = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String uname1,pass1;
        uname1="user";
        pass1="1234";
        while(myReader.hasNextLine()){
            uname1=myReader.nextLine();

        }
        while(myReader2.hasNextLine()){
            pass1=myReader2.nextLine();

        }
        List<String> LM= new ArrayList<>();
        for(Mesaj i: l1) {
            System.out.println();

                //System.out.println("///*"+i.getListaMesaje());
                LM.add(i.getUser()+" "+i.getZbor());

        }
       // System.out.println("//////*"+LM);
        mesaje.getItems().addAll(LM);
        mesaje.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                mesajSelectat=mesaje.getSelectionModel().getSelectedItem();
                MesajSelectat.setText(mesajSelectat);
            }
        });
    }
    public void displayChaturi(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatAdmin.fxml"));
        root = loader.load();
        ControllerChatroomAdmin scene2Controller = loader.getController();
        scene2Controller.displayChatroom(mesajSelectat);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchtoAdmin1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void serializareMesaje(List<Mesaj> l, File f){
        try{
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            for(Mesaj i: l){
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Mesaj> deserializareMesaje(File f, int numar){
        List<Mesaj> l= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<numar;i++){
                l.add((Mesaj) ois.readObject());
            }
            ois.close();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }
}
