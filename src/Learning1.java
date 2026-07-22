import java.sql.*;

public class Learning1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        String url= "jdbc:mysql://localhost:3306/ecommerce";
        String username="root";
        String password="1234";

        // connection established
        Connection connection = DriverManager.getConnection(url,username,password);
        // Statement creation

        Statement st=connection.createStatement();

        // execute query
        String sql = "INSERT INTO customer (cust_id, name, address_city, address_street, address_houseno) " +
                "VALUES (115, 'Rahul Yadav', 'Delhi', 'MG Road', 'A-101')";

        int rowAffected=st.executeUpdate(sql);
        if(rowAffected==0){
            System.out.println("no row effected");
        }else{
            System.out.println("changes made sucessfully");
        }
     st.close();
        connection.close();



    }
}
