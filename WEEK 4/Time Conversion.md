#### TIME CONVERSION

###### Given a time in -hour AM/PM format, convert it to military (24-hour) time.

###### 

###### Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.

###### \- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.





import java.io.\*;

import java.util.\*;



class Result {



    /\*

     \* Complete the 'timeConversion' function below.

     \*

     \* The function is expected to return a STRING.

     \* The function accepts STRING s as parameter.

     \*/



    public static String timeConversion(String s) {

        String period = s.substring(s.length() - 2); // AM or PM

        String time = s.substring(0, s.length() - 2); // HH:MM:SS



        String\[] parts = time.split(":");

        int hour = Integer.parseInt(parts\[0]);

        String minute = parts\[1];

        String second = parts\[2];



        if (period.equals("AM")) {

            if (hour == 12) {

                hour = 0;

            }

        } else { // PM

            if (hour != 12) {

                hour += 12;

            }

        }



        return String.format("%02d:%s:%s", hour, minute, second);

    }

}



public class Solution {

    public static void main(String\[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT\_PATH")));



        String s = bufferedReader.readLine();



        String result = Result.timeConversion(s);



        bufferedWriter.write(result);

        bufferedWriter.newLine();



        bufferedReader.close();

        bufferedWriter.close();

    }

}



2.DIAGONAL DIFFERENCE



Given a square matrix, calculate the absolute difference between the sums of its diagonals.



For example, the square matrix arr is shown below:



1 2 3

4 5 6

9 8 9







import java.io.\*;

import java.util.\*;

import java.util.stream.\*;

import static java.util.stream.Collectors.toList;



class Result {



    /\*

     \* Complete the 'diagonalDifference' function below.

     \*

     \* The function is expected to return an INTEGER.

     \* The function accepts 2D\_INTEGER\_ARRAY arr as parameter.

     \*/



    public static int diagonalDifference(List<List<Integer>> arr) {

        int n = arr.size();

        int leftDiagonal = 0;

        int rightDiagonal = 0;



        for (int i = 0; i < n; i++) {

            leftDiagonal += arr.get(i).get(i);

            rightDiagonal += arr.get(i).get(n - 1 - i);

        }



        return Math.abs(leftDiagonal - rightDiagonal);

    }

}



public class Solution {

    public static void main(String\[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT\_PATH")));



        int n = Integer.parseInt(bufferedReader.readLine().trim());



        List<List<Integer>> arr = new ArrayList<>();



        IntStream.range(0, n).forEach(i -> {

            try {

                arr.add(

                    Stream.of(bufferedReader.readLine().trim().split(" "))

                        .map(Integer::parseInt)

                        .collect(toList())

                );

            } catch (IOException ex) {

                throw new RuntimeException(ex);

            }

        });



        int result = Result.diagonalDifference(arr);



        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.newLine();



        bufferedReader.close();

        bufferedWriter.close();

    }

}



3\. TRANSPOSE MATRIX

Given a 2D integer array matrix, return the transpose of matrix.



The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.



class Solution {

    public int\[]\[] transpose(int\[]\[] matrix) {

        int rows = matrix.length;

        int cols = matrix\[0].length;



        int\[]\[] transpose = new int\[cols]\[rows];



        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                transpose\[j]\[i] = matrix\[i]\[j];

            }

        }



        return transpose;

    }

}





4.MATRIX BLOCK SUM



Given a m x n matrix mat and an integer k, return a matrix answer where each answer\[i]\[j] is the sum of all elements mat\[r]\[c] for:



i - k <= r <= i + k,

j - k <= c <= j + k, and

(r, c) is a valid position in the matrix.



class Solution {

    public int\[]\[] matrixBlockSum(int\[]\[] mat, int k) {

        int m = mat.length;

        int n = mat\[0].length;



        // Prefix sum matrix

        int\[]\[] prefix = new int\[m + 1]\[n + 1];



        // Build prefix sum

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                prefix\[i + 1]\[j + 1] =

                        mat\[i]\[j]

                        + prefix\[i]\[j + 1]

                        + prefix\[i + 1]\[j]

                        - prefix\[i]\[j];

            }

        }



        int\[]\[] answer = new int\[m]\[n];



        // Calculate block sums

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int r1 = Math.max(0, i - k);

                int c1 = Math.max(0, j - k);

                int r2 = Math.min(m - 1, i + k);

                int c2 = Math.min(n - 1, j + k);



                answer\[i]\[j] =

                        prefix\[r2 + 1]\[c2 + 1]

                        - prefix\[r1]\[c2 + 1]

                        - prefix\[r2 + 1]\[c1]

                        + prefix\[r1]\[c1];

            }

        }



        return answer;

    }

}



5.MATRIX LAYER ROTATION

You are given a 2D matrix of dimension  and a positive integer . You have to rotate the matrix  times and print the resultant matrix. Rotation should be in anti-clockwise direction.



Rotation of a  matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only.



import java.io.\*;

import java.util.\*;

import java.util.stream.\*;

import static java.util.stream.Collectors.toList;



class Result {



    /\*

     \* Complete the 'matrixRotation' function below.

     \*

     \* The function accepts following parameters:

     \*  1. 2D\_INTEGER\_ARRAY matrix

     \*  2. INTEGER r

     \*/



    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();

        int n = matrix.get(0).size();



        int layers = Math.min(m, n) / 2;



        for (int layer = 0; layer < layers; layer++) {



            List<Integer> elements = new ArrayList<>();



            int top = layer;

            int bottom = m - 1 - layer;

            int left = layer;

            int right = n - 1 - layer;



            // top row

            for (int j = left; j <= right; j++)

                elements.add(matrix.get(top).get(j));



            // right column

            for (int i = top + 1; i <= bottom - 1; i++)

                elements.add(matrix.get(i).get(right));



            // bottom row

            for (int j = right; j >= left; j--)

                elements.add(matrix.get(bottom).get(j));



            // left column

            for (int i = bottom - 1; i >= top + 1; i--)

                elements.add(matrix.get(i).get(left));



            int len = elements.size();

            int rotations = r % len;



            // Rotate anti-clockwise

            Collections.rotate(elements, -rotations);



            int idx = 0;



            // put back top row

            for (int j = left; j <= right; j++)

                matrix.get(top).set(j, elements.get(idx++));



            // put back right column

            for (int i = top + 1; i <= bottom - 1; i++)

                matrix.get(i).set(right, elements.get(idx++));



            // put back bottom row

            for (int j = right; j >= left; j--)

                matrix.get(bottom).set(j, elements.get(idx++));



            // put back left column

            for (int i = bottom - 1; i >= top + 1; i--)

                matrix.get(i).set(left, elements.get(idx++));

        }



        // Print the matrix

        for (List<Integer> row : matrix) {

            for (int val : row) {

                System.out.print(val + " ");

            }

            System.out.println();

        }

    }

}



public class Solution {

    public static void main(String\[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));



        String\[] firstMultipleInput = bufferedReader.readLine().trim().split(" ");



        int m = Integer.parseInt(firstMultipleInput\[0]);

        int n = Integer.parseInt(firstMultipleInput\[1]);

        int r = Integer.parseInt(firstMultipleInput\[2]);



        List<List<Integer>> matrix = new ArrayList<>();



        IntStream.range(0, m).forEach(i -> {

            try {

                matrix.add(

                    Stream.of(bufferedReader.readLine().trim().split(" "))

                        .map(Integer::parseInt)

                        .collect(toList())

                );

            } catch (IOException ex) {

                throw new RuntimeException(ex);

            }

        });



        Result.matrixRotation(matrix, r);



        bufferedReader.close();

    }

}

