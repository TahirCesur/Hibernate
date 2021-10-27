package h7_crudIslemleri;

public class Runner {

	public static void main(String[] args) {

		// Crud işlemleri için gerekli olan class tan object in türetilmesi
		CrudMetodlar metod = new CrudMetodlar();

		metod.sessionFactoryOlustur();

		// metod.personelEkle("Gülcan", "kısakol", 7000);

		// metod.personelEkle("ipek", "bilgin", 3000);

		// metod.personelEkle("Basri", "konuskan", 7100);

		metod.personelSil(46L);
		metod.personelSil(47L);
		metod.tumPersoneliListele();

		metod.maasGuncelle(48L, 8000);

		metod.tumPersoneliListele();

		metod.maasGuncelle(32L, 8000);
	}

}