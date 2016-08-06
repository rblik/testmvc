package isr.ek0.service;

import isr.ek0.model.User;
import org.displaytag.decorator.TableDecorator;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JBlik on 04.08.2016.
 */

/**
 * Makes appropriate date format in table
 */
public class DateDecorator extends TableDecorator {

    public String getCreatedDate() {
        Date date = ((User)getCurrentRowObject()).getCreatedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(date);
    }
}
