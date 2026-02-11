### WEEK 5

### &nbsp;

#### 1.MAXIMUM SUBARRAY



Given an integer array nums, find the subarray with the largest sum, and return its sum.



class Solution {

&nbsp;   public int maxSubArray(int\[] nums) {

&nbsp;       int maxSoFar = nums\[0];

&nbsp;       int currentSum = nums\[0];



&nbsp;       for (int i = 1; i < nums.length; i++) {

&nbsp;           currentSum = Math.max(nums\[i], currentSum + nums\[i]);

&nbsp;           maxSoFar = Math.max(maxSoFar, currentSum);

&nbsp;       }



&nbsp;       return maxSoFar;

&nbsp;   }

}





#### 2.SUBARRAY DIVISION 



Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.



Lily decides to share a contiguous segment of the bar selected such that:



The length of the segment matches Ron's birth month, and,

The sum of the integers on the squares is equal to his birth day.

Determine how many ways she can divide the chocolate.





import java.io.\*;

import java.math.\*;

import java.security.\*;

import java.text.\*;

import java.util.\*;

import java.util.concurrent.\*;

import java.util.function.\*;

import java.util.regex.\*;

import java.util.stream.\*;

import static java.util.stream.Collectors.joining;

import static java.util.stream.Collectors.toList;



class Result {



&nbsp;   /\*

&nbsp;    \* Complete the 'birthday' function below.

&nbsp;    \*

&nbsp;    \* The function is expected to return an INTEGER.

&nbsp;    \* The function accepts following parameters:

&nbsp;    \*  1. INTEGER\_ARRAY s

&nbsp;    \*  2. INTEGER d

&nbsp;    \*  3. INTEGER m

&nbsp;    \*/



&nbsp;   public static int birthday(List<Integer> s, int d, int m) {

&nbsp;   // Write your code here

&nbsp;   int count = 0;

&nbsp;   int windowSum = 0;



&nbsp;   // Edge case: if segment length is greater than chocolate length

&nbsp;   if (m > s.size()) {

&nbsp;       return 0;

&nbsp;   }



&nbsp;   // Sum of the first window

&nbsp;   for (int i = 0; i < m; i++) {

&nbsp;       windowSum += s.get(i);

&nbsp;   }



&nbsp;   if (windowSum == d) {

&nbsp;       count++;

&nbsp;   }



&nbsp;   // Slide the window

&nbsp;   for (int i = m; i < s.size(); i++) {

&nbsp;       windowSum += s.get(i);       // add next square

&nbsp;       windowSum -= s.get(i - m);   // remove previous square



&nbsp;       if (windowSum == d) {

&nbsp;           count++;

&nbsp;       }

&nbsp;   }



&nbsp;   return count;

}



&nbsp;   }



public class Solution {

&nbsp;   public static void main(String\[] args) throws IOException {

&nbsp;       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

&nbsp;       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT\_PATH")));



&nbsp;       int n = Integer.parseInt(bufferedReader.readLine().trim());



&nbsp;       List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\\\s+$", "").split(" "))

&nbsp;           .map(Integer::parseInt)

&nbsp;           .collect(toList());



&nbsp;       String\[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\\\s+$", "").split(" ");



&nbsp;       int d = Integer.parseInt(firstMultipleInput\[0]);



&nbsp;       int m = Integer.parseInt(firstMultipleInput\[1]);



&nbsp;       int result = Result.birthday(s, d, m);



&nbsp;       bufferedWriter.write(String.valueOf(result));

&nbsp;       bufferedWriter.newLine();



&nbsp;       bufferedReader.close();

&nbsp;       bufferedWriter.close();

&nbsp;   }

}



#### 3.THE MAXIMUM SUBARRAY 



###### We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.

###### 

###### Given an array, find the maximum possible sum among:

###### 

###### all nonempty subarrays.

###### all nonempty subsequences.

###### Print the two values as space-separated integers on one line.

###### 

###### Note that empty subarrays/subsequences should not be considered.







import java.io.\*;

import java.math.\*;

import java.security.\*;

import java.text.\*;

import java.util.\*;

import java.util.concurrent.\*;

import java.util.function.\*;

import java.util.regex.\*;

import java.util.stream.\*;

import static java.util.stream.Collectors.joining;

import static java.util.stream.Collectors.toList;



class Result {



&nbsp;   /\*

&nbsp;    \* Complete the 'maxSubarray' function below.

&nbsp;    \*

&nbsp;    \* The function is expected to return an INTEGER\_ARRAY.

&nbsp;    \* The function accepts INTEGER\_ARRAY arr as parameter.

&nbsp;    \*/



&nbsp;   public static List<Integer> maxSubarray(List<Integer> arr) {

&nbsp;   // Write your code here



&nbsp;   int maxSubarray = arr.get(0);

&nbsp;   int currentSum = arr.get(0);



&nbsp;   int maxSubsequence = 0;

&nbsp;   int maxElement = arr.get(0);



&nbsp;   for (int i = 0; i < arr.size(); i++) {

&nbsp;       int val = arr.get(i);



&nbsp;       // Kadane's algorithm for subarray

&nbsp;       if (i > 0) {

&nbsp;           currentSum = Math.max(val, currentSum + val);

&nbsp;           maxSubarray = Math.max(maxSubarray, currentSum);

&nbsp;       }



&nbsp;       // Subsequence logic

&nbsp;       if (val > 0) {

&nbsp;           maxSubsequence += val;

&nbsp;       }



&nbsp;       maxElement = Math.max(maxElement, val);

&nbsp;   }



&nbsp;   // If all elements are negative

&nbsp;   if (maxSubsequence == 0) {

&nbsp;       maxSubsequence = maxElement;

&nbsp;   }



&nbsp;   return Arrays.asList(maxSubarray, maxSubsequence);

}



&nbsp;   }





public class Solution {

&nbsp;   public static void main(String\[] args) throws IOException {

&nbsp;       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

&nbsp;       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT\_PATH")));



&nbsp;       int t = Integer.parseInt(bufferedReader.readLine().trim());



&nbsp;       IntStream.range(0, t).forEach(tItr -> {

&nbsp;           try {

&nbsp;               int n = Integer.parseInt(bufferedReader.readLine().trim());



&nbsp;               List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\\\s+$", "").split(" "))

&nbsp;                   .map(Integer::parseInt)

&nbsp;                   .collect(toList());



&nbsp;               List<Integer> result = Result.maxSubarray(arr);



&nbsp;               bufferedWriter.write(

&nbsp;                   result.stream()

&nbsp;                       .map(Object::toString)

&nbsp;                       .collect(joining(" "))

&nbsp;                   + "\\n"

&nbsp;               );

&nbsp;           } catch (IOException ex) {

&nbsp;               throw new RuntimeException(ex);

&nbsp;           }

&nbsp;       });



&nbsp;       bufferedReader.close();

&nbsp;       bufferedWriter.close();

&nbsp;   }

}





###### 4\. MAXIMUM SUM CIRCULAR SUBARRAY

###### Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

###### 

###### A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums\[i] is nums\[(i + 1) % n] and the previous element of nums\[i] is nums\[(i - 1 + n) % n].

###### 

###### A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums\[i], nums\[i + 1], ..., nums\[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.





class Solution {

&nbsp;   public int maxSubarraySumCircular(int\[] nums) {

&nbsp;       int totalSum = 0;



&nbsp;       int maxKadane = nums\[0];

&nbsp;       int currentMax = nums\[0];



&nbsp;       int minKadane = nums\[0];

&nbsp;       int currentMin = nums\[0];



&nbsp;       for (int i = 0; i < nums.length; i++) {

&nbsp;           int val = nums\[i];

&nbsp;           totalSum += val;



&nbsp;           if (i > 0) {

&nbsp;               currentMax = Math.max(val, currentMax + val);

&nbsp;               maxKadane = Math.max(maxKadane, currentMax);



&nbsp;               currentMin = Math.min(val, currentMin + val);

&nbsp;               minKadane = Math.min(minKadane, currentMin);

&nbsp;           }

&nbsp;       }



&nbsp;       // If all numbers are negative, totalSum == minKadane

&nbsp;       if (totalSum == minKadane) {

&nbsp;           return maxKadane;

&nbsp;       }



&nbsp;       return Math.max(maxKadane, totalSum - minKadane);

&nbsp;   }

}



##### 5.STRING TO INTEGER 



Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.



class Solution {

&nbsp;   public int myAtoi(String s) {

&nbsp;       int i = 0;

&nbsp;       int n = s.length();

&nbsp;       int sign = 1;

&nbsp;       int result = 0;



&nbsp;       // 1. Skip leading whitespaces

&nbsp;       while (i < n \&\& s.charAt(i) == ' ') {

&nbsp;           i++;

&nbsp;       }



&nbsp;       // 2. Check optional sign

&nbsp;       if (i < n \&\& (s.charAt(i) == '+' || s.charAt(i) == '-')) {

&nbsp;           sign = (s.charAt(i) == '-') ? -1 : 1;

&nbsp;           i++;

&nbsp;       }



&nbsp;       // 3. Convert digits and handle overflow

&nbsp;       while (i < n \&\& Character.isDigit(s.charAt(i))) {

&nbsp;           int digit = s.charAt(i) - '0';



&nbsp;           // Overflow check

&nbsp;           if (result > Integer.MAX\_VALUE / 10 ||

&nbsp;              (result == Integer.MAX\_VALUE / 10 \&\& digit > 7)) {

&nbsp;               return (sign == 1) ? Integer.MAX\_VALUE : Integer.MIN\_VALUE;

&nbsp;           }



&nbsp;           result = result \* 10 + digit;

&nbsp;           i++;

&nbsp;       }



&nbsp;       return result \* sign;

&nbsp;   }

}

##### 

##### 6.ALTERNATING CHARACTERS





You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.



Your task is to find the minimum number of required deletions.



###### 



import java.io.\*;

import java.math.\*;

import java.security.\*;

import java.text.\*;

import java.util.\*;

import java.util.concurrent.\*;

import java.util.function.\*;

import java.util.regex.\*;

import java.util.stream.\*;

import static java.util.stream.Collectors.joining;

import static java.util.stream.Collectors.toList;



class Result {



&nbsp;   /\*

&nbsp;    \* Complete the 'alternatingCharacters' function below.

&nbsp;    \*

&nbsp;    \* The function is expected to return an INTEGER.

&nbsp;    \* The function accepts STRING s as parameter.

&nbsp;    \*/



&nbsp;  

&nbsp;   // Write your code here



&nbsp;   public static int alternatingCharacters(String s) {

&nbsp;   int deletions = 0;



&nbsp;   for (int i = 1; i < s.length(); i++) {

&nbsp;       if (s.charAt(i) == s.charAt(i - 1)) {

&nbsp;           deletions++;

&nbsp;       }

&nbsp;   }



&nbsp;   return deletions;

}





}



public class Solution {

&nbsp;   public static void main(String\[] args) throws IOException {

&nbsp;       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

&nbsp;       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT\_PATH")));



&nbsp;       int q = Integer.parseInt(bufferedReader.readLine().trim());



&nbsp;       IntStream.range(0, q).forEach(qItr -> {

&nbsp;           try {

&nbsp;               String s = bufferedReader.readLine();



&nbsp;               int result = Result.alternatingCharacters(s);



&nbsp;               bufferedWriter.write(String.valueOf(result));

&nbsp;               bufferedWriter.newLine();

&nbsp;           } catch (IOException ex) {

&nbsp;               throw new RuntimeException(ex);

&nbsp;           }

&nbsp;       });



&nbsp;       bufferedReader.close();

&nbsp;       bufferedWriter.close();

&nbsp;   }

}



##### 7.LONGEST SUBSTRING WITHOUT REPEAIN CHARACERS

Given a string s, find the length of the longest substring without duplicate characters.



class Solution {

&nbsp;   public int lengthOfLongestSubstring(String s) {

&nbsp;       Set<Character> set = new HashSet<>();

&nbsp;       int left = 0;

&nbsp;       int maxLength = 0;



&nbsp;       for (int right = 0; right < s.length(); right++) {

&nbsp;           while (set.contains(s.charAt(right))) {

&nbsp;               set.remove(s.charAt(left));

&nbsp;               left++;

&nbsp;           }



&nbsp;           set.add(s.charAt(right));

&nbsp;           maxLength = Math.max(maxLength, right - left + 1);

&nbsp;       }



&nbsp;       return maxLength;

&nbsp;   }

}









