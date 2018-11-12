package hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hcww.com.orchtech.hcww.mvpebrd.R;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.contactuslist.ContactUsList;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BaseViewHolder;

public class ContactUsListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private Callback mCallback;
    private Callback mOnItemClickListener;


    private List<ContactUsList> mContactUsResponseList;

    public ContactUsListAdapter(List<ContactUsList> mContactUsResponseList) {
        this.mContactUsResponseList = mContactUsResponseList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }
    public void setClickListener(Callback itemClickListener) {
        this.mOnItemClickListener= itemClickListener;
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_us_list, parent, false));
            case VIEW_TYPE_EMPTY:
                return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
            default:
                return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if(mContactUsResponseList != null && mContactUsResponseList.size() > 0){
            return mContactUsResponseList.size();
        }else{
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mContactUsResponseList != null && mContactUsResponseList.size() > 0)
        {
            return VIEW_TYPE_NORMAL;
        }else{
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public long getItemId(int position) {
        return mContactUsResponseList.get(position).getId();
    }

    public void addItems(List<ContactUsList> contactUsList)
    {
        mContactUsResponseList.addAll(contactUsList);
        notifyDataSetChanged();
    }
    public interface Callback {
        void onContactUsListEmptyViewRetryClick();
        void onContactUsListClick(int position);
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.contact_us_text)
        TextView companyTitleTxt;
        @BindView(R.id.contact_us_list_image)
        ImageView companyImg;
        @BindView(R.id.divider)
        View dividerView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            final ContactUsList contactUsList = mContactUsResponseList.get(position);
            if(contactUsList.getImageUrl() != null)
            {
                Glide.with(itemView.getContext())
                        .load(contactUsList.getImageUrl())
                        .asBitmap()
                        .into(companyImg);
            }
            if(contactUsList.getTitle() != null)
            {
                companyTitleTxt.setText(contactUsList.getTitle());
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mOnItemClickListener != null)
                    {
                        mOnItemClickListener.onContactUsListClick(getAdapterPosition());
                    }
                }
            });
        }

        @Override
        protected void clear() {
            companyImg.setImageDrawable(null);
            companyTitleTxt.setText("");
        }

    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.no_internet_connection_txt)
        TextView noInternetConnectionTxt;

        @BindView(R.id.fail_view_button)
        CardView retryCard;

        @BindView(R.id.retry_txt)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.fail_view_button)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onContactUsListEmptyViewRetryClick();
        }
    }

}
