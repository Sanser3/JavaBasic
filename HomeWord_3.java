/**
* JavaBasic. HomeWork #3
*
* @author Sergey Sanzarevskiy
* @todo 13.9.2022
* @date 12.9.2022
*
*/
class HomeWord_3 {
    public static void main(String[] args) {
        int array[] = {1, 17, 4, 12, 22, 8, -1};

        //task1
        printArray(array);
        System.out.println();

        //task2
        System.out.println("max = " + getMax(array));
        System.out.println();

        //task3
        int arrayInvert[] = {1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1};
        printArray(arrayInvert);
        printArray(invertArray(arrayInvert));
        System.out.println();

        //task4
        printArray(sortArray(array));
        System.out.println();

        //уже запутался в этих методах сортировок (написал ещё один для примера)
        printArray(sortPrim(array));
        System.out.println();

        //task5
        boolean asc = true;
        printArray(sortArrayM(array, asc));
        System.out.println();
    }

    //task1
    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //task2
    static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    //task3
    static int[] invertArray(int[] arr) {
        int arrIn[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arrIn[i] = 1;
            }
        }
        return arrIn;
    }

    //task4
    static int[] sortArray(int[] arr) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            //printArray(arr);//оставил специально строчку для вывода пошагового изменения масива
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
        return arr;
    }

    static int[] sortPrim(int[] arr) {
        //System.out.println(printArray(arr));
        for (int j = 0; j < arr.length; j++) {
            int mIn = j;
            for (int i = j; i < arr.length; i++) {
                if (arr[i] > arr[mIn]) {
                    mIn = i;
                }
            }
        }
        return arr;
    }

    //task5
    static int[] sortArrayM(int[] arr, boolean asC) {
        if (asC) {
            for (int i = 0; i < arr.length - 1; i++) {
                //printArray(arr);//оставил специально строчку для вывода пошагового изменения масива
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                //printArray(arr);//оставил специально строчку для вывода пошагового изменения масива
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] < arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
        return arr;
    }
}