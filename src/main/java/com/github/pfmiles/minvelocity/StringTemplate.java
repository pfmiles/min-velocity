package com.github.pfmiles.minvelocity;

import java.io.StringReader;

import com.github.pfmiles.org.apache.velocity.Template;
import com.github.pfmiles.org.apache.velocity.exception.ParseErrorException;
import com.github.pfmiles.org.apache.velocity.exception.ResourceNotFoundException;
import com.github.pfmiles.org.apache.velocity.exception.TemplateInitException;
import com.github.pfmiles.org.apache.velocity.exception.VelocityException;
import com.github.pfmiles.org.apache.velocity.runtime.parser.ParseException;

/**
 * 常量形式的模板类；每次创建均会将String形式的模板parse为velocity的AST，因此若在乎大量重复render的性能，
 * 实际使用上可自行cache此类实例
 * 
 * @author pf-miles
 * 
 */
public class StringTemplate extends Template {
    private String content;

    public StringTemplate(String templateString) {
        super();
        this.content = templateString;
        this.name = "StringTemplate";
    }

    public boolean process() throws ResourceNotFoundException, ParseErrorException {
        data = null;
        errorCondition = null;

        /*
         * parse the template
         */

        try {
            StringReader br = new StringReader(this.content);
            data = rsvc.parse(br, name);
            initDocument();
            return true;
        } catch (ParseException pex) {
            /*
             * remember the error and convert
             */
            errorCondition = new ParseErrorException(pex, name);
            throw errorCondition;
        } catch (TemplateInitException pex) {
            errorCondition = new ParseErrorException(pex, name);
            throw errorCondition;
        }
        /**
         * pass through runtime exceptions
         */
        catch (RuntimeException e) {
            errorCondition = new VelocityException("Exception thrown processing Template " + getName(), e);
            throw errorCondition;
        }
    }

}
