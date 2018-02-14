import java.util.*;
import java.io.*;
import java.lang.*;
class Frequency implements Comparator<Frequency>, Comparable<Frequency>
{
	int freq;
	String word;
	int length;
	Frequency()
	{

	}
	Frequency(String w, int f)
	{
		freq = f;
		word = w;
		this.length = w.length();
	}
	public String getWord()
	{
		return this.word;
	}
	public int getFrequency()
	{
		return this.freq;
	}
	public int compareTo(Frequency f)
	{
		return this.word.compareTo(f.word);
	}
	public int compare(Frequency f, Frequency f1)
	{
		return f1.freq - f.freq;
	}
}
