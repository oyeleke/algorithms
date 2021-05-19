package elements_of_programming_interviews;

public class ConvertBase {

    public static String convertBase(String numAsString, int b1, int b2){
        boolean isNegative = numAsString.startsWith("-");
        int result = 0;
        for (int i = (isNegative ? 1 : 0); i < numAsString.length(); i++){

            result *= b1;
            result += Character.isDigit(numAsString.charAt(i)) ?
                     numAsString.charAt(i)
                    : numAsString.charAt(i) - 'A' + 10;
        }
        System.out.println("result decimal "+ result);
        return (isNegative ? "-" : "") + (result == 0 ? "0" : constructFromBase(result, b2));
    }

    private static String constructFromBase(int numAsInt, int base){
        return numAsInt == 0 ?
                "" :
                constructFromBase(numAsInt / base, base) +
                        (char)((numAsInt % base) >= 10 ?
                                'A' + numAsInt%base - 10 :
                                '0' + numAsInt % base
                                );
    }

    public static void main(String [] args){
        System.out.print(convertBase("615", 7, 13));
    }
}
