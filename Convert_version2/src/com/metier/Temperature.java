package com.metier;

public class Temperature {
	private double celsius;

    public Temperature(double valeurCelsius)
    {
          celsius = valeurCelsius;
    }

    /**
     * Pour obtenir la valeur en Celsius
     *
     * @return Valeur de la température en Celsius
   */
    public double getCelsius() {
          return celsius;
    }

    /**
     * Pour obtenir la valeur en Fahrenheit
     *
     * @return Valeur de la température en Farenheit
    */
    public double getFahrenheit() {
          return (celsius * 9/5) + 32;
  }
}
