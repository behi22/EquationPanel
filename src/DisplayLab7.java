import javax.swing.JFrame;

/**
 *         The class that displays the whole lab!
 *         @author bbabai00
 */
public class DisplayLab7 {
	/**
	 *         our main function that starts the program!
	 *         @author bbabai00
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Quadratic Equation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new EquationPanel());
		frame.pack();
		frame.setVisible(true);
	}
}