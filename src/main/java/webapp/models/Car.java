package webapp.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import webapp.enums.Transmission;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "cars")
public class Car implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    private String marka;

    private String model;

    private Transmission transmission;

    private int year;

    @ManyToMany(mappedBy = "cars")
    private Set<Client> clients;

}
