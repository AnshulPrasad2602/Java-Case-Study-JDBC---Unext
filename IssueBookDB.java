package librarybookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueBookDB {

	public static boolean checkBook(int bookNo){
		boolean status=false;
		try{
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from books where callno = ?");
			ps.setInt(1,bookNo);
		    ResultSet rs = ps.executeQuery();
			//status=rs.next();
			
			System.out.println("Book No."+ "\t" + "Book Name" + "\t" + "Author" + "\t" +"Publisher" + 
					  "\t" + "Quantity");
			  
			  while(rs.next())
			  {
				  System.out.println(rs.getInt(1)+ "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" +rs.getString(4) + 
						  "\t" + rs.getInt(5));
				  
			  }
			  
			con.close();
		}catch(Exception e){
			
			System.out.println(e);
		}
		return status;
	}

	public static int save(int bookNo,int studentID,String studentName,String studentContact){
		int status=0;
		try{
			Connection con = DB.getConnection();
			
			status=updatebook(bookNo);//updating quantity
			
			if(status>0){
				
			PreparedStatement ps = con.prepareStatement("insert into issuebooks(bookcallno,studentid,studentname,studentcontact,issueddate) values(?,?,?,?,curdate())");
			ps.setInt(1,bookNo);
			ps.setInt(2,studentID);
			ps.setString(3,studentName);
			ps.setString(4,studentContact);
			status=ps.executeUpdate();
			
			}
			
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	
	private static int updatebook(int bookcallno){
		int status=0;
		int quantity=0;
		try{
			Connection con=DB.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select quantity from books where callno=?");
			ps.setInt(1,bookcallno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				
			}
			
			if(quantity>0){
				PreparedStatement ps2=con.prepareStatement("update books set quantity=? where callno=?");
				ps2.setInt(1,quantity-1);
				
				ps2.setInt(2,bookcallno);
				
				status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static void viewIssuedHistory() {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from issuebooks");
			  ResultSet rs = stmt.executeQuery();
			  
			  System.out.println("ID"+ "\t" + "Book ID" + "\t\t" + "Student ID" + "\t" +"Student Name" + 
					  "\t" + "Student Contact" + "\t\t" + "Issued Date");
			  
			  while(rs.next())
			  {
				  System.out.println(rs.getInt(1)+ "\t" + rs.getInt(2) + "\t\t" + rs.getInt(3) + "\t\t" +rs.getString(4) + 
						  "\t\t" + rs.getString(5) + "\t\t" + rs.getDate(6));
				  
			  }
			
		} catch (Exception e) {
			//System.out.println(e);
		}
	}
	
}
