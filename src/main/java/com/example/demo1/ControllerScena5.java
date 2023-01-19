package com.example.demo1;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class ControllerScena5 {
    @FXML
    TextField textFieldDest;
    @FXML
    Label zboruriDus;
    @FXML
    TextField textFieldIdZbor;
    @FXML
    Label textIdZborDus;
    @FXML
    Label textIdZborIntors;
    @FXML
    TextField idZborDus;
    @FXML
    TextField idZborIntors;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void displayDestinatie(List<Zbor> l) throws Exception{
        /**
         * Aceasta metoda incarca informatiile necesare
         *
         */
        int nr=1;
        File myObj= new File("fisierDestinatie.txt");
        Scanner myReader= new Scanner(myObj);
        File myObj2= new File("fisierSosire.txt");
        Scanner myReader2= new Scanner(myObj2);
        File myObj3= new File("fisierDataPlecare.txt");
        Scanner myReader3= new Scanner(myObj3);
        File myObj4= new File("fisierdataSosire.txt");
        Scanner myReader4= new Scanner(myObj4);
        String aPlecare1="jhsa",aSosire1="hbc";
        LocalDate dPlecare1=LocalDate.parse("2022-04-08"),dSosire1=LocalDate.parse("2022-04-08");
        while(myReader.hasNextLine()){
            aPlecare1=myReader.nextLine();

        }
        while(myReader2.hasNextLine()){
            aSosire1=myReader2.nextLine();
        }
        while(myReader3.hasNextLine()){
            dPlecare1=LocalDate.parse(myReader3.nextLine());        }
        while(myReader4.hasNextLine()) {
            dSosire1=LocalDate.parse(myReader4.nextLine());

        }
        for(Zbor i: l) {
            //System.out.println(i.getaPlecare()+aPlecare1+i.getaSosire()+aSosire1);
            if (i.getaPlecare().equals(aPlecare1) && i.getaSosire().equals(aSosire1) && i.getDataPlecare().isEqual(dPlecare1) ) {
                zboruriDus.setText(zboruriDus.getText() + "\n" + nr + ". " + i.getaPlecare() + " " + i.getaSosire() + " " + i.getDataPlecare() + " " + i.getOraZbor() + " " + i.getPretZbor() + " lei");
                nr++;
            }
        }
    }
    public void displayDestinatie2(List<Zbor> l) throws IOException,FileNotFoundException{
        /**
         * Aceasta metoda incarca informatiile necesare
         *
         */
        int nr=1;
        File myObj= new File("fisierDestinatie.txt");
        Scanner myReader= new Scanner(myObj);
        File myObj2= new File("fisierSosire.txt");
        Scanner myReader2= new Scanner(myObj2);
        File myObj3= new File("fisierDataPlecare.txt");
        Scanner myReader3= new Scanner(myObj3);
        File myObj4= new File("fisierdataSosire.txt");
        Scanner myReader4= new Scanner(myObj4);
        String aPlecare1="jhsa",aSosire1="hbc";
        LocalDate dPlecare1=LocalDate.parse("2022-04-08"),dSosire1=LocalDate.parse("2022-04-08");
        while(myReader.hasNextLine()){
            aPlecare1=myReader.nextLine();

        }
        while(myReader2.hasNextLine()){
            aSosire1=myReader2.nextLine();
        }
        while(myReader3.hasNextLine()){
            dPlecare1=LocalDate.parse(myReader3.nextLine());        }
        while(myReader4.hasNextLine()) {
            dSosire1=LocalDate.parse(myReader4.nextLine());

        }

        for(Zbor i: l) {
            System.out.println(i.getaPlecare()+aPlecare1+i.getaSosire()+aSosire1+i.getDataPlecare()+dSosire1);
            System.out.println(i.getaPlecare()+aPlecare1+i.getaSosire()+aSosire1);
            if (i.getaPlecare().equals(aPlecare1) && i.getaSosire().equals(aSosire1) && i.getDataPlecare().isEqual(dPlecare1) ) {
                textIdZborDus.setText(idZborDus.getText() + "\n" + nr + ". " + i.getaPlecare() + " " + i.getaSosire() + " " + i.getDataPlecare() + " " + i.getOraZbor() + " " + i.getPretZbor() + " lei");
                nr++;
            }
        }
        System.out.println();
        nr=1;
        for(Zbor i: l) {
            System.out.println(i.getaPlecare()+aPlecare1+i.getaSosire()+aSosire1+i.getDataPlecare()+dSosire1);
            if (i.getaPlecare().equals(aSosire1) && i.getaSosire().equals(aPlecare1) && i.getDataPlecare().isEqual(dSosire1) ) {
                textIdZborIntors.setText(idZborIntors.getText() + "\n" + nr + ". " + i.getaPlecare() + " " + i.getaSosire() + " " + i.getDataPlecare() + " " + i.getOraZbor() + " " + i.getPretZbor() + " lei");
                nr++;
            }
        }

    }
    public void getZborDus(ActionEvent e) throws Exception{
        /**
         * Aceasta metoda doar zbor dus
         *
         *
         */
        String aPlecare1="jhsa",aSosire1="hbc";
        LocalDate dPlecare1=LocalDate.parse("2022-04-08"),dSosire1=LocalDate.parse("2022-04-08");
        File myObj= new File("fisierDestinatie.txt");
        Scanner myReader= new Scanner(myObj);
        File myObj2= new File("fisierSosire.txt");
        Scanner myReader2= new Scanner(myObj2);
        File myObj3= new File("fisierDataPlecare.txt");
        Scanner myReader3= new Scanner(myObj3);
        File myObj4= new File("fisierdataSosire.txt");

        Scanner myReader4= new Scanner(myObj4);
        while(myReader.hasNextLine()){
            aPlecare1=myReader.nextLine();

        }
        while(myReader2.hasNextLine()){
            aSosire1=myReader2.nextLine();
        }
        while(myReader3.hasNextLine()){
            dPlecare1=LocalDate.parse(myReader3.nextLine());        }
        while(myReader4.hasNextLine()) {
            dSosire1=LocalDate.parse(myReader4.nextLine());

        }
        String id= textFieldIdZbor.getText();
        List<Zbor> l= new ArrayList<>();
        File file= new File("zboruri2.txt");
        l.addAll(deserializareZboruri2(file, 6));
        int nr=1;
        List<ZboruriRezervate> lista=new ArrayList<>();
        File fisierul=new File("zboruriRezervate.txt");
        String nrul="";
        File myObj7= new File("nrZboruri.txt");
        Scanner myReader7= new Scanner(myObj7);
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        lista.addAll(deserializareZboruriRezervate2(fisierul,Integer.parseInt(nrul)));
        File myObj6= new File("userPass.txt");
        Scanner myReader6= new Scanner(myObj6);
        File myObj8= new File("uPass.txt");
        Scanner myReader8= new Scanner(myObj8);
        String uname1,pass1;
        uname1="user";
        pass1="1234";
        while(myReader6.hasNextLine()){
            uname1=myReader6.nextLine();

        }
        while(myReader8.hasNextLine()){
            pass1=myReader8.nextLine();

        }
        int nr1=1;
        for(Zbor i: l) {
            //System.out.println(aPlecare1+aSosire1+dPlecare1);
            //System.out.println(i.getaPlecare()+i.getaSosire()+i.getDataPlecare());
            if (i.getaPlecare().equals(aPlecare1) && i.getaSosire().equals(aSosire1) && i.getDataPlecare().isEqual(dPlecare1) ){
                //System.out.println("Y1YYYY"+lista);
                System.out.println(id+" "+String.valueOf(nr1));
                if(String.valueOf(nr1).equals(id)) {
                    ZboruriRezervate z = new ZboruriRezervate(uname1, i.getaPlecare(), i.getaSosire(), i.getDataPlecare(), i.getOraZbor(), i.getPretZbor());
                    lista.add(z);
                    nrul=String.valueOf(Integer.parseInt(nrul)+1);
                    // System.out.println("YY2YYY"+lista);

                }
                nr1++;
            }

        }System.out.println("$$$$");
        for(ZboruriRezervate i: lista){
            System.out.println(i);
        }
        System.out.println("$$$");
        serializareZboruriRezervate2(lista, fisierul);
        FileWriter myWriter= new FileWriter("nrZboruri.txt");
        myWriter.write(nrul);
        myWriter.close();
        root = FXMLLoader.load(getClass().getResource("Scena8.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void getZborDusIntors(ActionEvent e) throws Exception{
        /**
         * Aceasta metoda rezerva zbor dus intors
         *
         */
        String aPlecare1="jhsa",aSosire1="hbc";
        LocalDate dPlecare1=LocalDate.parse("2022-04-08"),dSosire1=LocalDate.parse("2022-04-08");
        File myObj= new File("fisierDestinatie.txt");
        Scanner myReader= new Scanner(myObj);
        File myObj2= new File("fisierSosire.txt");
        Scanner myReader2= new Scanner(myObj2);
        File myObj3= new File("fisierDataPlecare.txt");
        Scanner myReader3= new Scanner(myObj3);
        File myObj4= new File("fisierdataSosire.txt");

        Scanner myReader4= new Scanner(myObj4);
        while(myReader.hasNextLine()){
            aPlecare1=myReader.nextLine();

        }
        while(myReader2.hasNextLine()){
            aSosire1=myReader2.nextLine();
        }
        while(myReader3.hasNextLine()){
            dPlecare1=LocalDate.parse(myReader3.nextLine());        }
        while(myReader4.hasNextLine()) {
            dSosire1=LocalDate.parse(myReader4.nextLine());

        }

        String id= idZborDus.getText();
        String id2=idZborIntors.getText();
        List<Zbor> l= new ArrayList<>();
        File file= new File("zboruri2.txt");
        l.addAll(deserializareZboruri2(file, 6));
        int nr=1;
        String nrul="";
        File myObj7= new File("nrZboruri.txt");
        Scanner myReader7= new Scanner(myObj7);
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        List<ZboruriRezervate> lista=new ArrayList<>();
        File fisierul=new File("zboruriRezervate.txt");

        lista.addAll(deserializareZboruriRezervate2(fisierul,Integer.parseInt(nrul)));
        File myObj5= new File("userPass.txt");
        Scanner myReader5= new Scanner(myObj5);
        File myObj6 = new File("uPass.txt");
        Scanner myReader6= new Scanner(myObj6);
        String uname1,pass1;
        uname1="user";
        pass1="1234";

        while(myReader5.hasNextLine()){
            uname1=myReader5.nextLine();

        }
        while(myReader6.hasNextLine()){
            pass1=myReader6.nextLine();

        }
        System.out.println("****");
        for(ZboruriRezervate i: lista){
            System.out.println(i);
        }
        System.out.println("****");
        ZboruriRezervate zb=new ZboruriRezervate("acvc","asc","asv",LocalDate.of(2022,12,8),"12:00",2000);
        int nr1=1,nr2=1;
        for(Zbor i: l) {
            System.out.println(aPlecare1+aSosire1+dPlecare1);
            System.out.println(i.getaPlecare()+i.getaSosire()+i.getDataPlecare());
            if (i.getaPlecare().equals(aPlecare1) && i.getaSosire().equals(aSosire1) && i.getDataPlecare().isEqual(dPlecare1) ){
                //System.out.println("Y1YYYY"+lista);
                System.out.println(id+" "+String.valueOf(nr1));
                if(String.valueOf(nr1).equals(id)) {
                    ZboruriRezervate z = new ZboruriRezervate(uname1, i.getaPlecare(), i.getaSosire(), i.getDataPlecare(), i.getOraZbor(), i.getPretZbor());
                    lista.add(z);
                    zb=z;
                    nrul=String.valueOf(Integer.parseInt(nrul)+1);
                   // System.out.println("YY2YYY"+lista);

                }
                nr1++;
            }

        }
        String file_name="C:\\Users\\Asus\\Desktop\\Pdf-uri exportate\\"+zb.getUser()+zb.getaSosire()+".pdf";
        Document doc=new Document();
        PdfWriter c= PdfWriter.getInstance(doc,new FileOutputStream(file_name));
        doc.open();
        Paragraph para=new Paragraph("NumeClient : "+zb.getUser()+"\n");
        doc.add(para);
        para=new Paragraph("Aeroport plecare : "+zb.getaPlecare()+"\n");
        doc.add(para);
        para=new Paragraph("Aeroport sosire : "+zb.getaSosire()+"\n");
        doc.add(para);
        para=new Paragraph("Data Plecare : "+zb.getDataPlecare()+"\n");
        doc.add(para);
        para=new Paragraph("Ora Sosire : "+zb.getOraZbor()+"\n");
        doc.add(para);
        para=new Paragraph("Pret Zbor :"+zb.getPretZbor()+"\n");
        //doc.add(Image.getInstance("C:\\Users\\Asus\\Desktop\\demo1 - Copy\\src\\main\\resources\\com\\example\\demo1\\"+zb.getaSosire()+".jpg"));
        para=new Paragraph("\n\n\n");
        doc.add(para);
        Random x=new Random();
        int y=x.nextInt(100);
        String myString="zb.getUser()+zb.getDataPlecare()+zb.getUser()";
        Barcode128 code128=new Barcode128();
        code128.setCode(myString.trim());
        code128.setCodeType(Barcode128.CODE128);
        PdfContentByte cb=c.getDirectContent();
        Image code128Image=code128.createImageWithBarcode(cb,null,null);
        doc.add(code128Image);
        //doc.add(Image.getInstance("C:\\Users\\Asus\\Desktop\\demo1 - Copy\\src\\main\\resources\\com\\example\\demo1\\qr"+y%3+".jpg"));
        doc.close();
        for(Zbor i: l) {
            //System.out.println("YYYYY"+lista);
            if (i.getaPlecare().equals(aSosire1) && i.getaSosire().equals(aPlecare1) && i.getDataPlecare().isEqual(dSosire1) ){
                if(String.valueOf(nr2).equals(id2)) {
                    ZboruriRezervate z = new ZboruriRezervate(uname1, i.getaPlecare(), i.getaSosire(), i.getDataPlecare(), i.getOraZbor(), i.getPretZbor());
                    lista.add(z);
                    nrul=String.valueOf(Integer.parseInt(nrul)+1);
                    zb=z;
                   // System.out.println("XXX2XXX"+lista);

                }
                nr2++;

            }

        }
        FileWriter myWriter= new FileWriter("nrZboruri.txt");
        myWriter.write(nrul);
        myWriter.close();
        File f = new File("zboruriRezervate.txt");
        System.out.println("****");
        for(ZboruriRezervate i: lista){
            System.out.println(i);
        }
        System.out.println("****");
        serializareZboruriRezervate2(lista, f);
        file_name="C:\\Users\\Asus\\Desktop\\Pdf-uri exportate\\"+zb.getUser()+zb.getaSosire()+".pdf";
        doc=new Document();
         c=PdfWriter.getInstance(doc,new FileOutputStream(file_name));
        doc.open();
         para=new Paragraph("NumeClient : "+zb.getUser()+"\n");
        doc.add(para);
        para=new Paragraph("Aeroport plecare : "+zb.getaPlecare()+"\n");
        doc.add(para);
        para=new Paragraph("Aeroport sosire : "+zb.getaSosire()+"\n");
        doc.add(para);
        para=new Paragraph("Data Plecare : "+zb.getDataPlecare()+"\n");
        doc.add(para);
        para=new Paragraph("Ora Sosire : "+zb.getOraZbor()+"\n");
        doc.add(para);
        para=new Paragraph("Pret Zbor :"+zb.getPretZbor()+"\n");
        //doc.add(Image.getInstance("C:\\Users\\Asus\\Desktop\\demo1 - Copy\\src\\main\\resources\\com\\example\\demo1\\"+zb.getaSosire()+".jpg"));
        para=new Paragraph("\n\n\n");
        doc.add(para);
        //Random x=new Random();
        int zz=x.nextInt(100);
         myString=zb.getUser()+zb.getDataPlecare()+zb.getUser();
         code128=new Barcode128();
        code128.setCode(myString.trim());
        code128.setCodeType(Barcode128.CODE128);
         cb=c.getDirectContent();
         code128Image=code128.createImageWithBarcode(cb,null,null);
        doc.add(code128Image);
        //doc.add(Image.getInstance("C:\\Users\\Asus\\Desktop\\demo1 - Copy\\src\\main\\resources\\com\\example\\demo1\\qr"+zz%3+".jpg"));
        doc.close();

        root = FXMLLoader.load(getClass().getResource("Scena8.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();



    }
    public void cautareRevDest(){
        String Dest=textFieldDest.getText();



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
    public void switchtoScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

