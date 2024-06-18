package com.exo2.Exercice2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "etudiant", indexes = {
        @Index(name = "index_nom", columnList = "nom"),
        @Index(name = "index_ecole", columnList = "ecole_id")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@BatchSize(size = 5)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etudiant_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String nom;
    @Column(nullable = false, length = 50)
    private String prenom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ecole_id")
    private Ecole ecole;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "etudiant_projet", joinColumns = @JoinColumn(name = "etudiant_id"), inverseJoinColumns = @JoinColumn(name = "projet_id"))
    private List<Projet> projets;
}
