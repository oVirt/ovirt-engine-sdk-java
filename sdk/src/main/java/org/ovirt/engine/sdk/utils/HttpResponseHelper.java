package org.ovirt.engine.sdk.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

/**
 * Provides HttpResponse processing services
 */
public class HttpResponseHelper {
    /**
     * fetches entity from the HttpEntity
     * 
     * @param entity
     *            HttpEntity entity
     * 
     * @return XML String
     * 
     * @throws ParseException
     * @throws IOException
     */
    public static synchronized String getEntity(HttpEntity entity) throws ParseException, IOException {
        if (entity != null) {
            return EntityUtils.toString(entity, StringUtils.UTF8);
        } else {
            return null;
        }
    }
}
