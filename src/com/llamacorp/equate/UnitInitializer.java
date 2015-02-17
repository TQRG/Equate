package com.llamacorp.equate;

import java.util.ArrayList;

public class UnitInitializer {

	public static ArrayList<UnitType> getDefaultUnitArray(){
		ArrayList<UnitType> unitTypeArray = new ArrayList<UnitType>();
		
		UnitType unitsOfCurrency = new UnitType("Currency");
		unitsOfCurrency.addUnit(new UnitCurrency("USD", "Dollars", 1));
		unitsOfCurrency.addUnit(new UnitCurrency("EUR", "Euros", 0.76)); 
		unitsOfCurrency.addUnit(new UnitCurrency("CAD", "Canadian Dollars", 1.08)); 
		unitsOfCurrency.addUnit(new UnitCurrency("GBP", "Pounds", 0.6)); 
		unitsOfCurrency.addUnit(new UnitCurrency("JPY", "Yen", 103.9)); 

		unitsOfCurrency.addUnit(new UnitCurrency("CHF", "Swiss Francs", 0.91)); 
		unitsOfCurrency.addUnit(new UnitCurrency("AUD", "Australian Dollars", 1.07)); 
		unitsOfCurrency.addUnit(new UnitCurrency("HKD", "Hong Kong Dollars", 7.75)); 


		//array of values from 1914 $10 bill; starts with 1913; uses the CPI index
		//data can be found: http://data.bls.gov/timeseries/CUUR0000SA0
		double[] cpiTable = {9.9, 10, 10.1, 10.9, 12.8, 15.1, 17.3, 20, 17.9, 16.8, 
				17.1, 17.1, 17.5, 17.7, 17.4, 17.1, 17.1, 16.7, 15.2, 13.7, 13, 13.4, 
				13.7, 13.9, 14.4, 14.1, 13.9, 14, 14.7, 16.3, 17.3, 17.6, 18, 19.5, 
				22.3, 24.1, 23.8, 24.1, 26, 26.5, 26.7, 26.9, 26.8, 27.2, 28.1, 28.9,
				29.1, 29.6, 29.9, 30.2, 30.6, 31, 31.5, 32.4, 33.4, 34.8, 36.7, 38.8,
				40.5, 41.8, 44.4, 49.3, 53.8, 56.9, 60.6, 65.2, 72.6, 82.4, 90.9, 96.5,
				99.6, 103.9, 107.6, 109.6, 113.6, 118.3, 124, 130.7, 136.2, 140.3, 
				144.5, 148.2, 152.4, 156.9, 160.5, 163, 166.6, 172.2, 177.1, 179.9, 
				184, 188.9, 195.3, 201.6, 207.342, 215.303, 214.537, 218.056, 224.939, 
				229.594, 232.957, 236.911};

		ArrayList<Double> al = new ArrayList<Double>();
		for(int i=0;i<cpiTable.length;i++){
			//convert values such that 1 is current 2014 dollar
			double normalizedValue = cpiTable[i]/cpiTable[cpiTable.length-1];
			al.add(normalizedValue);
		}

		unitsOfCurrency.addUnit(new UnitHistCurrency("USD", "Dollars", al, 1913, 1975));

		unitsOfCurrency.addUnit(new UnitCurrency("SGD", "Singapore Dollars", 1.25)); 
		unitsOfCurrency.addUnit(new UnitCurrency("CNY", "Chinese Yuans", 6.15)); 
		unitsOfCurrency.addUnit(new UnitCurrency("BTC", "Bitcoins", 0.003, 
				"http://blockchain.info/tobtc?currency=USD&value=1")); 
		unitsOfCurrency.addUnit(new UnitCurrency("RUB", "Russian Rubles", 39.7)); 
		unitTypeArray.add(unitsOfCurrency);

		//refreshAllDynamicUnits();		

		UnitType unitsOfTemp = new UnitType("Temp");
		unitsOfTemp.addUnit(new UnitTemperature());
		unitsOfTemp.addUnit(new UnitTemperature());
		unitsOfTemp.addUnit(new UnitTemperature());
		unitsOfTemp.addUnit(new UnitTemperature());
		unitsOfTemp.addUnit(new UnitTemperature("\u00B0F", "Fahrenheit", UnitTemperature.FAHRENHEIT));

		unitsOfTemp.addUnit(new UnitTemperature());
		unitsOfTemp.addUnit(new UnitTemperature());
		unitsOfTemp.addUnit(new UnitTemperature());
		unitsOfTemp.addUnit(new UnitTemperature("\u00B0K", "Kelvin", UnitTemperature.KELVIN));
		unitsOfTemp.addUnit(new UnitTemperature("\u00B0C", "Celsius", UnitTemperature.CELSIUS));
		unitTypeArray.add(unitsOfTemp);


		UnitType unitsOfWeight = new UnitType("Weight");
		unitsOfWeight.addUnit(new UnitScalar("oz", "Ounces", 1/0.0283495));
		unitsOfWeight.addUnit(new UnitScalar("lb", "Pounds", 1/0.453592));
		unitsOfWeight.addUnit(new UnitScalar("ton us", "Short Tons", 1/907.184));
		unitsOfWeight.addUnit(new UnitScalar("ton uk", "Long Tons", 1/1016.04608));
		unitsOfWeight.addUnit(new UnitScalar("st", "Stones", 1/6.350288));

		unitsOfWeight.addUnit(new UnitScalar("\u00B5g", "Micrograms", 1/1e-9));
		unitsOfWeight.addUnit(new UnitScalar("mg", "Milligrams", 1/1e-6));
		unitsOfWeight.addUnit(new UnitScalar("g", "Grams", 1/0.001));
		unitsOfWeight.addUnit(new UnitScalar("kg", "Kilograms", 1));
		unitsOfWeight.addUnit(new UnitScalar("ton", "Metric Tons", 1/1e3));

		unitsOfWeight.addUnit(new UnitScalar("oz t", "Troy Ounces", 1/0.0311034768)); //exact
		unitsOfWeight.addUnit(new UnitScalar("gr", "Grains", 1/6.479891E-5)); //exact
		unitsOfWeight.addUnit(new UnitScalar("dwt", "Pennyweights", 20/0.0311034768)); //exact, 1/20 troy oz
		unitsOfWeight.addUnit(new UnitScalar("CD", "Carats", 5000)); // =200mg
		unitTypeArray.add(unitsOfWeight);


		UnitType unitsOfLength = new UnitType("Length");
		unitsOfLength.addUnit(new UnitScalar("in", "Inches", 1/0.0254));//exact
		unitsOfLength.addUnit(new UnitScalar("ft", "Feet", 1/0.3048));//exact: in*12
		unitsOfLength.addUnit(new UnitScalar("yd", "Yards", 1/0.9144));//exact: in*12*3
		unitsOfLength.addUnit(new UnitScalar("mi", "Miles", 1/1609.344));//exact: in*12*5280
		unitsOfLength.addUnit(new UnitScalar("km", "Kilometers", 1/1000.0));

		unitsOfLength.addUnit(new UnitScalar("\u00B5m", "Micrometers", 1E6));
		unitsOfLength.addUnit(new UnitScalar("mm", "Millimeters", 1000));
		unitsOfLength.addUnit(new UnitScalar("cm", "Centimeters", 100));
		unitsOfLength.addUnit(new UnitScalar("m", "Meters", 1));

		unitsOfLength.addUnit(new UnitScalar("nm", "Nanometers", 1E9));
		unitsOfLength.addUnit(new UnitScalar("�", "�ngstr�ms", 1E10));
		unitsOfLength.addUnit(new UnitScalar("mil", "Thousandths of an Inch", 1/2.54E-5));
		unitsOfLength.addUnit(new UnitScalar("fur", "Furlongs", 0.00497096954));
		unitsOfLength.addUnit(new UnitScalar("pc", "Parsecs", 3.24078E-17));
		unitsOfLength.addUnit(new UnitScalar("nmi", "Nautical Miles", 1/1852.0));
		unitsOfLength.addUnit(new UnitScalar("ly", "Light Years", 1/9.4607E15));
		unitsOfLength.addUnit(new UnitScalar("au", "Astronomical Units", 1/1.495978707E11)); //exact
		unitTypeArray.add(unitsOfLength);	


		UnitType unitsOfArea = new UnitType("Area");
		unitsOfArea.addUnit(new UnitScalar("in\u00B2", "Square Inches", 1/0.00064516));//exact: 0.0254^2
		unitsOfArea.addUnit(new UnitScalar("ft\u00B2", "Square Feet", 1/0.09290304));//0.3048^2
		unitsOfArea.addUnit(new UnitScalar("yd\u00B2", "Square Yards", 1/0.83612736));//0.3048^2*9
		unitsOfArea.addUnit(new UnitScalar("acre", "Acres", 1/4046.8564224));//0.3048^2*9*4840
		unitsOfArea.addUnit(new UnitScalar("mi\u00B2", "Square Miles", 1/2589988.110336));//1609.344^2

		unitsOfArea.addUnit(new UnitScalar("mm\u00B2", "Square Millimeters", 1/0.000001));
		unitsOfArea.addUnit(new UnitScalar("cm\u00B2", "Square Centimeters", 1/0.0001));
		unitsOfArea.addUnit(new UnitScalar("m\u00B2", "Square Meters", 1));
		unitsOfArea.addUnit(new UnitScalar("km\u00B2", "Square Kilometers", 1/1000000.0));

		unitsOfArea.addUnit(new UnitScalar("ha", "Hectares", 1/10000.0));
		unitsOfArea.addUnit(new UnitScalar("a", "Ares", 0.01));
		unitsOfArea.addUnit(new UnitScalar("cir mil", "Circular Mils", 1/5.067E-10));
		unitTypeArray.add(unitsOfArea);


		UnitType unitsOfVolume = new UnitType("Volume");
		unitsOfVolume.addUnit(new UnitScalar("tbsp", "Tablespoons", 1/0.00001478676478125));//exact: gal/256
		unitsOfVolume.addUnit(new UnitScalar("cup", "Cups", 1/0.0002365882365));//exact: gal/16
		unitsOfVolume.addUnit(new UnitScalar("pt", "Pints (US)", 1/0.000473176473));//exact: gal/8
		unitsOfVolume.addUnit(new UnitScalar("qt", "Quarts (US)", 1/0.000946352946));//exact: gal/4
		unitsOfVolume.addUnit(new UnitScalar("gal", "Gallons (US)", 1/0.003785411784));//exact: according to wiki

		unitsOfVolume.addUnit(new UnitScalar("tsp", "Teaspoons", 1/0.00000492892159375));//exact: gal/768
		unitsOfVolume.addUnit(new UnitScalar("fl oz", "Fluid Ounces (US)", 1/0.0000295735295625));//exact: gal/128
		unitsOfVolume.addUnit(new UnitScalar("mL", "Milliliters", 1E6)); 
		unitsOfVolume.addUnit(new UnitScalar("L", "Liters", 1000));

		unitsOfVolume.addUnit(new UnitScalar("cL", "Centiliter", 1E5));
		unitsOfVolume.addUnit(new UnitScalar("dL", "Deciliters", 1E4));
		unitsOfVolume.addUnit(new UnitScalar("gal uk", "Gallons (UK)", 1000/4.54609));//exact: 4.54609L/gal uk
		unitsOfVolume.addUnit(new UnitScalar("qt uk", "Quart (UK)", 1000/1.1365225));//exact: gal uk/4
		unitsOfVolume.addUnit(new UnitScalar("pt uk", "Pints (UK)", 1000/0.56826125));//exact: gal uk/8
		unitsOfVolume.addUnit(new UnitScalar("fl oz uk", "Fluid Ounces (UK)", 1000/0.0284130625));//exact: gal uk/160
		unitsOfVolume.addUnit(new UnitScalar("shot", "Shots (US)", 1/0.00004436029434375));//exact for 1.5 fl oz
		unitsOfVolume.addUnit(new UnitScalar("m^3", "Cubic Meters", 1));
		unitsOfVolume.addUnit(new UnitScalar("in\u00B3", "Cubic Inches", 1/0.000016387064));//exact: gal/231
		unitsOfVolume.addUnit(new UnitScalar("ft\u00B3", "Cubic Feet", 1/0.028316846592));//exact: gal/231*12^3
		unitsOfVolume.addUnit(new UnitScalar("yd\u00B3", "Cubic Yards", 1/0.764554857984));//exact: 3^3 ft^3
		unitsOfVolume.addUnit(new UnitScalar("cm\u00B3", "Cubic Centimeters", 1E6));
		unitsOfVolume.addUnit(new UnitScalar("cm\u00B3", "Cubic Millimeters", 1E9));

		unitTypeArray.add(unitsOfVolume);


		UnitType unitsOfSpeed = new UnitType("Speed");
		unitsOfSpeed.addUnit(new UnitScalar("mi/min","Miles per minute", 1/26.8224));
		unitsOfSpeed.addUnit(new UnitScalar("min/mi","Minute miles", 1/26.8224, true));
		unitsOfSpeed.addUnit(new UnitScalar("ft/s", "Feet per Second", 1/0.3048));
		unitsOfSpeed.addUnit(new UnitScalar("mph", "Miles per Hour", 1/0.44704));
		unitsOfSpeed.addUnit(new UnitScalar("knot", "Knots", 1/0.514444));

		unitsOfSpeed.addUnit(new UnitScalar("", 0));
		unitsOfSpeed.addUnit(new UnitScalar("", 0));
		unitsOfSpeed.addUnit(new UnitScalar("", 0));
		unitsOfSpeed.addUnit(new UnitScalar("m/s", "Meters per Second", 1));
		unitsOfSpeed.addUnit(new UnitScalar("kph", "Kilometers per Hour", 3.6));
		unitTypeArray.add(unitsOfSpeed);


		UnitType unitsOfPower = new UnitType("Power");
		unitsOfPower.addUnit(new UnitScalar("", 0));
		unitsOfPower.addUnit(new UnitScalar("", 0));
		unitsOfPower.addUnit(new UnitScalar("W", "Watts", 1));
		unitsOfPower.addUnit(new UnitScalar("kW", "Kilowatts", 1E-3));
		unitsOfPower.addUnit(new UnitScalar("hp", "Horsepower", 1/745.699872)); //don't think it's exact

		unitsOfPower.addUnit(new UnitScalar("", 0));
		unitsOfPower.addUnit(new UnitScalar("Btu/hr", "Btus/Hour", 3.412141632)); //approx
		unitsOfPower.addUnit(new UnitScalar("Btu/min", "Btus/Minute", 0.0568690272)); //approx
		unitsOfPower.addUnit(new UnitScalar("ft-lb/min", "Foot-Pounds/Minute", 44.2537289)); //most likely approx
		unitsOfPower.addUnit(new UnitScalar("ft-lb/sec", "Foot-Pounds/Second", 0.73756215)); //most likely approx
		unitTypeArray.add(unitsOfPower);


		UnitType unitsOfEnergy = new UnitType("Energy");
		unitsOfEnergy.addUnit(new UnitScalar("cal", "Calories", 0.239005736)); //approx
		unitsOfEnergy.addUnit(new UnitScalar("kCal", "Kilocalories", 0.239005736/1E3)); //approx, but exact comp to cal
		unitsOfEnergy.addUnit(new UnitScalar("BTU", "British Thermal Units", 0.00094781712)); //approx
		unitsOfEnergy.addUnit(new UnitScalar("ft-lb", "Foot-pounds", 1/1.3558179483314)); //approx
		unitsOfEnergy.addUnit(new UnitScalar("in-lb", "Inch-pounds", 12/1.3558179483314)); //approx

		unitsOfEnergy.addUnit(new UnitScalar("kJ", "Kilojoules", 0.001));
		unitsOfEnergy.addUnit(new UnitScalar("J", "Joules", 1));
		unitsOfEnergy.addUnit(new UnitScalar("Wh", "Watt-Hours", 1/3.6E3)); //exact
		unitsOfEnergy.addUnit(new UnitScalar("kWh", "Kilowatt-Hours", 1/3.6E6)); //exact

		unitsOfEnergy.addUnit(new UnitScalar("Nm", "Newton-Meters", 1));
		unitsOfEnergy.addUnit(new UnitScalar("MJ", "Megajoules", 1E-6));
		unitsOfEnergy.addUnit(new UnitScalar("eV", "Electronvolts", 6.241509E18));
		unitTypeArray.add(unitsOfEnergy);


		UnitType unitsOfTorque = new UnitType("Torque");
		unitsOfTorque.addUnit(new UnitScalar("Nm", "Newton Meters", 1)); 
		unitsOfTorque.addUnit(new UnitScalar("Ncm", "Newton Centimeters", 100)); 
		unitsOfTorque.addUnit(new UnitScalar("kgf m", "Kilogram-Force Meters", 1/9.80665)); //exact
		unitsOfTorque.addUnit(new UnitScalar("kgf cm", "Kilogram-Force Centimeters", 100/9.80665)); //exact
		unitsOfTorque.addUnit(new UnitScalar("dyn m", "Dyne Meters", 1E5)); 

		unitsOfTorque.addUnit(new UnitScalar("lbf in", "Pound-Force Inches", 12/1.3558179483314004));  //exact
		unitsOfTorque.addUnit(new UnitScalar("lbf ft", "Pound-Force Feet", 1/1.3558179483314004));  //exact
		unitsOfTorque.addUnit(new UnitScalar("ozf in", "Ounce-Force Inches", 192/1.3558179483314004));  //exact
		unitsOfTorque.addUnit(new UnitScalar("ozf ft", "Ounce-Force Feet", 16/1.3558179483314004));  //exact
		unitsOfTorque.addUnit(new UnitScalar("dyn cm", "Dyne Centimeters", 1));
		unitTypeArray.add(unitsOfTorque);

		//note the use of singular tense, not sure what is the best
		UnitType unitsOfPressure = new UnitType("Pressure");
		unitsOfPressure.addUnit(new UnitScalar("N/m\u00B2", "Newton/Square Meter", 1));
		unitsOfPressure.addUnit(new UnitScalar("lb/ft\u00B2", "Pounds/Square Foot", 144/6894.757293168));  //approx
		unitsOfPressure.addUnit(new UnitScalar("psi", "Pounds/Square Inch", 1/6894.757293168)); //approx
		unitsOfPressure.addUnit(new UnitScalar("atm", "Atmospheres", 1/101325.0));  //exact
		unitsOfPressure.addUnit(new UnitScalar("bar", "Bars", 0.00001));  //exact

		unitsOfPressure.addUnit(new UnitScalar("kg/m\u00B2", "Kilogram/Square Meter", 1/9.80665)); //approx?
		unitsOfPressure.addUnit(new UnitScalar("kPa", "Kilopascals", 0.001)); //exact
		unitsOfPressure.addUnit(new UnitScalar("Pa", "Pascals", 1)); //exact
		unitsOfPressure.addUnit(new UnitScalar("inHg", "Inches of Mercury", 1/3386.388640341)); //exact using cmHg - 1/(1333.22387415*2.54)
		unitsOfPressure.addUnit(new UnitScalar("cmHg", "Centimeters of Mercury", 1/1333.22387415)); //exact

		unitsOfPressure.addUnit(new UnitScalar("mmHg", "Millimeters of Mercury", 1/133.322387415)); //exact
		unitsOfPressure.addUnit(new UnitScalar("N/cm\u00B2", "Newton/Square Centimeters", 1E-4));
		unitsOfPressure.addUnit(new UnitScalar("N/mm\u00B2", "Newton/Square Millimeters", 1E-6));
		unitsOfPressure.addUnit(new UnitScalar("kg/cm\u00B2", "Kilogram/Square Centimeter", 1/98066.5)); //approx?
		unitTypeArray.add(unitsOfPressure);

		return unitTypeArray;
	}
}