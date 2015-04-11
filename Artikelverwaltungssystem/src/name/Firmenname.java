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
package name;

import exceptions.UngueltigeEingabeException;
import java.util.Objects;

/**
 * Diese Klasse bildet den Firmennamen ab.
 * @author Alfred Loran
 * @version 1.00
 */
public class Firmenname extends Name {
    private static int firmenNameAnzahl;
    private int firmenNameNummer;
    private String firmenName;
    
    /**
     * Erzeugt ein Firmenname - Objekt.
     * @param firmenName Der übergebene Firmenname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    public Firmenname(String firmenName) throws UngueltigeEingabeException {
        setFirmenNameNummer(++firmenNameAnzahl);
        setFirmenName(firmenName);
    }

    /**
     * Liefert die Firmennamennummer.
     * @return die Firmennamennummer.
     * @since 1.00
     */
    private int getFirmenNameNummer() {
        return firmenNameNummer;
    }

    /**
     * Setzt die Firmennamennummer.
     * @param firmenNameNummer Dir übergebene Nummer.
     * @since 1.00
     */
    private void setFirmenNameNummer(int firmenNameNummer) {
        this.firmenNameNummer = firmenNameNummer;
    }

    /**
     * Liefert den Firmennamen.
     * @return den Firmennamen
     * @since 1.00
     */
    public String getFirmenName() {
        return firmenName;
    }

    /**
     * Setzt den Firmennamen.
     * @param firmenName Der übergebene Firmenname.
     * @since 1.00
     * @throws UngueltigeEingabeException Wird geworfen, wenn der Benutzer weniger als 4 Zeichen eingibt.
     * @since 1.00
     */
    private void setFirmenName(String firmenName) throws UngueltigeEingabeException {
        if (firmenName == null) {
            throw new NullPointerException("Kein Firmenname vorhanden!");
        } else if (firmenName.length() < 4) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 4 Zeichen als Firmenname ein!");
        } else {
            this.firmenName = firmenName;
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Firmennamennummer: " + getFirmenNameNummer() + "\n" + 
                "Firmenname: " + getFirmenName();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das zu vergleichende Objekt.
     * @return true, die Objekte sind gleich.
     *         false, die Objekte sind ungleich
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Firmenname)) {
            return false;
        } else {
            Firmenname fN = (Firmenname)object;
            return fN.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.firmenNameNummer;
        hash = 37 * hash + Objects.hashCode(this.firmenName);
        return hash;
    }        
}
