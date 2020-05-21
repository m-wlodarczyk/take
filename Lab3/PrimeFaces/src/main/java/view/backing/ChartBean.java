/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mwlodarczyk
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {
    private LineChartModel lineChart;
    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
        lineChart = new LineChartModel();
        
        LineChartSeries sin = new LineChartSeries();
        LineChartSeries cos = new LineChartSeries();
        
        for (int i=0; i<=360; i+=10) {
            sin.set(i, Math.sin(i));
            cos.set(i, Math.cos(i));
        }
        
        sin.setLabel("Sine");
        cos.setLabel("Cosine");
        
        lineChart.addSeries(sin);
        lineChart.addSeries(cos);
        lineChart.setLegendPosition("e");
        lineChart.setTitle("Chart");
        
        Axis y = lineChart.getAxis(AxisType.Y);
        y.setMin(-1);
        y.setMax(1);
        y.setLabel("Value");

        Axis x = lineChart.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(360);
        x.setTickInterval("10");
        x.setLabel("Degrees");
        
        lineChart.setZoom(true);
    }

    /**
     * @return the lineChart
     */
    public LineChartModel getLineChart() {
        return lineChart;
    }    
}
