package Test;

import java.util.*;

public class Test{


   public static List<Pair> wordCountEngine(String doc){
      Map<String, Integer> map = new HashMap<String, Integer>();

      doc = doc.replaceAll("[,!?.]", "");
      String[] words = doc.split("\\s+");
      for(String word : words){
         if(map.containsKey(word)){
            map.put(word, map.get(word) + 1);
         }
         else{
            map.put(word, 1);
         }
      }

      List<Pair> orderedWords = new ArrayList<Pair>();
      TreeMap<String, Integer> tmap = new TreeMap<String, Integer>(Collections.reverseOrder());
      tmap.putAll(map);

      for(Map.Entry<String, Integer> entry: tmap.entrySet()){
         Pair pair = new Pair(entry.getKey(), entry.getValue());
         orderedWords.add(pair);
      }

      return orderedWords;
   }

   public static class Pair{
      String word;
      Integer count;

      public Pair(String word, Integer count){
         this.word = word;
         this.count = count;
      }
   }

   public static void main(String[] args){
      String words = "practice makes perfect. get perfect by practice. just practice!";
      List<Pair> result = wordCountEngine(words);
      for(Pair data : result){
         System.out.println(data.word + ": " + data.count);
      }
   }
}