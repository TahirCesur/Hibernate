package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H02_Save {
	public static void main(String[] args) {

		// İMPORTLARI HİBERNATE OLANDAN yapmalıyız...

		// Veritabani baglanti ayarlarini Hibernate'e gostermeliyiz.Hibernate den import
		// etmeliyiz...

		// Configuration con = new
		// Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Sehir.class);
		// Ustteki url lere göre hibernate i (şifre isim vs) ayarla demek
		// Ustteki class ı göz önüne alalım
		// con objesinden bir oturum grubu olusturduk.
		// session açıyoruz işimiz bitince kapatıyoruz en altta
		// SessionFactory sf = con.buildSessionFactory();
		// Tum session ların anası, parent ı, Bunun altına bir sürü session
		// olusturabiliriz,transaction lada acarız..

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H01_Sehir.class)
				.buildSessionFactory();

		// Oturum grubundan bir oturumu başlattık.
		Session session = sf.openSession();
		// Acilan session icerisinde islemlere baslayabilmek icin Transaction aciyoruz.

		/*
		 * Transactionlar ile bir islem yarıda kaldıysa veya tam olarak tamamlanamadıysa tüm adımlar basa alınır.. 
		 * Nedeni ise veri ve islem güvenligi için onem arzeder.
		 * Kısacası ya hep ya hiç prensibine göre çalışır
		 */
		Transaction tx = session.beginTransaction();

		
		H01_Sehir sehir1 = new H01_Sehir(34, "Istanbul", 10000000);

		session.save(sehir1);
		
		session.save(new H01_Sehir(35, "Izmir", 2500000));
		// İslemlerin veritabanina aktarilmasi(yazmakta fayda var)
		tx.commit();
		
		// Oturumlarin kapatilmasi
		sf.close(); 
		// Bunu kapatınca parent kapamış olur, session açılamaz
		session.close();
		// Kapattıktan sonra islem yapılmaz, yapmak istersek tekrar session lar acmalıyız...
	}
}
