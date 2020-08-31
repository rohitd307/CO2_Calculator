package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        Emission em = new Emission();
        Arguments arg = em.splitArguments(args);
        em.checkUnits(arg);
        double emissionRate = em.fetchEmissionRate(arg.getTransportationMethod());
        double result = em.calculateEmission(emissionRate ,arg);
        em.displayResult(result, arg.getOutputUnit());
    }
}
