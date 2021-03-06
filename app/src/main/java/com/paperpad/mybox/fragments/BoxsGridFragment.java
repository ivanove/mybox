package com.paperpad.mybox.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.paperpad.mybox.R;
import com.paperpad.mybox.activities.BoxsMainActivity;
import com.paperpad.mybox.adapters.MyBoxGridCategoriesAdapter;
import com.paperpad.mybox.controllers.DatabaseController;
import com.paperpad.mybox.helpers.BoxComparator;
import com.paperpad.mybox.models.Colors;
import com.paperpad.mybox.models.MyBox;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class BoxsGridFragment extends Fragment {
	
	protected int id_cat = 0;
	private List<MyBox> boxs;
	private DatabaseController appController;
	protected MyBoxGridCategoriesAdapter myboxGridAdapter;


	static BoxsListFragment newInstance() {
		BoxsListFragment frag = new BoxsListFragment();
		Bundle args=new Bundle();
		frag.setArguments(args);
		return(frag);
	}
	private GridView grid;
	private Colors colors;

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onAttach(android.app.Activity)
	 */
	@Override
	public void onAttach(Activity activity) {
		
		((BoxsMainActivity)getActivity()).bodyFragment = "BoxsGridFragment";
				
		appController = new DatabaseController(getActivity());
		
		int orderMode = 0;
		if (getArguments() != null) {
			id_cat = getArguments().getInt("id_categorie");
			orderMode = getArguments().getInt("orderMode");
		}else {
			id_cat = ((BoxsMainActivity)getActivity()).id_selected_cat;
		}
		boxs = appController.getAllCategoryBoxs(id_cat, MainContentFragment.minPrice, MainContentFragment.maxPrice);
		//MainContentFragment.maxPrice = appController.getMax(id_cat);
		//MainContentFragment.minPrice = appController.getMin(id_cat);
//		FragmentUtils.getParent(BoxsGridFragment.this, callbackInterface)
		if (orderMode == 0) {

			Collections.reverse(boxs);
		} else if (orderMode == 1) {
			filterByTitle();
		} else if (orderMode == 2) {
			filterByPrice();
		}
		super.onAttach(activity);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
//		setRetainInstance(true);
		super.onCreate(savedInstanceState);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.mybox_grid_fragment, container, false);
		

		try {
			//colors = appController.getColorsDao().queryForAll().get(0);
            colors = (appController.getColorsDao().queryForId(1) == null) ? new Colors() : appController.getColorsDao().queryForId(1);
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		grid = (GridView)view.findViewById(R.id.grid);
		myboxGridAdapter = new MyBoxGridCategoriesAdapter(boxs, getActivity(), colors);
		grid.setAdapter(myboxGridAdapter);
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				MyBox box = (MyBox) arg0.getItemAtPosition(arg2);
				BoxsPagerFragment  boxsPagerFragment = new BoxsPagerFragment();
				Bundle bundle = new Bundle();
				((BoxsMainActivity)getActivity()).id_selected_cat = box.getId_categorie();
				bundle.putInt("box_id", box.getId());
				bundle.putInt("category_id", box.getId_categorie());
				boxsPagerFragment.setArguments(bundle);
				getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, boxsPagerFragment).addToBackStack(null).commit();
				
				/*MyBoxPageFragment boxPageFragment = new MyBoxPageFragment();
				Bundle bundle = new Bundle();
				((BoxsMainActivity)getActivity()).id_selected_cat = box.getId();
				bundle.putInt("box_id", box.getId());
				boxPageFragment.setArguments(bundle);
//				FooterFragment footerFragment = (FooterFragment) getActivity().getSupportFragmentManager().findFragmentByTag(BoxsMainActivity.FOOTER_FRAGMENT);
//				if (footerFragment != null) {
//					getActivity().getSupportFragmentManager().beginTransaction().remove(footerFragment);	
//				}
//				getActivity().findViewById(R.id.box_page_fragment).setVisibility(View.VISIBLE);
				getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, boxPageFragment).addToBackStack(null).commit();*/
				
			}
		});

		return view;
	}


	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	public void selectCategory(int id_cat) {
		this.id_cat = id_cat; 
		boxs = appController.getAllCategoryBoxs(id_cat, MainContentFragment.minPrice, MainContentFragment.maxPrice);
		refreshListView();
	}

	/**
	 * 
	 */
	private void refreshListView() {
		myboxGridAdapter.setBoxs(boxs);
		myboxGridAdapter.notifyDataSetChanged();
	}
	
	
	public void filterByPrice(){
		Collections.sort(boxs, new BoxComparator());
		refreshListView();
	}
	
	public void filterByDate(){
		boxs = appController.getAllCategoryBoxs(id_cat, MainContentFragment.minPrice, MainContentFragment.maxPrice);
		refreshListView();
	}
	
	public void filterByTitle(){
		boxs = appController.getAllCategoryBoxsABCOrder(id_cat, MainContentFragment.minPrice, MainContentFragment.maxPrice);
		refreshListView();
	}
	
	public void priceRange(int min, int max) {
		boxs = appController.getBoxsInRange(id_cat, min, max);
		refreshListView();
	}
	
	public void getBoxsInRange(){
		
	}

	/**
	 * @return the boxs
	 */
	public List<MyBox> getBoxs() {
		return boxs;
	}

	/**
	 * @param boxs the boxs to set
	 */
	public void setBoxs(List<MyBox> boxs) {
		this.boxs = boxs;
	}

	/**
	 * @return the id_cat
	 */
	public int getId_cat() {
		return id_cat;
	}

	/**
	 * @param id_cat the id_cat to set
	 */
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

}
