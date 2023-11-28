package review;

import org.example.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E1 {

    public static void main(String[] args) {


        List<Map<String,String>> tableDataList=new ArrayList<>();
       try(Connection connection= DriverManager.getConnection(Constants.DB_URL,Constants.USER_NAME,Constants.PASSWORD);){

           Statement statement=connection.createStatement();
           String query="select * from person";
           ResultSet rs= statement.executeQuery(query);
           ResultSetMetaData rsmd= rs.getMetaData();

           while (rs.next()){
                Map<String,String> rowDataMap=new HashMap<>();
               for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
                   String key=rsmd.getColumnName(i);
                   String value=rs.getString(i);
                   rowDataMap.put(key,value);
               }
               tableDataList.add(rowDataMap);

           }

           System.out.println(tableDataList);

       }catch (SQLException e){
           e.printStackTrace();
       }
    }
}
