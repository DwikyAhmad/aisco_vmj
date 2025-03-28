package aisco.product.kebaikannusantara;

import aisco.program.ProgramFactory;
import aisco.program.core.Program;
import aisco.financialreport.FinancialReportFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.donation.DonationFactory;
import aisco.donation.core.Donation;

import java.util.ArrayList;
import java.util.List;

public class KebaikanNusantara {
    private static final int INDEX_GIFTS = 0;
    private static final int INDEX_ORPH = 1;

    private static FinancialReport income2;
    private static FinancialReport expense1;

    public static List<Program> addProgram()
    {   
        List<Program> programs = new ArrayList<>();
        Program sharegifts = ProgramFactory.createProgram("aisco.program.operational.ProgramImpl",1, "Share Gifts", "Sharing gifts to slum area", "50 persons");
        Program orphanagecompetition = ProgramFactory.createProgram("aisco.program.operational.ProgramImpl",2, "Orphanage Competition", "Competition of Orphanage in Karawang", "30 orphanages");
        programs.add(INDEX_GIFTS, sharegifts);
        programs.add(INDEX_ORPH, orphanagecompetition);
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs)
    { 
        List<FinancialReport> incomes = new ArrayList<>();
        FinancialReport core1 = FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","1", "12-11-2019", 2500000, "Donation from Society", programs.get(INDEX_GIFTS), "11000");
        FinancialReport income1 = FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl", core1, "Cash");
        incomes.add(income1);

        income2= FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl",
        FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","2", "13-11-2019",
            300000, "Donation Raden", programs.get(INDEX_ORPH), "11000"), "Transfer");
        incomes.add(income2);
        incomes.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl",
        FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","3", "14-11-2019",
        500000, "Donation Anonim", programs.get(INDEX_GIFTS), "110"), "Transfer"));

        return incomes;
    }   

    public static void addDonation()
    {  
        Donation donate = DonationFactory.createDonation("aisco.donation.creditcard.DonationImpl");
        donate.addDonation();
        donate.getDonation();
    }

    public static void main(String[] args) {
        System.out.println("Product Kebaikan Nusantara");

        List<Program> programs = addProgram();
        System.out.println(programs);

        List<FinancialReport> incomes = addIncome(programs);
        income2.printHeader();
        System.out.println(incomes);
        int totalincome = income2.total(incomes);
        
        addDonation();
        System.out.println("Balance: "+totalincome);
    
    }
}
