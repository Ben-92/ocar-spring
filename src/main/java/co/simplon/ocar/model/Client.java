//package co.simplon.ocar.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Client {
//
//    @Id
//    @SequenceGenerator(name = "client_seq_id", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq_id")
//    private Long id;
//
//    private String lastName;
//
//    private String firstName;
//
//    private String userName;
//
//    private String email;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "client")
//    private List<Offer> offers = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public List<Offer> getOffers() {
//        return offers;
//    }
//
//    public void setOffers(List<Offer> offers) {
//        this.offers = offers;
//    }
//}
