package pl.kobietydokodu.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;
import pl.kobietydokodu.domain.Kot;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Configuration
@ImportResource("classpath:beans.xml")
@Repository
public class JpaKotDAO implements KotDAOInterf{

    @PersistenceContext
    private EntityManager entityManagerFactory;

    @Override
    @Transactional
    public Kot getKotById(Integer id) {
        return entityManagerFactory.find(Kot.class, Long.valueOf(id));
    }

    @Transactional
    public Long getMaxId() {
        Query query2 = entityManagerFactory.createQuery("select max(k.id) from Kot k");
        Long maxId = (Long) query2.getSingleResult();
        return maxId;
    }

    @Override
    @Transactional
    public boolean dodajKota(Kot kot) {
        boolean isCatSaved = false;
           entityManagerFactory.persist(kot);
           if (entityManagerFactory.contains(kot)) {
               System.out.println("Kot został dodany");
               isCatSaved=true;
           }
//            kotek = entityManagerFactory.merge(kot);
//        }
        return isCatSaved;
    }

    @Transactional
    public List<Kot> getList() {
        Query query = entityManagerFactory.createQuery("from Kot k");
        List<Kot> koty;
        return koty = query.getResultList();
    }

    @Transactional
    public List<Kot> getListByOwner(String person) {
        String sel = "from Kot k where k.catOwner = :koci_catOwner";
        Query query1 = entityManagerFactory.createQuery(sel);
        query1.setParameter("koci_catOwner", person);
        List<Kot> koty = query1.getResultList();
        return koty;
    }

    @Transactional
    public boolean isCatNew(String name, String person) {
        boolean isCatNew = true;
        String sel = "from Kot k where k.name = :koci_name and k.catOwner = :koci_catOwner";
        Query query1 = entityManagerFactory.createQuery(sel);
        query1.setParameter("koci_name", name);
        query1.setParameter("koci_catOwner", person);
        List<Kot> koty = query1.getResultList();
        if (!koty.isEmpty()) {
            isCatNew = false;
        }
        return isCatNew;
    }
}
