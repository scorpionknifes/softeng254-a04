package se254.a4.t1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * SE254 Assignment 4 Task 1 Reflector - Instructions
 * 
 * This class should be implemented to contain the reflection functionality
 * described in the assignment hand-out. This class must be called by T1Main for
 * executing the desired reflection for a given class e.g. class Counter. * All
 * changes required for Task 1 must be performed on a new branch named
 * "T1Branch". You can create this new branch from our IDE.
 * 
 * @author Author Name: Cheng-Zhen Yang Author UPI: cyan562
 * @version Date: 29/10/2020
 */

public class Reflector {
    private Object _object;
    private Class<?> _class;

    public Reflector(String classname) throws ClassNotFoundException {
        _class = Class.forName(classname);

        try {
            Constructor<?> constructor = _class.getConstructor();
            _object = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    public List<String> getPublicField() {
        List<String> fields = new ArrayList<String>();

        for (Field f : _class.getDeclaredFields()) {
            try {
                if (Modifier.isPublic(f.getModifiers())) {
                    fields.add(f.getName() + ": " + f.get(_object));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fields;
    }

    public List<String> getPublicMethod() {
        List<String> methods = new ArrayList<String>();

        for (Method m : _class.getDeclaredMethods()) {
            try {
                if (m.getParameterTypes().length == 0 && Modifier.isPublic(m.getModifiers())) {
                    methods.add(m.getName() + "()");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return methods;
    }

    public void executeMethod(String method) throws Exception {
        _class.getMethod(method).invoke(_object);
    }
}
