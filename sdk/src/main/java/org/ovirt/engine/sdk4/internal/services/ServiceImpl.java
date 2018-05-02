package org.ovirt.engine.sdk4.internal.services;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionReader;
import org.ovirt.engine.sdk4.internal.xml.XmlFaultReader;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Fault;

import java.io.IOException;

public class ServiceImpl {

    private String path;
    private HttpConnection connection;

    public ServiceImpl() {
        this.connection = null;
        this.path = null;
    }

    public ServiceImpl(HttpConnection connection, String path) {
        this.connection = connection;
        this.path = path;
    }

    public void checkFault(HttpResponse response) {
        try (XmlReader reader = new XmlReader(response.getEntity().getContent())) {
            Fault fault = null;
            try {
                fault = XmlFaultReader.readOne(reader);
            } catch (XmlException e) {
                // Ignore
            }
            if (
                fault != null ||
                (response.getStatusLine() != null && response.getStatusLine().getStatusCode() >= 400)
            ) {
                this.throwError(response, fault);
            }
        } catch (IOException ex) {
            throw new Error("Failed to read response", ex);
        } finally {
            EntityUtils.consumeQuietly(response.getEntity());
        }
    }

    public Action checkAction(HttpResponse response) {
        try (XmlReader reader = new XmlReader(response.getEntity().getContent())) {
            Object result = reader.read();
            if (result != null ) {
                if (result instanceof Fault) {
                    this.throwError(response, (Fault) result);
                }
                else if (result instanceof Action && ((Action) result).faultPresent()) {
                    this.throwError(response, ((Action) result).fault());
                }
            }
            return (Action) result;
        } catch (IOException ex) {
            throw new Error("Failed to read response", ex);
        } finally {
            EntityUtils.consumeQuietly(response.getEntity());
        }
    }

    public void throwError(HttpResponse response, Fault fault) {
        StringBuilder buffer = new StringBuilder();
        if (fault != null) {
            if (fault.reasonPresent()) {
                if (buffer.length() > 0) {
                    buffer.append(" ");
                }
                buffer.append(
                    String.format(
                        "Fault reason is \"%s\".",
                        fault.reason()
                    )
                );
            }

            if (fault.detailPresent()) {
                if (buffer.length() > 0) {
                    buffer.append(" ");
                }
                buffer.append(
                    String.format(
                        "Fault detail is \"%s\".",
                        fault.detail())
                );
            }
        }

        if (response != null && response.getStatusLine() != null) {
            if (buffer.length() > 0) {
                buffer.append(" ");
            }
            buffer.append(
                String.format(
                    "HTTP response code is \"%s\".",
                    response.getStatusLine().getStatusCode()
                )
            );
            buffer.append(" ");
            buffer.append(
                String.format(
                    "HTTP response message is \"%s\".",
                    response.getStatusLine().getReasonPhrase()
                )
            );
        }
        throw new Error(buffer.toString());
    }

    public HttpConnection getConnection() {
        return connection;
    }

    public String getPath() {
        return path;
    }
}
