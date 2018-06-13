package com.example.charl.gamingnewz.Activities.Fragments;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.charl.gamingnewz.Activities.Adapters.NewsAdapter;
import com.example.charl.gamingnewz.Activities.Interfaces.GamingNewZAPI;
import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.Activities.Room.ViewModel.NewsViewModel;
import com.example.charl.gamingnewz.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainNews.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainNews#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainNews extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView rv;
    NewsAdapter adapter;
    NewsViewModel NViewModel;
    GridLayoutManager gManager;
    public int valor;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainNews() {
        // Required empty public constructor
    }

    public MainNews(int p) {
        valor = p;
    }




    // TODO: Rename and change types and number of parameters
    public static MainNews newInstance(int p) {
        MainNews fragment = new MainNews();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista = inflater.inflate(R.layout.fragment_main_news, container, false);
        rv = vista.findViewById(R.id.recycler);


        NViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        NViewModel.getAllNews().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(@Nullable List<News> news) {
                adapter = new NewsAdapter((ArrayList<News>)news,getContext());
                gManager = new GridLayoutManager(getActivity(), 2);
                gManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (position % 3 == 0) {
                            return 2;
                        } else {
                            return 1;
                        }
                    }
                });


                rv.setLayoutManager(gManager);
                rv.setAdapter(adapter);
            }
        });

        return vista;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
