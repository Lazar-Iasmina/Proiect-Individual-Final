package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class HelloController {

    @FXML
    TextField numeDestinatie;
    @FXML
    TextField aeroportSosire;
    @FXML
    DatePicker dataPlecare;
    @FXML
    DatePicker dataSosire;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchtoScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoScene2(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Scena2.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoScene3(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Scena3.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchCont(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Cont.fxml"));
        root = loader.load();
        ControllerCont scene2Controller = loader.getController();
        scene2Controller.displayDestinatie();
        scene2Controller.nume();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoLogIn(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoSignIn(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void cautare(ActionEvent e) throws IOException{
        //root = FXMLLoader.load(getClass().getResource("Scena2.fxml"));
        String destinatie = numeDestinatie.getText();
        String aeroportSosire1 = aeroportSosire.getText();
        LocalDate dataPlecare1 = dataPlecare.getValue();
        LocalDate dataSosire1 = dataSosire.getValue();
        System.out.println(destinatie+ aeroportSosire1+dataPlecare1+dataSosire1);
        if(destinatie.equals("") || aeroportSosire1.equals("") || dataSosire1==null || dataPlecare1==null){
            root = FXMLLoader.load(getClass().getResource("Scena2.fxml"));
            //cautare(e);
        }
        else {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scena4.fxml"));
            root = loader.load();
            ControllerScena2 scene2Controller = loader.getController();
            scene2Controller.displayDestinatie(destinatie, aeroportSosire1, dataPlecare1, dataSosire1);
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
   // public
    @FXML
    TextField username;
    @FXML
    TextField parola;
    public void login(ActionEvent e) throws IOException,FileNotFoundException{
       String uname = username.getText();
       String pass =parola.getText();
       System.out.println(uname+" "+pass);
       if(uname.equals("Admin") && pass.equals("1234")){
           root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
           stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
           FileWriter myWriter = new FileWriter("userPass.txt");
           myWriter.write(uname);
           myWriter.close();
           FileWriter myWriter2 = new FileWriter("uPass.txt");
           myWriter2.write(pass);
           myWriter2.close();
       }
       else {
           List<User> l = new ArrayList<>();
           File fisier = new File("useri.txt");
           File myObj7 = new File("numarUseri.txt");
           Scanner myReader7 = new Scanner(myObj7);
           while (myReader7.hasNextLine()) {
               nrul = myReader7.nextLine();
           }

           l.addAll(deserializareUseri(fisier, Integer.parseInt(nrul)));
           for (User i : l) {
               System.out.println(i.getUsername());
           }
           System.out.println(l);
           int ok = 0;
           for (User i : l) {
               if (i.getUsername().equals(uname)) {
                   if (i.getParola().equals(pass)) {
                       ok = 1;
                   }
               }
           }
           if (ok == 1) {
               try {
                   root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                   stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                   scene = new Scene(root);
                   stage.setScene(scene);
                   stage.show();
                   FileWriter myWriter = new FileWriter("userPass.txt");
                   myWriter.write(uname);
                   myWriter.close();
                   FileWriter myWriter2 = new FileWriter("uPass.txt");
                   myWriter2.write(pass);
                   myWriter2.close();
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           } else {
               try {
                   root = FXMLLoader.load(getClass().getResource("login.fxml"));
                   stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                   scene = new Scene(root);
                   stage.setScene(scene);
                   stage.show();
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           }
       }
    }
    @FXML
    TextField newUsername;
    @FXML
    TextField newPass;
    @FXML
    TextField confPass;
    String usernameul;
    String nrul="";
    public void signin(ActionEvent e) throws IOException,FileNotFoundException{
        String username= newUsername.getText();
        String pass=newPass.getText();
        String conPass=confPass.getText();
        if(pass.equals(conPass)){
            List<User>l =new ArrayList<>();
            File fisier=new File("useri.txt");
            File myObj7= new File("numarUseri.txt");
            Scanner myReader7= new Scanner(myObj7);
            while(myReader7.hasNextLine()){
                nrul=myReader7.nextLine();
            }

            l.addAll(deserializareUseri(fisier,Integer.parseInt(nrul)));
            User u=new User(username,pass,2000);
            l.add(u);
            for(User i: l){
                System.out.println(i.getUsername());
            }
            System.out.println(nrul);
            nrul=String.valueOf(Integer.parseInt(nrul)+1);
            System.out.println(nrul);
            FileWriter myWriter= new FileWriter("numarUseri.txt");
            myWriter.write(nrul);
            myWriter.close();
            serializareUseri(l,fisier);
            try {
                FileWriter myWriter1= new FileWriter("userPass.txt");
                myWriter1.write(username);
                myWriter1.close();
                FileWriter myWriter2= new FileWriter("uPass.txt");
                myWriter2.write(pass);
                myWriter2.close();
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
        else{
            try {
                root = FXMLLoader.load(getClass().getResource("signin.fxml"));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void serializareUseri(List<User> l, File f){
        try{
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            for(User i: l){
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<User> deserializareUseri(File f, int numar){
        List<User> l= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<numar;i++){
                l.add((User) ois.readObject());
            }
            ois.close();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }
    public void switchtoModifZboruri(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminModifZboruri.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoAdaugareZbor(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdaugareZbor.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoStergereZbor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StergereZbor.fxml"));
        root = loader.load();
        ControllerStergereZbor scene2Controller = loader.getController();
        scene2Controller.displayZboruri();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoMeniuChatAdmin(ActionEvent event) throws IOException {/*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MeniuChatAdmin.fxml"));
        root = loader.load();
        ControllerChatAdmin scene2Controller = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
        root = FXMLLoader.load(getClass().getResource("MeniuChatAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoDestinatiiVacanta(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScenaDestinatiiVacanta.fxml"));
        root = loader.load();
        ControllerdestinatiiVacanta scene2Controller = loader.getController();
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
    public void switchtoScenaReview(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScenaReview.fxml"));
        root = loader.load();
        ControllerScenaReview scene2Controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void serializareZboruri(List<Zbor> l, File f){
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
    public static List<Zbor> deserializareZboruri(File f, int numar){
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