package Exam_Portal;
	 
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class Teachers
	{
		Scanner sc=new Scanner(System.in);
		int t_id;// Variables to teacher portal details
		String t_name;
		String t_gender;
		String t_subject;
		String t_address;
		
		   // Method to perform various operations in the teacher portal
		public void operations() throws SQLException 
		{
			try
			{  // Establish connection to the database
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn;
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ExamPortal","root","root");
				while(true)// Main menu loop
				{
				System.out.println("\nEnter your choice from below options");
				System.out.println("1:for Create the table");
				System.out.println("2:for showing the List of teacher");
				System.out.println("3:for add the new teacher in the list");
				System.out.println("4:for Updating the list of teacher");
				System.out.println("5:for showing teacher account to teacher Id");
				System.out.println("6:for deleting teacher from the list");
				System.out.println("7:for showing customise list of Teacher");
				System.out.println("8:for deleting the table");
				System.out.println("9:Exit");
				int ch=sc.nextInt();
				switch (ch) 
				{
				case 1:
					create(conn);
					break;
				case 2:
					view(conn);
					break;
				case 3:
					insert(conn);
					break;
				case 4:
					update(conn);
					break;
				case 5:
					row_view(conn);
					break;
				case 6:
					delete(conn);
					break;
				case 7:
					customize(conn);
					break;
				case 8:
					drop(conn);
					break;
				case 9:
					System.exit(0);// Exit the program
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			
				}
			} 
			catch (ClassNotFoundException e) 
			{
				 // Handle class not found exception
				e.printStackTrace();
			}	
		}
		
		 // Method to create the table if not exists
		public void create(Connection conn) throws SQLException
		{
			
	        PreparedStatement statement = conn.prepareStatement( "CREATE TABLE IF NOT EXISTS teacher (t_id INT PRIMARY KEY AUTO_INCREMENT, t_name VARCHAR(255), t_gender VARCHAR(255), t_address VARCHAR(255), t_subject VARCHAR(255), t_doj DATE)");
	        int count = statement.executeUpdate();
	        
	        if (count > 0) 
	        {
	            System.out.println("Table created successfully");
	        } 
	        else 
	        {
	            System.err.println("Table creation failed");
	        }
		}
		
		 // Method to view List of Teacher
		public void view(Connection conn) throws SQLException
		{
			String qur="Select * from teacher";
			PreparedStatement st=conn.prepareStatement(qur);
			ResultSet rs=st.executeQuery();
			System.out.println("Teacher id \tTeacher Name \tTeacher Gender \tTeacher Subject \tTeacher address \t  Teacher Date of joining");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getDate(6));
			}
		}
		 // Method to add a new teacher in the list
		public void insert (Connection conn) throws SQLException
		{
			char ans;
			do
			{
			String qur="insert into teacher (t_name,t_gender,t_subject,t_address,t_doj) values(?,?,?,?,?);";
			PreparedStatement ps=conn.prepareStatement(qur);
			System.out.println("Enter teacher name");
			t_name=sc.next();
			System.out.println("Enter teacher Gender");
			t_gender=sc.next();
			System.out.println("Enter teacher subject");
			t_subject=sc.next();
			System.out.println("Enter teacher address(city)");
			t_address=sc.next();
			System.out.println("Enter date of Joining of teacher(YYYY-MM-DD)");
			String t_doj=sc.next();
			Date doj=Date.valueOf(t_doj);
			ps.setString(1, t_name);
			ps.setString(2, t_gender);
			ps.setString(3, t_subject);
			ps.setString(4,t_address);
			ps.setDate(5,doj);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Data added successfully");
			}
			System.out.println("do you want add another data ");
			System.out.println("Enter 'Y' for yes & 'N' for no");
			 ans=sc.next().charAt(0);
			}while(ans=='y'|| ans=='Y');
		}
		
		
		// Method to update teacher name,Gender,Subject,Address
		public void update(Connection conn) throws SQLException
		{
			int ch1;
			char ans1;
			do
			{
			System.out.println("WHich item do you want to update");
			System.out.println("1:name");
			System.out.println("2:gender");
			System.out.println("3:subject");
			System.out.println("4:address");
			ch1=sc.nextInt();
			switch(ch1)
			{
			case 1:
				System.out.println("Enter Teachers id");
				t_id=sc.nextInt();
				System.out.println("Enter Teacher Name");
				t_name=sc.next();
				String qur="update teacher set t_name=? where t_id=?";
				PreparedStatement ps=conn.prepareStatement(qur);
				ps.setString(1,t_name);
				ps.setInt(2,t_id);
				int count=ps.executeUpdate();
				if(count>0)
				{
				System.out.println("Data updated successfully");
				}
				else
				{
					System.err.println("error in query");
				}
				break;
			case 2:
				System.out.println("Enter Teachers id");
				t_id=sc.nextInt();
				System.out.println("Enter Teacher Gender");
				t_gender=sc.next();
				String qur1="update teacher set t_gender=? where t_id=?";
				PreparedStatement ps1=conn.prepareStatement(qur1);
				ps1.setString(1, t_gender);
				ps1.setInt(2,t_id);
				int count1=ps1.executeUpdate();
				if(count1>0)
				{
				System.out.println("Data updated successfully");
				}
				else
				{
				System.err.println("error in query");
				}
				break;
			case 3:
				System.out.println("Enter teacher Id");
				t_id=sc.nextInt();
				System.out.println("Enter Teacher subject");
				t_subject=sc.next();
				String qui="update teacher set t_subject=? where t_id=?";
				PreparedStatement psu=conn.prepareStatement(qui);
				psu.setString(1,t_subject);
				psu.setInt(2,t_id);
				int count11=psu.executeUpdate();
				if(count11>0)
				{
				System.out.println("Data updated successfully");
				}
				else
				{
				System.out.println("error in query");
				}
				break;
			case 4:
				System.out.println("Enter Teacher Id");
				t_id=sc.nextInt();
				System.out.println("Enter Teacher Address(City)");
				t_address=sc.next();
				PreparedStatement psj=conn.prepareStatement("update teacher set t_doj=? where t_id=?");
				psj.setString(1, t_address);
				psj.setInt(2, t_id);
				int count2=psj.executeUpdate();
				if(count2>0)
				{
				System.out.println("Data updated successfully");
				}
				else
				{
					System.err.println("error in query");
				}
				break;
			default:
				System.out.println("Sorry you enter invalid choice");
				break;
			}
			System.out.println("do you want Update another data ");
			System.out.println("Enter 'Y' for yes & 'N' for no");
			 ans1=sc.next().charAt(0);
			}while(ans1=='y'|| ans1=='Y');
		  }
		
		// Method to view a specific Teacher by its ID
		public void row_view(Connection conn) throws SQLException
		{
			System.out.println("Enter Teachers id");
			t_id=sc.nextInt();
			String qur="select * from teacher where t_id=?";
			PreparedStatement pse=conn.prepareStatement(qur);
			pse.setInt(1, t_id);
			ResultSet rs=pse.executeQuery();
			System.out.println("teacher id \tteacher name \tteacher Gender \tteacher Subject \tteacher address \t  teacher Date of joining");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getDate(6));
			}
		}
		
		 // Method to delete a Teacher from the Data entry
		public void delete(Connection conn) throws SQLException
		{
			String confirm;
			System.out.println("Enter Teacher id");
			t_id=sc.nextInt();
			System.out.println("Are you sure for deleting the entered record"
					+ "press Y for yes and N for No");
			confirm=sc.next();
			if(confirm.equalsIgnoreCase("Y"))
			{
			String qur="delete from teacher where t_id=?";
			PreparedStatement ps=conn.prepareStatement(qur);
			ps.setInt(1, t_id);
			ps.executeLargeUpdate();
			System.out.println("deleted successfully");
			}
			else
			{
				System.out.println("cancelling the deletion of record");
			}
		}
		
		
		// Method to generate customized lists of teacher
		public void customize(Connection conn) throws SQLException
		{
			char ans1;
			do 
			{
			System.out.println("which list do you want according to");
			System.out.println("1:Teacher Id");
			System.out.println("2:Teacher name");
			System.out.println("3:Teacher gender");
			System.out.println("4:Teacher subject");
			System.out.println("5:Teacher address");
			System.out.println("6:Teacher Date of joining");
			int ch2=sc.nextInt();
			switch(ch2)
			{
			case 1:
				System.out.println("Enter Teacher Id");
				t_id=sc.nextInt();
				String qur="select * from teacher where t_id=?";
				PreparedStatement pse=conn.prepareStatement(qur);
				pse.setInt(1, t_id);
				ResultSet rs=pse.executeQuery();
				System.out.println("teacher id \tteacher name \tteacher Gender \tteacher Subject \tteacher address \t  teacher Date of joining");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getDate(6));
				}
				break;
			case 2:
				System.out.println("Enter Teacher name");
				t_name=sc.next();
				String que="select * from teacher where t_name=?";
				PreparedStatement ps=conn.prepareStatement(que);
				ps.setString(1,t_name);
				ResultSet rs1=ps.executeQuery();
				System.out.println("teacher id \tteacher name \tteacher Gender \tteacher Subject \tteacher address \t  teacher Date of joining");
				while(rs1.next())
				{
					System.out.println(rs1.getInt(1)+"\t\t"+rs1.getString(2)+"\t\t"+rs1.getString(3)+"\t\t"+rs1.getString(4)+"\t\t"+rs1.getString(5)+"\t\t"+rs1.getDate(6));
				}
				break;
			case 3:
				System.out.println("Enter Teacher Gender");
				t_gender=sc.next();
				String qui="select * from teacher where t_gender=?";
				PreparedStatement psi=conn.prepareStatement(qui);
				psi.setString(1,t_gender);
				ResultSet re=psi.executeQuery();
				System.out.println("teacher id \tteacher name \tteacher Gender \tteacher Subject \tteacher address \t  teacher Date of joining");
				while(re.next())
				{
					System.out.println(re.getInt(1)+"\t\t"+re.getString(2)+"\t\t"+re.getString(3)+"\t\t"+re.getString(4)+"\t\t"+re.getString(5)+"\t\t\t"+re.getDate(6));
				}
				break;
			case 4:
				System.out.println("Enter Teacher Subject");
				t_subject=sc.next();
				String qut="select * from teacher where t_subject=?";
				PreparedStatement psp=conn.prepareStatement(qut);
				psp.setString(1,t_subject);
				ResultSet rw=psp.executeQuery();
				System.out.println("teacher id \tteacher name \tteacher Gender \tteacher Subject \tteacher address \t  teacher Date of joining");
				while(rw.next())
				{
					System.out.println(rw.getInt(1)+"\t\t"+rw.getString(2)+"\t\t"+rw.getString(3)+"\t\t"+rw.getString(4)+"\t\t\t"+rw.getString(5)+"\t\t\t"+rw.getDate(6));
				}
				break;
			case 5:
				System.out.println("Enter Teacher Address(City)");
				t_address=sc.next();
				String quj="select * from teacher where t_address=?";
				PreparedStatement psj=conn.prepareStatement(quj);
				psj.setString(1,t_address);
				ResultSet rj=psj.executeQuery();
				System.out.println("teacher id \tteacher name \tteacher Gender \tteacher Subject \tteacher address \t  teacher Date of joining");
				while(rj.next())
				{
					System.out.println(rj.getInt(1)+"\t\t"+rj.getString(2)+"\t\t"+rj.getString(3)+"\t\t"+rj.getString(4)+"\t\t\t"+rj.getString(5)+"\t\t\t"+rj.getDate(6));
				}
				break;
			case 6:
				String t_doj;
				System.out.println("Enter teacher Date of joining(YYYY-MM-DD)");
				t_doj=sc.next();
				Date doj=Date.valueOf(t_doj);
				String quj1="select * from teacher where t_doj=?";
				PreparedStatement psj1=conn.prepareStatement(quj1);
				psj1.setDate(1, doj);
				ResultSet rj1=psj1.executeQuery();
				System.out.println("teacher id \tteacher name \tteacher Gender \tteacher Subject \tteacher address \t  teacher Date of joining");
				while(rj1.next())
				{
					System.out.println(rj1.getInt(1)+"\t\t"+rj1.getString(2)+"\t\t"+rj1.getString(3)+"\t\t"+rj1.getString(4)+"\t\t\t"+rj1.getString(5)+"\t\t\t"+rj1.getDate(6));
				}
				break;
			default:
				System.out.println("Sorry you entered Wrong choice");
				break;
			}
			System.out.println("Do you want another Customize list???");
			System.out.println("'Y' for Yes & 'N' for No");
			ans1=sc.next().charAt(0);
		  }while(ans1=='Y' || ans1=='y');
		 }
		public void drop(Connection conn) throws SQLException
		{
			String confirm;
			System.out.println("Are you sure for deleting the entered table"
					+ "press Y for yes and N for No");
			confirm=sc.next();
			if(confirm.equalsIgnoreCase("Y"))
			{
			String qur="drop table teacher ";
			PreparedStatement ps=conn.prepareStatement(qur);
			ps.setInt(1, t_id);
			ps.executeLargeUpdate();
			System.out.println("table deleted successfully");
			}
			else
			{
				System.out.println("cancelling the deletion of record");
			}
		}
}
