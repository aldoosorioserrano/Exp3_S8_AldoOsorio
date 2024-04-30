package exp3_s8_aldoosorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Exp3_S8_AldoOsorio {

	static String nombreTeatro = "Teatro Moro";
	static int anioBoleta = 2024;

	static int valorGeneral = 5000;
	static int valorVIP = 7000;
	static int valorPlatea = 6000;
	static Scanner scanner = new Scanner(System.in);
	static Asiento[] asientos = new Asiento[10];
	static List<Venta> ventas = new ArrayList();
	static List<Cliente> clientes = new ArrayList();

	// Clase para grabar datos de boleta e imprimir el resultado en pantalla.
	public static class Boleta {

		private UUID idBoleta;
		int precio;
		String tipoEntrada;
		int cantidad;
		String descuentoAplicado;
		double precioFinalEntrada;
		int numeroAsiento;

		public Boleta() {
			// generamos un id único
			this.idBoleta = UUID.randomUUID();
		}

		public UUID getIdBoleta() {
			return idBoleta;
		}

		public void setIdBoleta(UUID idBoleta) {
			this.idBoleta = idBoleta;
		}

		public int getNumeroAsiento() {
			return numeroAsiento;
		}

		public void setNumeroAsiento(int numeroAsiento) {
			this.numeroAsiento = numeroAsiento;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		public String getTipoEntrada() {
			return tipoEntrada;
		}

		public void setTipoEntrada(String tipoEntrada) {
			this.tipoEntrada = tipoEntrada;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public String getDescuentoAplicado() {
			return descuentoAplicado;
		}

		public void setDescuentoAplicado(String descuentoAplicado) {
			this.descuentoAplicado = descuentoAplicado;
		}

		public double getPrecioFinalEntrada() {
			return precioFinalEntrada;
		}

		public void setPrecioFinalEntrada(double precioFinalEntrada) {
			this.precioFinalEntrada = precioFinalEntrada;
		}

	};

	public static class Cliente {

		int idCliente;
		String nombre;
		String apeliido;
		int edad;

		public int getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApeliido() {
			return apeliido;
		}

		public void setApeliido(String apeliido) {
			this.apeliido = apeliido;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

	}

	public static class Venta {

		UUID idVenta;
		UUID idBoleta;
		int idCliente;
		int idAsiento;
		String tipoAsiento;

		public Venta() {
			// generamos un id único
			this.idVenta = UUID.randomUUID();
		}

		public int getIdAsiento() {
			return idAsiento;
		}

		public void setIdAsiento(int idAsiento) {
			this.idAsiento = idAsiento;
		}

		public UUID getIdVenta() {
			return idVenta;
		}

		public void setIdVenta(UUID idVenta) {
			this.idVenta = idVenta;
		}

		public UUID getIdBoleta() {
			return idBoleta;
		}

		public void setIdBoleta(UUID uuid) {
			this.idBoleta = uuid;
		}

		public int getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		public String getTipoAsiento() {
			return tipoAsiento;
		}

		public void setTipoAsiento(String tipoAsiento) {
			this.tipoAsiento = tipoAsiento;
		}

	}

	public static class Asiento {

		int numeroAsiento;
		String tipoAsiento;
		boolean disponible;

		public int getNumeroAsiento() {
			return numeroAsiento;
		}

		public void setNumeroAsiento(int numeroAsiento) {
			this.numeroAsiento = numeroAsiento;
		}

		public String getTipoAsiento() {
			return tipoAsiento;
		}

		public void setTipoAsiento(String tipoAsiento) {
			this.tipoAsiento = tipoAsiento;
		}

		public boolean isDisponible() {
			return disponible;
		}

		public void setDisponible(boolean disponible) {
			this.disponible = disponible;
		}

	}

	private static Boleta calcularPrecioEntrada(String tipoAsiento, Boleta boleta) {

		// Caoturar por pantalla el tipo Cliente
		System.out.println("****************************************\n");
		System.out.println("Tipos de clientes disponibles\n ");
		System.out.println("1 : ESTUDIANTE\n ");
		System.out.println("2 : GENERAL\n ");
		System.out.println("3 : TERCERA EDAD\n ");
		System.out.println("****************************************\n");
		System.out.println("Ingrese el tipo de cliente: ");

		int opcionTipoCliente = scanner.nextInt();

		if (opcionTipoCliente == 1) {
			boleta.setTipoEntrada("General");
			boleta.setPrecio(valorGeneral);

			boleta = calcularPrecioFinal(valorGeneral, opcionTipoCliente, boleta);

		} else if (opcionTipoCliente == 2) {
			boleta.setTipoEntrada("VIP");
			boleta.setPrecio(valorVIP);

			boleta = calcularPrecioFinal(valorVIP, opcionTipoCliente, boleta);

		} else if (opcionTipoCliente == 3) {
			boleta.setTipoEntrada("Platea");
			boleta.setPrecio(valorPlatea);
			boleta = calcularPrecioFinal(valorPlatea, opcionTipoCliente, boleta);
		}

		return boleta;

	}

	private static Boleta calcularPrecioFinal(int valorTipoEntrada, int opcionTipoCliente, Boleta boleta) {
		double valorFinalEntrada = 0.0;

		if (opcionTipoCliente == 1) {

			valorFinalEntrada = valorTipoEntrada * 0.90;
			boleta.setDescuentoAplicado("10%");

		} else if (opcionTipoCliente == 2) {
			boleta.setDescuentoAplicado("0%");
			valorFinalEntrada = valorTipoEntrada;

		} else if (opcionTipoCliente == 3) {
			boleta.setDescuentoAplicado("15%");
			valorFinalEntrada = valorTipoEntrada * 0.85;
		}

		System.out.println("Valor final de la entrada: " + valorFinalEntrada);
		boleta.setPrecioFinalEntrada(valorFinalEntrada);
		return boleta;
	}

	private static String menu() {
		String opcion;
		System.out.println("****************************************\n");
		System.out.println("Ingrese su opcion del menu:\n");
		opcion = scanner.nextLine();

		return opcion;

	}

	private static boolean salir() {
		System.out.println("****************************************\n");
		System.out.println("Gracias por  asistir a  " + nombreTeatro);
		System.out.println("****************************************\n");
		System.exit(0);
		return true;
	}

	private static Boleta comprarEntradas(int entradasDisponibles, Boleta boleta) {

		int i = 0;

		Venta venta = new Venta();

		if (asientos.length == 0) {
			System.out.println("****************************************\n");
			System.out.println("NO HAY ENTRADAS DISPONIBLES\n");
			System.out.println("****************************************\n");
		} else if (asientos.length > 0 && asientos != null) {
			System.out.println("****************************************\n");
			System.out.println("ENTRADAS DISPONIBLES\n ");
			System.out.println("******************************************\n");
			for (i = 0; i < asientos.length; i++) {
				if (asientos[i].isDisponible()) {

					System.out.println("NUMERO DE ASIENTO: " + asientos[i].getNumeroAsiento());
					System.out.println("TIPO DE ASIENTO  : " + asientos[i].getTipoAsiento());
					System.out.println("******************************************\n");

				}
			}

		}
		int numeroAsiento = 0;
		int numeroRut = 0;
		String nombreCliente = null;

		System.out.println("INGRESE EL NUMERO DE ASIENTO QUE DESEA COMPRAR\n");
		System.out.println("****************************************\n");
		// capturar por pantalla el tipo de entrada
		numeroAsiento = scanner.nextInt();
		boleta.setNumeroAsiento(numeroAsiento);
		System.out.println("NUMERO DE ASIENTO --> " + numeroAsiento);

		String tipoEntrada = null;
		for (int j = 0; j < asientos.length; j++) {
			if (asientos[j].getNumeroAsiento() == numeroAsiento) {
				asientos[j].setDisponible(false);
				venta.setIdAsiento(numeroAsiento);
				tipoEntrada = asientos[j].getTipoAsiento();
			}
		}
		boleta.setTipoEntrada(tipoEntrada);
		Cliente cliente = new Cliente();
		boleta.setCantidad(1);

		System.out.println("****************************************\n");
		System.out.println("INGRESE EL RUT DEL CLIENTE, SIN - NI DIGITO VERIFICADOR ");
                numeroRut = scanner.nextInt();
		System.out.println("****************************************");


		


		cliente.setIdCliente(numeroRut);

		System.out.println("****************************************");
		System.out.println("INGRESE EL NOMBRE DEL CLIENTE");
		nombreCliente = scanner.next();
                System.out.println("****************************************");

		cliente.setNombre(nombreCliente);
		venta.setIdCliente(numeroRut);


		clientes.add(cliente);

		boleta = calcularPrecioEntrada(tipoEntrada, boleta);

		venta.setIdBoleta(boleta.getIdBoleta());
		venta.setTipoAsiento(boleta.getTipoEntrada());
		ventas.add(venta);

		entradasDisponibles--;

		// Imprime Boleta
		System.out.println("---------------------------------------\n");
		System.out.println("Numero Asiento     : " + boleta.getNumeroAsiento()+ "\n");
		System.out.println("Ubicacion          : " + boleta.getTipoEntrada() + "\n");
		System.out.println("Costo Base         : " + boleta.getPrecio() + "\n");
		System.out.println("Descuento Aplicado : " + boleta.getDescuentoAplicado() + "\n");
		System.out.println("Costo Final        : " + boleta.getPrecioFinalEntrada() + "\n");
		System.out.println("---------------------------------------\n");
		System.out.println("Gracias por su visita al Teatro Moro\n");
		System.out.println("---------------------------------------\n");

		return boleta;
	}

	public static Asiento[] llenarAsientos() {
		// Asiento[] asientos = new Asiento[10];
		Asiento asiento1 = new Asiento();
		asiento1.setNumeroAsiento(1);
		asiento1.setTipoAsiento("General");
		asiento1.setDisponible(true);
		asientos[0] = asiento1;
		Asiento asiento2 = new Asiento();
		asiento2.setNumeroAsiento(2);
		asiento2.setTipoAsiento("General");
		asiento2.setDisponible(true);
		asientos[1] = asiento2;
		Asiento asiento3 = new Asiento();
		asiento3.setNumeroAsiento(3);
		asiento3.setTipoAsiento("Platea");
		asiento3.setDisponible(true);
		asientos[2] = asiento3;
		Asiento asiento4 = new Asiento();
		asiento4.setNumeroAsiento(4);
		asiento4.setTipoAsiento("Platea");
		asiento4.setDisponible(true);
		asientos[3] = asiento4;
		Asiento asiento5 = new Asiento();
		asiento5.setNumeroAsiento(5);
		asiento5.setTipoAsiento("Platea");
		asiento5.setDisponible(true);
		asientos[4] = asiento5;
		Asiento asiento6 = new Asiento();
		asiento6.setNumeroAsiento(6);
		asiento6.setTipoAsiento("VIP");
		asiento6.setDisponible(true);
		asientos[5] = asiento6;
		Asiento asiento7 = new Asiento();
		asiento7.setNumeroAsiento(7);
		asiento7.setTipoAsiento("VIP");
		asiento7.setDisponible(true);
		asientos[6] = asiento7;
		Asiento asiento8 = new Asiento();
		asiento8.setNumeroAsiento(8);
		asiento8.setTipoAsiento("VIP");
		asiento8.setDisponible(true);
		asientos[7] = asiento8;
		Asiento asiento9 = new Asiento();
		asiento9.setNumeroAsiento(9);
		asiento9.setTipoAsiento("VIP");
		asiento9.setDisponible(true);
		asientos[8] = asiento9;
		Asiento asiento10 = new Asiento();
		asiento10.setNumeroAsiento(10);
		asiento10.setTipoAsiento("General");
		asiento10.setDisponible(true);
		asientos[9] = asiento10;

		return asientos;

	}

	public static void main(String[] args) {

		asientos = llenarAsientos();

		int entradasDisponibles = 10;

		List<Boleta> listaBoletas = new ArrayList();

		boolean salir = false;

		while (!salir) {
			Boleta boleta = new Boleta();

			System.out.println("****************************************\n");
			System.out.println("Bienvenido a " + nombreTeatro);
			System.out.println("****************************************\n");
			System.out.println("");
			System.out.println("(1) Comprar entradas ");
			System.out.println("(2) Ver entradas vendidas ");
			System.out.println("(3) Liberar un asiento vendido");
			System.out.println("(4) Cambiar asiento a una venta ");
			System.out.println("(5) Salir");
			System.out.println("****************************************\n");
			System.out.println("****************************************\n");

			String opcion = menu();

			switch (opcion) {
			case "1":
				boleta = comprarEntradas(entradasDisponibles, boleta);
				listaBoletas.add(boleta);
				break;
			case "2":
				obtenerEntradasVendidas(listaBoletas);
				break;
			case "3":
				liberarAsiento(ventas);
				break;
			case "4":
				modificarAsiento();
				break;
			case "5":
				salir = salir();
				break;
			default:
				System.out.println("Ingrese una opcion\n");
			}
		}

	}

	private static void modificarAsiento() {

		System.out.println("****************************************\n");
		System.out.println("INGRESE EL RUT DEL CLIENTE, SIN - NI DIGITO VERIFICADOR \n");
		System.out.println("****************************************\n");
		// capturar por pantalla el tipo de entrada
		int numeroRut = scanner.nextInt();

		Venta ventaActual = null;
		for (int i = 0; i < ventas.size(); i++) {

			if (ventas.get(i).getIdCliente() == numeroRut) {
				ventaActual = ventas.get(i);
				System.out.println("****************************************\n");
				System.out.println("DATOS ENTRADA\n");
				System.out.println("Numero asiento: " + ventas.get(i).getIdAsiento());
				System.out.println("Tipo asiento  : " + ventas.get(i).getTipoAsiento());
				System.out.println("****************************************\n");
			}

		}

		System.out.println("****************************************\n");
		System.out.println("ASIENTOS DISPONIBLES\n");
		System.out.println("****************************************\n");
		int i = 0;
		for (int j = 0; j < asientos.length; j++) {

			if (asientos[j].isDisponible() && asientos[j].getTipoAsiento().equals(ventaActual.getTipoAsiento())) {
				System.out.println("---------------------------------------\n");
				System.out.println("ASIENTO     : " + asientos[j].getNumeroAsiento() + "\n");
				System.out.println("TIPO ASIENTO: " + asientos[j].getTipoAsiento());
				System.out.println("---------------------------------------\n");
				i++;
			}
		}
		int nuevoAsiento = 0;
		if (i > 0) {
			System.out.println("****************************************\n");
			System.out.println("INGRESE EL NUMERO DE ASIENTO QUE DESEA  \n");
			System.out.println("****************************************\n");
			nuevoAsiento = scanner.nextInt();
		}

		ventaActual.setIdAsiento(nuevoAsiento);

		for(int j =0; j< asientos.length ; j++) {
			if(asientos[j].getNumeroAsiento() == nuevoAsiento)
			{
				asientos[j].setDisponible(false);
			}

		}


		ventas.add(ventaActual);
		System.out.println("****************************************\n");
		System.out.println("SU ASIENTO FUE MODIFICADO CORRECTAMENTE \n");
		System.out.println("****************************************\n");

	}

	private static void liberarAsiento(List<Venta> ventas2) {
		System.out.println("****************************************\n");
		System.out.println("ENTRADAS VENDIDAS\n");
		System.out.println("****************************************\n");
		for (int i = 0; i < ventas2.size(); i++) {
			System.out.println("---------------------------------------\n");
			System.out.println("Asiento     : " + ventas2.get(i).getIdAsiento() + "\n");
			System.out.println("Tipo asiento: " + ventas2.get(i).getTipoAsiento());
			System.out.println("---------------------------------------\n");

		}

		System.out.println("****************************************\n");
		System.out.println("INGRESE EL NUMERO DE ASIENTO QUE DESEA LIBERAR ");
		System.out.println("****************************************\n");

		int numeroAsiento = scanner.nextInt();

		for (int i = 0; i < ventas2.size(); i++) {
			if (ventas2.get(i).getIdAsiento() == numeroAsiento) {
				ventas2.remove(i);
				cambiarEstadoAsiento(numeroAsiento);
			}
		}


	}

	private static void cambiarEstadoAsiento(int asientoLiberado) {

		for (int i = 0; i < asientos.length; i++) {

			if (asientos[i].getNumeroAsiento() == asientoLiberado) {

				asientos[i].setDisponible(true);
				System.out.println("****************************************\n");
				System.out.println("EL ASIENTO HA SIDO LIBERADO ");
				System.out.println("****************************************\n");

			}
		}

	}

	private static void obtenerEntradasVendidas(List<Boleta> listaBoletas) {

		if (listaBoletas.size() != 0) {
			for (int i = 0; i < listaBoletas.size(); i++) {

				Boleta boleta = listaBoletas.get(i);

				if (boleta != null) {
					System.out.println("---------------------------------------\n");
					System.out.println("Numero asiento     : " + boleta.getNumeroAsiento() + "\n");
					System.out.println("Ubicacion          : " + boleta.getTipoEntrada() + "\n");
					System.out.println("Costo Base         : " + boleta.getPrecio() + "\n");
					System.out.println("Descuento Aplicado : " + boleta.getDescuentoAplicado() + "\n");
					System.out.println("Costo Final        : " + boleta.getPrecioFinalEntrada() + "\n");
					System.out.println("---------------------------------------\n");

				}

			}

		} else {

			System.out.println("No se han vendido entradas");
		}

	}
}
