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

private int createPrimeNumber(){
  boolean isPrimeFound = false;
  Random r = new Random();
  int primeNumber = 0;
  while(isPrimeFound == false)
  {
    int testPrimeNumber = r.nextInt(50);
    if( isPrime(testPrimeNumber) == true)
    {
      isPrimeFound = true;
      primeNumber = testPrimeNumber;
    }
  }
  System.out.println("priem: "+primeNumber);
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
