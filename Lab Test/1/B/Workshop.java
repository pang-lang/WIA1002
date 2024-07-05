
package labtest1;

public class Workshop extends Event{
    private String topic;
    private String instructor;

    public Workshop(String eventId, String eventName,  String eventDate, String topic, String instructor) {
        super(eventName, eventId, eventDate);
        this.topic = topic;
        this.instructor = instructor;
    }

    @Override
    public void displayEventDetails() {
         System.out.println("SportsGame" + " - ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + 
                 ", Topic: " + topic + ", Instructor: " + instructor);
    }
    
}
