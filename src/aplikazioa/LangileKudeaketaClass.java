package Err3;
public class LangileKudeaketaClass {
	
	private String 	Izena;
	private String 	Abizena;
	private int 	Telefonoa;
	private int 	Mota;
	private String 	HE;
	private String Pasahitza;

	public LangileKudeaketaClass( String Izena, String Abizena, String Pasahitza, int Telefonoa, int Mota, String HE){
		this.Izena=Izena;
		this.Abizena=Abizena;
		this.Pasahitza=Pasahitza;
		this.Telefonoa=Telefonoa;
		this.Mota=Mota;
		this.HE=HE;
	}

	public String getIzena() {
		return Izena;
	}

	public void setIzena(String izena) {
		Izena = izena;
	}

	public String getAbizena() {
		return Abizena;
	}

	public void setAbizena(String abizena) {
		Abizena = abizena;
	}
	
	public String getPasahitza() {
		return Pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		Pasahitza = pasahitza;
	}

	public int getTelefonoa() {
		return Telefonoa;
	}

	public void setTelefonoa(int telefonoa) {
		Telefonoa = telefonoa;
	}

	public int getMota() {
		return Mota;
	}

	public void setMota(int mota) {
		Mota = mota;
	}

	public String getHE() {
		return HE;
	}

	public void setHE(String hE) {
		HE = hE;
	}
}