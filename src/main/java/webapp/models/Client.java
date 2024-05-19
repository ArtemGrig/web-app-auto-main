package webapp.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.*;
import java.util.*;

@Data
@Entity
@Builder
@Table(name = "clients")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Transient
    private int age;

    @NonNull

    @Column(unique = true)
    private String email;

    @NonNull
    @Column(unique = true)
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "clients_cars",
            joinColumns = { @JoinColumn(name = "client_id") },
            inverseJoinColumns = { @JoinColumn(name = "car_id") }
    )
    private Set<Car> cars;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder.Default
    private Boolean isActive = true;

    @Builder.Default
    private Boolean isBlocked = false;

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
