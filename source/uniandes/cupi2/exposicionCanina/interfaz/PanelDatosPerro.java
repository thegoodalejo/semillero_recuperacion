package uniandes.cupi2.exposicionCanina.interfaz;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.exposicionCanina.mundo.*;

/**
 * Es el panel donde se muestran los datos de un perro
 */
public class PanelDatosPerro extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Esta constante indica la altura que debe tener la imagen de un individuo
     */
    private static final int ALTURA = 200;

    /**
     * Esta constante indica el ancho que debe tener la imagen de un individuo
     */
    private static final int ANCHO = 200;
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la etiqueta donde se muestra la imagen del perro
     */
    private JLabel etiquetaImagen;

    /**
     * Es la etiqueta para el nombre del perro
     */
    private JLabel etiquetaNombre;

    /**
     * Es la etiqueta para la raza del perro
     */
    private JLabel etiquetaRaza;

    /**
     * Es la etiqueta donde se muestra los puntos del perro
     */
    private JLabel etiquetaPuntos;

    /**
     * Es la etiqueeta para la edad del perro
     */
    private JLabel etiquetaEdad;

    /**
     * Es el campo para el nombre del perro
     */
    private JTextField txtNombre;

    /**
     * Es el campo para la raza del perro
     */
    private JTextField txtRaza;

    /**
     * Es el campo para la edad del perro
     */
    private JTextField txtEdad;

    /**
     * Es el campo para la altura del perro
     */
    private JTextField txtAltura;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes.
     */
    public PanelDatosPerro( )
    {
        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Datos Perro" ) ) );

        JPanel panelImagen = new JPanel( );
        etiquetaImagen = new JLabel( );
        etiquetaImagen.setBorder( new LineBorder( Color.BLACK, 1 ) );
        etiquetaImagen.setMinimumSize( new Dimension( 230, 153 ) );
        etiquetaImagen.setMaximumSize( new Dimension( 230, 153 ) );

        panelImagen.add( etiquetaImagen );
        add( panelImagen, BorderLayout.CENTER );

        JPanel panelDatosTexto = new JPanel( new GridLayout( 2, 4 ) );

        etiquetaNombre = new JLabel( "Nombre: " );
        txtNombre = new JTextField( );
        txtNombre.setEnabled( false );
        txtNombre.setDisabledTextColor(getForeground());
        panelDatosTexto.add( etiquetaNombre );
        panelDatosTexto.add( txtNombre );

        etiquetaRaza = new JLabel( "Raza: " );
        etiquetaRaza.setBorder( new EmptyBorder( 0, 5, 0, 0 ) );
        txtRaza = new JTextField( );
        txtRaza.setEnabled( false );
        txtRaza.setDisabledTextColor(getForeground());
        panelDatosTexto.add( etiquetaRaza );
        panelDatosTexto.add( txtRaza );

        etiquetaEdad = new JLabel( "Edad: " );
        txtEdad = new JTextField( );
        txtEdad.setEnabled( false );
        txtEdad.setDisabledTextColor(getForeground());
        panelDatosTexto.add( etiquetaEdad );
        panelDatosTexto.add( txtEdad );

        etiquetaPuntos = new JLabel( "Puntos: " );
        etiquetaPuntos.setBorder( new EmptyBorder( 0, 5, 0, 0 ) );
        txtAltura = new JTextField( );
        txtAltura.setEnabled( false );
        txtAltura.setDisabledTextColor(getForeground());
        panelDatosTexto.add( etiquetaPuntos );
        panelDatosTexto.add( txtAltura );

        add( panelDatosTexto, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Muestra los datos del perro en los campos.
     * @param perro es el perro del que se quieren mostrar los datos - perro!= null
     */
    public void mostrarDatos( Perro perro )
    {
        try
        {
            String imagen = perro.darImagen( );
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );
            Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            etiquetaImagen.setIcon( new ImageIcon( laImagen ) );

            txtNombre.setText( perro.darNombre( ) );
            txtRaza.setText( perro.darRaza( ) );
            txtAltura.setText( "" + perro.darPuntos( ) );
            txtEdad.setText( "" + perro.darEdad( ) + " meses" );

            validate( );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog(this, "Error al cargar la imagen del perro "+perro.darNombre(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Limpia todos los campos.
     */
    public void limpiarDatos( )
    {
        etiquetaImagen.setIcon( null );
        txtNombre.setText( "" );
        txtRaza.setText( "" );
        txtAltura.setText( "" );
        txtEdad.setText( "" );
    }
}