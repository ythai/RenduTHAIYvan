package com.exo2.Exercice2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "ecole", indexes = {
        @Index(name = "index_nom", columnList = "nom_ecole")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@BatchSize(size = 5)
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ecole_id")
    private Long id;

    @Column(name = "nom_ecole", nullable = false, length = 50)
    private String nom;

    @Column(name = "domaine_ecole", nullable = false, length = 50)
    private String domaine;

    @OneToMany(mappedBy = "ecole", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;
}
