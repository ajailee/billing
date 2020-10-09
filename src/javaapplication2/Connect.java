/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author ajai
 */
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connect {

    /**
     * Connect to a sample database
     */
    static String pernmenturl;
    static String url;

    public static void createNewDatabase(String fileName) {
        String os = System.getProperty("os.name");
        if (os.equals("Linux")) {
            String url = "jdbc:sqlite:/home/ajai/Desktop/db/" + fileName;
            pernmenturl = url;
        } else {
            String url = "jdbc:sqlite:C:sqlite/db/" + fileName;
            pernmenturl = url;
        }

        //String url = "jdbc:sqlite:/home/ajai/Desktop/db/" + fileName;
        try {
            Connection conn = DriverManager.getConnection(pernmenturl);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
//                pernmenturl=url;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = pernmenturl;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println("not working");
        }

        return conn;
    }

    public static void createNewTable() {
        // SQLite connection string  
        String url = pernmenturl;

        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS login (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " password text NOT NULL\n"
                + ");";

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewProductTable() {
        // SQLite connection string  
        String url = pernmenturl;

        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS product (\n"
                + " productid integer PRIMARY KEY,\n"
                + " productname text NOT NULL,\n"
                + " category text NOT NULL,\n"
                + " qty int NOT NULL,\n"
                + " gst real NOT NULL,\n"
                + " purchaseprice real NOT NULL,\n"
                + " margin real NOT NULL,\n"
                + " discount real NOT NULL,\n"
                + " hsn int NOT NULL,\n"
                + " total real NOT NULL\n"
                + ");";

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createAdmin(String user, String password) {
        String sql = "INSERT OR IGNORE INTO login(name,password) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(pernmenturl);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.print("problem");
            System.out.println(e.getMessage());
        }
    }

    public static void addProduct(int productid, String productname, String category, int qty, double gst, double purchaseprice, double margin, double discount, int hsn, double total) {

        String sql = "INSERT  INTO product(productid,productname,category,qty,gst,purchaseprice,margin,discount,hsn,total) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(pernmenturl);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, productid);
            pstmt.setString(2, productname);
            pstmt.setString(3, category);
            pstmt.setInt(4, qty);
            pstmt.setDouble(5, gst);
            pstmt.setDouble(6, purchaseprice);
            pstmt.setDouble(7, margin);
            pstmt.setDouble(8, discount);
            pstmt.setInt(9, hsn);
            pstmt.setDouble(10, total);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Add Successfully");
        } catch (SQLIntegrityConstraintViolationException e) {

        } catch (SQLException e) {
            int SQL_DUPLICATE_PK = 19;
            if (e.getErrorCode() == SQL_DUPLICATE_PK) {
                JOptionPane.showMessageDialog(null, "Product Id already Exist");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        }
    }
    
    public static ResultSet getInventoryTable(){
        String sql = "SELECT * FROM product";
        try {
            Connection conn = DriverManager.getConnection(pernmenturl);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "table getInventorytable");
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
