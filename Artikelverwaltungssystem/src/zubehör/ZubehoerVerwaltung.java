/*
 * Copyright (C) 2015 Alfred Loran
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package zubehör;

import exceptions.UngueltigeEingabeException;
import java.util.ArrayList;
import java.util.Objects;
import zubehör.artikelgruppe.Artikelgruppe;

/**
 * Diese Klasse bildet die Zubehörverwaltung ab.
 * @author Alfred Loran
 * @version 1.00
 */
public class ZubehoerVerwaltung {    
    private ArrayList<Klebespray> klebeSprayListe;
    private ArrayList<Lagerfett> lagerFettListe;
    private ArrayList<Nadeln> nadelListe;
    private ArrayList<Nadeloel> nadelOelListe;
    private ArrayList<Spruehoel> spruehOelListe;
    private ArrayList<Vlies> vliesListe;
    
    /**
     * Erzeugt ein ZubehoerVerwaltung - Objekt. 
     * Dies erzeugt wiederum intern seine Listen.
     * @since 1.00
     */
    public ZubehoerVerwaltung() {
        setKlebeSprayListe();
        setLagerFettListe();
        setNadelListe();
        setNadelOelListe();
        setSpruehOelListe();
        setVliesListe();
    }
    
    /**
     * Liefert die Klebesprayliste
     * @return die Klebesprayliste
     * @since 1.00
     */
    public ArrayList getKlebeSprayListe() {
        return klebeSprayListe;
    }
    
    /**
     * Initialisiert die KlebeSprayListe.
     * @since 1.00
     */
    private void setKlebeSprayListe() {
        this.klebeSprayListe = new ArrayList<>();
    }
    
    /**
     * Liefert die LagerFettListe
     * @return die LagerFettListe
     * @since 1.00
     */
    public ArrayList getLagerFettListe() {
        return lagerFettListe;
    }
    
    /**
     * Initialisiert die LagerfettListe.
     * @since 1.00
     */
    private void setLagerFettListe() {
        this.lagerFettListe = new ArrayList<>();
    }
    
    /**
     * Liefert die NadelOelListe.
     * @return die NadelOelListe
     * @since 1.00
     */
    public ArrayList getNadelOelListe() {
        return nadelOelListe;
    }
    
    /**
     * initialisiert die NadelOelListe.
     * @since 1.00
     */
    private void setNadelOelListe() {
        this.nadelOelListe = new ArrayList<>();
    }
    
    /**
     * Liefert die SpruehOelListe.
     * @return die SpruehOelListe
     * @since 1.00
     */
    public ArrayList getSpruehOelListe() {
        return spruehOelListe;
    }
    
    /**
     * Initialisiert  die SpruehOelListe.
     * @since 1.00
     */
    private void setSpruehOelListe() {
        this.spruehOelListe = new ArrayList<>();
    }
    
    /**
     * Liefert die VliesListe.
     * @return die VliesListe
     * @since 1.00
     */
    public ArrayList getVliesListe() {
        return vliesListe;
    }
    
    /**
     * Initialisiert die VliesListe.
     * @since 1.00
     */
    private void setVliesListe() {
        this.vliesListe = new ArrayList<>();
    }
    
    /**
     * Liefert die NadelListe.
     * @return die NadelListe
     * @since 1.00
     */
    public ArrayList getNadelListe() {
        return nadelListe;
    }
    
    /**
     * Initialisiert die NadelListe.
     * @since 1.00
     */
    private void setNadelListe() {
        this.nadelListe = new ArrayList<>();
    }
    
    /**
     * Fügt das KlebeSpray der Liste hinzu.
     * @param artikelGruppe Die übergebene Artikelgruppe.
     * @param artikelName Der Übergebene Artikelname.
     * @param inhalt Der übergebene Inhalt.
     * @throws UngueltigeEingabeException Wird geworfen, wenn eine der Eingaben des Benutzers ungültig ist.
     * @since 1.00
     */
    public void fuegeKlebeSprayHinzu(Artikelgruppe artikelGruppe, String artikelName, double inhalt) throws UngueltigeEingabeException {
        if (artikelGruppe == null) {
            throw new NullPointerException("Keine Artikelgruppe vorhanden!");
        } else {
            Klebespray klebeSpray = new Klebespray(artikelGruppe, artikelName, inhalt);
            klebeSprayListe.add(klebeSpray);
        }
    }
    
    /**
     * Fügt das Lagerfett der Lagerfettliste hinzu.
     * @param artikelGruppe Die übergebene Artikelgruppe.
     * @param artikelName Der übergebene Artikelname.
     * @param inhalt Der übergebene Inhalt.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    public void fuegeLagerfettHinzu(Artikelgruppe artikelGruppe, String artikelName, double inhalt) throws UngueltigeEingabeException {
        if (artikelGruppe == null) {
            throw new NullPointerException("Keine Artikelgruppe vorhanden!");
        } else {
            Lagerfett lagerFett = new Lagerfett(artikelGruppe, artikelName, inhalt);
            lagerFettListe.add(lagerFett);
        }
    }
    
    /**
     * Diese Methode fügt der Nadelliste eine Nadel hinzu.
     * @param artikelgruppe Die übergebene Artikelgruppe
     * @param artikelName Der übergebene Artikelname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    public void fuegeNadelnHinzu(Artikelgruppe artikelgruppe, String artikelName) throws UngueltigeEingabeException {
        if (artikelgruppe == null) {
            throw new NullPointerException("Keine Artikelgruppe vorhanden!");
        } else {
            Nadeln nadel = new Nadeln(artikelgruppe, artikelName);
            nadelListe.add(nadel);
        }
    }
    
    /**
     * Diese Methode fügt der Naelölliste ein Nadelöl hinzu.
     * @param artikelGruppe Die übergebene Artikelgruppe.
     * @param artikelName Der übergebene Artikelname
     * @param inhalt Der übergebene Inhalt.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Einagbe des Benutzers ungültig ist.
     * @since 1.00
     */
    public void fuegeNadelOelHinzu(Artikelgruppe artikelGruppe, String artikelName, double inhalt) throws UngueltigeEingabeException {
        if (artikelGruppe == null) {
            throw new NullPointerException("Keine Artikelgruppe vorhanden!");
        } else {
            Nadeloel nadelOel = new Nadeloel(artikelGruppe, artikelName, inhalt);
            nadelOelListe.add(nadelOel);
        }
    }
    
    
    public void fuegeSpruehOelHinzu(Artikelgruppe artikelGruppe, String artikelName, double inhalt) throws UngueltigeEingabeException {
        if (artikelGruppe == null) {
            throw new NullPointerException("Keine Artikelgruppe vorhanden!");
        } else {
            Spruehoel spruehOel = new Spruehoel(artikelGruppe, artikelName, inhalt);
            spruehOelListe.add(spruehOel);
        }
    }
    
    /**
     * Fügt Vlies der Vliesliste hinzu.
     * @param artikelGruppe Die übergebene Artikelgruppe.
     * @param artikelName Der übergebene Artikelname.
     * @param gramm Die übergebene Grammzahl.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingaben des Benutzer ungültig sind.
     * @since 1.00
     */
    public void fuegeVliesHinzu(Artikelgruppe artikelGruppe, String artikelName, double gramm) throws UngueltigeEingabeException {
        if (artikelGruppe == null) {
            throw new NullPointerException("Keine Artikelgruppe vorhanden!");
        } else {
            Vlies vlies = new Vlies(artikelGruppe, artikelName, gramm);
            vliesListe.add(vlies);
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        String ausgabe = "***********************************************\nKlebesprayliste: \n\n";
        
        for (Klebespray k: klebeSprayListe) {
            ausgabe += "\n" + k.toString() + "\n";
        }
        
        ausgabe+= "\nVliesliste: \n";
        for (Vlies v : vliesListe) {
            ausgabe += "\n" + v.toString() + "\n";
        }
        
        ausgabe +="\nNadelliste: \n";
        for (Nadeln n : nadelListe) {
            ausgabe += "\n" + n.toString() + "\n";
        }
                
        ausgabe += "\nNadelölliste: \n";
        for (Nadeloel no: nadelOelListe) {
            ausgabe += "\n" + no.toString() + "\n";
        }
        
        ausgabe += "\nSprühölliste: \n";
        for (Spruehoel sp : spruehOelListe) {
            ausgabe += "\n" + sp.toString() + "\n";
        }
        
        ausgabe += "\nLagerfettliste: \n";
        for (Lagerfett l : lagerFettListe) {
            ausgabe += "\n" + l.toString() + "\n";
        }
        ausgabe += "***********************************************";
        
        return ausgabe;
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object das zu vergleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich.
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if ( object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof ZubehoerVerwaltung)) {
            return false;
        } else {
            ZubehoerVerwaltung zbv = (ZubehoerVerwaltung)object;
            return this.hashCode() == zbv.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.klebeSprayListe);
        hash = 41 * hash + Objects.hashCode(this.lagerFettListe);
        hash = 41 * hash + Objects.hashCode(this.nadelListe);
        hash = 41 * hash + Objects.hashCode(this.nadelOelListe);
        hash = 41 * hash + Objects.hashCode(this.spruehOelListe);
        hash = 41 * hash + Objects.hashCode(this.vliesListe);
        return hash;
    }        
}