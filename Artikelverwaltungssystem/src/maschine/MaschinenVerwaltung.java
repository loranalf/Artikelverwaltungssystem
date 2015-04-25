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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Diese Klasse hält die Maschinen und gibt dieser Zur nutzung an andere Pakete weiter.
 * @author Alfred Loran
 * @since 1.00
 */
public class MaschinenVerwaltung {
    private ArrayList<Maschine> maschinenListe;
    private ArrayList<Maschine> einKopfMaschinenListe;
    private ArrayList<Maschine> zweiBisAchtKopfMaschinenListe;
    private ArrayList<Maschine> zehnUndMehrKopfMaschinenListe;
    
    /**
     * Erzeugt eine MaschinenVerwaltung - Objekt.
     * @since 1.00
     */
    public MaschinenVerwaltung() {
        setMaschinenListe();
        setEinKopfMaschinenListe();
        setZweiBisAchtKopfMaschine();
        setZehnUndMehrKopfMaschine();
    }                
    
    /**
     * Liefert die MaschinenListe.
     * @return die MaschinenListe
     * @since 1.00
     */
    public ArrayList getMaschinenListe() {
        return maschinenListe;
    }
    
    /**
     * Liefert die EinkopfMaschinenListe.
     * @return die EinkopfMaschinenListe
     * @since 1.00
     */
    public ArrayList getEinKopfMaschinenListe() {
        return einKopfMaschinenListe;
    }
    
    /**
     * Liefert die ZweiBisAchtKopfMaschinenListe.
     * @return die ZweiBisAchtKopfMaschinenListe
     * @since 1.00
     */
    public ArrayList getZweiBisAchtKopfMaschinenListe() {
        return zweiBisAchtKopfMaschinenListe;
    }
    
    /**
     * Liefert die ZehnBisMehrKopfMaschinenListe.
     * @return die ZehnBisMehrKopfMaschinenListe
     * @since 1.00
     */
    public ArrayList getZehnBisMehrKopfMaschinenListe() {
        return zehnUndMehrKopfMaschinenListe;
    }
    
    /**
     * Setzt die MaschinenListe.
     * @since 1.00
     */
    private void setMaschinenListe() {
        this.maschinenListe = new ArrayList<>();
    }
    
    /**
     * Setzt die EinKopfMaschinenListe.
     * @since 1.00
     */
    private void setEinKopfMaschinenListe() {
        this.einKopfMaschinenListe = new ArrayList<>();
    }
    
    /**
     * Setzt die ZweiBisAchtKopfListe.
     * @since 1.00
     */
    private void setZweiBisAchtKopfMaschine() {
        this.zweiBisAchtKopfMaschinenListe = new ArrayList<>();
    }
    
    /**
     * Setzt die ZehnUndMehrKopfMaschine
     * @since 1.00
     */
    private void setZehnUndMehrKopfMaschine() {
        this.zehnUndMehrKopfMaschinenListe = new ArrayList<>();
    }
    
    /**
     * Diese Methode generiert eine Maschine und fügt diese der Maschinenliste hinzu.
     * Zusätzlich wird die Maschine je nach Anzahl der Köpfe der jeweiligen Liste hinzugefügt.
     * @param maschinenName Der übergebene Maschinenname.
     * @param anzahlKoepfe Die übergebene Anzahl Köpfe.
     * @param anzahlNadeln Die übergebene Anzahl der Nadeln.
     * @param beschreibung Die übergebene Motorbeschreibung.
     * @param gewicht Das übergebene Gewicht.
     * @param speicher Der übergebene maximale Speicher.
     * @param stichlaenge Die übergebene Stichlänge.
     * @param drehzahl Die übergebene maximale Drehzahl.
     * @param usbSteckplaetze Die übergebene Anzahl der USB - Steckplätze.
     * @param monitorGroesse Die übergebene Monitorgröße.
     * @param groesseStickfeld Die übergebene Größe des Stickfeldes.
     * @param elektro Die Beschreibung der Voltzahl.
     * @throws UngueltigeEingabeException Wird geworfen, wenn eine der Eingaben des Benutzers ungültig ist.
     * @since 1.00
     */
    public void fuegeMaschineHinzu(String maschinenName, int anzahlKoepfe, 
                                   int anzahlNadeln, String beschreibung, float gewicht, float speicher,
                                   String stichlaenge, int drehzahl, int usbSteckplaetze, int monitorGroesse,
                                   int groesseStickfeld, String elektro) throws UngueltigeEingabeException {
        Kopf kopf = null;        
        if (anzahlNadeln == 1) {
            kopf = new Kopf(anzahlKoepfe, NadelAnzahlEnum.EINS);
        } else if (anzahlNadeln == 9) {
            kopf = new Kopf(anzahlKoepfe, NadelAnzahlEnum.NEUN);
        } else if (anzahlNadeln == 12) {
            kopf = new Kopf(anzahlKoepfe, NadelAnzahlEnum.ZWOELF);
        } else if (anzahlNadeln == 15) {
            kopf = new Kopf(anzahlKoepfe, NadelAnzahlEnum.FUENFZEHN);
        } else {
            throw new UngueltigeEingabeException("Bitte geben Sie 1,9,12 oder 15 ein!");
        }         
        
        Motor motor = new Motor(beschreibung);        
        Daten daten = new Daten(gewicht, drehzahl, stichlaenge, drehzahl, anzahlKoepfe, monitorGroesse);
        
        Stickfeldgroesse stickfeldgroesse = null; 
        if (groesseStickfeld == 1) {
            stickfeldgroesse = new Stickfeldgroesse(StickfeldGroessenEnum.NORMAL);
        } else if (groesseStickfeld == 2) {
            stickfeldgroesse = new Stickfeldgroesse(StickfeldGroessenEnum.GROSSERKAPPENRAHMEN);
        } else if (groesseStickfeld == 3) {
            stickfeldgroesse = new Stickfeldgroesse(StickfeldGroessenEnum.KLEINERKAPPENRAHMEN);
        } else if (groesseStickfeld == 4) {
            stickfeldgroesse = new Stickfeldgroesse(StickfeldGroessenEnum.FREIRAHMEN);
        } else if (groesseStickfeld == 5) {
            stickfeldgroesse = new Stickfeldgroesse(StickfeldGroessenEnum.ZYLINDRISCHERRAHMEN);
        } else {
            throw new UngueltigeEingabeException("Bitte geben Sie eine Zahl zwischen 1 und 5 ein!");
        } 
        
        Maschine maschine = new Maschine(maschinenName, kopf, motor, daten, stickfeldgroesse, elektro);        
        maschinenListe.add(maschine);
        
        if (maschine.getKopf().getAnzahlKoepfe() == 1) {
            einKopfMaschinenListe.add(maschine);
        } else if (maschine.getKopf().getAnzahlKoepfe() >= 2 && maschine.getKopf().getAnzahlKoepfe() <= 8) {
            zweiBisAchtKopfMaschinenListe.add(maschine);
        }else if (maschine.getKopf().getAnzahlKoepfe() >= 10) {
            zehnUndMehrKopfMaschinenListe.add(maschine);
        }        
    }      
    
    /**
     * Entfernt die Maschine aus der Liste.
     * @param maschinenName Die übergebene Maschinename.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers nicht vorhanden ist.
     * @since 1.00
     */
    public void entferneMaschine(String maschinenName) throws UngueltigeEingabeException {
        if (maschinenName == null) {
            throw new NullPointerException("Keine Maschinename vorhanden!");
        } else {
            if (maschinenListe.isEmpty()) {
                throw new UngueltigeEingabeException("Die Maschinenliste ist leer!");
            } else {
                Iterator<Maschine> masch = maschinenListe.iterator();
                boolean istVorhanden = false;

                while (masch.hasNext()) {                    
                    if (masch.next().getMaschinenName().equals(maschinenName)) {
                        masch.remove();
                        istVorhanden = true;
                    }
                }

                if (istVorhanden == false) {
                    throw new UngueltigeEingabeException("Dieser Maschinenname ist nicht vorhanden!");
                }
            }
        }
    }
    
    /**
     * Löscht die Maschine aus Ihrer Liste.
     * @param maschine Die übergebene Maschine.
     * @since 1.00
     */
    private void loescheAusEnsprechenderListe(Maschine maschine) {
        if (maschine.getKopf().getAnzahlKoepfe() == 1) {
            einKopfMaschinenListe.remove(maschine);
        } else if (maschine.getKopf().getAnzahlKoepfe() >= 2 && maschine.getKopf().getAnzahlKoepfe() <= 8) {
            zweiBisAchtKopfMaschinenListe.remove(maschine);
        } else if (maschine.getKopf().getAnzahlKoepfe() >= 10) {
            zehnUndMehrKopfMaschinenListe.remove(maschine);
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        String ausgabe = "";
        if (maschinenListe.isEmpty()) {
            ausgabe = "Es ist keine Maschine vorhanden!";
        } else {
            for (Maschine m : maschinenListe) {
                ausgabe += m.toString();
            }

            ausgabe += "Einkopfmaschinen: \n";
            for (Maschine m : einKopfMaschinenListe) {
                ausgabe += m.toString();
            }

            ausgabe += "ZweiBisAchtKopf: \n";
            for (Maschine m : zweiBisAchtKopfMaschinenListe) {
                ausgabe += m.toString();
            }

            ausgabe += "ZehnUndMehrKopf: \n";
            for (Maschine m : zehnUndMehrKopfMaschinenListe) {
                ausgabe += m.toString();
            }
        }
        return ausgabe;
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das zu vergleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false; Obejkte sind ungleich
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Obejekt zum vergleichen vorhannde!");
        } else if (!(object instanceof MaschinenVerwaltung)) {
            return false;
        } else {
            MaschinenVerwaltung mv = (MaschinenVerwaltung)object;
            return mv.hashCode() == this.hashCode();
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
        hash = 19 * hash + Objects.hashCode(this.maschinenListe);
        hash = 19 * hash + Objects.hashCode(this.einKopfMaschinenListe);
        hash = 19 * hash + Objects.hashCode(this.zweiBisAchtKopfMaschinenListe);
        hash = 19 * hash + Objects.hashCode(this.zehnUndMehrKopfMaschinenListe);
        return hash;
    }        
}