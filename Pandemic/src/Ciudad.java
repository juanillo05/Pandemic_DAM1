import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

public class Ciudad {
	private int idCiudad;
	private String nombre;
	private String enfermedad;
	private int idColor;
	int nivelInfeccion;
	private int infeccion;
	private int[] coords = new int[2];

	ArrayList<String> colindantes =  new ArrayList<>();

	public Ciudad(String nombre, String enfermedad, int[] coords, ArrayList<String> colindantes) {
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.coords = coords;
		this.colindantes = colindantes;
	}



	// Getters
	public int getIdCiudad() {
		return idCiudad;
	}

	public String getNombre() {
		return nombre;
	}
	public int[] getCoords() {
		return coords;
	}

	public int getIdColor() {
		return idColor;
	}

	public int getNivelInfeccion() {
		return nivelInfeccion;
	}

	public int getInfeccion() {
		return infeccion;
	}

	public String getEnfermedad() {
		return enfermedad;

	}

	// Setters
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	//getcolindantes que devuelva el array de colindantes
	public ArrayList<String> getColindantes() {
		return colindantes;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCoords(int[] coords) {
		this.coords = coords;
	}
 //setters
	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public void setNivelInfeccion(int nivelInfeccion) {
		this.nivelInfeccion = nivelInfeccion;
	}

	public void setInfeccion(int infeccion) {
		this.infeccion = infeccion;
	}

	public void aumentarInfeccion() {
		this.infeccion++;
	}

	public void disminuirInfeccion() {
		if (this.infeccion > 0) {
			this.infeccion--;
		}
	}

	public void propagarInfeccion() {
		// Implement the logic to propagate the infection to adjacent cities
	}

	@Override
	public String toString() {
		long[] coordenadas = null;
		String enfermedad = null;
		long[] ciudadesColindantes = null;
		return "Ciudad{" +
				"nombre='" + nombre + '\'' +
				", coordenadas=" + Arrays.toString(coordenadas) +
				", enfermedad='" + enfermedad + '\'' +
				", infeccion=" + infeccion +
				", ciudadesColindantes=" + Arrays.toString(ciudadesColindantes) +
				'}';
	}

	public void curarciudad() {
		if (Mapa.contadorAcciones >= 1) {

			//restarle 1 a la infeccion
			this.setInfeccion(this.getInfeccion() - 1);
			//imprimir el nombre de la ciudad y su nivel de infeccion actual
			System.out.println("Ciudad curada: " + this.getNombre() + " Nivel de infeccion: " + this.getInfeccion());
			//si la infeccion es menor que 0, ponerla a 0
			if (this.infeccion < 0) {
				this.infeccion = 0;
			}
			//actualizar la imagen de la ciudad
			ImageIcon icon = null;


			switch (this.getEnfermedad()) {
				case "Alfa":
					if (PanelBotones.porcentajeActual3 == 100) {
						this.setInfeccion(0);
						icon = new ImageIcon("0 azul.png");

					}
					//actualizar imagen de la ciudad segun su nivel infeccion
					if (this.getInfeccion() == 1) {
						icon = new ImageIcon("1 azul.png");
					} else if (this.getInfeccion() == 2) {
						icon = new ImageIcon("2 azul.png");
					} else if (this.getInfeccion() == 0) {
						icon = new ImageIcon("0 azul.png");
					}
					break;
				case "Beta":
					if (PanelBotones.porcentajeActual2 == 100) {
						this.setInfeccion(0);
						icon = new ImageIcon("0 rojo.png");

					}
					//actualizar imagen de la ciudad segun su nivel infeccion
					if (this.getInfeccion() == 1) {
						icon = new ImageIcon("1 rojo.png");
					} else if (this.getInfeccion() == 2) {
						icon = new ImageIcon("2 rojo.png");
					} else if (this.getInfeccion() == 0) {
						icon = new ImageIcon("0 rojo.png");
					}
					break;
				case "Gama":
					if (PanelBotones.porcentajeActual4 == 100) {
						this.setInfeccion(0);
						icon = new ImageIcon("0 negro.png");
					}
					//actualizar imagen de la ciudad segun su nivel infeccion
					if (this.infeccion == 1) {
						icon = new ImageIcon("1 negro.png");
					} else if (this.getInfeccion() == 2) {
						icon = new ImageIcon("2 negro.png");
					} else if (this.getInfeccion() == 0) {
						icon = new ImageIcon("0 negro.png");
					}
					break;
				case "Delta":
					if (PanelBotones.porcentajeActual1 == 100) {
						this.setInfeccion(0);
						icon = new ImageIcon("0 amarillo.png");
					}



			//actualizar imagen de la ciudad segun su nivel infeccion
			if (this.getInfeccion() == 1) {
				icon = new ImageIcon("1 amarillo.png");
			} else if (this.getInfeccion() == 2) {
				icon = new ImageIcon("2 amarillo.png");
			} else if (this.getInfeccion() == 0) {
				icon = new ImageIcon("0 amarillo.png");
			}
			break;
			default:
				// Opcional: puedes manejar el caso en que la enfermedad no sea ninguna de las esperadas
				break;
		}


			//crear jbutton llamado botonCiudad
			JButton botonCiudad = null;
			for (int i = 0; i < Mapa.botonesCiudad.size(); i++) {
				//buscar el boton con el nombre de la ciudad en Mapa.botonesciudad
				if (this.getNombre().equals(Mapa.botonesCiudad.get(i).getText())){
					botonCiudad = Mapa.botonesCiudad.get(i);
					break;
				}
			}




			if (icon != null) {
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(botonCiudad.getWidth(), botonCiudad.getHeight(), java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				botonCiudad.setIcon(icon);
			}

		}
		//si contador de acciones es menor que 1, imprimir que no hay acciones restantes
		else {
			System.out.println("No hay acciones restantes");
		}
		//si el porcentaje esta al nivel 100 poder curar la ciudad que esta la nivel 3
	}

}


