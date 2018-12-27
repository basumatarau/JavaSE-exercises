package com.codeHeap.swing.trackEvent;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class UpperCaseDocument extends PlainDocument {
    private boolean isUpper = true;

    public void setUpper(boolean flag){
        isUpper = flag;
    }

    @Override
    public void insertString(int i, String s, AttributeSet attributeSet) throws BadLocationException {
        if(isUpper){
            s = s.toUpperCase();
        }
        super.insertString(i, s, attributeSet);
    }
}
