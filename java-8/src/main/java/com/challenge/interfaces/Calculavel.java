package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

    public BigDecimal somar(Object cl) throws IllegalAccessException;

    public BigDecimal subtrair(Object cl) throws IllegalAccessException;

    public BigDecimal totalizar(Object cl) throws IllegalAccessException;

}
