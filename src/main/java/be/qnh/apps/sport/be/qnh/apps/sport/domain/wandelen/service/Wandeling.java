package be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Wandeling implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String plaats;
    private String kledij;

    public Wandeling() {
    }

    public Wandeling(String plaats, String kledij) {
        this.plaats = plaats;
        this.kledij = kledij;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getKledij() {
        return kledij;
    }

    public void setKledij(String kledij) {
        this.kledij = kledij;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Wandeling op plaats: " +plaats+"met aangepaste kledij: "+kledij;
    }
}
