package org.example.demo.ticket.model.bean.projet;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;


/**
 * Objet métier représentant un Projet
 *
 * @author lgu
 */
@Entity
public class Projet {

    // ==================== Attributs ====================
	@Id
    private Integer id;
    private String nom;
    private Date dateCreation;
    private Boolean cloture;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName="responsable_id", insertable=false, updatable=false)
    private Utilisateur responsable;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Projet() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Projet(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================
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
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date pDateCreation) {
        dateCreation = pDateCreation;
    }
    public Boolean getCloture() {
        return cloture;
    }
    public void setCloture(Boolean pCloture) {
        cloture = pCloture;
    }
    public Utilisateur getResponsable() {
        return responsable;
    }
    public void setResponsable(Utilisateur pResponsable) {
        responsable = pResponsable;
    }


    // ==================== Méthodes ====================
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("id=").append(id)
            .append(vSEP).append("nom=\"").append(nom).append('"')
            .append(vSEP).append("dateCreation=").append(dateCreation)
            .append(vSEP).append("cloture=").append(cloture)
            .append("}");
        return vStB.toString();
    }
}
