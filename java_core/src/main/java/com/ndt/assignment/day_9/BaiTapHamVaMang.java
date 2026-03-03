package com.ndt.assignment.day_9;

import java.util.*;


public class BaiTapHamVaMang {
    private static int[] _getArr() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu trong mang: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
    }


    // private static boolean _isIn(int[] arr, int target) {
    //     for (int e : arr) {
    //         if (e == target) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    public static boolean isPrime(int n) {
        return BaiTap8.isPrime(n);
    }


    public static int sumArray(int[] arr) {
        // Q1
        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        return sum;
    }


    public static int maxValue(int[] arr) {
        int max = arr[0];
        for (int e : arr) {
            if (e > max)
                max = e;
        }
        return max;
    }


    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int e : arr) {
            if (e < min)
                min = e;
        }
        return min;
    }


    public static void countEvenOdd(int[] arr) {
        int evenCounter = 0;
        int oddCounter = 0;

        for (int e : arr) {
            if (e % 2 == 0)
                evenCounter++;
            else
                oddCounter++;
        }

        System.out.println("Num even numbers: " + evenCounter);
        System.out.println("Num odd numbers: " + oddCounter);
    }


    public static int[] reverseArray(int[] arr) {
        int[] reversedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - i - 1];
        }

        return reversedArr;
    }


    public static boolean isExist(int[] arr, int x) {
        for (int e : arr)
            if (e == x)
                return true;

        return false;
    }


    public static double average(int[] arr) {
        double mean = 0;

        for (int e : arr)
            mean += e;

        return mean / arr.length;
    }


    public static int countOccurrences(int[] arr, int x) {
        int counter = 0;
        for (int e : arr) {
            if (e == x)
                counter++;
        }

        return counter;
    }


    public static void sortAscending(int[] arr) {
        // bubble sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    public static int[] removeElement(int[] arr, int x) {
        // TODO
        List<Integer> matchedIdx = new ArrayList<>();

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x)
                matchedIdx.add(i);

        int curMatchedIdx = 0;
        int[] returnedArr = new int[arr.length - matchedIdx.size()];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (!matchedIdx.isEmpty() && curMatchedIdx < matchedIdx.size() && i == matchedIdx.get(curMatchedIdx)) {
                curMatchedIdx++;
                continue;
            }

            returnedArr[j++] = arr[i];
        }

        return returnedArr;
    }


    public static int[] insertElement(int[] arr, int pos, int value) {
        if (pos < 0 || pos > arr.length)
            throw new IllegalArgumentException("Position is invalid");

        int[] addedArr = new int[]{arr.length + 1};
        for (int i = 0; i < pos; i++) {
            addedArr[i] = arr[i];
        }

        arr[pos] = value;

        for (int i = pos + 1; i < addedArr.length; i++) {
            addedArr[i] = arr[i];
        }
        return addedArr;
    }


    public static void printPrimeNumbers(int[] arr) {
        System.out.println("Các số nguyên tố trong mảng: ");
        for (int e : arr) {
            if (isPrime(e))
                System.out.print(e + " ");
        }
    }


    public static int mostFrequentElement(int[] arr) {
        // Did not tackle the case: having more than 1 most frequent element in the arr !
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int e : arr) {
            freqMap.put(e, freqMap.getOrDefault(e, 0) + 1);
        }

        List<Integer> keyLst = freqMap.keySet().stream().toList();
        int maxE = keyLst.getFirst();
        Integer maxFreq = freqMap.get(maxE);

        for (int i = 1; i < keyLst.size(); i++) {
            Integer e = keyLst.get(i);
            Integer freq = freqMap.get(e);
            if (freq > maxFreq) {
                maxE = e;
                maxFreq = freq;
            }
        }
        return maxE;
    }


    public static List<List<Integer>> splitEvenOdd(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> evenArr = new ArrayList<>();
        List<Integer> oddArr = new ArrayList<>();

        for (int e : arr) {
            if (e % 2 == 0)
                evenArr.add(e);
            else
                oddArr.add(e);
        }

        result.add(evenArr);
        result.add(oddArr);
        return result;

    }


    public static int[] rotateRight(int[] arr, int k) {
        int[] result = new int[arr.length];

        for (int i = arr.length - k; i < arr.length; i++) {
            result[i - (arr.length - k)] = arr[i];
        }

        for (int i = 0; i < arr.length - k; i++) {
            result[i + k] = arr[i];
        }
        return result;
    }


    public static boolean isSymmetric(int[] arr) {
        int mid = arr.length >>> 1;

        System.out.println(mid);

        for (int i = 0; i < mid; i++) {
            if (arr[i] != arr[arr.length - i - 1])
                return false;
        }
        return true;
    }


    public static List<Integer> mergeUnique(int[] a, int[] b) {
        Map<Integer, Integer> cache = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        for (int[] ar : new int[][]{a, b}) {
            for (int ele : ar) {
                if (cache.getOrDefault(ele, null) == null) {
                    cache.put(ele, 1);
                    result.add(ele);
                }
            }
        }
        return result;
    }


    public static int[] maxSubArraySum(int[] arr) {
        // TODO
        int globalSum = 0;
        // 1 2 5 6 -8 0 9 1 2
        return new int[0];
    }


    public static void Q19() {

    }


    public static void Q20() {

    }


    public static void coBan(int[] arr) {
        System.out.println("Sum: " + sumArray(arr));
        System.out.println("Max: " + maxValue(arr));
        System.out.println("Min: " + minValue(arr));
        countEvenOdd(arr);
        System.out.println("Reversed arr: " + Arrays.toString(reverseArray(arr)));
        System.out.println("Is x exist: " + isExist(arr, arr[0]));
        System.out.println("Average: " + average(arr));
        System.out.println("Count x: " + countOccurrences(arr, arr[0]));
        sortAscending(arr);
        System.out.println("Ascending sorted arr: " + Arrays.toString(arr));
    }


    public static void trungBinh(int[] arr) {
        System.out.println("After x is removed: " + Arrays.toString(removeElement(arr, arr[0])));

        insertElement(arr, 0, 1);
        System.out.println("After insert at pos 0 val 1: " + Arrays.toString(arr));

        printPrimeNumbers(arr);
        System.out.println("Most frequent element: " + mostFrequentElement(arr));
        System.out.println("Split arrays are:");
        splitEvenOdd(arr).forEach(lst -> System.out.println(Arrays.toString(lst.toArray())));
    }


    public static void nangCao(int[] arr) {
        // System.out.println("Rotated array: " + Arrays.toString(rotateRight(arr, 4)));
        // System.out.println("Is symmetric: " + isSymmetric(arr));
        // System.out.println("Merged array: " + margeUnique(arr, arr));
        System.out.printf("Max sub-array sum: %s", Arrays.toString(maxSubArraySum(arr)));
    }


    static void main() {
        int[] arr = _getArr();

        // coBan(arr);
        // trungBinh(arr);
        nangCao(arr);
    }
}
