//
// Copyright (c) 2012 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//           http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.ovirt.engine.sdk.exceptions;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Fault;
import org.ovirt.engine.sdk.utils.HttpResponseHelper;
import org.ovirt.engine.sdk.utils.SerializationHelper;
import org.ovirt.engine.sdk.utils.StringUtils;

/**
 * Thrown when server reports error
 */
public class ServerException extends OvirtSdkException {
    private static final long serialVersionUID = 3286777099419639787L;

    private static final String ACTION_FAULT = "<action>";
    private static final String FAULT = "<fault>";

    private int code;
    private String reason;
    private String detail;

    /**
     * Constructs an <code>ServerException</code> without a detail message.
     */
    public ServerException() {
        super();
    }

    /**
     * @param response
     *            HttpResponse response
     */
    public ServerException(HttpResponse response) {
        super(response.getStatusLine().getReasonPhrase());

        this.code = getCode(response);
        this.reason = getReason(response);
        this.detail = getDetail(response.getEntity());
    }

    private int getCode(HttpResponse response) {
        return response.getStatusLine().getStatusCode();
    }

    private String getReason(HttpResponse response) {
        return response.getStatusLine().getReasonPhrase();
    }

    private String getDetail(HttpEntity httpEentity) {
        String detail = null;
        String entity = null;
        Fault fault = null;

        try {
            entity = HttpResponseHelper.getEntity(httpEentity);
        } catch (ParseException e) {
            // TODO: Log error
            e.printStackTrace();
        } catch (IOException e) {
            // TODO: Log error
            e.printStackTrace();
        }

        if (entity != null && !entity.equals("") && !entity.startsWith("<html>")) {
            try {
                if (entity.contains(ACTION_FAULT)) {
                    fault = SerializationHelper.unmarshall(Action.class, entity).getFault();
                } else if (entity.contains(FAULT)) {
                    fault = SerializationHelper.unmarshall(Fault.class, entity);
                } else {
                    // TODO: check if there other use-case
                }

                if (fault != null) {
                    detail = StringUtils.removeBrackets(fault.getDetail());
                } else {
                    detail = entity;
                }

            } catch (Exception e) {
                detail = entity;
            }
        } else {
            detail = entity;
        }

        return detail;
    }

    /**
     * HTTP response code
     * 
     * @return int
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Returns HTTP failure reason
     * 
     * @return String
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * Returns HTTP failure detail
     * 
     * @return String
     */
    public String getDetail() {
        return this.detail;
    }

    @Override
    public String toString() {
        return "\ncode  : " + this.getCode() +
                "\nreason: " + this.getReason() +
                "\ndetail: " + this.getDetail();
    }
}
