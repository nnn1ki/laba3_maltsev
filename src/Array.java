import java.util.Scanner;

public class Array {
    private int[] mass;
    private int[] defaultMass;

    public Array() {
        defaultMass = new int[]{12, 13, 14, 15, 16};
        mass = new int[5];

        for (int i = 0; i < defaultMass.length; i++ ){
            mass[i] = defaultMass[i];
        }
    }

    public Array(int[] userMatr) {
        this.defaultMass = new int[]{12, 11, 10, 9, 8};
        this.mass = userMatr;
    }

    public Array(Array other) {
        this(other.getmatrix());
    }

    public int[] getmatrix() {
        return this.mass;
    }

    public String deleteSimilar() {
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

    public void showArr(){
        for(int i = 0; i < mass.length; i++){
            System.out.println(mass[i]);
        }
    }

    public Array inputArr(int size, Array arr){
        Scanner s = new Scanner(System.in);

        System.out.println("Введите значения вашего массива: ");

        for(int i = 0; i < size; i++){
            arr.mass[i] = Integer.parseInt(s.nextLine()); // берем значения в массив
        }

        return arr;
    }

}
