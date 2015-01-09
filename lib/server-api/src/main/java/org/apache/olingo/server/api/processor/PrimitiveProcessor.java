/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.server.api.processor;

import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.server.api.ODataApplicationException;
import org.apache.olingo.server.api.ODataRequest;
import org.apache.olingo.server.api.ODataResponse;
import org.apache.olingo.server.api.deserializer.DeserializerException;
import org.apache.olingo.server.api.serializer.SerializerException;
import org.apache.olingo.server.api.uri.UriInfo;

/**
 * Processor interface for handling an instance of a primitive type, e.g., a primitive property of an entity.
 */
public interface PrimitiveProcessor extends Processor {

  /**
   * Reads primitive-type instance.
   * If its value is <code>null</code>, the service responds with 204 No Content.
   * If it is not available, for example due to permissions, the service responds with 404 Not Found.
   * @param request  OData request object containing raw HTTP information
   * @param response OData response object for collecting response data
   * @param uriInfo  information of a parsed OData URI
   * @param responseFormat   requested content type after content negotiation
   * @throws ODataApplicationException if the service implementation encounters a failure
   * @throws SerializerException       if serialization failed
   */
  void readPrimitive(ODataRequest request, ODataResponse response, UriInfo uriInfo, ContentType responseFormat)
      throws ODataApplicationException, SerializerException;

  /**
   * Update primitive-type instance with send data in the persistence and
   * puts content, status, and Location into the response.
   * @param request  OData request object containing raw HTTP information
   * @param response OData response object for collecting response data
   * @param uriInfo  information of a parsed OData URI
   * @param requestFormat   content type of body sent with request
   * @param responseFormat   requested content type after content negotiation
   * @throws ODataApplicationException if the service implementation encounters a failure
   * @throws DeserializerException     if deserialization failed
   * @throws SerializerException       if serialization failed
   */
  void updatePrimitive(ODataRequest request, ODataResponse response, UriInfo uriInfo,
                    ContentType requestFormat, ContentType responseFormat)
          throws ODataApplicationException, DeserializerException, SerializerException;

  /**
   * Deletes primitive-type value from an entity and puts the status into the response.
   * Deletion for primitive-type values is equal to
   * set the value to <code>NULL</code> (see chapter "11.4.9.2 Set a Value to Null")
   * @param request  OData request object containing raw HTTP information
   * @param response OData response object for collecting response data
   * @param uriInfo  information of a parsed OData URI
   * @throws ODataApplicationException if the service implementation encounters a failure
   */
  void deletePrimitive(ODataRequest request, ODataResponse response, UriInfo uriInfo)
          throws ODataApplicationException;

  /**
   * Process an action which has as return type a primitive-type.
   * @param request  OData request object containing raw HTTP information
   * @param response OData response object for collecting response data
   * @param uriInfo  information of a parsed OData URI
   * @param requestFormat   content type of body sent with request
   * @param responseFormat   requested content type after content negotiation
   * @throws ODataApplicationException if the service implementation encounters a failure
   * @throws DeserializerException     if deserialization failed
   * @throws SerializerException       if serialization failed
   */
  void processPrimitive(ODataRequest request, ODataResponse response, UriInfo uriInfo,
                                  ContentType requestFormat, ContentType responseFormat)
          throws ODataApplicationException, DeserializerException, SerializerException;
}