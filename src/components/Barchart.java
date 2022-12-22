package components;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.ui.TextAnchor;

public class Barchart {

    public JPanel createBarPanel(String title, Map<String,Map> source) {
        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                null,
                "จำนวนนักศึกษา",
                createDataset(source),
                PlotOrientation.HORIZONTAL,
                false, true, false);
        barChart.getTitle().setFont(new Font("Prompt", Font.BOLD, 24));
//        barChart.getLegend().setItemFont(new Font("Prompt", Font.PLAIN, 12));
        
        CategoryPlot plot = (CategoryPlot) barChart.getCategoryPlot(); // advabce customization by using plot
        // Y AXIS (Faculty)
        plot.getDomainAxis().setLabelFont(new Font("Prompt", Font.BOLD, 12));
        plot.getDomainAxis().setTickLabelFont(new Font("Prompt", Font.PLAIN, 12));
        plot.getDomainAxis().setMaximumCategoryLabelLines(3); // text wrap
        // X AXIS (Student Amount)
        plot.getRangeAxis().setLabelFont(new Font("Prompt", Font.BOLD, 12));
        plot.getRangeAxis().setTickLabelFont(new Font("Prompt", Font.PLAIN, 12));
        
        BarRenderer rndr = new CustomRenderer(new Paint[] {new Color(255, 137, 47)});
        // uncomment the line below to remove gradient on bars
//        rndr.setBarPainter(new StandardBarPainter());
        rndr.setBaseItemLabelsVisible(true);
        rndr.setBaseItemLabelPaint(new Color(0, 0, 0)); // font color for texts in bars
        rndr.setBaseItemLabelFont(new Font("Prompt", Font.PLAIN, 10));
        // {0} = branch, {1} = faculty, {2} = amount
        rndr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{1}, {0} - {2} คน", NumberFormat.getInstance()));
        rndr.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{0} - {2}", NumberFormat.getInstance()));
        rndr.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE3, TextAnchor.CENTER_RIGHT, TextAnchor.CENTER, 0.0));
        
        plot.setRenderer(rndr);

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

    private static class CustomRenderer extends BarRenderer {
        private Paint[] colors;

        public CustomRenderer(final Paint[] colors) {
            this.colors = colors;
        }
        
        @Override
        public Paint getItemPaint(final int row, final int col) {
            return this.colors[col % this.colors.length];
        }
    }
}
