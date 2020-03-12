//package co.simplon.ocar.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//public class Car {
//
//    @Id
//    @SequenceGenerator(name = "car_seq_id", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq_id")
//    private Long id;
//
//    private String year;
//
//    private String gearbox;
//
//    private String outerColor;
//
//    private boolean fourWheelDrive;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "car")
//    private List<Offer> offers = new ArrayList<>();
//
//
//    @ManyToMany
//    @JoinTable(
//            name = "cars_equipments",
//            joinColumns = @JoinColumn(name = "car_id"),
//            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
//    private Set<Equipment> equipments = new HashSet<>();
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public String getGearbox() {
//        return gearbox;
//    }
//
//    public String getOuterColor() {
//        return outerColor;
//    }
//
//    public boolean isFourWheelDrive() {
//        return fourWheelDrive;
//    }
//
//    public List<Offer> getOffers() {
//        return offers;
//    }
//
//    public Set<Equipment> getEquipments() {
//        return equipments;
//    }
//}
