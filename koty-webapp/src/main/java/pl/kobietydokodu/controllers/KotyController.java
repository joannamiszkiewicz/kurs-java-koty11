package pl.kobietydokodu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kobietydokodu.domain.Kot;
import pl.kobietydokodu.dto.KotDTO;
import pl.kobietydokodu.dto.KotDTOService;
import pl.kobietydokodu.service.ListAndString;
import pl.kobietydokodu.service.RepService;

import javax.validation.Valid;

@Controller
public class KotyController {

//   one to be chosen:
@Autowired
//protected JpaService service;
// protected JdbcService service;
 protected RepService service;

@Autowired
 protected KotDTOService kotDTOService;

    @RequestMapping("/start")
    public String metoda(Model model) {
    model.addAttribute("message","Możesz dodać nowego kota, wyświetlić listę kotów i informacje o wybranym kocie");
    return "glowny";
}
    @RequestMapping("/listakotow")
    public String listaKotow(Model model) {
                model.addAttribute("koty", service.getListSortedByIdASC());
//                model.addAttribute("koty", kotDAORepInterf.findAll(Sort.by(Sort.Direction.ASC, "id")));
        return "listakotow";
    }

    @RequestMapping("/listakotowosoby-{osoba}")
    public String listaKotowOsoby(@PathVariable("osoba") String osoba, Model model) {
        model.addAttribute("koty", service.getListByCatOwner(osoba));
//        model.addAttribute("koty", kotDAORepInterf.findByCatOwnerOrderByIdAsc(osoba));
        model.addAttribute("osoba", osoba);
        return "listakotowosoby";
    }

    @RequestMapping("/kot-{id}")
    public String pokazKota(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("kot", service.getKotById(id));
//        model.addAttribute("kot", kotDAORepInterf.findById(id.longValue()).get());
        return "jeden";
    }
    @RequestMapping(value = "/dodajkota", method = RequestMethod.GET)
    public String dodajkota(Model model) {
    model.addAttribute("blank", new KotDTO());
    return "formularz";
    }
    @RequestMapping(value = "/dodajkota", method = RequestMethod.POST)
    public String dodajkota(@ModelAttribute("blank") @Valid KotDTO blank, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formularz";
        } else {
            Kot cat=new Kot();

            cat = kotDTOService.formAsObject(blank, cat, service.getMaxId() + 1);

            ListAndString listmessage = service.dodajKota(cat);
            model.addAttribute("msg",listmessage.getString());
            model.addAttribute("koty",listmessage.getList());

return "listakotow";
//następuje tylko wywołanie widoku przy atrybutach nadanych powyżej
        }
    }
}
