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
package org.apache.olingo.client.core.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.client.api.domain.ClientAnnotation;
import org.apache.olingo.client.api.domain.ClientProperty;
import org.apache.olingo.client.api.domain.ClientValue;

public final class ClientPropertyImpl extends ClientValuableImpl implements ClientProperty {

  private final List<ClientAnnotation> annotations = new ArrayList<ClientAnnotation>();
  private final String name;

  public ClientPropertyImpl(final String name, final ClientValue value) {
    super(value);
    this.name = name;
  }

  /**
   * Returns property name.
   *
   * @return property name.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Checks if has null value.
   *
   * @return 'TRUE' if has null value; 'FALSE' otherwise.
   */
  @Override
  public boolean hasNullValue() {
    return value == null || value.isPrimitive() && value.asPrimitive().toValue() == null;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !(obj instanceof ClientPropertyImpl)) {
      return false;
    }
    final ClientPropertyImpl other = (ClientPropertyImpl) obj;
    return annotations.equals(other.annotations)
        && (name == null ? other.name == null : name.equals(other.name))
        && (value == null ? other.value == null : value.equals(other.value));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((annotations == null) ? 0 : annotations.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public List<ClientAnnotation> getAnnotations() {
    return annotations;
  }

  @Override
  public String toString() {
    return "ClientPropertyImpl{" + "name=" + name + ", value=" + value + ", annotations=" + annotations + '}';
  }
}
