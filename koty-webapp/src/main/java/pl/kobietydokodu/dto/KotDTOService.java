package pl.kobietydokodu.dto;

import org.springframework.stereotype.Service;
import pl.kobietydokodu.domain.Kot;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class KotDTOService {

    public Kot formAsObject(KotDTO form, Kot kot, Long id) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        kot.setName(form.getName());
        try {
            kot.setDateOfBirth(sdf.parse(form.getDateOfBirth()));
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        kot.setWeight(form.getWeight());
        kot.setCatOwner(form.getCatOwner());
        System.out.println("utworzony został nowy cat na podstawie formularza: ");
        System.out.println(kot.przedstawSie());
        kot.setId(id);
    return kot;
    }
}
