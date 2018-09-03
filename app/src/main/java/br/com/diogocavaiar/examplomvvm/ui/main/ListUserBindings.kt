package br.com.diogocavaiar.examplomvvm.ui.main

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import br.com.diogocavaiar.examplomvvm.domain.model.Item
import com.facebook.drawee.generic.RoundingParams
import com.facebook.drawee.view.SimpleDraweeView

object ListUsersBindings {

    @JvmStatic
    @BindingAdapter("load_users")
    fun loadUsers(recyclerView: RecyclerView, users: List<Item>?) {
        recyclerView.adapter = if (users != null) MainActiviyAdapter(users) else MainActiviyAdapter(emptyList())
    }

    @JvmStatic
    @BindingAdapter("load_user_avatar")
    fun loadUserAvatar(simpleDraweeView: SimpleDraweeView, item: Item?) {
        val roundingParams = RoundingParams.fromCornersRadius(5f)
        roundingParams.roundAsCircle = true

        simpleDraweeView.hierarchy.roundingParams = roundingParams
        simpleDraweeView.setImageURI(item?.owner?.avatar_url)
    }
}