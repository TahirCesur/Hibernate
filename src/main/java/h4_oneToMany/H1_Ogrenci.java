package h4_oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "ogrenciler1")
public class H1_Ogrenci {

	@Id
	private int ogrId;

	private String ogrAd;

	private int ogrNot;

	@OneToMany(mappedBy = "ogrenci" , orphanRemoval = true, cascade =CascadeType.ALL, fetch = FetchType.EAGER)

	private List<H2_Kitap> kitapListesi = new ArrayList<>();

  
	// Parametresiz Cons...
	public H1_Ogrenci() {

	}
	
	// Parametreli Cons...
	public H1_Ogrenci(int ogrId, String ogrAd, int ogrNot) {
		this.ogrId = ogrId;
		this.ogrAd = ogrAd;
		this.ogrNot = ogrNot;
	}

	public int getOgrId() {
		return ogrId;
	}

	public void setOgrId(int ogrId) {
		this.ogrId = ogrId;
	}

	public String getOgrAd() {
		return ogrAd;
	}

	public void setOgrAd(String ogrAd) {
		this.ogrAd = ogrAd;
	}

	public int getOgrNot() {
		return ogrNot;
	}

	public void setOgrNot(int ogrNot) {
		this.ogrNot = ogrNot;
	}

	public List<H2_Kitap> getKitapListesi() {

		return kitapListesi;
	}

	public void setKitapListesi(List<H2_Kitap> kitapListesi) {
		this.kitapListesi = kitapListesi;
	}

	// toString
	@Override
	public String toString() {
		return "Ogrenci ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot + ", kitapListesi=" + kitapListesi
				+ "]";
	}

}