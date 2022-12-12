package com.company;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Project{
	
	static Map<String, String> map = new HashMap<>();
    
	public static void sortbykey(){
        // TreeMap to store values of HashMap
        
		TreeMap<String,String > sorted = new TreeMap<>();
 
        // Copy all data from hashMap into TreeMap
        
		sorted.putAll(map);
		
        // Display the TreeMap which is naturally sorted
        
		for (Map.Entry<String, String> entry : sorted.entrySet()){
			
			System.out.println("Name = " + entry.getKey() + ", Contact = " + entry.getValue());
		
		}
    } 
	public static void main(String[] args) {
	 
		HashMap<String,String> hm= new HashMap<String, String>();
		ArrayList<String> list= new ArrayList<>();
	 	// Linkedlist list= new Linkedlist();
    
		try {
			File myObj = new File("C:\\Users\\Faizan\\Desktop\\Proj\\src\\com\\company\\DSA.txt");
			Scanner myReader = new Scanner(myObj);
			String d="";
		
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
			
				String con[]= data.split(":");
			
				//System.out.print("Name : " + con[0]);
				//System.out.println("   Number : " + con[1]);
				
				hm.put(con[0],con[1]);
				map.put(con[0],con[1]);
			
			}
		
			Scanner sc= new Scanner(System.in);
			int x=0;
			do{
				System.out.println("*********Options***********");
				System.out.println("Press 1: Add new contact :");
				System.out.println("Press 2: Delete contact : ");
				System.out.println("Press 3: update contact : ");
				System.out.println("Press 4: search contact : ");
				System.out.println("Press 5: show all Recent contacts : ");
				System.out.println("Press 6: sorted contacts and size :");
				System.out.println("Press 7: Clear all contacts : ");
				System.out.println("Press 8: Exit program : ");
				
				while(true){
			
					System.out.print("Enter choice : ");
					int a=sc.nextInt();
					
					
					// Add contacts
					if(a==1){
						System.out.print("Enter name  : ");
						String name=sc.next();
						System.out.print("Enter phone : ");
						String contact= sc.next();
						map.put(name,contact);
						hm.put(name,contact);
						
					}
					
					// delete contact
					if(a==2){
						System.out.print("Enter name  : ");
						String name=sc.next();
						System.out.println(hm.remove(name));
					}
			
					// Updated contacts
			
					if(a==3){
						System.out.print("Enter name  : ");
						String name=sc.next();
						System.out.println("Updated contacts : "+hm);
					}   
					//search
					if(a==4){

						System.out.print("Enter name  : ");
						String ss= sc.next();
						
						if(hm.containsKey(ss)){
					
							System.out.println(hm.get(ss));
							System.out.println("Press M: Message.");
							System.out.println("Press C: Call.");
							String c=sc.next();
							
							if(c.equalsIgnoreCase("M")){
								
								System.out.println("Enter message    "+"        Press Send");
								String message=sc.nextLine();
								
								if(message.equalsIgnoreCase("Send")){
									return;
								}
				
							}
							if(c.equalsIgnoreCase("C")){
								System.out.println("Calling......");
								list.add(ss);
							}

						}

					}
			
					//  show all Recent contacts
					if(a==5){
						System.out.println(list);
					} 
					
					//  show all contacts in ascending order
					if(a==6){
						System.out.println("All contacts in sorted :  ");  
						sortbykey();
						System.out.println("\n\nTotal saved contacts : "+hm.size()+"\n");
						
					}
					
					//  clear all contacts 
					if(a==7){
						hm.clear();
						System.out.println(hm);
						System.out.println("All contacts are Removed : ");
					}
					
					if(a==8){
						x=1; 
						break;
					}
					
					System.out.println("\n******Options********");
					System.out.println("Press 1: Add new contact :");
					System.out.println("Press 2: Delete contact : ");
					System.out.println("Press 3: update contact : ");
					System.out.println("Press 4: search contact : ");
					System.out.println("Press 5: show all Recent contacts : ");
					System.out.println("Press 6: sorted contacts and size :");
					System.out.println("Press 7: Clear all contacts : ");
					System.out.println("Press 8: Exit program : \n");
					
				}
			
			}while(x!=1);
	  
      		myReader.close();
	  
    	} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}