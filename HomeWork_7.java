import java.util.*;

/**
 * JavaBasic. HomeWork #7
 *
 * @author Sergey Sanzharevskiy
 * @todo 26.9.2022
 * @date 27.9.2022
 *
 */

public class HomeWork_7 {
    public static void main(String[] args) {

        //task2
        int[] arr = generatorArray(500_000);
        Arrays.sort(arr);
        int key = (int) (Math.random() * 100_000);

        //oneAtATime
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.printf("position - %d : number - %d\n", i, key);
                break;
            }
        }
        System.out.println("oneAtATime: "+ (System.currentTimeMillis() - startTime1));

        //binarySearch()
        long startTime2 = System.currentTimeMillis();
        int found = Arrays.binarySearch(arr, key);
        System.out.println("position - " + found + " : number - " + arr[found]);
        System.out.println("binarySearch: " + (System.currentTimeMillis() - startTime2));
   }
    static int[] generatorArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 100_000);
        }
        return result;
    }

    //task1
    static void showShuffle() {
        //part of Lottery game
        List<Integer> lottery = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lottery.add(i + 1);
        }
        // shuffle
        Collections.shuffle(lottery);
        System.out.println(lottery.subList(0, 10));
    }

    static void showCollections() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(6, 8, 2, 3, 1));
        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

    static void showMap() {
        Map<Integer, String> dayMap = new HashMap<>();
        dayMap.put(1, "Monday");
        dayMap.put(2, "Tuesday");
        System.out.println(dayMap);
        System.out.println(dayMap.get(1));
    }

    static void showArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        System.out.println(arrayList);
        arrayList.add(5);
        arrayList.add(8);
        arrayList.addAll(Arrays.asList(4, 3, 2, 1));
        System.out.println(arrayList);
        arrayList.add(2, 12);
        System.out.println(arrayList);
        arrayList.remove(4);
        System.out.println(arrayList);
        for (Integer a : arrayList) {
            System.out.println(a);
        }
    }

    static void showArray() {
        int[] arr = generatorArray(20);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int key = (int) (Math.random() * 20);
        int found = Arrays.binarySearch(arr, key);
        System.out.println(found + ": " + arr[found]);
    }
}