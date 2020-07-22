package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		try {
			System.out.print("Room Number");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Resrvation: " + reservation);
			
			System.out.println();
			System.out.println("Entrar com uma nova data para reserva: ");
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);		
			System.out.println("Resrvation: " + reservation);
		}
		catch (ParseException e){
			System.out.println("Formato da data inv�lido: ");
		}
		catch (DomainException e) {
			System.out.println("Error na reserva: " +e.getMessage());
		}
		
		sc.close();
	}

}
