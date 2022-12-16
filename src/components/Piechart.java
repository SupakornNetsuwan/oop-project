package components;

import java.awt.Font;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.util.*;

public class Piechart {
    
    // CREATE THE PIE CHART

    public JPanel createPiePanel(String title, Map<String,Integer> source) {
        JFreeChart pieChart = createPieChart(createPieDataset(source), title);
        pieChart.getTitle().setFont(new Font("Prompt", Font.BOLD, 24));
        pieChart.getLegend().setItemFont(new Font("Prompt", Font.PLAIN, 12));
        return new ChartPanel(pieChart);
    }

    // BUILD THE PIE CHART
    private static JFreeChart createPieChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart(
                title, // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();

        plot.setSectionOutlinesVisible(false);

        plot.setNoDataMessage("ไม่มีข้อมูลให้แสดง");
        return chart;

    }

    // CREATE THE PIE CHART DATA
    private PieDataset createPieDataset(Map<String,Integer> source) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String,Integer> professorSubjects = source;
        
        for (String p : professorSubjects.keySet()) {
            dataset.setValue(p, professorSubjects.get(p));
        }

        return dataset;

    }
    
}
