package com.wangyao.dp.behavioral.mediator;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LblDisplay extends JLabel {

    Mediator med;

    LblDisplay(Mediator m) {
        super("Just start...");
        med = m;
        med.registerDisplay(this);
        setFont(new Font("Arial", Font.BOLD, 24));
    }

}
