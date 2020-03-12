package co.simplon.ocar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seller {

    @Id
    @SequenceGenerator(name = "seller_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seller_seq_id")
    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "seller")
    private List<Offer> offers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public List<Offer> getOffers() {
        return offers;
    }
}
