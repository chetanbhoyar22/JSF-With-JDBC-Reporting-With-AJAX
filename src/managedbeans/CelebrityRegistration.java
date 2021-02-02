package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.*;

@ManagedBean(name="celreg")
@RequestScoped
public class CelebrityRegistration 
{
private int celebno;
private String celebnm;
private String field;
private String country;
private String regstatus;

public CelebrityRegistration()
{
	celebno=0;
	celebnm="";
	field="";
	country="";
	regstatus="";
}

public int getCelebno() {
	return celebno;
}

public void setCelebno(int celebno) {
	this.celebno = celebno;
}

public String getCelebnm() {
	return celebnm;
}

public void setCelebnm(String celebnm) {
	this.celebnm = celebnm;
}

public String getField() {
	return field;
}

public void setField(String field) {
	this.field = field;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getRegstatus() {
	insertCelebrity();
	return regstatus;
}

public void setRegstatus(String regstatus) {
	this.regstatus = regstatus;
}


private void insertCelebrity()
{
	Connection con;
	PreparedStatement pst;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdb?user=root&password=12345");
		pst=con.prepareStatement("insert into celebs values(?,?,?,?);");
		pst.setInt(1, celebno);
		pst.setNString(2, celebnm);
		pst.setString(3,field);
		pst.setNString(4, country);
		pst.executeUpdate();
		regstatus="success";
		con.close();
		
	}
	catch(Exception e)
	{
		regstatus="failed";
	}
}


}
