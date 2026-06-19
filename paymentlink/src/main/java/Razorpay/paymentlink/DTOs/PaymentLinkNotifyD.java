package Razorpay.paymentlink.DTOs;

public class PaymentLinkNotifyD{
    private boolean email;
    private boolean sms;

    // Getters and Setters
    public boolean isEmail() { return email; }
    public void setEmail(boolean email) { this.email = email; }
    public boolean isSms() { return sms; }
    public void setSms(boolean sms) { this.sms = sms; }
}
