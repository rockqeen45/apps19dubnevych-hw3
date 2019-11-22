package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator<Integer> cmp = new MyComparator<Integer>() {
            @Override
            public int compare(Integer fst, Integer snd) {
                return fst - snd;
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student s = (Student) t;
                return s.getYear() == 2 && s.getGPA() >= 4;
            }
        };

        MyComparator<Student> cmp = new MyComparator<Student>() {
            @Override
            public int compare(Student fst, Student snd) {
                return fst.getSurname().compareTo(snd.getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student stud = (Student) t;
                return stud.getSurname() + " " + stud.getName();
            }
        };

        SmartArray stdArray = new BaseArray(students);
        stdArray = new DistinctDecorator(stdArray);
        stdArray = new FilterDecorator(stdArray, pr);
        stdArray = new SortDecorator(stdArray, cmp);
        stdArray = new MapDecorator(stdArray, func);

        Object[] result = stdArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
