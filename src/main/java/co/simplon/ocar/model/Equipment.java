package co.simplon.ocar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipment {

    @Id
    @SequenceGenerator(name = "equipment_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipment_seq_id")
    private Long id;

    private String type;

    private String label;

    @JsonIgnore
    @ManyToMany(mappedBy = "equipments")
    private Set<Offer> offers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
