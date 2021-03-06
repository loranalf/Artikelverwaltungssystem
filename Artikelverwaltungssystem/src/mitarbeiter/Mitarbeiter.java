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
import datenbankverbindung.DatenbankVerbindung;
import exceptions.UngueltigeEingabeException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import name.Firmenname;
import name.Name;
import passwort.Passwort;

/**
 * Diese Klasse bildet einen Mitarbeiter ab.
 * Ein Mitarbeiter besitzt einen Namen und eine Adresse.
 * @author Alfred Loran
 * @version 1.00
 */
public class Mitarbeiter {
    private static int mitarbeiterAnzahl;
    private int mitarbeiterNummer;
    private DatenbankVerbindung dbv = null;
    private Name personenName;
    private Adresse adresse;
    private Passwort passwort;
    private Firmenname firmenName;
    
    /**
     * Erzeugt ein Mitarbeiter - Objekt.
     * @param firmenName Der übergebene Firmenname.
     * @param vorName Der übergebene Vorname.
     * @param zweitName Der übergebene Zweitname.
     * @param nachName Der übergebene Nachname.
     * @param strasse Die übergebene Strasse.
     * @param hausNummer Die übergebene Hausnummer.
     * @param ort Der übergebene Ort.
     * @param plz Die übergebene Postleitzahl.
     * @param passwort Das übergebene Passwort
     * @throws UngueltigeEingabeException  Wird geworfen, wenn die Eingaben des Benutzers fehlerhaft sind.
     * @since 1.00
     */
    public Mitarbeiter(Firmenname firmenName, String vorName, String zweitName, String nachName, String strasse, int hausNummer, String ort, String plz, String passwort) throws UngueltigeEingabeException {
        setDatenbankverbindung();
        setMitarbeiterNummer(++mitarbeiterAnzahl);
        setFirmenName(firmenName);
        setPersonenName(new Name(vorName, zweitName, nachName));
        setAdresse(new Adresse(strasse, hausNummer, ort, plz));
        setPaswort(new Passwort(passwort));        
        eintragInDatenbank();
    }

    /**
     * Liefert die Mitarbeiternummer.
     * @return die Mitarbeiternummer
     * @since 1.00
     */
    public int getMitarbeiterNummer() {
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
     * Liefert den Firmenname.
     * @return den Firmenname
     * @since 1.00
     */
    public Firmenname getFirmenName() {
        return firmenName;
    }
    
    /**
     * Setzt den Firmennamen.
     * @param firmenName Der übergebene Firmenname
     * @since 1.00
     */
    private void setFirmenName(Firmenname firmenName) {
        if (firmenName == null) {
            throw new NullPointerException("Kein Firmenname vorhanden!");
        } else {
            this.firmenName= firmenName;
        }
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
        if (personenName == null) {
            throw new NullPointerException("Kein Personenename vorhanden!");
        } else {
            this.personenName= personenName;
        }
    }

    /**
     * Setzt die Datenbankverbindung.
     * @since 1.00
     */
    private void setDatenbankverbindung() {
        dbv= new DatenbankVerbindung();
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
     * Setzt das Adressen - Objekt.
     * @param adresse Das übergebene Adressen - Objekt.
     * @since 1.00
     */
    private void setAdresse(Adresse adresse) {
        if (adresse == null) {
            throw new NullPointerException("Keine Adresse vorhanden!");
        } else {
            this.adresse = adresse;
        }
    }
    
    /**
     * Diese Methode dient dem Eintrag der Daten in die Datenbank.
     * @since 1.00
     */
    private void eintragInDatenbank() {
        try {
            Connection conn = dbv.verbindungAufbauen();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into mitarbeiter(idmitarbeiter,idname,idadresse,idpasswort,idfirmenname) values(" + getMitarbeiterNummer() + "," + getPersonenName().getNameNummer() +"," + getAdresse().getAdressenNummer() + "," + getPasswort().getPasswortNummer() + "," + getFirmenName().getFirmenNameNummer() + ");");
            dbv.verbindungTrennen();
        } catch(SQLException fehler) {
            System.err.println(fehler.getMessage());
        }
    }
    
    /**
     * Liefert das Passwort - Objekt.
     * @return das Passwort - Objekt
     * @since 1.00
     */
    public Passwort getPasswort() {
        return passwort;
    }
    
    /**
     * Setzt das Passwort - Objekt.
     * @param passwort Das übergebene Objekt.
     * @since 1.00
     */
    private void setPaswort(Passwort passwort) {
        if (passwort == null) {
            throw new NullPointerException("Kein Passwort vorhanden!");
        } else {
            this.passwort = passwort;
        }
    }        
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Mitarbeiternummer: " + getMitarbeiterNummer() + "\n" + 
                getPersonenName().toString() + "\n" + 
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