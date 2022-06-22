package main.java;

import java.sql.Statement;
import java.util.*;
import java.sql.*;
import main.java.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database_provider
{
    private int MaxIncrement;

    public int AddUser(User users) throws ClassNotFoundException
    {

        String PracticeUrl = "jdbc:mysql://localhost:3306/rental?useSSL=false";
        String INSERT_USERS_SQL = "INSERT INTO user" +
                "(id, number_phone, technique, name, surname, address) VALUES"+
                "(?,?,?,?,?,?);";
        int result = 0;
        //Class.forName("com.mysql.jdbc.Driver");


        try (Connection connection = DriverManager.getConnection(PracticeUrl, "root", "DHM912");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, users.getId());
            preparedStatement.setString(2, users.getNumber_phone());
            preparedStatement.setString(3, users.getTechnique());
            preparedStatement.setString(4, users.getName());
            preparedStatement.setString(5, users.getSurname());
            preparedStatement.setString(6, users.getAddress());

            System.out.println(preparedStatement);

            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException e) { }

    public ArrayList<User> GetFromDb()throws ClassNotFoundException{

        String PracticeUrl = "jdbc:mysql://localhost:3306/rental";
        //Class.forName("com.mysql.jdbc.Driver");
        String query = "SELECT * FROM user";

        ArrayList<User> UserList  = new ArrayList<User>();
        User  users = new User ();

        try(Connection connection = DriverManager.getConnection(PracticeUrl, "root", "DHM912")){

            Statement st = connection.createStatement();

            ResultSet rs= st.executeQuery(query);

            while (rs.next()){
                MaxIncrement++;
                users.setId(rs.getInt("id"));
                users.setNumber_phone(rs.getString("number_phone"));
                users.setTechnique(rs.getString("technique"));
                users.setName(rs.getString("name"));
                users.setSurname(rs.getString("surname"));
                users.setAddress(rs.getString("address"));

                System.out.print(rs.getInt("id")+" ");
                System.out.print(rs.getString("number_phone")+" ");
                System.out.print(rs.getString("technique")+" ");
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("surname"));
                System.out.println(rs.getString("address"));

                UserList.add(rs.getInt("id")-1,users);
            }
            //System.out.println(flower.getFlowerID());
            st.close();

        }catch (SQLException e){
            // process sql exception
            printSQLException(e);
        }

        return UserList ;
    }

    public  int UpdateUser(User  users) throws  ClassNotFoundException{
        int result=0;
        String PracticeUrl = "jdbc:mysql://localhost:3306/rental?useSSL=false";

        try {
            Connection connection = DriverManager.getConnection(PracticeUrl, "root", "DHM912");
            Statement myStmt = connection.createStatement();


            String updSql = "update user"
                    +" set number_phone='"+users.getNumber_phone()+"',"
                    +"technique='"+users.getTechnique()+"',"
                    +"name='"+ users.getName()+"',"
                    +"surname='"+ users.getSurname()+"',"
                    +"address='"+ users.getAddress()+"'"
                    +" where id='"+ users.getId()+"'";

            result = myStmt.executeUpdate(updSql);
            System.out.println("Update complete");

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int DeleteUser(User users) throws  ClassNotFoundException{
        int result=0;

        String PracticeUrl = "jdbc:mysql://localhost:3306/rental?useSSL=false";
        try{
            String query = "SELECT * FROM user";
            Connection connection = DriverManager.getConnection(PracticeUrl, "root", "DHM912");
            Statement myStmt = connection.createStatement();
            ResultSet rs= myStmt.executeQuery(query);

            while (rs.next()){
            }

            String delsql= "delete from user where id='"+ users.getId()+"'";
            result = myStmt.executeUpdate(delsql);
            String AIncsql= "AUTO_INCREMENT ='"+MaxIncrement+"'";
            System.out.println("Rows Affected:"+result);
            System.out.printf("Delete Complete");

        }catch ( Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}

