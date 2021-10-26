package h5_manyToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Mirasyediler.class)
				.addAnnotatedClass(H2_Arsalar.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		// Soru ; no=22 olan arsayı getir

		System.out.println(session.get(H2_Arsalar.class, 22));

		// Soru ; adı=Muhittin olan mirasyediyi getir (arsalarını da görmek istiyorum HQL ile)

		Object mrs1 = session.createQuery("FROM H1_Mirasyediler m WHERE m.isim='muhittin  topalak'").getSingleResult();
		System.out.println(mrs1);

		// Soru ; Arsa yerlerini getir

		List<Object[]> liste = session.createQuery("SELECT a.sehir FROM H2_Arsalar a").getResultList();

		System.out.println(liste);

		// Soru ; mirasyedi isimlerini getir
		System.out.println(session.createQuery("SELECT m.isim FROM H1_Mirasyediler m").getResultList());

		tx.commit();
	}

}