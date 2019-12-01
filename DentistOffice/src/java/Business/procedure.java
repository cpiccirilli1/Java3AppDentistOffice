/**
 * Chelsea Piccirilli
 * procedure b.o.
 * miniproject fall 2019
 */

package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Chelsea
 */
public class procedure {

    /**
     * @return the procCode
     */
    public String getProcCode() {
        return procCode;
    }

    /**
     * @param procCode the procCode to set
     */
    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    /**
     * @return the procName
     */
    public String getProcName() {
        return procName;
    }

    /**
     * @param procName the procName to set
     */
    public void setProcName(String procName) {
        this.procName = procName;
    }

    /**
     * @return the procDesc
     */
    public String getProcDesc() {
        return procDesc;
    }

    /**
     * @param procDesc the procDesc to set
     */
    public void setProcDesc(String procDesc) {
        this.procDesc = procDesc;
    }

    /**
     * @return the cost
     */
    public String getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(String cost) {
        this.cost = cost;
    }
    private String procCode;
    private String procName;
    private String procDesc;
    private String cost;
    
    /**
     * Empty constructor setting all to ""
     */
    public void procedure(){
        this.setProcCode("");
        this.setProcName("");
        this.setProcDesc("");
        this.setCost("");
        
    }
    
    /**
     * Constructor to set every parameter.
     * @param code
     * @param name
     * @param desc
     * @param cost 
     */
    public void procedure(String code, String name, String desc, String cost){
        this.setProcCode(code);
        this.setProcDesc(desc);
        this.setProcName(name);
        this.setCost(cost);
    }
    
    /**
     * Selects database row depending on procCode
     */
    public void selectDB(String code){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
         try{
            String db_path = "C:/Users/Chelsea/Documents/CTC/db/DentistOfficeMDB.mdb";
            System.out.println("Starting DB Connection - procedure.selectDB");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+db_path);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Procedures WHERE procCode='"+code+"'";
            
            System.out.println("Checking the db now - procedures.selectDB");
            
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                
//                for (int i = 1; i < 5; i++){
//                    System.out.println("#"+i+": "+rs.getString(i));
//                }
                
                
                this.setProcCode(rs.getString(1));
                this.setProcName(rs.getString(2));
                this.setProcDesc(rs.getString(3));
                this.setCost(rs.getString(4));
                
            }
            
        }
        catch(Exception e){
           e.printStackTrace();
        }
    
    }
    
    /**
    *Insert a new procedure into the database.
    * code: code id
    * name: name of proc
    * desc: short description
    * cost: cost of proc.
    */
    
        public void insertDB(String code, String name, String desc, String cost){
        
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
                "Values('"+code+"', '" + name +"', '"+desc+"', '"+
                    cost+"')";
            System.out.println("Inserting into the db now - procedures");
            
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
    
     /**
    *Updates a current database entry. Must call: 1st selectDB, 2nd setter method
    *3rd updateDB
    * code: proc code
    */
    public void updateDB(String code){
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
                    "set proccode='"+this.getProcCode()+"', "+
                    "procName='"+this.getProcName()+"', "+
                    "procdesc='"+this.getProcDesc()+"', "+
                    "cost='"+this.getCost()+"' "+                    
                    "WHERE patid='"+code+"'";
                 
            System.out.println("Updating DB now. - Procedures");
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
           String sql = "delete FROM procedures WHERE proccode='" +this.getProcCode()+"'";

           System.out.println("Deleting entry now - Procedures");

            stmt.executeUpdate(sql);
            System.out.println("Deleted Successfully.");

           con.close();

       }
       catch(SQLException e){
           System.out.println(e);
       }
    }
    
    
    
     /*
    *Displays strings in variables.
    */
    public void display(){
        System.out.println("Code: "+this.getProcCode());
        System.out.println("Name: "+this.getProcName());
        System.out.println("Desc: "+this.getProcDesc());
        System.out.println("Cost: "+this.getCost());
        
    }
    
    public static void main(String[] args){
        procedure p = new procedure();
        p.selectDB("P114");
        p.display();
    }
}
