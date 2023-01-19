package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ControllerScena2 {
    @FXML
    Label nameLabel;
    @FXML
    Label labelDestinatie;
    @FXML
    Label labelZboruri;
    @FXML
    Label labelPlecare;
    @FXML
    Label labelZboruriIntoarcere;


    @FXML
    Label zboruriDus;
    private String dicb;
    String aPlecare,aSosire;
    LocalDate dPlecare,dSosire;
    private boolean dusIntors;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void displayDestinatie(String destinatie, String sosire, LocalDate plecare, LocalDate timpSosire) throws IOException{
        //nameLabel.setText("Hello: "+destinatie+" "+ sosire+" "+plecare+" "+timpSosire);
        //nameLabel.setText(nameLabel.getText()+"\nIasmina");
        labelDestinatie.setText(labelDestinatie.getText()+" "+destinatie+" "+plecare);
        labelPlecare.setText(labelPlecare.getText()+" "+sosire+" "+timpSosire);
        aPlecare=destinatie;
        aSosire=sosire;
        dPlecare=plecare;
        dSosire=timpSosire;
        FileWriter myWriter= new FileWriter("fisierDestinatie.txt");
        myWriter.write(aPlecare);
        myWriter.close();
        FileWriter myWriter2= new FileWriter("fisierSosire.txt");
        myWriter2.write(aSosire);
        myWriter2.close();
        FileWriter myWriter3= new FileWriter("fisierdataPlecare.txt");
        myWriter3.write(""+dPlecare);
        myWriter3.close();
        FileWriter myWriter4= new FileWriter("fisierdataSosire.txt");
        myWriter4.write(""+dSosire);
        myWriter4.close();


        List<Zbor> l= new ArrayList<>();
        File file= new File("zboruri2.txt");
        String nrul="";
        File myObj7= new File("nrZboruriExistente.txt");
        Scanner myReader7= new Scanner(myObj7);
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        l.addAll(deserializareZboruri2(file, Integer.parseInt(nrul)));
        for(Zbor i: l){
            System.out.println("****");
            System.out.println(i.getaPlecare()+destinatie+i.getaSosire()+sosire+i.getDataPlecare()+plecare);
            if(i.getaPlecare().equals(destinatie) && i.getaSosire().equals(sosire) && i.getDataPlecare().isEqual(plecare))
                labelZboruri.setText(labelZboruri.getText()+"\n"+i.getaPlecare()+" "+i.getaSosire()+" "+i.getDataPlecare()+" "+i.getOraZbor()+" "+i.getPretZbor()+" lei");

        }
        for(Zbor i: l){
            System.out.println(i.getaPlecare()+sosire+i.getaSosire()+destinatie+i.getDataPlecare()+ timpSosire);
            if(i.getaPlecare().equals(sosire) && i.getaSosire().equals(destinatie) && i.getDataPlecare().isEqual(timpSosire))
                labelZboruriIntoarcere.setText(labelZboruriIntoarcere.getText()+"\n"+i.getaPlecare()+" "+i.getaSosire()+" "+i.getDataPlecare()+" "+i.getOraZbor()+" "+i.getPretZbor()+" lei");
        }


    }
    public void switchtoScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
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
    public void switchtoScene5(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Scena5.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchtoScene6(ActionEvent e) throws Exception{
        List<Zbor> l= new ArrayList<>();
        File file= new File("zboruri2.txt");
        l.addAll(deserializareZboruri2(file, 6));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scena6.fxml"));
        root = loader.load();
        ControllerScena5 scene5Controller = (ControllerScena5) loader.getController();
        System.out.println("**"+aPlecare+aSosire);
        scene5Controller.displayDestinatie(l);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();





    }
    public void switchtoScene7(ActionEvent e) throws IOException,FileNotFoundException {
        List<Zbor> l= new ArrayList<>();
        File file= new File("zboruri2.txt");
        l.addAll(deserializareZboruri2(file, 6));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scena7.fxml"));

        root = loader.load();
        ControllerScena5 scene5Controller = (ControllerScena5) loader.getController();
        System.out.println("**"+aPlecare+aSosire);
        scene5Controller.displayDestinatie2(l);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public static void serializareZboruriRezervate(List<ZboruriRezervate> l, File f){
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
    public static List<ZboruriRezervate> deserializareZboruriRezervate(File f, int numar){
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
