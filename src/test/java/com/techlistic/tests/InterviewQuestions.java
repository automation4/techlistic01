package com.techlistic.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InterviewQuestions {

    @Test
    public void wordCount()
    {
        String str = "this is a new this is";
        Map<String, Integer> map = new LinkedHashMap<>();
        Integer count = 1;
        String[] arr = str.split(" ");

        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],count);
            }
            else{
                map.put(arr[i],map.get(arr[i])+1);  // map.get(key object)//return value of key
            }
        }
        for(String key : map.keySet()){
            System.out.println(key+" -> "+map.get(key));
        }

    }
    @Test
    public void charCount()
    {
        String str = "this is a new this is";

        Map<Character, Integer> map = new LinkedHashMap<>();
        Integer count = 1;
        char[] arr = str.replace(" ","").toCharArray();

        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],count);
            }
            else{
                map.put(arr[i],map.get(arr[i])+1);  // map.get(key object)//return value of key
            }
        }
        for(Character key : map.keySet()) {
            if (map.get(key) > 1) {
                System.out.println(key + " -> " + map.get(key));
            }
        }
    }

    @Test
    public void firstNonRepeatedChar()
    {
        String str = "Program";
        char[] arr = str.replace(" ","").toLowerCase().toCharArray();
        boolean flag = false;
        Map<Character, Integer> map = new LinkedHashMap<>();
        Integer count = 1;

        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],count);
            }
            else{
                map.put(arr[i],map.get(arr[i])+1);  // map.get(key object)//return value of key
            }
        }
        for(Map.Entry<Character,Integer>  entry : map.entrySet()) {
            if (entry.getValue()==1) {
                System.out.println("first non repeated character is >"+entry.getKey());
                flag=true;
                break;
        }
        }
            if(!flag)
        Assert.fail("There is no non repeated character in String >"+ str);
    }

    @Test
    public void charAnagramCheck()
    {
        String str1 = "post";
        String str2 = "stop";
        boolean flag = false;

        Map<Character, Integer> map1 = new LinkedHashMap<>();
        Map<Character, Integer> map2 = new LinkedHashMap<>();

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        if(arr1.length==arr2.length) {
            map1 = returnMap(arr1);
            map2 = returnMap(arr2);
            if(map1.size()==map2.size()){
                for(Character key :map1.keySet()){
                    if(map2.containsKey(key)){
                        flag =true;
                    }
                    else {
                        flag=false;
                        break;
                    }
            }
                if(flag){
                    System.out.println(map1.keySet());
                    System.out.println(map2.keySet());
                    System.out.println("its Anagram");
                }
                else {
                    Assert.fail("Not Anagram");
                }
        }
            else {
                Assert.fail("Map size is not same to check Anagram");
            }
        }
        else {
            Assert.fail("Length should be same for Anagram");
        }
    }

    public Map<Character, Integer> returnMap(char[] charr){
        Map<Character, Integer> map = new LinkedHashMap<>();
        Integer count = 1;
        for(int i=0;i<charr.length;i++){
            if(!map.containsKey(charr[i])){
                map.put(charr[i],count);
            }
            else{
                map.put(charr[i],map.get(charr[i])+1);  // map.get(key object)//return value of key
            }
        }
        return map;
    }
    @Test
    public void characterCount()
    {
        String str = "this is a new this is";
        int result = str.length()-str.replaceAll("s","").length();
        System.out.println(result);

    }

    @Test
    public void hashExample(){
        // Create an empty hash map by declaring object
        // of string and integer type
        Map<String, Integer> map = new HashMap<>();

        // Adding elements to the Map
        // using standard add() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Print size and content of the Map
        System.out.println("Size of map is:- "
                + map.size());

        for(String key : map.keySet()){
            System.out.println(key);
        }
        // map.keySet(); // return set of strings
        // map.containsKey(key object) // return boolean
        // map.get(key object)//return value of key
        //map.size() // return integer

        // Printing elements in object of Map
        System.out.println(map);   // key= value

        // Checking if a key is present and if
        // present, print value by passing
        // random element
        if (map.containsKey("vishal")) {

            // Mapping
            Integer a = map.get("vishal");

            // Printing value fr the corresponding key
            System.out.println("value for key"
                    + " \"vishal\" is:- " + a);
        }

    }
}
