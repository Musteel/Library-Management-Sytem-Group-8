package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDao {
    public static int save(String callno,String name,String author,String publisher,String category,int quantity){
        int status=0;
        try{
            Connection con= DB.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,category,quantity) values(?,?,?,?,?,?)");
            ps.setString(1,callno);
            ps.setString(2,name);
            ps.setString(3,author);
            ps.setString(4,publisher);
            ps.setString(5,category);
            ps.setInt(6,quantity);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
}
