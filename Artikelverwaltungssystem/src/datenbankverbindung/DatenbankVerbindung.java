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
package datenbankverbindung;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Diese Klasse baut die verbindung mit der Datenbank auf.
 * @author Alfred Loran
 * @version 1.00
 */
public class DatenbankVerbindung {
   private static DatenbankVerbindung datenBankVerbindung = null;
   private final String URL = "jdbc:mysql://localhost:3306/artikelverwaltung";
   private final String BENUTZER = "root";
   private final String PASSWORT = "A877384l!";
   private Connection con = null;
   
   /**
    * Erzeugt ein DatenbankVerbindung - Objekt.
    * @since 1.00
    */
   public DatenbankVerbindung() {
       setDatenBankVerbindung(this);
       verbindungAufbauen();
   }
   
   /**
    * Liefert dieses Objekt zurück.
    * @return dieses Objekt.
    * @since 1.00
    */
   public static DatenbankVerbindung getDatenBankVerbindung() {
       return datenBankVerbindung;
   }
   
   /**
    * Setzt dieses Objekt.
    * @param db Das übergebene Objekt.
    * @since 1.00
    */
   private void setDatenBankVerbindung(DatenbankVerbindung db) {
       DatenbankVerbindung.datenBankVerbindung = db;
   }
   
   /**
    * Diese Methode baut die Verbindung zur Datenbank auf.
    * @since 1.00
    */
   private void verbindungAufbauen() {        
        try {
            con = (Connection) DriverManager.getConnection(URL, BENUTZER, PASSWORT);            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
    }
   
   /**
    * Diese Methode trennt die Verbindung zur Datenbank.
    * @since 1.00
    */
   public void verbindungTrennen() {
       try {
           con.close();
       } catch(SQLException fehler) {
           System.err.println(fehler.getMessage());
       }
   }   
}