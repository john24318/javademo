package com.swallow.base.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

public class DateConverter implements Converter {

    // ----------------------------------------------------------- Constructors

    /**
     * Create a {@link Converter} that will throw a {@link ConversionException} if a conversion error occurs.
     */
    public DateConverter() {
        this.defaultValue = null;
        this.useDefault = false;

    }

    /**
     * Create a {@link Converter} that will return the specified default value if a conversion error occurs.
     * 
     * @param defaultValue The default value to be returned
     */
    public DateConverter(Object defaultValue) {
        this.defaultValue = defaultValue;
        this.useDefault = true;

    }

    // ----------------------------------------------------- Instance Variables

    /**
     * The default value specified to our Constructor, if any.
     */
    private Object defaultValue = null;

    /**
     * Should we return the default value on conversion errors?
     */
    private boolean useDefault = true;

    private DateFormat df = new SimpleDateFormat(DateUtil.getDateTimePattern());

    // --------------------------------------------------------- Public Methods

    public Object convert(Class type, Object value) {
        if (value == null) {
            if (useDefault) {
                return (defaultValue);
            } else {
                throw new ConversionException("No value specified");
            }
        }

        if (value instanceof Date) {
            if (type.equals(Timestamp.class)) {
                if (value instanceof Timestamp) {
                    return value;
                }
                return new Timestamp(((Date) value).getTime());
            }

            return value;
        }

        if (value instanceof String) {
            try {
                Date date = df.parse(value.toString());
                if (type.equals(Timestamp.class)) {
                    return new Timestamp(date.getTime());
                }

                return date;
            } catch (Exception e) {
                if (useDefault) {
                    return (defaultValue);
                } else {
                    throw new ConversionException(e);
                }
            }
        }

        throw new ConversionException("Could not convert " + value.getClass().getName() + " to " + type.getName());
    }

}
