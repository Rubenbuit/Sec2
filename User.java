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
  public String publicKey;
  private String privateKey;
  private int modulesNumber;
  private int primenumberA;
  private int primeNumberB;
  private int commonFactor;
  Rsa rsa = new Rsa();

  // constructor
  public User(Socket client, String name) throws IOException {
    this.streamOut = new PrintStream(client.getOutputStream());
    this.streamIn = client.getInputStream();
    this.client = client;
    this.nickname = name;
    this.userId = nbUser;
    this.color = ColorInt.getColor(this.userId);
    nbUser += 1;

    this.primeNumberA = rsa.createPrimeNumber();
    this.primeNumberB = rsa.createPrimeNumber();
    this.modulesNumber = this.primeNumberA * this.primeNumberB;
    this.commonFactor = (this.primeNumberA -1) *(this.primeNumberB -1);
    this.publicKey = rsa.createPublicKey();

}
  // getteur
  public PrintStream getOutStream(){
    return this.streamOut;
  }

  public InputStream getInputStream(){
    return this.streamIn;
  }

  public String getEncryptedMessage(String message){
    	return this.rsa.encryptmessage(this.privateKey, message);
  }

  public String getDecryptedMessage(String message){
    return rsa.decryptmessage(this.publicKey, message);
  }

  public String getPublicKey(){
    return this.publicKey;
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
