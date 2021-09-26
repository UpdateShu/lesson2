package ru.geekbrains.lessons;

public class MainApp
{
    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1 };//{ 4, 2, 7, 1, 5, 3, 6, 8, 0, 1, 9, 7};
        PrintArray(arr, "Исходный массив: ");//ArrayShiftN(arr, 5);
        InvertValues(arr);
        PrintArray(arr, "Инвертированный массив: ");

        PrintArray(GetArrayWithMultipleValue(8, 3), "Массив значений, кратных 3: ");

        int[] arr1 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        PrintArray(arr1, "Исходный массив: ");
        MultiplyValueOnCondition(arr1, 6, 2);
        PrintArray(arr1, "Массив значений *2 (при условии < 6): ");

        CreateSquareArray(7);

        PrintArray(arr1, "Массив: ");
        System.out.println("max = " + GetMaxElement(arr1) + ", min = " + GetMinElement(arr1));

        int[] arr2 = { 2, 2, 2, 1, 2, 2, 10, 1 };
        int[] arr3 = { 1, 1, 1, 2, 1 };
        if (CheckBalance(arr2))
            System.out.println("Проверка успешна!");
        else
            System.out.println("Проверка провалилась!");

        PrintArray(arr1, "Массив: ");
        ShiftArray(arr1, 3);
    }

    static void InvertValues(int[] arr){
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i] == 0 ? 1 : 0;
    }

    static int[] GetArrayWithMultipleValue(int length, int k){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = i * k;
        return arr;
    }

    static void MultiplyValueOnCondition(int[] arr, int border, int k)
    {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < border)
                arr[i] *= k;
    }

    static void CreateSquareArray(int length){
        int[][] arr = new int[length][length];
        String outStr = "";
        for (int i = 0; i < length; i++){
            for ( int j = 0; j < length; j++ ) {
                arr[i][j] = i == j ? 1 : 0;
                outStr += arr[i][j] + ", ";
            }
            outStr += '\n';
        }
        System.out.println("Квадратный массив, размером [" + length + " * " + length + "]:");
        System.out.println(outStr);
    }

    static int GetMaxElement(int[] arr){
        int maxElement = arr[0];
        for (int i = 0; i < arr[i]; i++)
        {
            if (arr[i] > maxElement)
                maxElement = arr[i];
        }
        return maxElement;
    }

    static int GetMinElement(int[] arr){
        int minElement = arr[0];
        for (int i = 0; i < arr[i]; i++)
        {
            if (arr[i] < minElement)
                minElement = arr[i];
        }
        return minElement;
    }

    static boolean CheckBalance (int[] arr)
    {
        String outStr = "" + arr[0];
        int checkVal = -1;
        for (int i = 1; i < arr.length; i++){
            if (checkVal == -1)
            {
                int sum1 = 0;
                int sum2 = 0;
                for (int j = 0; j < arr.length; j++)
                {
                    if (j < i)
                        sum1 += arr[j];
                    else
                        sum2 += arr[j];
                }
                if (sum1 == sum2){
                    checkVal = i;
                    outStr += " ||";
                }
            }
            outStr += ", " + arr[i];
        }
        System.out.println("Массив: " + outStr);
        return checkVal != -1;
    }

    static void PrintArray(int[] arr, String info)
    {
        String str = "";
        for (int k = 0; k < arr.length; k++)
            str += arr[k] + ", ";
        System.out.println(info + " [" + str + "]");
    }

    static void ShiftArray(int[] arr, int n)
    {
        if (n > 0)
        {
            for (int i = 0; i < n; i++)
                arr[0] = GetShiftLeftIndex(arr, arr.length - 1);
        }
        else {
            for (int i = n; i < 0; i++)
                arr[arr.length - 1] = GetShiftRightIndex(arr, 0);
        }
        PrintArray(arr, "Сдвиг на " + n + ": ");
    }

    static int GetShiftRightIndex(int[] arr, int index)
    {
        if (index < arr.length - 1)
        {
            int shiftVal = GetShiftRightIndex(arr, index + 1);
            int iVal = arr[index];
            arr[index] = shiftVal;
            return iVal;
        }
        return arr[arr.length - 1];
    }

    static int GetShiftLeftIndex(int[] arr, int index)
    {
        if (index > 0)
        {
            int shiftVal = GetShiftLeftIndex(arr,index - 1);
            int iVal = arr[index];
            arr[index] = shiftVal;
            return iVal;
        }
        return arr[0];
    }
}
