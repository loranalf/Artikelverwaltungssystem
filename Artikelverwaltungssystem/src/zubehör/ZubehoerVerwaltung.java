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

import java.util.ArrayList;
import zubehör.artikelgruppe.Artikelgruppe;

/**
 * Diese Klasse bildet die Zubehörverwaltung ab.
 * @author Alfred Loran
 * @version 1.00
 */
public class ZubehoerVerwaltung {    
    private ArrayList<Klebespray> klebeSprayListe;
    private ArrayList<Lagerfett> lagerFettListe;
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
    
    public void fuegeKlebeSprayHinzu(Artikelgruppe artikelGruppe, String artikelName, double inhalt, String beschreibung) {
        if (artikelGruppe == null) {
            throw new NullPointerException("Keine Artikelgruppe vorhanden!");
        }
    }
}