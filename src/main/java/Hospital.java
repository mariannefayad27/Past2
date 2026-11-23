import Notifications.HospitalInformation;
import Notifications.MedicalNotification;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private final List<Service> services = new ArrayList<>();
    private final List<JLabel> labels = new ArrayList<>();

    public Hospital() {
        services.add(new Ultrasound("Nightingale"));
        services.add(new ECG("Seacole"));
        services.add(new Masseur("Seacole"));
        services.add(new Dialysis("Henderson"));
    }

    public JPanel buildGrid() {
        JPanel grid = new JPanel(new GridLayout(2, 4));    // TODO: rows x cols >= number of items
        for (String bay : HospitalInformation.bays) {
            JLabel label = new JLabel("", SwingConstants.CENTER);
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            panel.add(label, BorderLayout.CENTER);
            labels.add(label);
            grid.add(panel);
        }
        return grid;
    }

    public void updateAll() {
        for (int i = 0; i < HospitalInformation.bays.length; i++) {      // CHANGED: services.size() → bays.length
            String bay = HospitalInformation.bays[i];                    // CHANGED: was Service s = services.get(i);
            String text = "";                                            // ADDED

            for (Service s : services) {                                 // ADDED
                if (s.getBayName().equals(bay)) {                        // ADDED
                    text += "<br>" + s.describe();                       // ADDED
                }                                                        // ADDED
            }                                                            // ADDED

            labels.get(i).setText("<html><center>" + bay + text + "</center></html>");   // CHANGED: s.describe() → bay + text
        }
    }

    public void log() {
        if (HospitalInformation.getHourCount()>0 && HospitalInformation.getHourCount()%24==0) {
            System.out.println("Status:");
            for (Service s : services) {
                System.out.println(s.describe() + " in " + s.getBayName());
            }
        }
    }

    public void run(){
        MedicalNotification notif= HospitalInformation.getMedicalNotificationFromDoctor();

    }
}