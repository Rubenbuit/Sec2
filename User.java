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
import java.util.Random;

/*

Ruben Buitendijk
0890813
01-11-2019

In Server.java is de summery te lezen

dit is de user klasse
hier worden de public key , private key en  public modules  opgeslagen
ook wordt hier de modules en public key van de andere gebruiker opgeslagen.

*/
public class User  {
  private static int nbUser = 0;
  private int userId;
  private PrintStream streamOut;
  private InputStream streamIn;
  private String nickname;
  private Socket client;
  private String color;
  public int myPublicKey;
  private int otherPublicKey;
  private int myPrivateKey;
  public int myModules;
  private int otherModules;
  private int primeNumberA;
  private int primeNumberB;
  private int commonFactor;
  Rsa rsa = new Rsa();
  Wiskunde w = new Wiskunde();

  public User(Socket client, String name) throws IOException {
    this.streamOut = new PrintStream(client.getOutputStream());
    this.streamIn = client.getInputStream();
    this.client = client;
    this.nickname = name;
    this.userId = nbUser;
    this.color = ColorInt.getColor(this.userId);
    nbUser += 1;

    primeNumberA = w.createPrimeNumber();
    primeNumberB = w.createPrimeNumber();
    myModules = primeNumberA * primeNumberB;

    // common factor moet nog anders genoemd worden
    commonFactor = (primeNumberA -1) *(primeNumberB -1);
    myPublicKey = 5 // hier kon zelf een getal voor gekozen worden?
    myPrivateKey = rsa.createPrivateKey(myPublicKey,commonFactor);
/*
dit laat is staan voor als je zelf de berekeningen wilt narekenen

    System.out.println("ggd: " +commonFactor);
    System.out.println("primeA: " +primeNumberA +" primeB: "+primeNumberB);
    System.out.println("modules: " +myModules);
    System.out.println("publickey: " + myPublicKey);
    System.out.println("privatekey: "+ myPrivateKey);
*/

}


  public PrintStream getOutStream(){
    return this.streamOut;
  }

  public InputStream getInputStream(){
    return this.streamIn;
  }

  public String encryptTheMessage(String message)
  {
   return rsa.encryptmessage(message, otherPublicKey, otherModules);
  }

  public String decryptTheMessage(String message)
  {
    return rsa.decryptmessage(message, myPrivateKey, myModules);
  }

  public void receivePublicKey(int key){
    this.otherPublicKey = key;
  }

  public void receiveModules(int modules){
    this.otherModules = modules;
  }

  public int givePublicKey(){
    return this.myPublicKey;
  }

  public int giveModules(){
    return this.myModules;
  }


  public String getNickname(){
    return this.nickname;
  }

  public String toString(){

    return "<u><span style='color:"+ this.color
      +"'>" + this.getNickname() + "</span></u>";

  }
}
