import java.sql.*;

public class Learning2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        String url = "jdbc:mysql://localhost:3306/ecommerce";
        String username = "root";
        String password = "1234";

        // connection established
        Connection connection = DriverManager.getConnection(url, username, password);
        // Statement creation

        Statement st = connection.createStatement();

        // execute query
        String sql ="select * from customer";
                ResultSet rs =st.executeQuery(sql);
                while(rs.next()){
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                    System.out.println(rs.getString(5));
                }
                st.close();
                connection.close();
    }
}