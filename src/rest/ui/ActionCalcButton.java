package rest.ui;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCalcButton implements ActionListener {
    private final JTextField outField;

    public ActionCalcButton(JTextField outField) {
        this.outField = outField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        try {
            String calcResult = String.valueOf(scriptEngine.eval(outField.getText()));
            outField.setText(calcResult);
        } catch (ScriptException scriptException) {
            outField.setText("Ошибка в выражении.");
        }

    }
}
