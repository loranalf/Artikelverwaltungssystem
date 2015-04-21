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
package maschine;

import java.util.Objects;

/**
 * Diese Klasse bildet die Stickfeldgroesse ab.
 * @author Alfred Loran
 * @since 1.00
 */
class Stickfeldgroesse {
    private String groessenBeschreibung;
    
    protected Stickfeldgroesse(StickfeldGroessenEnum stickfeldgroesse) {
        setGroessenBeschreibung(stickfeldgroesse);
    }
    
    protected String getGroessenBeschreibung() {
        return groessenBeschreibung;
    }
    
    
    private void setGroessenBeschreibung(StickfeldGroessenEnum stickfeldgroesse) {
        if (stickfeldgroesse == null) {
            throw new NullPointerException("Die Stickfeldgroesse wurde nicht definiert!");
        } else {
            if (stickfeldgroesse.equals(StickfeldGroessenEnum.NORMAL)) {
                this.groessenBeschreibung = "353 * 500";
            } else if (stickfeldgroesse.equals(StickfeldGroessenEnum.GROSSERKAPPENRAHMEN)) {
                this.groessenBeschreibung = "75 * 360";
            } else if (stickfeldgroesse.equals(StickfeldGroessenEnum.KLEINERKAPPENRAHMEN)) {
                this.groessenBeschreibung = "83 * 180";
            } else if (stickfeldgroesse.equals(StickfeldGroessenEnum.FREIRAHMEN)) {
                this.groessenBeschreibung = "360 * 500";
            } else if (stickfeldgroesse.equals(StickfeldGroessenEnum.ZYLINDRISCHERRAHMEN)) {
                this.groessenBeschreibung = "180 * 60";
            }
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return "Stickfeldgröße: " + getGroessenBeschreibung();
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
        } else if (!(object instanceof Stickfeldgroesse)) {
            return false;
        } else {
            Stickfeldgroesse stickfeldGroesse = (Stickfeldgroesse)object;
            return stickfeldGroesse.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefer den hashCode des Objektes.
     * @return den hashCode des Objjektes.
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.groessenBeschreibung);
        return hash;
    }        
}