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
package mitarbeiter;

import adresse.Adresse;
import exceptions.UngueltigeEingabeException;
import java.util.Objects;
import name.Name;
import name.Personenname;

/**
 * Diese Klasse bildet einen Mitarbeiter ab.
 * Ein Mitarbeiter besitzt einen Namen und eine Adresse.
 * @author Alfred Loran
 * @version 1.00
 */
public class Mitarbeiter {
    private static int mitarbeiterAnzahl;
    private int mitarbeiterNummer;
    private Name personenName;
    private Adresse adresse;
    
    /**
     * Erzeugt ein Mitarbeiter - Objekt.
     * @param vorName Der übergebene Vorname.
     * @param zweitName Der übergebene Zweitname.
     * @param nachName Der übergebene Nachname.
     * @param strasse Die übergebene Strasse.
     * @param hausNummer Die übergebene Hausnummer.
     * @param ort Der übergebene Ort.
     * @param plz Die übergebene Postleitzahl.
     * @throws UngueltigeEingabeException  Wird geworfen, wenn die Eingaben des Benutzers fehlerhaft sind.
     * @since 1.00
     */
    public Mitarbeiter(String vorName, String zweitName, String nachName, String strasse, int hausNummer, String ort, String plz) throws UngueltigeEingabeException {
        setMitarbeiterNummer(++mitarbeiterAnzahl);
        setPersonenName(new Personenname(vorName, zweitName, nachName));
        setAdresse(new Adresse(strasse, hausNummer, ort, plz));
    }

    /**
     * Liefert die Mitarbeiternummer.
     * @return die Mitarbeiternummer
     * @since 1.00
     */
    private int getMitarbeiterNummer() {
        return mitarbeiterNummer;
    }

    /**
     * Setzt die Mitarbeiternummer.
     * @param mitarbeiterNummer Die übergebene Mitarbeiternummer.
     * @since 1.00
     */
    private void setMitarbeiterNummer(int mitarbeiterNummer) {
        this.mitarbeiterNummer = mitarbeiterNummer;
    }

    /**
     * Liefert das Personennamen - Objekt.
     * @return das Personennamen - Objekt
     * @since 1.00
     */
    public Name getPersonenName() {
        return personenName;
    }

    /**
     * Setzt das Personennamen - Objekt.
     * @param personenName Das übergebene Personennamen - Objekt.
     * @since 1.00
     */
    private void setPersonenName(Name personenName) {
        this.personenName = personenName;
    }

    /**
     * Liefert das Adresse - Objekt.
     * @return das Adresse - Objekt
     * @since 1.00
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setzt das Adressenen - Objekt.
     * @param adresse Das übergebene Adressen - Objekt.
     * @since 1.00
     */
    private void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  getPersonenName().toString() + "\n" + 
                getAdresse().toString();
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
        } else if (!(object instanceof Mitarbeiter)) {
            return false;
        } else {
            Mitarbeiter mitarbeiter = (Mitarbeiter)object;
            return mitarbeiter.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes.
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.mitarbeiterNummer;
        hash = 23 * hash + Objects.hashCode(this.personenName);
        hash = 23 * hash + Objects.hashCode(this.adresse);
        return hash;
    }       
}