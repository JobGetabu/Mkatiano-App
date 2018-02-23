package com.job.mkatiano

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.*


/**
 * Created by JOB on 2/22/2018.
 *
 * Additional text on this class
 * @layout is used to bind the layout with this class.
 * @View is used to bind the views in a layout we want to refer to.
 * @Resolve annotation bind a method to be executed when the view is ready to be used.
 * Any operation we want to perform on view references should be written in a method and annotated with this.
 * @SwipeOut calls the annotated method when the card has been rejected.
 * @SwipeIn calls the annotated method when the card has be accepted.
 * @SwipeCancelState calls the annotated method when the card is put back in the deck/canceled.
 * @SwipeInState pings the annotated method till the card is moving in accepted state.
 * @SwipeOutState pings the annotated method till the card is moving in rejected state.
 * IMPORTANT: If we don’t plan to re add a view then the class should be annotated with
 * @NonReusable so that the references are released and memory is optimises.
 * For the demonstration, we are adding a view back in the deck
 * if rejected, so we have not used
 * @NonReusable.
 */

@Layout(R.layout.tinder_card_view)
class TinderCard(private val mContext: Context, private val mProfile: Profile, private val mSwipeView: SwipePlaceHolderView) {

    @View(R.id.profileImageView)
    private val profileImageView: ImageView? = null

    @View(R.id.nameAgeTxt)
    private val nameAgeTxt: TextView? = null

    @View(R.id.locationNameTxt)
    private val locationNameTxt: TextView? = null

    @Resolve
    private fun onResolved() {
        Glide.with(mContext).load(mProfile.imageUrl).into(profileImageView!!)
        nameAgeTxt!!.text = mProfile.name + ", " + mProfile.age
        locationNameTxt!!.text = mProfile.location
    }

    @SwipeOut
    private fun onSwipedOut() {
        Log.d("EVENT", "onSwipedOut")
        mSwipeView.addView(this)
    }

    @SwipeCancelState
    private fun onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState")
    }

    @SwipeIn
    private fun onSwipeIn() {
        Log.d("EVENT", "onSwipedIn")
    }

    @SwipeInState
    private fun onSwipeInState() {
        Log.d("EVENT", "onSwipeInState")
    }

    @SwipeOutState
    private fun onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState")
    }
}