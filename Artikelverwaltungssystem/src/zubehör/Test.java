/*
 * Copyright (C) 2015 there_000
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
 *
 * @author there_000
 */
public class Test {
    public static void main(String[] args) {
        Artikelgruppe ag1 = new Artikelgruppe("Klebespray");
        Artikelgruppe ag2 = new Artikelgruppe("Lagerfett");
        Artikelgruppe ag3 = new Artikelgruppe("Nadeln");
        Artikelgruppe ag4 = new Artikelgruppe("Nadelöl");
        Artikelgruppe ag5 = new Artikelgruppe("Sprühöl");
        Artikelgruppe ag6 = new Artikelgruppe("Vlies");
        
        
        ZubehoerVerwaltung zbv = new ZubehoerVerwaltung();
        
        for (int i = 0; i < 10; i++) {
            Klebespray s;
            
            try {
                s = new Klebespray(ag1, "Klebespray", 1);
                s.setBeschreibung("Tolles Klebespray");
            } catch(UngueltigeEingabeException fehler) {
                System.err.println(fehler.getMessage());
            }
            
            try {
                zbv.fuegeKlebeSprayHinzu(ag1, "Klebespray", 1+i);
            } catch(UngueltigeEingabeException fehler) {
                System.err.println(fehler.getMessage());
            }
            
            try {
                zbv.fuegeLagerfettHinzu(ag2, "Lagerfett", 1+i);
            } catch(UngueltigeEingabeException fehler) {
                System.err.println(fehler.getMessage());
            }
            
            try {
                zbv.fuegeNadelnHinzu(ag3, "Nadeln");
            } catch(UngueltigeEingabeException fehler) {
                System.err.println(fehler.getMessage());
            }
            
            try {
                zbv.fuegeNadelOelHinzu(ag4, "Nadelöl", 1+i);
            } catch(UngueltigeEingabeException fehler) {
                System.err.println(fehler.getMessage());
            }
            
            try {
                zbv.fuegeSpruehOelHinzu(ag5, "Sprühöl", 1+i);
            } catch(UngueltigeEingabeException fehler) {
                System.err.println(fehler.getMessage());
            }
            
            try {
                zbv.fuegeVliesHinzu(ag6, "Vlies", 1+i);
            } catch(UngueltigeEingabeException fehler) {
                System.err.println(fehler.getMessage());
            }
        }
        
        System.out.println(zbv.toString());
    }
}