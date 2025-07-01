package andrespoo2;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConeccionBaseDeDatos {
    String url = "jdbc:mysql://localhost:3306/pruebapooa"; //pruebapooa
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
            ConeccionBaseDeDatos conex = new ConeccionBaseDeDatos();
            conex.getConnection();
            
            
        }
 }

