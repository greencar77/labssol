package labs.javalang;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		getAnalysis();
		tryComputeIfAbsent();
		tryGetOrDefault();
		computeIfAbsentAnalysis();
	}

	private static void getAnalysis() {
		System.out.println("getAnalysis()");
		Map<String, String> map = Repo.getMap();

		String value;

		System.out.println("map.size()=" + map.size());

		value = map.get("aaa");
		System.out.println("value=" + value);

		value = map.get("some not existing");
		System.out.println("value=" + value);

		System.out.println("map2");
		Map<String, String> map2 = new HashMap();
		value = map2.get(null);
		System.out.println("value=" + value);

		map2.put(null, null);
		value = map2.get(null);
		System.out.println("value=" + value);
	}

	private static void computeIfAbsentAnalysis() {
		System.out.println("computeIfAbsentAnalysis()");
		Map<String, String> map = Repo.getMap();

		String value;

		System.out.println("map.size()=" + map.size());

		value = map.computeIfAbsent("aaa", x -> "Some key with a length of " + x.length() + " " + Math.random());
		System.out.println("value=" + value);

		System.out.println("When key not present");
		value = map.computeIfAbsent("xxx", x -> "Some key with a length of " + x.length() + " " + Math.random());
		System.out.println("value=" + value);

		System.out.println("When key not present 2nd time");
		value = map.computeIfAbsent("xxx", x -> "Some key with a length of " + x.length() + " " + Math.random());
		System.out.println("value=" + value);

		System.out.println("When value is null");
		value = map.computeIfAbsent("ccc", x -> "Some key with a length of " + x.length() + " " + Math.random());
		System.out.println("value=" + value);

		System.out.println("Subsequent call with 'get'");
		System.out.println("value=" + map.get("ccc"));

		value = map.computeIfAbsent(null, x -> "Some key with a length of " + x.length() + " " + Math.random());
		System.out.println("value=" + value);
		System.out.println("map.size()=" + map.size());



		System.out.println("map2");
		Map<String, String> map2 = new HashMap();
		value = map2.computeIfAbsent(null, x ->  (x == null? "null key" : "Some key with a length of " + x.length()) + " " + Math.random());
		System.out.println("value=" + value);

		map2.put(null, null);
		value = map2.computeIfAbsent(null, x -> (x == null? "null key" : "Some key with a length of " + x.length()) + " " + Math.random());
		System.out.println("value=" + value);
		value = map2.computeIfAbsent(null, x -> (x == null? "null key" : "Some key with a length of " + x.length()) + " " + Math.random());
		System.out.println("value=" + value);
	}

	/**
	 * Q9SK
	 */
	private static void tryComputeIfAbsent() {
		System.out.println("playWithNotExistingKey()");

		Map<String, String> map = Repo.getMap();

		String value;

		System.out.println("map.keySet().contains(\"notexisting\")=" + map.keySet().contains("notexisting"));

		value = map.computeIfAbsent("notexisting", x -> "new1" + " " + Math.random());
		System.out.println(value);
		System.out.println("map.keySet().contains(\"notexisting\")=" + map.keySet().contains("notexisting"));

		value = map.get("notexisting");
		System.out.println(value);

		value = map.computeIfAbsent("notexisting", x -> "new2" + " " + Math.random());
		System.out.println(value);
	}

	private static void tryGetOrDefault() {
		System.out.println("playWithGetOrDefault()");

		Map<String, String> map = Repo.getMap();

		String value;

		System.out.println("map.keySet().contains(\"notexisting\")=" + map.keySet().contains("notexisting"));

		value = map.getOrDefault("notexisting", "new1" + " " + Math.random());
		System.out.println(value);
		System.out.println("map.keySet().contains(\"notexisting\")=" + map.keySet().contains("notexisting"));

		value = map.get("notexisting");
		System.out.println(value);

		value = map.getOrDefault("notexisting", "new2" + " " + Math.random());
		System.out.println(value);
	}
}

