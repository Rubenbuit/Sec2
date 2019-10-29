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
     else if( message == 'g' || message == 'G' ){ return 7;}
     else if( message == 'h' || message == 'H' ){ return 8;}
     else if( message == 'i' || message == 'I' ){ return 9;}
     else if( message == 'j' || message == 'J' ){ return 10;}
     else if( message == 'k' || message == 'K' ){ return 11;}
     else if( message == 'l' || message == 'L' ){ return 12;}
     else if( message == 'm' || message == 'M' ){ return 13;}
     else if( message == 'n' || message == 'N' ){ return 14;}
     else if( message == 'o' || message == 'O' ){ return 15;}
     else if( message == 'p' || message == 'P' ){ return 16;}
     else if( message == 'q' || message == 'Q' ){ return 17;}
     else if( message == 'r' || message == 'R' ){ return 18;}
     else if( message == 's' || message == 'S' ){ return 19;}
     else if( message == 't' || message == 'T' ){ return 20;}
     else if( message == 'u' || message == 'U' ){ return 21;}
     else if( message == 'v' || message == 'V' ){ return 22;}
     else if( message == 'w' || message == 'W' ){ return 23;}
     else if( message == 'x' || message == 'X' ){ return 24;}
     else if( message == 'y' || message == 'Y' ){ return 25;}
     else if( message == 'z' || message == 'Z' ){ return 26;}
     else if( message == ' '){ return 27;}
     else if( message == '.'){ return 28;}
     else {return 8;}
  }

  //convert int back to string
  public String anciiToChar( double message){
    if(message == 1){return "a";}
    else if (message ==2 ){ return "b";}
    else if (message ==3 ){ return "c";}
    else if (message ==4 ){ return "d";}
    else if (message ==5 ){ return "e";}
    else if (message ==6 ){ return "f";}
    else if (message ==7 ){ return "g";}
    else if (message ==8 ){ return "h";}
    else if (message ==9 ){ return "i";}
    else if (message ==10 ){ return "j";}
    else if (message ==11 ){ return "k";}
    else if (message ==12 ){ return "l";}
    else if (message ==13 ){ return "m";}
    else if (message ==14 ){ return "n";}
    else if (message ==15 ){ return "o";}
    else if (message ==16 ){ return "p";}
    else if (message ==17 ){ return "q";}
    else if (message ==18 ){ return "r";}
    else if (message ==19 ){ return "s";}
    else if (message ==20 ){ return "t";}
    else if (message ==21 ){ return "u";}
    else if (message ==22 ){ return "v";}
    else if (message ==23 ){ return "w";}
    else if (message ==24 ){ return "x";}
    else if (message ==25 ){ return "y";}
    else if (message ==26 ){ return "z";}
    else if (message ==27 ){ return " ";}
    else if (message ==28 ){return ".";}
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
