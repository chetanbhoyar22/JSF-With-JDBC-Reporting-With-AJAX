package managedbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="ps")
@RequestScoped
public class PlayerSearch 
{
private int playerno;
private String club;
private String playernm;
private String position;
private String country;

public PlayerSearch()
{
	playerno=0;
	club="";
	playernm="";
	position="";
	country="";
}

public int getPlayerno() {
	return playerno;
}

public void setPlayerno(int playerno) {
	this.playerno = playerno;
	retrieveData();
}

public String getClub() {
	return club;
}

public void setClub(String club) {
	this.club = club;
}

public String getPlayernm() {
	return playernm;
}

public void setPlayernm(String playernm) {
	this.playernm = playernm;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

private void retrieveData()
{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chetan?user=root&password=12345");
		pst=con.prepareStatement("select * from plteams where playerno=?;");
		pst.setInt(1, playerno);
		rs=pst.executeQuery();
		if(rs.next())
		{
			club=rs.getString("club");
			playernm=rs.getString("playernm");
			position=rs.getString("position");
			country=rs.getString("country");
		}
		else
		{
			club="Not found";
			playernm="Not found";
			position="Not found";
			country="Not found";
		}
		con.close();
		
	}
	catch(Exception e)
	{
		club="Error";
		playernm="Error";
		position="Error";
		country="Error";
	}

}

}
