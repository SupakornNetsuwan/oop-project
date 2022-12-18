package components;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Piechart {

    // CREATE THE PIE CHART
    public JPanel createPiePanel(String title, Map<String, Integer> source) {
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

        plot.setSectionOutlinesVisible(true);
        plot.setLabelFont(new Font("Prompt", Font.PLAIN, 12));
        // {0} = professor, {1} = amount, {2} = percentage
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}"
        ));
//        plot.setToolTipGenerator(new PieToolTipGenerator() {
//            @Override
//            public String generateToolTip(PieDataset dataset, Comparable key) {
//                return key + " - " + dataset.getValue(key) + " คน";
//            }
//        });
        plot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} - {1} วิชา ({2})"));
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("Prompt", Font.PLAIN, 12));

        plot.setNoDataMessage("No professors data available.");
        return chart;

    }

    // CREATE THE PIE CHART DATA
    private PieDataset createPieDataset(Map<String, Integer> source) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String, Integer> professorSubjects = source;

        for (String p : professorSubjects.keySet()) {
            dataset.setValue(p, professorSubjects.get(p));
        }

        return dataset;

    }

}
