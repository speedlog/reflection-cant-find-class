package pl.speedlog.example.reflection.domain2;

import pl.speedlog.example.reflection.AbstractUsecase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mariusz@wyszomierski.pl">mariusz@wyszomierski.pl</a>
 */
public class UsecaseC extends AbstractUsecase {

    @Override
    protected List<String> execute() {
        List<String> array = new ArrayList<>();
        array.add("c");
        array.add("cc");
        return array;
    }
}
