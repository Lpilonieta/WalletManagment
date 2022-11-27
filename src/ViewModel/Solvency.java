package ViewModel;

public interface Solvency {
     float calcTotalIndebtedness();
     float calcShortIndebtedness();
     float calcLongIndebtedness();
     String statusTotalIndebtedness();
     String statusShortIndebtedness();
     String statusLongIndebtedness();
}
