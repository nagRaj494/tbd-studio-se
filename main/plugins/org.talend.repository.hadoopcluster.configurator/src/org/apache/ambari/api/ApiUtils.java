// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.apache.ambari.api;

import java.util.Date;

import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

import com.cloudera.api.Parameters;
import com.google.common.base.Preconditions;

/**
 * created by bchen on Jun 2, 2015 Detailled comment
 *
 */
/**
 * A collection of utility methods and common constants used by API code.
 */
public final class ApiUtils {

    private static final DateTimeFormatter DATE_TIME_PRINTER = ISODateTimeFormat.dateTime();

    private static final DateTimeFormatter DATE_TIME_PARSER = ISODateTimeFormat.dateTimeParser();

    private static final PeriodFormatter PERIOD_FORMATTER = ISOPeriodFormat.standard();

    /**
     * A special path component contained in the path for an HDFS snapshot dir.
     *
     * Copied from org.apache.hadoop.hdfs.protocol.HdfsConstants.
     */
    public final static String DOT_SNAPSHOT_DIR = ".snapshot";

    public static Instant newInstantFromString(String value) {
        if (value.equalsIgnoreCase(Parameters.DATE_TIME_NOW)) {
            return new Instant();
        }

        return new Instant(DATE_TIME_PARSER.parseMillis(value));
    }

    public static Date newDateFromString(String value) {
        return new Date(newInstantFromString(value).getMillis());
    }

    public static Date newDateFromMillis(long millis) {
        return new Date(millis);
    }

    public static Period newPeriodFromString(String value) {
        return PERIOD_FORMATTER.parsePeriod(value);
    }

    public static String printDate(Date date) {
        return DATE_TIME_PRINTER.print(new Instant(date));
    }

    public static String printDate(Instant instant) {
        return DATE_TIME_PRINTER.print(instant);
    }

    /**
     * Calculate the fromDate. If the fromString is not provided, then the fromDate calculated from the toDate and the
     * window.
     * 
     * @param fromString A string representation of the from date.
     * @param toDate The to date for this period
     * @param window The duration of this period
     * @return the Date object that corresponds to the from date
     */
    public static Date getFromDate(String fromString, Date toDate, Duration window) {
        Date fromDate = null;
        if (fromString != null) {
            fromDate = newDateFromString(fromString);
            Preconditions.checkArgument(fromDate.getTime() < toDate.getTime(),
                    "Invalid period specified: 'to' must be later than 'from'.");
        } else {
            Instant fromInstant = new Instant(toDate.getTime()).minus(window);
            fromDate = new Date(fromInstant.getMillis());
        }
        return fromDate;
    }

    /**
     * Checks whether the <i>other</i> object has the same class as the given object, and casts it to the given object's
     * type.
     * <p>
     * The pattern for using this in an implementation of equals() would be: <blockquote><tt>
     *   MyType that = ApiUtils.baseEquals(this, other);
     *   return this == that || (that != null &&
     *       Objects.equal(...) &&
     *       Objects.equal(...));
     * </tt></blockquote>
     *
     * @param object The object being compared.
     * @param other The object being compared against.
     * @return <i>other</i>, if it's not null and has the same class as <i>object</i>; null otherwise.
     */
    public static <T> T baseEquals(T object, Object other) {
        if (object == other || (other != null && object.getClass() == other.getClass())) {
            return (T) other;
        }
        return null;
    }

    /**
     * Check that the given values are sane.
     *
     * @param offset Value to use as offset of a list.
     * @param limit Value to use as limit of a list's size.
     */
    public static void checkOffsetAndLimit(int offset, int limit) {
        Preconditions.checkArgument(offset >= 0, "Offset should be greater or equal 0.");
        Preconditions.checkArgument(limit > 0, "Limit should be greater than 0.");
    }

    private ApiUtils() {
    }

}
