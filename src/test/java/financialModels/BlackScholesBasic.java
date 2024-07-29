package financialModels;

import org.apache.commons.math3.special.Erf;

import java.lang.Math;

public class BlackScholesBasic {

    // Standard normal cumulative distribution function
    public static double cumulativeNormalDistribution(double x) {
        return 0.5 * (1.0 + Erf.erf(x / Math.sqrt(2.0)));
    }

    // Black-Scholes formula for a European call option
    public static double blackScholesCallPrice(double S, double K, double T, double r, double sigma) {
        // S = Current stock price
        // K = Strike price
        // T = Time to expiration in years
        // r = Risk-free interest rate (annual)
        // sigma = Volatility of the stock (annual)

        // Calculating d1 and d2
        double d1 = (Math.log(S / K) + (r + 0.5 * sigma * sigma) * T) / (sigma * Math.sqrt(T));
        double d2 = d1 - sigma * Math.sqrt(T);

        // Calculating call price using the Black-Scholes formula
        double callPrice = S * cumulativeNormalDistribution(d1) - K * Math.exp(-r * T) * cumulativeNormalDistribution(d2);

        return callPrice;
    }

    public static void main(String[] args) {
        // Example usage
        double S = 100.0; // Current stock price
        double K = 100.0; // Strike price
        double T = 1.0;   // Time to expiration in years
        double r = 0.05;  // Risk-free interest rate (5%)
        double sigma = 0.2; // Volatility (20%)

        double callPrice = blackScholesCallPrice(S, K, T, r, sigma);
        System.out.println("The Black-Scholes price of the call option is: " + callPrice);
    }
}