package pl.kobietydokodu.service;

import pl.kobietydokodu.domain.Kot;

import java.util.List;

public interface KotyServiceInterf {

    public List<Kot> getListSortedByIdASC();
    public List<Kot> getListSortedByIdDESC();
    public List<Kot> getListSortedByNameASC();
    public List<Kot> getListByCatOwner(String person);
    public Kot getKotById(Integer id);
    public Long getMaxId();
    public boolean isKotNew(String name, String person);
    public ListAndString dodajKota(Kot kot);
}
