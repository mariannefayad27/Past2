public class ECG extends Service {
    public ECG(String bay) {
        //always reput in constructors parameter the one of super
        super(bay);
    }

    @Override
    public String getServiceName() {
// cant call it however it want it needs to match the way they coded it,
// which can always be found in the instructions
        return "ECG";
    }

    @Override
    public int getActionDuration() {
        return 1;
    }
}
