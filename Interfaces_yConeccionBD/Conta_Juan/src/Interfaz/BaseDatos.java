package Interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    String url = "jdbc:mysql://localhost:3306/proyecto"; //proyecto
    String user = "root";
    String psw = "12345";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;

    public Connection getConnection(){
        try{
            Class.forName(this.driver);
            con = DriverManager.getConnection(url, user, psw);
            System.out.println("Coneccion Lista");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error en la coneccion con a base de datos: " + e);
        }
        return con;
    }
    
    public static void main(String[] args) {
        //comprobar la coneccion establecida
        BaseDatos conex = new BaseDatos();
        conex.getConnection();
    }
 }

