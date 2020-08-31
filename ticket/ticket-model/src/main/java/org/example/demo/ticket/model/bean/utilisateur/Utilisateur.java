package org.example.demo.ticket.model.bean.utilisateur;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Embeddable
public class Utilisateur {

	@Id
    private Integer id;
    private String nom;
    private String prenom;


    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String pNom) {
        nom = pNom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String pPrenom) {
        prenom = pPrenom;
    }
}
