package com.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "beds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String bedNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedStatus status;

    @OneToMany(mappedBy = "bed", cascade = CascadeType.ALL)
    private List<BedAllocation> allocations;
}