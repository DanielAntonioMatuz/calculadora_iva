import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CalculadoraIva extends JFrame implements ActionListener{

    private JLabel mensaje;
    private JLabel mensaje2;
    private JButton boton;
    private JTextField caja,caja2;
    private JComboBox iva;
    private String selectIva = "16";

    
    public CalculadoraIva(){
        super();
        configurarVentana();
        crearComponente();
    }
    
    private void configurarVentana(){
        this.setTitle("Calculadora de IVA");
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new java.awt.Color(130,224,170));
    }
    
    private void crearComponente(){
        mensaje = new JLabel();
        mensaje.setText("Cantidad ( $ ):");
        mensaje.setBounds(50, 50, 200, 60);
        mensaje.setForeground(Color.black);
        this.add(mensaje);
        
        mensaje2 = new JLabel();
        mensaje2.setText("I V A :");
        mensaje2.setBounds(250, 50, 200, 60);
        mensaje2.setForeground(Color.black);
        this.add(mensaje2);
        
        boton = new JButton();
        boton.setText("Calcular IVA");
        boton.setBounds(50, 130, 175, 25);
        boton.addActionListener(this);
        this.add(boton);
       
        caja = new JTextField();
        caja.setBounds(130,70,100,30);
        this.add(caja);
        
        String [] ivaList = new String[] {"16","8"};
        JComboBox<String> iva = new JComboBox<>(ivaList);
        iva.setBounds(290,70,100,30);
        iva.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectIva = iva.getItemAt(iva.getSelectedIndex());
        		System.out.println("El valor de iva es: " + selectIva);
        	}
        });
        this.add(iva);
        
       /* caja2 = new JTextField();
        caja2.setBounds(290,70,100,30);
        this.add(caja2); */

    }
 
    
    @Override
    public void actionPerformed(ActionEvent e){

        String resultado = caja.getText();  
        String resultado2 = selectIva;
        Calcular(resultado, resultado2);
	
    }
    
    public void Calcular(String resultado,String resultado2) {
    	float cantidad = Float.parseFloat(resultado);
    	 float iva = Float.parseFloat(resultado2); 
         float resultadoIva = (cantidad * iva/100) + cantidad;
         String resultadoTotal = Float.toString(resultadoIva);
         JOptionPane.showMessageDialog(this, "El valor es: " + resultadoTotal);
    }
    
    
    
    public static void main(String[] args){
        CalculadoraIva ventana = new CalculadoraIva();
        ventana.setVisible(true);
    }
    
}