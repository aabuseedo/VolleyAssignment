package com.example.volleyassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.tvId.setText("ID: " + user.getId());
        holder.tvName.setText("Name: " + user.getName());
        holder.tvUsername.setText("Username: " + user.getUsername());
        holder.tvEmail.setText("Email: " + user.getEmail());
        holder.tvAddress.setText("Address: " + user.getAddress());
        holder.tvPhone.setText("Phone: " + user.getPhone());
        holder.tvWebsite.setText("Website: " + user.getWebsite());
        holder.tvCompanyName.setText("Company: " + user.getCompanyName());
        holder.tvCatchPhrase.setText("CatchPhrase: " + user.getCatchPhrase());
        holder.tvBs.setText("BS: " + user.getBs());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvUsername, tvEmail, tvAddress, tvPhone, tvWebsite, tvCompanyName, tvCatchPhrase, tvBs;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvWebsite = itemView.findViewById(R.id.tvWebsite);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            tvCatchPhrase = itemView.findViewById(R.id.tvCatchPhrase);
            tvBs = itemView.findViewById(R.id.tvBs);
        }
    }
}

