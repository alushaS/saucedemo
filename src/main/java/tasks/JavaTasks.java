package tasks;

public class JavaTasks {

    public static void main(String[] args) {

        JavaTasks javaTasks = new JavaTasks();
        javaTasks.sumNumbers();

    }

    public void sumNumbers() {
        int sum = 0;
        for(int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Сумма чисел от 1 до 100: " + sum);
    }
}
