/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.view.menu;


import org.example.model.undomachine.UndoMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Wera
 */
public class SwitchUndo extends AbstractAction implements Observer{

    public SwitchUndo(String name, Icon icon, UndoMachine machine) {
        super(name, icon);
        putValue("machine", machine);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UndoMachine m = (UndoMachine)getValue("machine");
        if (this.isEnabled()) m.unexecute();   
    }

    @Override
    public void update(Observable o, Object arg) {
        UndoMachine.UndoRedoButtonState buttonState = (UndoMachine.UndoRedoButtonState) arg;
        this.setEnabled(buttonState.undo);
    }  
}
