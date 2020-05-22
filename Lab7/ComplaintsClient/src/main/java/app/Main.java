/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mwlodarczyk
 */
public class Main {

    private static final String uri = "http://localhost:8080/Complaints/";
    
    private static List<Complaint> getAllComplaints(Client client) {        
        return client
                .target(uri + "resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>(){});
    }
    
    private static Complaint getComplaint(Client client) {
        return client
                .target(uri + "resources/complaints/1")
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint.class);                   
    }
    
    private static void closeComplaint(Client client, Complaint complaint) {
        complaint.setStatus("closed");
        
        client
                .target(uri + "resources/complaints/1")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(complaint, MediaType.APPLICATION_JSON));
    }
    
    private static List<Complaint> getAllOpenComplaints(Client client) {        
        return client
                .target(uri + "resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>(){});
    }

    public static void main(String args[]) {
        Client client = ClientBuilder.newClient();

        System.out.println("a. Pobierz i wyświetl na konsoli wszystkie skargi");
        System.out.println(getAllComplaints(client));
        
        System.out.println("b. Pobierz i wyświetl na konsoli jedną z otwartych skarg (przesyłając jej identyfikator do usługi)");
        Complaint sampleOpenComplaint = getComplaint(client);
        System.out.println(getComplaint(client));         

        System.out.println("c. Zmodyfikuj skargę pobraną w poprzednim punkcie zmieniając jej status na zamknięty (poprzez podmianę całego zasobu)");
        closeComplaint(client, sampleOpenComplaint);
        
        System.out.println("d. Pobierz i wyświetl na konsoli wszystkie otwarte skargi.");
        System.out.println(getAllOpenComplaints(client));
        
        client.close();
    }
}
