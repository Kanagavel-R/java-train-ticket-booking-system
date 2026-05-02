//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Passenger {

    String name;
    int age;
    String gender;
    String berthPreference;
    String AllotedBerth;
    String ticketId;
    Passenger(String name, int age, String gender, String breathPreference, String AllotedBreath, String ticketId){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.berthPreference=breathPreference;
        this.AllotedBerth=AllotedBreath;
        this.ticketId=ticketId;
    }
    @Override
    public String toString(){
        return "Ticket ID:"+ticketId+",Name:"+name+",Age:"+age+",Gender:"+gender+",Bredth:"+AllotedBerth;
    }
}
