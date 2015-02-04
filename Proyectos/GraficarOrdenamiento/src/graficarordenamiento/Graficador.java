/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graficarordenamiento;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author diego
 */
public class Graficador{
    //int[] num = new int[100];
    ListaDoble lista;
    DefaultCategoryDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;
    int tiempo = 0;
    Graficador(){
        lista = new ListaDoble();
    }
    public void crearBase(int cantidad){
        int m = 0;
        for (int i = 0; i < cantidad; i++){  
            m = (int)(Math.random()*cantidad + 1);
            if(!lista.contains(m)){
                lista.add(m);
            }
        }
    }
    public void agregarDatos(){
        // Fuente de Datos
        dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < lista.size(); i++)
            dataset.addValue(lista.get(i),"Valores", 
                    ""+lista.get(i));
    }
    
    public void crearGrafico(){
        // Creando el Grafico
        chart = ChartFactory.createBarChart("Gráfico de barras", 
                null, null, dataset, PlotOrientation.VERTICAL, false, false, false);
        
        chart.setBackgroundPaint(new GradientPaint(0, 0, Color.WHITE, 700, 0, Color.BLACK.brighter(), false));
        chart.setBackgroundImageAlpha(0.5f);
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setNoDataMessage("NO DATA!");
        plot.setRangeGridlinePaint(Color.red);
        plot.setBackgroundPaint(new GradientPaint(0, 0, Color.LIGHT_GRAY, 0, 100, Color.darkGray)); 
        plot.setBackgroundImageAlpha(0.5f);
        //plot.setDomainGridlinesVisible(true);
        
        BarRenderer rend = (BarRenderer) plot.getRenderer();
        
        final ItemLabelPosition e = new ItemLabelPosition(
            ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 45.0
        );
       
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green,
                0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red,
                0.0f, 0.0f, new Color(64, 0, 0));
       
        rend.setSeriesPaint(0, gp0);
        rend.setSeriesPaint(1, gp1);
        rend.setSeriesPaint(2, gp2);
        plot.setRenderer(rend);

        // change the margin at the top of the range axis...
        final ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setLowerMargin(0.15);
        rangeAxis.setUpperMargin(0.15);
        
        // set up gradient paints for series...
        
        
    }
    
    public void obtenerGrafico(JPanel p){
        // Crear el Panel del Grafico con ChartPanel
        
        chartPanel = new ChartPanel(chart);
        chartPanel.setDisplayToolTips(true);
        chartPanel.setFillZoomRectangle(true);
        p.add(chartPanel);
        p.updateUI();
    }
    
     class CustomRenderer extends BarRenderer {

        /** The colors. */
        private Paint[] colors;

        /**
         * Creates a new renderer.
         *
         * @param colors  the colors.
         */
        public CustomRenderer(final Paint[] colors) {
            this.colors = colors;
        }

        /**
         * Returns the paint for an item.  Overrides the default behaviour inherited from
         * AbstractSeriesRenderer.
         *
         * @param row  the series.
         * @param column  the category.
         *
         * @return The item color.
         */
        public Paint getItemPaint(final int row, final int column) {
            return this.colors[column % this.colors.length];
        }
    }
}
