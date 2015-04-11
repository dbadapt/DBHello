// Simple Java JDBC example
// Edit db.properties for your environment 
// Compile: javac DBHello.java
// Run: java -cp .:{jdbc.jar} DBHello

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class DBHello {
  public static void main(String[] args) 
      throws SQLException,ClassNotFoundException,IOException {
    Properties dbp = new Properties();
    dbp.load(DBHello.class.getClassLoader()
        .getResourceAsStream("db.properties"));
    Class.forName(dbp.getProperty("class"));
    Connection con = 
        DriverManager.getConnection(dbp.getProperty("url"), dbp);
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(dbp.getProperty("versionQuery"));
    if (rs.next()) {
      System.out.printf("Hello from %s\n",rs.getString("version"));
    }
    st.close(); con.close();
  }
}
