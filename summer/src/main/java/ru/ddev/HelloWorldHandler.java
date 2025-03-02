package ru.ddev;

import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.io.Content;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.Callback;

class HelloWorldHandler extends Handler.Abstract.NonBlocking
    {
        @Override
        public boolean handle(Request request, Response response, Callback callback)
        {
            response.setStatus(200);
            response.getHeaders().put(HttpHeader.CONTENT_TYPE, "text/html; charset=UTF-8");

            // Write a Hello World response.
            Content.Sink.write(response, true, """
            <!DOCTYPE html>
            <html>
            <head>
              <title>Jetty Hello World Handler</title>
            </head>
            <body>
              <p>Hello World</p>
            </body>
            </html>
            """, callback);
            return true;
        }
    }