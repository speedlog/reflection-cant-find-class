package pl.speedlog.example.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import pl.speedlog.example.reflection.domain1.UsecaseA;
import pl.speedlog.example.reflection.domain1.UsecaseB;
import pl.speedlog.example.reflection.domain2.UsecaseC;
import pl.speedlog.example.reflection.domain2.UsecaseD;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:mariusz@wyszomierski.pl">mariusz@wyszomierski.pl</a>
 */
class SearchUsecaseTest {

    @Test
    void searchUsecaseClasses() {
        Reflections reflections = new Reflections("pl.speedlog.example.reflection");
        Set<Class<? extends AbstractUsecase>> classes = reflections.getSubTypesOf(AbstractUsecase.class);

        Set<Class<? extends  AbstractUsecase>> expectedList = new HashSet<>();
        expectedList.add(UsecaseA.class);
        expectedList.add(UsecaseB.class);
        expectedList.add(UsecaseC.class);
        expectedList.add(UsecaseD.class);
        Assertions.assertEquals(expectedList, classes);

    }

}