package pl.kobietydokodu.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "koty")
public class Kot {
    @Id
    private Long id;
    private String name;
    private Date dateOfBirth;
    private float weight;
    private String catOwner;

//    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
public Kot() {}

/*   public Kot(String name, Date dateOfBirth, String weight, String catOwner) {
  };*/
public Kot(String name, Date dateOfBirth, float weight, String catOwner) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.catOwner = catOwner;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public float getWeight() {
        return weight;
    }

    public String getCatOwner() {
        return catOwner;
    }

    public String przedstawSie() {
        return "Nazywam się " + this.name + ". Moim opiekunem jest " + catOwner + ".";
    }
//    public String przedstawSiePelne() {
//        Date date2 = this.dateOfBirth;
//        return przedstawSie() + " Moja data urodzenia to "+ sdf1.format(date2) +". Ważę " + this.weight + "kg.";
//    }
//    public String toString() {
//        return(this.name + ", " + sdf1.format(this.dateOfBirth) + ", " + this.weight + ", " + this.catOwner);
//    }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setCatOwner(String catOwner) {
        this.catOwner = catOwner;
    }
}
