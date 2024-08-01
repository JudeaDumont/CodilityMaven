package financialModels;

import java.util.Random;

//Here's a basic Java implementation of the Vasicek model, simulating the evolution of short-term interest rates over time:
public class VasicekModel {

    private double a;     // Speed of reversion
    private double b;     // Long-term mean level
    private double sigma; // Volatility
    private double r0;    // Initial interest rate
    private double dt;    // Time step
    private int steps;    // Number of steps

    public VasicekModel(double a, double b, double sigma, double r0, double dt, int steps) {
        this.a = a;
        this.b = b;
        this.sigma = sigma;
        this.r0 = r0;
        this.dt = dt;
        this.steps = steps;
    }

    public void simulate() {
        double[] rates = new double[steps];
        rates[0] = r0;
        Random random = new Random();

        System.out.println("Time\tRate");

        for (int i = 1; i < steps; i++) {
            double t = i * dt;
            double dr = a * (b - rates[i - 1]) * dt + sigma * Math.sqrt(dt) * random.nextGaussian();
            rates[i] = rates[i - 1] + dr;

            System.out.printf("%.2f\t%.4f%n", t, rates[i]);
        }
    }

    public static void main(String[] args) {
        // Parameters
        double a = 0.1;   // Speed of reversion
        double b = 0.05;  // Long-term mean level
        double sigma = 0.02; // Volatility
        double r0 = 0.03; // Initial interest rate
        double dt = 0.01; // Time step (years)
        int steps = 1000; // Number of steps

        // Create the model and run the simulation
        VasicekModel model = new VasicekModel(a, b, sigma, r0, dt, steps);
        model.simulate();
    }
}

