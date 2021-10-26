package h5_manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("unused") // sari cizgiler gitsin diye...

@Entity
@Table(name="mirasyediler")
public class H1_Mirasyediler {
	
	@Id
	private int tc;
	
	private String isim;
	
	private int yas;
	
	
	@ManyToMany
	@JoinTable(
			name="H1_Mrsydlr_H2_Arslr",
			joinColumns = {@JoinColumn(name="m_id")},
			inverseJoinColumns= {@JoinColumn(name="a_id")}
			)
	
	// List
	private List<H2_Arsalar> arsaListesi=new ArrayList<>();


	// Parametresiz Cons..
	public H1_Mirasyediler() {}
	
	// Parametreli Cons..
	public H1_Mirasyediler(int tc, String isim, int yas) {

		this.tc = tc;
		this.isim = isim;
		this.yas = yas;
	}
	
	// Getters and Setters
	public int getTc() {
		return tc;
	}
	public void setTc(int tc) {
		this.tc = tc;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public int getYas() {
		return yas;
	}
	public void setYas(int yas) {
		this.yas = yas;
	}
	public List<H2_Arsalar> getArsaListesi() {
		return arsaListesi;
	}
	public void setArsaListesi(List<H2_Arsalar> arsaListesi) {
		this.arsaListesi = arsaListesi;
	}
	
	// toString
	@Override
	public String toString() {
		return "H1_Mirasyediler [tc=" + tc + ", isim=" + isim + ", yas=" + yas + ", arsaListesi=" + arsaListesi + "]";
	}

}