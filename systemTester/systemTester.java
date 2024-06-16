package systemTester;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.tickets.NonExistentFileException;
import es.uam.eps.padsof.tickets.UnsupportedImageTypeException;
import system.ArtGallery;
import users.*;
import works.*;
import vistasUsers.*;

public class systemTester implements Serializable {
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		//Testear compra de entradas
		
		Exhibition e = new Exhibition("La Nuit", "Derecho UAM", LocalDateTime.now(), LocalDateTime.now().plusDays(2));
		Client c = new Client("Gael", "Ankaoua", "55450352C", Gender.MALE, LocalDate.of(2004, 12, 12), "Hola123456");
		
		System.out.println(String.valueOf(e.publishExposition()));
		
		
		try{
			e.payTicket(c, LocalDateTime.now().plusHours(2), 1, "6392482992747428", 10);
		}catch(UnsupportedImageTypeException ex) {
			System.out.println("Catch 1");
		}catch(NonExistentFileException ex) {
			System.out.println("Catch 2");
		}catch(OrderRejectedException ex) {
			System.out.println("Catch 3");
		}finally {
			System.out.println("Finally");
		}
		
		System.out.println("Catch 1");
		
	 }

}
