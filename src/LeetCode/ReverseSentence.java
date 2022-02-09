package LeetCode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ReverseSentence {

    public static String reverseWords(String s) {
        List<String> words = Arrays.stream(s.split("\\s{1,}"))
                .map(String::trim)
                .filter(i -> !i.isEmpty())
                .collect(Collectors.toList());
        System.out.println(words);
        Collections.reverse(words);
        return String.join(" ", words);
    }

    @Test
    public void test(){
        //assertEquals("", reverseWords(""));
        assertEquals("blue is sky the", reverseWords("the sky is blue"));
        assertEquals("world hello", reverseWords("  hello world  "));
        assertEquals("example good a", reverseWords("a good   example"));
        assertEquals("Alice Loves Bob", reverseWords("  Bob    Loves  Alice   "));
        assertEquals("bob like even not does Alice", reverseWords("Alice does not even like bob"));
    }

}
