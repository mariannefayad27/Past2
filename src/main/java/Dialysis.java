public class Dialysis extends Service {
    public Dialysis(String bay) {
        //always reput in constructors parameter the one of super
        super(bay);
    }

    @Override
    public String getServiceName() {
// cant call it however it want it needs to match the way they coded it,
// which can always be found in the instructions
        return "Dialysis";
    }

    @Override
    public int getActionDuration() {
        return 4;
    }
}
