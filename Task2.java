import java.util.logging.*;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        calculate();
    }

    public static void calculate() {
        Logger logger = Logger.getLogger("MyLog");
        logger.setUseParentHandlers(false);
        FileHandler fh;

        try {
            fh = new FileHandler("Log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (IOException e) {
            e.printStackTrace();
        }
        int result = 0;
        Scanner sc = new Scanner(System.in);
        String logStr = "Результат - ";
        
        while (true) {
            System.out.print("Введите операцию +-*/ либо команду stop для выхода из калькулятора ");
            String op = sc.next();
            logger.info("Ввел " + op);
            System.out.print("Введите первое число: ");
            int a = sc.nextInt();
            logger.info(getText(a));
            System.out.print("Введите второе число: ");
            int b = sc.nextInt();
            logger.info(getText(b));

            if (op.equals("stop")) {
                logger.info(op);
                break;
            } else if (op.equals("+")) {
                result = a + b;
                logger.info(logStr + result);
                System.out.println(result);
            } else if (op.equals("-")) {
                result = a - b;
                logger.info(logStr + result);
                System.out.println(result);
            } else if (op.equals("*")) {
                result = a * b;
                logger.info(logStr + result);
                System.out.println(result);
            } else {
                result = a / b;
                logger.info(logStr + result);
                System.out.println(result);
            }
        }
        sc.close();

    }

    private static String getText(int value) {
        return "Пользователь ввёл число " + Integer.toString(value);
    }
}