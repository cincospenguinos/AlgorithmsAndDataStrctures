package usa.cincospenguinos.main.structures.stack;

import java.lang.reflect.InvocationTargetException;

class StackEvaluation<C extends Stack<Integer>> {
    private Class<C> evaluatedClass;

    StackEvaluation(Class<C> classToEvaluate) {
        evaluatedClass = classToEvaluate;
    }

    long evaluateAddOperation(int totalTrials, boolean clearStack) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Stack<Integer> evaluatedStack = evaluatedClass.getConstructor().newInstance();
        long totalIndividaulAddOpTime = 0;

        for (int trial = 1; trial <= totalTrials; trial++) {
            int totalElements = 1000;

            Operation operation = () -> {
                for (int i = 0; i < totalElements; i++) evaluatedStack.push(i);
            };
            Operation control = () -> { for(int i = 0; i < totalElements; i++); };

            long individualOperationTime = timeOperation(operation, control) / totalElements;
            totalIndividaulAddOpTime += individualOperationTime;

            if (clearStack) {
                evaluatedStack.clear();
            }
        }

        return totalIndividaulAddOpTime / totalTrials;
    }

    long evaluateAddingElements(int totalTrials, int totalElements) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Stack<Integer> evaluatedStack = evaluatedClass.getConstructor().newInstance();
        long totalIndividaulAddOpTime = 0;

        for (int trial = 1; trial <= totalTrials; trial++) {
            Operation operation = () -> {
                for (int i = 0; i < totalElements; i++) evaluatedStack.push(i);
            };
            Operation control = () -> { for(int i = 0; i < totalElements; i++); };

            long individualOperationTime = timeOperation(operation, control) / totalElements;
            totalIndividaulAddOpTime += individualOperationTime;

            evaluatedStack.clear();
        }

        return totalIndividaulAddOpTime / totalTrials;
    }

    private long timeOperation(Operation operation, Operation control) {
        long operationStart = System.nanoTime();
        operation.run();
        long operationEnd = System.nanoTime();

        long controlStart = System.nanoTime();
        control.run();
        long controlEnd = System.nanoTime();

        return (operationEnd - operationStart) - (controlEnd - controlStart);
    }

    private interface Operation {
        void run();
    }
}
