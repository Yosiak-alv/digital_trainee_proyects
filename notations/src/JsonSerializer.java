import annotations.Init;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializer {
    public static void initObject(Object object) {
        if(Objects.isNull(object)) {
            throw new JsonSerializerException("Object is null");
        }
        Method[] methods = object.getClass().getDeclaredMethods();

        Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Init.class))
                .forEach(method -> {
                    method.setAccessible(true);
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializerException("Error initializing object: " + e.getMessage());
                    }
                });

        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new JsonSerializerException("Error initializing object: " + e.getMessage());
                }
            }
        }
    }

    public static String serializeToJson(Object object) {
        if(Objects.isNull(object)) {
            throw new JsonSerializerException("Object is null");
        }
        initObject(object);
        Field[] fields = object.getClass().getDeclaredFields();

        return Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(annotations.JsonAtributo.class))
                .map(field -> {
                    field.setAccessible(true);
                    annotations.JsonAtributo annotation = field.getAnnotation(annotations.JsonAtributo.class);
                    String name = annotation.name().isEmpty() ? field.getName() : annotation.name();
                    try {
                        Object value = field.get(object);

                        if (annotation.capitalize()) {
                            String newValue = (String) value;
                            newValue = Arrays.stream(newValue.split(" "))
                                    .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                                    .collect(Collectors.joining(" "));

                            field.set(object, newValue);
                        }
                        return "\"" + name + "\": \"" + field.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializerException("Error serializing object: " + e.getMessage());
                    }

                })
                .reduce((s1, s2) -> s1 + ", " + s2)
                .map(s -> "{" + s + "}")
                .orElse("{}");
    }
}
