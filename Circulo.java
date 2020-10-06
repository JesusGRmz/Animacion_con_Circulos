
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circulo {
    //Coordenadas
    private int coordenada_x, coordenada_y;
    
    //tamaño
    private int radio;
    
    //instancia de color
    private Color color;
    
    //Sentido en que se mueve
    private int sentido;
    
    //Sentido posibles
    private final int  ARRIBA = 1;
    private final int  DERECHA_ARRIBA = 2;
    private final int  DERECHA = 3;
    private final int  DERECHA_ABAJO = 4;
    private final int  ABAJO = 5;
    private final int  IZQUIERDA_ABAJO = 6;
    private final int  IZQUIERDA = 7;
    private final int  IZQUIERDA_ARRIBA = 8;
    
    //velocidad
    private int velocidad;
    
    //margenes de la ventana
    private int minimo_x, minimo_y, Maximo_x, Maximo_y;
    
    // Objeto
    private Random random;

    public Circulo(int alto, int ancho, int radio, int velocidad) {
    random = new Random();
    color = new Color(random.nextInt(255), 
                      random.nextInt(255), 
                      random.nextInt(255));    
    
    //definir coordenada iniciales
    this.coordenada_x = this.random.nextInt(ancho-radio);
    this.coordenada_y = this.random.nextInt(alto-radio);
    
    //definir el radio
    this.radio = radio;
    
    //definir el sentido
    this.sentido = 1 + random.nextInt(8);
    
    //Definir velocidad
    this.velocidad = velocidad;
    
    //definir coordenadas minimas
    this.minimo_x = 0;
    this.minimo_y = 0;
    
    //definir coordenadas maximas
    this.Maximo_x = ancho;
    this.Maximo_y = alto;
    }            
    
    public void dibujar(Graphics graphics){
        graphics.setColor(this.color);
        graphics.fillOval(
                this.coordenada_x, 
                this.coordenada_y, 
                this.radio, 
                this.radio);        
    }
    
    public void animar(){
        // siguientes coordenadas positivas
        int x_positiva = this.coordenada_x + this.velocidad;
        int y_positiva = this.coordenada_y + this.velocidad;
        
        // siguientes coordenadas negativas
        int x_negativa = this.coordenada_x - this.velocidad;
        int y_negativa = this.coordenada_y - this.velocidad;
    
        //logica para determinar colisiones y sentido
        switch (this.sentido) {
            case ARRIBA:   
                if (y_negativa > this.minimo_y) {
                   this.coordenada_y = y_negativa;
                }else{
                    int sentiodo_temp = 1 + random.nextInt(3);
                    switch (sentiodo_temp) {
                        case 1: this.sentido = IZQUIERDA_ABAJO; break;                            
                        case 2: this.sentido = ABAJO; break;                            
                        case 3: this.sentido = DERECHA_ABAJO; break;                                                                             
                    }
                    //this.sentido = 1 + random.nextInt(8);
                }
                break;
            case DERECHA_ARRIBA:      
                if ((x_positiva < this.Maximo_x-30) && (y_negativa > this.minimo_y-35)) {
                    this.coordenada_x = x_positiva;
                    this.coordenada_y = y_negativa;
                }else{
                    int sentiodo_temp = 1 + random.nextInt(3);
                    switch (sentiodo_temp) {
                        case 1: this.sentido = IZQUIERDA_ABAJO; break;                            
                        case 2: this.sentido = ABAJO; break;                            
                        case 3: this.sentido = IZQUIERDA; break;                                                                             
                    }
                    //this.sentido = 1 + random.nextInt(8);
                }
                break;
            case DERECHA:                
                if (x_positiva < this.Maximo_x) {
                    this.coordenada_x = x_positiva;
                }else{
                    int sentiodo_temp = 1 + random.nextInt(3);
                    switch (sentiodo_temp) {
                        case 1: this.sentido = IZQUIERDA_ARRIBA; break;                            
                        case 2: this.sentido = IZQUIERDA; break;                            
                        case 3: this.sentido = IZQUIERDA_ABAJO; break;                                                                             
                    }
                    //this.sentido = 1 + random.nextInt(8);
                }
                break;
            case DERECHA_ABAJO:                
                if ((x_positiva < this.Maximo_x) && (y_positiva < this.Maximo_y)) {
                    this.coordenada_x = x_positiva;
                    this.coordenada_y = y_positiva;
                } else {
                    int sentiodo_temp = 1 + random.nextInt(3);
                    switch (sentiodo_temp) {
                        case 1: this.sentido = ARRIBA; break;                            
                        case 2: this.sentido = IZQUIERDA_ARRIBA; break;                            
                        case 3: this.sentido = IZQUIERDA; break;                                                                             
                    }
                    //this.sentido = 1 + random.nextInt(8);
                }
                break;
            case ABAJO: 
                if (y_positiva < this.Maximo_y) {
                    this.coordenada_y = y_positiva;
                }else{
                    int sentiodo_temp = 1 + random.nextInt(3);
                    switch (sentiodo_temp) {
                        case 1: this.sentido = DERECHA_ARRIBA; break;                            
                        case 2: this.sentido = ARRIBA; break;                            
                        case 3: this.sentido = IZQUIERDA_ARRIBA; break;                                                                             
                    }
                   //this.sentido = 1 + random.nextInt(8); 
                }
                break;
            case IZQUIERDA_ABAJO: 
                //(y_positiva < this.Maximo_y) && (x_negativa > minimo_y))
                if ((y_positiva < this.Maximo_y)&&(x_negativa < this.Maximo_x)) {
                    this.coordenada_x = x_negativa;
                    this.coordenada_y = y_positiva;
                } else {
                    int sentiodo_temp = 1 + random.nextInt(3);
                    switch (sentiodo_temp) {
                        case 1: this.sentido = ARRIBA; break;                            
                        case 2: this.sentido = DERECHA_ARRIBA; break;                            
                        case 3: this.sentido = DERECHA; break;                                                                             
                    }
                    //this.sentido = 1 + random.nextInt(8); 
                }
                break;
            case IZQUIERDA: 
                if (x_negativa > this.minimo_x) {
                    this.coordenada_x = x_negativa;
                } else {
                    int sentiodo_temp = 1 + random.nextInt(3);
                    switch (sentiodo_temp) {
                        case 1: this.sentido = DERECHA_ARRIBA; break;                            
                        case 2: this.sentido = DERECHA; break;                            
                        case 3: this.sentido = DERECHA_ABAJO; break;                                                                             
                    }
                    //this.sentido = 1 + random.nextInt(8);
                }
                break;
            case IZQUIERDA_ARRIBA: 
                if ((y_negativa > minimo_y)&&(x_negativa > minimo_x)) {
                    this.coordenada_y = y_negativa;
                    this.coordenada_x = x_negativa;
                } else {
                    int sentiodo_temp = 1 + random.nextInt(3);
                    switch (sentiodo_temp) {
                        case 1: this.sentido = DERECHA; break;                            
                        case 2: this.sentido = DERECHA_ABAJO; break;                            
                        case 3: this.sentido = ABAJO; break;                                                                             
                    }
                    //this.sentido = 1 + random.nextInt(8); 
                }
                break;
            default:                
        }
    }
}
