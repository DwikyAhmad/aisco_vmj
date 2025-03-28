package aisco.donation.ewallet;

import aisco.donation.core.DonationComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DonationImpl extends DonationComponent {
    String walletId;
    String userId;
    String securityToken;
    String walletType;
    List <Object> donationList;

    public DonationImpl() {
        System.out.println("Donation via Payment Gateway Ewallet");
        donationList = new ArrayList<>();
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod,
            String walletId, String userId, String securityToken, String walletType) {
        super(name, email, phone, amount, paymentMethod);
        this.walletId = walletId;
        this.userId = userId;
        this.securityToken = securityToken;
        this.walletType = walletType;
    }

    public void getDonation(){
        System.out.println(Arrays.asList(donationList));
    }

    public void addDonation() {
        donationList.add(new DonationImpl("Anisa", "anisa@jmail.com", "+62878 6654 3321", 2500000, "Ewallet",
                "1", "11", "100", "Gopay"));
        donationList.add(new DonationImpl("Dave", "dave@jmail.com", "+62828 2345 3091", 500000, "Ewallet",
                "2", "12", "200", "Dana"));
        donationList.add(new DonationImpl("Edo", "edo@jmail.com", "+62828 2345 3091", 300000, "Ewallet",
                "3", "13", "300", "ShopeePay"));
    }

    public String toString() {
        return "- Donasi " + name + ": " + amount + " Payment Method: " + paymentMethod + " Wallet ID: " + walletId
                + " User ID: " + userId + " Security Token: " + securityToken + " Wallet Type: " + walletType + "\n";
    }

}