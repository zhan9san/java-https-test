# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Create app directory
WORKDIR /app

# Copy the Java file
COPY JavaHttpsTest.java .

# Compile the Java program
RUN javac JavaHttpsTest.java

# Run the test with debug flags
ENTRYPOINT ["java", "-Djavax.net.debug=all", "JavaHttpsTest"]
CMD ["https://file.zoom.us"]
