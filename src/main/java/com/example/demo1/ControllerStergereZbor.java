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

public class ControllerStergereZbor {
    private Stage stage;
    private Scene scene;
    private Parent root;
    List<Zbor> l1=new ArrayList<>();
    String ZborSelectat;
    @FXML
    Label zbor;
    @FXML
    ListView<String> zboruri;
    public void displayZboruri(){
        try {
            File file = new File("zboruri2.txt");
            String nrul = "";
            File myObj7 = new File("nrZboruriExistente.txt");
            Scanner myReader7 = new Scanner(myObj7);
            while (myReader7.hasNextLine()) {
                nrul = myReader7.nextLine();

            }
            l1.addAll(deserializareZboruri2(file, Integer.parseInt(nrul)));
            List l2= new ArrayList();
            for(Zbor i: l1){
                l2.add(afisare(i));
            }


            String uname1, pass1;
            uname1 = "user";
            pass1 = "1234";
            /*String[] splited = x.split("\\s+");
            //aPlecare.setText(aPlecare.getText()+splited[0]);
            user=splited[0];
            zbor=splited[1]+" "+splited[2]+" "+splited[3]+" "+splited[4];*/


            System.out.println("//////*" + l2);
            zboruri.getItems().addAll(l2);
            zboruri.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    ZborSelectat=zboruri.getSelectionModel().getSelectedItem();
                    zbor.setText(ZborSelectat);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(ActionEvent e) throws IOException {
        File file = new File("zboruri2.txt");
        String nrul = "";
        File myObj7 = new File("nrZboruriExistente.txt");
        Scanner myReader7 = new Scanner(myObj7);
        while (myReader7.hasNextLine()) {
            nrul = myReader7.nextLine();

        }
        l1.addAll(deserializareZboruri2(file, Integer.parseInt(nrul)));
        List l2= new ArrayList();
        String x;
        x=zbor.getText();
        int ok=-1,in=0;
        Zbor y=new Zbor("Tokyo","Atena",LocalDate.of(2022,12,8),"12.30",1500);
        List<Zbor> l3=new ArrayList<>();
        l3.clear();
        for(Zbor i: l1){
            System.out.println(x+"    "+afisare(i));
            if(afisare(i).equals(x)){
                in++;
                System.out.println("*"+x+"    "+afisare(i));
            }
            else{
                l3.add(i);
            }

        }
        for(Zbor i: l3) {
            System.out.println(afisare(i));
        }


        serializareZboruri2(l3,file);
        FileWriter myWriter= new FileWriter("nrZboruriExistente.txt");
        nrul=String.valueOf(Integer.parseInt(nrul)-1);
        myWriter.write(nrul);
        myWriter.close();
        root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
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
    public static String afisare(Zbor i){
        return i.getaPlecare()+" "+i.getaSosire()+" "+i.getDataPlecare()+i.getPretZbor();
    }
}
