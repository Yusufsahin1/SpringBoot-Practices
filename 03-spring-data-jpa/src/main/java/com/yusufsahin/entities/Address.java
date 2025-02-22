package com.yusufsahin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "description")
    private String description;

    // This entity does not own the relationship.
    // The "address" field in the User entity manages the relationship.
    @OneToOne(mappedBy = "address") // Inverse side / Non-owning side
    private Customer customer;
}
