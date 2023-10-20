package projek;

import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Koneksi {
    private Connection connect;
    
    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/aplikasikasir";
    private String username = "root";
    private String password = "";
    
    public Connection getKoneksi() {
        if (connect == null) {
            try {
                Class.forName(driverName);
                System.out.println("Class driver ditemukan");
                
                connect = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
                // Penanganan kesalahan untuk ClassNotFoundException
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                // Penanganan kesalahan untuk SQLException
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connect;
    }
}
