import java.util.Random;
import java.util.*;

public class Rsa{

public String encryptmessage(int privateKey,int publicKey, String message){
  String restult="";
  for(int i = 0; i< message.length();i++){
    double ancii = charToAnciiInt(message.charAt(i));
    double privateKeyd = Double.valueOf(privateKey);
    double publicKeyd= Double.valueOf(publicKey);
  //  System.out.println("ancii: "+ ancii + " privateKey: "+privateKeyd +" publicKey: " +publicKeyd +" math powered" + Math.pow(ancii, privateKeyd));
    double encryptedMessage = (Math.pow(ancii, privateKeyd))%publicKeyd;
    System.out.println(Math.round(encryptedMessage) + "verstuurd bericht");
//    "tempsss"
    restult +=( String.valueOf(Math.round(encryptedMessage)));
//    restult +=( String.valueOf(Math.round(encryptedMessage))+ ",");
  }
return restult;
}

public String decryptmessage(int privateKey, int publicKey, String message){
   double message_ = Double.valueOf(message);
   double privateKeyd = 11;
   double publicKeyd= Double.valueOf(publicKey);
   double decryptmessage = (Math.pow(message_, privateKeyd)%publicKeyd);
   String restult = anciiToChar(decryptmessage);
   System.out.println( "privateKey: "+privateKeyd +" publicKey: " +publicKeyd +" math powered" + Math.pow(message_, privateKeyd));
   System.out.println(" int valuue is decryptmessage: " + decryptmessage);
   return( restult);

}

public int createPrivateKey(int ggd, int modules)
{
  List<Integer> privateKey = new ArrayList<Integer>();
  for(int i = 2; i< ggd; i++)
  {
      if(modules % i != 0)
      {
        privateKey.add(i);
  //      System.out.println("added number:"  +i );
      }
  }
  return privateKey.get(privateKey.size()-1);
}

//converting a string into int
private double charToAnciiInt( char message){
  return (double) message;
}

//convert int back to string
private String anciiToChar( double message){
  return Character.toString((char)message);
}

public int createPrimeNumber(){
  boolean isPrimeFound = false;
  Random r = new Random();
  int primeNumber = 0;
  while(isPrimeFound == false)
  {
    int testPrimeNumber = r.nextInt(13);
    if( isPrime(testPrimeNumber) == true)
    {
      isPrimeFound = true;
      primeNumber = testPrimeNumber;
    }
  }
  return primeNumber;
}

private static boolean isPrime(int inputNum){
      if (inputNum <= 3 || inputNum % 2 == 0)
          return inputNum == 2 || inputNum == 3;
      int divisor = 3;
      while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
          divisor += 2;
      return inputNum % divisor != 0;
  }




}
