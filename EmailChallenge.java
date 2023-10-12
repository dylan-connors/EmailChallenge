import java.io.*;
import java.net.*;

public class EmailChallenge {
  public static void main(String[] args) throws Exception {
    // Takes username as input from user
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Username: ");
    String username = br.readLine();

    // Concatenates username and url stub to form full url
    URL url = new URL("https://www.southampton.ac.uk/people/" + username);
    
    // Reads lines from the webpage
    URLConnection connection = url.openConnection();
    BufferedReader webReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String line;
    while ((line = webReader.readLine()) != null) {
            if (line.contains("<h1 class=\"heading-m inline-block text-prussianDark\">")) {
		    // Extracts name from between tags
		    String[] splitLine = line.split(">");
		    splitLine = splitLine[1].split("<");
		    String name = splitLine[0];
		    System.out.println(name);
            }
    }


    webReader.close();
  }
}
