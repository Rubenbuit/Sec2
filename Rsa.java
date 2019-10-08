import java.util.Random;

public class Rsa{


public String encryptmessage(String privateKey, String message){
  return(privateKey + "encrypt: " +message );
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

}
