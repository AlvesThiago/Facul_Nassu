package com.projeto.shopshoes.view.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.projeto.shopshoes.R;
import com.projeto.shopshoes.view.activities.MainActivity;

public class HomeFragment extends Fragment {

    private LinearLayout mLLPessoas;
    private LinearLayout mLLEstatisticas;


    private View view;

    Toolbar mToolbar;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        mToolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mToolbar.setTitle("Redes APK");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window w = getActivity().getWindow();
            w.setStatusBarColor(getActivity().getResources().getColor(R.color.colorPrimaryDark));
            w.setNavigationBarColor(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary, getActivity().getTheme()));
        }else{
            //noinspection deprecation
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        mLLPessoas = (LinearLayout)view.findViewById(R.id.ll_listar_pessoas);
        mLLPessoas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = null;
                fragment = new SneakersFragment();
                if (fragment != null) {
                    // Insert the fragment by replacing any existing fragment
                    // Insert the fragment by replacing any existing fragment
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_content, fragment)
                            .commit();
                }
            }
        });

        mLLEstatisticas = (LinearLayout)view.findViewById(R.id.ll_listar_estatisticas);
        mLLEstatisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder caixaDeDialogo = new AlertDialog.Builder(getActivity());
                caixaDeDialogo.setTitle("Sobre");
                caixaDeDialogo.setMessage("O Redes APK ?? um aplicativo que tem como objetivo simular a vendas de t??nis e sapatos.\n\n" +
                        "Alunos:\nThiago Alves\n" +
                        "Raniele Santos S??\n" +
                        "Paulo Gabriel Marques da Cunha de Souza\n" +
                        "Eduardo Almeida Viana\n" +
                        "Renan Isikawa Pinto da Silva\n" +
                        "Gabriel de Paula Jesus \n\n" +
                        "Institui????o: FMU \n\n" +
                        "Curso: SISTEMAS DA INFORMA????O \n\n" +
                        "Professor: EUGENIO AKIHIRO NASSU \n\n" +
                        "Disciplina: COMPUTACAO PARA DISPOSITIVOS MOVEIS \n\n");
                // Adicona um bot??o FECHAR
                caixaDeDialogo.setNeutralButton("Fechar", null);
                caixaDeDialogo.create().show();
            }
        });

        return view;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
