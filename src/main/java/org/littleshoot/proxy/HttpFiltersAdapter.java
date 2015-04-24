package org.littleshoot.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

/**
 * Convenience base class for implementations of {@link HttpFilters}.
 */
public class HttpFiltersAdapter implements HttpFilters {
    
    public static final HttpResponse BYPASS_PROXY_HANDLER = new DefaultHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.OK);
    protected final HttpRequest originalRequest;
    protected final ChannelHandlerContext ctx;

    public HttpFiltersAdapter(HttpRequest originalRequest,
            ChannelHandlerContext ctx) {
        this.originalRequest = originalRequest;
        this.ctx = ctx;
    }

    public HttpFiltersAdapter(HttpRequest originalRequest) {
        this(originalRequest, null);
    }

    @Override
    public HttpResponse requestPre(HttpObject httpObject) {
        return null;
    }

    @Override
    public HttpResponse requestPost(HttpObject httpObject) {
        return null;
    }

    @Override
    public HttpObject responsePre(HttpObject httpObject) {
        return httpObject;
    }

    @Override
    public HttpObject responsePost(HttpObject httpObject) {
        return httpObject;
    }

}
