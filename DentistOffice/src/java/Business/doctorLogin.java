package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chelsea
 */
public class doctorLogin {
    
    private String id;
    private String pwd;
    private String fn;
    private String ln;
    private String email;
    private String office;
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the fn
     */
    public String getFn() {
        return fn;
    }

    /**
     * @param fn the fn to set
     */
    public void setFn(String fn) {
        this.fn = fn;
    }

    /**
     * @return the ln
     */
    public String getLn() {
        return ln;
    }

    /**
     * @param ln the ln to set
     */
    public void setLn(String ln) {
        this.ln = ln;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(String office) {
        this.office = office;
    }
    
    /*
    *Empty Constructor. sets all variables to ""
    */
    public void doctorLogin(){
        this.setId("");
        this.setFn("");
        this.setLn("");
        this.setEmail("");
        this.setOffice("");
        this.setPwd("");
    }
    
    /*
    *Constructor that takes all params to set fields.
    */
    public void doctorLogin(String id, String fn, String ln, String email, 
            String office, String pwd){
        this.setId(id);
        this.setPwd(pwd);
        this.setFn(fn);
        this.setLn(ln);
        this.setEmail(email);
        this.setOffice(office);
    }
    
     /*
    *Takes the user id and populates the Object through setter methods.
    */
    public void selectDB(String id){
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String db_path = "C:/Users/Chelsea/Documents/CTC/db/DentistOfficeMDB.mdb";
            System.out.println("Starting DB Connection - doctorLogin.selectDB");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+db_path);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Dentists WHERE id='"+id+"'";
            
            System.out.println("Checking the db now - doctorLogin.selectDB");
            
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                /*for (int i = 1; i < 7; i++){
                    System.out.println("#"+i+": "+rs.getString(i));
                }
                */
                
                this.setFn(rs.getString(1));
                this.setLn(rs.getString(2));
                this.setEmail(rs.getString(3));
                this.setId(rs.getString(4));
                this.setPwd(rs.getString(5));
                this.setOffice(rs.getString(6));
                
            }
            
        }
        catch(Exception e){
           e.printStackTrace();
        }
        
    }
    
    
    /*
    *Updates a current database entry. Must call: 1st selectDB, 2nd setter method
    *3rd updateDB
    */
    public void updateDB(String id){
        /*
        *This requires a selectDB() to be called first
        */
         try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/DentistOfficeMDB.mdb";
            System.out.println("Starting DB Connection");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "Update Dentists "+ 
                    "set id='"+this.getId()+"', "+
                    "passwd='"+this.getPwd()+"', "+
                    "firstName='"+this.getFn()+"', "+
                    "lastName='"+this.getLn()+"', "+
                    "office='"+this.getOffice()+"', "+
                    "email='"+this.getEmail()+"' "+
                    
                    "WHERE id='"+id+"'";
                 
            System.out.println("Updating DB now.");
            stmt.executeUpdate(sql);
            
            con.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    /*
    *Deletes a database entry. Must call selectDB first.
    */
    public void deleteDB(){
    /*
    *This requires a selectDB() to be called first.
    */
        try{
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       }
       catch(ClassNotFoundException e){
           e.printStackTrace();
       }

       try{
           String dbPath = "C:/Users/Chelsea/Documents/CTC/db/DentistOfficeMDB.mdb";
           System.out.println("Starting DB Connection");
           Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
           Statement stmt = con.createStatement();
           String sql = "delete FROM Dentists WHERE ID='" +this.getId()+"'";

           System.out.println("Deleting entry now");

            stmt.executeUpdate(sql);
            System.out.println("Deleted Successfully.");

           con.close();

       }
       catch(SQLException e){
           System.out.println(e);
       }
    }
    
     /*
    *Insert a new entry into the Patient Database
    *Provide id, pass, fn, ln, address, email, ins
    */
    
    public void insertDB(String id, String pwd, String fn, String ln, String office,
        String email){
        
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/DentistOfficeMDB.mdb";
            System.out.println("Starting DB Connection");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO Dentists "+
                "Values('"+fn+"', '" + ln +"', '"+email+"', '"+
                    id+"', '" + pwd + "', '"+ office +"')";
            System.out.println("Inserting into the db now");
            
            stmt.executeUpdate(sql);
            con.close();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    /*
    *Displays all variable data in console.
    */
    public void display(){
        System.out.println("ID: "+this.getId());
        System.out.println("First Name: "+this.getFn());
        System.out.println("Last Name: "+this.getLn());
        System.out.println("Email: "+this.getEmail());
        System.out.println("Pwd: "+this.getPwd());
        System.out.println("Office#: "+this.getOffice());
    
    }
    

    public static void main(String[] args){
        doctorLogin ldb = new doctorLogin();
    
        ldb.selectDB("D201");
//        ldb.setFn("Francesca");
//        ldb.updateDB("D201");
        ldb.display();
    }
}
