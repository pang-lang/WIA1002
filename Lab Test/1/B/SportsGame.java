
package labtest1;

public class SportsGame extends Event{
    private String gameType;

    public SportsGame(String eventName, String eventId, String eventDate,String gameType) {
        super(eventId, eventName, eventDate);
        this.gameType = gameType;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("SportsGame" + " - ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + ", Type: "+ gameType);
        
    }
    
    
    
}
