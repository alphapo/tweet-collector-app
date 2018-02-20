package fr.esipe.ing2.common.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tweet")
public class Tweet implements Serializable {

    public Tweet(Long id, int follewersCount, String email, String tag, String auteur, String libelle){
        this.id = id;
        this.follewersCount = follewersCount;
        this.email = email;
        this.tag = tag;
        this.auteur = auteur;
        this.libelle = libelle;
    }

    public Tweet() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="follewersCount")
    private int follewersCount;

    @Column(name="email")
    private String email;

    @Column(name="tag")
    private String tag;

    @NotEmpty
    @Column(name="auteur")
    private String auteur;

    @NotEmpty
    @Column(name="libelle")
    private String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFollewersCount() {
        return follewersCount;
    }

    public void setFollewersCount(int follewersCount) {
        this.follewersCount = follewersCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
        return "Tweet{" +
                "id=" + id +
                ", follewersCount=" + follewersCount +
                ", email='" + email + '\'' +
                ", tag='" + tag + '\'' +
                ", auteur='" + auteur + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
