package pl.speedlog.example.reflection.domain2;

import pl.speedlog.example.reflection.AbstractUsecase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mariusz@wyszomierski.pl">mariusz@wyszomierski.pl</a>
 */
public class UsecaseD extends AbstractUsecase {

    @Override
    protected List<String> execute() {
        List<String> array = new ArrayList<>();
        array.add("d");
        array.add("dd");
        return array.stream()
                .filter(text -> !text.equals("dd"))
                .collect(Collectors.toList());
    }
}
