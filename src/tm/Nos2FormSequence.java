package tm;

import java.util.Arrays;

/*
Given an array arr[] with N distinct numbers and another array arr1[] with N-1 operators (either < or >),
the task is to organize the numbers to form a valid sequence which obeys relational operator rules with respect to provided operators.

Input: arr[] = {3, 12, 7, 8, 5}; arr1= {‘<‘, ‘>’, ‘>’, ‘<‘}
Output: {3, 12, 8, 5, 7}
Explanation:
3 < 12 > 8 > 5 < 7
There can be more such combinations. The task is to return one of the combinations.

 */
public class Nos2FormSequence {
    // Function to organize the given numbers to form a valid sequence.
    static int[] orgazineInOrder(int []vec,int[] op, int n)
    {
        int []result = new int[n];

        // Sorting the array
        Arrays.sort(vec);

        int i = 0, j = n - 1, k = 0;
        while (i <= j && k <= n - 2)
        {
            // Two pointer technique to organize the numbers
            if (op[k] == '<')
            {
                result[k] = vec[i++];
            }
            else
            {
                result[k] = vec[j--];
            }
            k++;
        }
        result[n - 1] = vec[i];

        return result;
    }

    // Driver code
    public static void main(String[] args)
    {
       /* int []vec ={ 8, 2, 7, 1, 5, 9 };
        int[] op ={ '>', '>', '<', '>', '<' };*/

        int []vec ={ 3, 12, 7, 8, 5 };
        int[] op ={ '>', '>', '<', '>', '<' };

        int []result = orgazineInOrder(vec, op, vec.length);

        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]+ " ");
        }
    }
}
