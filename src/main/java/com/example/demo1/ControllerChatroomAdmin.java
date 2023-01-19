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

public class ControllerChatroomAdmin {
    private Stage stage;
    private Scene scene;
    private Parent root;
    List<Mesaj> l1= new ArrayList<>();
    String Zborul;
    String user;
    String zbor;
    @FXML
    ListView<String> mesaje;
    @FXML
    TextField mesaj;
    public void displayChatroom(String x){
        Zborul=x;
        try {
            /**
             * Aceasta metoda afiseaza toate mesajele dintre admin si un user despre un anumit zbor
             *
             */
            File file = new File("mesaje.txt");
            String nrul = "";
            File myObj7 = new File("nrMesaje.txt");
            Scanner myReader7 = new Scanner(myObj7);
            while (myReader7.hasNextLine()) {
                nrul = myReader7.nextLine();

            }
            l1.addAll(deserializareMesaje(file, Integer.parseInt(nrul)));

            String uname1, pass1;
            uname1 = "user";
            pass1 = "1234";
            String[] splited = x.split("\\s+");
            //aPlecare.setText(aPlecare.getText()+splited[0]);
            user=splited[0];
            zbor=splited[1]+" "+splited[2]+" "+splited[3]+" "+splited[4];

            List<String> LM = new ArrayList<>();
            for (Mesaj i : l1) {
                System.out.println(user + "       " + i.getUser() + "    " + i.getZbor() + "    " + zbor);
                if (i.getUser().equals(user) && i.getZbor().equals(zbor)) {
                    System.out.println("///*" + i.getListaMesaje());
                    LM.addAll(i.getListaMesaje());
                }
            }
            System.out.println("//////*" + LM);
            mesaje.getItems().addAll(LM);
        }catch (Exception e){
            e.printStackTrace();
        }




    }
    public void sendMesaj(ActionEvent e) throws IOException{
        /**
         * Aceasta metodade posibilitatea adminului sa dea mesaj userului
         *
         */
        String msg= mesaj.getText();
        mesaje.getItems().add("Employee : "+ msg);
        mesaj.setText("");
        File file=new File("mesaje.txt");
        String nrul="";
        File myObj7= new File("nrMesaje.txt");
        Scanner myReader7= new Scanner(myObj7);
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        l1.clear();
        l1.addAll(deserializareMesaje(file,Integer.parseInt(nrul)));
        String uname1,pass1;
        uname1="user";
        pass1="1234";

        List<String> lst=new ArrayList<>();
        int ok=0;
        for(Mesaj i: l1) {
            System.out.println(uname1+"       "+i.getUser()+"    "+i.getZbor()+"    "+Zborul);
            if (i.getUser().equals(user) && i.getZbor().equals(zbor)) {
                lst=i.getListaMesaje();
                lst.add("Employee : "+ msg);
                i.setListaMesaje(lst);
                ok=1;
            }
        }
        System.out.println();
        for(Mesaj i: l1){
            System.out.println(i);
        }
        serializareMesaje(l1,file);
        FileWriter myWriter= new FileWriter("nrMesaje.txt");
        //nrul=String.valueOf(Integer.parseInt(nrul)+1);
        myWriter.write(nrul);
        myWriter.close();


    }
    public void refresh(ActionEvent e) throws IOException {
        /**
         * Aceasta metoda face refresh pt ca adminul si userul sa poata coresponda
         *
         */
        //mesaje.getItems().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatAdmin.fxml"));
        root = loader.load();
        ControllerChatroomAdmin scene2Controller = loader.getController();
        scene2Controller.displayChatroom(Zborul);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
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
