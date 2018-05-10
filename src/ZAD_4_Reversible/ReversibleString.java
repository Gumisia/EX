package ZAD_4_Reversible;


public class ReversibleString implements Reversible {

    private String text;

    ReversibleString(String text){
        this.text=text;
    }

    public Reversible reverse(){


        char[] tabOfChars = text.toCharArray();

        for(int i=0; i<text.length(); i++){
            if(Character.isLowerCase(tabOfChars[i])) tabOfChars[i] = (char)(tabOfChars[i]-32);
            else
                if(Character.isLetter(tabOfChars[i])) tabOfChars[i] = (char)(tabOfChars[i]+32);
        }

        text = new String(tabOfChars);

        return this;
        }

        public Reversible zmiana(){

            reverse();

            char[] tabOfChars = text.toCharArray();

            text = "Tekst " + (new String(tabOfChars));

            return this;

        }

    @Override
    public String toString() {
        return " " + text;
        }
    }



