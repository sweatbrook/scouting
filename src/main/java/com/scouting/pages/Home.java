package com.scouting.pages;

import java.util.Date;
import org.apache.tapestry5.annotations.Import;

/**
 *
 * @author sweatbrook
 */
@Import(library = {"context:ckeditor/ckeditor.js"})
public class Home {
    
    public Date getCurrentTime() {
        return new Date();
    }
}
