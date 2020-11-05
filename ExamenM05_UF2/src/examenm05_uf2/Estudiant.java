/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenm05_uf2;

import java.util.Objects;

/**
 *
 * @author pep
 */
public class Estudiant {
    
        private String nom;
        private double primerParcial;
        private double segundoParcial;
        private double tercerParcial;

    public Estudiant(String nom, double primerParcial, double segundoParcial, double tercerParcial) {
        this.nom = nom;
        this.primerParcial = primerParcial;
        this.segundoParcial = segundoParcial;
        this.tercerParcial = tercerParcial;
    }
    
    public String getNombre(){
        return this.nom;
    }
    
    public double getPrimerParcial() {
        return primerParcial;
    }

    public double getSegundoParcial() {
        return segundoParcial;
    }

    public double getTercerParcial() {
        return tercerParcial;
    }

    @Override
    public String toString() {
        return "Estudiant{" + "nom=" + this.nom + ", primerParcial=" + this.primerParcial + ", segundoParcial=" + this.segundoParcial + ", tercerParcial=" + this.tercerParcial + '}';
    }

    /**
     * Aquest mètode retorna true si dos estudians són iguals: mateix nom i 
     * notes. Altrament retorna false
     * @param obj
     * @return true si dos estudiants són iguals. false si dos estudiants són
     * diferents
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        
        if (obj == null) {
            return false;
        }
   
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Estudiant other = (Estudiant) obj;

        if (Double.doubleToLongBits(this.primerParcial) != Double.doubleToLongBits(other.primerParcial)) {
            return false;
        }
        if (Double.doubleToLongBits(this.segundoParcial) != Double.doubleToLongBits(other.segundoParcial)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tercerParcial) != Double.doubleToLongBits(other.tercerParcial)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }

        return true;
    }
    
    
    
}
