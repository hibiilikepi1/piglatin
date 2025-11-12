//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.net.URL;


public class Book
{
  private static String book;
  private static int count = 0;

  public Book (String url){
    readBook(url);
  }
  public static void readBook(String link){
    try{
        URL url = new URL(link);
        Scanner in = new Scanner(url.openStream());
        while (in.hasNext()){
          String text = in.nextLine();
          text = Book.translateSentence(text);
         //System.out.println(text);
          book += text;
        }
    }
    catch(IOException ex){
      System.out.println("herro ur file isnt working");
    }
      
  
  }


  public static String pigLatin(String word)
  {

    count++;
    if(word.length() == 0){
      return word;
    }
    if(word.length() == 1){
      return word + "yay";
    }
    String numbers = "0123456789!?.";
    if(numbers.indexOf(word.substring(0,1)) >= 0){
      return word;
    }
    int index = 0;
    int upperyn = 0;
    if (Character.isUpperCase(word.charAt(index))){
      upperyn = 1;
    }
    word = word.toLowerCase();
    String vowels = "aeiouy";
    while (index < word.length()-1 && (vowels.indexOf(word.substring(index,index+1)) < 0)){
      index++;
    }
   // System.out.println(index);
    if (index == 0){
      if (upperyn == 0){
        return word + "yay";
      }
      else{
        return word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase() + "yay";
      }
      
    }
    if(upperyn == 0){
      return word.substring(index) + word.substring(0,index) + "ay";
    }
    else{
      return word.substring(index,index+1).toUpperCase()+ word.substring(index+1)+word.substring(0,index).toLowerCase() + "ay";
    }
    
  }
  
  public static int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {
    String puncString = ",.?!;:";
    for(int i = 0; i < word.length(); i ++){
      if (puncString.indexOf(word.charAt(i)) >= 0){
        return i;
      }
    }
    return -1;
  }

  public static String translateWord(String word)    //to share with class
  {
    String convertedWord = "";
    int punctuation = Book.endPunctuation(word);
    if (punctuation > 0){
      convertedWord = Book.pigLatin(word.substring(0,punctuation)) + word.substring(punctuation);
    }
    else{
      convertedWord = Book.pigLatin(word);
    }
    
    return convertedWord;
  }

  public static String translateSentence(String sentence)
  {
    String retSentence = "";
    
    while (sentence.indexOf(' ') > 0){ //maybe make >=
      int spaceindex = sentence.indexOf(' ');
      retSentence = retSentence + Book.translateWord(sentence.substring(0,spaceindex)) + " ";
      sentence = sentence.substring(spaceindex+1); 
    }
    if(sentence.length() > 0)
    {      
     retSentence = retSentence + Book.translateWord(sentence);
    }

    return retSentence;
  }

  public static int returnCount(){
    return count;
  }
}  