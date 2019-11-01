import java.util.Random;
import java.util.*;

/*

Ruben Buitendijk
0890813
01-11-2019

In Server.java is de summery te lezen

*/

/*
in deze classe worden de berichten versleuteld en ontsleuteld
*/
public class Rsa{
Wiskunde math = new Wiskunde();
/*
 voor het encrypten werkt met deze berekening :
  ( message^other persons publickey ) mod  other persons modules
er wordt nu gebruik gemaakt van long, dit had achteraf aangepast kunnen worden naar een biginterger
om met grotere getallen te kunnen werken

de message wordt per letter gesplitst, vervolgesn wordt de ancii waarde berekend en wordt de encryptie gedaan
vervolgens worden de characters achter elkaar geplakt met een , ertussen
*/
public String encryptmessage(String message, int otherPublicKey, int otherModules)
{
  String result="";
  for(int i = 0; i< message.length();i++)
  {
    int ancii = math.charToAnciiInt(message.charAt(i));
    long encryptedChar = (math.powerOfN(ancii, otherPublicKey))%otherModules;
    result +=( String.valueOf(Math.round(encryptedChar))+ ",");
  }
  return result;
}

/*
 decrypten werkt met de volgende berekening:
 encryted message ^ mijn private key  modules mijn public key

 de mess wordt eesrt op de , gesplits.
 vervolgens wordt te berekening gedaan en wordt het resultaat achter elkaar geplakt.

*/
public String decryptmessage(String message, int myPrivateKey, int mypublicModules)
{
 String[] fullMessage = message.split(",");
 String decryptedMessage = "";
 for(int i =0; i< fullMessage.length; i++)
 {
   int charValueEncrypted = Integer.valueOf(fullMessage[i]);
   long charValueDecrypted = (math.powerOfN(charValueEncrypted, myPrivateKey) % mypublicModules);
   decryptedMessage += math.anciiToChar(charValueDecrypted);
 }
 return decryptedMessage;
}

/*
 deze functie creerd de private key
 hiervoor geld

 dat de public key * de unknown privatekey  modules commonFactor
    de commonfactor zou anders benaamd moeten worden, echter wist ik hier niets voorzichzelf
    commonfact houdt het volgende in :commonfactor = (primeNumberA -1) *(primeNumberB -1);

de functie begint bij 1 en blift zoeken naar het unknown( privatekey) tot de uitkomst van de som 1 is
dit zal de private key zijn
*/
public int createPrivateKey(int myPublicKey, int myCommonFactor)
{
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
