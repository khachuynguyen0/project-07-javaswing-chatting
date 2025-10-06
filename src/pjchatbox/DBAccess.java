package pjchatbox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBAccess {
    private Connection con;
    private Statement stmt;

    public DBAccess() {
        try {
            MyConnection mycon = new MyConnection();
            con = mycon.getConnection();
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace(); // để debug dễ hơn
        }
    }

    public int Update(String str) {
        try {
            int i = stmt.executeUpdate(str);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //tra ve 1 gia tri
    public ResultSet Query(String str) {
        try {
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int Get1IntValue(String query){
        try {
            ResultSet rs = this.Query(query);
            //tien len dong tiep theo: rs.next()
            if (rs.next()) { 
                //dong thu 1
                return rs.getInt(1);
            }
            //loi-> return -1
            return -1;

        } catch (Exception e) {
            e.printStackTrace();
           return -1;
        }
    };
    
    public String Get1StringValue(String query){
        try {
            ResultSet rs = this.Query(query);
            //tien len dong tiep theo: rs.next()
            if (rs.next()) { 
                //dong thu 1
                return rs.getString(1);
            }
            //loi-> return -1
            return "";

        } catch (Exception e) {
            e.printStackTrace();
           return "";
        }
    };
    
}
