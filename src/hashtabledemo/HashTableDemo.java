
package hashtabledemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author YAHIYAMANSURI
 */
public class HashTableDemo {

    private static final int SIZE = 97;
	private Pair[] map = null;

	public HashTableDemo(){
		this(SIZE);
	}

	public HashTableDemo(int N){
		map = new Pair[N];
		for(int i =0; i < N ; i++){
			map[i]=null;
		}
	}

	public void put(int key, String  value) throws HashtableException {
                if(value==null)
                    return;
        
		int hash = key % SIZE;
		int count = 0;
		while(map[hash] != null && map[hash].getKey() != key){ 
			hash = (hash + 1) % SIZE;
			if(count == SIZE)
				throw new HashtableException("Table full");
			count++;
		}
		map[hash]= new Pair(key,value);
	}

	public String get(int key) throws HashtableException{
		int hash = key % SIZE;
		int count = 0;

		while(map[hash] != null && map[hash].getKey() != key){
			hash = (hash+1) % SIZE;
			if(count == SIZE)
				throw new HashtableException("No matching key in the table");
			count++;
		}
		if(map[hash] == null)
			throw new HashtableException("No matching key in the table");
                System.out.println("No of elements inspected is:-"+count);
		return map[hash].getValue();

	}
       public int generateKey(String str){
       int hash = 0;
       for (int i = 0; i < str.length(); i++)
            hash = (31 * hash + str.charAt(i))%1000;
       
        return hash;
   }
       public void searchTable(String str){
           int found=0;
           int count=0;
           for(int i=0;i<map.length;i++){
               try{
                  
                   count++;
                   if(map[i].getValue().endsWith(str)){
                       count++;
                       found=1;
                       break;
                   }                      
               }catch(Exception e){}
           }
           if(found==1)
               System.out.println("String present;No of elements inspected"+count);
           else
               System.out.println("Stirng is not present;No of elements inspected"+count);
       }


    public static void main(String[] args) throws IOException {
                HashTableDemo hashTable=new HashTableDemo();
                String str="";
                str=new String(Files.readAllBytes(Paths.get("data.txt")));
                String[] words=str.split("[ .,']+");//you can add more special-characters 
                for(String word:words){
                        int key=hashTable.generateKey(word);
                        //System.out.println("Key:-"+key+"value:-"+word);
                        hashTable.put(key, word);
                 }
                
                ///for searching string 
                String str_search;
        Scanner scan=new Scanner(System.in);
        do{
            System.out.println("\npress '1' to search||press '0' to quit\n");
            int ch=(scan.nextInt());
            scan.nextLine();
             if(ch==1){
                System.out.println("\nenter string to be searched\n");
                str_search=scan.nextLine();
                //hashTable.search(str_search);
                hashTable.searchTable(str_search);
            }else if(ch==0)
                    break;
        }while(true);
    }
    }    

