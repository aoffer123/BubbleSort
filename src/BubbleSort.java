import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort {
    public static void printArray(int array[]) {
        int ai[];
        int j = (ai = array).length;
        for (int i = 0; i < j; i++) {
            int a = ai[i];
            System.out.print((new StringBuilder(String.valueOf(a))).append(" ").toString());
        }

        System.out.println();

    }

    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void writeArrayToFile(int array[], String fileName) throws Exception {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            int ai[];
            int j = (ai = array).length;
            for (int i = 0; i < j; i++) {
                int a = ai[i];
                fileWriter.write((new StringBuilder(String.valueOf(a))).append("\n").toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Encounter an IOException");
            e.printStackTrace();

        }

    }

    public static int[] readArrayFromFile(String fileName) {
        File file = new File(fileName);
        try
        {
            try (Scanner scanner = new Scanner(file)) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                int a;
                for(; scanner.hasNextLine(); arrayList.add(Integer.valueOf(a)))
                {
                    String str = scanner.nextLine();
                    a = Integer.parseInt(str);
                }

                int array[] = new int[arrayList.size()];
                for(int i = 0; i < arrayList.size(); i++)
                    array[i] = ((Integer)arrayList.get(i)).intValue();

      scanner.close();
                return array;
            } catch (NumberFormatException e) {
               
                e.printStackTrace();
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
        

    public static void bubbleSort(int array[]) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
            printArray(array);

        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a filename");
        // int arrayLength = 5;
        String fileName = scanner.next();
        // int[] array = createRandomArray(arrayLength);
        // printArray(array);
        // writeArrayToFile(array, fileName);
        int[] array = readArrayFromFile(fileName);
        bubbleSort(array);
        writeArrayToFile(array, "sorted.txt");
        scanner.close();
    }
}
