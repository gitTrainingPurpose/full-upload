


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;



class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
    
    
}



public class CollectionsDemo {

    private static Scanner s;

    public static <T> void mySort(List<T> l, Comparator<? super T> c) {
    	
    }
	public static void main(String[] args) {
//         listsDemo();
        mapDemo();
        setDemo();
        sortDemo();
        List<String> iList = new ArrayList<String>();
        StringLengthComparator c = new StringLengthComparator();
        mySort(iList,c);
//        Collections.sort
    }

    private static void sortDemo() {
        String[] words = {"this","is","a","test","of","sorting","lists","made","from","array"};
        List<String> wordList = Arrays.asList(words);
        System.out.println("Before sorting:\n"+wordList);
        Collections.sort(wordList);
        System.out.println("After sorting:\n"+wordList);
    }

    private static void setDemo() {
        Set<String> words = new LinkedHashSet<String>();
        while(true) {
            String aWord = fromKB("Enter a unique word");
            if(!words.add(aWord)) {
                System.out.println("That's a duplicate!");
            }
            if(words.size() == 10) {
                break;
            }
        }
        System.out.println("Here are the unique words: ");
        for(String aWord : words) {
            System.out.println(aWord);
        }
        
    }

    private static void mapDemo() {
        Map<String, String> emp = new HashMap<>();
        emp.put("E1234", "Bill Gates");
        emp.put("E2345", "Steve Jobs");
        emp.put("E3456", "Larry Ellison");
        emp.put("E4567", "Jeff Bezos");
        emp.put("E8765", "Mark Zuckerberg");
        emp.put("E6789", "Larry Page");
        while(true) {
            String input = fromKB("Enter an Emp Id: ");
            if(input.equalsIgnoreCase("quit")) {
                break;
            }
            if(emp.containsKey(input)) {
                System.out.println("Employee exists!");
                System.out.println(emp.get(input));
            }else {
                System.out.println("CAN'T FIND THAT EMPLOYEE!!");
            }
        }

    }

    private static String fromKB(String prompt) {
        System.out.println(prompt);
        s = new Scanner(System.in);
        return s.nextLine();
    }

    /*private static void listsDemo() {
        List<Circle> circles = new ArrayList<>();
        while (true) {
            double aRadius = Math.random();
            if (aRadius < 0.01) {
                break;
            }
            Circle aCircle = new Circle(aRadius);
            circles.add(aCircle);
        }
        System.out.println("There are " + circles.size() + " circles with radius >= 0.01");
        
         * for(Circle c : circles) { System.out.println(c.area()); }
         
        Iterator<Circle> it = circles.iterator();
        while (it.hasNext()) {
            Circle c = it.next();
            if (c.getRadius() < 0.5) {
                it.remove();
            }
        }

        System.out.println("There are " + circles.size() + " circles with radius >= 0.5");
    }
*/
}
