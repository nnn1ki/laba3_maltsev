public class Matrix {
    private int[] mass;
    private int[] defaultMass;

    public Matrix() {
        this.defaultMass = new int[]{12, 12, 12, 12, 12};
        this.mass = this.defaultMass;
    }

    public Matrix(int[] userMatr) {
        this.defaultMass = new int[]{12, 12, 12, 12, 12};
        this.mass = userMatr;
    }

    public Matrix(Matrix other) {
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

}
