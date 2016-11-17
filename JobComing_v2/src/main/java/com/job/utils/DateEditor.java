package com.job.utils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport{  
	  
    @Override  
    public String getAsText() {  
        Date date = (Date)getValue();  
        if(date==null){  
            date = new Date();  
        }  
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return sf.format(date);  
    }  
  
    @Override  
    public void setAsText(String text) throws IllegalArgumentException {  
        Date value = null;  
        if(text!=null&&!text.equals("")){  
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
            try {  
                value = sf.parse(text);  
            } catch (ParseException e) {  
                e.printStackTrace();  
            }  
              
        }  
        setValue(value);  
    }  
}