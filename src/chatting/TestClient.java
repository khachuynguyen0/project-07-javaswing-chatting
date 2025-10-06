package chatting;

import java.io.*;
import java.net.*;

/**
 * Test client to verify server functionality without GUI.
 * This is a command-line test client that can be used for automated testing.
 */
public class TestClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String username;

    public TestClient(String username) {
        this.username = username;
    }

    public boolean connect() {
        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Send username
            out.println(username);
            System.out.println("[" + username + "] Connected to server");
            
            // Start listening thread
            new Thread(this::listenForMessages).start();
            
            return true;
        } catch (IOException e) {
            System.err.println("[" + username + "] Connection failed: " + e.getMessage());
            return false;
        }
    }

    public void sendMessage(String message) {
        if (out != null) {
            out.println(message);
            System.out.println("[" + username + "] Sent: " + message);
        }
    }

    private void listenForMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("[" + username + "] Received: " + message);
            }
        } catch (IOException e) {
            System.err.println("[" + username + "] Disconnected");
        }
    }

    public void disconnect() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("[" + username + "] Error closing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Chat Application Test...\n");
        
        // Create test clients
        TestClient client1 = new TestClient("Alice");
        TestClient client2 = new TestClient("Bob");
        TestClient client3 = new TestClient("Charlie");
        
        // Connect clients
        System.out.println("=== Connecting Clients ===");
        if (!client1.connect()) {
            System.err.println("ERROR: Make sure the server is running!");
            System.err.println("Run: java -cp bin chatting.Server");
            return;
        }
        Thread.sleep(500);
        client2.connect();
        Thread.sleep(500);
        client3.connect();
        Thread.sleep(1000);
        
        // Send test messages
        System.out.println("\n=== Sending Test Messages ===");
        client1.sendMessage("Hello everyone!");
        Thread.sleep(500);
        client2.sendMessage("Hi Alice!");
        Thread.sleep(500);
        client3.sendMessage("Hey there!");
        Thread.sleep(500);
        client1.sendMessage("This is a test of the chat application.");
        Thread.sleep(1000);
        
        // Disconnect one client
        System.out.println("\n=== Disconnecting Charlie ===");
        client3.disconnect();
        Thread.sleep(1000);
        
        // Continue chatting
        System.out.println("\n=== Continuing Chat ===");
        client1.sendMessage("Charlie left.");
        Thread.sleep(500);
        client2.sendMessage("See you later, Charlie!");
        Thread.sleep(1000);
        
        // Disconnect all
        System.out.println("\n=== Disconnecting All Clients ===");
        client1.disconnect();
        client2.disconnect();
        Thread.sleep(1000);
        
        System.out.println("\n=== Test Completed Successfully ===");
    }
}
