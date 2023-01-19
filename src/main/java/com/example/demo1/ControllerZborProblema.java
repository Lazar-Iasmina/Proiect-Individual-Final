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

public class ControllerZborProblema {
    private Stage stage;
    private Scene scene;
    private Parent root;
    String Zborul;
    List<Mesaj> l1= new ArrayList<>();
    @FXML
    ListView<String> mesaje;
    @FXML
    TextField mesaj;


    public void displayChat(String x) throws FileNotFoundException{
        Zborul=x;

        File file=new File("mesaje.txt");
        String nrul="";
        File myObj7= new File("nrMesaje.txt");
        Scanner myReader7= new Scanner(myObj7);
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        l1.addAll(deserializareMesaje(file,Integer.parseInt(nrul)));
        File myObj= new File("userPass.txt");
        Scanner myReader= new Scanner(myObj);
        File myObj2= new File("uPass.txt");
        Scanner myReader2= new Scanner(myObj);
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
            System.out.println(uname1+"       "+i.getUser()+"    "+i.getZbor()+"    "+Zborul);
            if (i.getUser().equals(uname1) && i.getZbor().equals(Zborul)) {
                System.out.println("///*"+i.getListaMesaje());
                LM.addAll(i.getListaMesaje());
            }
        }
        System.out.println("//////*"+LM);
        mesaje.getItems().addAll(LM);





    }
    public void sendMesaj(ActionEvent e) throws IOException {
        String msg= mesaj.getText();
        mesaje.getItems().add("User : "+ msg);
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
        File myObj= new File("userPass.txt");
        Scanner myReader= new Scanner(myObj);
        File myObj2= new File("uPass.txt");
        Scanner myReader2= new Scanner(myObj);
        String uname1,pass1;
        uname1="user";
        pass1="1234";
        while(myReader.hasNextLine()){
            uname1=myReader.nextLine();

        }
        while(myReader2.hasNextLine()){
            pass1=myReader2.nextLine();

        }
        List<String> lst=new ArrayList<>();
        int ok=0;
        for(Mesaj i: l1) {
            System.out.println(uname1+"       "+i.getUser()+"    "+i.getZbor()+"    "+Zborul);
            if (i.getUser().equals(uname1) && i.getZbor().equals(Zborul)) {
                lst=i.getListaMesaje();
                lst.add("User : "+ msg);
                i.setListaMesaje(lst);
                ok=1;
            }
        }
        if(ok==0){
            System.out.println();
            for(Mesaj i: l1){
                System.out.println(i);
            }
            System.out.println();

            Mesaj mes=new Mesaj(uname1,Zborul);
            lst=mes.getListaMesaje();
            lst.add("User : "+ msg);
            mes.setListaMesaje(lst);
            l1.add(mes);
            System.out.println("***"+mes);
            nrul=String.valueOf(Integer.parseInt(nrul)+1);
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
        //mesaje.getItems().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScenaProblema.fxml"));
        root = loader.load();
        ControllerZborProblema scene2Controller = loader.getController();
        scene2Controller.displayChat(Zborul);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
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
