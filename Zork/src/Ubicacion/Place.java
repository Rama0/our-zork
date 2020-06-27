package Ubicacion;

import java.util.LinkedList;
import java.util.List;

import items.Item;

public class Place {

	protected String nombre;
	protected Character genero;
	protected Character numero;
	protected List<Item> items;

	public Place(String nom, Character gen, Character num) {

		this.nombre = nom;
		this.genero = gen;
		this.numero = num;

		items = new LinkedList<>();

	}

//// GETTERS ////
	public String getName() {
		return nombre;
	}

	public Character getGenero() {
		return genero;
	}

	public char getNumero() {
		return numero;
	}

	public Item getItem(String nombreItem) { /* remueve el item de la lista, lo saca del place donde se encuentra */
		Item aux = null;
		for (Item item : items) {
			if (item.getNombre().equals(nombreItem)) {
				aux = new Item(item.getNombre(), item.getGenero(), item.getNumero());
				items.remove(item);
				break;
			}
		}
		return aux;
	}

	public String getNombre() {
		return nombre;
	}

//// LISTAS ////
	public String listarItems() {
		String listaItems = "En ";
		listaItems += genero == 'F' ? "la " : "el ";
		listaItems += getNombre() + " hay ";
		Item item;
		if (items.size() != 0) {
			for (int indice = 0; indice < items.size(); indice++) {

				item = items.get(indice);
				if (items.size() == 1) {
					listaItems += item.toString() + ".";
				}
				// si es el ultimo item
				else if (indice + 1 == items.size()) {
					listaItems += "y " + item.toString() + ".";
				} else {
					listaItems += item.toString() + ", ";
				}
			}
		} else {
			listaItems = "No hay objetos aqui";
		}
		return listaItems;
	}

//// AGREGAR ELEMENTOS ////
	public void agregarItem(Item objeto) {
		items.add(objeto);
	}

	@Override
	public String toString() {
		String descripcionSitio = "";
		if (numero == 'S')
			descripcionSitio += genero == 'F' ? "una " : "un ";
		else
			descripcionSitio += genero == 'F' ? "unas " : "unos ";
		return descripcionSitio + getNombre();
	}

	public static void mostrarItems(String nombrePlace, List<Place> sitios) {

		boolean enc = false;
		for (Place place : sitios) {

			if (place.nombre.equals(nombrePlace)) {
				System.out.println(place.listarItems());
				enc = true;
			}
		}
		if (!enc) {
			System.out.print("sitio no existente para mirar");
		}
	}

}
