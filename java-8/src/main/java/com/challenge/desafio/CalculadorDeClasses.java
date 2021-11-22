package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object cl) throws IllegalAccessException {
        Field[] fields = cl.getClass().getDeclaredFields();
        BigDecimal result = BigDecimal.ZERO;
        for (Field field: fields) {
            field.setAccessible(true);
            if (field.getType() == BigDecimal.class
                    && field.getDeclaredAnnotation(Somar.class) != null) {
                BigDecimal toSum = new BigDecimal(field.get(cl).toString());
                result = result.add(toSum);
            }
        }
        return result;
    }

    @Override
    public BigDecimal subtrair(Object cl) throws IllegalAccessException {
        Field[] fields = cl.getClass().getDeclaredFields();
        BigDecimal result = BigDecimal.ZERO;
        for (Field field: fields) {
            field.setAccessible(true);
            if (field.getType().equals(BigDecimal.class)
                    && field.getDeclaredAnnotation(Subtrair.class) != null) {
                BigDecimal toSum = new BigDecimal(field.get(cl).toString());
                result = result.add(toSum);
            }
        }
        return result;
    }

    @Override
    public BigDecimal totalizar(Object cl) throws IllegalAccessException {
        BigDecimal sum = somar(cl);
        BigDecimal sub = subtrair(cl);
        return sum.subtract(sub);
    }
}
