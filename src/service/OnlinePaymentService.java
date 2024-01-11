package service;

public interface OnlinePaymentService {

    double paymentFee(double amount);
    double imterest(double amount,int months);
}
