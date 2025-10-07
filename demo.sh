#!/bin/bash

# Script to demonstrate the Java Swing Chat Application

echo "==================================="
echo "Java Swing Chat Application Demo"
echo "==================================="
echo ""

# Check if Java is installed
echo "1. Checking Java installation..."
java -version
echo ""

# Compile the code
echo "2. Compiling the application..."
mkdir -p bin
javac -d bin src/chatting/*.java
if [ $? -eq 0 ]; then
    echo "✓ Compilation successful!"
else
    echo "✗ Compilation failed!"
    exit 1
fi
echo ""

# List compiled classes
echo "3. Compiled classes:"
find bin -name "*.class" | sort
echo ""

# Show server and client code structure
echo "4. Server features:"
echo "   - Multi-client support"
echo "   - Message broadcasting"
echo "   - Join/leave notifications"
echo "   - Thread-based client handling"
echo ""

echo "5. Client features:"
echo "   - Java Swing GUI with JFrame"
echo "   - JTextArea for chat display"
echo "   - JTextField and JButton for input"
echo "   - Real-time message reception"
echo "   - Auto-scrolling chat area"
echo ""

echo "6. To run the application:"
echo "   Terminal 1: java -cp bin chatting.Server"
echo "   Terminal 2: java -cp bin chatting.Client"
echo "   Terminal 3: java -cp bin chatting.Client"
echo "   (You can open multiple clients)"
echo ""

echo "==================================="
echo "Demo completed successfully!"
echo "==================================="
