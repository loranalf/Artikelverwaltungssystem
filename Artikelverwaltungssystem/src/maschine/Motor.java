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

import exceptions.UngueltigeEingabeException;
import java.util.Objects;

/**
 * Diese Klasse bildet den Motor der Maschine ab.
 * @author Alfred Loran
 * @version 1.00
 */
class Motor {
    private String bezeichnung;
    
    /**
     * Erzeugt ein Mototr - Objekt.
     * @param bezeichnung Die übergebene Bezeichnung.
     * @throws UngueltigeEingabeException Wirdgeworfen, wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    protected Motor(String bezeichnung) throws UngueltigeEingabeException {
        setBezeichnung(bezeichnung);
    }

    /**
     * Liefert die Bezeichnung.
     * @return die Bezeichnung
     * @since 1.00
     */
    protected String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Setzt die Bezeichnung.
     * @param bezeichnung Die übergebene Bezeichnung.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe der Bezeichnung weniger als 4 Zeichen enthält.
     * @since 1.00
     */
    private void setBezeichnung(String bezeichnung) throws UngueltigeEingabeException {
        if (bezeichnung == null) {
            throw new NullPointerException("Keine Bezeichnung vorhanden!");
        } else if (bezeichnung.length() < 4) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 4 Zeichen als Bezeichnung ein!");
        } else {
            this.bezeichnung = bezeichnung;
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return "Bezeichnung: " + getBezeichnung();
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
            throw new NullPointerException("Kein objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Motor)) {
            return false;
        } else {
            Motor motor = (Motor)object;
            return motor.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.bezeichnung);
        return hash;
    }
    
    
}