/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenm05_uf2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pep
 * 
 * L'objectiu de la classe Avaluador és avaluar Estudiants.
 * 
 * Es tracta de validar els seus mètodes amb la llibreria JUnit
 * 
 * 1. Tests de tots els mètodes públics i correcció de possible errors (fins a 5 punts)
 * 
 * 2. 15 ests parametritzats de cada mètode public (3 punts)
 * 
 * 3. Tests @Rule de timeout i control d'excepcions de tots els mètodes publics (2 punts)
 * 
 */
public class Avaluador {

    private double notaMaxima = 10.0;
    private double notaMinima = 0.0;
    private double notaSupera = 5.0;

    public Avaluador(double notaMaxima, double notaMinima, double notaSupera) throws Exception {
        if (notaMinima >= notaMaxima) {
            throw new Exception("Nota mínima " + notaMinima + " no pot ser major que nota màxima " + notaMaxima);
        }

        if (notaSupera < notaMinima || notaSupera > notaMaxima) {
            throw new Exception("Nota supera" + notaSupera + " no pot ser menor que nota mínima " + notaMinima + " ni major que nota màxima " + notaMaxima);
        }

        this.notaMaxima = notaMaxima;
        this.notaMinima = notaMinima;
        this.notaSupera = notaSupera;
    }

    public Avaluador() {
    }

    /**
     * 
     * Aquest mètode ha de retornar la mitjana de les tres notes parcials 
     * d'un estudiant si totes són iguals o superiors a notaSupera.
     * 
     * @param estudiant
     * @return la nota mitjana si totes les notes són iguals o superiors a
     * notaSupera
     * @throws Exception 
     */
    public double mitjanaSiSupera(Estudiant estudiant) throws Exception {
        double sumaNotes = 0;

        if (estudiant == null) {
            throw new Exception("Estudiant no pot ser null");
        }
        
        if (estudiant.getPrimerParcial() >= notaSupera && estudiant.getTercerParcial() >= notaSupera && estudiant.getSegundoParcial() >= notaSupera) {
        	sumaNotes = estudiant.getPrimerParcial()  + estudiant.getSegundoParcial() + estudiant.getTercerParcial();
        }
        
        return sumaNotes / 3;
    }

    /**
     * 
     * Aquest mètode ha de retornar la mitja de totes les notes parcials d'un
     * estudiant
     * 
     * @param estudiant
     * @return la nota mitjana
     * @throws Exception 
     */
    public double mitjana(Estudiant estudiant) throws Exception {
        double sumaNotes = 0;

        if (estudiant == null) {
            throw new Exception("Estudiant no pot ser null", new IllegalAccessException());
        }

        sumaNotes = estudiant.getPrimerParcial()
                + estudiant.getSegundoParcial()
                + estudiant.getTercerParcial();

        return sumaNotes / 3;
    }

    /**
     * 
     * Aquest mètode ha de retornar l'estudiant que té una nota mitjana més 
     * alta
     * 
     * @param estudiants
     * @return l'estudiant amb nota mitjana més alta
     */
    public Estudiant millorEstudiantPerNotaMitjana(Estudiant[] estudiants) throws Exception {
        final int n = estudiants.length;
        Estudiant millorEstudiant = null;
        double millorNota = 0;
        
        for (int i = 0; i <= n - 1; i++) {
            try {
                double nota = mitjana(estudiants[i]);
                if (nota > millorNota) {
                    millorNota = nota;
                    millorEstudiant = estudiants[i];
                }
            } catch (Exception ex) {
                Logger.getLogger(Avaluador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return millorEstudiant;
    }

}
