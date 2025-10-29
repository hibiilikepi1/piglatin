//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

public class Book
{
  public static String pigLatin(String word)
  {
    int index = 0;
    int upperyn = 0;
    if (Character.isUpperCase(word.charAt(index))){
      upperyn = 1;
    }

    while ((word.charAt(index) != 'a') &&(word.charAt(index) != 'e') &&(word.charAt(index) != 'i') &&(word.charAt(index) != 'o') &&(word.charAt(index) != 'u')){
      index++;
    }
    if (index == 0){
      if (upperyn == 0){
        return word + "yay";
      }
      else{
        return word.substring(0,1).toUpperCase()+word.toLowerCase().substring(1) + "yay";
      }
      
    }
    if(upperyn == 0){
      return word.substring(index) + word.substring(0,index) + "ay";
    }
    else{
      return word.substring(index,index+1).toUpperCase()+ word.substring(index+1)+word.substring(0,1).toLowerCase() + "ay";
    }
    
  }
  
  public static int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {
    if (word.indexOf('.') < 0  && word.indexOf('!') < 0&& word.indexOf('?')< 0){
      return -1;
    }
    else if (word.indexOf('.') > 0){
      return word.indexOf('.');
    }
    else if (word.indexOf('!') > 0){
      return word.indexOf('!');
    }
    else if (word.indexOf('?') > 0){
      return word.indexOf('?');
    }
    return 0;
  }

  public static String translateWord(String word)    //to share with class
  {
    String convertedWord = "";
    int punctuation = Book.endPunctuation(word);
    if (punctuation > 0){
      convertedWord = Book.pigLatin(word.substring(0,punctuation)) + word.charAt(punctuation);
    }
    else{
      convertedWord = Book.pigLatin(word);
    }
    

    return convertedWord;
  }

  public static String translateSentence(String sentence)
  {
    String retSentence = "";
    
    while (sentence.indexOf(' ') > 0){
      int spaceindex = sentence.indexOf(' ');
      retSentence = retSentence + Book.translateWord(sentence.substring(0,spaceindex)) + " ";
      sentence = sentence.substring(spaceindex+1); 
    }
    retSentence = retSentence + Book.translateWord(sentence);

    return retSentence;
  }
}  