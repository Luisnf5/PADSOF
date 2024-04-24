package systemTester;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import system.ArtGallery;
import users.*;
import works.*;
import vistasUsers.*;

public class systemTester implements Serializable {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 Boolean st = true;
		 Client clientSing = null;
		 Staff staffSing = null;
		 Admin adminSing = null;
		 Exhibition exActual = null;
		 
		 
		 /*Cogemos la aplicacion con la clase sistema*/
		 ArtGallery inicio = ArtGallery.getSystem() ;
		 inicio.readSistem();
		 /*Creamos nuevos usuarios*/
		 inicio.newClient("Paco", "Fiestas", "51546798A", Gender.OTHER, LocalDate.of(2004, 10, 2), "SOY-EL-JEFE");
		 /*Creamos exhibiciones*/
		 inicio.createExhibition("FIESTA CON EL JEFE", "La Nuit", LocalDateTime.of(2024, 4, 3, 8, 0),  LocalDateTime.of(2024, 4, 7, 8, 0));
		 
		 /*Creamos una sala*/
		 SubRoom room1 = new SubRoom(1, true, 21.5 ,48.00, 24.00, 5.00, 40.00, 100);
		 inicio.addSubRoom(room1);
		 
		 SubRoom room2 = new SubRoom(1, true, 21.5 ,48.00, 24.00, 5.00, 40.00, 150);
		 inicio.addSubRoom(room2);
		 
		 
		 SubroomExhibition space1 = new SubroomExhibition(room1); 
		 
		 Painting p1 = new Painting("Guernika", "Pablo Picasso", false, 21.5, 0.180, 0, 0.180, 50, "Oleo sobre tela");
		 space1.addWorks(p1);
		 
		 
		 exActual = inicio.searchExhibition("FIESTA CON EL JEFE");
		 boolean staux = exActual.addRoomExhibition(space1);
		 exActual.publishExposition();
		 
		 /*Cargamos pruebas de sistema*/
		 System.out.println("BIENVENIDO A ART GALLERY!\n");
		 System.out.println("POR FAVOR INDIQUE SI QUIERE REGISTRARSE(R) O INICIAR SESION(I):");
		 System.out.println("R o I?\n");
		 
		 vistaCliente vc = new vistaCliente();
;		 while(st) {
			 String entradaUsuario = scanner.nextLine().toUpperCase();
			 switch(entradaUsuario) {
			 	case "R":
			 		System.out.println("Para registrar introduzca los siguientes campos");
			 		System.out.println("Nombre:");
			 		String name = scanner.nextLine();
			 		System.out.println("Apellido:");
			 		String lastname = scanner.nextLine();
			 		System.out.println("DNI:");
			 		String dni = scanner.nextLine().toUpperCase();
			 		System.out.println("Elija su genero: Hombre(H), Mujer(M) u Otro(O)");
			 		String gender = scanner.nextLine().toUpperCase();
			 		Gender g;
			 		switch(gender) {
			 			case "H":
			 				g = Gender.MALE;
			 				break;
			 			case "M": 
			 				g = Gender.FEMALE;
			 				break;
			 			default: 
			 				g = Gender.OTHER;
			 				break;
			 		}
			 		System.out.println("Fecha de nacimiento: ");
			 		System.out.println("Año: ");
			 		int year = scanner.nextInt();
			 		System.out.println("Mes(numero): ");
			 		int month = scanner.nextInt();
			 		System.out.println("Dia: ");
			 		int day = scanner.nextInt();
			 		System.out.println("Contrasena: ");
			 		String psw1 = scanner.nextLine();
			 
		 			while(!inicio.isPwdValid(psw1)) {
			 			System.out.println("Contrasena debil. Repita contraseña ");
			 			psw1 = scanner.nextLine();
			 		}
			 		
			 		
			 		System.out.println("Repita contraseña: ");
			 		String psw2 = scanner.nextLine();
			 		while(!psw1.equals(psw2)) {
			 			System.out.println("Las contraseñas no coindicen: ");
				 		psw2 = scanner.nextLine();
			 		}
			 		
			 		inicio.newClient(name, lastname, dni, g, LocalDate.of(year, month, day), psw2);
			 		st = false;
			 		break;
			 	case "I": 
			 		st = false;
			 		break;
			 	default:
			 		System.out.println("No se conocer ese comando. R o I?");
			}
		 }
		 System.out.println("(para la prueba inicie sesion, registrese primero o inicie como: 51546798A 'SOY-EL-JEFE'\n");
		 st = true;
		 while(st) {
			 System.out.println("INTRODUZCA NIF: ");
			 String nif = scanner.nextLine().toUpperCase();
			 System.out.println("INTRODUZCA CONTRASENA: ");
			 String psw = scanner.nextLine();
			 for(User u: inicio.getUsers()) {
				 if(u.validate_credentials(nif, psw)) {
					 System.out.println("BIENVENIDO DE VUELTA " + u.getName().toUpperCase() + "\n");
					 st = false;
					 inicio.setLoggedUser(u);
					 if(u.getClass( )== Client.class) {
						 clientSing = (Client) u; 
					 }
					 else if(u.getClass( )== Staff.class){
						 staffSing = (Staff) u;
					 }
					 else {
						 adminSing = (Admin) u;
					 }
					break;
				 }
				 else {
					 System.out.println("EL NIF O LA CONTRASENA NO ES CORRECTA.\n");
				 }
			 }
		 }
		 System.out.println("Esto seria un ejemplo de como funcionaria los inicios o registros de los clientes\n"
		 		+ "A partir de aqui vamos a automatizar los ejemplos");
		 System.out.println("(vamos a comprarle entradas para la exposicion Fiesta con el jefe)");
		 for(Exhibition e: inicio.getExhibitions()) {
			 System.out.println(e.getTitle());
			 if((e.getTitle()).equals("FIESTA CON EL JEFE")) {
				 	/*Vamos a intentar que compra distintas*/
				 	Ticket t1 = e.buyTicket(clientSing, LocalDateTime.of(2024, 4, 4, 12, 0));
				 	
				 	if(t1 == null)
				 		System.out.println("ERROR EN LA COMPRA 4-4-2024 12:00-BIEN");
				 	if(e.buyTicket(clientSing, LocalDateTime.of(2024, 3, 3, 12, 0)) == null)
				 		System.out.println("ERROR EN LA COMPRA 3-3-2024 12:00-MAL");
				 	if(e.buyTicket(clientSing, LocalDateTime.of(2024, 4, 3, 3, 0)) == null)
				 		System.out.println("ERROR EN LA COMPRA 4-4-2024 3:00-MAL");
			 }

			 	
		 }
		 
		 System.out.println("ESTAS SON TUS ENTRADAS: ");
		 for(Ticket t:  clientSing.getTickets()) {
			 System.out.println("Entrada para: " + t.getExhibition().getTitle() + " a las " + t.getHour());
		 }

        // Cerrar el Scanner
        scanner.close();
        
		inicio.saveSistem();
		return;
	 }

}
