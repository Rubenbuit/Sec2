import java.util.Random;
import java.util.*;


public class Rsa{
Wiskunde math = new Wiskunde();

public String encryptmessage(int privateKey,int publicKey, String message){
  String restult="";
  for(int i = 0; i< message.length();i++){
    int ancii = math.charToAnciiInt(message.charAt(i));
    long encryptedMessage = (math.powerOfN(ancii, privateKey))%publicKey;

  //  System.out.println("ancii: "+ ancii + " privateKey: "+privateKeyd +" publicKey: " +publicKeyd +" math powered" + Math.pow(ancii, privateKeyd));
//    System.out.println("verstuurd bericht: " + encryptedMessage);

//    restult +=( String.valueOf(Math.round(encryptedMessage)));// temp
    restult +=( String.valueOf(Math.round(encryptedMessage))+ ",");
  }
return restult;
}

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





}
