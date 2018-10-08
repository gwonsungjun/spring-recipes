package ch16.com.springrecipes.bank;

public interface InterestCalculator {
    void setRate(double rate);
    double calculate(double amount, double year);
}
