import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Task1 {
    public static void main(String[] args) {
        int[] nums = {11, 3, 14, 16, 7};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubbleSort(int[] arr) {
        Logger logger = Logger.getLogger("MyLog");
        logger.setUseParentHandlers(false);
        FileHandler fh;
        try {
            fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        boolean isSorted = false;
        int buf;
        String text = "";
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                    text = String.format("Поменяли местами число %d и %d \n", arr[i + 1], arr[i]);
                    logger.info(text);
                } else {
                    text = "Ничего не поменяли местами \n";
                    logger.info(text);
                }
            }
        }
    }
    
}
