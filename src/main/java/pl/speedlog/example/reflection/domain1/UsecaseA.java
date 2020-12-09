package pl.speedlog.example.reflection.domain1;

import pl.speedlog.example.reflection.AbstractUsecase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mariusz@wyszomierski.pl">mariusz@wyszomierski.pl</a>
 */
public class UsecaseA extends AbstractUsecase {

    @Override
    protected List<String> execute() {
        List<String> array = new ArrayList<>();
        array.add("a");
        array.add("aa");
        return array;
    }
}
