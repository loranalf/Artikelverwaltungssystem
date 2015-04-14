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

/**
 * Diese Klasse bildet den Namen ab. Hierbei handelt es sich um eine abstrakte Basisklasse.
 * @author Alfred Loran
 * @version 1.00
 */
public abstract class Name {
    private static int anzahlNamen;
    private int nameNummer;
    
    /**
     * Erzeugt ein Name - Objekt.
     * @param nummer Die übergebene Nummer.
     * @since 1.00
     */
    public Name(int nummer) {
        setNummer(++anzahlNamen);
    }
    
    /**
     * Setzt die Nummer.
     * @param nummer Die übergebene Nummer.
     * @since 1.00
     */
    private void setNummer(int nummer) {
        this.nameNummer = nummer;
    }
    
    /**
     * Liefert die Nummer.
     * @return die Nummer
     * @since 1.00
     */
    public int getNummer() {
        return nameNummer;
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Namenummer: " + getNummer();
    }
    
    /**
     * Vergleicht zwei Objekte
     * @param object Das zu vergleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Name)) {
            return false;
        } else {
            Name name = (Name)object;
            return name.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes.
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.nameNummer;
        return hash;
    }        
}