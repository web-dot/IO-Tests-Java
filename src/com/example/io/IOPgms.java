package com.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class PathNotFoundException extends Exception{
	public PathNotFoundException(String message) {
		super(message);
	}
}

class StringComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
}

public class IOPgms {
	
	/**
	 * -> print words in sorted manner with duplicates
	 * -> print words in sorted manner without duplicates
	 * -> print words in reverse sorted manner
	 * */
	public static void wordSort(String path) {
		if(path == null) {
			throw new IllegalArgumentException();
		}
		File f = new File(path);
		if(f.exists() && f.isDirectory()) {
			File[] fa = f.listFiles();
			for(File file : fa) {
				if(file.exists() && file.isFile() && file.getName().endsWith(".txt")) {
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(file));
						String line;
						List<String> wordList = new ArrayList<>();
						Set<String> wordSet = new TreeSet<>();
						while((line = br.readLine()) != null) {
							String[] words = line.split(" ");
							for(String s : words) {
								wordList.add(s);
								wordSet.add(s);
								/*sort in List*/
								//Collections.sort(wordList);
								/**reverse sort in list*/
								Collections.sort(wordList, new StringComparator());
							}
						}
						System.out.println("sorted in List with duplicates= " + wordList);
					}
					catch(IOException e) {
						
					}
				}
			}
		}
	}
	
	/**num of occurances of a word in a file*/
	public static void countOccuranceOfWord(String path, String str) throws PathNotFoundException {
		if(path == null) {
			throw new PathNotFoundException("Path can not be null");
		}
		File f = new File(path);
		if(f.exists() && f.isDirectory()) {
			File[] fa = f.listFiles();
			for(File file : fa) {
				if(file.exists() && file.isFile() && file.getName().endsWith(".txt")) {
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(file));
						String line;
						int count = 0;
						int pos = 0;
						while((line = br.readLine()) != null) {
							while((pos = line.indexOf(str, pos)) != -1) {
								++count;
								++pos;
							}
						}
						System.out.println("count of the word: " + count);
					}
					catch(Exception e) {
						
					}
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws PathNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a path");
		String path = sc.nextLine();
		//wordSort(path);
		countOccuranceOfWord(path, "an");
	}
}
