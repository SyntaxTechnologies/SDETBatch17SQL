package org.example;

import java.util.List;
import java.util.Map;

public class E4 {
    public static void main(String[] args) {

      List<Map<String,String>> data= DbUtils.fetch("Select * from person");
        System.out.println(data);
        Map<String,String> rowData=data.get(1);
        System.out.println(rowData.get("FirstName"));
        //Break till 8:49

    }
}
