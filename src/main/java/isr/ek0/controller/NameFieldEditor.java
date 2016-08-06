package isr.ek0.controller;

import java.beans.PropertyEditorSupport;

/**
 * Created by JBlik on 06.08.2016.
 */
public class NameFieldEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String name) throws IllegalArgumentException {
        StringBuffer sb = new StringBuffer(name);
        char c = sb.charAt(0);
        if (Character.isLowerCase(c)) {
            sb.setCharAt(0, Character.toUpperCase(c));
        }
        System.out.println(sb.toString());
        setValue(sb.toString());
    }
}
