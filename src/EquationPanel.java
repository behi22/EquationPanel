import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *         Our panel that shows on the frame.
 *         @author bbabai00
 */
public class EquationPanel extends JPanel {
	private JButton compute;
	private JLabel firstRoot, secondRoot, status, codeLabel1, codeLabel2;
	private JTextField firstRootField, secondRootField, statusField, codeField1, codeField2, codeField3;
	
	/**
	 *         Our panel's constructor.
	 *         @author bbabai00
	 */
	public EquationPanel() {
		// button
		compute = new JButton("Compute");
		compute.addActionListener(new ButtonListener());
				
		// labels
		firstRoot = new JLabel("First root:");
		secondRoot = new JLabel("Second root:");
		status = new JLabel("Status");
		codeLabel1 = new JLabel(" x^2 + ");
		codeLabel2 = new JLabel(" x + ");
				
		// text fields
		firstRootField = new JTextField("--");
		firstRootField.setEditable(false);
		
		secondRootField = new JTextField("--");
		secondRootField.setEditable(false);
		
		statusField = new JTextField("Waiting for data");
		statusField.setEditable(false);
		
		codeField1 = new JTextField(4);
		codeField1.addKeyListener(new EnterListener());
		codeField2 = new JTextField(4);
		codeField2.addKeyListener(new EnterListener());
		codeField3 = new JTextField(4);
		codeField3.addKeyListener(new EnterListener());
		
		// setting the outer panel
		JPanel organizer = new JPanel();
		organizer.setLayout(new BorderLayout());
		
		// the outer border
		TitledBorder tBorder = BorderFactory.createTitledBorder("Quadratic Equation Root Solver");
		tBorder.setTitleJustification(TitledBorder.LEFT);
		organizer.setBorder(tBorder);
		
		// first inner border
		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new GridLayout(3,2));
		TitledBorder firstInner = BorderFactory.createTitledBorder("Results");
		firstInner.setTitleJustification(TitledBorder.CENTER);
		firstPanel.setBorder(firstInner);
		firstPanel.add(firstRoot);
		firstPanel.add(firstRootField);
		firstPanel.add(secondRoot);
		firstPanel.add(secondRootField);
		firstPanel.add(status);
		firstPanel.add(statusField);
		organizer.add(firstPanel, BorderLayout.NORTH);
		
		// second inner border
		JPanel secondPanel = new JPanel();
		TitledBorder secondInner = BorderFactory.createTitledBorder("Enter Codefficients");
		secondInner.setTitleJustification(TitledBorder.CENTER);
		secondPanel.setBorder(secondInner);
		secondPanel.add(codeField1);
		secondPanel.add(codeLabel1);
		secondPanel.add(codeField2);
		secondPanel.add(codeLabel2);
		secondPanel.add(codeField3);
		secondPanel.add(compute);
		organizer.add(secondPanel, BorderLayout.SOUTH);
		
		add(organizer);
	}
	
	/**
	 *         class that handles the button when clicked.
	 *         @author bbabai00
	 */
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			double delta = 0, quad = 0, line = 0, cons = 0, root1, root2;
			quad = parseDouble(codeField1.getText());
			line = parseDouble(codeField2.getText());
			cons = parseDouble(codeField3.getText());
			// calculating the roots using delta
			delta = (line*line) - 4*(quad*cons);
			root1 = ((-1*line) + Math.sqrt(delta))/(2*quad);
			root2 = ((-1*line) - Math.sqrt(delta))/(2*quad);
			// up to 2 decimal places
			root1 = (int)(root1*100)/100.0;
			root2 = (int)(root2*100)/100.0;
			// showing the answer
			if(Double.isNaN(quad) || Double.isNaN(line) || Double.isNaN(cons)) {
				firstRootField.setText("--");
				secondRootField.setText("--");
				statusField.setText("Non-numeric data");
			} else if(quad == 0) {
				firstRootField.setText("--");
				secondRootField.setText("--");
				statusField.setText("NonZero value needed in x^2");
			} else if(delta == 0) {
				firstRootField.setText(root1 + "");
				secondRootField.setText(root2 + "");
				statusField.setText("Double roots");
			} else if(delta < 0) {
				firstRootField.setText("--");
				secondRootField.setText("--");
				statusField.setText("No real roots");
			} else {
				firstRootField.setText(root1 + "");
				secondRootField.setText(root2 + "");
				statusField.setText("Two unique roots");
			}
		}
	}
	
	/**
	 *         class that handles the button when the enter key is released.
	 *         @author bbabai00
	 */
	private class EnterListener implements KeyListener{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				double delta = 0, quad = 0, line = 0, cons = 0, root1, root2;
				quad = parseDouble(codeField1.getText());
				line = parseDouble(codeField2.getText());
				cons = parseDouble(codeField3.getText());
				// calculating the roots using delta
				delta = (line*line) - 4*(quad*cons);
				root1 = ((-1*line) + Math.sqrt(delta))/(2*quad);
				root2 = ((-1*line) - Math.sqrt(delta))/(2*quad);
				// up to 2 decimal places
				root1 = (int)(root1*100)/100.0;
				root2 = (int)(root2*100)/100.0;
				// showing the answer
				if(Double.isNaN(quad) || Double.isNaN(line) || Double.isNaN(cons)) {
					firstRootField.setText("--");
					secondRootField.setText("--");
					statusField.setText("Non-numeric data");
				} else if(quad == 0) {
					firstRootField.setText("--");
					secondRootField.setText("--");
					statusField.setText("NonZero value needed in x^2");
				} else if(delta == 0) {
					firstRootField.setText(root1 + "");
					secondRootField.setText(root2 + "");
					statusField.setText("Double roots");
				} else if(delta < 0) {
					firstRootField.setText("--");
					secondRootField.setText("--");
					statusField.setText("No real roots");
				} else {
					firstRootField.setText(root1 + "");
					secondRootField.setText(root2 + "");
					statusField.setText("Two unique roots");
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/**
	 *         function that handles non-numeric data.
	 *         @param s: a string representing a double number
	 *         @return a double number if its convertable
	 *         or NaN if it's not.
	 *         @author bbabai00
	 */
	private static double parseDouble(String s) {
		if(s == null) {
			return Double.NaN;
		}
		try {
			return Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}
}
