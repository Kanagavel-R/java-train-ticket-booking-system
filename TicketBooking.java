import java.util.Scanner;
public class TicketBooking {
        public static void main(String[] args) {
            TicketSystem ticketSystem=new TicketSystem();
            Scanner sc=new Scanner(System.in);
            while (true){
                System.out.println("\nRailway Booking System:");
                System.out.println("1. Book Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. view confirmed Tickets");
                System.out.println("4. view Available Tickets");
                System.out.println("5. view RAC Tickets");
                System.out.println("6. view Waiting List Tickets");
                System.out.println("7. Exit");
                System.out.println("Enter Your choice:");
                int ch=sc.nextInt();
                sc.nextLine();
                switch (ch){
                    case 1:
                        System.out.println("Enter Name:");
                        String name= sc.nextLine();
                        System.out.println("Enter Age:");
                        int age= sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Gender(Male/Female):");
                        String gender=sc.nextLine();
                        System.out.println("Enter Berth Preference(L/M/U):");
                        String berthPreference=sc.nextLine();
                        ticketSystem.bookTicket(name,age,gender,berthPreference);
                        break;
                    case 2:
                        System.out.println("Enter Ticket ID to Cancel:");
                        String ticketID=sc.nextLine();
                        ticketSystem.cancelTicket(ticketID);
                        break;
                    case 3:
                        ticketSystem.printBookedTickets();
                        break;
                    case 4:
                        ticketSystem.printAvailableTickets();
                        break;
                    case 5:
                        ticketSystem.viewRacTickets();
                        break;
                    case 6:
                        ticketSystem.viewWaitingListTickets();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.Try again.");
                }
            }
        }
}
