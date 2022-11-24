package ViewModel.Components.DailyRecord;

public class DailyRecordComponent {

    private DailyRecordTemplate dailyRecordTemplate;


    public DailyRecordComponent (){

        this.dailyRecordTemplate = new DailyRecordTemplate(this);
    }

    public DailyRecordTemplate getDailyRecordTemplate() {
        return dailyRecordTemplate;
    }
}
