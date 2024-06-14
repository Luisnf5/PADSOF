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

	public static void loadInfoExample(){
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
		
		inicio.newClient("Juan", "Lopez", "12345678X", Gender.OTHER, LocalDate.of(1998, 1, 1), "Password123");
		
		inicio.newAdmin("Admin", "Sistema", "99999999X", Gender.OTHER, LocalDate.of(2000, 1, 1), "Admin123");
		
		inicio.newStaff("Staff", "1", "11111111X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		inicio.newStaff("Staff", "2", "11111112X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		inicio.newStaff("Staff", "3", "11111113X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		inicio.newStaff("Staff", "4", "11111114X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		inicio.newStaff("Staff", "5", "11111115X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		
		/* Creamos exhibiciones */
		inicio.createExhibition("Van Gogh", "Pepe", LocalDateTime.of(2024, 5, 3, 8, 0),LocalDateTime.of(2024, 5, 7, 10, 0));
		inicio.createExhibition("Pablo Picasso", "Francisco", LocalDateTime.of(2024, 5, 3, 8, 0),LocalDateTime.of(2024, 5, 7, 10, 0));
		
		/* Creamos una sala */
		SubRoom room1 = new SubRoom(true, 21.5, 48.00, 24.00, 5.00, 40.00, 10);
		inicio.addSubRoom(room1);

		SubRoom room2 = new SubRoom(true, 21.5, 48.00, 24.00, 5.00, 40.00, 10);
		inicio.addSubRoom(room2);

		SubroomExhibition space1 = new SubroomExhibition(room1);
		SubroomExhibition space2 = new SubroomExhibition(room2);

		Painting p1 = new Painting("Guernika", "Pablo Picasso", false, 21.5, 0.180, 0, 0.180, 50);
		space1.addWorks(p1);

		exActual = inicio.searchExhibition("Van Gogh");
		exActual.setPrice(8.00);
		boolean staux = exActual.addRoomExhibition(space1);
		exActual.publishExposition();
		exActual.createRaffle("Sorteo Bienvenida", "Participa para ganar las entradas que quieras", 1, LocalDateTime.of(2024, 5, 5, 10, 0), LocalDateTime.of(2024, 5, 6, 10, 0));
		
		exActual = inicio.searchExhibition("Pablo Picasso");
		exActual.setPrice(10.00);
		staux = exActual.addRoomExhibition(space2);
		exActual.publishExposition();
		exActual.createRaffle("Diablo", "Participa para ganar las entradas que quieras", 1, LocalDateTime.of(2024, 5, 5, 10, 0), LocalDateTime.of(2024, 5, 6, 10, 0));
		
		inicio.newClient("Luis", "Nuñez", "43229075T", Gender.MALE ,LocalDate.of(2004, 3, 11), "Hola123");
		
		for (User u : inicio.getUsers()) {
			if (u.getName().equals("Luis")) {
				cl = (Client) u;
				break;
			}
		}
		
		inicio.createNotification("Enhorabuena", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);

		for (User u : inicio.getUsers()) {
			if (u.getName().equals("Juan")) {
				cl = (Client) u;
				break;
			}
		}
		
		inicio.createNotification("Enhorabuena", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);
		inicio.createNotification("Mensaje prueba", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);

		
		
		inicio.saveSistem();
	}

}