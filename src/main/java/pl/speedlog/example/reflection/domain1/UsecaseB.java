package pl.speedlog.example.reflection.domain1;

import pl.speedlog.example.reflection.AbstractUsecase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mariusz@wyszomierski.pl">mariusz@wyszomierski.pl</a>
 */
public class UsecaseB extends AbstractUsecase {

    @Override
    protected List<String> execute() {
        List<String> array = new ArrayList<>();
        array.add("b");
        array.add("bb");
        return array.stream()
                .filter(text -> !text.equals("bb"))
                .collect(Collectors.toList());
    }
}
