/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.armeria.client;

import java.net.URI;
import java.nio.charset.Charset;

import com.linecorp.armeria.common.AggregatedHttpRequest;
import com.linecorp.armeria.common.HttpData;
import com.linecorp.armeria.common.HttpMethod;
import com.linecorp.armeria.common.HttpRequest;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.RequestHeaders;
import com.linecorp.armeria.common.SessionProtocol;

/**
 * An HTTP client.
 */
public interface HttpClient extends ClientBuilderParams {

    /**
     * Creates a new HTTP client that connects to the specified {@code uri} using the default
     * {@link ClientFactory}.
     *
     * @param uri the URI of the server endpoint
     * @param options the {@link ClientOptionValue}s
     *
     * @throws IllegalArgumentException if the scheme of the specified {@code uri} is not an HTTP scheme
     */
    static HttpClient of(String uri, ClientOptionValue<?>... options) {
        return of(ClientFactory.DEFAULT, uri, options);
    }

    /**
     * Creates a new HTTP client that connects to the specified {@code uri} using the default
     * {@link ClientFactory}.
     *
     * @param uri the URI of the server endpoint
     * @param options the {@link ClientOptions}
     *
     * @throws IllegalArgumentException if the scheme of the specified {@code uri} is not an HTTP scheme
     */
    static HttpClient of(String uri, ClientOptions options) {
        return of(ClientFactory.DEFAULT, uri, options);
    }

    /**
     * Creates a new HTTP client that connects to the specified {@code uri} using an alternative
     * {@link ClientFactory}.
     *
     * @param factory an alternative {@link ClientFactory}
     * @param uri the URI of the server endpoint
     * @param options the {@link ClientOptionValue}s
     *
     * @throws IllegalArgumentException if the scheme of the specified {@code uri} is not an HTTP scheme
     */
    static HttpClient of(ClientFactory factory, String uri, ClientOptionValue<?>... options) {
        return new HttpClientBuilder(uri).factory(factory).options(options).build();
    }

    /**
     * Creates a new HTTP client that connects to the specified {@code uri} using an alternative
     * {@link ClientFactory}.
     *
     * @param factory an alternative {@link ClientFactory}
     * @param uri the URI of the server endpoint
     * @param options the {@link ClientOptions}
     *
     * @throws IllegalArgumentException if the scheme of the specified {@code uri} is not an HTTP scheme
     */
    static HttpClient of(ClientFactory factory, String uri, ClientOptions options) {
        return new HttpClientBuilder(uri).factory(factory).options(options).build();
    }

    /**
     * Creates a new HTTP client that connects to the specified {@link URI} using the default
     * {@link ClientFactory}.
     *
     * @param uri the URI of the server endpoint
     * @param options the {@link ClientOptionValue}s
     *
     * @throws IllegalArgumentException if the scheme of the specified {@code uri} is not an HTTP scheme
     */
    static HttpClient of(URI uri, ClientOptionValue<?>... options) {
        return of(ClientFactory.DEFAULT, uri, options);
    }

    /**
     * Creates a new HTTP client that connects to the specified {@link URI} using the default
     * {@link ClientFactory}.
     *
     * @param uri the URI of the server endpoint
     * @param options the {@link ClientOptions}
     *
     * @throws IllegalArgumentException if the scheme of the specified {@code uri} is not an HTTP scheme
     */
    static HttpClient of(URI uri, ClientOptions options) {
        return of(ClientFactory.DEFAULT, uri, options);
    }

    /**
     * Creates a new HTTP client that connects to the specified {@link URI} using an alternative
     * {@link ClientFactory}.
     *
     * @param factory an alternative {@link ClientFactory}
     * @param uri the URI of the server endpoint
     * @param options the {@link ClientOptionValue}s
     *
     * @throws IllegalArgumentException if the scheme of the specified {@code uri} is not an HTTP scheme
     */
    static HttpClient of(ClientFactory factory, URI uri, ClientOptionValue<?>... options) {
        return new HttpClientBuilder(uri).factory(factory).options(options).build();
    }

    /**
     * Creates a new HTTP client that connects to the specified {@link URI} using an alternative
     * {@link ClientFactory}.
     *
     * @param factory an alternative {@link ClientFactory}
     * @param uri the URI of the server endpoint
     * @param options the {@link ClientOptions}
     *
     * @throws IllegalArgumentException if the scheme of the specified {@code uri} is not an HTTP scheme
     */
    static HttpClient of(ClientFactory factory, URI uri, ClientOptions options) {
        return new HttpClientBuilder(uri).factory(factory).options(options).build();
    }

    /**
     * Creates a new HTTP client that connects to the specified {@link Endpoint} with
     * the {@link SessionProtocol} using the default {@link ClientFactory}.
     *
     * @param protocol the {@link SessionProtocol} of the {@link Endpoint}
     * @param endpoint the server {@link Endpoint}
     * @param options the {@link ClientOptionValue}s
     */
    static HttpClient of(SessionProtocol protocol, Endpoint endpoint, ClientOptionValue<?>... options) {
        return of(ClientFactory.DEFAULT, protocol, endpoint, options);
    }

    /**
     * Creates a new HTTP client that connects to the specified {@link Endpoint} with
     * the {@link SessionProtocol} using the default {@link ClientFactory}.
     *
     * @param protocol the {@link SessionProtocol} of the {@link Endpoint}
     * @param endpoint the server {@link Endpoint}
     * @param options the {@link ClientOptions}
     */
    static HttpClient of(SessionProtocol protocol, Endpoint endpoint, ClientOptions options) {
        return of(ClientFactory.DEFAULT, protocol, endpoint, options);
    }

    /**
     * Creates a new HTTP client that connects to the specified {@link Endpoint} with
     * the {@link SessionProtocol} using an alternative {@link ClientFactory}.
     *
     * @param factory an alternative {@link ClientFactory}
     * @param protocol the {@link SessionProtocol} of the {@link Endpoint}
     * @param endpoint the server {@link Endpoint}
     * @param options the {@link ClientOptionValue}s
     */
    static HttpClient of(ClientFactory factory, SessionProtocol protocol, Endpoint endpoint,
                         ClientOptionValue<?>... options) {
        return new HttpClientBuilder(protocol, endpoint).factory(factory).options(options).build();
    }

    /**
     * Creates a new HTTP client that connects to the specified {@link Endpoint} with
     * the {@link SessionProtocol} using an alternative {@link ClientFactory}.
     *
     * @param factory an alternative {@link ClientFactory}
     * @param protocol the {@link SessionProtocol} of the {@link Endpoint}
     * @param endpoint the server {@link Endpoint}
     * @param options the {@link ClientOptions}
     */
    static HttpClient of(ClientFactory factory, SessionProtocol protocol, Endpoint endpoint,
                         ClientOptions options) {
        return new HttpClientBuilder(protocol, endpoint).factory(factory).options(options).build();
    }

    /**
     * Sends the specified HTTP request.
     */
    HttpResponse execute(HttpRequest req);

    /**
     * Sends the specified HTTP request.
     */
    HttpResponse execute(AggregatedHttpRequest aggregatedReq);

    /**
     * Sends an empty HTTP request with the specified headers.
     */
    default HttpResponse execute(RequestHeaders headers) {
        return execute(AggregatedHttpRequest.of(headers));
    }

    /**
     * Sends an HTTP request with the specified headers and content.
     */
    default HttpResponse execute(RequestHeaders headers, HttpData content) {
        return execute(AggregatedHttpRequest.of(headers, content));
    }

    /**
     * Sends an HTTP request with the specified headers and content.
     */
    default HttpResponse execute(RequestHeaders headers, byte[] content) {
        return execute(AggregatedHttpRequest.of(headers, HttpData.wrap(content)));
    }

    /**
     * Sends an HTTP request with the specified headers and content.
     */
    default HttpResponse execute(RequestHeaders headers, String content) {
        return execute(AggregatedHttpRequest.of(headers, HttpData.ofUtf8(content)));
    }

    /**
     * Sends an HTTP request with the specified headers and content.
     */
    default HttpResponse execute(RequestHeaders headers, String content, Charset charset) {
        return execute(AggregatedHttpRequest.of(headers, HttpData.of(charset, content)));
    }

    /**
     * Sends an HTTP OPTIONS request.
     */
    default HttpResponse options(String path) {
        return execute(RequestHeaders.of(HttpMethod.OPTIONS, path));
    }

    /**
     * Sends an HTTP GET request.
     */
    default HttpResponse get(String path) {
        return execute(RequestHeaders.of(HttpMethod.GET, path));
    }

    /**
     * Sends an HTTP HEAD request.
     */
    default HttpResponse head(String path) {
        return execute(RequestHeaders.of(HttpMethod.HEAD, path));
    }

    /**
     * Sends an HTTP POST request with the specified content.
     */
    default HttpResponse post(String path, HttpData content) {
        return execute(RequestHeaders.of(HttpMethod.POST, path), content);
    }

    /**
     * Sends an HTTP POST request with the specified content.
     */
    default HttpResponse post(String path, byte[] content) {
        return execute(RequestHeaders.of(HttpMethod.POST, path), content);
    }

    /**
     * Sends an HTTP POST request with the specified content.
     */
    default HttpResponse post(String path, String content) {
        return execute(RequestHeaders.of(HttpMethod.POST, path), HttpData.ofUtf8(content));
    }

    /**
     * Sends an HTTP POST request with the specified content.
     */
    default HttpResponse post(String path, String content, Charset charset) {
        return execute(RequestHeaders.of(HttpMethod.POST, path), content, charset);
    }

    /**
     * Sends an HTTP PUT request with the specified content.
     */
    default HttpResponse put(String path, HttpData content) {
        return execute(RequestHeaders.of(HttpMethod.PUT, path), content);
    }

    /**
     * Sends an HTTP PUT request with the specified content.
     */
    default HttpResponse put(String path, byte[] content) {
        return execute(RequestHeaders.of(HttpMethod.PUT, path), content);
    }

    /**
     * Sends an HTTP PUT request with the specified content.
     */
    default HttpResponse put(String path, String content) {
        return execute(RequestHeaders.of(HttpMethod.PUT, path), HttpData.ofUtf8(content));
    }

    /**
     * Sends an HTTP PUT request with the specified content.
     */
    default HttpResponse put(String path, String content, Charset charset) {
        return execute(RequestHeaders.of(HttpMethod.PUT, path), content, charset);
    }

    /**
     * Sends an HTTP PATCH request with the specified content.
     */
    default HttpResponse patch(String path, HttpData content) {
        return execute(RequestHeaders.of(HttpMethod.PATCH, path), content);
    }

    /**
     * Sends an HTTP PATCH request with the specified content.
     */
    default HttpResponse patch(String path, byte[] content) {
        return execute(RequestHeaders.of(HttpMethod.PATCH, path), content);
    }

    /**
     * Sends an HTTP PATCH request with the specified content.
     */
    default HttpResponse patch(String path, String content) {
        return execute(RequestHeaders.of(HttpMethod.PATCH, path), HttpData.ofUtf8(content));
    }

    /**
     * Sends an HTTP PATCH request with the specified content.
     */
    default HttpResponse patch(String path, String content, Charset charset) {
        return execute(RequestHeaders.of(HttpMethod.PATCH, path), content, charset);
    }

    /**
     * Sends an HTTP DELETE request.
     */
    default HttpResponse delete(String path) {
        return execute(RequestHeaders.of(HttpMethod.DELETE, path));
    }

    /**
     * Sends an HTTP TRACE request.
     */
    default HttpResponse trace(String path) {
        return execute(RequestHeaders.of(HttpMethod.TRACE, path));
    }
}
