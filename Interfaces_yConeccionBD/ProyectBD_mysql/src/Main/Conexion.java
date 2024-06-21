package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class Conexion {
    
    String bd = " proyectobd";
    String url = "jdbc:mysql://localhost:3306/proyectobd";
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
            Conexion conex = new Conexion();
            conex.getConnection();
            
            
        }
        public void insertUserAndPwd (String u, String p){
               this.user = u;
               this.psw = p;
        }
 }

