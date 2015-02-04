/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

/**
 *
 * @author Pablo PC
 */
public class Armeria extends Estructura implements Runnable
{
    Thread producir;
    int cantAcero = 0;
    String tipoArma = null;

    public Armeria(String nTipo, int Acero,String pTipoArma) 
    {
        super(nTipo);
        cantAcero = Acero;
        tipoArma = pTipoArma;
        producir = new Thread(this);
        producir.start();
    }
    
    @Override
    public void run()
    {
        while (true)
        {
            if(JuegoGato.acero>=cantAcero)
            {
                if(tipoArma == "misil")
                {
                    int temporalCantidad = JuegoGato.getMisiles();
                    temporalCantidad++;
                    System.out.println("he producido un misil");
                    JuegoGato.acero  = JuegoGato.acero - 500;
                   
                    System.out.println("soy acero del juego" + JuegoGato.acero );
                    JuegoGato.setMisiles(temporalCantidad);
                }                
                if(tipoArma == "multi")
                {
                    int temporalCantidad = JuegoGato.getMultis();
                    temporalCantidad++;
                    JuegoGato.acero  = JuegoGato.acero - 1000;
                    JuegoGato.setMultis(temporalCantidad);
                }
                if(tipoArma == "bombas")
                {
                    int temporalCantidad = JuegoGato.getBombas();
                    temporalCantidad++;
                    JuegoGato.acero  = JuegoGato.acero - 2000;
                    JuegoGato.setBombas(temporalCantidad);
                }
                if(tipoArma == "combos")
                {
                    int temporalCantidad = JuegoGato.getBombas();
                    temporalCantidad++;
                    JuegoGato.acero  = JuegoGato.acero - 5000;
                    JuegoGato.setBombas(temporalCantidad);
                }
            }
            try {
                Thread.sleep(200);
            }catch(InterruptedException e) {}
        }
        }
    }
    

