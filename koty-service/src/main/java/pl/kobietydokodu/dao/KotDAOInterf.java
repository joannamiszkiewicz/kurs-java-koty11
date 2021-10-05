package pl.kobietydokodu.dao;

import pl.kobietydokodu.domain.Kot;

public interface KotDAOInterf {

    public Kot getKotById(Integer id);

    public boolean dodajKota(Kot kot);
}
