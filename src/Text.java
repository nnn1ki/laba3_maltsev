import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class Text {
    private String text;
    private  final String defautText = "Hello, Ann! Hello, world!"; //дефолтный текст
    private String[] words;

    //переписать функции вывода
    //написать функцию стирания
    //функция создания
    //функция записи и сохранения


    public Text() {
        text = defautText;
        words = text.split("\\W+");
    }

    public Text(String text) { //конструктор пользовательского ввода
        this.text = text;
        words = text.split("\\W+");
    }

    public Text(Text other) { //типо копирование
        this(other.getText());
    } //клонирование

    public String getText() {
        return this.text;
    }


    public void showText(){ //выводим наш текст
        System.out.print(text + '\n');
    }


    public int numberSentences() { //блок по заданию
        int numderOfSentences = 0;
        String signsEnd = ".;!?";

        for(int i = 0; i < this.text.length(); ++i) {
            for(int s = 0; s < signsEnd.length(); ++s) {
                if (this.text.charAt(i) == signsEnd.charAt(s)) {
                    ++numderOfSentences;
                }
            }
        }

        return numderOfSentences;
    }

    public String popularWord() { //блок по заданию
        String popWord = "";
        int maxCount = 0;

        for(int i = 0; i < this.words.length; ++i) {
            int count = 0;

            for(int j = i + 1; j < this.words.length; ++j) {
                if (this.words[i].equals(this.words[j])) {
                    ++count;
                }
            }

            if (maxCount < count) {
                maxCount = count;
                popWord = this.words[i];
            }
        }

        return popWord;
    }

    public int[] vowelOrConsonant() { //блок по заданию

        int[] conVow = new int[2];//массив для двух значений
        String vowelLetters = "eyuioa";
        int vowInt = 0;
        int conInt = 0;

        for(int i = 0; i < this.words.length; ++i) {
            boolean vow = false;

            for(int j = 0; j < vowelLetters.length(); ++j) {
                if (this.words[i].charAt(0) == vowelLetters.charAt(j)) {
                    vow = true;
                    break;
                }
            }

            if (vow) {
                ++vowInt;
            } else {
                ++conInt;
            }
        }

        conVow[0] = conInt;
        conVow[1] = vowInt;

        return conVow;
    }


}
