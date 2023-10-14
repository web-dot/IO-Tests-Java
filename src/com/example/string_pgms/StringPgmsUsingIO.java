package com.example.string_pgms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.FileWritingException;
import com.example.exceptions.IncorrectPathException;

public class StringPgmsUsingIO {
	
	// remove duplicates
	public static void writeUnique(String path) {
		if(path == null) {
			throw new IncorrectPathException();
		}
		File f = new File(path);
		if(f.exists() && f.isDirectory()) {
			File[] fa = f.listFiles();
			for(File file : fa) {
				if(file.exists() && file.isFile() && file.getName().endsWith(".txt")) {
					BufferedReader br = null;
					BufferedWriter bw = null;
					try {
						br = new BufferedReader(new FileReader(file));
						List<String> content = new ArrayList<>();
						String line;
						while((line = br.readLine()) != null) {
							String[] strArr = line.split(" ");
							for(String str : strArr) {
								str = str.toLowerCase();
								if(!content.contains(str)) {
									content.add(str);
								}
							}
						}
						br.close();
						br = null;
						bw = new BufferedWriter(new FileWriter(file));
						for(String str : content) {
							bw.write(str + " ");
						}
						System.out.println("File updated");
					}
					catch(IOException e) {
						throw new FileWritingException();
					}
					finally {
						if(br != null) {
							try { br.close(); }catch(IOException e) { e.printStackTrace();}
						}
						if(bw != null) {
							try { bw.close(); }catch(IOException e) {e.printStackTrace();};
						}
					}
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		writeUnique("C:\\Users\\fedev\\OneDrive\\Documents\\eclipse_workspaces\\primary_workspace\\IOTests\\text_files");
	}
}
