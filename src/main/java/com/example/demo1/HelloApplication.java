package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * Aceasta clasa are rolul de a controla partea de login/ sign in si primele scene din partea de user
 *
 * @author  Iasmina Lazar
 * @version 1.0
 * @since   2022-11-29
 */
public class HelloApplication extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        /**
         * Acasta metoda lanseaza aplixcatia si da posibilitatea userului
         * sa acceseze meniul de login
         */
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        //Stage stage =new Stage(root);
      //Group root = new Group();
        User x = new User("abcd","1223",123);
        User x2 = new User("gbcd","1223",123);
        User x3 = new User("fbcd","1523",123);
        User x4 = new User("ebcd","1223",123);
        List<User> l= new ArrayList<>();
        l.add(x);
        l.add(x2);
        l.add(x3);
        l.add(x4);
        Zbor z1= new Zbor("Bucuresti","Atena",LocalDate.of(2022,12,8),"12.30",1500);
        Zbor z2= new Zbor("Atena","Bucuresti",LocalDate.of(2022,12,15),"18.30",2000);
        Zbor z3= new Zbor("Bucuresti","Budapesta",LocalDate.of(2022,12,12),"20.30",1000);
        Zbor z4= new Zbor("Budapesta","Bucuresti",LocalDate.of(2022,12,22),"05.30",750);
        Zbor z5= new Zbor("Budapesta","Atena",LocalDate.of(2022,12,26),"14.30",400);
        Zbor z6= new Zbor("Atena","Budapesta",LocalDate.of(2022,12,31),"10.30",600);
        List<Zbor> zboruri= new ArrayList<>();

        zboruri.add(z1);
        zboruri.add(z2);
        zboruri.add(z3);
        zboruri.add(z4);
        zboruri.add(z5);
        zboruri.add(z6);
        List<Zbor1> lz1=new ArrayList<>();
        lz1=deserializareZboruri3();
System.out.println("zzz");
        for(Zbor1 i: lz1){
            System.out.println(i);
        }
        List<User> u=new ArrayList();
        u=deserializare2Useri1();
        for(User i: u){
            System.out.println(i.getId());
        }
        serializareUseri1(u);
        serializareZboruri3(lz1);
        List<String> listaMesaje= new ArrayList<>();
        listaMesaje.add("User : Hi");
        listaMesaje.add("Employee : Hello! How Can i help you?");
        Mesaj m= new Mesaj("abcd","Budapesta Bucuresti 2022-12-22 750",listaMesaje);
        List<Mesaj> LMes= new ArrayList<>();
        LMes.add(m);
        File fis= new File("mesaje.txt");
        File fis2= new File("nrMesaje.txt");
        //serializareMesaje(LMes,fis);


        File fisier = new File("useri.txt");
        File fisier2 = new File("zboruri2.txt");
        //serializareZboruri2(zboruri,fisier2);
        //serializareUseri(l,fisier);
        Scene scene=new Scene(root);
        //primaryStage.setResizable(true);

        //primaryStage.setFullScreen(true);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void serializareUseri(List<User> l, File f){
        /**
         * Aceasta metoda serializeara obiectele de tip user
         *
         */
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
    public static List<User> deserializare2Useri(File f, int numar){
        /**
         * Aceasta metoda deserializeara obiectele de tip user
         *
         */
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
    public static void serializareZboruri2(List<Zbor> l, File f){
        /**
         * Aceasta metoda serializeara obiectele de tip zbor
         *
         */
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
        }/*
        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        var sql= "select * from zbor";
        Zbor1 x= new Zbor1();
        for(Zbor1 x:)
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
    public static void serializareZboruri3(List<Zbor1> l){
        /**
         * Aceasta metoda serializeara obiectele de tip zbor
         *
         *//*
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
        }*/
        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        String sql= "select * from zbor";
        Zbor1 x= new Zbor1();

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                System.out.println(conn.getCatalog());
                Statement statement = conn.createStatement();
                sql="delete from zbor";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.executeUpdate();
                Statement st = conn.createStatement();
                for(Zbor1 i: l) {
                    System.out.println(i);
                    st.executeUpdate("INSERT INTO zbor (idZbor,aeroportPlecare ,aeroportSosire ,dataPlecare,dataSosire,pretZbor,ora,oraSosire,compania ) " + "VALUES ( "+i.getIdZbor()+",'Flinstone', 'hbfe', 'sgd','evg',1000,'134','11','anda')");

                }
                conn.close();
                //ResultSet resultSet = statement.executeQuery(sql);*/
            }catch (Exception e){
                e.printStackTrace();
            }

    }
    public static List<Zbor> deserializareZboruri2(){
        /**
         * Aceasta metoda deserializeara obiectele de tip zbor
         *
         */
        List<Zbor> l= new ArrayList<>();/*
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
        }*/
        Zbor1 x= new Zbor1();



        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        var sql= "select * from zbor";

        try{
            Connection conn= DriverManager.getConnection(url,user,password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()){
                x.setIdZbor(resultSet.getInt(1));
                x.setAeroportPlecare(resultSet.getString(2));
                x.setAeroportSosire(resultSet.getString(3));
                x.setDataPlecare(resultSet.getString(4));
                x.setDataSosire(resultSet.getString(5));
                x.setPret(resultSet.getInt(6));
                x.setOraPlecare(resultSet.getString(7));
                x.setOraSosire(resultSet.getString(8));

               // l.add(x);


            }
            resultSet.close();
            statement.close();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return l;

    }
    public static List<Zbor1> deserializareZboruri3(){
        /**
         * Aceasta metoda deserializeara obiectele de tip zbor
         *
         */
        List<Zbor1> l= new ArrayList<>();
        Zbor1 x= new Zbor1();



        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        var sql= "select * from zbor";

        try{
            Connection conn= DriverManager.getConnection(url,user,password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()){
                x= (Zbor1) createBean(resultSet);
                System.out.println("a");
                System.out.println(x);
                l.add(x);
                System.out.println("sss");
                for(Zbor1 i: l){
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
    public static void serializareUseri1(List<User> l){
        /**
         * Aceasta metoda serializeara obiectele de tip user
         *
         *//*
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
        }*/
        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        String sql= "select * from users";
        Zbor1 x= new Zbor1();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            sql="delete from users";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.executeUpdate();
            Statement st = conn.createStatement();
            for(User i: l) {
                System.out.println(i);
                st.executeUpdate("INSERT INTO users (id,uname,pass ) " + "VALUES ( "+i.getId()+",'"+i.getUsername()+"','"+i.getParola()+"')");

            }
            conn.close();
            //ResultSet resultSet = statement.executeQuery(sql);*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static List<User> deserializare2Useri1(){
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
        List<User> l= new ArrayList<>();
        User x= new User("x","wf",1);



        var url="jdbc:mysql://localhost:3306/proiectpi";
        var user="root";
        var password="" ;
        var sql= "select * from users";

        try{
            Connection conn= DriverManager.getConnection(url,user,password);
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()){
                x= (User) createBeanuseri(resultSet);
                System.out.println("a");
                System.out.println(x);
                l.add(x);
                System.out.println("sss");
                for(User i: l){
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
    public static void serializareMesaje(List<Mesaj> l, File f){
        /**
         * Aceasta metoda serializeara obiectele de tip mesaj
         *
         */
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
        /**
         * Aceasta metoda serializeara obiectele de tip mesaj
         *
         */
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
        public static Object createBean( ResultSet rs ) throws SQLException {
            return new Zbor1( rs.getInt("idZbor"),rs.getString("aeroportPlecare"),rs.getString("aeroportSosire"),rs.getString("dataPlecare"),rs.getString("dataSosire"),rs.getString("ora"),rs.getString("oraSosire"),rs.getInt("pretZbor"),rs.getString("compania"));
        }/*
    public static Object createBeanzr( ResultSet rs ) throws SQLException {
        return new Zbor1( rs.getInt("idZbor"),rs.getString("aeroportPlecare"),rs.getString("aeroportSosire"),rs.getString("dataPlecare"),rs.getString("dataSosire"),rs.getString("ora"),rs.getString("oraSosire"),rs.getInt("pretZbor"),rs.getString("compania"));
    }*/
    public static Object createBeanuseri( ResultSet rs ) throws SQLException {
        return new User( rs.getString("uname"),rs.getString("pass"),rs.getInt("id"));
    }
    }


