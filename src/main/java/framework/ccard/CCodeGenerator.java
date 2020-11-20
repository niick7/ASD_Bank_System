package framework.ccard;

import framework.Common.AccNumGenerator;

import java.util.Random;

public class CCodeGenerator implements AccNumGenerator {
    private CCodeGenerator() {
    }
    private final static CCodeGenerator ccAccountGeneratorInstance = new CCodeGenerator();
    public static CCodeGenerator myAccountGenerator(){
        return ccAccountGeneratorInstance;
    }

    @Override
    public String generateCode() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
