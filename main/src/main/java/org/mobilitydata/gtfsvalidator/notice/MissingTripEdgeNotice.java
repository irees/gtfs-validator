/*
 * Copyright 2021 MobilityData IO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mobilitydata.gtfsvalidator.notice;

import com.google.common.collect.ImmutableMap;

/**
 * "First and last stop of a trip must define both `arrival_time` and `departure_time` fields."
 *
 * <p>"If there are not separate times for arrival and departure at a stop, enter the same value for
 * arrival_time and departure_time."
 *
 * <p>(http://gtfs.org/reference/static/#stop_timestxt)
 *
 * <p>Severity: {@code SeverityLevel.ERROR}
 */
public class MissingTripEdgeNotice extends ValidationNotice {
  public MissingTripEdgeNotice(
      long csvRowNumber, int stopSequence, String tripId, String specifiedField) {
    super(
        ImmutableMap.of(
            "csvRowNumber", csvRowNumber,
            "stopSequence", stopSequence,
            "tripId", tripId,
            "specifiedField", specifiedField),
        SeverityLevel.ERROR);
  }

  @Override
  public String getCode() {
    return "missing_trip_edge_arrival_time_departure_time";
  }
}
