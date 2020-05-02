package co.simplon.ocar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Offer {

    @Id
    @SequenceGenerator(name = "offer_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_seq_id")
    private Long id;

    private LocalDateTime date;

    private Integer postalCode;

    private String carBrand;

    private String carModel;

    private String year;

    private String gearbox;

    private String outerColor;

    private boolean fourWheelDrive;

    private String description;

    private Integer price;

    // // TODO: 23/04/2020 change brand and model to entities 

    /* adding joining with user */
    @ManyToOne
//    @JsonBackReference
//    @JsonManagedReference
    @JsonIgnoreProperties("offers")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) /*PERSIST : when creating offer. When offer deleted, Jpa delete the relation table rows without need to tell Jpa*/
    @JoinTable(
            name = "offers_equipments",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<Equipment> equipments = new HashSet<>();

    @OneToMany(mappedBy = "offer", cascade = CascadeType.REMOVE) /*cascadeType.REMOVE when deleting an offer */
    private List<Image> images = new ArrayList<>();




    // Getters et setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getYear() {
        return year;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getOuterColor() {
        return outerColor;
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

//    public Client getClient() {
//        return client;
//    }


    public User getUser() {
        return user;
    }



    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public void setOuterColor(String outerColor) {
        this.outerColor = outerColor;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

//    public void setClient(Client client) {
//        this.client = client;
//    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", date=" + date +
                ", postalCode=" + postalCode +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", year='" + year + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", outerColor='" + outerColor + '\'' +
                ", fourWheelDrive=" + fourWheelDrive +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
