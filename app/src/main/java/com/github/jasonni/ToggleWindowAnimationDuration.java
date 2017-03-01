/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jasonni;

import android.service.quicksettings.TileService;

import static uk.co.nickbutcher.animatordurationtile.AnimatorDurationScaler.SCALE_TYPE_WINDOW;

/**
 * A {@link TileService quick settings tile} for scaling animation durations. Toggles between 1x and
 * 5x window animation duration scales.
 */
public class ToggleWindowAnimationDuration extends BaseTileService {

    @Override
    String getScaleType() {
        return SCALE_TYPE_WINDOW;
    }
}
