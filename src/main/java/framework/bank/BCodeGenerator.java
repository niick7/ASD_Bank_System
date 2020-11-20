package framework.bank;

import framework.Common.AccNumGenerator;

import java.util.Random;

public class BCodeGenerator implements AccNumGenerator {

    private BCodeGenerator() {
    }
    private final static BCodeGenerator bAccountGeneratorInstance = new BCodeGenerator();
    public static BCodeGenerator myAccountGenerator(){
        return bAccountGeneratorInstance;
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
