//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

public class Book
{
  public static String pigLatin(String word)
  {
    int index = 0;

    while ((word.charAt(index) != 'a') &&(word.charAt(index) != 'e') &&(word.charAt(index) != 'i') &&(word.charAt(index) != 'o') &&(word.charAt(index) != 'u')){
      index++;
    }
    if (index == 0){
      return word + "yay";
    }
    return word.substring(index) + word.substring(0,index) + "ay";
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
    int punctuation = Book.endPunctuation(word);

    String convertedWord = Book.pigLatin(word.substring(0,punctuation)) + word.charAt(punctuation);

    return convertedWord;
  }

  public String translateSentence(String sentence)
  {
    String retSentence = "";


    return retSentence;
  }
}  
