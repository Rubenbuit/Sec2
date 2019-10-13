import java.util.Random;

public class Rsa{

public String encryptmessage(String privateKey, String message){
  for(int i = 0; i< message.length();i++){
    int x = charToAnciiInt(message.charAt(i));
  }
return "done"
}

public String decryptmessage(String publicKey, String message){
  return( publicKey +message + "decrypt");
}

public String createPrivateKey(){
  return "A";
}

public String createPublicKey(){
  //Random rand = new Random();
  //int n = rand.nextInt(50);
  //return Integer.toString(n);
  return "B";
}

//converting a string into int
private int charToAnciiInt( char message){
  return (int) message;
}

//convert int back to string
private String anciiToChar( int message){
  return Character.toString((char)message);
}


}
