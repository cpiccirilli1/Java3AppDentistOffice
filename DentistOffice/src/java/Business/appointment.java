/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Chelsea
 */
public class appointment {

    /**
     * @return the appt
     */
    public String getAppt() {
        return appt;
    }

    /**
     * @param appt the appt to set
     */
    public void setAppt(String appt) {
        this.appt = appt;
    }

    /**
     * @return the pat
     */
    public String getPat() {
        return pat;
    }

    /**
     * @param pat the pat to set
     */
    public void setPat(String pat) {
        this.pat = pat;
    }

    /**
     * @return the dent
     */
    public String getDent() {
        return dent;
    }

    /**
     * @param dent the dent to set
     */
    public void setDent(String dent) {
        this.dent = dent;
    }

    /**
     * @return the proc
     */
    public String getProc() {
        return proc;
    }

    /**
     * @param proc the proc to set
     */
    public void setProc(String proc) {
        this.proc = proc;
    }
    
    /*
    *Returns appointment arraylist
    */
    public ArrayList getApptList(){
        return this.ap;
    }
    
    /*
    *Blank constructor, sets every variable as ""
    */
    public void appointment(){
        this.setAppt("");
        this.setPat("");
        this.setDent("");
        this.setProc("");
    }
    
    /*
    *Constructor that sets all variables at once
    */
    public void appointment( String appt, String pat, String dent, String proc){
        this.setAppt(appt);
        this.setPat(pat);
        this.setDent(dent);
        this.setProc(proc);
    }
    
    private String appt;
    private String pat;
    private String dent;
    private String proc;
    public ArrayList<appointment> ap = new ArrayList<appointment>();
    
    /*
    *Select statement to the appointments database. Needs patient id (patid)
    */   
    public void selectDB(String pat){
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
         try{
            String db_path = "C:/Users/Chelsea/Documents/CTC/db/DentistOfficeMDB.mdb";
            System.out.println("Starting DB Connection - appointment.selectDB");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+db_path);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Appointments WHERE patId='"+pat+"'";
            
            System.out.println("Checking the db now - appointment.selectDB");
            
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                /*
                for (int i = 1; i < 5; i++){
                    System.out.println("#"+i+": "+rs.getString(i));
                }
                */
                
                this.setAppt(rs.getString(1));
                this.setProc(rs.getString(2));
                this.setPat(rs.getString(3));
                this.setDent(rs.getString(4));
                
            }
            
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }
    
    /*
    * Insert an appointment into the database
    */
    public void insertDB(String pat, String dent, String appt, String proc){
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/DentistOfficeMDB.mdb";
            System.out.println("Starting DB Connection - Appointment.insertDB");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO appointments "+
                "Values('"+appt+"', '" + proc +"', '"+pat+"', '"+
                    dent+"')";
            System.out.println("Inserting into the db now - appointments");
            
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
    *Updates a current database entry. Must call: 1st selectDB, 2nd setter method
    *3rd updateDB
    */
    public void updateDB(String pat){
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
            String sql = "Update appointments "+ 
                    "set patid='"+this.getPat()+"', "+
                    "apptdatetime='"+this.getAppt()+"', "+
                    "procCode='"+this.getProc()+"', "+
                    "dentid='"+this.getDent()+"' "+                    
                    "WHERE patid='"+pat+"'";
                 
            System.out.println("Updating DB now. - Appointment");
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
           String sql = "delete FROM appointments WHERE patID='" +this.getPat()+"'";

           System.out.println("Deleting entry now - appointments");

            stmt.executeUpdate(sql);
            System.out.println("Deleted Successfully.");

           con.close();

       }
       catch(SQLException e){
           System.out.println(e);
       }
    }
    
    /*
    *Selects all appointments for a specific dentist.
    */
    public void selectAppts(String dent){
        
      try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
         try{
            String db_path = "C:/Users/Chelsea/Documents/CTC/db/DentistOfficeMDB.mdb";
            System.out.println("Starting DB Connection - appointment.selectDB");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+db_path);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Appointments WHERE dentid='"+dent+"'";
            
            System.out.println("Checking the db now - appointment.selectDB");
            
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            // String appt, String pat, String dent, String proc
            while(rs.next()){
                
                this.setAppt(rs.getString(1));
                this.setProc(rs.getString(2));
                this.setPat(rs.getString(3));
                this.setDent(rs.getString(4));
                
                appointment a1 = new appointment();
                a1.appointment(this.getAppt(), this.getPat(), this.getDent(),
                        this.getProc());
                a1.display();
                ap.add(a1);
                
            }
            
        }
        catch(Exception e){
           e.printStackTrace();
        }
        
    }
    
    
    /*
    *Displays strings in variables.
    */
    public void display(){
        System.out.println("ID: "+this.getPat());
        System.out.println("Appt: "+this.getAppt());
        System.out.println("Proc: "+this.getProc());
        System.out.println("Dentist: "+this.getDent());
        
    }
    
    public static void main(String[] args){
        appointment a = new appointment();
        a.selectAppts("D201");
    }
    
}
