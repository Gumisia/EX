package ZAD_19_WykresFunkcji;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialFunction {

    String formula;
    int sizePoints;

    int powerMax;
    List<String> miniFormula;
    int[] coefficient;

    int[] tabX;
    int[] tabY;

    int xMin;
    int xMax;

    PolynomialFunction(String formula, int sizePoints, int xMin, int xMax){
        this.formula=formula;
        this.sizePoints=sizePoints;
        this.xMin = xMin;
        this.xMax = xMax;

        tabX = new int[sizePoints];
        tabY = new int[tabX.length];

        miniFormula = new ArrayList<>();

        findMaxPower(this.formula);//ustawia stopień wielomianu
        cutFormula(this.formula);//tnie wzór na części
        loadCoefficient();
        setTabX();
        calculatePints();
    }

    public void findMaxPower(String formula){
        String correctFormula = "[\\dx]*\\^*[\\d^x+\\-]*";
        String stringOnePow = "[\\dx]*[\\dx+\\-]*";
        String powerWithChar = "\\^\\d*";
        String onlyNumber = "\\d";

        Pattern patternCorrectFormula = Pattern.compile(correctFormula);
        Pattern patternOnePow = Pattern.compile(stringOnePow);
        Pattern patternPowerWithChar = Pattern.compile(powerWithChar);
        Pattern patternOnlyNumber = Pattern.compile(onlyNumber);

        Matcher matcherCorrectFormula = patternCorrectFormula.matcher(formula);
        Matcher matcherOnePow = patternOnePow.matcher(formula);
        Matcher matcherPowerWithChar = patternPowerWithChar.matcher(formula);
        Matcher matcherOnlyNumber;

        if(matcherCorrectFormula.matches()) {
            if (matcherPowerWithChar.find()) {
                String cutString = formula.substring(matcherPowerWithChar.start(), matcherPowerWithChar.end());
                matcherOnlyNumber = patternOnlyNumber.matcher(cutString);
                if (matcherOnlyNumber.find()) {
                    powerMax = Integer.valueOf(cutString.substring(matcherOnlyNumber.start()));
                }

            } else if (matcherOnePow.matches()) {
                powerMax = 1;
            }
        }else System.out.println(formula + " invalid");

//        System.out.println("PowerMax = "+powerMax);
    }

    public void cutFormula(String formula){

        String formulaTmp = formula;
        char[] chars = formulaTmp.toCharArray();

        for(int i=0; i<chars.length; i++){
            if(chars[i]=='-' || chars[i]=='+'){
                miniFormula.add(formulaTmp.substring(0, i));
                formulaTmp = formulaTmp.substring(i);
                i=0;
                chars = formulaTmp.toCharArray();
            }
        }
        miniFormula.add(String.valueOf(chars));
//        System.out.println(miniFormula);
    }

    public void loadCoefficient(){
        coefficient = new int[powerMax+1];
        String xWithPower = "\\d*?x\\^";
        String charNumber = "\\p{Punct}*\\d*";
        String withoutPower = "\\p{Punct}*\\d*x";
        String cutNumber = "\\p{Punct}*?\\d";

        String numberX = "\\p{Punct}*?\\dx\\p{Punct}\\d";

        Pattern patternXWithPower = Pattern.compile(xWithPower);
        Pattern patternCharNumber = Pattern.compile(charNumber);
        Pattern patternWithoutPower = Pattern.compile(withoutPower);
        Pattern patternCutNumber = Pattern.compile(cutNumber);

        Pattern patternNumberX = Pattern.compile(numberX);

        Matcher matcherXWithPower;
        Matcher matcherCharNumber;
        Matcher matcherWithoutPower;
        Matcher matcherCutNumber;

        Matcher matcherNumberX;

        String tmp;

        for(String oneMiniFormula: miniFormula){
            matcherCharNumber = patternCharNumber.matcher(oneMiniFormula);
            matcherXWithPower = patternXWithPower.matcher(oneMiniFormula);
            matcherWithoutPower = patternWithoutPower.matcher(oneMiniFormula);

            if(matcherCharNumber.matches()){
                tmp = "0";
                matcherCutNumber = patternCutNumber.matcher(oneMiniFormula);
                if(matcherCutNumber.matches()){
                    coefficient[Integer.valueOf(tmp)] = Integer.valueOf(oneMiniFormula);
                }
            } else if (matcherXWithPower.find()) {
                    tmp = oneMiniFormula.substring(matcherXWithPower.end());
                    matcherNumberX = patternNumberX.matcher(oneMiniFormula);

                    if(matcherNumberX.find()){
                        String[] stringtmp = oneMiniFormula.split("x");
                        coefficient[Integer.valueOf(tmp)] = Integer.valueOf(stringtmp[0]);
                    }
                    else{
                        if(oneMiniFormula.charAt(0)=='-')
                            coefficient[Integer.valueOf(tmp)] = -1;
                        if(oneMiniFormula.charAt(0)=='+')
                            coefficient[Integer.valueOf(tmp)] = 1;
                    }

            } else if(oneMiniFormula.equals("-x")){
                coefficient[1]=-1;
            } else if(oneMiniFormula.equals("+x") || oneMiniFormula.equals("x")){
                coefficient[1]=1;
            } else if(matcherWithoutPower.matches()){
                coefficient[1] = Integer.valueOf(oneMiniFormula.substring(0,oneMiniFormula.length()-1));
            }
        }
    }

    public void calculatePints(){

        for(int i=0; i<sizePoints; i++){
            tabY[i] = (int)hornerCalculateY(tabX[i]);
//            System.out.println("x="+tabX[i]+" y="+tabY[i]);
        }
    }

    public double hornerCalculateY(int x){
        double y = coefficient[coefficient.length-1];
//        System.out.println("coefficient.length-1="+(coefficient.length-1));
        for(int i=coefficient.length-2; i>=0; i--){
            y=(y*x)+coefficient[i];
        }
        return y*(-1);
    }

    public void setTabX() {
        double distance = ((xMin*(-1))+xMax)/(double)sizePoints;
        tabX[0]=xMin;
        double tmp = xMin;
        for(int i=1; i<sizePoints; i++){
            tmp = tmp+distance;
            tabX[i]=(int)tmp;
        }
    }

    public int[] getTabX() {
        return tabX;
    }

    public int[] getTabY() {
        return tabY;
    }
}
