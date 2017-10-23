/*
 * Copyright (C) 2015 Paul Burke
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

package com.example.user1.tablayout_viewpager.ItemTouchHelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ItemTouchRecyclerViewAdapter<T>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Context context;

    protected List<T> items = new ArrayList<>();

    public ItemTouchRecyclerViewAdapter(Context context, List<T> items) {
        this.context = context;
        this.items.addAll(items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(items,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }
    public void onItemDismiss(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }
}
