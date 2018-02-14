package fr.esipe.ing2.common.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tweet")
public class Tweet implements Serializable {

    public Tweet(String auteur, String libelle){
        this.auteur = auteur;
        this.auteur = libelle;
    }
    public Tweet(){
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="libelle")
    private String libelle;

    @NotEmpty
    @Column(name="auteur")
    private String auteur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    @Override
    public String toString() {
        return "Tweet [id=" + id + ", libelle=" + libelle+"]";
    }


}
