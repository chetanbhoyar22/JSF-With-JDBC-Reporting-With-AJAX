package managedbeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entitybeans.Celeb;
import java.sql.*;

@ManagedBean(name="cr")
@SessionScoped
public class CelebReporter 
{
	private ArrayList<Celeb> list;
	
	public CelebReporter()
	{
		Connection con;
		Statement st;
		ResultSet rs;
		list=new ArrayList<Celeb>();
		Celeb obj;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdb?user=root&password=12345");
			st=con.createStatement();
			rs=st.executeQuery("select * from celebs;");
						
			while(rs.next())
			{
				obj=new Celeb();
				obj.setCelebno(rs.getInt("celebno"));
				obj.setCelebnm(rs.getNString("celebnm"));
				obj.setField(rs.getNString("field"));
				obj.setCountry(rs.getNString("country"));
				list.add(obj);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error in reporting");
		}
	}

	public ArrayList<Celeb> getList() {
		return list;
	}

	public void setList(ArrayList<Celeb> list) {
		this.list = list;
	}

	
	
}
