

package com.subhipandey.android.spacingout

class SpacingAnalytics {
  fun logEvent(event: String, attributes: Map<String, String> = emptyMap()) {
    val newAttribtues = attributes.toMutableMap()
    print("Logging a event with event name $event")
    newAttribtues["client_type"] = "Android"
    newAttribtues["version"] = "1"
    ThirdPartyAnalyticsProvider.logEvent(event, newAttribtues)
  }
}