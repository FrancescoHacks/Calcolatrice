package com.example.calcolatrice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Vector;

public class HelloController {


    @FXML
    Button One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero, Result,
            Addition, Subtraction, Moltiplication, Division, Ac, Point, Del;

    @FXML
    Label Total, Total1;

    public void One(){
        Total.setText(Total.getText() + One.getText());
        Total1.setText(Total1.getText() + One.getText());
    }

    public void Two(){
        Total.setText(Total.getText() + Two.getText());
        Total1.setText(Total1.getText() + Two.getText());
    }

    public void Three(){
        Total.setText(Total.getText() + Three.getText());
        Total1.setText(Total1.getText() + Three.getText());
    }

    public void Four(){
        Total.setText(Total.getText() + Four.getText());
        Total1.setText(Total1.getText() + Four.getText());
    }

    public void Five(){
        Total.setText(Total.getText() + Five.getText());
        Total1.setText(Total1.getText() + Five.getText());
    }

    public void Six(){
        Total.setText(Total.getText() + Six.getText());
        Total1.setText(Total1.getText() + Six.getText());
    }

    public void Seven(){
        Total.setText(Total.getText() + Seven.getText());
        Total1.setText(Total1.getText() + Seven.getText());
    }

    public void Eight(){
        Total.setText(Total.getText() + Eight.getText());
        Total1.setText(Total1.getText() + Eight.getText());
    }

    public void Nine(){
        Total.setText(Total.getText() + Nine.getText());
        Total1.setText(Total1.getText() + Nine.getText());
    }

    public void Zero(){
        Total.setText(Total.getText() + Zero.getText());
        Total1.setText(Total1.getText() + Zero.getText());
    }

    public void Delete(){
        Total.setText("");
        Total1.setText("");
    }

    public void Addition(){
        Total.setText(Total.getText() + Addition.getText());
        Total1.setText(Total1.getText() + ";" +  Addition.getText() + ";");
    }

    public void Subtraction(){
        Total.setText(Total.getText() + Subtraction.getText());
        Total1.setText(Total1.getText() + ";" +  Subtraction.getText() + ";");
    }

    public void Division(){
        Total.setText(Total.getText() + Division.getText());
        Total1.setText(Total1.getText() + ";" +  "/" + ";");
    }

    public void Moltiplication(){
        Total.setText(Total.getText() + Moltiplication.getText());
        Total1.setText(Total1.getText() + ";" +  "*" + ";");
    }

    public void Decimal(){
        Total.setText(Total.getText() + Point.getText());
        Total1.setText(Total1.getText() + Point.getText());
    }

    public void Result(){
        Boolean Trovato = false;
        String[] Total2 = Total1.getText().split(";");
        Vector<String> Total3 = new Vector<>(0, 1);
        for(int i=0; i<Total2.length; i++){
            Total3.add(Total2[i]);
        }
        for (int i=0; i<Total3.size(); i++){
            if(Total3.get(i).isEmpty()){
                Total3.remove(i);
            }
        }
        if(Total3.get(0).equals("-")){
            Total3.set(0, Total3.get(0) + Total3.get(1));
            Total3.remove(1);
        }

        for (int i=0; i<Total3.size(); i++){
            if(Total3.get(i).equals("+") || Total3.get(i).equals("-") ||
                    Total3.get(i).equals("*") || Total3.get(i).equals("/")){
                Trovato = true;
            }else{
                Trovato = false;
            }
        
            if(i+1<Total3.size()){
                if((Total3.get(i+1).equals("+") || Total3.get(i+1).equals("-") ||
                        Total3.get(i+1).equals("*") || Total3.get(i+1).equals("/")) && Trovato){
                    Total3.set(i+1, Total3.get(i+1) + Total3.get(i+2));
                    Total3.remove(i+2);
                }
            }

        }
        double totale;
        do{
            for (int i=0; i<Total3.size(); i++){
                if(i+1<Total3.size()){
                    if(Total3.get(i).equals("*")){
                        totale = Double.parseDouble(Total3.get(i-1)) * Double.parseDouble(Total3.get(i+1));
                        Total3.set(i-1, String.valueOf(totale));
                        Total3.remove(i);
                        Total3.remove(i);
                    }
                    else if(Total3.get(i).equals("/")){
                        totale = Double.parseDouble(Total3.get(i-1)) / Double.parseDouble(Total3.get(i+1));
                        Total3.set(i-1, String.valueOf(totale));
                        Total3.remove(i);
                        Total3.remove(i);
                    }
                }

            }

            for (int i=0; i<Total3.size(); i++){
                if(i+1<Total3.size()) {
                    if (Total3.get(i).equals("+")) {
                        totale = Double.parseDouble(Total3.get(i - 1)) + Double.parseDouble(Total3.get(i + 1));
                        Total3.set(i - 1, String.valueOf(totale));
                        Total3.remove(i+1);
                        Total3.remove(i);
                    }
                    else if (Total3.get(i).equals("-")) {
                        totale = Double.parseDouble(Total3.get(i-1)) - Double.parseDouble(Total3.get(i+1));
                        Total3.set(i-1, String.valueOf(totale));
                        Total3.remove(i+1);
                        Total3.remove(i);
                    }
                }

            }

        }while(Total3.size()!=1);

        String[] Total4 = Total3.get(0).split("");

        Vector<String> Total5 = new Vector<>(0, 1);
        for(int i=0; i<Total4.length; i++){
            Total5.add(Total4[i]);
        }
        int totals = Total5.size()-1;

        if(Total5.get(totals).equals("0") && Total5.get((totals-1)).equals(".")){
            Total5.remove(totals);
            Total5.remove((totals-1));
        }

        Total.setText("");
        Total1.setText("");
        
        for(int i=0; i<Total5.size(); i++){
            Total.setText(Total.getText() + Total5.get(i));
            Total1.setText(Total1.getText() + Total5.get(i));
        }
        

    }
}