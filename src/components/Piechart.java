package components;

import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Piechart {
    // CREATE THE PIE CHART

    public JPanel createPiePanel(String title) {
        JFreeChart pieChart = createPieChart(createPieDataset(), title);
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
    private static PieDataset createPieDataset() {

        DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue("One", Double.valueOf(43.21));
        dataset.setValue("Two", Double.valueOf(12.38));
        dataset.setValue("Three", Double.valueOf(25.9));
        dataset.setValue("Four", Double.valueOf(32.12));
        dataset.setValue("Five", Double.valueOf(16.25));

        return dataset;

    }

}
