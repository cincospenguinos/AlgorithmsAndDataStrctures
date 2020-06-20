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
    public void time_addOperation() {
        int trials = 30000;

        System.out.println("*** ADD OPERATION ***");
        System.out.println("Stack\tClear Between\tNo Clear Between");
        try {
            for (Class<? extends AbstractStack> classToEvaluate : CLASSES) {
                StackEvaluation evaluation = new StackEvaluation(classToEvaluate);
                String className = classToEvaluate.toString().replaceAll("class usa\\.cincospenguinos\\.main\\.structures\\.stack\\.", "");

                long clearAfterEach = evaluation.evaluateAddOperation(trials, true);
                long noClearAfterEach = evaluation.evaluateAddOperation(trials, false);
                System.out.println(className + "\t" + clearAfterEach + "\t" + noClearAfterEach);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            fail();
        }
    }
}