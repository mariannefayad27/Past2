import Notifications.HospitalInformation;

public abstract class Service {
    private String bay;
    private final int neverStarted=-1000;
    private int startedHour=neverStarted;
    // instead of creating a field to use HospitalInformation methods just call it directly
    // because it's methods are static so can call class.static_method unlike getService() in MedicalNotification

    public Service(String bay) {
        this.bay=bay;
    }

    public abstract String getServiceName();
    public abstract int getActionDuration();


// always make sure that it's diff methods for each subclass, if not it goes in abstract as below:
    public String getBayName() {
        return bay;
    }

    public void deploy(String newBay) {
        if(actionDone()){
            HospitalInformation.requestPorter(newBay, getServiceName());
            startedHour=HospitalInformation.getHourCount();
            bay= newBay;
        }
    }

    // Is the action over?
    public boolean actionDone() {
        return (HospitalInformation.getHourCount() - startedHour) >= getActionDuration();
    }

    public String getStatus() {
        return actionDone() ? "Inactive" : "Active";
    }
}
