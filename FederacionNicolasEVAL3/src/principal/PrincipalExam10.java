package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import entidades.*;
import utils.ConexBD;
import utils.Datos;


public class PrincipalExam10 {

	public static void main(String[] args) {
		Responsable r1 = new Responsable (1, "902422202", LocalTime.of(00, 00), LocalTime.of(23, 59), Datos.buscarPersonaPorId(1011));
		Responsable r2 = new Responsable (2, "985181105", LocalTime.of(9, 00), LocalTime.of(18, 00), Datos.buscarPersonaPorId(1012));
		Responsable r3 = new Responsable (3, "985103000", LocalTime.of(8, 30), LocalTime.of(20, 00), Datos.buscarPersonaPorId(1013));
		Responsable r4 = new Responsable (4, "985185503", LocalTime.of(8, 30), LocalTime.of(18, 00), Datos.buscarPersonaPorId(1014));
		
		Patrocinador [] PATROCINADORES = {
			new Patrocinador (1, "ALSA", "www.alsa.es", 500.00F, r1),
			new Patrocinador (2, "Ayto.Gijón", "www.gijon.es", 250.00F, r2),
			new Patrocinador (3, "Universidad de Oviedo", "www.uniovi.es", 350.50F, r3),
			new Patrocinador (4, "CIFP La Laboral", "www.cifplalaboral.es", 255.99F, r4)				
		};
		
		Patrocinador aux = new Patrocinador();
		for (Patrocinador p : PATROCINADORES) {
			aux.insertarConID(p);
		}
		
		Patrocinador aux2 = new Patrocinador();
		for (Patrocinador p : PATROCINADORES) {
			aux2.insertarSinID(p);
		}

	}

}
