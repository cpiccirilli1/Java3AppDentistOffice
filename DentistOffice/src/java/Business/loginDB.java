package Business;

/*
@author: Chelsea
Project Fall 2019
 */


import java.sql.*;


public class loginDB {
    
    private String id;
    private String pwd;
    private String address;
    private String fn;
    private String ln;
    private String email;
    private String ins;

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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return the ins
     */
    public String getIns() {
        return ins;
    }

    /**
     * @param ins the ins to set
     */
    public void setIns(String ins) {
        this.ins = ins;
    }
    
    /*
    *Empty Constructor. Sets everything to ""
    */
    public void loginDB(){
        this.setId("");
        this.setIns("");
        this.setFn("");
        this.setLn("");
        this.setPwd("");
        this.setAddress("");
        this.setEmail("");
    }
    
    /*
    *Constructor to set everything outright.
    */
    public void loginDB(String id, String fn, String ln, String pwd, String add,
            String email, String ins){
        this.setId(id);
        this.setIns(ins);
        this.setFn(fn);
        this.setLn(ln);
        this.setPwd(pwd);
        this.setAddress(add);
        this.setEmail(email);
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
            System.out.println("Starting DB Connection - loginDB.selectDB");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+db_path);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Patients WHERE patId='"+id+"'";
            
            System.out.println("Checking the db now - loginDB.selectDB");
            
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                this.setId(rs.getString(6));
                this.setPwd(rs.getString(7));
                this.setFn(rs.getString(1));
                this.setLn(rs.getString(2));
                this.setAddress(rs.getString(3));
                this.setEmail(rs.getString(4));
                this.setIns(rs.getString(5));
                
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
            String sql = "Update Patients "+ 
                    "set patId='"+this.getId()+"', "+
                    "passwd='"+this.getPwd()+"', "+
                    "firstName='"+this.getFn()+"', "+
                    "lastName='"+this.getLn()+"', "+
                    "addr='"+this.getAddress()+"', "+
                    "email='"+this.getEmail()+"', "+
                    "insCo='"+this.getIns()+"' "+
                    "WHERE patId='"+id+"'";
                 
            System.out.println("Updating DB now.");
            stmt.executeUpdate(sql);
            
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
    
    public void insertDB(String id, String pass, String fn, String ln, String add,
        String email, String ins){
        
        
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
            String sql = "INSERT INTO Patients "+
                "Values('"+fn+"', '" + ln +"', '"+ add +"', '"+email+"', '"+
                    ins+"', '"+id+"', '"+ pass +"')";
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
    *Deletes a database entry. Must call selectDB first.
    */
    public void deleteDB(String id){
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
           String sql = "delete FROM Patients WHERE patID='" +this.getId()+"'";

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
       *Displays the current objects holdings
        */
    public void display(){
        System.out.println("ID: "+ this.getId());
        System.out.println("First Name: " + this.getFn());
        System.out.println("Last Name: "+ this.getLn());
        System.out.println("Address: "+ this.getAddress());
        System.out.println("Email: "+this.getEmail());
        System.out.println("Pwd: "+this.getPwd());
        System.out.println("InsCo: "+this.getIns());
    }
    
    public static void main(String[] args){
        loginDB ldb = new loginDB();
       
        ldb.selectDB("A999");
    }
}
