package systemTester;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import activities.ActivityType;
import system.ArtGallery;
import users.Admin;
import users.Client;
import users.Gender;
import users.Staff;
import users.User;
import works.Exhibition;
import works.SubRoom;

public class SystemManual implements Serializable {

	public static void loadInfoExample(){
		Boolean st = true;
		Client clientSing = null;
		Staff staffSing = null;
		Admin adminSing = null;
		Exhibition exActual = null;
		Client cl = null;
		
		System.out.println("Loading Info...");
		
		Path currentPath = Paths.get("").toAbsolutePath();
		Path entradasPath = currentPath.resolve("EntradasPDF");
		
		deleteFile(entradasPath.toFile());
		
		try {
			if (Files.exists(entradasPath)) {
				Files.delete(entradasPath);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

		/* Cogemos la aplicacion con la clase sistema */
		ArtGallery inicio = ArtGallery.getSystem();
		/* Creamos nuevos usuarios */
		inicio.newClient("Paco", "Fiestas", "51546798A", Gender.MALE, LocalDate.of(2004, 10, 2), "SOY-EL-JEFE");
		inicio.newClient("Pepe", "Cocas", "51546797A", Gender.MALE, LocalDate.of(2004, 6, 23), "SOY-EL-JEFE");
		inicio.newClient("Silvia", "De la Calle", "51546796A", Gender.FEMALE, LocalDate.of(2005, 5, 25), "SOY-EL-JEFE");
		inicio.newClient("Juan Jose", "Vieira", "51546795A", Gender.MALE, LocalDate.of(2004, 7, 22), "SOY-EL-JEFE");
		inicio.newClient("Juan", "Lopez", "12345678X", Gender.MALE, LocalDate.of(1998, 1, 1), "Password123");
		inicio.newClient("Luis", "Nunez", "43229075T", Gender.MALE, LocalDate.of(2004, 3, 11), "Hola123");
		
		inicio.newAdmin("Admin", "Sistema", "99999999X", Gender.OTHER, LocalDate.of(2000, 1, 1), "Admin123");
		
		inicio.newStaff("Staff", "1", "11111111X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		inicio.newStaff("Staff", "2", "11111112X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		inicio.newStaff("Staff", "3", "11111113X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		inicio.newStaff("Staff", "4", "11111114X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		inicio.newStaff("Staff", "5", "11111115X", Gender.OTHER, LocalDate.of(2000, 1, 1));
		
		Staff.changeStaffPwd("Staff123");
		
		/* Creamos exhibiciones */
		inicio.createExhibition("Van Gogh", "Pepe", LocalDateTime.of(2024, 6, 18, 8, 0),LocalDateTime.of(2024, 8, 4, 10, 0));
		inicio.createExhibition("Pablo Picasso", "Francisco", LocalDateTime.of(2024, 6, 14, 8, 0),LocalDateTime.of(2024, 9, 7, 10, 0));
		
		/* Creamos una sala */
		SubRoom space1 = inicio.createSalaFisica(false, 21.5, 48.00, 24.00, 5.00, 40.00, 10);


		SubRoom space2 = inicio.createSalaFisica(true, 21.5, 48.00, 24.00, 5.00, 40.00, 10);

		inicio.createActivity("EJEMPLO", ActivityType.ACTUACION, "DESC EJEMPLO", 10, LocalDateTime.of(2024, 06, 20, 10, 0), space2);

		inicio.createPainting("Guernica", "Picasso", true, 20, 10, 10, 10, 0);
		inicio.createPainting("Guernica2", "Picasso2", true, 20, 10, 10, 10, 0);
		inicio.createPainting("Guernica3", "Picasso3", true, 20, 10, 10, 10, 0);

		exActual = inicio.searchExhibition("Van Gogh");
		exActual.setPrice(8.00);
		boolean staux = exActual.setExpositionToSubRoom(space1);
		exActual.publishExposition();
		exActual.createRaffle("Sorteo Bienvenida", "Participa para ganar las entradas que quieras", 1, LocalDateTime.of(2024, 5, 5, 10, 0), LocalDateTime.of(2024, 5, 6, 10, 0));
		
		exActual = inicio.searchExhibition("Pablo Picasso");
		exActual.setPrice(10.00);
		//staux = exActual.setExpositionToSubRoom(space2);
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

		for (User u : inicio.getUsers()) {
			if (u.getName().equals("Juan")) {
				cl = (Client) u;
				break;
			}
		}
		
		inicio.createNotification("Enhorabuena", "Esto es un mensaje automatizado enviado a los ganadores del sorteo hecho en la previa fecha, si le ha llegado esta notificacion porfavor revise su bandeja de entrada del correo electrónico pararecibir el PDF de la entrada ganadora", cl);

		
		
		inicio.saveSistem();
	}
	
	public static void deleteFile(File file){
	    if (file.exists()) {
	        if (file.isFile())
	            file.delete();
	        else {
	            File f[]=file.listFiles();
	            for (int i = 0; i < f.length; i++) {
	                    deleteFile(f[i]);
	            }
	            file.delete();
	        }
	    }else
	        System.out.println("El archivo no existe!");
	}

}