package tasks;

public class Search {

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "banana"};
        String targetWord = "banana";
        boolean isFound = false;

        for (String word: words) {
            if (word.equals(targetWord)) {
                isFound = true;
                System.out.println("Слово " + word + " найдено");
            }
            else if (isFound)
            System.out.println("Слово не найдено");
            }
        }
    }
