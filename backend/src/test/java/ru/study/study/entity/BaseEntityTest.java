package ru.study.study.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseEntityTest {


    @BeforeAll
    protected void initTest() throws Exception {
        checkLongConstructor();
    }


    protected void checkLongConstructor() throws ClassNotFoundException {
        Class<?> clazz = Class.forName(this.getClass().getName().replace("Test", ""));

        Constructor<?> longConstructor = null;
        try {
            longConstructor = clazz.getDeclaredConstructor(Long.class);
        } catch (NoSuchMethodException e) {
           longConstructor = null;
        }
        assertNotNull(longConstructor, "There is no constructor Long parameter in class " + clazz.getName());
    }

    protected void checkCountFields(int countFields) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(this.getClass().getName().replace("Test", ""));
        assertEquals(countFields, getAllClassFields(clazz).size(), String.format("Number of fields in class %s changed.", clazz.getSimpleName()));
    }


    private List<Field> getAllClassFields(Class<?> clazz){

        var fields = new LinkedList<Field>();
        var isSuperClass = new AtomicBoolean(false);

        while (clazz.getSuperclass() != null){
            fields.addAll(Arrays.stream(clazz.getDeclaredFields())
                    .filter(field -> !isSuperClass.get()|| (Modifier.isPublic(field.getModifiers()) || Modifier.isProtected(field.getModifiers())))
                    .filter(field -> !Modifier.isStatic(field.getModifiers()))
                    .toList()
            );

            clazz = clazz.getSuperclass();
            isSuperClass.set(true);
        }
        return fields;
    }
}
