package edu.allegheny.vanschedule.frontend;
import edu.allegheny.vanschedule.*;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class GoogleCalendar {
    /** Application name. */
    private static final String APPLICATION_NAME =
        "Cody Kinneer";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/calendar-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart. */
    private static final List<String> SCOPES =
        Arrays.asList(CalendarScopes.CALENDAR);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
            GoogleCalendar.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Calendar client service.
     * @return an authorized Calendar client service
     * @throws IOException
     */
    public static com.google.api.services.calendar.Calendar
        getCalendarService() throws IOException {
        Credential credential = authorize();
        return new com.google.api.services.calendar.Calendar.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

//    public static void main(String[] args) throws IOException {
      public static void addToCalendar(String summary, String location, String[] beginTime, String[] endTime) throws IOException {
        // Build a new authorized API client service.
        // Note: Do not confuse this class with the
        //   com.google.api.services.calendar.model.Calendar class.
        com.google.api.services.calendar.Calendar service =
            getCalendarService();
        
        Event event = new Event()
        	    .setSummary(summary)
        	    .setLocation(location)
        	    .setDescription(summary);

        	DateTime startDateTime = new DateTime("2015-12-07T" + beginTime[0] + ":" + beginTime[1] + ":00-05:00");
        	EventDateTime start = new EventDateTime()
        	    .setDateTime(startDateTime)
        	    .setTimeZone("America/New_York");
        	event.setStart(start);

        	DateTime endDateTime = new DateTime("2015-12-07T" + endTime[0] + ":" + endTime[1] + ":00-05:00");
        	EventDateTime end = new EventDateTime()
        	    .setDateTime(endDateTime)
        	    .setTimeZone("America/New_York");
        	event.setEnd(end);

        	String[] recurrence = new String[] {"RRULE:FREQ=WEEKLY;COUNT=16"};
        	event.setRecurrence(Arrays.asList(recurrence));

//        	EventAttendee[] attendees = new EventAttendee[] {
//        	    new EventAttendee().setEmail("lpage@example.com"),
//        	    new EventAttendee().setEmail("sbrin@example.com"),
//        	};
//        	event.setAttendees(Arrays.asList(attendees));
//
//        	EventReminder[] reminderOverrides = new EventReminder[] {
//        	    new EventReminder().setMethod("email").setMinutes(24 * 60),
//        	    new EventReminder().setMethod("popup").setMinutes(10),
//        	};
//        	Event.Reminders reminders = new Event.Reminders()
//        	    .setUseDefault(false)
//        	    .setOverrides(Arrays.asList(reminderOverrides));
//        	event.setReminders(reminders);

        	String calendarId = "shuttlevanschedule@gmail.com";
        	event = service.events().insert(calendarId, event).execute();
        	System.out.printf("Event created: %s\n", event.getHtmlLink());
        	
    }

}