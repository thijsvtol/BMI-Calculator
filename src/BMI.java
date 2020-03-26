import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class BMI extends Applet implements ActionListener{
	//Properties
	private double Gewicht;
	private double Lengte;
	private double BMI;
	private String[] Geslacht = {"Man", "Vrouw"};

	//Objects
	private TextField tfGewicht,tfLengte;
	private Button btnConfirm = new Button("Bereken BMI");
	private Label lblGewicht,lblLengte,lblGeslacht,lblUitkomstBMI,lblUitkomstType;
	private Choice cbGeslacht = new Choice();
	private Panel pnl = new Panel();
	
	public void init()
    {
		//Set Objects
        lblGewicht = new Label("Gewicht (kg): ");
        lblLengte = new Label("Lengte (m): ");
        lblGeslacht = new Label("Geslacht: ");
        lblUitkomstBMI = new Label();
        lblUitkomstType = new Label();
        tfGewicht = new TextField();
        tfLengte = new TextField();
        
        //Vul choicel
        VulGeslachtsKeuze();
        
        //Voeg Objecten toe aan panel
        add(pnl);
        pnl.add(lblGewicht);
        pnl.add(tfGewicht);
        pnl.add(lblLengte);
        pnl.add(tfLengte);
        pnl.add(lblGeslacht);
        pnl.add(cbGeslacht);
        pnl.add(btnConfirm);
        pnl.add(lblUitkomstBMI);
        pnl.add(lblUitkomstType);
        
        //Events
        btnConfirm.addActionListener(this);
    }
	
	//Bereken BMI en set uitkomst
	public void actionPerformed(ActionEvent e){
		Gewicht = Double.parseDouble(tfGewicht.getText());
		Lengte = Double.parseDouble(tfLengte.getText());
		BMI = Gewicht / (Math.pow(Lengte, 2));
		lblUitkomstBMI.setText(String.valueOf(BMI));
		BerekenRisicoFactor();
	}
	
	private void VulGeslachtsKeuze() {
		for (String gender : Geslacht) {
			cbGeslacht.add(gender);
		}
	}
	
	private void BerekenRisicoFactor() {
		String uitvoer = "";
		
		//Bepaal welk geslacht de gebruiker is
		switch (cbGeslacht.getSelectedItem()) {
		case "Man":
			//Bepaal welke BMI waarde bij welke type hoort
			if (BMI < 20.7)
				uitvoer = "Te laag. Hoe lager uw BMI, hoe groter het risico!";
			else if (BMI >= 20.7 && BMI <= 26.4)
				uitvoer = "Normaal, laagste risico!";
			else if (BMI > 26.4 && BMI <= 27.8 )
				uitvoer = "Enigszins te zwaar, enig risico!";
			else if (BMI > 27.8 && BMI <= 31.1)
				uitvoer = "Overgewicht, riskant!";
			else if (BMI > 31.1 && BMI <= 45.4)
				uitvoer = "Zwaar overgewicht, hoog risico!";
			else if (BMI > 45.4)
				uitvoer = "Morbide obesitas, zeer hoog risico!";
			break;
		case "Vrouw":
			//Bepaal welke BMI waarde bij welke type hoort
			if (BMI < 19.1)
				uitvoer = "Te laag. Hoe lager uw BMI, hoe groter het risico!";
			else if (BMI >= 19.1 && BMI <= 25.8)
				uitvoer = "Normaal, laagste risico!";
			else if (BMI > 25.8 && BMI <= 27.3 )
				uitvoer = "Enigszins te zwaar, enig risico!";
			else if (BMI > 27.3 && BMI <= 32.2)
				uitvoer = "Overgewicht, riskant!";
			else if (BMI > 32.2 && BMI <= 44.8)
				uitvoer = "Zwaar overgewicht, hoog risico!";
			else if (BMI > 44.8)
				uitvoer = "Morbide obesitas, zeer hoog risico!";
			break;
		default:
			break;
		}
		lblUitkomstType.setText(uitvoer);
	}
}
