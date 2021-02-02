package entitybeans;

public class Celeb 
{
	private int celebno;
	private String celebnm;
	private String field;
	private String country;
	
	public Celeb()
	{
		celebno=0;
		celebnm="";
		field="";
		country="";
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
	
	

}
