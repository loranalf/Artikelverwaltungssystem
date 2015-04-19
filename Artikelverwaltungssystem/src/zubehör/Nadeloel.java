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
import zubehör.artikelgruppe.Artikelgruppe;

/**
 * Diese Klasse bildet das Nadelöl ab.
 * Es besitzt einen Inhalt und eine Beschreibung.
 * @author Alfred Loran
 * @version 1.00
 */
class Nadeloel extends Zubehoer {
    private double inhalt;      
    
    /**
     * Erzeugt ein Nadelöl - Objekt.
     * @param artikelGruppe Die übergebne Artikelgruppe.
     * @param artikelName Der übergebne Artikelname.
     * @param inhalt Der übergebene Inhalt.
     * @param beschreibung Die übergebene Beschreibung.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers fehlerhaft ist.
     * @since 1.00
     */
    protected Nadeloel(Artikelgruppe artikelGruppe, String artikelName, double inhalt, String beschreibung) throws UngueltigeEingabeException {
        super(artikelGruppe, artikelName, beschreibung);
        setInhalt(inhalt);
    }
    
    /**
     * Liefert den Inhalt des Nadelöls.
     * @return den Inhalt.
     * @since 1.00
     */
    protected double getInhalt() {
        return inhalt;
    }
    
    /**
     * Setzt den Inhalt.
     * @param inhalt Der übergebne Inhalt.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Zahl kleiner der gleich 0 ist.
     * @since 1.00
     */
    private void setInhalt(double inhalt) throws UngueltigeEingabeException {
        if (inhalt <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine Zahl größer 0 ein!");
        } else {
            this.inhalt = inhalt;
        }
    }
            
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  super.toString() + "\n" + 
                "Inhalt: " + getInhalt() + "\n" +
                "Beschreibung: " + super.getBeschreibung();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das zu vergleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich.
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Nadeloel)) {
            return false;
        } else {
            Nadeloel no = (Nadeloel)object;
            return no.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.inhalt) ^ (Double.doubleToLongBits(this.inhalt) >>> 32));
        return hash;
    }            
}