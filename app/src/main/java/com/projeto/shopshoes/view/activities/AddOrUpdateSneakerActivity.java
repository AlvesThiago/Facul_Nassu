package com.projeto.shopshoes.view.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.projeto.shopshoes.model.Sneaker;
import com.projeto.shopshoes.R;
import com.projeto.shopshoes.util.Constants;

public class AddOrUpdateSneakerActivity extends AppCompatActivity {

	private Sneaker sneaker = null;
	//Atributos

	// Spinners
	private Spinner sp_cor;
	private Spinner sp_size;
	private Spinner sp_amount;

	// ImageViews
	private ImageView iv_brand;
	private ImageView iv_genre_male;
	private ImageView iv_genre_female;
	private ImageView iv_sneaker_01;
	private ImageView iv_sneaker_02;
	private ImageView iv_sneaker_03;
	private ImageView iv_sneaker_04;
	private ImageView iv_rating_star_01;
	private ImageView iv_rating_star_02;
	private ImageView iv_rating_star_03;
	private ImageView iv_rating_star_04;
	private ImageView iv_rating_star_05;

	// TextViews
	private TextView tv_price;
	private TextView tv_price_parcels;
	private TextView tv_amount;
	private TextView tv_recommended;
	private TextView tv_type;
	private TextView tv_composition;
	private TextView tv_desc;
	private TextView tv_rating_amount;


	private Button bt_buy;
	private Context mContext;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Define o Layout Resource da Activity
		setContentView(R.layout.activity_add_or_update_item);

		Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mToolbar.setNavigationIcon(R.mipmap.ic_menu_seta_esquerda_white);

		if (mToolbar != null) {
			setSupportActionBar(mToolbar);
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window w = getWindow();
			w.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
			w.setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
		}

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary, getTheme()));
		}else{
			//noinspection deprecation
			mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
		}

		mContext = this;
		// Carregar todos os spinners
		sp_size = (Spinner) findViewById(R.id.sp_size);
		sp_cor = (Spinner) findViewById(R.id.sp_cor);
		sp_amount = (Spinner) findViewById(R.id.sp_amount);

		// Carregar todos os ImageViews
		iv_brand = (ImageView) findViewById(R.id.iv_brand);
		iv_genre_male = (ImageView) findViewById(R.id.iv_genre_male);
		iv_genre_female = (ImageView) findViewById(R.id.iv_genre_female);
		iv_sneaker_01 = (ImageView) findViewById(R.id.iv_sneaker_01);
		iv_sneaker_02 = (ImageView) findViewById(R.id.iv_sneaker_02);
		iv_sneaker_03 = (ImageView) findViewById(R.id.iv_sneaker_03);
		iv_sneaker_04 = (ImageView) findViewById(R.id.iv_sneaker_04);
		iv_rating_star_01 = (ImageView) findViewById(R.id.iv_rating_star_01);
		iv_rating_star_02 = (ImageView) findViewById(R.id.iv_rating_star_02);
		iv_rating_star_03 = (ImageView) findViewById(R.id.iv_rating_star_03);
		iv_rating_star_04 = (ImageView) findViewById(R.id.iv_rating_star_04);
		iv_rating_star_05 = (ImageView) findViewById(R.id.iv_rating_star_05);

		// TextViews
		tv_price = (TextView) findViewById(R.id.tv_price);
		tv_price_parcels = (TextView) findViewById(R.id.tv_price_parcels);
		tv_amount = (TextView) findViewById(R.id.tv_amount);
		tv_recommended = (TextView) findViewById(R.id.tv_recommended);
		tv_type = (TextView) findViewById(R.id.tv_type);
		tv_composition = (TextView) findViewById(R.id.tv_composition);
		tv_desc = (TextView) findViewById(R.id.tv_desc);
		tv_rating_amount = (TextView) findViewById(R.id.tv_rating_amount);


		bt_buy = (Button) findViewById(R.id.bt_buy);

		/**
		 * Recebe o objeto recebido como parâmetro da ListView para edição.
		 */
		sneaker = (Sneaker) getIntent().getSerializableExtra(Constants.ITEM_SELECTED);

		if (sneaker == null) {
			// Instancia um novo objeto do tipo Item
			sneaker = new Sneaker();
		} else {
			iv_brand.setImageResource(sneaker.getBrand().getImageResource());


			if (sneaker.isForMale()){
				iv_genre_male.setVisibility(View.VISIBLE);
			}else{
				iv_genre_male.setVisibility(View.GONE);
			}

			if (sneaker.isForFemale()){
				iv_genre_female.setVisibility(View.VISIBLE);
			}else{
				iv_genre_female.setVisibility(View.GONE);
			}

			iv_sneaker_01.setImageResource(sneaker.getImageResource());
			iv_sneaker_02.setImageResource(sneaker.getAlbum()[0]);
			iv_sneaker_03.setImageResource(sneaker.getAlbum()[1]);
			iv_sneaker_04.setImageResource(sneaker.getAlbum()[2]);

			tv_price.setText(sneaker.getPriceAsString());
			tv_price_parcels.setText(sneaker.getPriceParcelsAsString());
			tv_amount.setText(sneaker.getExtraInfo().getStockFormatted( getApplicationContext() ));
			tv_recommended.setText(sneaker.getExtraInfo().getRecommended() );
			tv_type.setText(sneaker.getExtraInfo().getType());
			tv_composition.setText(sneaker.getExtraInfo().getComposition());
			tv_desc.setText(sneaker.getExtraInfo().getFullDescription());

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

			tv_rating_amount.setText(String.format("%d", sneaker.getRating().getAmount()) );
		}

		/**
		 * O botao salvar irá salvar o objeto no banco de dados.
		 */
		bt_buy.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Mensagem de confirmação no logcat
				Log.i(AddOrUpdateSneakerActivity.class.getName(), "Botão salvar clicado!");


				// Criar um Dialog para confirmar a ação com o layout dialog_payment.xml
				LayoutInflater inflater = getLayoutInflater();
				View dialogView = inflater.inflate(R.layout.dialog_payment, null);
				Button bt_finish_buy = (Button) dialogView.findViewById(R.id.bt_finish_buy);

				AlertDialog.Builder builder = new AlertDialog.Builder(AddOrUpdateSneakerActivity.this);
				builder.setView(dialogView);
				builder.setTitle("Pagamento");
				int amountSneakers = Integer.parseInt(sp_amount.getSelectedItem().toString());

				bt_finish_buy.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// Mensagem de confirmação no logcat
						Log.i(AddOrUpdateSneakerActivity.class.getName(), "Botão confirmar clicado!");
						// Fecha a Activity
						Intent i = new Intent(getApplicationContext(), ThankYouActivity.class);
						i.putExtra(Constants.ITEM_SELECTED, sneaker);
						// Pegar o valor do spinner sp_amount
						// Adicionar o campo amountSneakers
						i.putExtra(Constants.AMOUNT_SNEAKERS, amountSneakers);

						startActivityForResult(i, 0);
						builder.create().dismiss();
					}
				});
				builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// Mensagem de confirmação no logcat
						Log.i(AddOrUpdateSneakerActivity.class.getName(), "Botão confirmar clicado!");
						// Fecha a Activity
						Intent i = new Intent(getApplicationContext(), ThankYouActivity.class);
						i.putExtra(Constants.ITEM_SELECTED, sneaker);
						// Adicionar o campo amountSneakers
						i.putExtra(Constants.AMOUNT_SNEAKERS, amountSneakers);

						startActivityForResult(i, 0);
						dialog.cancel();
					}
				});
				builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// Mensagem de confirmação no logcat
						Log.i(AddOrUpdateSneakerActivity.class.getName(), "Botão cancelar clicado!");
						// Fecha o Dialog
						dialog.cancel();
					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();

			}

		});

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == android.R.id.home){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}


}
