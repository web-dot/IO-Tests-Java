package com.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class PathNotFoundException extends Exception{
	public PathNotFoundException(String message) {
		super(message);
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
								Collections.sort(wordList);
								
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a path");
		String path = sc.nextLine();
		wordSort(path);
	}
}
