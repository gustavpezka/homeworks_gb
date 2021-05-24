package lessons;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson4_praxis_spiel {

    private static final String [] animals = {"tiger","lion","crocodile","elephant","lynx","leopard"};
    private static final String [] germanTowns = {"berlin","bremen","leipzig","bohn","gamburg","stuttgart"};
    private static final String [] fruits = {"banana","apple","watermelon","pear","mango","orange"}; //Массивы слов
    private static final String [] categories = {"Fruits", "Wild animals", "German towns"};//Массив тем
    private static int counter = 0;                                     //Счетчик ошибок, по количеству частей тела висельника
    private static int letterCounterToWin = 0;                          //Счетчик правильно угаданных букв
    private static boolean gameEnd = false;                             // Статус игры. Если количество попыток >6 или угаданы все буквы, то становится true
    private static ArrayList<String> usedLetters = new ArrayList<>();   //Массив с выбранными буквами для вывода на экран, чтобы не путаться и чтобы учитывать повторы при подсчете счетчиков ошибок и угаданных букв

    public static void main(String[] args) {
        usedLetters.add("Used letters");                                // Инициализация массива выбранных букв
        System.out.println("Choose category to play:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println(i + ") " + categories[i]);
        }
        Scanner scanner = new Scanner(System.in);
        playGame(scanner.nextInt());
    }

    public static void playGame(int categoryType){
        String[][] gallows = drawGallows();
        String word = null;
        switch (categoryType){                                          //Выбираем массив со словами по выбору игрока
            case 0:
                word = pickWord(fruits);                                //Выбираем случайное слово из массива
                System.out.println(categories[0]);
                break;
            case 1:
                word = pickWord(animals);
                System.out.println(categories[1]);
                break;
            case 2:
                word = pickWord(germanTowns);
                System.out.println(categories[2]);
                break;
        }
        for (int i = 0; i < 7; i++) {                                   //Рисуем виселицу в первый раз
            for (int j = 0; j < 7; j++) {
                System.out.print(gallows[i][j]);
            }
            System.out.println();
        }

        System.out.println("  ");
        String[] openLetters = makeOpenTextArray(word);                 //Разбиваем слово на массив букв и рисуем массив подчеркиваний для угадывания в первый раз
        String[] hiddenLetters = makeHiddenTextArray(openLetters);      //Вызов метода массива подчеркиваний для передачи в основной игровой цикл, для дальнейшей игры
        System.out.println("  ");
        System.out.println("  ");
        while (!gameEnd){                                               //Запускаем основной игровой цикл, он крутится до тех пор пока gameEnd не станет true
            makeMove(openLetters, hiddenLetters, gallows);
        }
        if (counter>=6){                                                //Проверяем статус оконченной игры
            System.out.println("YER A LOSER, HARRY!");
            drawEndScreen(true);                                 //Вызываем картинку проигрыша
        }else{
            System.out.println("WINNER, WINNER, CHICKEN DINNER!!!");
            drawEndScreen(false);                                //Вызываем картинку выйгрыша
        }
    }

    public static void makeMove(String[] openLetters, String[] hiddenLetters, String[][] gallows){
        System.out.println("Enter your letter (Allowed: a-z, -)");     //Спрашиваем и считываем букву
        Scanner scanner = new Scanner(System.in);
        String enteredLetter = scanner.nextLine();
        boolean letterNotUsed = true;                                   //Переменная метода - была ли эта буква выбрана раньше или нет
        //System.out.println(Arrays.toString(openLetters));             //Вывод загаданного слова на экран, для отладки
        boolean noGuess = true;                                         //Переменная метода показывает угадана буква или нет
        for (int i = 0; i < usedLetters.size(); i++) {                  //Проверка по массиву использованных букв, если такая уже была, то счетчик ошибок +1
            if (enteredLetter.equals(usedLetters.get(i))) {
                letterNotUsed = false;
            }
        }
        if (letterNotUsed) {                                            //Проверка наличия введенной буквы в массиве букв угадываемого слова
            for (int j = 0; j < openLetters.length; j++) {
                if (enteredLetter.equals(openLetters[j])) {
                    hiddenLetters[j] = openLetters[j];
                    noGuess = false;
                    letterCounterToWin += 1;
                }
            }
            usedLetters.add(enteredLetter);                             //Добавляем букву в массив использованных букв
        }
        if(noGuess){                                                    //Если не угадали - перерисовываем висельника
            counter += 1;
            gallows = drawHangman(gallows);                             //Дорисовываем еще одну часть висельника
            for (int i = 0; i < 7; i++) {                               //Выводим на экран
                for (int j = 0; j < 7; j++) {
                    System.out.print(gallows[i][j]);
                }
                System.out.println();

            }
            System.out.println();
            for (int i = 0; i < hiddenLetters.length; i++) {            //Перерисовываем текстовое поле без изменений
                System.out.print("  " + hiddenLetters[i] + "  ");
            }
            System.out.println();
            System.out.println();
            System.out.println(usedLetters);                            //Выводим массив использованных букв для информации игрока
        }else{
            for (int i = 0; i < 7; i++) {                               //Перерисовываем виселицу без изменений
                for (int j = 0; j < 7; j++) {
                    System.out.print(gallows[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            for (int i = 0; i < hiddenLetters.length; i++) {            //Перерисовываем текстовое поле с угаданной буквой
                System.out.print("  " + hiddenLetters[i] + "  ");
            }
            System.out.println();
            System.out.println();
            System.out.println(usedLetters);                            //Выводим массив использованных букв для информации игрока
        }

        if (letterCounterToWin == openLetters.length || counter>=6){    //Проверка статуса окончания игры
            gameEnd = true;
        }
    }

    public static String[][] drawHangman(String[][] gallows){           //Метод дорисовывающий висельника
        switch(counter){
            case 1:
                gallows[2][5] = "O";
                break;
            case 2:
                gallows[3][5] = "|";
                break;
            case 3:
                gallows[3][4] = "-";
                break;
            case 4:
                gallows[3][6] = "-";
                break;
            case 5:
                gallows[4][4] = "|";
                break;
            case 6:
                gallows[4][6] = "|";
                break;
        }
        return gallows;
    }

    public static String [] makeOpenTextArray(String word){             //Разбиваем слово на массив букв
        String [] openLetters = word.split("",0);
        String [] hiddenLetters = makeHiddenTextArray(openLetters);
        for (int i = 0; i < hiddenLetters.length; i++) {                //Этот цикл дублируется в методе makeMove, но он нужен здесь для первоначальной отрисовки игрового поля
            System.out.print("  " + hiddenLetters[i] + "  ");
        }
        return openLetters;
    }

    public static String[] makeHiddenTextArray(String[] lettersWord){   //Формируем массив закрытых букв и передаём его в метод playGame
        String [] hiddenLetters = new String[lettersWord.length];
        Arrays.fill(hiddenLetters, "_");
        return hiddenLetters;
    }

    public static String pickWord(String[] wordsArray){                 //Выбираем случайное слово из массива темы игры
        Random random = new Random();
        int intrandom = random.nextInt(wordsArray.length-1);
        return wordsArray[intrandom];
    }

    public static String [][] drawGallows(){                            //Рисуем виселицу
        String arrayGallows[][] = new String[7][7];
        for (int i = 0; i < arrayGallows.length; i++) {                 //Заполняем поле пробелами
            for (int j = 0; j < arrayGallows[0].length; j++) {
                arrayGallows[i][j] = " ";
            }
        }
        for (int i = 0; i < arrayGallows[6].length; i++) {
            arrayGallows[6][i] = "_";
        }
        for (int i = 0; i < 6; i++) {
            arrayGallows[i][1] = "|";
        }
        arrayGallows[0][0] = "_";
        arrayGallows[0][2] = "_";
        arrayGallows[0][3] = "_";
        arrayGallows[0][4] = "_";
        arrayGallows[0][5] = "_";
        arrayGallows[6][1] = "|";
        arrayGallows[2][2] = "/";
        arrayGallows[1][3] = "/";
        arrayGallows[1][5] = "|";
        return arrayGallows;
    }

    public static void drawEndScreen(boolean status) {                  //Рисуем конец игры
        String endScreen[][] = new String[7][7];
        for (int i = 0; i < endScreen.length; i++) {                    //Заполняем поле пробелами
            for (int j = 0; j < endScreen[0].length; j++) {
                endScreen[i][j] = " ";
            }
        }
        if(status){                                                     //Картинка при проигрыше
            for (int i = 0; i < endScreen.length; i++) {
            endScreen[6][i] = "_";
            }

            for (int i = 2; i < endScreen.length; i++) {
                endScreen[i][1] = "|";
                endScreen[i][5] = "|";
            }

            endScreen[1][1]="/";
            endScreen[0][2]="_";
            endScreen[0][4]="_";
            endScreen[0][3]="_";
            endScreen[1][5]="|";
            endScreen[3][2]="R";
            endScreen[3][3]="I";
            endScreen[3][4]="P";


        }else{                                                          //Картинка при выйгрыше
            for (int i = 1; i < endScreen.length; i++) {
                endScreen[i][1]="|";
            }
            endScreen[0][1]="_";
            endScreen[0][2]="_";
            endScreen[0][5]="_";
            endScreen[0][6]="_";
            endScreen[1][2]="|";
            endScreen[2][2]="|";
            endScreen[3][2]="|";
            endScreen[4][2]="|";
            endScreen[1][5]="|";
            endScreen[1][6]="|";
            endScreen[2][5]="|";
            endScreen[2][6]="|";
            endScreen[4][3]="/";
            endScreen[3][4]="/";
            endScreen[3][6]="/";
            endScreen[4][5]="/";
            endScreen[5][4]="/";
            endScreen[6][3]="/";
            endScreen[6][2]="_";
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(endScreen[i][j]);
            }
            System.out.println();
        }
    }
}


