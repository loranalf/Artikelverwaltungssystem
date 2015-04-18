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
import java.util.Objects;
import zubehör.artikelgruppe.Artikelgruppe;

/**
 * Diese Klasse bildet die abstrakte Klasse Zubehör ab.
 * Diese besitzt die artikelAnzahl und die Artikelnummer.
 * @author Alfred Loran
 * @since 1.00
 */
abstract class Zubehoer {
    private static int anzahlZubehoer;
    private int zubehoerNummer;
    private String artikelName;
    private String artikelNummer;
    private Artikelgruppe artikelGruppe;
    
    /**
     * Erzeugt ein Zubehoer - Objekt mit den übergebenen Parametern.
     * @param artikelGruppe Die übergebne Artikelgruppe.
     * @param artikelName Der übergebene Artikelname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    protected Zubehoer(Artikelgruppe artikelGruppe, String artikelName) throws UngueltigeEingabeException {
        setZubehoerNummer(++anzahlZubehoer);
        setArtikelGruppe(artikelGruppe);
        setArtikelName(artikelName);
        setArtikelNummer();
    }

    /**
     * Liefert die Zubehörnummer.
     * @return die Zubehörnummer
     * @since 1.00
     */
    protected int getZubehoerNummer() {
        return zubehoerNummer;
    }

    /**
     * Setzt die Zubehörnummer.
     * @param zubehoerNummer Die übergebene Zubehörnummer.
     * @since 1.00
     */
    private void setZubehoerNummer(int zubehoerNummer) {
        this.zubehoerNummer = zubehoerNummer;
    }

    /**
     * Liefert den Artikelnamen.
     * @return den Artikelnamen
     * @since 1.00
     */
    protected String getArtikelName() {
        return artikelName;
    }

    /**
     * Setzt den Atikelnamen.
     * @param artikelName Der übergebne Artikelname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers nicht mindestens 3 Zeichen enthält.
     * @since 1.00
     */
    private void setArtikelName(String artikelName) throws UngueltigeEingabeException {
        if (artikelName == null) {
            throw new NullPointerException("Kein Artikelname vorhanden!");
        } else if (artikelName.length() < 3) {
            throw new UngueltigeEingabeException("Bitte geben Sie einen Artikelnamen mit mindestens 3 zeichen ein!");
        } else {
            this.artikelName = artikelName;
        }
    }

    /**
     * Liefert die Artikelnummer.
     * @return die Artikelnummer
     * @since 1.00
     */
    protected String getArtikelNummer() {
        return artikelNummer;
    }

    /**
     * Generiert und setzt die Artikelnummer.
     * @since 1.00
     */
    private void setArtikelNummer() {
        String artN = getZubehoerNummer() + getArtikelName().substring(0, 2) + getArtikelGruppe().getArtikelGruppenNummer() + "-" + 100;
        this.artikelNummer = artN;
    }

    /**
     * Liefert die Artikelgruppe.
     * @return die Artikelgruppe
     * @since 1.00
     */
    protected Artikelgruppe getArtikelGruppe() {
        return artikelGruppe;
    }

    /**
     * Setzt die Aritkelgruppe.
     * @param artikelGruppe Die übergebene Aritkelgruppe.
     * @since 1.00
     */
    private void setArtikelGruppe(Artikelgruppe artikelGruppe) {
        if (artikelGruppe == null) {
            throw new NullPointerException("Keine Artikelgruppe vorhanden!");
        } else {
            this.artikelGruppe = artikelGruppe;
        }
    }
    
    /**
     * Liefer die Daten des Artikels.
     * @return die Daten des Artikels.
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Artikelnummer: " + getArtikelNummer() + "\n"+ 
                "Artikelname: " + getArtikelName() + "\n" + 
                "Artikelgruppe: " + getArtikelGruppe().getArtikelGruppenNummer();
    }
    
    /**
     * Vergleicht zwei Objekte miteinadner.
     * @param object Das zu verggleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich.
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Zubehoer)) {
            return false;
        } else {
            Zubehoer z = (Zubehoer)object;
            return z.hashCode() == this.hashCode();
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
        hash = 97 * hash + this.zubehoerNummer;
        hash = 97 * hash + Objects.hashCode(this.artikelName);
        hash = 97 * hash + Objects.hashCode(this.artikelNummer);
        hash = 97 * hash + Objects.hashCode(this.artikelGruppe);
        return hash;
    }            
}