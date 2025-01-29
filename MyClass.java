import java.util.*;

public class MyClass {
  public static void main(String args[]) {
    Junk my_list = new Junk(new String[]{"e", "eh", "Hey", "weh"});
    my_list.sort();//start sorting according to length: long to short
    my_list.junks(); //ouput: [Hey, weh, eh, e]
  }
}

class Junk{
    String[] sort = {""}; //array to fetch unsorted Junk
    String[] bucket = {""}; //bucket container to store length-sorted Junk
    int length = 0;
    Junk(String[] array){ //constructor to initialize the Junk
        this.sort = array;
        this.bucket = new String[array.length];
        this.length = array.length;
    }
    //method to sort the Junk according to length from longer to shorter
    public void sort(){
        if(length==0)
        {
            System.out.print("Empty Junk provided");
        }else{
            for(int i=0; i<length; i++){
                bucket[i] = sort[i]; //take current word as the larger one
                for(int j=0; j<length; j++)//inner loop: check if there is any word larger than the current one
                {
                    if(i!=j && (bucket[i].length() < sort[j].length()) ){
                        String temp_large = bucket[i]; //swapping operation
                        bucket[i] = sort[j];
                        sort[j] = temp_large;
                    }
                }
            }
        }
    }
    
    //method for displayign the sorted list
    public void junks(){
        System.out.print("[");
        for(int k=0; k<length-1; k++){
            System.out.print(bucket[k]+", ");
        }
        System.out.print(bucket[length-1]+"]");
    }
    
}
