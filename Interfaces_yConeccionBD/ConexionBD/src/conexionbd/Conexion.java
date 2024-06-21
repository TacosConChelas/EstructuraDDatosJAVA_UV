import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    String bd = "Compras";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String psw = "root";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;
    
        public Connection getConnection(){
            try{
                Class.forName(this.driver);
                con=DriverManager.getConnection(url+bd);
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
    }
