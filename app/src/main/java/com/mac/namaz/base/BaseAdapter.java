package com.mac.namaz.base;

/**
 * Created by arsalan.chishti on 8/9/2018.
 */
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private ArrayList<T> items;
    private Context context;

    /**
     * Default constructor.
     * @param context Associates this adapter with the specified context.
     */
    public BaseAdapter(Context context){
        super();
        this.context = context;
        this.items = new ArrayList<>();
    }

    /**
     * Overloaded constructor for conveniently adding a list of items on creation.
     * @param context Associates this adapter with the specified context.
     * @param items Adds this list of items into the underlying list data structure.
     */
    public BaseAdapter(Context context, ArrayList<T> items){
        super();
        this.context = context;
        this.items = items;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBindViewHolder(holder, getItem(position), position);
    }

    /**
     * Overloaded version of the onBindViewHolder method providing easier access to the item at this position.
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given
     *               position in the data set.
     * @param item The item at the specified position within the adapter's data set.
     * @param position The position of the item within the adapter's data set.
     */
    public abstract void onBindViewHolder(VH holder, T item, int position);

    @Override
    public int getItemCount() {
        if(items != null){
            return items.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int position){
        return getItem(position).hashCode();
    }

    /**
     * Retrieves the context associated with this adapter.
     * @return Context The context provided in the constructor.
     */
    public Context getContext(){
        return context;
    }

    /**
     * Retrieves the item at the specified position.
     * @param position The index in the adapter's data set where the item is located.
     * @return T The item at the specified position or null if the data set is null.
     */
    public T getItem(int position){
        if(items != null){
            return items.get(position);
        }
        return null;
    }

    /**
     * Retrieves the index of the specified item.
     * @param item The object whose position we are retrieving from the underlying data set.
     * @return int The index of the item or -1 if the data set is null or the item is not in the data set.
     */
    public int getPosition(T item){
        if(items != null){
            return items.indexOf(item);
        }
        return -1;
    }

    /**
     * Adds the item to the data set.
     * @param item The item to be added.
     */
    public void add(T item){
        if(items == null){
            items = new ArrayList<>();
        }
        items.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Adds all of the items to the data set.
     * @param items The item list to be added.
     */
    public void addAll(List<T> items){
        if(this.items == null){
            this.items = new ArrayList<>();
        }
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    /**
     * Adds all of the items to the data set.
     * @param items The item collection to be added.
     */
    public void addAll(Collection<T> items){
        if(this.items == null){
            this.items = new ArrayList<>();
        }
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    /**
     * Adds all of the items to the data set.
     * @param items The item array to be added.
     */
    public void addAll(T[] items){
        if(this.items == null){
            this.items = new ArrayList<>();
        }
        for(int i = 0; i < items.length; i++){
            this.items.add(items[i]);
        }
        notifyDataSetChanged();
    }

    /**
     * Removes the specified item from the underlying data set.
     * @param item The item to be removed.
     * @return boolean The boolean representing if the item was in the data set. True if the item was removed, false
     * if the item wasn't in the data set or the data set was null.
     */
    public boolean remove(T item){
        boolean b = false;
        if(items != null){
            int i = items.indexOf(item);
            b = items.remove(item);
            if(b && i != -1){
                notifyItemRemoved(i);
            }
        }
        return b;
    }

    /**
     * Inserts the specified item at the specified location in the underlying data set.
     * @param item The item to be inserted.
     * @param position The index where the item is to be inserted.
     */
    public void insert(T item, int position){
        if(items == null){
            items = new ArrayList<>();
        }
        this.items.add(position, item);
        notifyItemInserted(position);
    }

    /**
     * Clears all items from the data set.
     */
    public void clear(){
        if(items != null){
            items.clear();
            notifyDataSetChanged();
        }
    }

    /**
     * Sorts all the items in the data set.
     * @param comparator The comparator used to sort the items.
     */
    public void sort(Comparator<? super T> comparator){
        if(items != null){
            Collections.sort(items, comparator);
            notifyDataSetChanged();
        }
    }

}
