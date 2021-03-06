package h5_manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="arsalar")
public class H2_Arsalar {
	
	@Id
	private int arsaNo;
	
	private String sehir;
	
	@ManyToMany(mappedBy = "arsaListesi")

	// List
	private List<H1_Mirasyediler> mirasyediListesi=new ArrayList<>();

	// Parametresiz Cons..
	public H2_Arsalar() {}
	
	// Parametreli Cons..
	public H2_Arsalar(int arsaNo, String sehir) {
		
		this.arsaNo = arsaNo;
		this.sehir = sehir;
	}
	
	// Getters and Setters
	public int getArsaNo() {
		return arsaNo;
	}
	public void setArsaNo(int arsaNo) {
		this.arsaNo = arsaNo;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public List<H1_Mirasyediler> getMirasyediListesi() {
		return mirasyediListesi;
	}
	public void setMirasyediListesi(List<H1_Mirasyediler> mirasyediListesi) {
		this.mirasyediListesi = mirasyediListesi;
	}
	
	// toString
	@Override
	public String toString() {
		return "H2_Arsalar [arsaNo=" + arsaNo + ", sehir=" + sehir + "]";
	}


}