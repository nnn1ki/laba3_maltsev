import java.io.*;
import java.util.Arrays;
import java.util.Scanner;



//TODO
//если мы ломаем запись элементов в масссив, то потом массив не вводиться до конца
//этого быть не должно
//возможно программа не возвращяется обратно в ввод

//некоректный вывод массива, говорит что нужно ввести значения меню




public class Menu {
    private static Text text = null; //определяем наш текст
    private static Array array; //определяем наш массив
    private static Scanner input;

    private static String readStr(){ //читаем запись пользователя
        input = new Scanner(System.in);
        return input.nextLine();
    }

    private static int readInt(){ //читаем цифровые значения и проверяем правильность ввода
        int temp = 100; //значение должно быть больше, чем наших case-ов

        try {
            temp = Integer.parseInt(readStr());
            return temp;
        }catch (NumberFormatException e ){
            System.out.println("Вводите корректные значения!");
        }

        return temp;
    }


    public static int getInputNumber(){

        boolean valid; //подходит или нет
        String inputData; //то что мы вводим
        int expectedOutput = 0; //то,что выводим

//        do {
//            System.out.print("Введите значение: \t");
//            try {
//                inputData = readStr(); //читаем потенциальное число
//
//                if (Integer.parseInt(inputData) > 0) {
//                    expectedOutput = Integer.parseInt(inputData);
//                    valid = true;
//                } else {
//                    System.out.println("Invalid Input!");
//                    valid = false;
//                }
//            } catch (Exception ex){
//                valid = false;
//            }
//        } while(!valid);


        do {
            System.out.print("Введите значение: \t");
            try {
                inputData = readStr(); //читаем потенциальное число
                expectedOutput = Integer.parseInt(inputData);
                valid = true;

            } catch (NumberFormatException e){
                valid = false;
            }
        } while(!valid);
        return expectedOutput;
    }

    private static int menuCheck(int num){
        int i;

        while ((i = readInt()) > num || i <= -1){
            System.out.println("Введите корректные значения для меню!");
        }
        return i;
    }


    public static void startMenu(){

        int choice = -1; //выбора пока нет

        do{
            //главное меню
            System.out.println("\n-------главное меню-------");
            System.out.println("1/ Выполнить задание с текстом");
            System.out.println("2/ Выполнить задание с массивом");
            System.out.println("0/ Выйти из программы");

            choice = menuCheck(2);


            switch (choice){
                case 1:
                    textMenu();
                    break;
                case  2:
                    arrayMenu();
                    break;

            }
        }
        while (choice != 0);
        System.out.println("Программа завершена!");
        System.exit(0);
    }

    public static void textMenu(){ //Выполнить задание с текстом

        int choice = -1;

        do{
            System.out.println("\n------- Текст -------");
            System.out.println("1/ Начало работы с текстом"); //вводы, чтения и тд...

            //выполнить задание с текстом
            System.out.println("2/ Посчитать количество предложений");
            System.out.println("3/ Посчитать количество слов, начинающихся с согланой/гласной букв");
            System.out.println("4/ Найти самое популярное слово");

            System.out.println("5/ Сохранить текст");
            System.out.println("6/ Вывести текст");
            System.out.println("7/ НАЗАД");
            System.out.println("0/ Выйти из программы");

            choice = menuCheck(7);


                try {
                    switch (choice) {
                        case 1:
                            creatingTextMenu(); //меню создания текста
                            break;

                        case 2: //количество предложений
                            System.out.println("- количество предложений: " + text.numberSentences());
                            break;

                        case 3: //колисчество слов на гл и солгл
                            System.out.println("С первой согласной: " + text.vowelOrConsonant()[0]);
                            System.out.println("C первой гласной: " + text.vowelOrConsonant()[1]);
                            break;

                        case 4: //самое популярное слово
                            System.out.println("Савмое популярое слово текста " + text.popularWord());
                            break;

                        case 5: //сохранить текст
                            //если текст не был никак введен, то файл будет пустой
                            System.out.println("Введите имя файла, в которй сохранить файл");
                            textToFile(readStr());
                            //вывод подписи о сохранении
                            break;

                        case 6: //вывести текст
                            text.showText();
                            break;

                        case 7: //назад
                            startMenu();
                            break;

                    }

                }
                catch (NullPointerException e) {
                    System.out.println("Сначала создайте текст!");
                }
        }
        while (choice != 0);
        System.out.println("Программа завершена!");
        System.exit(0);
    }

    private static void creatingTextMenu(){ //менб стоздания текста, его ввод...
        int choice = -1;

        do{
            System.out.println("\n--- Создание текста ---");
            System.out.println("1/ Создать новый текст с дефолтным содержанием");
            System.out.println("2/ Создать новый текст и ввести содержание сомостоятельно"); //нельзя работать с текстом, если он не создан
            System.out.println("3/ Создать текст с содержанием из файла");
            System.out.println("4/ Назад");
            System.out.println("0/ ВЫХОД");

            choice = menuCheck(4);

            switch (choice){
                case 1:
                    text = new Text();
                    System.out.println("Текст создан!");
                    textMenu(); //нам уже тут делать нечего
                    break;

                case 2:
                    System.out.println("Напишите свой текст!");
                    text = new Text(readStr()); //передаем написанные текст пользователя в конструктор
                    textMenu();
                    break;

                case 3:
                    System.out.println("Введите имя файла");
                    text = new Text(textFromFile(readStr()));
                    textMenu();
                    break;

                case 4:
                    textMenu();
                    break;

            }

        }while (choice != 0);
        System.out.println("Программа завершена!");
        System.exit(0);
    }

    private static void textToFile(String nameFile) { //сохранение текста в файл
        StringBuilder str = new StringBuilder();

        try(BufferedWriter br = new BufferedWriter(new FileWriter(nameFile))) {
            br.write(str.toString());
            System.out.println("Файл сохранен!");

        } catch (IOException e) {
            System.out.println("Ошибка записи!");
        }

    }

    private static String textFromFile(String fileName){ //чтение текста из файла
        String line = "";

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            line = br.readLine();
            System.out.println("Файл загружен!");

        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет!");
        } catch (IOException e) {
            System.out.println("Ошибка чтения!");
        }

        return line;
    }
    
    //-----------------------------------------------------------------------------------

    public static void arrayMenu(){
        int choice = -1;

        do{
            System.out.println("------- Массив -------");
            System.out.println("1/ Начало работы с массивом"); //меню создания и заполнения массива

            System.out.println("2/ Удалить повторяющиеся элементы в массиве");

            System.out.println("3/ Сохранить массив");
            System.out.println("4/ Очистить массив");
            System.out.println("5/ Показать массив");
            System.out.println("6/ НАЗАД");
            System.out.println("0/ Выйти из программы");

            choice = menuCheck(6);

            try {
                switch (choice){
                    case 1:
                        //меню создания массива
                        creatingArrayMenu();
                        break;

                    case  2: //удалить посвторяющиеся элементы
                        System.out.println("Масив после удаления лишних элементов - " + array.deleteSimilar());
                        break;

                    case 3: //сохранить
                        System.out.println("Введите имя файла, куда сохранить");
                        arrToFile(array, readStr());
                        break;

                    case 4: //очистить массив
                        array.clearArr();
                        System.out.println("значения массива обнулены");
                        break;

                    case 5: //показать массив
                        try {
                            array.showArr(); //на этом этапе программа не сохраняет!
                        }catch (NullPointerException e){
                            System.out.println("Значения массива не сохранены!");
                        }

                        break;

                    case 6: //назад
                        startMenu();
                        break;

                }

            }catch (NullPointerException e){
                System.out.println("Введите значения меню!");
            }


        } while (choice != 0);
        System.out.println("Программа завершена!");
        System.exit(0);
    }





    public static void creatingArrayMenu(){
        int choice = -1;

        Array array1;

        do{
            System.out.println("------- Меню создания массива -------");
            System.out.println("1/ Ввести массив по-умолчанию");
            System.out.println("2/ Ввести в массив свои значения");
            System.out.println("3/ Прочитать массив из файла");
            System.out.println("4/ НАЗАД");
            System.out.println("0/ Выйти из программы!");

            choice = menuCheck(4);

            switch (choice){
                case 1: //по-умолчанию
                    array = new Array();
                    System.out.println("Дефолтные значения заданы!");
                    arrayMenu();
                    break;

                case 2: //свои значения
                    System.out.println("Введите количество элементов");

                    int[] arr = new int[readInt()];
                    int num;

                    for(int i = 0; i < arr.length; i++){
                        System.out.println("Введите значения вашего массива: ");
                        arr[i] = getInputNumber(); //ждет ввода корректного числа
                    }

                    array = new Array(arr);
                    arrayMenu();

                    break;

                case 3: //прочитать значения из файла
                    System.out.println("Введите имя файла, из которого нужно прочитать значения");
                    array = new Array(arrFromFile(readStr())); //создали объект в который передали массив, прочтенный из файла
                    arrayMenu();
                    break;

                case 4:
                    arrayMenu();
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }


        } while (choice != 0);
        System.out.println("Программа завершена!");
        System.exit(0);

    }

    private static int[] arrFromFile(String nameFile) {

        int[] tempArr = null;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(nameFile))) {
            int size = dis.readInt();

            tempArr = new int[size];

            for(int i = 0; i < size; i++){
                tempArr[i] = dis.readInt();
            }

            System.out.println("Файл успешно прочитан! ");
            return tempArr; //попроб

        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет!");
        } catch (IOException e) {
            System.out.println("Ошибка чтения!");
        }

        return new int[0]; //зничего не получилось и вывелся нулевой
    }

    private static void arrToFile(Array values, String nameFile) {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nameFile))){
            dos.writeInt(values.getmatrix().length);

            for(int i = 0; i < values.getmatrix().length; i++){
                dos.writeInt(values.getmatrix()[i]);
            }

            System.out.println("Файл сохранен!");

        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла!");

        } catch (IOException e) {
            System.out.println("Ошибка записи!");
        }

    }

}
