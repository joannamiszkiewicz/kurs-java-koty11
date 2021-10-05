package pl.kobietydokodu.service;

import pl.kobietydokodu.domain.Kot;

import java.util.List;

public class ListAndString {
    List<Kot> list;
    String string;

    public ListAndString(List<Kot> list, String string) {
        this.list = list;
        this.string = string;
    }

    public List<Kot> getList() {
        return list;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
