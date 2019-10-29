import java.util.Random;
import java.util.*;


public class Rsa{
Wiskunde math = new Wiskunde();

public String encryptmessage(String message, int otherPublicKey, int otherModules)
{
  System.out.println("op: "+ otherPublicKey + " om: "+otherModules);
  String result="";
  for(int i = 0; i< message.length();i++)
  {
    int ancii = math.charToAnciiInt(message.charAt(i));
    System.out.println("char value is: " + ancii);
    System.out.println("power of is: " +math.powerOfN(ancii, otherPublicKey));
    long encryptedChar = (math.powerOfN(ancii, otherPublicKey))%otherModules;
    System.out.println("char verstuurd" +encryptedChar);
    result +=( String.valueOf(Math.round(encryptedChar))+ ",");
  }
  return result;

}
public String decryptmessage(String message, int myPrivateKey, int mypublicModules)
{
//  encryptedchar ^ myprivate key  mod  my publicmodules
 String[] fullMessage = message.split(",");
 String decryptedMessage = "";
 for(int i =0; i< fullMessage.length; i++)
 {
   int charValueEncrypted = Integer.valueOf(fullMessage[i]);
   long charValueDecrypted = (math.powerOfN(charValueEncrypted, myPrivateKey) % mypublicModules);
   System.out.println("char teruggekregen"+charValueDecrypted);
   decryptedMessage += math.anciiToChar(charValueDecrypted);
 }
 return decryptedMessage;
}

public int createPrivateKey(int myPublicKey, int myCommonFactor)
{
   // mypublickey * ? mod commonFactor =1
  int result = 0;
  boolean isKeyFound = false;
  int unknown =1;
  while(isKeyFound == false)
  {
    if((myPublicKey * unknown)% myCommonFactor ==1)
    {
      result = unknown;
      isKeyFound = true;
    }
    else{unknown +=1;}
  }
  return result;
}

}

/*
public String decryptmessage(int privateKey, int publicKey, String message){

   String[] messageArray = message.split(",");
   String result= "";
   for(int i =0; i< messageArray.length; i++)
   {
    int message_ = Integer.valueOf(messageArray[i]);
    long decryptmessage = (math.powerOfN(message_, privateKey)%publicKey);
    result += math.anciiToChar(decryptmessage);
  }

  // System.out.println("message: "+ message_ + "privateKey: "+privateKeyd +" publicKey: " +publicKeyd +" math powered" + Math.pow(message_, privateKeyd));
//   System.out.println("restul: "+ decryptmessage);
   return result;
  }
*/

/*
public int createPrivateKey(int ggd, int modules)
{
  List<Integer> privateKey = new ArrayList<Integer>();
  for(int i = 2; i< ggd; i++)
  {
      if(modules % i != 0)
      {
        privateKey.add(i);
      }
  }
  return privateKey.get(privateKey.size()-1);
}
*/
