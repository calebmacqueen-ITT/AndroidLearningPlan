package com.intimetec.androidlearningwk1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_example.*

class FragmentExample : Fragment() {
    private var starList: ArrayList<ImageView> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        starList.add(ivStar1)
        starList.add(ivStar2)
        starList.add(ivStar3)
        starList.add(ivStar4)
        starList.add(ivStar5)

        rgArticleLikeRadioButtons.setOnCheckedChangeListener { radioGroup, i ->
            rbGroupCheckedChanged()
        }

        for(image in starList){
            image.setOnClickListener {
                val index = getIndexOfClickedImage(image)
                fillStars(index)
                val toast = Toast.makeText(context!!, "My Rating: " + (index+1), Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    private fun fillStars(selectedIndex: Int){
        for(i in 0 until starList.size){
            if(i <= selectedIndex) {
                starList[i].setImageDrawable(context!!.getDrawable(R.drawable.star_filled))
            } else {
                starList[i].setImageDrawable(context!!.getDrawable(R.drawable.star_empty))
            }
        }
    }

    private fun getIndexOfClickedImage(clickedImage: ImageView): Int{
        when (clickedImage.id){
            R.id.ivStar1 -> return 0
            R.id.ivStar2 -> return 1
            R.id.ivStar3 -> return 2
            R.id.ivStar4 -> return 3
            R.id.ivStar5 -> return 4
            else -> return 0
        }
    }

    private fun rbGroupCheckedChanged(){
        if(rbYes.isChecked){
            tvLikeSong.visibility = View.VISIBLE
            for(image in starList){
                image.visibility = View.VISIBLE
            }
        } else if(rbNo.isChecked) {
            tvLikeSong.visibility = View.GONE
            for(image in starList){
                image.visibility = View.GONE
            }
        }
    }
}
