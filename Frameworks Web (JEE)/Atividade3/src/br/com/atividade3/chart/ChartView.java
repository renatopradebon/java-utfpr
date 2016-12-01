package br.com.atividade3.chart;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
public class ChartView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarChartModel barModel;

	@PostConstruct
	public void init() {
		createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries paises = new ChartSeries();
		paises.setLabel("Países");
		paises.set("China", 1534);
		paises.set("Brasil", 202);
		paises.set("USA", 316);
		paises.set("Argentina", 42);
		paises.set("Alemanha", 81);

		model.addSeries(paises);

		return model;
	}

	private void createBarModels() {
		createBarModel();
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("População dos Países (em muilhões de habitantes)");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Países");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("População (em milhões de habitantes)");
		yAxis.setMin(0);
		yAxis.setMax(2000);
	}
}