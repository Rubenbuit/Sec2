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


public class User  {
  private static int nbUser = 0;
  private int userId;
  private PrintStream streamOut;
  private InputStream streamIn;
  private String nickname;
  private Socket client;
  private String color;
  public int myPublicKey =5;
  private int otherPublicKey;
  private int privateKey;
  public int myModules;
  private int otherModules;
  private int primeNumberA =7  ;
  private int primeNumberB  =2;
  private int commonFactor;
  Rsa rsa = new Rsa();
  Wiskunde w = new Wiskunde();

  // constructor
  public User(Socket client, String name) throws IOException {
    this.streamOut = new PrintStream(client.getOutputStream());
    this.streamIn = client.getInputStream();
    this.client = client;
    this.nickname = name;
    this.userId = nbUser;
    this.color = ColorInt.getColor(this.userId);
    nbUser += 1;

    //gedeelt wordt myModules en myPublicKey



  //  primeNumberA = w.createPrimeNumber();
  //  primeNumberB = w.createPrimeNumber();
    myModules = primeNumberA * primeNumberB;
    // common factor moet nog anders genoemd worden
    commonFactor = (primeNumberA -1) *(primeNumberB -1);




  //  privateKey = rsa.createPrivateKey(commonFactor, modulesNumber);
    /*
    System.out.println("ggd: " +commonFactor);
    System.out.println("primeA: " +primeNumberA +" primeB: "+primeNumberB);
    System.out.println("modules: " +modulesNumber);
    System.out.println("publickey: " + publicKey );
    System.out.println("privatekey: "+ privateKey);
*/
}
  // getteur
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

  public String getDecryptedMessage(String message){

    // private key voor decrypten omet nog verzonnen worden
    return rsa.decryptmessage(privateKey, publicKey, message);

  }

  public int givePublicKey(){
    return this.myPublicKey;
  }

  public void receivePublicKey(int key){
    this.otherPublicKey = key;
  }

  public void receiveModules(int modules){
    this.otherModules = modules;
  }

  public int giveModules(){
    return this.myModules;
  }


  public String getNickname(){
    return this.nickname;
  }

  // print user with his color
  public String toString(){

    return "<u><span style='color:"+ this.color
      +"'>" + this.getNickname() + "</span></u>";

  }
}
