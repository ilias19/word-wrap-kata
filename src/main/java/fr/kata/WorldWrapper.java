package fr.kata;

public class WorldWrapper {

    private static final String SPACE = " ";
    private static final String BREAK = "\n";
    private int columns;

    private WorldWrapper(int columns) {
        this.columns = columns;
    }

    public static String wrap(String sentence, int columns) {
        return new WorldWrapper(columns).wrap(sentence);
    }

    private String wrap(String sentence) {
        if (isShortEnough(sentence)) {
            return sentence;
        }

        String left = sentence.substring(0, columns);
        String right = sentence.substring(columns);

        if (right.startsWith(SPACE)) {
            return join(left, right.substring(1, right.length()));
        }

        int spaceIndex = left.lastIndexOf(SPACE);
        if (spaceIndex != -1) {
            return join(sentence.substring(0, spaceIndex), sentence.substring(spaceIndex + 1));
        }

        return join(left, right);
    }

    private boolean isShortEnough(String sentence) {
        return sentence == null || sentence.length() <= columns;
    }

    private String join(String left, String right) {
        return left + BREAK + wrap(right, columns);
    }
}
