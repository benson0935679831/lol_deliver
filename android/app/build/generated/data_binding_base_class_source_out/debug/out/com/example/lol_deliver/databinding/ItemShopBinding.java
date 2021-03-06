// Generated by view binder compiler. Do not edit!
package com.example.lol_deliver.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lol_deliver.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemShopBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ivLike;

  @NonNull
  public final ImageView ivSkShopIcon;

  @NonNull
  public final ImageView ivStar;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView tvShopDetail;

  @NonNull
  public final TextView tvShopName;

  @NonNull
  public final TextView tvShopStar;

  private ItemShopBinding(@NonNull LinearLayout rootView, @NonNull ImageView ivLike,
      @NonNull ImageView ivSkShopIcon, @NonNull ImageView ivStar,
      @NonNull LinearLayout linearLayout, @NonNull TextView tvShopDetail,
      @NonNull TextView tvShopName, @NonNull TextView tvShopStar) {
    this.rootView = rootView;
    this.ivLike = ivLike;
    this.ivSkShopIcon = ivSkShopIcon;
    this.ivStar = ivStar;
    this.linearLayout = linearLayout;
    this.tvShopDetail = tvShopDetail;
    this.tvShopName = tvShopName;
    this.tvShopStar = tvShopStar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemShopBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_shop, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemShopBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_like;
      ImageView ivLike = ViewBindings.findChildViewById(rootView, id);
      if (ivLike == null) {
        break missingId;
      }

      id = R.id.iv_sk_shopIcon;
      ImageView ivSkShopIcon = ViewBindings.findChildViewById(rootView, id);
      if (ivSkShopIcon == null) {
        break missingId;
      }

      id = R.id.iv_star;
      ImageView ivStar = ViewBindings.findChildViewById(rootView, id);
      if (ivStar == null) {
        break missingId;
      }

      LinearLayout linearLayout = (LinearLayout) rootView;

      id = R.id.tv_shopDetail;
      TextView tvShopDetail = ViewBindings.findChildViewById(rootView, id);
      if (tvShopDetail == null) {
        break missingId;
      }

      id = R.id.tv_shopName;
      TextView tvShopName = ViewBindings.findChildViewById(rootView, id);
      if (tvShopName == null) {
        break missingId;
      }

      id = R.id.tv_shopStar;
      TextView tvShopStar = ViewBindings.findChildViewById(rootView, id);
      if (tvShopStar == null) {
        break missingId;
      }

      return new ItemShopBinding((LinearLayout) rootView, ivLike, ivSkShopIcon, ivStar,
          linearLayout, tvShopDetail, tvShopName, tvShopStar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
