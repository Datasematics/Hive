//importing all necessary packages for hive
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;


public class HiveJDBCConnection {

// hive connectivity driver name
      private static  String driverName = "org.apache.hive.jdbc.HiveDriver";

      public static void main(String[] args) throws IOException,SQLException,ClassNotFoundException {

                 try {
                      	Class.forName(driverName);
                         } catch (ClassNotFoundException e) {
  		e.printStackTrace();
                         System.out.println("catching exception");
                         System.exit(1);
                 }

//address to the host where hive is installed. 
// here “hive” is a username, and password is “ ”.
                 

Connection con =DriverManager.getConnection("jdbc:hive2://localhost:10000/default","hive", "");

            Statement stmt = con.createStatement();
                 String tableName = "table99";
                 stmt.execute("drop table if exists " + tableName);
                 stmt.execute("create table " + tableName + " (key int, value string)");
                 // show tables
                 // String sql = "show tables '" + tableName + "'";
                 String sql = ("show tables");
                 ResultSet res = stmt.executeQuery(sql);
                 if (res.next()) {
                  System.out.println(res.getString(1));
                 }
         }

}
