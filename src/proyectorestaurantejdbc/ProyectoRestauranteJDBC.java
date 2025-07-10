/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectorestaurantejdbc;

/**
 *
 * @author valen
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectoRestauranteJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/restaurante";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoRestauranteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        try {
            conexion=DriverManager.getConnection(url,usuario,password);
          
            statement=conexion.createStatement();
            statement.executeUpdate ("INSERT INTO USUARIO (ID_TIPO_USUARIO, NOMBRE, APELLIDO, DIRECCION, TELEFONO, CEDULA, EMAIL, PASSWORD) VALUES('1','Jose','Roa','calle 127','12345','67890','j@correo.com','1234')");
            rs=statement.executeQuery("select * FROM USUARIO");
            rs.next();
             
            do{System.out.println(rs.getInt("Id_usuario")+ " : "+rs.getString("Nombre")); 
            
          } while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoRestauranteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
