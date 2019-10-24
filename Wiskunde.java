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
     if(message == 'a'|| message == 'A'){return 1;}
     else if( message == 'b' || message == 'B' ){ return 2;}
     else if( message == 'c' || message == 'C' ){ return 3;}
     else if( message == 'd' || message == 'D' ){ return 4;}
     else if( message == 'e' || message == 'E' ){ return 5;}
     else if( message == 'f' || message == 'F' ){ return 6;}
     else if( message == ' '){ return 7;}
     else {return 8;}
  }

  //convert int back to string
  public String anciiToChar( double message){
    if(message == 1){return "a";}
    else if (message ==2 ){return "b";}
    else if (message ==3 ){return "c";}
    else if (message ==4 ){return "d";}
    else if (message ==5 ){return "e";}
    else if (message ==6){return "f";}
    else if (message ==7 ){return " ";}
    else{
      return Character.toString((char)message);
    }
  }



  public int createPrimeNumber(){
    boolean isPrimeFound = false;
    Random r = new Random();
    int primeNumber = 0;
    while(isPrimeFound == false)
    {
      int testPrimeNumber = r.nextInt(200);
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
