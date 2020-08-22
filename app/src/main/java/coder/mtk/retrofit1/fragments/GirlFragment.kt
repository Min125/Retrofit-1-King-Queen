package coder.mtk.retrofit1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk.retrofit1.R
import coder.mtk.retrofit1.adapter.BoyAdapter
import coder.mtk.retrofit1.adapter.GirlAdapter
import coder.mtk.retrofit1.api.BoyApiClient
import coder.mtk.retrofit1.api.GirlApiClient
import coder.mtk.retrofit1.model.BoyItem
import coder.mtk.retrofit1.model.GirlItem
import kotlinx.android.synthetic.main.fragment_boy.*
import kotlinx.android.synthetic.main.fragment_girl.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GirlFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_girl, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getGirl()


    }
    fun getGirl (){
        val boyApiClient = GirlApiClient()
        val boyApiCall = boyApiClient.postGirlApiService.getGirl()

        boyApiCall.enqueue(
            object  : Callback<ArrayList<GirlItem>> {
                override fun onFailure(call: Call<ArrayList<GirlItem>>, t: Throwable) {
                    Toast.makeText(
                        context,
                        t.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(
                    call: Call<ArrayList<GirlItem>>,
                    response: Response<ArrayList<GirlItem>>
                ) {

                    girlRecyclerView.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = GirlAdapter(response.body()!!)
                    }

                    Toast.makeText(
                        context,
                        response.toString(),
                        Toast.LENGTH_LONG
                    )
                }
            }
        )

}
}