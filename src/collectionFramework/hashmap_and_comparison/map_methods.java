package collectionFramework.hashmap_and_comparison;

import java.util.*;

public class map_methods {
    public static void main(String[] args) {
        /*hashMap       -> unordered_map
        * linkedHashMap -> NA
        * treeMap       -> map*/
        Map<Integer, String> mp = new HashMap<>();
        Map<Integer, String> mp2 = new TreeMap<>();

        /*TODO, how map forms a Entry and then Saves
        *  check similarity with Pair of C++*/
        mp.put(3, "United States of America");
        mp.put(1, "India");
        mp.put(1, "India");
        mp.put(2, "England");

        printHashMap("mp", mp);

        mp.put(3, "China"); // update or save new
        mp.putIfAbsent(10,"Sri Lanka"); // never update only save new
        mp.putIfAbsent(1, "Bangladesh");
        printHashMap("mp", mp);

        String value_2 = mp.remove(2);
        String value_50 = mp.remove(50);
        System.out.println("removing 2 and 50");
        System.out.println(value_2 + " , " + value_50);
        printHashMap("mp", mp);

        System.out.println("1 present : " +  mp.containsKey(1));
        System.out.println("50 present : " + mp.containsKey(50));
        printHashMap("mp", mp);

        mp2.put(7, "France");
        mp2.put(8, "Germany");
        mp.putAll(mp2);
        printHashMap("mp2", mp2);
        printHashMap("mp", mp);


        System.out.println("mp.get(1) : " + mp.get(1));
        System.out.println("mp.get(50) : " + mp.get(50));
        System.out.println("mp.getOrDefault(1, \"default_country\") : " + mp.getOrDefault(1, "default_country"));
        System.out.println("mp.getOrDefault(50 , \"default_country\") : " + mp.getOrDefault(50, "default_country"));

        System.out.println("-----");
        printHashMaps("mp", mp, "mp2", mp2);
        System.out.println("mp.containsValue(\"China\") : " + mp.containsValue("China"));
        System.out.println("mp.containsValue(\"china\") : " + mp.containsValue("china"));
        System.out.println("mp.containsValue(\"USA\") : " + mp.containsValue("USA"));
        System.out.println("mp.containsValue(2.0) : " + mp.containsValue(2.0));

        System.out.println("-----");

        System.out.println("mp.replace(7, \"Bhutan\") : " + mp.replace(7, "Bhutan")); // only update
        System.out.println("mp.replace(9, \"Nepal\") : " + mp.replace(9, "Nepal"));
        printHashMaps("mp", mp, "mp2", mp2);

        // only update when value match
        System.out.println("mp.replace(7, \"Bhutan\", \"Slovenia\") : " + mp.replace(7, "Bhutan", "Slovenia"));
        System.out.println("mp.replace(8, \"Nepal\", \"Serbia\") : " + mp.replace(8, "Nepal", "Serbia"));
        printHashMaps("mp", mp, "mp2", mp2);

        // only remove when value match
        System.out.println("mp.remove(7, \"Slovenia\") : " + mp.remove(7, "Slovenia"));
        System.out.println("mp.remove(8, \"Nepal\") : "  + mp.remove(8, "Nepal"));
        printHashMaps("mp", mp, "mp2", mp2);

        System.out.println("mp.size() : " + mp.size());
        System.out.println("mp2.size() : " + mp2.size());
        System.out.println("mp2.clear()");mp2.clear();
        System.out.println("mp2.size() : " + mp2.size());
        printHashMaps("mp", mp, "mp2", mp2);

        mp.put(10, "Germany");
        System.out.println("mp : " + mp);
        System.out.println("mp.keySet() : " + mp.keySet());
        System.out.println("arraylist of mp.keySet() : " + new ArrayList<>(mp.keySet()));
        System.out.println("mp.values() : " + mp.values());
        System.out.println("arraylist of mp.values() : " + new ArrayList<>(mp.values()));

        System.out.println("mp.entrySet() : " + mp.entrySet());

        System.out.println("---");
        Set<Map.Entry<Integer, String>> entries= mp.entrySet();
        for(Map.Entry<Integer, String> entry : entries) {
            System.out.println("key : " + entry.getKey() + ", " + "value : " + entry.getValue());
        }

        System.out.println("---");
        mp.forEach((key,value) -> System.out.println("k : " + key + " , " + "v : " + value));



    }

    static void printHashMap(String mapName, Map<?,?> mp) {
        System.out.println(mapName);
        System.out.println(mp);
        System.out.println("-------");
    }

    static void printHashMaps(String mapName, Map<?,?> mp1, String mapName2, Map<?, ?> mp2) {
        System.out.println(mapName + mp1);
        System.out.println(mapName2 + mp2);
        System.out.println("-------");
    }
}
