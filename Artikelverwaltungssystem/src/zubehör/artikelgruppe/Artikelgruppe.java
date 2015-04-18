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
package zubehör.artikelgruppe;

import java.util.Objects;

/**
 * Diese Klasse bildet die Artikelgruppe ab.
 * @author Alfred Loran
 * @version 1.00
 */
public class Artikelgruppe {
    private static int anzahlArtikelGruppen;
    private int artikelGruppenNummer;
    private String artikelGruppenName;
    
    /**
     * Erzeugt ein Artikelgruppe - Objekt mit dem übergebenen Parameter.
     * @param artikelGruppenName Der übergebene Artikelgruppenname.
     * @since 1.00
     */
    public Artikelgruppe(String artikelGruppenName) {
        setArtikelGruppenNummer(++anzahlArtikelGruppen);
        setArtikelGruppenName(artikelGruppenName);
    }
    
    /**
     * Liefert die Artikelgruppennummer.
     * @return die Artikelgruppennummer
     * @since 1.00
     */
    public int getArtikelGruppenNummer() {
        return artikelGruppenNummer;
    }
    
    /**
     * Setzt die Aritkelgruppennummer.
     * @param nummer Die Artikelgruppennummer.
     * @since 1.00
     */
    private void setArtikelGruppenNummer(int nummer) {
        this.artikelGruppenNummer = nummer;
    }
    
    /**
     * Liefert den Artikelgruppennamen.
     * @return den Artikelgruppennamen
     * @since 1.00
     */
    public String getArtikelGruppenName() {
        return artikelGruppenName;
    }
    
    /**
     * Setzt den Artikelgruppennamen.
     * @param name Der übergebene Artikelgruppenname
     * @since 1.00
     */
    private void setArtikelGruppenName(String name) {
        if (name == null) {
            throw new NullPointerException("Kein Artikelgruppenname vorhanden!");
        } else {
            this.artikelGruppenName = name;
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Artikelgruppennummer: " + getArtikelGruppenNummer() + "\n" + 
                "Artikelgruppenname: " + getArtikelGruppenName();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das zu vrgleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich.
     * @since 1.00s
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Artikelgruppe)) {
            return false;
        } else {
            Artikelgruppe ag = (Artikelgruppe)object;
            return ag.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.artikelGruppenNummer;
        hash = 37 * hash + Objects.hashCode(this.artikelGruppenName);
        return hash;
    }
}