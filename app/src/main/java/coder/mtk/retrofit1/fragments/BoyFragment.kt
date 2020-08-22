package coder.mtk.retrofit1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.retrofit1.R
import coder.mtk.retrofit1.adapter.BoyAdapter
import coder.mtk.retrofit1.api.BoyApiClient
import coder.mtk.retrofit1.model.BoyItem
import kotlinx.android.synthetic.main.fragment_boy.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BoyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_boy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBoy()
    }
    fun getBoy (){
        val boyApiClient =BoyApiClient()
        val boyApiCall = boyApiClient.postApiService.getBoy()

        boyApiCall.enqueue(
            object  : Callback<ArrayList<BoyItem>>{
                override fun onFailure(call: Call<ArrayList<BoyItem>>, t: Throwable) {
                    Toast.makeText(
                        context,
                        t.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(
                    call: Call<ArrayList<BoyItem>>,
                    response: Response<ArrayList<BoyItem>>
                ) {
                    boyRecyclerView.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = BoyAdapter(response.body()!!)
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