# Quick Start Guide

## Prerequisites
- Java JDK 8 or higher installed
- Terminal/Command Prompt access

## Step-by-Step Instructions

### 1️⃣ Compile the Application
```bash
cd project-07-javaswing-chatting
javac -d bin src/chatting/*.java
```
**Expected Output**: No errors

### 2️⃣ Start the Server
Open a terminal and run:
```bash
java -cp bin chatting.Server
```
**Expected Output**: 
```
Server started on port 12345
```
**Keep this terminal open!**

### 3️⃣ Start First Client
Open a **new terminal** and run:
```bash
java -cp bin chatting.Client
```
**What happens**:
1. A dialog box will appear asking for your username
2. Enter a name (e.g., "Alice") and click OK
3. A chat window will open
4. You'll see "Connected to server" in the chat area

### 4️⃣ Start More Clients
Open **another new terminal** and run:
```bash
java -cp bin chatting.Client
```
**What happens**:
1. Enter a different username (e.g., "Bob")
2. Both clients will see "Bob joined the chat"
3. You can now chat between clients!

### 5️⃣ Start Chatting!
In any client window:
1. Type a message in the text field at the bottom
2. Click "Send" or press Enter
3. Your message appears in **all** client windows

## Example Session

### Terminal 1 (Server)
```
Server started on port 12345
New client connected: /127.0.0.1
Alice joined the chat
New client connected: /127.0.0.1
Bob joined the chat
Alice: Hello everyone!
Bob: Hi Alice!
```

### Terminal 2 (Client - Alice)
```
[Chat Window shows:]
Connected to server
Alice joined the chat
Bob joined the chat
Alice: Hello everyone!
Bob: Hi Alice!
```

### Terminal 3 (Client - Bob)
```
[Chat Window shows:]
Connected to server
Bob joined the chat
Alice: Hello everyone!
Bob: Hi Alice!
```

## Quick Test (Automated)
Run the automated test to verify everything works:
```bash
# Terminal 1: Start server
java -cp bin chatting.Server

# Terminal 2: Run test
java -cp bin chatting.TestClient
```

The test will automatically:
- Connect 3 clients (Alice, Bob, Charlie)
- Send test messages
- Verify broadcasting
- Test disconnection
- Report results

## Troubleshooting

### Problem: "Server error: Address already in use"
**Solution**: Another program is using port 12345. Either:
- Stop the other program
- Or change the port in Server.java (line 11) and Client.java (line 12)

### Problem: "Cannot connect to server"
**Solution**: Make sure the server is running first!
1. Check Terminal 1 shows "Server started on port 12345"
2. If not, start the server: `java -cp bin chatting.Server`

### Problem: "class not found"
**Solution**: Compile the code first:
```bash
javac -d bin src/chatting/*.java
```

### Problem: Chat window doesn't open (Linux headless)
**Solution**: The application requires a display. Either:
- Use a system with GUI
- Use X11 forwarding
- Or use the TestClient for testing: `java -cp bin chatting.TestClient`

## Tips
- You can run as many clients as you want
- Each client needs a different username
- Messages are broadcast to ALL clients
- Close a client window to disconnect
- Press Ctrl+C in the server terminal to stop the server

## Architecture Diagram
```
┌──────────────────────────────────────┐
│         Server Terminal              │
│   java -cp bin chatting.Server       │
│                                      │
│   Listening on port 12345...         │
└──────────────────────────────────────┘
              ↕ ↕ ↕
    ┌─────────┘ │ └─────────┐
    ↕           ↕           ↕
┌─────────┐ ┌─────────┐ ┌─────────┐
│Client 1 │ │Client 2 │ │Client N │
│ Alice   │ │  Bob    │ │ Charlie │
│         │ │         │ │         │
│[GUI]    │ │[GUI]    │ │[GUI]    │
└─────────┘ └─────────┘ └─────────┘
```

## What You'll See

### Server Terminal
- Connection announcements
- User join messages
- All chat messages
- User leave messages

### Client Window
- Title bar: "Chat Application - [username]"
- Large chat area showing all messages
- Text field at bottom for typing
- Send button to send messages

Enjoy chatting! 💬
