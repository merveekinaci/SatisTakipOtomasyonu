package test;
import javax.swing.SwingUtilities;

import frontend.Login;
import test.dao.UrunlerDao;
import test.frontend.AnaPencere;
import test.frontend.Login;

public class Run {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Login();
            }
        });
    }
}
