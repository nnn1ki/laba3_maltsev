import java.util.Scanner;

public class Array {
    private int[] mass; //задан неявно

    private final int[] defaultMass = new int[]{11, 11, 10, 9, 8}; //дефолтный массив для задания
    private Scanner input;

    public Array() { //создание массива с дефолтными значениями
        //копируем наше содержание в рабочий массив
        //System.arraycopy(defaultMass, 0, mass, 0, defaultMass.length + 1);

        mass = new int[defaultMass.length];

        for(int i = 0; i < defaultMass.length; i++){
            mass[i] = defaultMass[i];
        }
    }

    public Array(int[] userArr) { //значения пользователя
        //копируем значения введенного массива в наш

        mass = new int[userArr.length];

        for(int i = 0; i < userArr.length; i++){
            mass[i] = userArr[i];
        }

        //System.arraycopy(userArr, 0, mass, 0, userArr.length + 1);
    }

    public Array(Array other) {//клонирование
        this(other.getmatrix());
    }

    public int[] getmatrix() {
        return this.mass;
    }

    public void showArr(){ //выводи массива на экран
        String strArr = "";
        for(int i = 0; i < mass.length; i++){
            strArr += Integer.toString(mass[i]) + ' ';
        }

        System.out.println(strArr);
    }

    public String deleteSimilar() { //блок по заданию
        String ansStr = "";

        for(int i = 0; i < this.mass.length; ++i) {
            boolean inMass = false;

            for(int j = i + 1; j < this.mass.length; ++j) {
                if (this.mass[i] == this.mass[j]) {
                    inMass = true;
                    break;
                }
            }

            if (!inMass) {
                ansStr = ansStr + this.mass[i] + " ";
            }
        }

        return ansStr;
    }

    public  void clearArr(){ //обнуление всех значений
        for (int i : mass){
            mass[i] = 0;
        }

    }



}
