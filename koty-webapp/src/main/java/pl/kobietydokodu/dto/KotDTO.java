package pl.kobietydokodu.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;


public class KotDTO {

    @NotBlank(message="To pole nie może być puste")
    private String name;

    @NotBlank(message="To pole nie może być puste")
    @Pattern(regexp = "20[0-9]{2}\\.(0[1-9]|1[0-2])\\.(0[1-9]|[1-2][0-9]|3[0-1])", message="Format daty 20yy.mm.dd")
    private String dateOfBirth;

    @NotZeroWeight
    private Float weight;

    @NotBlank(message="To pole nie może być puste")
    private String catOwner;

    public KotDTO() {}
    public KotDTO(String name, String dateOfBirth, Float weight, String catOwner) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.catOwner = catOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getCatOwner() {
        return catOwner;
    }

    public void setCatOwner(String catOwner) {
        this.catOwner = catOwner;
    }
}
