import java.util.*;
import java.io.*;
import java.lang.*;
class Bard
{
  public static void main(String[] args) throws IOException
  {
    Scanner shakespeare = new Scanner(new File("shakespeare.txt"));
    //      Map<Integer, String> wlength = new Hashtable<Integer, String>();
    Map<String, Integer> wfrequency = new Hashtable<String, Integer>();
    ArrayList<Frequency> frequencyList = new ArrayList<Frequency>();
    ArrayList<ArrayList<Frequency>> list = new ArrayList<ArrayList<Frequency>>();
    for(int i = 0; i < 50; i++)
    {
      ArrayList<Frequency> temp = new ArrayList<Frequency>();
      list.add(temp);
    }
    while(shakespeare.hasNextLine())
    {
      String line = shakespeare.nextLine().trim();
      //      line = line.replaceAll("\\p{Punct}|\\d", " ");
      line = line.replace("?", " ");
      line = line.replace("!", " ");
      line = line.replace(",", " ");
      line = line.replace(".", " ");
      line = line.replace(":", " ");
      line = line.replace(";", " ");
      line = line.replace("[", " ");
      line = line.replace("]", " ");
      line = line.toLowerCase();
      if(line != null && !line.isEmpty())
      {
        //          System.out.println(line);
        String[] words = line.split("\\s+");
        for(int i = 0; i < words.length; i++)
        {
          //if this word is a new word that never appeared before
          if(wfrequency.get(words[i]) == null)
          {
            wfrequency.put(words[i], 1);
            //              Frequency temp = new Frequency(1, words[i]);
            //              frequencyList.add(temp);
            //              wlength.put(words[i].length(), words[i]);
          }
          //if this word appeared before
          else
          {
            Integer temp = wfrequency.get(words[i]);
            //            dont know if the put will replace old key value pair with new one so remove old one just in case
            //            Integer tempVal = wfrequency.remove(words[i]);
            temp++;
            wfrequency.put(words[i], temp);
            // for(Frequency a : frequencyList)
            // {
            //   if(a.word.equals(words[i]))
            //   {
            //     a.freq++;
            //     break;
            //   }
            // }
          }
        }
        // for(int i = 0; i < wfrequency.size(); i++)
        // {
        //   System.out.println("word: " + wfrequency.keySet() + " Frequency: "+ wfrequency.get(i))
        // }
      }
    }
    Set<String> keys = wfrequency.keySet();

    Iterator<String> temp = keys.iterator();
    Iterator<String> o = keys.iterator();
    // while(o.hasNext())
    // {
    //   System.out.println("o: "+o.next());
    // }
    //      System.out.println("tempNext: "+temp.next() + " wfrequency next: " +wfrequency.get(temp.next()));
    int sizes = 0;
    //    System.out.println("f length: "+f.length + " f word "+f.word);
    //    System.out.println(temp.hasNext());
    //
    // while(o.hasNext())
    // {
    //   System.out.println("o: "+o.next());
    // }
    while(temp.hasNext())
    {
      //System.out.println(list.get(f.length));
      //      System.out.println(temp.next());
      String s = temp.next();
      Frequency f = new Frequency(s, wfrequency.get(s));
      if(list.size() < f.length)
      {
        while(list.size() < f.length)
        {
          ArrayList<Frequency> t = new ArrayList<Frequency>();
          list.add(t);
        }
      }

      System.out.println("list size: " + list.size());
      System.out.println("length" + f.length);
      System.out.println("word: " + f.word);
      System.out.println();
      // System.out.println("list length: "+list.size());
      // System.out.println("keys size: "+keys.size());
      if(f.length == 0)
        list.get(f.length).add(f);
      else
        list.get(f.length-1).add(f);
    }
    for(int i = 0; i < list.size(); i++)
    {
      Collections.sort(list.get(i));
      Collections.sort(list.get(i), new Frequency());
    }

    // System.out.println("sorted list: ");
    // for(int i = 0; i < list.size(); i++)
    // {
    //   for(int j = 0; j < list.get(i).size(); j++)
    //   {
    //     System.out.println(list.get(i).get(j).word + " " + list.get(i).get(j).freq);
    //   }
    // }
    /*
    for(int i = 0; i < frequencyList.size(); i++)
    {
    System.out.println(frequencyList.get(i).getWord() + " "+frequencyList.get(i).getFrequency());
  }
  System.out.println();
  */
  // System.out.println("blah");
  // for(int i = 0; i < frequencyList.size(); i++)
  //   System.out.println(frequencyList.get(i).getWord() + " " + frequencyList.get(i).getFrequency());
  //      System.out.println(String.toString(frequencyList));
  /*
  ArrayList<Map.Entry<String, Integer>> l = new ArrayList<Map.Entry<String, Integer>>(wfrequency.entrySet());
  Collections.sort(l, new Comparator<Map.Entry<String, Integer>>(){
  public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
  return o2.getValue().compareTo(o1.getValue());
}});
*/
/*
Map<String, List<Integer>> orderedVal = new TreeMap<String, List<Integer>>();
for(Entry<Integer, String> map : wfrequency.entrySet())
{
List<Integer> values = orderedVal.get(map.getValue());
if(keys == null){
keys = new ArrayList<?>();
orderedVals.put(map.getValue(), keys);
}
keys.add(map.getKey());
}
System.out.println(orderedMap.toString());
*/
Scanner in = new Scanner(new File(args[0]));
PrintWriter out = new PrintWriter(new File(args[1]));
while(in.hasNextLine())
{
  String l = in.nextLine();
  String[] tokens = l.split("\\s+");
  int leng = Integer.parseInt(tokens[0]);
//  leng -= 1;
  int rank = Integer.parseInt(tokens[1]);
  System.out.println("rank: "+rank);
  System.out.println("leng: "+leng);
  int rankCount = 0;
  String desiredWord = " ";
  boolean found = false;
  /*
  for(int i = 0; i < list.size(); i++)
  {
  //           System.out.println("count: "+ count+" "+frequencyList.get(i).getWord());
  if(count == fr && list.get(i).getWord().length() == leng)
  {
  desiredWord = list.get(i).getWord();
  found = true;
  break;
}
else if(count != fr && list.get(i).getWord().length() == leng)
{
count++;
}
}
*/
  if(list.get(leng - 1).isEmpty())
  {
    System.out.println("No such word with this number of letters");
    out.println("-");
  }
  else if(list.get(leng - 1).size() - 1 < rank)
  {
    out.println("-");
  }
  else if(list.get(leng - 1).get(rank) == null)
  {
    out.println("-");
  }
  else if(rank < 0)
  {
    out.println("-");
  }
  // else if(list.get(leng-1))
  // {
  //   if(leng > list.size())
  //   {
  //     out.println("-");
  //   }
  // }
  else
  {
    // System.out.println("list length at " + leng + " has " + list.get(leng).size() + " ranks");
    // System.out.println("length: "+list.get(leng - 1).get(rank).length+" "+" rank "+ rank);
    //
    // System.out.println();
    // out.println("length: "+list.get(leng - 1).get(rank).length+" "+" rank "+ rank);
    // out.println("leng "+leng);
    out.println(list.get(leng-1).get(rank).word);
  }
}
in.close();
out.close();
shakespeare.close();
}
}
