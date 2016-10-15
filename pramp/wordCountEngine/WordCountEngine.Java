package Test;

import java.util.*;

public class Test {
   
   public static List<Pair> wordCountEngine(String doc){
      Map<String, Integer> wordCounter = new HashMap<String, Integer>();
      
      doc = doc.replaceAll("[!?,]", "");
      String[] words = doc.split("\\W+");
      
      for(int i = 0; i < words.length; i++){
         if(wordCounter.containsKey(words[i])){
            wordCounter.put(words[i], wordCounter.get(words[i]) + 1);
         }
         else{
            wordCounter.put(words[i], 1);
         }
      }
      
      Map<String, Integer> treeMap = new TreeMap<String, Integer>(Collections.reverseOrder());
      treeMap.putAll(wordCounter);
      
      List<Pair> sortedWordCounter = new ArrayList<Pair>();
      for(Map.Entry<String, Integer> entry: treeMap.entrySet()){
         Pair data = new Pair(entry.getKey(), entry.getValue());
         sortedWordCounter.add(data);
      }
      
      return sortedWordCounter;
   }
   
   public static class Pair {
      private String word;
      private Integer count;
      
      public Pair(String word, Integer count){
         this.word = word;
         this.count = count;
      }
   }
   
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
   }
   
}


//Time complexity O(n + m log m)
//Space complexity O(n + m) // m stands for unique items in the words