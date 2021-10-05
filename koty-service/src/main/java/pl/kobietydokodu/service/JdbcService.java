package pl.kobietydokodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kobietydokodu.dao.JdbcKotDAO;
import pl.kobietydokodu.domain.Kot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class JdbcService implements KotyServiceInterf{

    @Autowired
    private JdbcKotDAO jdbcKotDAO;

    @Override
    public List<Kot> getListSortedByIdASC() {
        List<Kot> koty = new ArrayList<>();
        jdbcKotDAO.getList().stream()
                .sorted(Comparator.comparingLong(Kot::getId))
                .forEach(koty::add);
        return koty;
    }

    @Override
    public List<Kot> getListSortedByIdDESC() {
        List<Kot> koty = new ArrayList<>();
        jdbcKotDAO.getList().stream()
                .sorted(Comparator.comparingLong(Kot::getId).reversed())
                .forEach(koty::add);
        return koty;
    }

    @Override
    public List<Kot> getListSortedByNameASC() {
        List<Kot> koty = new ArrayList<>();
        jdbcKotDAO.getList().stream()
                .sorted(Comparator.comparing(Kot::getName))
                .forEach(koty::add);
        return koty;
    }

    @Override
    public List<Kot> getListByCatOwner(String person) {
        return jdbcKotDAO.getListByOwner(person);
    }

    @Override
    public Kot getKotById(Integer id) {
        return jdbcKotDAO.getKotById(id);
    }

    @Override
    public Long getMaxId() {
        return jdbcKotDAO.getMaxId();
    }

    @Override
    public boolean isKotNew(String name, String person) {
        return jdbcKotDAO.isCatNew(name, person);
    }

    @Override
    public ListAndString dodajKota(Kot kot) {
        List<Kot> koty = new ArrayList<>();
        String message = new String();
        ListAndString kotymess = new ListAndString(koty,message);
        if (!jdbcKotDAO.isCatNew(kot.getName(), kot.getCatOwner())) {
            kotymess.setString("Twój Kot już jest w Bazie Kotów, sprawdź:");
            jdbcKotDAO.getList().stream()
                    .sorted(Comparator.comparing(Kot::getName))
                    .forEach(koty::add);
        } else {
            jdbcKotDAO.dodajKota(kot);
            kotymess.setString("Po dodaniu Twojego kota");
            jdbcKotDAO.getList().stream()
                    .sorted(Comparator.comparingLong(Kot::getId).reversed())
                    .forEach(koty::add);
        }
        return kotymess;
    }
}
