import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ContarVocales implements WindowListener, ActionListener		
{
	String cadena;
	int contador = 0;
	Frame ventana = new Frame("Número de vocales");
	Label lblIntro = new Label("Introduce una oración:");
	TextField txt = new TextField(30);
	Button btn = new Button("Contar vocales");
	TextField txtResultado = new TextField(30);
	
	public ContarVocales() {
		ventana.setLayout(new FlowLayout());
		ventana.add(lblIntro);
		ventana.add(txt);
		txt.requestFocus();
		btn.addActionListener(this);
		ventana.add(btn);
		ventana.add(txtResultado);
		
		ventana.setSize(350,200);
		ventana.setLocationRelativeTo(null);
		ventana.addWindowListener(this);
		ventana.setVisible(true);
	}
	
	//Main
	public static void main(String[] args)
	{
		new ContarVocales();
	}

	//Método que cuenta el número de vocales
	private static int numeroVocales(String cadena, int contador)
	{
		for (int i = 0; i < cadena.length(); i++) {
			char letra = cadena.charAt(i);
			if(letra=='a'||letra=='e'||letra=='i'||letra=='o'||letra=='u') {
				contador++;
			}
		}
		return contador;
	}

	//Metodo que se ejecuta al presionar el botón
	public void actionPerformed(ActionEvent ae)
	{
		//Toma el texto ingresado, contamos vocales mediante formula y agregamos el texto en el TextField vacío.
		cadena = txt.getText();
		contador = numeroVocales(cadena, contador);
		txtResultado.setText("La oración ingresada tiene "+Integer.toString(contador) + " vocales.");
	}
	
	//Metodos del Windows Listener
	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0){
			System.exit(0);
		}
	public void windowDeactivated(WindowEvent arg0){}
	public void windowDeiconified(WindowEvent arg0){}
	public void windowIconified(WindowEvent arg0){}
	public void windowOpened(WindowEvent arg0){}
	
}
