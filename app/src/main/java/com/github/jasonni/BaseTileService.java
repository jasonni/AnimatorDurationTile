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

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import uk.co.nickbutcher.animatordurationtile.AnimatorDurationScaler;
import uk.co.nickbutcher.animatordurationtile.SelectAnimatorDuration;

import static uk.co.nickbutcher.animatordurationtile.AnimatorDurationScaler.getAnimatorScale;
import static uk.co.nickbutcher.animatordurationtile.AnimatorDurationScaler.getIcon;

/**
 * A {@link TileService quick settings tile} for scaling animation durations. Toggles between 1x and
 * 5x animator duration scales.
 */
public abstract class BaseTileService extends TileService {

    public BaseTileService() { }

    @Override
    public void onStartListening() {
        super.onStartListening();
        updateTile();
    }

    @Override
    public void onClick() {
        Intent intent = new Intent(this, SelectAnimatorDuration.class);
        intent.putExtra("SCALE_TYPE", getScaleType());
        startActivityAndCollapse(intent);
    }

    private void updateTile() {
        final float scale = getAnimatorScale(getContentResolver(), getScaleType());
        final Tile tile = getQsTile();
        tile.setIcon(Icon.createWithResource(getApplicationContext(), getIcon(scale)));
        tile.updateTile();
    }

    abstract @AnimatorDurationScaler.ScaleType String getScaleType();
}
