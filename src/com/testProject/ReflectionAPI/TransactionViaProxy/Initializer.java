package com.testProject.ReflectionAPI.TransactionViaProxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Initializer {
    public static void init() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                Initializer.class.getName()
                        .replace(Initializer.class.getSimpleName(),"")
                        .replaceAll("[.]", File.separator);

        File users = new File(path + "users.txt");
        File goods = new File(path + "goods.txt");

        try (BufferedWriter bwUsers =
                     new BufferedWriter(
                             new FileWriter(users)
                     );
             BufferedWriter bwGoods =
                     new BufferedWriter(
                             new FileWriter(goods)
                     )
        ) {

            for (int i = 1; i <= 10; i++) {
                bwUsers.write("User#" + i + " ");
                bwUsers.newLine();
            }
            Random random = new Random(47);
            for (int i = 1; i <= 8; i++) {
                bwGoods.write("Good#" + i + " " + random.nextInt(30)+"   ");
                bwGoods.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        init();
    }
}
