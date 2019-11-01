import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.Color;

/*

Ruben Buitendijk
0890813
01-11-2019

summery
Voor deze opdracht is van github een java server met chat gui gedownload, de wiskunde erachter is zelf ontworpen en geschreven.
het hele project is ook te vinden op : https://github.com/Rubenbuit/Sec2

om het te starten moeten Server.java draaien en zijn er 2 ClientGui.java nodig die met elkaar kunnen chatten.


classes:
Server -- waar de server op wordt gedraaid
ClientGui -- hoe de chat gui eruit ziet
User -- waar de informatie van een gebruiker wordt opgeslagen
Rsa -- encrypten en decrypten van berichten
Wiskunde -- het creeren van de priemgetallen en het vercijferen van de characters

omdat Server en ClientGui voorzichzelf spreken en hier niks van de security gebeurd zal het niet uitgelegd worden.

Ook is er gebruik gemaakt van kleine priemgetallen, omdat de getallen al snel te groot werden en dit negatieve waardes gaf.
dit had (denk ik) opgelost kunnen worden met BigIntegers maar wegens tijdgebrek ben ik hier niet aan toe gekomen.
ook was ik van mening dat het meer om de uitleg ging van de wiskunde en het encrypten dan een werkend programma.

*/




public class Server {

  private int port;
  private List<User> clients;
  private ServerSocket server;

  public static void main(String[] args) throws IOException {
    new Server(12345).run();
  }

  public Server(int port) {
    this.port = port;
    this.clients = new ArrayList<User>();
  }

  public void run() throws IOException {
    server = new ServerSocket(port) {
      protected void finalize() throws IOException {
        this.close();
      }
    };
    System.out.println("Port 12345 is now open.");

    while (true) {
      Socket client = server.accept();
      String nickname = (new Scanner ( client.getInputStream() )).nextLine();
      nickname = nickname.replace(",", ""); //  ',' use for serialisation
      nickname = nickname.replace(" ", "_");
      System.out.println("New Client: \"" + nickname + "\"\n\t     Host:" + client.getInetAddress().getHostAddress());

      User newUser = new User(client, nickname);
      this.clients.add(newUser);
      newUser.getOutStream().println("Welcome to the Rsa encrypted chat program");
      this.sendPublicKey(newUser);
      new Thread(new UserHandler(this, newUser)).start();
    }
  }

  public void sendPublicKey(User sender){
    for(User client : this.clients)
    {
      if(client != sender)
      {
         client.receivePublicKey(sender.givePublicKey());
         client.receiveModules(sender.giveModules());
         sender.receiveModules(client.giveModules());
         sender.receivePublicKey(client.givePublicKey());
       }
    }
  }

  public void removeUser(User user){
    this.clients.remove(user);
  }

  public void broadcastMessages(String msg, User userSender) {
    String messageEncrypted = userSender.encryptTheMessage(msg);
    for (User client : this.clients) {
     String messageDecrypted   = client.decryptTheMessage(messageEncrypted);
      client.getOutStream().println(
         userSender.toString() + "<span>: " +"decryptmessage: " +messageDecrypted +"</span>");
    }
  }

  public void broadcastAllUsers(){
    for (User client : this.clients) {
      client.getOutStream().println(this.clients);
    }
  }

  public void sendMessageToUser(String msg, User userSender, String user){
    boolean find = false;
    for (User client : this.clients) {
      if (client.getNickname().equals(user) && client != userSender) {
        find = true;
        userSender.getOutStream().println(userSender.toString() + " -> " + client.toString() +": " + msg);
        client.getOutStream().println(
            "(<b>Private</b>)" + userSender.toString() + "<span>: " + msg+"</span>");
      }
    }
    if (!find) {
      userSender.getOutStream().println(userSender.toString() + " -> (<b>no one!</b>): " + msg);
    }
  }
}

class UserHandler implements Runnable {

  private Server server;
  private User user;

  public UserHandler(Server server, User user) {
    this.server = server;
    this.user = user;
    this.server.broadcastAllUsers();
  }

  public void run() {
    String message;

    Scanner sc = new Scanner(this.user.getInputStream());
    while (sc.hasNextLine()) {
      message = sc.nextLine();

      if (message.charAt(0) == '@'){
        if(message.contains(" ")){
          System.out.println("private msg : " + message);
          int firstSpace = message.indexOf(" ");
          String userPrivate= message.substring(1, firstSpace);
          server.sendMessageToUser(
              message.substring(
                firstSpace+1, message.length()
                ), user, userPrivate
              );
        }
      }else{
        server.broadcastMessages(message, user);
      }
    }
    server.removeUser(user);
    this.server.broadcastAllUsers();
    sc.close();
  }
}
