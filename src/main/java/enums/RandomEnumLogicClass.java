package enums;

import java.security.SecureRandom;

public class RandomEnumLogicClass {
    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T randomEnum(Class<T> tClass){
    int x = random.nextInt(tClass.getEnumConstants().length);
    return tClass.getEnumConstants()[x];
}

}
