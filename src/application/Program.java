package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy):");
		Date checkOut  = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
			
		}
		else {
			Reservation reserva = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut  = sdf.parse(sc.next());
			
			String erro = reserva.UpdateDates(checkIn, checkOut);
			if(erro==null) {
				reserva.UpdateDates(checkIn, checkOut);
				System.out.print(reserva);
			}
			else {
				System.out.print(erro);
			}
		
		}
		sc.close();
	}

}
