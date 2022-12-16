package components;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Barchart {

    public JPanel createBarPanel(String title) {
        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                null,
                "Score",
                createDataset(),
                PlotOrientation.HORIZONTAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        return chartPanel;
    }

    private CategoryDataset createDataset() {
        final String fiat = "FIAT";
        final String audi = "AUDI";
        final String ford = "FORD";
        final String fordx = "FORDX";
        final String fordy = "FORDY";
        final String speed = "Speed";
        final String millage = "Millage";
        final String userrating = "User Rating";
        final String safety = "safety";
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        dataset.addValue(1.0, fiat, speed);
        dataset.addValue(3.0, fiat, userrating);
        dataset.addValue(5.0, fiat, millage);
        dataset.addValue(5.0, fiat, safety);

        dataset.addValue(5.0, audi, speed);
        dataset.addValue(6.0, audi, userrating);
        dataset.addValue(10.0, audi, millage);
        dataset.addValue(4.0, audi, safety);

        dataset.addValue(4.0, ford, speed);
        dataset.addValue(2.0, ford, userrating);
        dataset.addValue(3.0, ford, millage);
        dataset.addValue(6.0, ford, safety);

        dataset.addValue(4.0, fordx, speed);
        dataset.addValue(2.0, fordx, userrating);
        dataset.addValue(3.0, fordx, millage);
        dataset.addValue(6.0, fordx, safety);

        dataset.addValue(4.0, fordy, speed);
        dataset.addValue(2.0, fordy, userrating);
        dataset.addValue(3.0, fordy, millage);
        dataset.addValue(6.0, fordy, safety);

        return dataset;
    }

}
