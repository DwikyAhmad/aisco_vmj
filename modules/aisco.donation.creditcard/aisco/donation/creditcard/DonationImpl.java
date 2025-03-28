package aisco.donation.creditcard;

import aisco.donation.core.DonationComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DonationImpl extends DonationComponent {
    String cardNumber;
    String expirationDate;
    String cvv;
    String cardHolderName;
    String billingAddress;
    List <Object> donationList;

    public DonationImpl() {
        System.out.println("Donation via Payment Gateway Credit Card");
        donationList = new ArrayList<>();
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod,
            String cardNumber, String expirationDate, String cvv, String cardHolderName, String billingAddress) {
        super(name, email, phone, amount, paymentMethod);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.cardHolderName = cardHolderName;
        this.billingAddress = billingAddress;
    }

    public void getDonation(){
        System.out.println(Arrays.asList(donationList));
    }

    public void addDonation() {
        donationList.add(new DonationImpl("Anisa", "anisa@jmail.com", "+62878 6654 3321", 2500000, "Credit Card",
                "1234567890123456", "11/25", "100", "Anisa", "Jl. Sudirman"));
        donationList.add(new DonationImpl("Dave", "dave@jmail.com", "+62828 2345 3091", 500000, "Credit Card",
                "2345678901234567", "12/26", "200", "Dave", "Jl. Gatot Subroto"));
        donationList.add(new DonationImpl("Edo", "edo@jmail.com", "+62828 2345 3091", 300000, "Credit Card",
                "3456789012345678", "13/27", "300", "Edo", "Jl. Diponegoro"));
    }

    public String toString() {
        return "- Donasi " + name + ": " + amount + " Payment Method: " + paymentMethod + " Card Number: " + cardNumber
                + " Expiration Date: " + expirationDate + " CVV: " + cvv + " Card Holder Name: " + cardHolderName
                + " Billing Address: " + billingAddress + "\n";
    }

}