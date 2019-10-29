import java.util.Random;

public class Wiskunde{

  public static long powerOfN(int number, int power)
  {
    if(power == 0) {return 1;}
    int result = number;

    while(power > 1)
    {
        result*=number;
        power--;
    }
    return (long)result;
  }

  //converting a string into int
  public int charToAnciiInt( char message){
  return (int) message;
  }

  //convert int back to string
  public String anciiToChar( long message){
      return Character.toString((char)message);
  }



  public int createPrimeNumber(){
    boolean isPrimeFound = false;
    Random r = new Random();
    int primeNumber = 0;
    while(isPrimeFound == false)
    {
      int testPrimeNumber = r.nextInt(10);
      if( isPrime(testPrimeNumber) == true)
      {
        isPrimeFound = true;
        primeNumber = testPrimeNumber;
      }
    }
    return primeNumber;
  }

  public static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0)
            return inputNum == 2 || inputNum == 3;
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
            divisor += 2;
        return inputNum % divisor != 0;
    }





}
