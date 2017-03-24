/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockappfx;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import yahoofinance.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author Bert
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField stockIn;
    @FXML
    private Text StockSymbol;
    @FXML
    private Text stockName;
    @FXML
    private Text stockPrice;
    @FXML
    private Text Dividend;
    @FXML
    private Text currency;
    @FXML
    private Text StockExchange;
    @FXML
    private LineChart graph;

    @FXML
    private void searchButtonAction(ActionEvent event) {

        try {
            //method uses yahoo finance API to call information on target stock

            // variable to hold String entered by user for target state
            Stock targetStock = YahooFinance.get(stockIn.getText(), true);

            //create variables to hold stock data/ did not use all these values here but in future they could be used.
            BigDecimal price = targetStock.getQuote().getPrice();
            BigDecimal change = targetStock.getQuote().getChangeInPercent();
            BigDecimal peg = targetStock.getStats().getPeg();
            BigDecimal dividend = targetStock.getDividend().getAnnualYieldPercent();
            System.out.println("search button pressed");
            System.out.println(targetStock.getSymbol());

            //sets labels to target stocks data
            StockSymbol.setText("Symbol : " + targetStock.getSymbol());
            stockName.setText("Name : " + targetStock.getName());
            StockExchange.setText("Stock Exchange : " + targetStock.getStockExchange());
            //jlbQuote.setText("Quote : " + targetStock.toString());
            currency.setText("Currency : " + targetStock.getCurrency());
            Dividend.setText("Dividend Annual yield : " + dividend + "%");
            stockPrice.setText("Price: " + price);
            graph.setLayoutX(10);
            graph.setLayoutY(10);

            //jtaHistory.setText("History : " + targetStock.getHistory(from, to, Interval.DAILY));
        } // end actionPerformed(ActionEvent e)
        catch (IOException ex) {

        } catch (java.lang.StringIndexOutOfBoundsException Ex) {

            System.out.println("Please enter a valid stock ticker symbol");

        } catch (java.lang.NullPointerException Ex) {

            System.out.println("Please enter a valid stock ticker symbol, empty spaces count as characters");

        } //end catch

    }// end search button action

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
