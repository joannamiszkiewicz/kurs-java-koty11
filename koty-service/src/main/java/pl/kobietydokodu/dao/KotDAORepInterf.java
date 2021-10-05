package pl.kobietydokodu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kobietydokodu.domain.Kot;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface KotDAORepInterf extends JpaRepository<Kot, Long> {
   Optional<Kot> findById(Long id);
    public Kot save(Kot kot);
    List<Kot> findByNameAndCatOwner(String name, String catOwner);
    Kot findFirstByOrderByIdDesc();
    List<Kot> findByCatOwnerOrderByIdAsc(String catOwner);
    }

