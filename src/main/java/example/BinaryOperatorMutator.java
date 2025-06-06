package example;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtLocalVariableReference;

public class BinaryOperatorMutator extends AbstractProcessor<CtElement> {

    private static int counter = 0;
    @Override
    public boolean isToBeProcessed(CtElement candidate) {
        return true;
    }

    @Override
    public void process(CtElement candidate) {
        if ((candidate instanceof CtLocalVariable<?>)) {
//            System.out.println("Processing: " + candidate.prettyprint());
            if (((CtLocalVariable<?>) candidate).getSimpleName().equals("i")) {
                ((CtLocalVariable<?>) candidate).setSimpleName("interestingVariable");
            }
        } else if ((candidate instanceof CtLocalVariableReference<?>)) {
            if (((CtLocalVariableReference<?>) candidate).getSimpleName().equals("i")) {
                ((CtLocalVariableReference<?>) candidate).setSimpleName("interestingVariable");
            }
        }
//        CtBinaryOperator op = (CtBinaryOperator)candidate;
//        op.setKind(BinaryOperatorKind.GT);
    }
}
