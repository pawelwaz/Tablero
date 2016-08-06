package com.example.pawel.tablero;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by pawel on 2016-02-15.
 */
public class Converter {
    private static int maxDigits;

    public Converter(int nonZeroDigits) {
        maxDigits = nonZeroDigits;
    }

    public static String round(String input) {
        int dot = input.indexOf('.');
        if(dot != -1 && input.substring(dot).length() > maxDigits) {
            BigDecimal tmp = new BigDecimal(input.substring(0, dot + maxDigits + 1));
            //char nextDigit = input.charAt(dot + maxDigits + 1);

            input = tmp.toPlainString();
        }
        return input;
    }

    public static BigDecimal convertToOldTerabyte(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "1.136868377216160297393798828125e-13"; break; //bit
            case 1: factor = "9.094947017729282379150390625e-13"; break; //byte

            case 2: factor = "1.16415321826934814453125e-10"; break; //kilobit
            case 3: factor = "0.000000000931322574615478515625"; break; //kilobyte

            case 4: factor = "0.00000011920928955078125"; break; //megabit
            case 5: factor = "0.00000095367431640625"; break; //megabyte

            case 6: factor = "0.0001220703125"; break; //gigabit
            case 7: factor = "0.0009765625"; break; //gigabyte

            case 8: factor = "0.125"; break; //terabit
            case 9: factor = "1"; break; //terabyte

            case 10: factor = "128"; break; //petabit
            case 11: factor = "1024"; break; //petabyte

            case 12: factor = "131072"; break; //exabit
            case 13: factor = "1048576"; break; //exabyte

            case 14: factor = "134217728"; break; //zettabit
            case 15: factor = "1073741824"; break; //zettabyte

            case 16: factor = "137438953472"; break; //yottabit
            case 17: factor = "1099511627776"; break; //yottabyte
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromOldTerabyte(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "8796093022208"; break; //bit
            case 1: factor = "1099511627776"; break; //byte

            case 2: factor = "8589934592"; break; //kilobit
            case 3: factor = "1073741824"; break; //kilobyte

            case 4: factor = "8388608"; break; //megabit
            case 5: factor = "1048576"; break; //megabyte

            case 6: factor = "8192"; break; //gigabit
            case 7: factor = "1024"; break; //gigabyte

            case 8: factor = "8"; break; //terabit
            case 9: factor = "1"; break; //terabyte

            case 10: factor = "0.0078125"; break; //petabit
            case 11: factor = "0.0009765625"; break; //petabyte

            case 12: factor = "0.00000762939453125"; break; //exabit
            case 13: factor = "0.00000095367431640625"; break; //exabyte

            case 14: factor = "0.000000007450580596923828125"; break; //zettabit
            case 15: factor = "0.000000000931322574615478515625"; break; //zettabyte

            case 16: factor = "7.2759576141834259033203125e-12"; break; //yottabit
            case 17: factor = "9.094947017729282379150390625e-13"; break; //yottabyte
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToTebibyte(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "1.136868377216160297393798828125e-13"; break; //bit
            case 1: factor = "9.094947017729282379150390625e-13"; break; //byte

            case 2: factor = "1.136868377216160297393798828125e-10"; break; //kilobit
            case 3: factor = "9.094947017729282379150390625e-10"; break; //kilobyte
            case 4: factor = "1.16415321826934814453125e-10"; break; //kibibit
            case 5: factor = "0.000000000931322574615478515625"; break; //kibibyte

            case 6: factor = "1.136868377216160297393798828125e-7"; break; //megabit
            case 7: factor = "9.094947017729282379150390625e-7"; break; //megabyte
            case 8: factor = "0.00000011920928955078125"; break; //mebibit
            case 9: factor = "0.00000095367431640625"; break; //mebibyte

            case 10: factor = "1.136868377216160297393798828125e-4"; break; //gigabit
            case 11: factor = "0.0009094947017729282379150390625"; break; //gigabyte
            case 12: factor = "0.0001220703125"; break; //gibibit
            case 13: factor = "0.0009765625"; break; //gibibyte

            case 14: factor = "0.1136868377216160297393798828125"; break; //terabit
            case 15: factor = "0.9094947017729282379150390625"; break; //terabyte
            case 16: factor = "0.125"; break; //tebibit
            case 17: factor = "1"; break; //tebibyte

            case 18: factor = "113.6868377216160297393798828125"; break; //petabit
            case 19: factor = "909.4947017729282379150390625"; break; //petabyte
            case 20: factor = "128"; break; //pebibit
            case 21: factor = "1024"; break; //pebibyte

            case 22: factor = "113686.8377216160297393798828125"; break; //exabit
            case 23: factor = "909494.7017729282379150390625"; break; //exabyte
            case 24: factor = "131072"; break; //exbibit
            case 25: factor = "1048576"; break; //exbibyte

            case 26: factor = "113686837.7216160297393798828125"; break; //zettabit
            case 27: factor = "909494701.7729282379150390625"; break; //zettabyte
            case 28: factor = "134217728"; break; //zebibit
            case 29: factor = "1073741824"; break; //zebibyte

            case 30: factor = "113686837721.6160297393798828125"; break; //yottabit
            case 31: factor = "909494701772.9282379150390625"; break; //yottabyte
            case 32: factor = "137438953472"; break; //yobibit
            case 33: factor = "1099511627776"; break; //yobibyte
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromTebibyte(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "8796093022208"; break; //bit
            case 1: factor = "1099511627776"; break; //byte

            case 2: factor = "8796093022.208"; break; //kilobit
            case 3: factor = "1099511627.776"; break; //kilobyte
            case 4: factor = "8589934592"; break; //kibibit
            case 5: factor = "1073741824"; break; //kibibyte

            case 6: factor = "8796093.022208"; break; //megabit
            case 7: factor = "1099511.627776"; break; //megabyte
            case 8: factor = "8388608"; break; //mebibit
            case 9: factor = "1048576"; break; //mebibyte

            case 10: factor = "8796.093022208"; break; //gigabit
            case 11: factor = "1099.511627776"; break; //gigabyte
            case 12: factor = "8192"; break; //gibibit
            case 13: factor = "1024"; break; //gibibyte

            case 14: factor = "8.796093022208"; break; //terabit
            case 15: factor = "1.099511627776"; break; //terabyte
            case 16: factor = "8"; break; //tebibit
            case 17: factor = "1"; break; //tebibyte

            case 18: factor = "0.008796093022208"; break; //petabit
            case 19: factor = "0.001099511627776"; break; //petabyte
            case 20: factor = "0.0078125"; break; //pebibit
            case 21: factor = "0.0009765625"; break; //pebibyte

            case 22: factor = "0.000008796093022208"; break; //exabit
            case 23: factor = "0.000001099511627776"; break; //exabyte
            case 24: factor = "0.00000762939453125"; break; //exbibit
            case 25: factor = "0.00000095367431640625"; break; //exbibyte

            case 26: factor = "0.000000008796093022208"; break; //zettabit
            case 27: factor = "0.000000001099511627776"; break; //zettabyte
            case 28: factor = "0.000000007450580596923828125"; break; //zebibit
            case 29: factor = "0.000000000931322574615478515625"; break; //zebibyte

            case 30: factor = "0.000000000008796093022208"; break; //yottabit
            case 31: factor = "0.000000000001099511627776"; break; //yottabyte
            case 32: factor = "7.2759576141834259033203125e-12"; break; //yobibit
            case 33: factor = "9.094947017729282379150390625e-13"; break; //yobibyte
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        ////result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToMeterPerSecond(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "0.277778"; break; //kilometer per hour
            case 1: factor = "1000"; break; //kilometer per second
            case 2: factor = "1"; break; //meter per second
            case 3: factor = "0.44704"; break; //mile per hour
            case 4: factor = "1609.344"; break; //mile per second
            case 5: factor = "0.3048"; break; //foot per second
            case 6: factor = "0.514444"; break; //knot (nautical mile/h)
            case 7: factor = "340.277778"; break; //mach
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromMeterPerSecond(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "3.5999971200023039981568014745588"; break; //kilometer per hour
            case 1: factor = "0.001"; break; //kilometer per second
            case 2: factor = "1"; break; //meter per second
            case 3: factor = "2.2369362920544022906227630637079"; break; //mile per hour
            case 4: factor = "6.2137119223733396961743418436332e-4"; break; //mile per second
            case 5: factor = "3.2808398950131233595800524934383"; break; //foot per second
            case 6: factor = "1.9438461717893492780555317974357"; break; //knot (nautical mile/h)
            case 7: factor = "0.0029387755082848813007119142526"; break; //mach
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToWatt(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "0.001"; break; //miliwatt
            case 1: factor = "0.01"; break; //centiwatt
            case 2: factor = "1"; break; //watt
            case 3: factor = "10"; break; //dacawatt
            case 4: factor = "100"; break; //hectowatt
            case 5: factor = "1000"; break; //kilowatt
            case 6: factor = "1000000"; break; //megawatt
            case 7: factor = "1000000000"; break; //gigawatt
            case 8: factor = "735.49875"; break; //horsepower
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromWatt(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "1000"; break; //miliwatt
            case 1: factor = "100"; break; //centiwatt
            case 2: factor = "1"; break; //watt
            case 3: factor = "0.1"; break; //dacawatt
            case 4: factor = "0.01"; break; //hectowatt
            case 5: factor = "0.001"; break; //kilowatt
            case 6: factor = "0.000001"; break; //megawatt
            case 7: factor = "0.000000001"; break; //gigawatt
            case 8: factor = "0.00135962161730390432342679032425"; break; //horsepower
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToJoule(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "1"; break; //joul
            case 1: factor = "1000"; break; //kilojoul
            case 2: factor = "1000000"; break; //megajoul
            case 3: factor = "1"; break; //watt second
            case 4: factor = "3600"; break; //watt hour
            case 5: factor = "3600000"; break; //kilowatt hour
            case 6: factor = "0.0000001"; break; //erg
            case 7: factor = "4.1868"; break; //calorie
            case 8: factor = "4186.8"; break; //kilocalorie
            case 9: factor = "4186800"; break; //megacalorie
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromJoule(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "1"; break; //joul
            case 1: factor = "0.001"; break; //kilojoul
            case 2: factor = "0.000001"; break; //megajoul
            case 3: factor = "1"; break; //watt second
            case 4: factor = "2.7777777777777777777777777777778e-4"; break; //watt hour
            case 5: factor = "2.7777777777777777777777777777778e-7"; break; //kilowatt hour
            case 6: factor = "10000000"; break; //erg
            case 7: factor = "0.23884589662749593961975733256903"; break; //calorie
            case 8: factor = "2.3884589662749593961975733256903e-4"; break; //kilocalorie
            case 9: factor = "2.3884589662749593961975733256903e-7"; break; //megacalorie
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    private static String timeFactor(int unit) {
        String factor = "0";
        switch(unit) {
            case 0: factor = "0.000000001"; break; //nanoseconds
            case 1: factor = "0.000001"; break; //microseconds
            case 2: factor = "0.001"; break; //miliseconds
            case 3: factor = "0.01"; break; //hundredth of a second
            case 4: factor = "1"; break; //second
            case 5: factor = "60"; break; //minute
            case 6: factor = "900"; break; //quarter of an hour
            case 7: factor = "3600"; break; //hour
            case 8: factor = "86400"; break; //day
            case 9: factor = "604800"; break; //week
            case 10: factor = "2419200"; break; //month (28 days)
            case 11: factor = "2505600"; break; //month (29 days)
            case 12: factor = "2592000"; break; //month (30 days)
            case 13: factor = "2678400"; break; //month (31 days)
            case 14: factor = "31536000"; break; //year (365 days)
            case 15: factor = "31622400"; break; //year (366 days)
            case 16: factor = "315360000"; break; //decade
            case 17: factor = "3153600000"; break; //age
            case 18: factor = "31536000000"; break; //millennium
        }
        return factor;
    }

    public static BigDecimal convertToSecond(int fromUnit, BigDecimal value) {
        String factor = timeFactor(fromUnit);
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromSecond(int toUnit, BigDecimal value) {
        String factor = timeFactor(toUnit);
        MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
        BigDecimal result = value.divide(new BigDecimal(factor), mc);
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToPascal(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "100"; break; //milibar
            case 1: factor = "100000"; break; //bar
            case 2: factor = "1"; break; //pascal
            case 3: factor = "100"; break; //hectopascal
            case 4: factor = "1000000"; break; //megapascal
            case 5: factor = "98066.5012"; break; //kilogram per square centimeter
            case 6: factor = "98066501.2"; break; //tonne per square centimeter
            case 7: factor = "9.80665012"; break; //kilogram per square meter
            case 8: factor = "1"; break; //newton per square meter
            case 9: factor = "1000"; break; //kilonewton per square meter
            case 10: factor = "1000000"; break; //meganewton per square meter
            case 11: factor = "10000"; break; //newton per square centimeter
            case 12: factor = "1000000"; break; //newton per square milimeter
            case 13: factor = "101325"; break; //physical atmosphere
            case 14: factor = "98066.5012"; break; //technical atmosphere
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromPascal(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "0.01"; break; //milibar
            case 1: factor = "0.00001"; break; //bar
            case 2: factor = "1"; break; //pascal
            case 3: factor = "0.01"; break; //hectopascal
            case 4: factor = "0.000001"; break; //megapascal
            case 5: factor = "1.0197162005000745351359593524481e-5"; break; //kilogram per square centimeter
            case 6: factor = "1.0197162005000745351359593524481e-8"; break; //tonne per square centimeter
            case 7: factor = "0.10197162005000745351359593524481"; break; //kilogram per square meter
            case 8: factor = "1"; break; //newton per square meter
            case 9: factor = "0.001"; break; //kilonewton per square meter
            case 10: factor = "0.000001"; break; //meganewton per square meter
            case 11: factor = "0.0001"; break; //newton per square centimeter
            case 12: factor = "0.000001"; break; //newton per square milimeter
            case 13: factor = "9.8692326671601283000246730816679e-6"; break; //physical atmosphere
            case 14: factor = "1.0197162005000745351359593524481e-5"; break; //technical atmosphere
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToCelsius(int fromUnit, BigDecimal value) {
        BigDecimal result = new BigDecimal(value.toPlainString());
        switch(fromUnit) {
            case 0: //Celsius
                result = new BigDecimal(value.toPlainString());
                break;
            case 1: //Fahrenheit
                result = result.subtract(new BigDecimal("32"));
                result = result.multiply(new BigDecimal("0.55555555555555555555555555555556"));
                break;
            case 2: //Kelvin
                result = result.subtract(new BigDecimal("273.15"));
                break;
            case 3: //Rankine
                result = result.multiply(new BigDecimal("0.55555555555555555555555555555556"));
                result = result.subtract(new BigDecimal("273.15"));
                break;
            case 4: //Réaumur
                result = result.multiply(new BigDecimal("1.25"));
                break;
            case 5: //Rømer
                result = result.subtract(new BigDecimal("7.5"));
                result = result.multiply(new BigDecimal("1.9047619047619047619047619047619"));
                break;
            case 6: //Delisle
                result = result.multiply(new BigDecimal("0.66666666666666666666666666666667"));
                BigDecimal temp = new BigDecimal("100");
                result = temp.subtract(result);
                break;
            case 7: //Newton
                result = result.multiply(new BigDecimal("3.030303030303030303030303030303"));
                break;
            default:
                result = new BigDecimal("1");
        }
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromCelsius(int toUnit, BigDecimal value) {
        BigDecimal result = new BigDecimal(value.toPlainString());
        switch(toUnit) {
            case 0: //Celsius
                result = new BigDecimal(value.toPlainString());
                break;
            case 1: //Fahrenheit
                result = result.multiply(new BigDecimal("1.8"));
                result = result.add(new BigDecimal("32"));
                break;
            case 2: //Kelvin
                result = result.add(new BigDecimal("273.15"));
                break;
            case 3: //Rankine
                result = result.add(new BigDecimal("273.15"));
                result = result.multiply(new BigDecimal("1.8"));
                break;
            case 4: //Réaumur
                result = result.multiply(new BigDecimal("4"));
                result = result.multiply(new BigDecimal("0.2"));
                break;
            case 5: //Rømer
                result = result.multiply(new BigDecimal("0.525"));
                result = result.add(new BigDecimal("7.5"));
                break;
            case 6: //Delisle
                BigDecimal temp = new BigDecimal("100");
                result = temp.subtract(result);
                result = result.multiply(new BigDecimal("1.5"));
                break;
            case 7: //Newton
                result = result.multiply(new BigDecimal("0.33"));
                break;
            default:
                result = new BigDecimal("1");
        }
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToLiter(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "0.000001"; break; //cubic milimeter
            case 1: factor = "0.001"; break; //cubic centimeter
            case 2: factor = "1"; break; //cubic decimeter
            case 3: factor = "1000"; break; //cubic meter
            case 4: factor = "0.001"; break; //mililiter
            case 5: factor = "0.01"; break; //centiliter
            case 6: factor = "0.1"; break; //deciliter
            case 7: factor = "1"; break; //liter
            case 8: factor = "100"; break; //hektoliter
            case 9: factor = "0.028413"; break; //ounce uk
            case 10: factor = "0.029574"; break; //ounce us
            case 11: factor = "0,56826125"; break; //pint uk
            case 12: factor = "0,5506104713575"; break; //pint (dry) us
            case 13: factor = "0.473176473"; break; //pint (fluid) us
            case 14: factor = "1.136523"; break; //quart uk
            case 15: factor = "1.10122"; break; //quart (dry) us
            case 16: factor = "0.946353"; break; //quart (fluid) us
            case 17: factor = "4.54609"; break; //gallon uk
            case 18: factor = "4.40488377086"; break; //gallon (dry) us
            case 19: factor = "3.785411784"; break; //gallon (fluid) us
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromLiter(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "1000000"; break; //cubic milimeter
            case 1: factor = "1000"; break; //cubic centimeter
            case 2: factor = "1"; break; //cubic decimeter
            case 3: factor = "0.001"; break; //cubic meter
            case 4: factor = "1000"; break; //mililiter
            case 5: factor = "100"; break; //centiliter
            case 6: factor = "10"; break; //deciliter
            case 7: factor = "1"; break; //liter
            case 8: factor = "0.01"; break; //hektoliter
            case 9: factor = "35.195157146376658571780523000035"; break; //ounce uk
            case 10: factor = "33.813484817745316832352742273619"; break; //ounce us
            case 11: factor = "1.759753986392702300218429463561"; break; //pint uk
            case 12: factor = "1.8161659685377117832685895969484"; break; //pint (dry) us
            case 13: factor = "2.1133764188651873230391993728733"; break; //pint (fluid) us
            case 14: factor = "0.87987660610475986847604491946049"; break; //quart uk
            case 15: factor = "0.90808376164617424311218466791377"; break; //quart (dry) us
            case 16: factor = "1.0566881491367386165627413871991"; break; //quart (fluid) us
            case 17: factor = "0.21996924829908778752730368294512"; break; //gallon uk
            case 18: factor = "0.22702074606721397290857369961855"; break; //gallon (dry) us
            case 19: factor = "0.26417205235814841537989992160916"; break; //gallon (fluid) us
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToSquareMeter(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "0.000001"; break; //square milimeter
            case 1: factor = "0.0001"; break; //squre centimeter
            case 2: factor = "0.01"; break; //square decimeter
            case 3: factor = "1"; break; //square meter
            case 4: factor = "1000000"; break; //square kilometer
            case 5: factor = "100"; break; //ar
            case 6: factor = "10000"; break; //hectare
            case 7: factor = "0.000645"; break; //square inch
            case 8: factor = "0.092903"; break; //square foot
            case 9: factor = "0.836127"; break; //square yard
            case 10: factor = "2589988.11"; break; //square mile
            case 11: factor = "4046.856422"; break; //acre uk
            case 12: factor = "4046.87261"; break; //acre us
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromSquareMeter(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "1000000"; break; //square milimeter
            case 1: factor = "10000"; break; //squre centimeter
            case 2: factor = "100"; break; //square decimeter
            case 3: factor = "1"; break; //square meter
            case 4: factor = "0.000001"; break; //square kilometer
            case 5: factor = "0.01"; break; //ar
            case 6: factor = "0.0001"; break; //hectare
            case 7: factor = "1550.3875968992248062015503875969"; break; //square inch
            case 8: factor = "10.763915051182416068372388405111"; break; //square foot
            case 9: factor = "1.195990561242490674263598711679"; break; //square yard
            case 10: factor = "3.8610215859253500588464091443261e-7"; break; //square mile
            case 11: factor = "2.4710538149158977007067141261677e-4"; break; //acre uk
            case 12: factor = "2.4710439303894964956655752007968e-4"; break; //acre us
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToKilogram(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "0.000001"; break; //miligram
            case 1: factor = "0.001"; break; //gram
            case 2: factor = "0.01"; break; //decagram
            case 3: factor = "1"; break; //kilogram
            case 4: factor = "1000"; break; //ton
            case 5: factor = "0.02834952981"; break; //ounce
            case 6: factor = "0.45359237"; break; //pound
            case 7: factor = "45.3592"; break; //hundredweight us
            case 8: factor = "50.80234544"; break; //hundredweight uk
            case 9: factor = "907.18474"; break; //ton us
            case 10: factor = "1016.046909"; break; //ton uk
            case 11: factor = "0.0002"; break; //carat
            case 12: factor = "100"; break; //quintal
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromKilogram(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "1000000"; break; //miligram
            case 1: factor = "1000"; break; //gram
            case 2: factor = "100"; break; //decagram
            case 3: factor = "1"; break; //kilogram
            case 4: factor = "0.001"; break; //ton
            case 5: factor = "35.273953631755136329719607437821"; break; //ounce
            case 6: factor = "2.2046226218487758072297380134503"; break; //pound
            case 7: factor = "0.02204624420183777491666519691705"; break; //hundredweight us
            case 8: factor = "0.01968413055222121256455123226295"; break; //hundredweight uk
            case 9: factor = "0.00110231131092438790361486900673"; break; //ton us
            case 10: factor = "9.8420652741732813046725188157627e-4"; break; //ton uk
            case 11: factor = "5000"; break; //carat
            case 12: factor = "0.01"; break; //quintal
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertToMeter(int fromUnit, BigDecimal value) {
        String factor = "0";
        switch(fromUnit) {
            case 0: factor = "0.001"; break; //milimeter
            case 1: factor = "0.01"; break; //centimeter
            case 2: factor = "0.1"; break; //decimeter
            case 3: factor = "1"; break; //meter
            case 4: factor = "1000"; break; //kilometer
            case 5: factor = "0.0254"; break; //inch
            case 6: factor = "0.3048"; break; //foot
            case 7: factor = "0.9144"; break; //yard
            case 8: factor = "1609.31232"; break; //mile
            case 9: factor = "4827.93696"; break; //league
            case 10: factor = "185.2"; break; //cable
            case 11: factor = "1852"; break; //nautical mile
            case 12: factor = "5556"; break; //nautical league
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertFromMeter(int toUnit, BigDecimal value) {
        String factor = "0";
        switch(toUnit) {
            case 0: factor = "1000"; break; //milimeter
            case 1: factor = "100"; break; //centimeter
            case 2: factor = "10"; break; //decimeter
            case 3: factor = "1"; break; //meter
            case 4: factor = "0.001"; break; //kilometer
            case 5: factor = "39.37007874015748031496062992126"; break; //inch
            case 6: factor = "3.2808398950131233595800524934383"; break; //foot
            case 7: factor = "1.0936132983377077865266841644794"; break; //yard
            case 8: factor = "6.2138342419450315275036234110232e-4"; break; //mile
            case 9: factor = "2.0712780806483438425012078036744e-4"; break; //league
            case 10: factor = "0.00539956803455723542116630669546"; break; //cable
            case 11: factor = "5.3995680345572354211663066954644e-4"; break; //nautical mile
            case 12: factor = "1.7998560115190784737221022318215e-4"; break; //nautical league
        }
        BigDecimal result = new BigDecimal(factor);
        result = result.multiply(value);
        //result = new BigDecimal(round(result.toPlainString()));
        //result = result.stripTrailingZeros();
        return result;
    }

    public static BigDecimal convertLength(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromMeter(toUnit, convertToMeter(fromUnit, value));
    }

    public static BigDecimal convertMass(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromKilogram(toUnit, convertToKilogram(fromUnit, value));
    }

    public static BigDecimal convertArea(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromSquareMeter(toUnit, convertToSquareMeter(fromUnit, value));
    }

    public static BigDecimal convertVolume(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromLiter(toUnit, convertToLiter(fromUnit, value));
    }

    public static BigDecimal convertTemperature(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromCelsius(toUnit, convertToCelsius(fromUnit, value));
    }

    public static BigDecimal convertPressure(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromPascal(toUnit, convertToPascal(fromUnit, value));
    }

    public static BigDecimal convertTime(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromSecond(toUnit, convertToSecond(fromUnit, value));
    }

    public static BigDecimal convertEnergy(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromJoule(toUnit, convertToJoule(fromUnit, value));
    }

    public static BigDecimal convertPower(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromWatt(toUnit, convertToWatt(fromUnit, value));
    }

    public static BigDecimal convertSpeed(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromMeterPerSecond(toUnit, convertToMeterPerSecond(fromUnit, value));
    }

    public static BigDecimal convertDataStorage(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromTebibyte(toUnit, convertToTebibyte(fromUnit, value));
    }

    public static BigDecimal convertDataStorageOld(int fromUnit, int toUnit, BigDecimal value) {
        return convertFromOldTerabyte(toUnit, convertToOldTerabyte(fromUnit, value));
    }

    public static BigDecimal convert(int type, int fromUnit, int toUnit, BigDecimal value) {
        switch(type) {
            case 0: return convertLength(fromUnit, toUnit, value);
            case 1:
                return convertMass(fromUnit, toUnit, value);
            case 2:
                return convertArea(fromUnit, toUnit, value);
            case 3:
                return convertVolume(fromUnit, toUnit, value);
            case 4:
                return convertTemperature(fromUnit, toUnit, value);
            case 5:
                return convertPressure(fromUnit, toUnit, value);
            case 6:
                return convertTime(fromUnit, toUnit, value);
            case 7:
                return convertEnergy(fromUnit, toUnit, value);
            case 8:
                return convertPower(fromUnit, toUnit, value);
            case 9:
                return convertSpeed(fromUnit, toUnit, value);
            case 10:
                return convertDataStorage(fromUnit, toUnit, value);
            case 11:
                return convertDataStorageOld(fromUnit, toUnit, value);
            default:
                return new BigDecimal("0");
        }
    }
}