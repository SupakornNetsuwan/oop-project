package components;

import java.awt.Font;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.*;

public class Barchart {

    public JPanel createBarPanel(String title, Map<String,Map> source) {
        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                null,
                "จำนวนนักศึกษา",
                createDataset(source),
                PlotOrientation.HORIZONTAL,
                true, true, false);
        barChart.getTitle().setFont(new Font("Prompt", Font.BOLD, 24));
        barChart.getLegend().setItemFont(new Font("Prompt", Font.PLAIN, 12));

        ChartPanel chartPanel = new ChartPanel(barChart);
        return chartPanel;
    }

    private CategoryDataset createDataset(Map<String,Map> source) {
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();
        
        Map<String,Map> faculties = source;
        
        for (String f : faculties.keySet()) {
//            System.out.println("IN FACLUTY: " + f);
            Map<String,Integer> branch = faculties.get(f);
            for (String b : branch.keySet()) {
//                System.out.println(branch.get(b) + ", " + b + ", " + f);
                dataset.addValue(branch.get(b), b, f);
            }
        }
        
        return dataset;
    }
    

}
