package co.simplon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel implements Serializable {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int phone;
    private String adresse;
    private int numberEtoile;
    private int numberChambre;
    private int numberPersonne;
    private boolean selected;
    private boolean available;
    private String photoName;
    @ManyToOne
    private Ville ville;
}