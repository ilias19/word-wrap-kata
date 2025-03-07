package fr.kata;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static fr.kata.WorldWrapper.wrap;
import static org.assertj.core.api.Assertions.assertThat;

class WorldWrapperTest {

    @Test
    void shouldNotWrapWithoutSentence() {
        assertThat(wrap(null, 4)).isNull();
    }

    @Test
    void shouldNotWrapShortEnoughSentence() {
        assertThat(wrap("Once", 4)).isEqualTo("Once");
    }

    @Test
    void shouldWrapBySplittingWord() {
        assertThat(wrap("Once", 2)).isEqualTo("On\nce");
    }

    @Test
    void shouldWrapBySplittingWordMultipleItems() {
        assertThat(wrap("Once", 1)).isEqualTo(join("O", "n", "c", "e"));
    }

    @Test
    void shouldWrapAfterWord() {
        assertThat(wrap("Once upon a time", 9)).isEqualTo(join("Once upon", "a time"));
    }

    @Test
    void shouldWrapBetweenWords() {
        assertThat(wrap("Once upon a time in Hollywood", 13)).isEqualTo(join("Once upon a", "time in", "Hollywood"));
    }

    private static String join(String... parts) {
        return Arrays.stream(parts).collect(Collectors.joining("\n"));
    }

}