package usa.cincospenguinos.main.structures.stack;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.fail;

/**
 * This test class exists for the sole purpose of testing the performance of implementations
 * of a stack.
 */
public class AbstractStackTest {
    private static final Class<? extends AbstractStack>[] CLASSES = new Class[]{
            new ArrayStack<Integer>().getClass(),
            new LinkedStack<>().getClass(),
            new BlendedStack<>().getClass()
    };

    /**
     * Time the add operation. Evaluates adding 1000 elements to a stack both when clearing between each
     * operation, but also when adding just a ton of elements.
     */
    @Test
    public void time_addOperationGeneral() {
        int trials = 1000;

        System.out.println("*** ADD OPERATION ***");
        System.out.println("Stack\tClear Between\tNo Clear Between");
        try {
            for (Class<? extends AbstractStack> classToEvaluate : CLASSES) {
                StackEvaluation evaluation = new StackEvaluation(classToEvaluate);
                String className = className(classToEvaluate);

                long clearAfterEach = evaluation.evaluateAddOperation(trials, true);
                long noClearAfterEach = evaluation.evaluateAddOperation(trials, false);
                System.out.println(className + "\t" + clearAfterEach + "\t" + noClearAfterEach);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Find the time to add the number of elements listed. Used to explore stack size benefits for each of
     * the different stack types.
     */
    @Test
    public void time_idealElementSizeForEach() {
        int trials = 10;

        System.out.println("*** ADDING ELEMENTS ***");
        System.out.println("Stack\t100\t1000\t10000\t100000\t1000000\t10000000");

        try {
            int[] sizes = { 100, 1000, 10000, 100000, 1000000, 10000000 };

            for (Class<? extends AbstractStack> classToEvaluate : CLASSES) {
                StackEvaluation evaluation = new StackEvaluation(classToEvaluate);
                String className = className(classToEvaluate);

                StringBuilder builder = new StringBuilder();
                builder.append(className);
                builder.append('\t');

                for (int size : sizes) {
                    long time = evaluation.evaluateAddingElements(trials, size);
                    builder.append(time);
                    builder.append('\t');
                }

                System.out.println(builder.toString().trim());
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            fail();
        }
    }

    private String className(Class<? extends AbstractStack> klass) {
        return klass.toString().replaceAll("class usa\\.cincospenguinos\\.main\\.structures\\.stack\\.", "");
    }
}