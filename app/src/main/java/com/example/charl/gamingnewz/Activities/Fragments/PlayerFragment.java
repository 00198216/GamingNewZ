package com.example.charl.gamingnewz.Activities.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charl.gamingnewz.Activities.Adapters.JugadoresAdapter;
import com.example.charl.gamingnewz.Activities.Adapters.NewsAdapter;
import com.example.charl.gamingnewz.Activities.POJO.News;
import com.example.charl.gamingnewz.Activities.POJO.Players;
import com.example.charl.gamingnewz.Activities.Room.ViewModel.NewsViewModel;
import com.example.charl.gamingnewz.Activities.Room.ViewModel.PlayersViewModel;
import com.example.charl.gamingnewz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView rv;
    JugadoresAdapter adapter;
    PlayersViewModel NViewModel;
    LinearLayoutManager LManager;
    public int valor;
    private String  Game;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PlayerFragment() {
        // Required empty public constructor
    }

    public PlayerFragment(int p) {
        valor= p;
    }


    // TODO: Rename and change types and number of parameters
    public static PlayerFragment newInstance(int p) {
        PlayerFragment fragment = new PlayerFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            final View vista = inflater.inflate(R.layout.fragment_player, container, false);
            rv = vista.findViewById(R.id.recycler2);

        SharedPreferences sharedPref = getContext().getSharedPreferences("Game",Context.MODE_PRIVATE);
        Game = sharedPref.getString("Games","");

        if(Game.contains("League of Legends") ) {
            NViewModel = ViewModelProviders.of(this).get(PlayersViewModel.class);
            NViewModel.getLolPlayers().observe(this, new Observer<List<Players>>() {


                @Override
                public void onChanged(@Nullable List<Players> players) {
                    adapter = new JugadoresAdapter((ArrayList<Players>) players, getContext());
                    LManager = new LinearLayoutManager(getActivity());


                    rv.setLayoutManager(LManager);
                    rv.setAdapter(adapter);
                }
            });
        }

        if(Game.contains("Overwatch") ) {
            NViewModel = ViewModelProviders.of(this).get(PlayersViewModel.class);
            NViewModel.getOverPlayers().observe(this, new Observer<List<Players>>() {


                @Override
                public void onChanged(@Nullable List<Players> players) {
                    adapter = new JugadoresAdapter((ArrayList<Players>) players, getContext());
                    LManager = new LinearLayoutManager(getActivity());


                    rv.setLayoutManager(LManager);
                    rv.setAdapter(adapter);
                }
            });
        }


        if(Game.contains("CSGO") ) {
            NViewModel = ViewModelProviders.of(this).get(PlayersViewModel.class);
            NViewModel.getCsgoPlayers().observe(this, new Observer<List<Players>>() {


                @Override
                public void onChanged(@Nullable List<Players> players) {
                    adapter = new JugadoresAdapter((ArrayList<Players>) players, getContext());
                    LManager = new LinearLayoutManager(getActivity());


                    rv.setLayoutManager(LManager);
                    rv.setAdapter(adapter);
                }
            });
        }

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
