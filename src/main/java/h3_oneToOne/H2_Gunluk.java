package h3_oneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gunlukler")
public class H2_Gunluk {
	
	@Id
	private int id;
	
	private String yazilar;
	
	// Birlestirmeyi burada yapıyoruz...OneToOne
	@OneToOne
	@JoinColumn(name="kisi_id")
	// Obje olusturduk
	private H1_Kisi kisi;
	
	// Bos Constructor
	public H2_Gunluk() {};

	// Parametreli Constructor
	public H2_Gunluk(int id, String yazilar) {
		this.id = id;
		this.yazilar = yazilar;
	}

	// Getter and Setter olusturduk...
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYazilar() {
		return yazilar;
	}

	public void setYazilar(String yazilar) {
		this.yazilar = yazilar;
	}

	public H1_Kisi getKisi() {
		return kisi;
	}

	public void setKisi(H1_Kisi kisi) {
		this.kisi = kisi;
	}

	// toString olusturduk...
	@Override
	public String toString() {
		return "H2_Gunluk [id=" + id + ", yazilar=" + yazilar + ", kisi=" + kisi + "]";
	}
	
	
	

}