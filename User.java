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

  // constructor
  public User(Socket client, String name) throws IOException {
    this.streamOut = new PrintStream(client.getOutputStream());
    this.streamIn = client.getInputStream();
    this.client = client;
    this.nickname = name;
    this.userId = nbUser;
    this.color = ColorInt.getColor(this.userId);
    nbUser += 1;
  }
  // getteur
  public PrintStream getOutStream(){
    return this.streamOut;
  }

  public InputStream getInputStream(){
    return this.streamIn;
  }

  public void CreatePublicKey() {
    Random rand = new Random();
    int n = rand.nextInt(50);

    this.publicKey = Integer.toString(n);
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

class ColorInt {
    public static String[] mColors = {
            "#3079ab", // dark blue
            "#e15258", // red
            "#f9845b", // orange
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#f092b0", // pink
            "#e8d174", // yellow
            "#e39e54", // orange
            "#d64d4d", // red
            "#4d7358", // green
    };

    public static String getColor(int i) {
        return mColors[i % mColors.length];
    }
}
