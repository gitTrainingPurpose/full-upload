import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
//import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lambdaApp {
	public static String betterString(String s1, String s2, ToStringPredicate condition) {
		return condition.isFirstBetter(s1, s2)?s1:s2;
	}
	private static void ex3() {
		String logger = betterString("yashasvi","geeta",(s1,s2)->s1.length()>s2.length());
		System.out.println("LOnger word is: "+logger);
	}
	public static <T> T betterElement(T a1, T a2, ToElementPredicate<T> condition) {
		return condition.isFirstBetter(a1, a2)?a1:a2;
	}
	private static void ex4() {
		int logger = betterElement(11,12,(s1,s2)->s1>s2);
		System.out.println("Better element is: "+logger);
	}
	private static<T> List<T> allMatches(List<T> t, Predicate<T> p) {
		List<T> res = new ArrayList<T>();
		for(T ti:t) {
			if(p.test(ti)) {
				res.add(ti);
			}
		}		
		return res;
	}
	private static void ex5() {
		String[] words = {"this","is","a","list","of","words","created","to","work","lambda","expressions","demo"};
		List<String> wordList = Arrays.asList(words);
		System.out.println(allMatches(wordList, str->str.length()<5));
		System.out.println(allMatches(wordList, s->s.contains("b")));
		System.out.println(allMatches(wordList, s->s.length()%2==0));
		List<Integer> newIntList = Arrays.asList(1,10,100,1000,10000);
		System.out.println(allMatches(newIntList,n->n>500));
	}
	private static void ex6() {
		String[] words = {"this","is","a","list","of","words","created","to","work","lambda","expressions","demo"};
		List<String> wordList = Arrays.asList(words);
		System.out.println(transformedList(wordList,s->s+"!"));
		System.out.println(transformedList(wordList, s->s.replace("i", "eye")));
		System.out.println(transformedList(wordList, String::toUpperCase));
		System.out.println(transformedList(wordList, String::length));
	}
	private static <T,R>  List<R> transformedList(List<T> t, Function<T,R> f) {
		// TODO Auto-generated method stub
		List<R> res = new ArrayList<R>();
		for(T ti:t) {
			res.add(f.apply(ti));	
		}
		return res;
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String[] words = {"this","is","a","list","of","words","created","to","work","lambda","expressions","demo"};
//		List<String> wordList = Arrays.asList(words);
////		System.out.println("Array before sorting: "+wordList);
////		Collections.sort(wordList, (s1,s2)->s1.length()-s2.length());
////		System.out.println("Array after sorting: "+wordList);
////		Collections.sort(wordList, (s1,s2)->-s1.length()+s2.length());
////		System.out.println("Array after reverse sorting: "+wordList);
////		Collections.sort(wordList, (s1,s2)->s1.charAt(0)-s2.charAt(0));
////		System.out.println("Array after sorting w.r.t first letter: "+wordList);
//////		Collections.sort(wordList, (s1,s2)->-s1.indexOf('e')+s2.indexOf('e'));
////		Collections.sort(wordList,Lambda::wrtPresenceOfE);
////		System.out.println("Array after sorting w.r.t presence of e: "+wordList);
////		ex3();
////		ex4();
////		ex5();
////		ex6();
////		System.out.println(transformedList(wordList, s->"  "+s+"\n"));
////		System.out.println(wordList);
////		System.out.println(transformedList(wordList, StreamsApp::modFn));
////		String es;
////		wordList.stream().forEach(es->System.out.println("  "+es));
////		wordList.stream().forEach(System.out::println);
////		wordList.stream().forEach(System.out::println);
//		List<String> resp = wordList.stream().map(n->n+"!").collect(Collectors.toList());
//		System.out.println(resp);
//		resp = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
//		System.out.println(resp);
//		resp = wordList.stream().filter(s->s.length()<4).collect(Collectors.toList());
//		System.out.println(resp);
////		Optional<String> a = wordList.stream().reduce((s1,s2)->s1.toUpperCase()+s2.toUpperCase());
////		Optional<String> a = wordList.stream().reduce().map(String::toUpperCase);
////		System.out.println(a);
//	
//	
//	}

}
