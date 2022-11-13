public class Text {
    private String text;
    private String[] words;

    public Text() {
        this.text = "Hello, world! Hello, Ann.";
        this.words = this.text.split("\\W+");
    }

    public Text(String text) {
        this.text = text;
        this.words = this.text.split("\\W+");
    }

    public Text(Text other) {
        this(other.getText());
    }

    private String getText() {
        return this.text;
    }

    public int numberSentences() {
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

    public String popularWord() {
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

    public void vowelOrConsonant() {
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

        System.out.println("Количество слов с согласной = " + conInt + "\nКоличество слов с гласной = " + vowInt);
    }


}
