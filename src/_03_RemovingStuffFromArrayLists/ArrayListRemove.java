package _03_RemovingStuffFromArrayLists;

import java.util.ArrayList;

public class ArrayListRemove {

    class Stuff {
        public String type;
    }
    
    class Worm extends Stuff {
        public Worm() {
            type = "worm";
        }
    }
    
    class Dirt extends Stuff {
        public Dirt() {
            type = "dirt";
        }
    }

    // 1. Write a method that removes the dirt in the yard and returns the
    //    ArrayList
    public static ArrayList<Stuff> cleanOutTheYard( ArrayList<Stuff> yard ) {
    	ArrayList<Stuff> yardCopy = new ArrayList<Stuff>();
    	

    	for (int i = 0; i < yard.size(); i++) {
        	if (yard.get(i).type != "dirt") {
        		yardCopy.add(yard.get(i));
        	}

        }
        return yardCopy;
    }
    
    // 2. Write a method that removes the hash tag ('#') characters from the
    //    ArrayList and returns it
    public static ArrayList<Character> removeHashTags(ArrayList<Character> list) {
    	ArrayList<Character> listCopy = new ArrayList<Character>();
    	System.out.print("List "+ list.size() + "   Copy "+ listCopy.size() +  "\n");
    	for (int i = 0; i < list.size(); i++) {
        	if (!Character.toString(list.get(i)).equals("#")) {
        		listCopy.add(list.get(i));
        	}

        }
    	System.out.print("List "+ list.size() + "   Copy "+ listCopy.size());
        return listCopy;
    }
}
