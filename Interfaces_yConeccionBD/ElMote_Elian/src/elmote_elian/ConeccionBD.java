package elmote_elian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class ConeccionBD {
    
    String bd = "elmote";
    String url = "jdbc:mysql://localhost:3306/elmote";
    String user = "root";
    String psw = "12345";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;
    
    
    
        public Connection getConnection(){
            try{
                Class.forName(this.driver);
                con= DriverManager.getConnection(url, user, psw);
                System.out.println("Se conecto a la bd: " + this.bd);
            }catch(Exception e){
                System.out.println("No se conecto: " + e);
            }
            return con;
        }
        public static void main(String[] args) {
            ConeccionBD conex = new ConeccionBD();
            conex.getConnection();
            
            
        }
 }

