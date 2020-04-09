import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void anagram_simple() {
        assertThat(Anagram.makeAnagram("a", "a")).isEqualTo(0);
    }

    @Test
    public void anagram_simple_2() {
        assertThat(Anagram.makeAnagram("a", "b")).isEqualTo(2);
    }

    @Test
    public void anagram_complex_1() {
        assertThat(Anagram.makeAnagram("abcaaccccxzf", "zioaac")).isEqualTo(10);
    }

    @Test
    public void anagram_complex_2() {
        assertThat(Anagram.makeAnagram("dabalearrozalazorraelabad", "elabaddabalearrozalazorra")).isEqualTo(0);
    }

    @Test
    public void anagram_complex_3() {
        assertThat(Anagram.makeAnagram("thisisatestsentence", "histestistense")).isEqualTo(5);
    }
}