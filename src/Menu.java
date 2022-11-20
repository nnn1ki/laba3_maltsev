import java.io.*;
import java.util.Scanner;

public class Menu {

    private static int readChoice(){
        Scanner input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }


    public static void startMenu(){

        int choice = -1; //выбора пока нет

        do{
            System.out.println("-------главное меню-------");
            System.out.println("1/ Выполить задание с текстом");
            System.out.println("2/ Выполнить задание с матрицей");
            System.out.println("0/ Выйти из программы");

            choice = readChoice();

            switch (choice){
                case 1:
                    textMenu();
                    break;
                case  2:
                    matrixMenu();
                    break;
                case 0:
                    System.out.println("Программа успешно завершена!");
            }
        }
        while (choice != 0);
    }

    public static void textMenu(){
        Text text = new Text();
        int choice = -1;
        
        do{
            System.out.println("------- Текст -------");
            System.out.println("1/ Создать новый текст");
            System.out.println("2/ Ввести текст");
            System.out.println("3/ Посчитать количество предложений");
            System.out.println("4/ Посчитать количество слов, начинающихся с согланой/гласной букв");
            System.out.println("5/ Найти самое популярное слово");
            System.out.println("6/ Сохранить текст");
            System.out.println("7/ Вывести текст");
            System.out.println("8/ НАЗАД"); //
            System.out.println("0/ Выйти из программы"); //

            choice = readChoice();

            switch (choice){
                case 1:
                    textMenu();
                    System.out.println("Текст создан!");
                    break;
                    
                case 2:
                    enterText(text);
                    break;
                    
                case 3:
                    System.out.println("Количество предложений" + text.numberSentences());
                    break;
                    
                case 4:
                    text.vowelOrConsonant();
                    break;
                    
                case 5:
                    System.out.println("Самое популярное слово " + text.popularWord());
                    break;
                    
                case 6:
                    Scanner s = new Scanner(System.in);

                    System.out.println("Введите имя файла!");
                    String nameFile = s.nextLine();

                    textToFile(nameFile);
                    break;
                    
                case 7:
                    System.out.println(text.getText());
                    break;
                    
                case 8:
                    startMenu();
                    break;

            }

        }
        while (choice != 0);
    }

    private static void textToFile(String nameFile) {
        StringBuilder str = new StringBuilder();

        try(BufferedWriter br = new BufferedWriter(new FileWriter(nameFile))) {
            br.write(str.toString());
        } catch (IOException e) {
            System.out.println("Ошибка записи!");
        }

    }

    private static String textFromFile(String fileName){
        String line = "";

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            line = br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет!");
        } catch (IOException e) {
            System.out.println("Ошибка чтения!");
        }

        return line;
    }


    private static void enterText(Text txt){ // чисто для ввода текста
        int choice = -1;

        System.out.println("------- Меню ввода текста -------");
        System.out.println("1/ Ввести дефолтный текст");
        System.out.println("2/ Прочитать текст из файла");
        System.out.println("3/ Ввести свой текст");
        System.out.println("4/ Ввести текст"); //
        System.out.println("5/ НАЗАД");
        System.out.println("0/ Выйти из программы!");

        choice = readChoice();
        
        switch (choice){
            case 1:
                txt = new Text();
                System.out.println("Стандартный текст создан");
                break;
                
            case 2:
                //читаем массив из файла
                
                //
                break;
                
            case 3:
                Scanner s = new Scanner(System.in);
                String userText = s.nextLine(); 
                txt = new Text(userText);
                System.out.println("Текст введен!");
                break;
                
            case 4:
                System.out.println(txt); //это работает? 
                break;
                
            case 5:
                
                break;
                
            case 6:
                
                break;
                
            
            
        }
    }
    
    
    

    public static void matrixMenu(){
        int choice = -1;

        Array arr = new Array();

        do{
            System.out.println("------- Массив -------");
            System.out.println("1/ Создать новый массив"); //
            System.out.println("2/ Ввести значения массива"); //
            System.out.println("3/ Показать массив"); //
            System.out.println("4/ Удалить повторяющиеся элементы в массиве"); //
            System.out.println("5/ Сохранить массив"); //
            System.out.println("6/ Очистить массив"); //нужен ли?
            System.out.println("7/ НАЗАД"); //
            System.out.println("0/ Выйти из программы"); //

            choice = readChoice();

            switch (choice){
                case 1:
                    arr = new Array();
                    System.out.println("Массив создан!");
                    break;

                case  2:
                    enterMatrixMenu(arr);
                    break;

                case 3:
                    arr.showArr();
                    break;

                case 4:
                    arr.deleteSimilar();
                    System.out.println("Одинаковые элементы удалены");
                    break;

                case 5:
                    arrToFile(arr, "testFile");
                    System.out.println("Файл сохоанен!");
                    break;

                case 6:
                    break;

                case 7:
                    startMenu();
                    break;

                case 8:
                    break;
            }

        } while (choice != 0);

    }


    public static void enterMatrixMenu(Array arr){ //мы передали сюда объект
        int choice = -1;

        do{
            System.out.println("------- Меню ввода масива -------");
            System.out.println("1/ Ввести дефолтный массив");
            System.out.println("2/ Прочитать массив из файла");
            System.out.println("3/ Ввести свои значения");
            System.out.println("4/ Ввести масив");
            System.out.println("5/ НАЗАД");
            System.out.println("0/ Выйти из программы!");

            choice = readChoice();

            switch (choice){
                case 1:
                    arr = new Array();
                    System.out.println("Дефолтные значения заданы!");
                    break;

                case 2:
                    int[] reader = arrFromFile("testFile");
                    arr = new Array(reader);
                    break;

                case 3:
                    Scanner s = new Scanner(System.in);
                    System.out.println("Введите размерность вашего массива: ");
                    int size = Integer.parseInt(s.nextLine());
                    arr.inputArr(size, arr); // передаем массив для записи
                    break;

                case 4:
                    arr.showArr();
                    break;

                case 5:
                    matrixMenu();
                    break;

            }


        } while (choice != 0);




    }

    private static int[] arrFromFile(String nameFile) {

        int[] tempArr = null;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(nameFile))) {
            int size = dis.readInt();

            tempArr = new int[size];

            for(int i = 0; i < size; i++){
                tempArr[i] = dis.readInt();
            }


            return tempArr; //попробуем выводить тут

        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет!");
        } catch (IOException e) {
            System.out.println("Ошибка записи!");
        }

        //return tempArr;
        System.out.println("Файл успешно прочитан! ");
        return new int[0]; //зничего не получилось и вывелся нулевой
    }

    private static void arrToFile(Array values, String nameFile) {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nameFile))){
            dos.writeInt(values.getmatrix().length);

            for(int i = 0; i < values.getmatrix().length; i++){
                dos.writeInt(values.getmatrix()[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла!");

        } catch (IOException e) {
            System.out.println("Ошибка записи!");
        }

    }





}
