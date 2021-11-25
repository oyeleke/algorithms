package codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SpinWords {

    public String spinWords(String sentence) {
        if (sentence.isEmpty()){
            return sentence;
        }

        String [] sentenceArray = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : sentenceArray){
            if (word.length() >= 5){
                String reverseWords = reverseWords(word);
                System.out.println(reverseWords);
                sb.append(reverseWords);
                sb.append(" ");
            } else {
                sb.append(word);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public String reverseWords(String wordToReverse){
        StringBuilder sb = new StringBuilder();
        for (char c: wordToReverse.toCharArray()){
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    public String spinWord(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
    }

    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }
}
