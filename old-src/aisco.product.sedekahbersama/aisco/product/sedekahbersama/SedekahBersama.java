package aisco.product.sedekahbersama;

import aisco.donation.DonationFactory;
import aisco.donation.core.Donation;
import aisco.financialreport.FinancialReportFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.income.FinancialReportImpl;
import aisco.program.ProgramFactory;
import aisco.program.core.Program;
import java.util.ArrayList;
import java.util.List;

public class SedekahBersama {
  private static final int INDEX_DISASTER = 0;
  
  private static final int INDEX_MEDICINE = 1;
  
  private static FinancialReport income1;
  
  public static List<Program> addProgram() {
    System.out.println("\n Programs: ");
    ArrayList<Program> arrayList = new ArrayList();
    Program program1 = ProgramFactory.createProgram("aisco.program.activity.ProgramImpl", new Object[] { Integer.valueOf(1), "Flood in Bogor", "Helping flood victims", "100 families", "Fast Furious", "https://www.hilfe.splelive.id/logohilfe" });
    Program program2 = ProgramFactory.createProgram("aisco.program.activity.ProgramImpl", new Object[] { Integer.valueOf(2), "Free Medicine", "Free treatment and medicine for poor people", "50 persons", "Healthy Clinic", "https://www.hilfe.splelive.id/logopengobatan" });
    arrayList.add(0, program1);
    arrayList.add(1, program2);
    return arrayList;
  }
  
  public static List<FinancialReport> addIncome(List<Program> paramList) {
    ArrayList<FinancialReport> arrayList = new ArrayList();
    income1 = FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl", new Object[] { FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", new Object[] { "1", "23-11-2019", Integer.valueOf(1000000), "Donation Nadia", paramList.get(0), "42010" }), "Transfer" });
    arrayList.add(income1);
    arrayList.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl", new Object[] { FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", new Object[] { "2", "25-11-2019", Integer.valueOf(800000), "Donation Lentera", paramList.get(1), "42010" }), "Cash" }));
    arrayList.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl", new Object[] { FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", new Object[] { "3", "29-11-2019", Integer.valueOf(5000000), "Fundraising Mitra University", paramList.get(0), "42000" }), "Transfer" }));
    return arrayList;
  }
  
  public static void addDonation() {
    Donation donation = DonationFactory.createDonation("aisco.donation.creditcard.DonationImpl", new Object[0]);
    donation.addDonation();
    donation.getDonation();
  }
  
  public static void main(String[] paramArrayOfString) {
    System.out.println("Product Sedekah Bersama");
    List<Program> list = addProgram();
    System.out.println(list);
    List<FinancialReport> list1 = addIncome(list);
    income1.printHeader();
    System.out.println(list1);
    int i = ((FinancialReportImpl)income1).total(list1);
    addDonation();
    System.out.println("Balance: " + i);
  }
}