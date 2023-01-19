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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControllerDest{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    ImageView imagdest;
    @FXML
    TabPane tabPane;
    @FXML
    Tab tab1;
    @FXML
    Tab tab2;
    @FXML
    Label nume;
   // @FXML
   // Button rezerva;
    @FXML
    ListView<String> reviewuri;
    @FXML
    Label despre;
    @FXML
    BarChart<String,Integer> statistica;
    @FXML private ImageView getImagdest;
    public void displayDestinatie(String x){
        /*abPane=new TabPane();
        tab1=new Tab("General");
        tabPane.getTabs().add(tab1);
        tab1.setClosable(false);*/
        //rezerva=new Button();
        //tab1.setContent(rezerva);
        List<Destinatie> l= new ArrayList<>();
        l=deserializare2Useri1();
        List<Review> l1= new ArrayList<>();
        l1=deserializare2rev1();
        List<String>l2=new ArrayList<>();
        for(Destinatie i: l){
            int r1=0,r2=0,r3=0,r4=0,r5=0;
            if(i.getNume().equals(x)) {
                despre.setText(i.getDescriere());
                nume.setText(i.getNume());
                Image photo;
                photo = new Image("C:\\Users\\Asus\\Desktop\\demo1 - Copy\\src\\main\\resources\\com\\example\\demo1\\"+x+".jpg");
                imagdest.setImage(photo);

                for(Review j: l1) {
                    if(j.getNume().equals(x)) {
                        l2.add(j.getMesaj());
                        if(j.getNrStele()==1) r1=r1+1;
                        if(j.getNrStele()==2) r2=r2+1;
                        if(j.getNrStele()==3) r3=r3+1;
                        if(j.getNrStele()==4) r4=r4+1;
                        if(j.getNrStele()==5) r5=r5+1;
                    }


                }
                reviewuri.getItems().addAll(l2);
                XYChart.Series series1=new XYChart.Series();
                series1.setName("Statistica Satisfactie Destinatie");
                series1.getData().add(new XYChart.Data("1",r1));
                series1.getData().add(new XYChart.Data("2",r2));
                series1.getData().add(new XYChart.Data("3",r3));
                series1.getData().add(new XYChart.Data("4",r4));
                series1.getData().add(new XYChart.Data("5",r5));
                statistica.getData().addAll(series1);
            }


            }
        }




    public void rezervare(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scena2.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static List<Destinatie> deserializare2Useri1(){
        /**
         * Aceasta metoda deserializeara obiectele de tip user
         *
         *//*
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
        return l;*/
        List<Destinatie> l= new ArrayList<>();
        Destinatie x= new Destinatie("Tokyo","Tokyo, cea mai mare suprafata urbana, capitala Japoniei si una dintre cele mai dens populate metropole din lume. Tokyo este situat la 35°41' lat N si 139°46' long E, la jumatatea coastei de est a insulei Honshu, cea mai mare dintre cele patru insule principale din arhipelagul Japoniei.\n" +
                "\n" +
                "Orasul ocupa cea mai mare parte din sudul campiei Kanto, cea mai mare suprafata de teren plat din Japonia. Tokyo este capitala Japoniei din 1868, dupa ce dinastia Tokugawa (1603-1867), care a condus din Kyoto, a fost detronata. Atunci numele orasului a fost schimbat din Edo in Tokyo, ceea ce inseamna 'capitala estica'. Astazi Tokyo este centrul financiar, industrial, comercial, educational si cultural al Japoniei; de asemenea este si principalul punct pentru comert si relatii diplomatice cu restul lumii.",1);



        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        var sql= "select * from destinatii";

        try{
            Connection conn= DriverManager.getConnection(url,user,password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()){
                x= (Destinatie) createDestinatii(resultSet);
                System.out.println("a");
                System.out.println(x);
                l.add(x);
                System.out.println("sss");
                for(Destinatie i: l){
                    System.out.println(i);
                }
            }
            resultSet.close();
            statement.close();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return l;

    }
    public static void serializareUseri1(List<Destinatie> l){
        /**
         * Aceasta metoda serializeara obiectele de tip user
         *
         */
        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        String sql= "select * from destinatii";
        Zbor1 x= new Zbor1();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            sql="delete from destinatii";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.executeUpdate();
            Statement st = conn.createStatement();
            for(Destinatie i: l) {
                System.out.println(i);
                st.executeUpdate("INSERT INTO users (id,nume,mesaj ) " + "VALUES ( "+i.getId()+",'"+i.getNume()+"','"+i.getDescriere()+"')");

            }
            conn.close();
            //ResultSet resultSet = statement.executeQuery(sql);*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Object createDestinatii( ResultSet rs ) throws SQLException {
        return new Destinatie( rs.getString("nume"),rs.getString("Descriere"),rs.getInt("idDestinatie"));
    }
    public void switchtoScenaDestinatie(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ScenaDespreDestinatie.fxml"));
        root = loader.load();
        ControllerDest scene2Controller = loader.getController();
        //scene2Controller.displayDestinatie();
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
    public static List<Review> deserializare2rev1(){
        /**
         * Aceasta metoda deserializeara obiectele de tip user
         *
         *//*
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
        return l;*/
        List<Review> l= new ArrayList<>();
        Review x= new Review();


        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        var sql= "select * from reviewuri";

        try{
            Connection conn= DriverManager.getConnection(url,user,password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()){
                x= (Review) createRev(resultSet);
                System.out.println("a");
                System.out.println(x);
                l.add(x);
                System.out.println("sss");
                for(Review i: l){
                    System.out.println(i);
                }
            }
            resultSet.close();
            statement.close();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return l;

    }
    public static void serializarerev1(List<Review> l){
        /**
         * Aceasta metoda serializeara obiectele de tip user
         *
         */
        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        String sql= "select * from review";
        Zbor1 x= new Zbor1();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            sql="delete from reviewuri";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.executeUpdate();
            Statement st = conn.createStatement();
            for(Review i: l) {
                System.out.println(i);
                st.executeUpdate("INSERT INTO users (id,nume,mesaj,nrStele ) " + "VALUES ( "+i.getIdRev()+"','"+i.getNume()+"','"+i.getMesaj()+"','"+i.getNrStele()+"')");

            }
            conn.close();
            //ResultSet resultSet = statement.executeQuery(sql);*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Object createRev( ResultSet rs ) throws SQLException {
        return new Review( rs.getInt("idRev"),rs.getString("nume"),rs.getString("mesaj"),rs.getInt("nrStele"));
    }

}