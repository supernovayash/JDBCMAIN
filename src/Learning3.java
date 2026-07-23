import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Learning3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc=new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/ecommerce";
        String username = "root";
        String password = "1234";
        // establish connection
        Connection connection= DriverManager.getConnection(url,username,password);


        String sql="update customer set address_city =? where cust_id=?";
        PreparedStatement prst=connection.prepareStatement(sql);

        System.out.println("enter cust_id where change or update expected");
        int x=sc.nextInt();
        sc.nextLine();
        System.out.println("enter updated address city");
        String y=sc.nextLine();

        prst.setString(1,y);
        prst.setInt(2,x);


        int rowsAffected=prst.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Record Updated Successfully!");
        } else {
            System.out.println("Customer ID not found.");
        }

        // all resources closed
        prst.close();
        connection.close();
        sc.close();


    }
}
