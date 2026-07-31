package com.example.demo.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DynamicCaller {
    public static void executeDynamically(Class clazz) {
        List<Method> callableMethods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> Modifier.isStatic(m.getModifiers()))
                .filter(m -> m.getName().startsWith("do"))
                .sorted(Comparator.comparing(Method::getName))
                .toList();

        for (int i = 0; i < callableMethods.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + callableMethods.get(i).getName());
        }
        System.out.print("Pick method:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Method pickedMethod = callableMethods.get(choice - 1);

        System.out.println("Picked '" + pickedMethod.getName() + "'");
        try {
            pickedMethod.setAccessible(true);
            pickedMethod.invoke(null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
