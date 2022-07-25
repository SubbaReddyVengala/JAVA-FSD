package com.simplilearn.FileHandling;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
public class FileHandlingDemo {
	public static void createWriteFile() throws IOException{
		File a=new File("D:\\FileHandling\\test1.txt");
		if(a.createNewFile()) {
			System.out.println("File created");
		}else {
			System.out.println("File already exists");
		}
		FileWriter b = new FileWriter(a,false);
		b.write("Hello there!");
		b.close();
	}
	public static void readFile() throws IOException
	{ 
		FileReader reader= new FileReader("D:\\FileHandling\\test1.txt");
		
		int data;
		
		while((data=reader.read())!=-1){
			
			System.out.print((char)data);
			
		}
		System.out.println("\nFile readed Succesfully");
		
	}
	public static void appendFile()throws IOException{
		Path d= Paths.get("D:\\FileHandling\\test1.txt");
		String e = " How are you?";
		byte arr[]= e.getBytes();
		Files.write(d, arr, StandardOpenOption.APPEND);
		System.out.println("File Appended Successfully");
	}
	public static void main(String[] args) {
		try {
			Scanner sin =new Scanner(System.in);
			while(true)
			{
			int ch;
			System.out.println("1.Create File 2.Read File 3.Append File\n");
			ch=sin.nextInt();
			switch(ch)
			{
			case 1:
				createWriteFile();
				break;
			case 2:
				readFile();
				break;
			case 3:
				appendFile();
				break;
			default :
				System.out.println("Please Enter Numbers Between 1-3 ");
			}
			
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
