package you.fuck.i.ecommerceapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import you.fuck.i.ecommerceapp.R;
import you.fuck.i.ecommerceapp.db.CartDAO;
import you.fuck.i.ecommerceapp.ui.adapter.CartAdapter;


public class FragmentCart extends Fragment {
    private CartDAO dao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dao = new CartDAO(getActivity());
        dao.open();
        RecyclerView rvCart = (RecyclerView)view.findViewById(R.id.rvcart);
        rvCart.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCart.setAdapter(new CartAdapter(getActivity(),dao.getProductModels()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dao.close();
    }
}
