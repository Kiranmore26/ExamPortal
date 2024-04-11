package Exam_Portal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Students 
{
	Scanner sc =new Scanner(System.in);
	String Name,Address,Birth_date,Gender;
	int Id,Age,phone_no;
	
	// Method to create the Students table in the database if it doesn't exist
	public void create_table(Connection con) 
	{
		try
		{
			PreparedStatement pst=con.prepareStatement("create table if not exists Students (s_id int auto_increment primary key,s_name varchar (255) not null,s_age varchar(255),s_phnno int ,s_address varchar (255));");
			int count=pst.executeUpdate();
			if(count>0)
			{
				System.out.println("Table Created Sucessfully");				
			}
			else
			{
				System.err.println("Table not created");
			}
		}
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}
	
	   // Method to insert data into the Students table
	public void insert(Connection con) 
	{
		
		char ans;
		do
		{
			try
			{
				System.out.println("\nEnter Your Name :");
				Name=sc.next();
				System.out.println("Enter Your Age :");
				Age=sc.nextInt();
				System.out.println("Enter Your Gender :");
				Gender=sc.next();
				System.out.println("Enter Your Date of Birth (YYYY-MM-DD) ");
				Birth_date=sc.next();
				Date dob=Date.valueOf(Birth_date);
				System.out.println("Enter Your Phone-No");
				phone_no=sc.nextInt();
				System.out.println("Enter your Address :");
				Address=sc.next();
				PreparedStatement pst =con.prepareStatement("insert into Students (s_name,s_age,s_gender,s_dob,s_phnno,s_address) values (?,?,?,?,?,?)");
				pst.setString(1, Name);
				pst.setInt(2, Age);
				pst.setString(3,Gender);
				pst.setDate(4, dob);
				pst.setInt(5, phone_no);
				pst.setString(6, Address);
				int count =pst.executeUpdate();
				if(count>0)
				{
					System.out.println("Data Inserted Sucessfully ");
				}
				else
				{
					System.err.println("Data Not Inserted ");
				}
			}
			catch (Exception e) 
			{
				System.err.println(e.getMessage());
			}
			System.out.println("\nDo you want to repeat the process ");
			ans=sc.next().charAt(0);
		}
		while(ans=='Y' || ans=='y');
		
	}

	  // Method to update data in the Students table
	public void update(Connection con) 
	{
		int count;
		char ans;
		
		
			try
			{
				int choice;
				System.out.println("Choose What to Update");
				System.out.println("1) Name of the existing Student");
				System.out.println("2) Age of the existing Student");
				System.out.println("3) Gender of the existing Student");
				System.out.println("4) Date of Birth of the existing Student");
				System.out.println("5) Phone No of the existing Student");
				System.out.println("6) Address of the existing Student");
				choice=sc.nextInt();
				switch (choice) 
				{
				case 1:
					System.out.println("\nEnter student's Id :");
					Id=sc.nextInt();
					System.out.println("Enter student's Name to Update :");
					Name=sc.next();
					PreparedStatement pst1 =con.prepareStatement("update Students set s_name=? where s_id=?");
					pst1.setString(1,Name);
					pst1.setInt(2,Id);
					count=pst1.executeUpdate();
					if(count>0)
					{
						System.out.println("Data Updated SucessFully ");
					}
					else
					{
						System.err.println("Data Not Updated Due To Wrong Input");
					}
					break;
					
				case 2:
					System.out.println("\nEnter student's Id :");
					Id=sc.nextInt();
					System.out.println("Enter student's Age to Update :");
					Age=sc.nextInt();
					PreparedStatement pst2 =con.prepareStatement("update Students set s_age=? where s_id=?");
					pst2.setInt(1,Age);
					pst2.setInt(2,Id);
					count=pst2.executeUpdate();
					if(count>0)
					{
						System.out.println("\nData Updated SucessFully ");
					}
					else
					{
						System.err.println("Data Not Updated Due To Wrong Input");
					}
					break;
					
				case 3:
					System.out.println("\nEnter student's Id :");
					Id=sc.nextInt();
					System.out.println("Enter student's Gender to Update :");
					Gender=sc.next();
					PreparedStatement pst6 =con.prepareStatement("update Students set s_gender=? where s_id=?");
					pst6.setString(1,Gender);
					pst6.setInt(2,Id);
					count=pst6.executeUpdate();
					if(count>0)
					{
						System.out.println("\nData Updated SucessFully ");
					}
					else
					{
						System.err.println("Data Not Updated Due To Wrong Input");
					}
					break;
					
				case 4:
					System.out.println("\nEnter student's Id :");
					Id=sc.nextInt();
					System.out.println("Enter student's Date of Birth to Update :");
					Birth_date=sc.next();
					Date dob=Date.valueOf(Birth_date);
					PreparedStatement pst3 =con.prepareStatement("update Students set s_dob=? where s_id=?");
					pst3.setDate(1,dob);
					pst3.setInt(2,Id);
					count=pst3.executeUpdate();
					if(count>0)
					{
						System.out.println("Data Updated SucessFully ");
					}
					else
					{
						System.err.println("Data Not Updated Due To Wrong Input");
					}
					break;
					
				case 5:
					System.out.println("\nEnter student's Id :");
					Id=sc.nextInt();
					System.out.println("Enter student's Phone No to Update :");
					phone_no=sc.nextInt();
					PreparedStatement pst4 =con.prepareStatement("update Students set s_phnno=? where s_id=?");
					pst4.setInt(1,phone_no);
					pst4.setInt(2,Id);
					count=pst4.executeUpdate();
					if(count>0)
					{
						System.out.println("Data Updated SucessFully ");
					}
					else
					{
						System.err.println("Data Not Updated Due To Wrong Input");
					}
					break;	
				case 6:
					System.out.println("\nEnter student's Id :");
					Id=sc.nextInt();
					System.out.println("Enter student's Address to Update :");
					Address=sc.next();
					PreparedStatement pst5 =con.prepareStatement("update Students set s_address=? where s_id=?");
					pst5.setString(1,Address);
					pst5.setInt(2,Id);
					count=pst5.executeUpdate();
					if(count>0)
					{
						System.out.println("Data Updated SucessFully ");
					}
					else
					{
						System.err.println("Data Not Updated Due To Wrong Input");
					}
					break;
				
				default:
					System.err.println("Wrong input");
					break;
				}
			}
			catch (Exception e) 
			{
				System.err.println(e.getMessage());
			}
	}
	
	
	 // Method to display all data from the Students table
	public void display(Connection con) 
	{
		try
		{
			PreparedStatement pst=con.prepareStatement("select * from Students");
			ResultSet rs=pst.executeQuery();
			System.out.println("Id\tName\tAge\tGender\tDateofBirth\tPhone No\tAddress");
			while (rs.next()) 
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getDate(5)+"\t"+rs.getInt(6)+"\t\t"+rs.getString(7));
			}
		}
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}
	
	
	// Method to customize data display from the Students table
	public void Customize_Table(Connection con) 
	{
		char ans;
		
		try 
		{
			do
			{
				System.out.println("\nWhich data you want to see according to ? ");
				System.out.println("1) Student Id ");
				System.out.println("2) Student Name ");
				System.out.println("3) Student Age ");
				System.out.println("4) Student Gender ");
				System.out.println("5) Student Date of Birth  ");
				System.out.println("6) Student Address ");
				int Choice=sc.nextInt();
				switch (Choice) 
				{
				case 1:
					System.out.println("\nEnter Student's id whose data you want to see ");
					Id=sc.nextInt();
					PreparedStatement pst1 =con.prepareStatement("select * from Students where s_id=?");
					pst1.setInt(1, Id);
					ResultSet rs1=pst1.executeQuery();
					System.out.println("Id\tName\tAge\tGender\tDate of Birth\tPhone no\tAddress");
					while(rs1.next())
					{
						System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getInt(3)+"\t"+rs1.getString(4)+"\t"+rs1.getDate(5)+"\t"+rs1.getInt(6)+"\t"+rs1.getString(7));
					}
					
					break;
				case 2:
					System.out.println("\nEnter Student's Name whose data you want to see ");
					Name=sc.next();
					PreparedStatement pst2 =con.prepareStatement("select * from Students where s_name=?");
					pst2.setString(1, Name);
					ResultSet rs2=pst2.executeQuery();
					System.out.println("Id\tName\tAge\tGender\tDate of Birth\tPhone no\tAddress");
					while(rs2.next())
					{
						System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getInt(3)+"\t"+rs2.getString(4)+"\t"+rs2.getDate(5)+"\t"+rs2.getInt(6)+"\t"+rs2.getString(7));
					}
					break;
				case 3:
					System.out.println("\nEnter Student's Age whose data you want to see ");
					Age=sc.nextInt();
					PreparedStatement pst3 =con.prepareStatement("select * from Students where s_age=?");
					pst3.setInt(1, Age);
					ResultSet rs3=pst3.executeQuery();
					System.out.println("Id\tName\tAge\tGender\tDate of Birth\tPhone no\tAddress");
					while(rs3.next())
					{
						System.out.println(rs3.getInt(1)+"\t"+rs3.getString(2)+"\t"+rs3.getInt(3)+"\t"+rs3.getString(4)+"\t"+rs3.getDate(5)+"\t"+rs3.getInt(6)+"\t"+rs3.getString(7));
					}
					break;
				case 4:
					System.out.println("\nEnter Student's Gender whose data you want to see ");
					Gender=sc.next();
					PreparedStatement pst4 =con.prepareStatement("select * from Students where s_gender=?");
					pst4.setString(1, Gender);
					ResultSet rs4=pst4.executeQuery();
					System.out.println("P_id\tP_Name\tP_Quantity\tP_Price\t\tP_Packingdate\tP_Expiredate");
					System.out.println("Id\tName\tAge\tGender\tDate of Birth\tPhone no\tAddress");
					while(rs4.next())
					{
						System.out.println(rs4.getInt(1)+"\t"+rs4.getString(2)+"\t"+rs4.getInt(3)+"\t"+rs4.getString(4)+"\t"+rs4.getDate(5)+"\t"+rs4.getInt(6)+"\t"+rs4.getString(7));
					}
					break;
				case 5:
					System.out.println("Enter Student's Birth Date whose data you want to see ");
					Birth_date=sc.next();
					PreparedStatement pst5=con.prepareStatement("select * from Students where s_dob=?");
					Date p_date=Date.valueOf(Birth_date);
					pst5.setDate(1, p_date);
					ResultSet rs5=pst5.executeQuery();
					System.out.println("Id\tName\tAge\tGender\tDate of Birth\tPhone no\tAddress");
					while(rs5.next())
					{
						System.out.println(rs5.getInt(1)+"\t"+rs5.getString(2)+"\t"+rs5.getInt(3)+"\t"+rs5.getString(4)+"\t"+rs5.getDate(5)+"\t"+rs5.getInt(6)+"\t"+rs5.getString(7));
					}
					break;
				case 6:
					System.out.println("\nEnter Student's Address whose data you want to see ");
					Address=sc.next();
					PreparedStatement pst6 =con.prepareStatement("select * from Students where s_address=?");
					pst6.setString(1, Address);
					ResultSet rs6=pst6.executeQuery();
					System.out.println("Id\tName\tAge\tGender\tDate of Birth\tPhone no\tAddress");
					while(rs6.next())
					{
						System.out.println(rs6.getInt(1)+"\t"+rs6.getString(2)+"\t"+rs6.getInt(3)+"\t"+rs6.getString(4)+"\t"+rs6.getDate(5)+"\t"+rs6.getInt(6)+"\t"+rs6.getString(7));
					}
					break;

				default:
					System.out.println("Wrong Input ");
					break;
				}
				System.out.println("\nDo you want to Check something else ? ");
				ans=sc.next().charAt(0);
			}
			while(ans=='y' || ans =='Y');
			

		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}
	
	 // Method to delete data from the Students table
	public void delete(Connection con) 
	{
		try 
		{
			System.out.println("Enter Student's Id to delete his Data");
			Id=sc.nextInt();
			System.out.println("Are You sure you want to delete the data :");
			char ans=sc.next().charAt(0);
			
			if(ans=='Y' || ans=='y')
			{
				PreparedStatement pst=con.prepareStatement("delete from Students where s_id=?");
				pst.setInt(1, Id);
				int count=pst.executeUpdate();
				if(count>0)
				{
					System.out.println("\n Data Deleted Sucessfully");				
				}
				else
				{
					System.err.println("\nWrong Input");
				}
			}
			else
			{
				System.out.println("Deletion Process Cancelled");
			}
			
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}

	 // Method to add a new column to the Students table
	public void add_column(Connection con) 
	{
		try 
		{
			System.out.println("Enter Column Name that you want to add :");
			String Column_name=sc.next();
			System.out.println("Enter its Data type as per SQL");
			String Data_type=sc.next();
			PreparedStatement pst=con.prepareStatement("alter table Students add column "+Column_name+" "+Data_type);
			int count=pst.executeUpdate();
			if(count>0)
			{
				System.out.println("\n New Column Added SuccessFully ");	
			}
			else
			{
				System.err.println("\n Column not Added  ");
			}
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	   // Method to delete a column from the Students table
	public void delete_column(Connection con) 
	{
		try 
		{
			System.out.println("Enter Column Name that you want to Delete :");
			String Column_name=sc.next();
			PreparedStatement pst=con.prepareStatement("alter table Students drop column "+Column_name);
			int count=pst.executeUpdate();
			if(count>0)
			{
				System.out.println("\n Column deleted SuccessFully ");	
			}
			else
			{
				System.err.println("\n Column not Deleted  ");
			}
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}


    // Method to drop the Students table
	public void drop_table(Connection con) 
	{
		try 
		{
			PreparedStatement pst =con.prepareStatement("drop table Students ");
			pst.executeUpdate();
			System.out.println("\nTable Deleted Sucessfully");
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}
	
	// Method to perform operations on the Students table
	public void Operation() 
	{
		char ans;
		
			while(true)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ExamPortal","root","root");
					int choice;
					System.out.println("\nEnter Your Choose : ");
					System.out.println("1) Create table"); 
					System.out.println("2) Insert data into table"); 
					System.out.println("3) Update data into table");
					System.out.println("4) Display Complete Table");		
					System.out.println("5) Display Customize Table"); 
					System.out.println("6) delete data from table"); 
					System.out.println("7) Add new Column into the  table"); 
					System.out.println("8) Delete Column from the table"); 
					System.out.println("9) Drop Table"); 
					System.out.println("10) Exit"); 
					choice=sc.nextInt();
					switch (choice) 
					{
					case 1:
						create_table(con);
						break;
					case 2:
						insert(con);
						break;
					case 3:
						update(con);
						break;
					case 4:
						display(con);
						break;
					case 5:
						Customize_Table(con);
						break;
					case 6:
						delete(con);				
						break;
					case 7:
						add_column(con);
						break;
					case 8:
						delete(con);
						break;
					case 9:
						drop_table(con);
						break;
					case 10:
						System.exit(0);
						break;

					default:
						break;
					}
					con.close();
				}
				catch (Exception e) 
				{
					System.err.println(e.getMessage());
				}
			}
	
	}

}
