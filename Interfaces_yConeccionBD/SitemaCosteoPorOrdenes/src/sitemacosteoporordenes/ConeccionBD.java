package sitemacosteoporordenes;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConeccionBD {
    String url = "jdbc:mysql://localhost:3306/baseconta";
    String user = "root";
    String pwd = "12345";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;
        public Connection getConnection(){
            try{
                Class.forName(this.driver);
                con = DriverManager.getConnection(url, user, pwd);
                System.out.println("Coneccion correctaS");
            }catch(Exception e){
                System.out.println("No se conecto: " + e);
            }
            return con;
        }
        public static void main(String[] args) {
            System.out.println("hola");
            ConeccionBD conex = new ConeccionBD();
            conex.getConnection();
            
            
        }
 }

