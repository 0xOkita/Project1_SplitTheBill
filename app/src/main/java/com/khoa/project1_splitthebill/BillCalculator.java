package com.khoa.project1_splitthebill;

public class BillCalculator {
    public enum TypeQualityOfService{
        EXCELLENT, AVERAGE, POOR;
    }
    private int NumPeople;
    private double NumBillAmount;
    private TypeQualityOfService myTypeQualityOfService;

    public void setBillAmount(double numBillAmount){
        if (numBillAmount > 0){
            NumBillAmount = numBillAmount;
        }
    }
    public void setNumPeople(int numPeople){
        if (numPeople > 0){
            NumPeople = numPeople;
        }
    }
    public void setTypeQualityOfService(TypeQualityOfService type){
        myTypeQualityOfService = type;
    }

    public double GetNumBillAmount(){
        return NumBillAmount;
    }
    public int GetNumPeople(){
        return NumPeople;
    }
    public TypeQualityOfService getTypeQualityOfService(){
        return myTypeQualityOfService;
    }


    public BillCalculator(double numBillAmount, int numPeople, TypeQualityOfService type){
        setBillAmount(numBillAmount);
        setNumPeople(numPeople);
        setTypeQualityOfService(type);
    }
    // Calculate Tip
    public double TipCalculate(){
        double percentOfService = 0;
        if(myTypeQualityOfService == TypeQualityOfService.EXCELLENT){
            percentOfService = 0.15;
        }else if(myTypeQualityOfService == TypeQualityOfService.AVERAGE){
            percentOfService = 0.1;
        }else if(myTypeQualityOfService == TypeQualityOfService.POOR){
            percentOfService = 0.05;
        }
        double tip = NumBillAmount/NumPeople*percentOfService;
        return roundNumber(tip,2);

    }

    // Calculate money for each person
    public double BillEachPerson(){
        double bill = NumBillAmount/(double)NumPeople;
        return roundNumber(bill,2);
    }

    // Custom function to round number's decimals
    public static double roundNumber(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
