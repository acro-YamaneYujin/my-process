package kadai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class DbSumple {
	  public static void main(String[] args) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    String qry = "select * from questions where number = ?";
	    ResultSet rs = null;
	    Scanner scanner = new Scanner(System.in);
	    Random random = new Random();
	    int i = random.nextInt(11);
	    
	    try {
	      con = DriverManager.getConnection("jdbc:mysql://localhost/kadai2?autoReconnect=true&useSSL=false",
	        "root",
	        ""
	      );
	      PreparedStatement ps = con.prepareStatement(qry);
	      pstmt = con.prepareStatement("select * from questions");
	      ps.setInt(1, i);
	      rs = ps.executeQuery();
	      while (rs.next()) {
	        System.out.println(rs.getString("question"));
	        System.out.println(rs.getString("A"));
	        System.out.println(rs.getString("B"));
	        System.out.println(rs.getString("C"));
	        System.out.println(rs.getString("D"));
	        System.out.println("答えを入力してください");
	        String scan = scanner.next();
	        if (scan.equals(rs.getString("answer"))) {
	        	System.out.println("正解");
	        } else {
	        	System.out.println("不正解");
	        	System.out.println("答え" + " " + (rs.getString("answer")));
	        }
	        
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      if (rs != null) {
	        try {
	          rs.close();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	      if (pstmt != null) {
	        try {
	          pstmt.close();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	      if (con != null) {
	        try {
	          con.close();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	  }
}
