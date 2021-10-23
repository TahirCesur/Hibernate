package h3_oneToOne;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H2_Gunluk.class)
				.addAnnotatedClass(H1_Kisi.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		// Soru ; id=101 olan kisinin bilgilerini getir ve sorgula...

		System.out.println(session.get(H1_Kisi.class, 101));

		// Soru ; id=12 olan gunlugun bilgilerini getiriniz...

		System.out.println(session.get(H2_Gunluk.class, 12));

		System.out.println();

		// Soru ; kisiler ve gunlukler tablolarindaki ortak olan kayitlarini,
		// kisi adi, yazilar kismi, kisi yasını sorgulayiniz

		// Bunu hibernate ile tek satirda halledebiliriz ama simdi SQL ile yapacagiz..
		// Bunu yapma nedenimiz sql i hatırlama...

		String sorgu = "SELECT k.kisiAd  , g.yazilar , k.kisiYas "
				+ "FROM kisiler k INNER JOIN gunlukler g ON k.kisiId=g.kisi_id ";

		List<Object[]> sonucList = session.createSQLQuery(sorgu).getResultList();

		for (Object[] w : sonucList) {
			System.out.println(Arrays.toString(w));
		}

		// Soru ; Gunluk tablosundan ogrenci adini gunluk adini kayıtlarin ogrenci yasini getir hql ile...

		String sorgu1 = "SELECT k.kisiAd,  g.yazilar, k.kisiYas "
				+ " FROM H1_Kisi k JOIN H2_Gunluk g  ON k.kisiId=g.kisi";

		List<Object[]> sonucList1 = session.createQuery(sorgu1).getResultList();

		for (Object[] w1 : sonucList1) {
			System.out.println("hql " + Arrays.toString(w1));
		}

		tx.commit();
		session.close();
		sf.close();

	}

}