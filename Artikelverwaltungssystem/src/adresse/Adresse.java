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
package adresse;

import com.mysql.jdbc.Connection;
import datenbankverbindung.DatenbankVerbindung;
import exceptions.UngueltigeEingabeException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * Diese Klasse bildet die Adresse ab. Eine Adresse besteht aus der Strasse der
 * Hausnummer, dem ort und der Postleitzahl.
 * @author Alfred Loran
 * @version 1.00
 */
public class Adresse {
    private static int adressenAnzahl;
    private int adressenNummer;
    private DatenbankVerbindung dbv;
    private String strasse;
    private int hausNummer;
    private String ort;
    private String postLeitZahl;
    
    /**
     * Erzeugt ein Adresse - Objekt mit den übergebenen Parametern.
     * @param strasse Die übergebene Strasse.
     * @param hausNummer Die übergebene Hausnummer.
     * @param ort Der übergebene Ort.
     * @param postLeitZahl Die übergebene Postleitzahl.
     * @throws UngueltigeEingabeException Wird geworfen, wenn einer der Eingaben des Benutzers ungültig ist.
     * @since 1.00
     */
    public Adresse(String strasse, int hausNummer, String ort, String postLeitZahl) throws UngueltigeEingabeException {
        setDatenbankVerbindung();
        setAdressenNummer(++adressenAnzahl);
        setStrasse(strasse);
        setHausNummer(hausNummer);
        setOrt(ort);
        setPostLeitZahl(postLeitZahl);
        eintragInDieDatenbank(strasse, hausNummer, ort, postLeitZahl);
    }

    /**
     * Liefert die Adressennummer.
     * @return die Adressennummer.
     * @since 1.00
     */
    public int getAdressenNummer() {
        return adressenNummer;
    }

    /**
     * Setzt die Adressennnummer. Diese gilt als eindeutiger Identifikator für die Adresse.
     * @param adressenNummer Die übergebene Adressnummer.
     * @since 1.00
     */
    private void setAdressenNummer(int adressenNummer) {
        this.adressenNummer = adressenNummer;
    }

    /**
     * Liefert die Strasse.
     * @return die Strasse.
     * @since 1.00
     */
    public String getStrasse() {
        return strasse;
    }

    /**
     * Setzt die Strasse.
     * @param strasse Die übergebene Strasse.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die übergebene Strasse weniger als 4 Zeichen enthält.
     * @since 1.00
     */
    private void setStrasse(String strasse) throws UngueltigeEingabeException {
        if (strasse == null) {
            throw new NullPointerException("Keine Strasse vorhanden!");
        } else if (strasse.length() < 4) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 4 Zeichen als Strasse ein!");
        } else {
            this.strasse = strasse;
        }
    }

    /**
     * Liefert die Hausnummer.
     * @return die Hausnummer
     * @since 1.00
     */
    public int getHausNummer() {
        return hausNummer;
    }

    /**
     * Setzt die Hausnummer.
     * @param hausNummer Die übergebene Hausnummer.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des benutzer kleiner oder gleich 0 ist.
     * @since 1.00
     */
    private void setHausNummer(int hausNummer) throws UngueltigeEingabeException {
        if (hausNummer <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine positive Zahl ein!");
        } else {
            this.hausNummer = hausNummer;
        }
    }

    /**
     * Liefert den Ort.
     * @return den Ort
     * @since 1.00
     */
    public String getOrt() {
        return ort;
    }

    /**
     * Setzt den Ort
     * @param ort Der übergebene Ort.
     * @throws UngueltigeEingabeException Wird geworfen, wenn der Benutzer weniger als 3 Zeichen als ort eingibt.
     * @since 1.00
     */
    private void setOrt(String ort) throws UngueltigeEingabeException {
        if (ort == null) {
            throw new NullPointerException("Kein Ort vorhanden!");
        } else if (ort.length() < 3) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 3 Zeichen als Ort ein!");
        } else {
            this.ort = ort;
        }
    }
        
    /**
     * Liefert die Postleitzahl.
     * @return die Postleitzahl.
     * @since 1.00
     */
    public String getPostLeitZahl() {
        return postLeitZahl;
    }

    /**
     * Setzt die Postleitzahl.
     * @param postLeitZahl Die übergebene Postleitzahl.
     * @throws UngueltigeEingabeException
     * @since 1.00
     */
    private void setPostLeitZahl(String postLeitZahl) throws UngueltigeEingabeException {
        if (postLeitZahl == null) {
            throw new NullPointerException("Keine Postleitzahl vorhanden!");
        } else if (postLeitZahl.length() != 5) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine 5-stellige Zahl ein!");
        } else if (!(postLeitZahl.matches("\\d+"))) {
            throw new UngueltigeEingabeException("Bitte geben Sie nur Zahlen ein!");
        } else {
            this.postLeitZahl = postLeitZahl;
        }
    }
    
    /**
     * Erzeugt die Datenbankverbindung.
     * @since 1.00
     */
    private void setDatenbankVerbindung() {
        dbv = new DatenbankVerbindung();
    }
    
    private void eintragInDieDatenbank(String strasse, int hausNummer, String ort, String postLeitZahl) {
        try {
            Connection conn = dbv.verbindungAufbauen();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into adresse(idadresse,strasse,hausnummer,ort,postleitzahl) values (" + getAdressenNummer() + ",\"" + strasse + "\"," + hausNummer +",\"" + ort + "\",\"" + postLeitZahl + "\");");
            dbv.verbindungTrennen();
        } catch(SQLException fehler) {
            System.err.println(fehler.getMessage());
        }
    }
    
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Adressnummer: " + getAdressenNummer() + "\n" +
                "Strasse: " + getStrasse() + "\n" + 
                "Hausnummer: " + getHausNummer() + "\n" +
                "Ort: " + getOrt() + "\n" + 
                "Postleitzahl: " + getPostLeitZahl();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das zu vergleichende Objekt.
     * @return true, wenn die Objekte gleich sind. 
     *         false, wenn die Objekte ungleich sind.
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Adresse)) {
            return false;
        } else {
            Adresse adresse = (Adresse)object;
            return adresse.hashCode() == this.hashCode();
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
        hash = 89 * hash + this.adressenNummer;
        hash = 89 * hash + Objects.hashCode(this.strasse);
        hash = 89 * hash + this.hausNummer;
        hash = 89 * hash + Objects.hashCode(this.postLeitZahl);
        return hash;
    }        
}