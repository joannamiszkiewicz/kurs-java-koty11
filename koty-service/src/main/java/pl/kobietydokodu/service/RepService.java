package pl.kobietydokodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.kobietydokodu.dao.KotDAORepInterf;
import pl.kobietydokodu.domain.Kot;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepService implements KotyServiceInterf{

    @Autowired
    private KotDAORepInterf repKotDAO;

    @Override
    public List<Kot> getListSortedByIdASC() {
        return repKotDAO.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Kot> getListSortedByIdDESC() {
        return repKotDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<Kot> getListSortedByNameASC() {
        return repKotDAO.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Kot> getListByCatOwner(String person) {
        return repKotDAO.findByCatOwnerOrderByIdAsc(person);
    }

    @Override
    public Kot getKotById(Integer id) {
        return repKotDAO.findById(id.longValue()).get();
    }

    @Override
    public Long getMaxId() {
        return repKotDAO.findFirstByOrderByIdDesc().getId();
    }

    @Override
    public boolean isKotNew(String name, String person) {
        return repKotDAO.findByNameAndCatOwner(name, person).isEmpty();
    }

    @Override
    public ListAndString dodajKota(Kot kot) {
        List<Kot> koty = new ArrayList<>();
        String message = new String();
        ListAndString kotymess = new ListAndString(koty, message);
        if (!repKotDAO.findByNameAndCatOwner(kot.getName(), kot.getCatOwner()).isEmpty()) {
            kotymess.setString("Twój Kot już jest w Bazie Kotów, sprawdź:");
            koty.addAll(repKotDAO.findAll(Sort.by(Sort.Direction.ASC, "name")));
        } else {
            repKotDAO.save(kot);
            kotymess.setString("Po dodaniu Twojego kota");
            koty.addAll(repKotDAO.findAll(Sort.by(Sort.Direction.DESC, "id")));
        }
        return kotymess;
    }
}
