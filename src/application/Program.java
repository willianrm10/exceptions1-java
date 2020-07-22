package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		System.out.print("Room Number");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error, data de checkout tem que ser maior que a data de check-in");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Resrvation: " + reservation);
			
			System.out.println();
			System.out.println("Entrar com uma nova data para reserva: ");
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("error, data não pode ser menor que a data atual: ");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Error, data de checkout tem que ser maior que a data de check-in");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Resrvation: " + reservation);
			}
			
			
		}
		
		sc.close();
	}

}
