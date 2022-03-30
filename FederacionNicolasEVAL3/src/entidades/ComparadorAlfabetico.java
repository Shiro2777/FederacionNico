package entidades;

import java.util.Comparator;

public class ComparadorAlfabetico implements Comparator<DatosPersona>{
	public int compare(DatosPersona o1, DatosPersona o2) {
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}
}
