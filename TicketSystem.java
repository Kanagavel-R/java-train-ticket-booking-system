import java.util.*;
public class TicketSystem {
    private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "U", "M"));
    private final Queue<Passenger> racQueue = new LinkedList<>();
    private final Queue<Passenger> waitingListQueue = new LinkedList<>();
    private final List<Passenger> confirmedPassengers = new ArrayList<>();
    private int ticketCounter = 1;

    public void bookTicket(String name, int age, String gender, String brethPreference) {
        String ticketId = "" + ticketCounter++;
        Passenger passenger;
        if (!availableBerths.isEmpty()) {
            String allocatedBreadth=allocateBreadth(age,gender,brethPreference);
            passenger=new Passenger(name,age,gender,brethPreference,allocatedBreadth,ticketId);
            confirmedPassengers.add(passenger);
            availableBerths.remove(allocatedBreadth);
            System.out.println("Ticket confirmed:"+passenger);

        }else if(racQueue.size()<1){
            passenger = new Passenger(name, age, gender,brethPreference, "RAC",ticketId);
            racQueue.offer(passenger);
            System.out.println("Ticket in RAC:"+passenger);
        }else if(waitingListQueue.size()<1){
            passenger = new Passenger(name, age, gender,brethPreference, "Waiting List",ticketId);
            waitingListQueue.offer(passenger);
            System.out.println("Ticket in Waiting List");

        }else{
            System.out.println("No tickets available");
        }
    }
    private String allocateBreadth(int age,String gender,String preference){
        if(age>60||gender.equalsIgnoreCase("female")&&availableBerths.contains("L")){
            return "L";
        }
        if(availableBerths.contains(preference)){
            return preference;
        }
        return availableBerths.get(0);

    }
    public void cancelTicket(String ticketId){
        Optional<Passenger>passengerOPt=confirmedPassengers.stream().filter(p->p.ticketId.equals(ticketId))
                .findFirst();
        if(passengerOPt.isPresent()){
            Passenger passenger=passengerOPt.get();
            confirmedPassengers.remove(passenger);
            availableBerths.add(passenger.AllotedBerth);
            if(!racQueue.isEmpty()){
                Passenger racPassenger=racQueue.poll();
                String allocatedBreth=allocateBreadth(racPassenger.age,racPassenger.gender,racPassenger.berthPreference);
                racPassenger.AllotedBerth=allocatedBreth;
                confirmedPassengers.add(racPassenger);
                availableBerths.remove(allocatedBreth);
                System.out.println("RAC ticket moved to confirmed:"+racPassenger);
            }
            if(!waitingListQueue.isEmpty()){
                Passenger waithingPassenger=waitingListQueue.poll();
                racQueue.offer(waithingPassenger);
                waithingPassenger.AllotedBerth="RAC";
                System.out.println("Waithing list ticket moved to RAC:");
            }
            System.out.println("Ticket cancelled successfully for ID:"+ticketId);
        }else{
            System.out.println("No ticket found with ID:"+ticketId);
        }}
    public void printBookedTickets() {
        if (confirmedPassengers.isEmpty()) {
            System.out.println("No confirmed Tickets.");
        } else {
            System.out.println("Confirmed Tickets:");
            for (Passenger passenger : confirmedPassengers) {
                System.out.println(passenger);
            }

        }

    }
    public void printAvailableTickets(){
        System.out.println("Available Berths:"+availableBerths.size());
        System.out.println("Available RAC Tickets:"+(1- racQueue.size()));
        System.out.println("Available Waiting List Tickets:"+(1- waitingListQueue.size()));
    }
    public void viewRacTickets() {
        if (racQueue.isEmpty()) {
            System.out.println("No RAC Tickets.");
        } else {
            System.out.println("RAC Tickets:");
            for (Passenger passenger : racQueue) {
                System.out.println(passenger);
            }
        }}
    public void viewWaitingListTickets() {
        if (waitingListQueue.isEmpty()) {
            System.out.println("No Waiting List Tickets.");
        } else {
            System.out.println("Waiting List Tickets:");
            for (Passenger passenger : waitingListQueue) {
                System.out.println(passenger);
            }
        }
    }
}
