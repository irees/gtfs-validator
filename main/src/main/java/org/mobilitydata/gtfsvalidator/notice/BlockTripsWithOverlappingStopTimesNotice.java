package org.mobilitydata.gtfsvalidator.notice;

import com.google.common.collect.ImmutableMap;
import org.mobilitydata.gtfsvalidator.type.GtfsDate;

/**
 * Describes two trips with the same block id that have overlapping stop times.
 *
 * <p>Severity: {@code SeverityLevel.ERROR}
 */
public class BlockTripsWithOverlappingStopTimesNotice extends ValidationNotice {
  public BlockTripsWithOverlappingStopTimesNotice(
      long csvRowNumberA,
      String tripIdA,
      String serviceIdA,
      long csvRowNumberB,
      String tripIdB,
      String serviceIdB,
      String blockId,
      GtfsDate intersection) {
    super(
        new ImmutableMap.Builder<String, Object>()
            .put("csvRowNumberA", csvRowNumberA)
            .put("tripIdA", tripIdA)
            .put("serviceIdA", serviceIdA)
            .put("csvRowNumberB", csvRowNumberB)
            .put("tripIdB", tripIdB)
            .put("serviceIdB", serviceIdB)
            .put("blockId", blockId)
            .put("intersection", intersection.toYYYYMMDD())
            .build(),
        SeverityLevel.ERROR);
  }
}
