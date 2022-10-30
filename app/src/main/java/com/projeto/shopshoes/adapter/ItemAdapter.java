package com.projeto.shopshoes.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projeto.shopshoes.R;
import com.projeto.shopshoes.model.Sneaker;

public class ItemAdapter extends ArrayAdapter<Sneaker> {
	private final Activity activity;
	private final  List<Sneaker> sneakers;
	Sneaker sneaker;


	/**
	 * Description: Construtor mínimo para fazer a adaptação dos dados
	 */
	public ItemAdapter(Activity activity, int textViewResourceId, List<Sneaker> sneakers) {
		//Chamada do metodo pai
		super(activity, textViewResourceId, sneakers);
		//Insersao da atividade
		this.activity = activity;
		//Lista de itens do tipo Item recebida como parâmetro pelo construtor
		this.sneakers = sneakers;
	}

	/**
	 * As views definidas no layout "model_item_list.xml" são setadas com
	 * os dados da lista passada por parâmetro (carregadas do banco de dados).
	 * Este Resource Layout será retornado como um item do tipo View
	 * para ser adicionado na ListView do definida no layout
	 * "fragment_activity_lista_itens.xml". Este método será chamado para cada
	 * item da lista passada por parametro, fazendo com que a ListView
	 * mostre todos os itens passados.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		sneaker = sneakers.get(position);
		@SuppressLint("ViewHolder") View view = activity.getLayoutInflater().inflate(
				R.layout.model_item_list, null);

		ImageView imageResource = (ImageView) view.findViewById(R.id.iv_sneaker);
		// Set iv_sneaker in ImageView
		imageResource.setImageResource(sneaker.getImageResource());

		ImageView iv_sneaker_gallery_01 = (ImageView) view.findViewById(R.id.iv_sneaker_gallery_01);
		ImageView iv_sneaker_gallery_02 = (ImageView) view.findViewById(R.id.iv_sneaker_gallery_02);
		ImageView iv_sneaker_gallery_03 = (ImageView) view.findViewById(R.id.iv_sneaker_gallery_03);
		iv_sneaker_gallery_01.setImageResource(sneaker.getAlbum()[0]);
		iv_sneaker_gallery_02.setImageResource(sneaker.getAlbum()[1]);
		iv_sneaker_gallery_03.setImageResource(sneaker.getAlbum()[2]);


		TextView tv_model = (TextView) view.findViewById(R.id.tv_model);
		tv_model.setText(sneaker.getModel());

		ImageView iv_brand = (ImageView) view.findViewById(R.id.iv_brand);
		// Set src Util.getImageSource( context, sneaker.brand.imageResource )
		iv_brand.setImageResource(sneaker.getBrand().getImageResource());

		// ImageView iv_genre_male
		ImageView iv_genre_male = (ImageView) view.findViewById(R.id.iv_genre_male);
		// sneaker.isForMale ? View.VISIBLE : View.GONE
		if (sneaker.isForMale()){
			iv_genre_male.setVisibility(View.VISIBLE);
		}else{
			iv_genre_male.setVisibility(View.GONE);
		}

		ImageView iv_genre_female = (ImageView) view.findViewById(R.id.iv_genre_female);
		// sneaker.isForMale ? View.VISIBLE : View.GONE
		if (sneaker.isForFemale()){
			iv_genre_female.setVisibility(View.VISIBLE);
		}else{
			iv_genre_female.setVisibility(View.GONE);
		}

		ImageView iv_rating_star_01 = (ImageView) view.findViewById(R.id.iv_rating_star_01);
		ImageView iv_rating_star_02 = (ImageView) view.findViewById(R.id.iv_rating_star_02);
		ImageView iv_rating_star_03 = (ImageView) view.findViewById(R.id.iv_rating_star_03);
		ImageView iv_rating_star_04 = (ImageView) view.findViewById(R.id.iv_rating_star_04);
		ImageView iv_rating_star_05 = (ImageView) view.findViewById(R.id.iv_rating_star_05);

		if (sneaker.getRating().getStars() >=  1){
			iv_rating_star_01.setImageResource(R.drawable.ic_star_black_18dp);
		}else{
			iv_rating_star_01.setImageResource(R.drawable.ic_star_border_white_18dp);
		}

		if (sneaker.getRating().getStars() >=  2){
			iv_rating_star_02.setImageResource(R.drawable.ic_star_black_18dp);
		}else{
			iv_rating_star_02.setImageResource(R.drawable.ic_star_border_white_18dp);
		}

		if (sneaker.getRating().getStars() >= 3){
			iv_rating_star_03.setImageResource(R.drawable.ic_star_black_18dp);
		}else{
			iv_rating_star_03.setImageResource(R.drawable.ic_star_border_white_18dp);
		}

		if (sneaker.getRating().getStars() >=  4){
			iv_rating_star_04.setImageResource(R.drawable.ic_star_black_18dp);
		}else{
			iv_rating_star_04.setImageResource(R.drawable.ic_star_border_white_18dp);
		}

		if (sneaker.getRating().getStars() >=  5){
			iv_rating_star_05.setImageResource(R.drawable.ic_star_black_18dp);
		}else{
			iv_rating_star_05.setImageResource(R.drawable.ic_star_border_white_18dp);
		}

		TextView tv_rating_amount = (TextView) view.findViewById(R.id.tv_rating_amount);
		tv_rating_amount.setText(String.format("%s", sneaker.getRating().getAmount()));

		//tv_price_parcels
		TextView tv_price_parcels = (TextView) view.findViewById(R.id.tv_price_parcels);
		tv_price_parcels.setText(sneaker.getPriceParcelsAsString());

		// tv_price
		TextView tv_price = (TextView) view.findViewById(R.id.tv_price);
		tv_price.setText(sneaker.getPriceAsString());

		// Retorna a View já adaptada para ser apresentada na ListView
		return view;
	}

	/**
	 * Retorna o ID de um determinado item da ListView, de acordo com a sua
	 * posição.
	 */
	@Override
	public long getItemId(int position) {
		return sneakers.get(position).getId();
	}

	/**
	 * Retorna o número de itens que serão mostrados na ListView.
	 */
	@Override
	public int getCount() {
		return super.getCount();
	}

	/**
	 * Retorna um determinado item da ListView, de acordo com a sua posição.
	 */
	@Override
	public Sneaker getItem(int position) {
		return sneakers.get(position);
	}

}
