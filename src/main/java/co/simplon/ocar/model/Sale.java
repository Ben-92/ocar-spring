package co.simplon.ocar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sale {

    @Id
    @SequenceGenerator(name = "sale_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_seq_id")
    private Long id;

    private LocalDateTime date;

    //Price after negociation between buyer and seller
    private Integer finalPrice;

    //commission rate applicable to finalPrice
    private Double commissionRate;

    //user who has bought
    @ManyToOne
    @JsonIgnoreProperties("sales")
    private User user;


    @JsonIgnore
    @OneToOne
    @JoinTable( name="sale_offer",
                joinColumns = { @JoinColumn(name="sale_id", referencedColumnName = "id")},
                inverseJoinColumns = { @JoinColumn(name="offer_id", referencedColumnName = "id")})
    private Offer offer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
