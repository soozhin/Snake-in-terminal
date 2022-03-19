import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener {

    /*
     * DELAY = 50 -> delay 50ms -> FPS = 20Hz
     */
    private static final int DELAY = 50;
    private Model model;
    private Timer timer;

    public Controller(Model model) {
        this.model = model;
        this.timer = new Timer(DELAY, this);
    }

    /*
     * Start timer and delay 50ms, 20Hz
     * Read key input
     * TODO
     * Why here no addActionListener? Should we add one?
     * actionPerformed is invoked automatically every 50ms after timer.start()
     */
    public void run() throws IOException {
        timer.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            model.process(line.toLowerCase());
        }
    }

    /*
     * Run process even when there is no input
     * For time event 時間経過と共に発生するイベント
     */
    @Override
    public void actionPerformed(ActionEvent e) {  
        model.process("TIME_ELAPSED");
    }

}
