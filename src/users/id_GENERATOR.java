package users;

import java.util.Random;

public class id_GENERATOR {

    static String generate(String name){
        Random random = new Random();

        int len = name.length();

        name = name.toUpperCase();

        char first = name.charAt(random.nextInt(len));
        char second = name.charAt(random.nextInt(len));

        return "" + first + second + random.nextInt(100, 999);
    }


}
