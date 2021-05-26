package lessons;


import java.util.*;

public class lesson4PraxisSpiel {

    private static final String[][] WORDS = {{"tiger", "lion", "crocodile", "elephant", "lynx", "leopard"}, {"berlin", "bremen", "leipzig", "bohn", "gamburg", "stuttgart"}, {"banana", "apple", "watermelon", "pear", "mango", "orange"}};
    private static final String[] CATEGORIES = {"WILD ANIMALS", "GERMAN TOWNS", "FRUITS"};//Массив тем
    private static final int MAX_ATTEMPT_COUNT = 6;                     //Количество частей тела висельника
    private static String[] OPEN_TEXT_ARRAY;                            //Массив букв слова
    private static String[] HIDDEN_TEXT_ARRAY;                          //Массив закрытых букв слова
    private static final String GALLOWS =
            "_|____ \n" +
            " | / | \n" +
            " |/    \n" +
            " |     \n" +
            " |     \n" +
            " |     \n" +
            "_|_____";
    private static final String WIN_SCREEN =
            " __  __\n" +
            " ||  ||\n" +
            " ||  ||\n" +
            " ||  //\n" +
            " || // \n" +
            " ||//  \n" +
            " |_/   \n";
    private static final String LOSE_SCREEN =
            " _____ \n" +
            "/     \\\n" +
            "|     |\n" +
            "| RIP |\n" +
            "|     |\n" +
            "|     |\n" +
            "|_____|\n";
    private static int counter = 0;                                             //Счетчик ошибок, по количеству частей тела висельника
    private static int letterCounterToWin = 0;                                  //Счетчик правильно угаданных букв
    private static int chosenCategory = 0;                                      //Номер категории
    private static boolean gameEnd = false;                                     //Статус игры. Если количество попыток >6 или угаданы все буквы, то становится true
    private static final ArrayList<String> USED_LETTER = new ArrayList<>();     //Массив с выбранными буквами для вывода на экран, чтобы не путаться и чтобы учитывать повторы при подсчете счетчиков ошибок и угаданных букв

    public static void main(String[] args) {
        if(!playGame()){
            System.out.println("YER A LOSER, HARRY!");
            System.out.println(LOSE_SCREEN);                              //Печать картинки проигрыша
        }else{
            System.out.println("WINNER, WINNER, CHICKEN DINNER!!!");
            System.out.println(WIN_SCREEN);                                //Печать картинки выйгрыша
        }
    }

    private static boolean playGame() {
        USED_LETTER.add("Used letters");                        // Инициализация массива выбранных букв
        String word = chooseCategory();
        System.out.println(GALLOWS);
        System.out.println("\n");
        makeTextArrays(word);                                   //Разбиваем слово на массив открытых и закрытых букв, записываем в соответствующие переменные класса
        for (String hiddenLetter : HIDDEN_TEXT_ARRAY) {         //Печать массива закрытых букв
            System.out.print("  " + hiddenLetter + "  ");
        }
        System.out.println("\n");
        while (!gameEnd) {                                      //Запускаем основной игровой цикл, он крутится до тех пор пока gameEnd не станет true
            makeMove();
        }
        return counter < MAX_ATTEMPT_COUNT;
    }

    private static String chooseCategory(){
        System.out.println("Choose category to play:");
        for (int i = 0; i < CATEGORIES.length; i++) {
            System.out.println(i + ") " + CATEGORIES[i]);
        }
        Scanner scanner = new Scanner(System.in);
        String word = null;
        chosenCategory = scanner.nextInt();
        switch (chosenCategory) {                                            //Выбираем массив со словами по выбору игрока
            case 0:
                word = pickRandomWord(WORDS[0]);                             //Выбираем случайное слово из массива
                System.out.println(CATEGORIES[0]);
                break;
            case 1:
                word = pickRandomWord(WORDS[1]);
                System.out.println(CATEGORIES[1]);
                break;
            case 2:
                word = pickRandomWord(WORDS[2]);
                System.out.println(CATEGORIES[2]);
                break;
        }
        return word;
    }

    private static void makeMove() {
        System.out.println("\n" + CATEGORIES[chosenCategory]);
        System.out.println("Enter your letter (Allowed: a-z, -)");     //Спрашиваем и считываем букву
        Scanner scanner = new Scanner(System.in);
        String enteredLetter = scanner.nextLine();
        if (checkIfLetterAlreadyUsed(enteredLetter)) {
            checkIfLetterIsInWord(enteredLetter);
        }
        System.out.println(drawHangman());
        System.out.println("\n");
        for (String hiddenLetter : HIDDEN_TEXT_ARRAY) {
            System.out.print("  " + hiddenLetter + "  ");
        }
        System.out.println("\n");
        System.out.println(USED_LETTER);                            //Выводим массив использованных букв для информации игрока

        if (letterCounterToWin == OPEN_TEXT_ARRAY.length || counter >= MAX_ATTEMPT_COUNT) {    //Проверка статуса окончания игры
            gameEnd = true;
        }
    }

    private static void checkIfLetterIsInWord(String enteredLetter){
        boolean guess = false;
        for (int j = 0; j < OPEN_TEXT_ARRAY.length; j++) {
            if (enteredLetter.equals(OPEN_TEXT_ARRAY[j])) {
                HIDDEN_TEXT_ARRAY[j] = OPEN_TEXT_ARRAY[j];
                letterCounterToWin += 1;
                guess = true;
            }
        }
        if(!guess){
            counter += 1;
        }
        USED_LETTER.add(enteredLetter);                             //Добавляем букву в массив использованных букв
    }

    private static boolean checkIfLetterAlreadyUsed(String enteredLetter) {
        for (String usedLetter : USED_LETTER) {
            if (enteredLetter.equals(usedLetter)) {
                counter +=1;
                System.out.println("Already used this letter, shame on you!");
                return false;
            }
        }
        return true;
    }

    private static String drawHangman() {           //Метод хранящий и выдающий висельника
        String gallows = GALLOWS;
        switch (counter) {
            case 1:
                gallows =
                        "_|____ \n" +
                        " | / | \n" +
                        " |/  O \n" +
                        " |     \n" +
                        " |     \n" +
                        " |     \n" +
                        "_|_____";
                break;
            case 2:
                gallows =
                        "_|____ \n" +
                        " | / | \n" +
                        " |/  O \n" +
                        " |   | \n" +
                        " |     \n" +
                        " |     \n" +
                        "_|_____";
                break;
            case 3:
                gallows =
                        "_|____ \n" +
                        " | / | \n" +
                        " |/  O \n" +
                        " |  -| \n" +
                        " |     \n" +
                        " |     \n" +
                        "_|_____";
                break;
            case 4:
                gallows =
                        "_|____ \n" +
                        " | / | \n" +
                        " |/  O \n" +
                        " |  -|-\n" +
                        " |     \n" +
                        " |     \n" +
                        "_|_____";
                break;
            case 5:
                gallows =
                        "_|____ \n" +
                        " | / | \n" +
                        " |/  O \n" +
                        " |  -|-\n" +
                        " |  /  \n" +
                        " |     \n" +
                        "_|_____";
                break;
            case 6:
                gallows =
                        "_|____ \n" +
                        " | / | \n" +
                        " |/  O \n" +
                        " |  -|-\n" +
                        " |  / \\\n" +
                        " |     \n" +
                        "_|_____";
                break;
        }
        return gallows;
    }

    private static void makeTextArrays(String word) {                           //Разбиваем слово на массив букв
        String[] openTextArray = word.split("", 0);
        OPEN_TEXT_ARRAY = openTextArray;
        HIDDEN_TEXT_ARRAY = new String[openTextArray.length];
        Arrays.fill(HIDDEN_TEXT_ARRAY, "_");
    }

    private static String pickRandomWord(String[] wordsArray) {                 //Выбираем случайное слово из массива темы игры
        Random random = new Random();
        int intrandom = random.nextInt(wordsArray.length - 1);
        return wordsArray[intrandom];
    }
}
