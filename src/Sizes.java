import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Sizes extends Applet implements ActionListener{
	
	//Arrays voor maten
	private int[] inch = {27,28,29,30,31,32,33,34,36,38,40,42}; //array voor inches
	private int[] maatMannenEU = {43,44,45,46,47,48,49,50,52,54,56,58}; //array voor maat EU Mannen
	private int[] maatVrouwenEU = {34,36,0,38,0,40,0,42,44,46,48,50}; //array voor maat EU Vrouw
	private String[] maatMannenLetter = {null,null,"S",null,"M",null,"L",null,"XL","XXL",null,null}; //array voor maat in letter mannen
	private String[] maatVrouwenLetter = {null,null,"S",null,"M",null,"L",null,"XL","XXL",null,null}; //array voor maat in letter vrouwen

	//Objecten voor panel
	private TextField tfSelectInput,tfSelectOutput;
	private Button btnConfirm = new Button("Reken om!");
	private Label lblInput,lblOutput;
	private Choice cbInputSize,cbOutputSize;
	private Panel pnl = new Panel();
	
	
	public void init()
    {
		//Set objecten
		tfSelectInput = new TextField();
		tfSelectOutput = new TextField();
		lblInput = new Label("Selecteer optie:");
		lblOutput = new Label("NAAR-->  Selecteer optie:");
		cbInputSize = new Choice();
		cbOutputSize = new Choice();
		
		//Vul Choice boxen
		FillChoices();
		
		//Voeg objecten toe aan panel
		add(pnl);
		pnl.add(lblInput);
		pnl.add(cbInputSize);
		pnl.add(tfSelectInput);
		pnl.add(lblOutput);
		pnl.add(cbOutputSize);
		pnl.add(tfSelectOutput);
		pnl.add(btnConfirm);
		
		//Voer actie uit wanneer er op button wordt geklikt
		btnConfirm.addActionListener(this);
    }
	
	private void FillChoices() {
		// TODO Auto-generated method stub
		cbInputSize.add("Inch");
		cbInputSize.add("Man EU");
		cbInputSize.add("Vrouw EU");
		cbInputSize.add("Man S/M/L/XL/XXL");
		cbInputSize.add("Vrouw S/M/L/XL/XXL");
		
		cbOutputSize.add("Inch");
		cbOutputSize.add("Man EU");
		cbOutputSize.add("Vrouw EU");
		cbOutputSize.add("Man S/M/L/XL/XXL");
		cbOutputSize.add("Vrouw S/M/L/XL/XXL");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CalculateSize();
	}

	private void CalculateSize() {
		// TODO Auto-generated method stub
		for (int i = 0; i < inch.length; i++) {
			if (cbInputSize.getSelectedItem() == "Inch") {
				if (inch[i] == Integer.parseInt(tfSelectInput.getText()))
					DecideOutput(i);
			}
			else if (cbInputSize.getSelectedItem() == "Man EU") {
				if (maatMannenEU[i] == Integer.parseInt(tfSelectInput.getText()))
					DecideOutput(i);
			}
			else if (cbInputSize.getSelectedItem() == "Vrouw EU") {
				if (maatVrouwenEU[i] == Integer.parseInt(tfSelectInput.getText()))
					DecideOutput(i);
			}
			else if (cbInputSize.getSelectedItem() == "Man S/M/L/XL/XXL") {
				if (maatMannenLetter[i] == tfSelectInput.getText())
					DecideOutput(i);
			}
			else if (cbInputSize.getSelectedItem() == "Vrouw S/M/L/XL/XXL") {
				if (maatVrouwenLetter[i] == tfSelectInput.getText())
					DecideOutput(i);
			}
		}
	}

	private void DecideOutput(int i) {
		// TODO Auto-generated method stub
		if (cbOutputSize.getSelectedItem() == "Inch")
    		tfSelectOutput.setText(String.valueOf(inch[i]));
    	else if (cbOutputSize.getSelectedItem() == "Man EU")
    		tfSelectOutput.setText(String.valueOf(maatMannenEU[i]));
    	else if (cbOutputSize.getSelectedItem() == "Vrouw EU")
    		tfSelectOutput.setText(String.valueOf(maatVrouwenEU[i]));
    	else if (cbOutputSize.getSelectedItem() == "Man S/M/L/XL/XXL")
    		tfSelectOutput.setText(maatMannenLetter[i]);
    	else if (cbOutputSize.getSelectedItem() == "Vrouw S/M/L/XL/XXL")
    		tfSelectOutput.setText(maatVrouwenLetter[i]);
	}
}
