package com.projeto.shopshoes.view.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.projeto.shopshoes.R;
import com.projeto.shopshoes.model.Sneaker;
import com.projeto.shopshoes.util.Constants;
import com.projeto.shopshoes.util.Util;

public class ThankYouActivity extends AppCompatActivity {

	private Sneaker sneaker = null;
	//Atributos
	private TextView tv_tracking_code;
	private TextView tv_model;
	private TextView tv_price;
	private ImageView iv_sneaker;
	private ImageView iv_brand;

	private Button bt_keep_buying;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Define o Layout Resource da Activity
		setContentView(R.layout.activity_thank_you);

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

		tv_tracking_code = (TextView) findViewById(R.id.tv_tracking_code);
		tv_model = (TextView) findViewById(R.id.tv_model);
		iv_sneaker = (ImageView) findViewById(R.id.iv_sneaker);
		iv_brand = (ImageView) findViewById(R.id.iv_brand);
		tv_price = (TextView) findViewById(R.id.tv_price);
		bt_keep_buying = (Button) findViewById(R.id.bt_keep_buying);
		bt_keep_buying.setOnClickListener(v -> finish());

		/**
		 * Recebe o objeto recebido como parâmetro da ListView para edição.
		 */
		sneaker = (Sneaker) getIntent().getSerializableExtra(Constants.ITEM_SELECTED);
		int AMOUNT_SNEAKERS = getIntent().getIntExtra(Constants.AMOUNT_SNEAKERS, 0);
		if (sneaker == null) {
			// Instancia um novo objeto do tipo Item
			sneaker = new Sneaker();
		} else {
			Log.i("Sneaker", sneaker.toString());
			tv_tracking_code.setText(String.format("%s %s", R.string.track_code_label, Util.codeBuyGenerator()));
			tv_model.setText(sneaker.getModel());
			// Set imageResource
			iv_sneaker.setImageResource(sneaker.getImageResource());
			iv_brand.setImageResource(sneaker.getBrand().getImageResource());
			tv_price.setText(String.format("%s %s", "R$", sneaker.getPrice() * AMOUNT_SNEAKERS));
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == android.R.id.home){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}


}
