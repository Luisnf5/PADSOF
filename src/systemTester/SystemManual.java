package systemTester;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import system.ArtGallery;
import users.Admin;
import users.Client;
import users.User;
import users.Gender;
import users.Raffle;
import users.Staff;
import users.User;
import works.Exhibition;
import works.Painting;
import works.SubRoom;
import works.SubroomExhibition;

public class SystemManual implements Serializable {

	public static void main(String[] args) {
		Boolean st = true;
		Client clientSing = null;
		Staff staffSing = null;
		Admin adminSing = null;
		Exhibition exActual = null;
		Client cl = null;

		/* Cogemos la aplicacion con la clase sistema */
		ArtGallery inicio = ArtGallery.getSystem();
		inicio.readSistem();
		/* Creamos nuevos usuarios */
		inicio.newClient("Paco", "Fiestas", "51546798A", Gender.OTHER, LocalDate.of(2004, 10, 2), "SOY-EL-JEFE");
		
		/* Creamos exhibiciones */
		inicio.createExhibition("FIESTA CON EL JEFE", "La Nuit", LocalDateTime.of(2024, 5, 3, 8, 0),LocalDateTime.of(2024, 5, 7, 8, 0));
		
		/* Creamos una sala */
		SubRoom room1 = new SubRoom(1, true, 21.5, 48.00, 24.00, 5.00, 40.00, 100);
		inicio.addSubRoom(room1);

		SubRoom room2 = new SubRoom(1, true, 21.5, 48.00, 24.00, 5.00, 40.00, 150);
		inicio.addSubRoom(room2);

		SubroomExhibition space1 = new SubroomExhibition(room1);

		Painting p1 = new Painting("Guernika", "Pablo Picasso", false, 21.5, 0.180, 0, 0.180, 50, "Oleo sobre tela");
		space1.addWorks(p1);

		exActual = inicio.searchExhibition("FIESTA CON EL JEFE");
		boolean staux = exActual.addRoomExhibition(space1);
		exActual.publishExposition();
		exActual.createRaffle("Sorteo Bienvenida", "Participa para ganar las entradas que quieras", 1, LocalDateTime.of(2024, 5, 5, 8, 0), LocalDateTime.of(2024, 5, 6, 8, 0));
		
		inicio.newClient("Luis", "Nuñez", "43229075T", Gender.MALE ,LocalDate.of(2004, 3, 11), "Hola123");
		for (User u : inicio.getUsers()) {
			if (u.getName().equals("Luis")) {
				cl = (Client) u;
				break;
			}
		}
		cl.participateRaffle(exActual, LocalDateTime.of(2024, 5, 5, 10, 0));

		
		inicio.saveSistem();
	}

}