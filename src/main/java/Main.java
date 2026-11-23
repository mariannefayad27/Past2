import javax.swing.*;

public class Main {
    private static int seconds = 0;
    public static void main(String[] args) {
        //  HospitalInformation system = new HospitalInformation();
        //  don't need that because everything is static in HospitalInfo
        Hospital hospital = new Hospital();                 // 2-3. sensors created inside the container

        JFrame frame = new JFrame("Royal Free Hospital");   // 4. the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(hospital.buildGrid());
        frame.setSize(900, 400);
        frame.setVisible(true);

        hospital.run(); // loops forever, once per hospital hour
    }
}