
package labtest1;

public class Concert extends Event{
    private String bandName;

    public Concert(String eventName, String eventId, String eventDate, String bandName) {
        super(eventId, eventName, eventDate);
        this.bandName = bandName;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("Concert" + " - ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + ", Band: "+ bandName);
    }
    
    
    
}
