package librarybookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDB {

	public static int save(int callno,String name,String author,String publisher,int quantity){
		int status=0;
		try{
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into books(callno,name,author,publisher,quantity) values(?,?,?,?,?)");
			ps.setInt(1,callno);
			ps.setString(2,name);
			ps.setString(3,author);
			ps.setString(4,publisher);
			ps.setInt(5,quantity);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){
			//System.out.println(e);
		}
		return status;
	}
	
	public static void viewBooks() {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from books");
			  ResultSet rs = stmt.executeQuery();
			  
			  System.out.println("Book No."+ "\t" + "Book Name" + "\t\t" + "Author" + "\t\t" +"Publisher" + 
					  "\t" + "Quantity");
			  
			  while(rs.next())
			  {
				  System.out.println(rs.getInt(1)+ "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" +rs.getString(4) + 
						  "\t\t" + rs.getInt(5));
				  
			  }
			
		} catch (Exception e) {
			//System.out.println(e);
		}
	}
	
	public static int deleteBook(int bookNo){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from books where callno=?");
			ps.setInt(1,bookNo);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
}
