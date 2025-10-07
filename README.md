# Java Swing Chatting Application

A simple multi-client chat application built with Java Swing for the GUI and Java Sockets for networking.

## Features

- Multi-client chat support
- Real-time message broadcasting
- User-friendly GUI with Java Swing
- Server-client architecture
- Join/leave notifications

## Project Structure

```
project-07-javaswing-chatting/
├── src/
│   └── chatting/
│       ├── Server.java    # Server class handling multiple clients
│       └── Client.java    # Client GUI class with Swing interface
└── README.md
```

## Requirements

- Java Development Kit (JDK) 8 or higher

## How to Build

Compile the Java files from the project root directory:

```bash
javac -d bin src/chatting/*.java
```

Or compile individually:

```bash
javac src/chatting/Server.java
javac src/chatting/Client.java
```

## How to Run

### Step 1: Start the Server

First, start the server:

```bash
java -cp src chatting.Server
```

Or if compiled:

```bash
java -cp bin chatting.Server
```

The server will start listening on port 12345.

### Step 2: Start Client(s)

Open a new terminal for each client and run:

```bash
java -cp src chatting.Client
```

Or if compiled:

```bash
java -cp bin chatting.Client
```

You can run multiple clients to test the chat functionality.

### Step 3: Chat!

1. When the client starts, enter your username in the dialog box
2. Type your message in the text field at the bottom
3. Click "Send" or press Enter to send the message
4. All connected clients will receive the message in real-time

## Usage Example

1. Start the server in one terminal
2. Open multiple terminals and start clients
3. Enter different usernames for each client
4. Start chatting - messages will be broadcast to all connected clients

## Server Configuration

The server runs on `localhost:12345` by default. To change the port, modify the `PORT` constant in `Server.java`.

## Client Configuration

The client connects to `localhost:12345` by default. To connect to a different server, modify the `SERVER_HOST` and `SERVER_PORT` constants in `Client.java`.

## Architecture

### Server
- Handles multiple client connections using threads
- Broadcasts messages to all connected clients
- Manages client join/leave events
- Uses `ServerSocket` for accepting connections

### Client
- Java Swing GUI with JTextArea for chat display
- JTextField and JButton for message input
- Socket connection to the server
- Separate thread for receiving messages
- Auto-scrolling chat area

## License

This project is open source and available for educational purposes.
