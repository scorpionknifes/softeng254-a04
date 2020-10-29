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

    /**
     * Constructs a Reflector object that includes the object from the given
     * qualified classname from param. Throw ClassNotFoundException if classname is
     * not found.
     * 
     * @param classname
     * @throws ClassNotFoundException
     */
    public Reflector(String classname) throws ClassNotFoundException {
        _class = Class.forName(classname);

        try {
            Constructor<?> constructor = _class.getConstructor();
            _object = constructor.newInstance();
        } catch (Exception e) {
            // Assume no empty constructor is a class that doesn't exist.
            throw new ClassNotFoundException();
        }
    }

    /**
     * Used to get a list of public fields with their values in the format:
     * FIELD_NAME: FIELD_VALUE. From the object created by constructor.
     * 
     * @return fields
     */
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

    /**
     * Used to get a list of public declared methods with no params and their values
     * in the format: METHOD_NAME(). From the class defined by constructor.
     * 
     * @return methods
     */
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

    /**
     * Used to execute a method by method name on the created object by constructor.
     * Throws an exception if an error has occured, assume all error is bad method
     * as method doesn't have params.
     * 
     * @param method
     * @throws Exception
     */
    public void executeMethod(String method) throws Exception {
        _class.getMethod(method).invoke(_object);
    }
}
