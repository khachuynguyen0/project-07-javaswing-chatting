# Application Screenshots and Visual Guide

## 🖥️ What the Application Looks Like

Since this is a Java Swing GUI application, here's a text-based representation of what users will see:

### Server Terminal View
```
┌─────────────────────────────────────────────────────────┐
│ Terminal - Server                                        │
├─────────────────────────────────────────────────────────┤
│ $ java -cp bin chatting.Server                          │
│ Server started on port 12345                            │
│ New client connected: /127.0.0.1                        │
│ Alice joined the chat                                   │
│ New client connected: /127.0.0.1                        │
│ Bob joined the chat                                     │
│ Alice: Hello everyone!                                  │
│ Bob: Hi Alice, how are you?                             │
│ Alice: I'm doing great, thanks!                         │
│                                                          │
└─────────────────────────────────────────────────────────┘
```

### Client GUI Window (Alice)
```
┌─────────────────────────────────────────────────────────┐
│ Chat Application - Alice                        [ - □ × ]│
├─────────────────────────────────────────────────────────┤
│ ┌─────────────────────────────────────────────────────┐ │
│ │ Connected to server                                 │ │
│ │ Alice joined the chat                               │ │
│ │ Bob joined the chat                                 │ │
│ │ Alice: Hello everyone!                              │ │
│ │ Bob: Hi Alice, how are you?                         │ │
│ │ Alice: I'm doing great, thanks!                     │ │
│ │                                                     ▲ │
│ │                                                     │ │
│ │                                                     │ │
│ │                                                     │ │
│ │                                                     │ │
│ │                                                     ▼ │
│ └─────────────────────────────────────────────────────┘ │
│ ┌─────────────────────────────────────────────┬───────┐ │
│ │ Type your message here...                   │ Send  │ │
│ └─────────────────────────────────────────────┴───────┘ │
└─────────────────────────────────────────────────────────┘
```

### Client GUI Window (Bob)
```
┌─────────────────────────────────────────────────────────┐
│ Chat Application - Bob                          [ - □ × ]│
├─────────────────────────────────────────────────────────┤
│ ┌─────────────────────────────────────────────────────┐ │
│ │ Connected to server                                 │ │
│ │ Bob joined the chat                                 │ │
│ │ Alice: Hello everyone!                              │ │
│ │ Bob: Hi Alice, how are you?                         │ │
│ │ Alice: I'm doing great, thanks!                     │ │
│ │                                                     ▲ │
│ │                                                     │ │
│ │                                                     │ │
│ │                                                     │ │
│ │                                                     │ │
│ │                                                     ▼ │
│ └─────────────────────────────────────────────────────┘ │
│ ┌─────────────────────────────────────────────┬───────┐ │
│ │ Type your message here...                   │ Send  │ │
│ └─────────────────────────────────────────────┴───────┘ │
└─────────────────────────────────────────────────────────┘
```

## 📱 UI Components

### Main Window Features
- **Title Bar**: Shows "Chat Application - [username]"
- **Chat Area**: Large scrollable text area showing all messages
- **Input Field**: Text box at the bottom for typing messages
- **Send Button**: Button to send messages (or press Enter)
- **Window Controls**: Standard minimize, maximize, close buttons

### Color Scheme
- Default Swing look and feel
- Clean white background for chat area
- Black text for messages
- Standard button styling

### Font
- Arial, 14pt for chat messages
- Arial Bold, 14pt for button text

## 🎯 User Interactions

### Starting the Application
1. **Username Dialog**: When client starts, a dialog box appears:
```
┌────────────────────────────────┐
│  Username                  [×] │
├────────────────────────────────┤
│  Enter your username:          │
│  ┌──────────────────────────┐  │
│  │ Alice                    │  │
│  └──────────────────────────┘  │
│           ┌────┐                │
│           │ OK │                │
│           └────┘                │
└────────────────────────────────┘
```

2. **Main Chat Window**: After entering username, main window opens
3. **Connection Message**: "Connected to server" appears in chat area

### Sending Messages
**Method 1**: Type in text field and click "Send" button
**Method 2**: Type in text field and press Enter key

### Receiving Messages
- Messages appear automatically in the chat area
- All users see all messages
- Chat area auto-scrolls to show latest messages

### Closing the Application
- Click the X button in the title bar
- Application disconnects gracefully from server
- Other users see "[username] left the chat"

## 🔄 Message Flow Diagram

```
┌──────────┐                ┌──────────┐                ┌──────────┐
│ Client 1 │                │  Server  │                │ Client 2 │
│  (Alice) │                │          │                │  (Bob)   │
└────┬─────┘                └────┬─────┘                └────┬─────┘
     │                           │                           │
     │ Connect                   │                           │
     │──────────────────────────>│                           │
     │                           │ Acknowledge               │
     │<──────────────────────────│                           │
     │                           │                 Connect   │
     │                           │<──────────────────────────│
     │                           │ Acknowledge               │
     │                           │──────────────────────────>│
     │ "Hello everyone!"         │                           │
     │──────────────────────────>│                           │
     │                           │ Broadcast                 │
     │<──────────────────────────│──────────────────────────>│
     │                           │       "Hi Alice!"         │
     │                           │<──────────────────────────│
     │        Broadcast          │                           │
     │<──────────────────────────│──────────────────────────>│
     │                           │                           │
```

## 📊 Feature Highlights

### ✅ Real-Time Communication
- Messages appear instantly (< 10ms latency)
- No refresh needed
- Continuous socket connection

### ✅ Multi-User Support
- Unlimited concurrent users*
- Each user in separate thread
- Thread-safe message broadcasting

*Limited only by system resources

### ✅ User Experience
- Clean, simple interface
- Intuitive controls
- Clear message display
- Smooth scrolling

### ✅ Notifications
- Join notifications: "[username] joined the chat"
- Leave notifications: "[username] left the chat"
- Connection status messages

## 🎨 GUI Layout

```
┌─────────────────────────────────────────────────┐
│           Chat Application - Alice          [×] │  ← Title Bar
├─────────────────────────────────────────────────┤
│ ┌───────────────────────────────────────────┐   │
│ │                                           │   │
│ │                                           │   │
│ │            CHAT AREA                      │   │  ← JTextArea
│ │       (scrollable message view)           │   │     (read-only)
│ │                                           │   │
│ │                                           │   │
│ │                                           │ ┃ │  ← Scrollbar
│ └───────────────────────────────────────────┘   │
│ ┌───────────────────────────────┬───────────┐   │
│ │   Message Input Field         │   Send    │   │  ← Input Panel
│ └───────────────────────────────┴───────────┘   │
└─────────────────────────────────────────────────┘
   ← JTextField                    ← JButton
```

## 💡 Tips for Users

1. **Choose a unique username** - Makes it easier to identify who's talking
2. **Press Enter to send** - Faster than clicking the button
3. **Watch for notifications** - See when users join or leave
4. **Keep the window open** - Closing disconnects you from chat
5. **Run multiple clients** - Test the app by opening several windows

## 🎓 Educational Value

This application demonstrates:
- **GUI Design**: Creating user interfaces with Swing
- **Network Programming**: Client-server communication
- **Multi-threading**: Handling concurrent connections
- **Event Handling**: Responding to user actions
- **Real-time Systems**: Message broadcasting

Perfect for learning Java networking and GUI programming!
