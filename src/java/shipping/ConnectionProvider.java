/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipping;

import java.sql.*;

/**
 *
 * @author dashmeetkaur
 */
public class ConnectionProvider implements Provider {
     public static Connection con=null;
    static 
    {
          
    }
    public static Connection getCon()
    {
        try{
        Class.forName(DRIVER);  
        con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
        
        }
        catch(Exception e){ e.printStackTrace();}
        
        return con;
    }
    
    
}
