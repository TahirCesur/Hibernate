package h2_embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_SaveFetch {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(H1_Ogrenci.class)
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		// H2_Dersler ders1 = new H2_Dersler("Muzik","Matematik");
		// H1_Ogrenci ogrenci1 = new H1_Ogrenci(14, "Erdem Gocen", 76, ders1);
		// session.save(ogrenci1);

		// 18-19-20. satirlari asagida tek satırda da yapabiliyoruz...
		// session.save(new H1_Ogrenci(13, "Mehmet Ozbay", 83, new H2_Dersler("Beden","Fizik")));

		// Fetch islemi

		 System.out.println(session.get(H1_Ogrenci.class, 14)); // Bu sekilde tum bilgileri getiririz..

		 System.out.println(session.get(H1_Ogrenci.class, 13).getOgrAd()); // Sadece adini getiririz..

	     tx.commit();
	     sf.close();
	     session.close();

	}

}