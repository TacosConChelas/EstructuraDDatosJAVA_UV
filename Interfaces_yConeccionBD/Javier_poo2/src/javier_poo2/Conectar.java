package javier_poo2;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conectar {
    String url = "jdbc:mysql://localhost:3306/pruebapooj"; //pruebapooj
    String user = "root";
    String psw = "1234";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;
        public Connection getConnection(){
            try{
                Class.forName(this.driver);
                con = DriverManager.getConnection(url, user, psw);
                System.out.println("Coneccion correcta");
            }catch(Exception e){
                System.out.println("No se conecto: " + e);
            }
            return con;
        }
        public static void main(String[] args) {
            Conectar conex = new Conectar();
            conex.getConnection();
            
            
        }
 }

