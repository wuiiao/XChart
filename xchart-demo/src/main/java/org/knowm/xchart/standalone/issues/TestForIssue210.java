/**
 * Copyright 2015-2017 Knowm Inc. (http://knowm.org) and contributors.
 * Copyright 2011-2015 Xeiam LLC (http://xeiam.com) and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.knowm.xchart.standalone.issues;

import java.util.ArrayList;

import org.knowm.xchart.DialChart;
import org.knowm.xchart.DialChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;

/**
 * Dial Chart
 * <p>
 * Demonstrates the following:
 * <ul>
 * <li>Dial Chart
 * <li>DialChartBuilder
 */
public class TestForIssue210 implements ExampleChart<DialChart> {

  public static void main(String[] args) {

    ExampleChart<DialChart> exampleChart = new TestForIssue210();
    ArrayList<DialChart> charts = new ArrayList<DialChart>();
    {
      DialChart chart = exampleChart.getChart();
      chart.setTitle("Dial chart");
      charts.add(chart);
    }
    {
      DialChart chart = exampleChart.getChart();
      chart.setTitle("Dial chart without green&red parts");
      chart.getStyler().setRedFrom(-1);
      chart.getStyler().setGreenFrom(-1);

      charts.add(chart);
    }
    {
      DialChart chart = exampleChart.getChart();
      chart.setTitle("Dial chart with custom ticks&labels");
      chart.getStyler().setAxisTickValues(new double[] { .33, .45, .79});
      chart.getStyler().setAxisTickLabels(new String[] { "min", "average", "max"});
      charts.add(chart);
    }
    {
      DialChart chart = exampleChart.getChart();
      chart.setTitle("Dial chart with custom arrow");
      chart.getStyler().setArrowLengthPercentage(1.05);
      chart.getStyler().setArrowArcAngle(90);
      chart.getStyler().setArrowArcPercentage(.03);
      charts.add(chart);
    }
    {
      DialChart chart = exampleChart.getChart();
      chart.setTitle("Full circle dial chart");
      chart.getStyler().setArcAngle(360);
      //chart.getStyler().setDonutThickness(1);
      chart.getStyler().setAxisTickLabelsVisible(false);
      charts.add(chart);
    }
    {
      DialChart chart = exampleChart.getChart();
      chart.setTitle("Full circle dial chart without donut");
      chart.getStyler().setArcAngle(360);
      chart.getStyler().setDonutThickness(1);
      chart.getStyler().setAxisTickLabelsVisible(false);
      charts.add(chart);
    }
    new SwingWrapper<DialChart>(charts).displayChartMatrix();
  }

  @Override
  public DialChart getChart() {

    // Create Chart
    DialChart chart = new DialChartBuilder().width(480).height(400).title("Dial Chart").build();

    // Series
    chart.addSeries("Rate", 0.9381, "93.81 %");
    chart.getStyler().setToolTipsEnabled(true);
    chart.getStyler().setLegendVisible(false);

    return chart;
  }
}
