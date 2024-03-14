package com.example.exceptionhandling.pokemon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "national_no", unique = true)
    @NotNull
    private Integer nationalNo;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private List<PokemonType> type;

    @Column(name = "weight")
    @Max(1_000_000)
    @Min(0)
    private Double weight;

    @Column(name = "height")
    @Max(1_000_000)
    @Min(0)
    private Double height;
}
