package h7_crudIslemleri;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personeller")
public class Personel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // id nin sırasıyla artmasını sağlayan anotasyon
	private long id;
	
	private String ad;
	
	private String soyad;
	
	private int maas;

	// Parametresiz Cons..
	public Personel() {}
	
	// Parametreli Cons..
	public Personel(String ad, String soyad, int maas) {
	
		this.ad = ad;
		this.soyad = soyad;
		this.maas = maas;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public int getMaas() {
		return maas;
	}

	public void setMaas(int maas) {
		this.maas = maas;
	}

	// toString
	@Override
	public String toString() {
		return "Personel [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", maas=" + maas + "]";
	}


}