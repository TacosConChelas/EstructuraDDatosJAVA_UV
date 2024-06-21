package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String url = "jdbc:mysql://localhost:3306/contaemma";
    String user = "root"; 
    String psw = "12345";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;

    public Connection getConnection(){
        try{
            Class.forName(this.driver);
            con = DriverManager.getConnection(url, user, psw);
            System.out.println("correcto");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar: " + e);
        }
        return con;
    }
    public static void main(String[] args) {
        Conexion conex = new Conexion();
        conex.getConnection();
        System.out.println("todo bien");
    }
 }

