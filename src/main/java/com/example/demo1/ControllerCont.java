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
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public  class ControllerCont implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    String ZborSelectat;
    @FXML
    Label listaZboruri;
    @FXML
    Label nume;
    @FXML
    private ListView<String> listViewCont;
    @FXML
    Label zborSelectat;

    public void initialize(URL arg0, ResourceBundle arg1) {
        /**
         * Aceasta metoda trimite userul spre pagina unde isi poate vizualiza detaliile contului
         *
         */
        try {
            List<ZboruriRezervate> l = new ArrayList<>();
            File file = new File("zboruriRezervate.txt");
            String nrul = "";
            File myObj7 = new File("nrZboruri.txt");
            Scanner myReader7 = new Scanner(myObj7);
            while (myReader7.hasNextLine()) {
                nrul = myReader7.nextLine();

            }
            l.addAll(deserializareZboruriRezervate2(file, Integer.parseInt(nrul)));
            List<Zbor> l1= new ArrayList<>();
            List<String> l2=new ArrayList<>();
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
            Zbor x=new Zbor("Bu","jh", LocalDate.of(2022,12,26),"14.30",400);
            for(ZboruriRezervate i: l){
                if(i.getUser().equals(uname1)){
                    x.setaPlecare(i.getaPlecare());
                    x.setaSosire(i.getaSosire());
                    x.setDataPlecare(i.getDataPlecare());
                    x.setPretZbor(i.getPretZbor());
                    l1.add(x);
                    l2.add(afisare(x));
                }
            }
            //String[] food={"Pizza","Soarec","Ramen"};
            listViewCont.getItems().addAll(l2);

            listViewCont.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    ZborSelectat=listViewCont.getSelectionModel().getSelectedItem();
                    zborSelectat.setText(ZborSelectat);
                }
            });

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }
    public void switchtoDetaliiCont(ActionEvent event) throws IOException {
        /**
         * Aceasta metoda permite userului si vada detaliile despre fiecare zbor pe care l-a rezervat
         *
         */
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScenaZbor.fxml"));
        root = loader.load();
        ControllerDetaliiZbor scene2Controller = loader.getController();
        scene2Controller.displayZbor(ZborSelectat);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void displayDestinatie() throws  FileNotFoundException{
        /**
         * Aceasta metoda afiseaza toate zborurile rezervate de un user
         *
         */
        List<ZboruriRezervate> l=new ArrayList<>();
        File file=new File("zboruriRezervate.txt");
        String nrul="";
        File myObj7= new File("nrZboruri.txt");
        Scanner myReader7= new Scanner(myObj7);
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        l.addAll(deserializareZboruriRezervate2(file,Integer.parseInt(nrul)));
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

        for(ZboruriRezervate i : l){
            if(i.getUser().equals(uname1)){
                listaZboruri.setText(listaZboruri.getText()+"\n"+i.getaPlecare()+" "+i.getaSosire()+" "+i.getDataPlecare());
            }
        }

    }
    public void nume() throws FileNotFoundException{
        /**
         * Aceasta metoda afiseaza username
         *
         */
        File myObj= new File("userPass.txt");
        Scanner myReader= new Scanner(myObj);
        String uname1;
        uname1="user";
        while(myReader.hasNextLine()){
            uname1=myReader.nextLine();
            System.out.println("Soricel + "+ uname1);

        }
        nume.setText(nume.getText()+uname1);
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
    public void switchtoScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public String afisare(Zbor x){
        return x.getaPlecare()+" "+x.getaSosire()+" "+x.getDataPlecare()+" "+x.getPretZbor();
    }
}
