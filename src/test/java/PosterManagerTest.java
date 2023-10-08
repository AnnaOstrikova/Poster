import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    PosterManager manager = new PosterManager();

    @BeforeEach
            public void setup() {
        manager.add("Forward");
        manager.add("Hotel Belgrade");
        manager.add("Gentlemen");
        }

    @Test
    public void addMovies() {
        String[] expected = {"Forward", "Hotel Belgrade", "Gentlemen"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReversMoviesLessLimit(){
        String[] expected = {"Gentlemen", "Hotel Belgrade", "Forward"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReversMoviesAboveLimit(){
        manager.add("Invisible Man");
        manager.add("Trolls");
        manager.add("Number one");
        String[] expected = {"Number one", "Trolls", "Invisible Man", "Gentlemen", "Hotel Belgrade"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReversMoviesLimit(){
        manager.add("Invisible Man");
        manager.add("Trolls");
        String[] expected = {"Trolls", "Invisible Man", "Gentlemen", "Hotel Belgrade", "Forward"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}