package org.example;

import java.util.Arrays;

public class Emission {

    public Arguments splitArguments(String[] args) {
        String argument = Arrays.toString(args);
        argument = argument.substring(1, argument.length() - 1).replace(",", "");
        String[] arguments = argument.split("--");
        Arguments arg = new Arguments();

        for (int i = 1; i < arguments.length; i++) {
            arguments[i] = arguments[i].replace("=", " ");
            String[] nameValue = arguments[i].split(" ");
            determineArguments(nameValue, arg);
        }
        return arg;
    }

    public void checkUnits(Arguments arg) {
        if (arg.getDistanceUnit() == null)
            arg.setDistanceUnit("km");
        if (arg.getOutputUnit() == null)
            arg.setOutputUnit(determineOutputUnit(arg));
    }

    public void determineArguments(String[] nameValue, Arguments arg) {
        String argumentName = nameValue[0];
        String argumentValue = nameValue[1];

        switch (argumentName) {
            case "transportation-method":
                arg.setTransportationMethod(argumentValue);
                break;
            case "distance":
                arg.setDistance(Double.parseDouble(argumentValue));
                break;
            case "unit-of-distance":
                arg.setDistanceUnit(argumentValue);
                break;
            case "output":
                arg.setOutputUnit(argumentValue);
                break;
            default:
                System.out.println("Invalid Argument");
        }
    }

    public String determineOutputUnit(Arguments arg) {
        if (arg.getDistanceUnit().equals("km"))
            arg.setOutputUnit("kg");
        else if (arg.getDistanceUnit().equals("m"))
            arg.setOutputUnit("kg");

        return arg.getOutputUnit();
    }

    public double fetchEmissionRate(String transportationMethod) {
        System.out.println(transportationMethod);
        switch (transportationMethod) {
            case "small-diesel-car":
                return 142.0;
            case "small-petrol-car":
                return 154.0;
            case "small-plugin-hybrid-car":
                return 73.0;
            case "small-electric-car":
                return 50.0;
            case "medium-diesel-car":
                return 171.0;
            case "medium-petrol-car":
                return 192.0;
            case "medium-plugin-hybrid-car":
                return 110.0;
            case "medium-electric-car":
                return 58.0;
            case "large-diesel-car":
                return 209.0;
            case "large-petrol-car":
                return 282.0;
            case "large-plugin-hybrid-car":
                return 126.0;
            case "large-electric-car":
                return 73.0;
            case "bus":
                return 27.0;
            case "train":
                return 6.0;
            default:
                return 0.0;
        }
    }

    public double calculateEmission(double rate, Arguments arg) {
        double result;

        if (arg.getDistanceUnit().equals("m"))
            result = (rate / 1000) * arg.getDistance();
        else
            result = rate * arg.getDistance();

        if (arg.getOutputUnit().equals("kg"))
            result = result / 1000;
        result = Math.round(result * 10) / 10.0;

        return result;
    }

    public void displayResult(double result, String outputUnit) {
        System.out.println("Your trip caused " + result + outputUnit + " of CO2-equivalent.");
    }
}
